package com.adan.asynctaskdome;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity implements View.OnClickListener {
    private Button button1, button2, button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initEvents();
    }

    private void initEvents() {
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
    }

    private void initViews() {
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                MyAsyncTask asyncTask=new MyAsyncTask();
                asyncTask.execute();
                break;
            case R.id.button2:
                startActivity(new Intent(MainActivity.this,LoadBitmapActivity.class));
                break;
            case R.id.button3:
                startActivity(new Intent(MainActivity.this,ShowProgressActivity.class));
                break;
        }
    }
}
