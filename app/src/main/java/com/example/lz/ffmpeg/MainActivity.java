package com.example.lz.ffmpeg;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity {
    MyVideoView my_video;
    TextView sample_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sample_text = findViewById(R.id.sample_text);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    100);
        }
        ffmpegTest();
    }

    private static Handler handler = new Handler();

    private void ffmpegTest() {
        new Thread() {
            @Override
            public void run() {
                long startTime = System.currentTimeMillis();
                String input = Environment.getExternalStorageDirectory().getPath() + "/DCIM/Video/V80930-085944.mp4";
                String output = Environment.getExternalStorageDirectory().getPath() + "/DCIM/Video/a_output.mp4";
                //剪切视频从00：10-00：28的片段
                String cmd = "ffmpeg -d -ss 00:00:10 -t 00:00:28 -i %s -vcodec copy -acodec copy %s";
                cmd = String.format(cmd, input, output);
                FFmpegNativeUtil.run(cmd.split(" "));
                final String logString = "FFmpegTest_run: 耗时：" + (System.currentTimeMillis() - startTime);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        sample_text.setText(logString);
                    }
                });
                Log.d("FFmpegTest", "run: 耗时：" + (System.currentTimeMillis() - startTime));
            }
        }.start();

    }

    public native String stringFromJNI();
}
