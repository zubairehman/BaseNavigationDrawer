package com.zubair.basenavigationdrawer.modules

import android.support.v4.app.Fragment
import com.zubair.basenavigationdrawer.modules.baseclasses.activity.BaseActivityDrawer

import com.zubair.basenavigationdrawer.modules.drawer.fragments.DrawerFragment
import com.zubair.basenavigationdrawer.modules.home.EmptyFragment

import java.util.ArrayList

class DashboardActivity : BaseActivityDrawer() {

    override fun getBaseFragment(): Fragment {
        return EmptyFragment()
    }

    override fun getExtras(extras: ArrayList<Any>) {

    }

    override fun getDrawerFragment(): Fragment {
        return DrawerFragment()
    }
}
