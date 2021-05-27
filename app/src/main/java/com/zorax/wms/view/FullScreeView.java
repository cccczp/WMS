package com.zorax.wms.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

/**
 * @创作者 czp
 * @创作时间 2021/5/27 10:24
 * @描述
 */
public class FullScreeView  extends VideoView {
    public FullScreeView(Context context) {
        super(context);
    }

    public FullScreeView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FullScreeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            int width = getDefaultSize(0,widthMeasureSpec);
            int height = getDefaultSize(0,heightMeasureSpec);
            setMeasuredDimension(width,height);
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
