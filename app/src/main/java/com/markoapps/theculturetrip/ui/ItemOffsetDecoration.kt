package com.markoapps.theculturetrip.ui

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.annotation.DimenRes
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration

class ItemOffsetDecoration(private val mItemOffset: Int) : ItemDecoration() {
    constructor(context: Context, @DimenRes itemOffsetId: Int) : this(
        context.resources.getDimensionPixelSize(itemOffsetId)
    ) {
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.set(0, 0, 0, mItemOffset)

        val position: Int = parent.getChildAdapterPosition(view)
        val itemCount = state.itemCount

        if(position == itemCount - 1){
            outRect.bottom = 0
        }

    }

}