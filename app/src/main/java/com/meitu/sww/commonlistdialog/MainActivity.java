package com.meitu.sww.commonlistdialog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.meitu.sww.commonlistdialog.common.FeedbackDialog;
import com.meitu.sww.commonlistdialog.common.FeedbackAdapter;
import com.meitu.sww.commonlistdialog.common.model.FeedbackItemModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<FeedbackItemModel> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i = 0; i < 3; i++) {
            list.add(new FeedbackItemModel(0, "点击事件" + i, (42000 + i)));
        }
        list.add(new FeedbackItemModel(1, "为什么看到了这个事件", (42000 + 3)));
    }

    public void showDialog(View view) {
        FeedbackDialog feedbackDialog = new FeedbackDialog.Builder(MainActivity.this)
                .setCancelable(true)
                .setItems(list, new FeedbackAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(FeedbackItemModel feedbackContentModel) {
                        Toast.makeText(MainActivity.this, "" + feedbackContentModel.getTitle(), Toast.LENGTH_SHORT).show();
                    }
                })
                .create();
        feedbackDialog.show();
    }

}
