package com.sww.commontipdialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        MtbCommonTipDialog mtbCommonTipDialog = new MtbCommonTipDialog.Builder(MainActivity.this)
                .setTitle("标题")
                .setMessage("激励视频不观看一定时长，无法获得奖励")
                .setCancelable(true)
                .setNegativeButton("取消",new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {

                    }
                })
                .setPositiveButton("确定", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                })
                .create();
        mtbCommonTipDialog.show();
    }
}
