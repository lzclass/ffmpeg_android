package com.example.lz.ffmpeg;

import android.content.Context;
import android.graphics.PixelFormat;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.SurfaceView;

public class MyVideoView extends SurfaceView {
    private FFmpegNativeUtil util;
    private Surface surface;
    public MyVideoView(Context context) {
        super(context);
    }

    public MyVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    private void init(){
        getHolder().setFormat(PixelFormat.RGBA_8888);
        surface = getHolder().getSurface();
        util = new FFmpegNativeUtil();
    }


}
