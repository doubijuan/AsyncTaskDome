package com.adan.asynctaskdome;

import android.os.AsyncTask;
import android.util.Log;

/**
 * @author: xiaolijuan
 * @description:
 * @projectName: AsyncTaskDome
 * @date: 2016-03-04
 * @time: 12:47
 */
public class MyAsyncTask extends AsyncTask<Void, Void, Void> {
    @Override
    protected Void doInBackground(Void... params) {
        Log.d("TAG", "doInBackground");
        publishProgress();
        return null;
    }

    @Override
    protected void onPreExecute() {
        Log.d("TAG", "onPreExecute");
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        Log.d("TAG", "onPostExecute");
        super.onPostExecute(aVoid);
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        Log.d("TAG", "onProgressUpdate");
        super.onProgressUpdate(values);
    }
}
