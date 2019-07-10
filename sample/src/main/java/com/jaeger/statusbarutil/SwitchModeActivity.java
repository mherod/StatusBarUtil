package com.jaeger.statusbarutil;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.widget.Toolbar;

import com.jaeger.library.StatusBarUtil;
import com.jaeger.statusbardemo.R;

/**
 * Created by jaeger on 08/03/2018.
 *
 * Email: chjie.jaeger@gmail.com
 * GitHub: https://github.com/laobie
 */

public class SwitchModeActivity extends BaseActivity {
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch_mode);

        mToolbar = findViewById(R.id.toolbar);
        Button mBtnSetLightMode = findViewById(R.id.btn_set_light_mode);
        Button mBtnSetDarkMode = findViewById(R.id.btn_set_dark_mode);

        // 设置toolbar
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        mBtnSetLightMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = getResources().getColor(R.color.light_gray);
                StatusBarUtil.setColor(SwitchModeActivity.this, color, 30);
                mToolbar.setBackgroundColor(color);
                StatusBarUtil.setLightMode(SwitchModeActivity.this);
            }
        });

        mBtnSetDarkMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = getResources().getColor(R.color.colorPrimary);
                StatusBarUtil.setColor(SwitchModeActivity.this, color);
                mToolbar.setBackgroundColor(color);
                StatusBarUtil.setDarkMode(SwitchModeActivity.this);
            }
        });
    }

    @Override
    protected void setStatusBar() {
        StatusBarUtil.setColor(this, getResources().getColor(R.color.colorPrimary));
    }
}
