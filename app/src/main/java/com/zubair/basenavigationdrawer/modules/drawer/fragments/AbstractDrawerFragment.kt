package com.zubair.basenavigationdrawer.modules.drawer.fragments

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.zubair.basenavigationdrawer.R
import com.zubair.basenavigationdrawer.models.MenuAdapterBuilder
import com.zubair.basenavigationdrawer.models.MenuAdapterDto
import com.zubair.basenavigationdrawer.models.MenuDto
import com.zubair.basenavigationdrawer.modules.baseclasses.fragment.BaseFragment
import com.zubair.basenavigationdrawer.modules.drawer.adapters.MenuAdapter
import com.zubair.basenavigationdrawer.modules.drawer.interfaces.IOnClick
import com.zubair.basenavigationdrawer.modules.drawer.interfaces.IOnMenuCreated
import com.zubair.basenavigationdrawer.modules.drawer.interfaces.IOnMenuItemClicked
import kotlinx.android.synthetic.main.fragment_drawer_new.*

import java.util.ArrayList

abstract class AbstractDrawerFragment : BaseFragment(), IOnMenuItemClicked {

    private var adapter: MenuAdapter? = null
    private var menuListener: IOnMenuCreated? = null
    private var clickListener: IOnClick? = null

    //abstract method to accept item layout from client
    open fun getLayout(): MenuAdapterDto {
        return MenuAdapterBuilder()
                .setLayout(R.layout.item_menu)
                .setColumnCount(4)
                .create()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_drawer_new, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //setting adapter
        setAdapter(getLayout())

        //setting callback listener
        menuListener = this as IOnMenuCreated
        menuListener!!.onMenuCreated()

        //setting click listener
        clickListener = this as IOnClick

        //listeners
        btn_back.setOnClickListener {
            clickListener!!.onClick(it)
        }

        btn_logout.setOnClickListener {
            clickListener!!.onClick(it)
        }
    }

    override fun getExtras(extras: ArrayList<Any>) {

    }

    //Adapter Methods:------------------------------------------------------------------------------
    private fun setAdapter(menuAdapterDto: MenuAdapterDto) {
        adapter = MenuAdapter(activity!!, this, menuAdapterDto.layout)
        rvMenus.setLayoutManager(GridLayoutManager(activity, menuAdapterDto.columnCount))
        rvMenus.setAdapter(adapter)
    }

    fun addMenu(menu: MenuDto) {
        adapter!!.addMenu(menu)
    }

    fun updateMenu(menu: MenuDto) {
        adapter!!.updateMenu(menu)
    }

}
