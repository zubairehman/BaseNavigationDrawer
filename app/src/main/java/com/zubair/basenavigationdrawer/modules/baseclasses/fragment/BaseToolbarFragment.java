package com.zubair.basenavigationdrawer.modules.baseclasses.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.zubair.basenavigationdrawer.modules.baseclasses.ToolbarUtil;
import com.zubair.basenavigationdrawer.modules.baseclasses.activity.BaseActivity;


public abstract class BaseToolbarFragment extends BaseFragment {

    private ToolbarUtil toolbarUtil;
    private boolean showToolbar = true;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (toolbarUtil == null) toolbarUtil = new ToolbarUtil((BaseActivity) getActivity());
    }

    @Override
    public void onResume() {
        super.onResume();
        if (toolbarUtil == null) toolbarUtil = new ToolbarUtil((BaseActivity) getActivity());
        toolbarUtil.refresh();
        toolbarUtil.setTitle(getTitle());
        if (showToolbar) {
            toolbarUtil.show();
        } else {
            toolbarUtil.hide();
        }
    }

    public abstract String getTitle();

    public void showToolbar() {
        showToolbar = true;
        toolbarUtil.show();
    }

    public void hideToolbar() {
        showToolbar = false;
        toolbarUtil.hide();
    }

    public TextView addMenuItemString(String title, View.OnClickListener onClickListener) {
        return toolbarUtil.addMenuItemString(title, onClickListener);
    }

    public ImageView addMenuItemImage(int imgRes, View.OnClickListener onClickListener) {
        return toolbarUtil.addMenuItemImage(imgRes, onClickListener);
    }

    public ProgressBar addMenuItemProgress() {
        return toolbarUtil.addMenuItemProgress();
    }

    public ToolbarUtil getToolbarUtil() {
        return toolbarUtil;
    }

}
