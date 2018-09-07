package com.zubair.basenavigationdrawer.modules.drawer.fragments

import com.zubair.basenavigationdrawer.R
import com.zubair.basenavigationdrawer.models.MenuAdapterBuilder
import com.zubair.basenavigationdrawer.models.MenuAdapterDto
import com.zubair.basenavigationdrawer.models.MenuBuilder
import com.zubair.basenavigationdrawer.models.MenuDto
import com.zubair.basenavigationdrawer.modules.baseclasses.activity.BaseActivityDrawer
import com.zubair.basenavigationdrawer.modules.drawer.interfaces.IOnMenuCreated

class DrawerFragment : BaseDrawerFragment(), IOnMenuCreated {

    private var items: List<MenuDto>? = null

    override fun getLayout(): MenuAdapterDto {
        return MenuAdapterBuilder()
                .setLayout(R.layout.item_menu_new)
                .setColumnCount(4)
                .create()
    }

    override fun onMenuCreated() {
        super.onMenuCreated()

        //create menu
        val menuDto = MenuBuilder()
                .setName("Child MenuItem")
                .setImageRes(R.drawable.ic_launcher_foreground)
                .setIsActive(true)
                .setIsCounterVisible(true)
                .setCounterValue(4)
                .create()

        addMenu(menuDto)
    }

    override fun onItemClick(items: List<MenuDto>, position: Int) {
        super.onItemClick(items, position)
        this.items = items
        (activity as BaseActivityDrawer).closeDrawer()

        //update menu
        updateMenu(position)
    }

    fun updateMenu(position: Int) {
        //in-order to update menu item
        val menuDto = items!!.get(position)
        menuDto.counterValue = 10
        menuDto.isCounterVisible = true
        updateMenu(menuDto)
    }
}
