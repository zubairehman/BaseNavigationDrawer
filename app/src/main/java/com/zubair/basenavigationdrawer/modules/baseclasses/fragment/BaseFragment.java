package com.zubair.basenavigationdrawer.modules.baseclasses.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.zubair.basenavigationdrawer.utils.WaitDialog;

import java.util.ArrayList;

public abstract class BaseFragment extends Fragment {

    private WaitDialog waitDialog;
    private boolean isActive;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = getArguments();
        if (extras != null) {
            getExtras((ArrayList<Object>) extras.getSerializable("extras"));
        }
        if (waitDialog == null) waitDialog = new WaitDialog(getContext());
    }

    @Override
    public void onResume() {
        super.onResume();
        if (waitDialog == null) waitDialog = new WaitDialog(getContext());
        isActive = true;
    }

    @Override
    public void onPause() {
        isActive = false;
        super.onPause();
    }

    public abstract void getExtras(ArrayList<Object> extras);

    public BaseFragment addExtras(ArrayList<Object> extras) {
        if (extras != null) {
            Bundle args = new Bundle();
            args.putSerializable("extras", extras);
            this.setArguments(args);
        }
        return this;
    }

    public void showWaitDialog() {
        waitDialog.showWaitDialog();
    }

    public void dismissWaitDialog() {
        try {
            if (waitDialog.isStillActive()) {
                waitDialog.dismissWaitDialog();
            }
        } catch (Exception e) {
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public boolean isThisFragmentActive() {
        return isActive;
    }

}
