package com.look.world.view.ActionBar;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.look.world.R;

/**
 * @author wy
 * @version V1.0
 * @Title: ForwardItemView.java
 * @Package com.melink.android.ui.widget
 * @Description: TODO
 * @date 2015-5-13 下午8:20:24
 */
public class ActionBarCommon extends RelativeLayout implements View.OnClickListener {

    private View viewBg;
    private RelativeLayout layout_exit;
    private TextView tvBack;
    private TextView tvTitle, tvEdit;
    private String strTitle = "";

    public ActionBarCommon(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView(context, attrs);
    }

    public ActionBarCommon(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    public ActionBarCommon(Context context) {
        super(context);
        initView(context, null);
    }

    private void initView(Context context, AttributeSet attrs) {
        TypedArray a = null;
        if (attrs != null) {
            a = context.obtainStyledAttributes(attrs, R.styleable.ActionBarCommon);
            strTitle = a.getString(R.styleable.ActionBarCommon_title_name);
            Log.e("ActionBarCommon", "title = " + strTitle);
        }
        View rootLayout = LayoutInflater.from(context).inflate(R.layout.actionbar_common, this);
        viewBg = (View) findViewById(R.id.view_bg);
        layout_exit = (RelativeLayout) findViewById(R.id.layout_exit);
        tvBack = (TextView) findViewById(R.id.actionbar_back);
        tvTitle = (TextView) findViewById(R.id.actionbar_title);
        tvEdit = (TextView) findViewById(R.id.actionbar_edit);
        layout_exit.setOnClickListener(this);
        tvEdit.setOnClickListener(this);
        if (getContext().getClass().getSimpleName().equals("MainTabActivity"))
            layout_exit.setVisibility(View.INVISIBLE);
        else
            layout_exit.setVisibility(View.VISIBLE);
        if (!TextUtils.isEmpty(strTitle))
            tvTitle.setText(strTitle);
        if (a != null)
            a.recycle();
    }

    public ActionBarCommon setTvTitle(String title) {
        this.tvTitle.setText(title);
        return this;
    }

    public ActionBarCommon setTvEdit(String edit) {
        this.tvEdit.setText(edit);
        return this;
    }

    public ActionBarCommon setIvBackVisible(int visible) {
        this.tvBack.setVisibility(visible);
        return this;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layout_exit:
                ((Activity) getContext()).finish();
                break;
            case R.id.actionbar_edit:
                if (listener != null)
                    listener.submit();
                break;
        }
    }

    private EventActionbarListener listener;

    public void setOnEventActionbarListener(EventActionbarListener listener) {
        this.listener = listener;
    }

    public interface EventActionbarListener {
        public void back();

        public void submit();
    }
}
