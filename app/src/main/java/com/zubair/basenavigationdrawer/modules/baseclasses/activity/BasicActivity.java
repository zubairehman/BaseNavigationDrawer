package com.zubair.basenavigationdrawer.modules.baseclasses.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public abstract class BasicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //this line is to lock screen orientation
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            getExtras((ArrayList<Object>) extras.getSerializable("extras"));
        }
    }

    public abstract void getExtras(ArrayList<Object> extras);

}
