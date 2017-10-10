package com.look.world.view;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.look.world.R;


/**
 * Created by wei.kong
 */
public class MyProgressDialog extends Dialog {
    public MyProgressDialog(Context context) {
        super(context, R.style.Dialog_loading_noDim);
        init();
    }

    private void init() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_network_loading, null);
        view.setBackgroundResource(android.R.color.transparent);
        setContentView(view);
    }

    public void setInVisible(boolean flag) {
        this.setCanceledOnTouchOutside(flag);
    }
}
