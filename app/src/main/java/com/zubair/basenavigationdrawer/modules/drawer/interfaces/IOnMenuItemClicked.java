package com.zubair.basenavigationdrawer.modules.drawer.interfaces;

import com.zubair.basenavigationdrawer.models.MenuDto;

import java.util.List;

public interface IOnMenuItemClicked {
    void onItemClick(List<MenuDto> items, int position);
}
