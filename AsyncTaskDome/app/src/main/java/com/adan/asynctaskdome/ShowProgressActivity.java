package com.adan.asynctaskdome;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ProgressBar;

/**
 * @author: xiaolijuan
 * @description:
 * @projectName: AsyncTaskDome
 * @date: 2016-03-04
 * @time: 13:12
 */
public class ShowProgressActivity extends Activity {
    private ProgressBar progressBar;
    private MyAsyncTask mTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_progress);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        mTask = new MyAsyncTask();
        mTask.execute();
    }

    //当跳到另外一个活动的时候调用该方法
    @Override
    protected void onPause() {
        //如果mTask不为空，且正在运行
        if (mTask != null && mTask.getStatus() == AsyncTask.Status.RUNNING) {
            mTask.cancel(true);//取消该任务
        }
        super.onPause();
    }

    class MyAsyncTask extends AsyncTask<Void, Integer, Void> {

        protected Void doInBackground(Void... params) {
            for (int i = 0; i < 50; i++) {
                if (isCancelled()) {//如果为取消状态，立刻break，跳出循环
                    break;
                }
                publishProgress(i);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        //根据任务执行情况更新UI，其实就是更新进度条
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0]);
        }

    }
}
