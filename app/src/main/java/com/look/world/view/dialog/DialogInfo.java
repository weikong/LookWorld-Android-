package com.look.world.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;

import com.look.world.R;

/**
 * @author YoYo-SHUN
 * @ClassName: DialogAlertInput
 * @Description: Information dialog
 * @Copyright InventoryLab RJC LLC.  All Rights Reserved.
 * @date 2014-7-26 PM 11:43:43
 */
public class DialogInfo extends Dialog {

    private TextView txtTitle;
    private TextView txtDone;
    private TextView txtCancle;

    private OnEventListener mOnEventListener;

    public DialogInfo(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        initViews();
    }

    public DialogInfo(Context context, int theme) {
        super(context, theme);
        initViews();
    }

    public DialogInfo(Context context) {
        this(context, R.style.DialogFullScreen);
    }

    private void initViews() {
        setContentView(R.layout.dialog_info);
        getWindow().setLayout(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        getWindow().setGravity(Gravity.CENTER);
        getWindow().setBackgroundDrawable(new ColorDrawable(0x44000000));
//        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
//        lp.setMargins(UITools.dp2px(40), UITools.dp2px(200), UITools.dp2px(40), 0);
        View root = findViewById(R.id.dialog_root);
//        root.setLayoutParams(lp);

        txtTitle = (TextView) findViewById(R.id.dialog_desc);
        txtDone = (TextView) findViewById(R.id.dialog_done);
        txtCancle = (TextView) findViewById(R.id.dialog_cancel);

        txtCancle.setOnClickListener(mClickListener);
        txtDone.setOnClickListener(mClickListener);
    }

    /**
     * @param desc Prompt message
     */
    public void setData(String desc) {
        txtTitle.setText(desc);
    }

    public void setDoneText(String s) {
        txtDone.setText(s);
    }

    public void setCancleText(String s) {
        txtCancle.setText(s);
    }

    public void setDoneTextColor(int color) {
        txtDone.setTextColor(color);
    }

    public void setCancleTextColor(int color) {
        txtCancle.setTextColor(color);
    }

    public void setOnEventListener(OnEventListener l) {
        this.mOnEventListener = l;
    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void cancel() {
        super.cancel();
        if (mOnEventListener != null)
            mOnEventListener.result(false);
    }

    @Override
    public void dismiss() {
        super.dismiss();
    }

    private View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.dialog_cancel:
                    cancel();
                    break;
                case R.id.dialog_done:
                    dismiss();
                    if (mOnEventListener != null)
                        mOnEventListener.result(true);
                    break;
            }
        }
    };

    public interface OnEventListener {

        /**
         * @param sure Are you sure
         */
        void result(boolean sure);
    }

}
