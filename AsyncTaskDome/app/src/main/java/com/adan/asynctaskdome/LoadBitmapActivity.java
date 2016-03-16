package com.adan.asynctaskdome;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author: xiaolijuan
 * @description:
 * @projectName: AsyncTaskDome
 * @date: 2016-03-04
 * @time: 13:12
 */
public class LoadBitmapActivity extends Activity {
    private ImageView img;
    private ProgressBar progressBar;
    private Bitmap bmp;
    private static final String myUrl = "https://www.baidu.com/img/bd_logo1.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_bitmap);

        img = (ImageView) findViewById(R.id.img_url);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);
        MyAsyncTask mTask = new MyAsyncTask();
        mTask.execute(myUrl);
    }

    class MyAsyncTask extends AsyncTask<String, Void, Bitmap> {
        protected Bitmap doInBackground(String... params) {
            String myUrl = params[0];
            HttpURLConnection connection = null;
            try {
                URL url = new URL(myUrl);//将字符串转化为网址对象
                connection = (HttpURLConnection) url.openConnection();//创建网络接口
                connection.setRequestMethod("GET");
                connection.setConnectTimeout(8000);
                connection.setReadTimeout(8000);
                InputStream in = connection.getInputStream();//获取返回的数据流
                bmp = BitmapFactory.decodeStream(in);//获取图片
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return bmp;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //显示进度条
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            try {
                Thread.sleep(3000);//为了观看效果，休眠5秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //关闭进度条和更新UI
            progressBar.setVisibility(View.GONE);
            img.setImageBitmap(bmp);
            super.onPostExecute(result);
        }
    }
}
