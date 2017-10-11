package com.look.world.activity.base;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;

import com.look.world.App;
import com.look.world.config.Config;
import com.look.world.view.MyProgressDialog;

public class AbsBaseActivity extends FragmentActivity {

    protected final String TAG = this.getClass().getSimpleName();
    protected MyProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.appActivity = this;
        App.appContext = this;
    }

    protected void intentToActivity(Class<?> c) {
        Intent intent = new Intent();
        intent.setClass(this, c);
        startActivity(intent);
    }

    protected void intentToActivity(Class<?> c, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(this, c);
        intent.putExtra("DATA", bundle);
        startActivity(intent);
    }

    protected void intentToActivityForResult(Class<?> c, int requestCode) {
        Intent intent = new Intent();
        intent.setClass(this, c);
        startActivityForResult(intent, requestCode);
    }

    protected void intentToActivityForResult(Class<?> c, Bundle bundle, int requestCode) {
        Intent intent = new Intent();
        intent.putExtra("DATA", bundle);
        intent.setClass(this, c);
        startActivityForResult(intent, requestCode);
    }

    @Override
    protected void onDestroy() {
        dismissProgressDialog();
        super.onDestroy();
    }

    public void hideSoftInput(View view) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            view.clearFocus();
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    protected void toggleSoftInput() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    protected void showProgressBar() {
        if (progressDialog == null) {
            progressDialog = new MyProgressDialog(this);
        }
//        progressDialog.setMessage("");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            progressDialog.create();
        }
        progressDialog.show();
//        progressDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
//            @Override
//            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
//                if (keyCode == KeyEvent.KEYCODE_BACK) {
//                    try {
//                        dismissProgressDialog();
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//                return false;
//            }
//        });
    }

    protected void dismissProgressDialog() {
        if (progressDialog != null) {
            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
            progressDialog = null;
        }
    }

    public void callService() {
        try {
            Intent intent = new Intent();
            //Data的字符串格式为：tel://10086
            intent.setData(Uri.parse("tel://" + Config.CallNumber));
            intent.setAction(Intent.ACTION_CALL);
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isListViewReachBottomEdge(final AbsListView listView) {
        boolean result = false;
        if (listView.getLastVisiblePosition() == (listView.getCount() - 1)) {
            final View bottomChildView = listView.getChildAt(listView.getLastVisiblePosition() - listView.getFirstVisiblePosition());
            result = (listView.getHeight() >= bottomChildView.getTop());
        }
        return result;
    }
}
