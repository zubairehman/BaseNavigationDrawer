package com.zubair.basenavigationdrawer.models

import android.support.annotation.LayoutRes

class MenuAdapterBuilder {
    @LayoutRes
    private var layout: Int = 0
    private var columnCount: Int = 0

    fun setLayout(layout: Int): MenuAdapterBuilder {
        this.layout = layout
        return this
    }

    fun setColumnCount(columnCount: Int): MenuAdapterBuilder {
        this.columnCount = columnCount
        return this
    }

    fun create(): MenuAdapterDto {
        return MenuAdapterDto(layout, columnCount)
    }
}