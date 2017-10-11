package com.look.world.activity;

import android.os.Bundle;

import com.look.world.R;
import com.look.world.activity.base.AbsBaseActivity;

public class MainActivity extends AbsBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
