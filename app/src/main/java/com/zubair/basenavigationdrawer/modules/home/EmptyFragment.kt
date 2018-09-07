package com.zubair.basenavigationdrawer.modules.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.zubair.basenavigationdrawer.R
import com.zubair.basenavigationdrawer.modules.baseclasses.fragment.BaseToolbarFragment

import java.util.ArrayList


class EmptyFragment : BaseToolbarFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_empty, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun getExtras(extras: ArrayList<Any>) {

    }

    override fun getTitle(): String? {
        return null
    }
}
