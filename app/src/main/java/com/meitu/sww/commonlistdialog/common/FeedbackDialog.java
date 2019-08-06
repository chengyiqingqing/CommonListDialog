package com.meitu.sww.commonlistdialog.common;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.meitu.sww.commonlistdialog.R;
import com.meitu.sww.commonlistdialog.common.model.FeedbackItemModel;

import java.util.List;

/**
 * 公用列表操作弹框
 * @author ShaoWenWen
 * @date 2019-07-08
 */
public class FeedbackDialog extends Dialog {

    private RecyclerView recyclerView;
    private FeedbackAdapter recyclerAdapter;

    private FeedbackDialog(Context context) {
        super(context);
        setViewDialogParams();
        setContentView(R.layout.mtb_dialog_common_list);
        initView();
    }

    private void setViewDialogParams() {
        Window window = getWindow();
        if (window == null) return;
        WindowManager.LayoutParams params = window.getAttributes();
        params.width = dip2px(getContext(), 346);
        params.gravity = Gravity.CENTER;
        window.setAttributes(params);
        window.requestFeature(Window.FEATURE_NO_TITLE);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }

    private void initView() {
        recyclerView = findViewById(R.id.recycler_list);
    }

    private void setItems(List<FeedbackItemModel> list, final FeedbackAdapter.OnItemClickListener listener) {
        if (recyclerAdapter == null) {
            recyclerAdapter = new FeedbackAdapter(list);
            recyclerAdapter.setOnItemClickListener(new FeedbackAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(FeedbackItemModel feedbackItemModel) {
                    dismiss();
                    listener.onItemClick(feedbackItemModel);
                }
            });
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.setAdapter(recyclerAdapter);
            ViewUtil.addCorner(recyclerView, dip2px(getContext(), 4), getContext().getResources().getColor(R.color.colorWhite),
                    0, 0);
        }
    }

    @Override
    public void dismiss() {
        if (ContextUtils.isActivityValid(getContext()) && isShowing()) super.dismiss();
    }

    public static int dip2px(Context context, float dipValue) {
        DisplayMetrics dm = context.getApplicationContext().getResources().getDisplayMetrics();
        return (int) (dipValue * dm.density + 0.5f);
    }

    @SuppressWarnings("unused")
    public static class Builder {

        private final Context context;
        private boolean cancelable = true;
        private List<FeedbackItemModel> itemList;
        private FeedbackAdapter.OnItemClickListener listener;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setCancelable(boolean cancelable) {
            this.cancelable = cancelable;
            return this;
        }

        public Builder setItems(List<FeedbackItemModel> items, final FeedbackAdapter.OnItemClickListener listener) {
            this.itemList = items;
            this.listener = listener;
            return this;
        }

        public FeedbackDialog create() {
            FeedbackDialog dialog = new FeedbackDialog(context);
            dialog.setCancelable(cancelable);
            dialog.setCanceledOnTouchOutside(cancelable);
            dialog.setItems(itemList, listener);
            return dialog;
        }
    }

}
