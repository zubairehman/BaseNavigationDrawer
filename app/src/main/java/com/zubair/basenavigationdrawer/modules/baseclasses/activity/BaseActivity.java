package com.zubair.basenavigationdrawer.modules.baseclasses.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.zubair.basenavigationdrawer.R;
import com.zubair.basenavigationdrawer.modules.baseclasses.fragment.FragmentUtil;


public abstract class BaseActivity extends BasicActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_activity_toolbar);
        new FragmentUtil(this).replaceBaseFragment(getBaseFragment());
    }

    public abstract Fragment getBaseFragment();

}
