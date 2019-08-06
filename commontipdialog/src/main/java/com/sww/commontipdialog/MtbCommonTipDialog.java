package com.sww.commontipdialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * 通用提示弹窗
 * @author ShaoWenWen
 * @date 2019-08-06
 */
public class MtbCommonTipDialog extends Dialog {

    private View layoutContent;
    private TextView textTitle;
    private TextView textMessage;
    private TextView textOk;
    private TextView textCancel;
    private View textButtonLine;

    public MtbCommonTipDialog(@NonNull Context context) {
        super(context);
        setViewDialogParams();
        setContentView(R.layout.mtb_dialog_common_tip);
        initView();
    }

    private void setViewDialogParams() {
        Window window = getWindow();
        if (window == null) return;
        WindowManager.LayoutParams params = window.getAttributes();
        params.gravity = Gravity.CENTER;
        window.setAttributes(params);
        window.requestFeature(Window.FEATURE_NO_TITLE);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }

    private void initView() {
        layoutContent = findViewById(R.id.layout_content);
        textTitle = findViewById(R.id.text_title);
        textMessage = findViewById(R.id.text_message);
        textOk = findViewById(R.id.text_ok);
        textCancel = findViewById(R.id.text_cancel);
        textButtonLine = findViewById(R.id.view_button_line);
    }

    @Override
    public void setTitle(CharSequence title) {
        if (TextUtils.isEmpty(title)) {
            textTitle.setVisibility(View.GONE);
            textMessage.setTextSize(15);
            textMessage.setTextColor(getContext().getResources().getColor(R.color.mtb_color_1D212C));
            layoutContent.setLayoutParams(new FrameLayout.LayoutParams(DeviceUtils.dip2px(getContext(),270),
                    ViewGroup.LayoutParams.WRAP_CONTENT));
        } else {
            textTitle.setText(title);
            textTitle.setVisibility(View.VISIBLE);
            textMessage.setTextSize(14);
            textMessage.setTextColor(getContext().getResources().getColor(R.color.mtb_color_4A4D56));
            layoutContent.setLayoutParams(new FrameLayout.LayoutParams(DeviceUtils.dip2px(getContext(),280),
                    ViewGroup.LayoutParams.WRAP_CONTENT));
        }
    }

    private void setMessage(CharSequence message) {
        textMessage.setText(message);
        textMessage.setVisibility(View.VISIBLE);
    }

    private void setPositiveButton(CharSequence positiveButtonText, final View.OnClickListener positiveButtonListener) {
        textOk.setText(positiveButtonText);
        textOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (positiveButtonListener != null) positiveButtonListener.onClick(v);
                dismiss();
            }
        });
    }

    private void setNegativeButton(CharSequence negativeButtonText, final View.OnClickListener negativeButtonListener) {
        if (TextUtils.isEmpty(negativeButtonText)) {
            textCancel.setVisibility(View.GONE);
            textButtonLine.setVisibility(View.GONE);
        } else {
            textCancel.setText(negativeButtonText);
            textCancel.setVisibility(View.VISIBLE);
            textButtonLine.setVisibility(View.VISIBLE);
            textCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (negativeButtonListener != null) negativeButtonListener.onClick(v);
                    dismiss();
                }
            });
        }
    }

    public static class Builder {

        private final Context context;
        private CharSequence title;
        private CharSequence message;
        private CharSequence positiveButtonText;
        private View.OnClickListener positiveButtonListener;
        private CharSequence negativeButtonText;
        private View.OnClickListener negativeButtonListener;
        private boolean cancelable = true;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setTitle(@StringRes int titleId) {
            this.title = context.getText(titleId);
            return this;
        }

        public Builder setTitle(CharSequence title) {
            this.title = title;
            return this;
        }

        public Builder setMessage(@StringRes int messageId) {
            this.message = context.getText(messageId);
            return this;
        }

        public Builder setMessage(CharSequence message) {
            this.message = message;
            return this;
        }

        public Builder setPositiveButton(@StringRes int textId, final View.OnClickListener listener) {
            this.positiveButtonText = context.getText(textId);
            this.positiveButtonListener = listener;
            return this;
        }

        public Builder setPositiveButton(CharSequence text, final View.OnClickListener listener) {
            this.positiveButtonText = text;
            this.positiveButtonListener = listener;
            return this;
        }

        public Builder setNegativeButton(@StringRes int textId, final View.OnClickListener listener) {
            this.negativeButtonText = context.getText(textId);
            this.negativeButtonListener = listener;
            return this;
        }

        public Builder setNegativeButton(CharSequence text, final View.OnClickListener listener) {
            this.negativeButtonText = text;
            this.negativeButtonListener = listener;
            return this;
        }

        public Builder setCancelable(boolean cancelable) {
            this.cancelable = cancelable;
            return this;
        }

        public MtbCommonTipDialog create() {
            MtbCommonTipDialog dialog = new MtbCommonTipDialog(context);
            dialog.setTitle(title);
            dialog.setMessage(message);
            dialog.setPositiveButton(positiveButtonText, positiveButtonListener);
            dialog.setNegativeButton(negativeButtonText, negativeButtonListener);
            dialog.setCancelable(cancelable);
            return dialog;
        }
    }

}
