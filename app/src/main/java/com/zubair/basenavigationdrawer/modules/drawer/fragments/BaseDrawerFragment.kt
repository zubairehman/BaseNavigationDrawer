package com.zubair.basenavigationdrawer.modules.drawer.fragments

import com.zubair.basenavigationdrawer.R
import com.zubair.basenavigationdrawer.models.MenuAdapterDto
import com.zubair.basenavigationdrawer.models.MenuBuilder
import com.zubair.basenavigationdrawer.models.MenuDto
import com.zubair.basenavigationdrawer.modules.drawer.interfaces.IOnMenuCreated


open class BaseDrawerFragment : AbstractDrawerFragment(), IOnMenuCreated {

    override fun onMenuCreated() {
        for (i in 0..4) {
            val menuDto = MenuBuilder()
                    .setName("Base MenuItem" + 1)
                    .setImageRes(R.drawable.ic_launcher_foreground)
                    .setIsActive(true)
                    .create()
            addMenu(menuDto)
        }
    }

    override fun onItemClick(items: List<MenuDto>, position: Int) {

    }

}
