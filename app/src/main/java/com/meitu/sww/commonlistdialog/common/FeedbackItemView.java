package com.meitu.sww.commonlistdialog.common;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.meitu.sww.commonlistdialog.R;
import com.meitu.sww.commonlistdialog.common.model.FeedbackItemModel;

/**
 * 负反馈弹窗列表item展示类
 * @author ShaoWenWen
 * @date 2019-07-08
 */
public class FeedbackItemView extends RelativeLayout {

    private TextView textTitle; // 选型名称；
    private ImageView imageIcon; // 选项图标

    public FeedbackItemView(@NonNull Context context) {
        this(context, null);
    }

    public FeedbackItemView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context) {
        inflate(context, R.layout.mtb_dialog_common_list_item_view, this);
        textTitle = findViewById(R.id.text_name);
        imageIcon = findViewById(R.id.image_icon);
    }

    public void updateViewByData(FeedbackItemModel feedbackItemModel) {
        if (feedbackItemModel == null) return;
        textTitle.setText(feedbackItemModel.getTitle());
        imageIcon.setImageResource(feedbackItemModel.getActionType() == 0 ? R.mipmap.mtb_feed_back_item_close_icon
                : R.mipmap.mtb_feed_back_why_watch_this_icon);
    }

}
