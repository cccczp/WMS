package com.zorax.wms.timer;


import android.os.Handler;

/**
 * @创作者 czp
 * @创作时间 2021/5/27 14:03
 * @描述
 */
public class CustomerCountDownTimer implements  Runnable{
    private int time;
    private ICountDownTimer iCountDownTimer;
    private final Handler mHandler;
    private boolean isRun;
    private int countDownTime;

    public CustomerCountDownTimer(int time,ICountDownTimer iCountDownTimer)
    {
        mHandler = new android.os.Handler();
        this.time = time;
        this.countDownTime = time;
        this.iCountDownTimer = iCountDownTimer;
    }

    @Override
    public void run() {
        if (isRun){
            if (iCountDownTimer != null)
            {
                iCountDownTimer.onTicker(time);
            }

            if (countDownTime == 0)
            {
                cancel();
                if (iCountDownTimer != null)
                {
                    iCountDownTimer.onFinish();
                }
            }
            else
            {
                countDownTime = time--;
                mHandler.postDelayed(this,1000);
            }
        }
    }

    public void start(){
        isRun = true;
        mHandler.post(this);
    }

    public void cancel(){
        isRun = false;
        mHandler.removeCallbacks(this);
    }

    public interface ICountDownTimer {
        void onTicker(int time);

        void onFinish();
    }
}


