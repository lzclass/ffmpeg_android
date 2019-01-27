package com.example.lz.ffmpeg;

import android.view.Surface;

public class FFmpegNativeUtil {

        static {
            System.loadLibrary("avcodec-57");
            System.loadLibrary("avdevice-57");
            System.loadLibrary("avfilter-6");
            System.loadLibrary("avformat-57");
            System.loadLibrary("avutil-55");
            System.loadLibrary("postproc-54");
            System.loadLibrary("swresample-2");
            System.loadLibrary("swscale-4");
        }
        /**
         * javah -classpath E:\Android\Sdk\platforms\android-28\android.jar;. main.java.com.example.lz.ffmpeg.FFmpegNativeUtil
         * 播放视频流
         * @param videoPath（本地）视频文件路径
         * @param surface
         */
        public native void videoStreamPlay(String videoPath, Surface surface);


}
