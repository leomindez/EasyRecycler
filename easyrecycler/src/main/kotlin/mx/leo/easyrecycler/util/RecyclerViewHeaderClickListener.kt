package mx.leo.easyrecycler.util

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.MotionEvent
import android.view.View

open class RecyclerViewHeaderClickListener(context: Context, var headerClick:OnHeaderClickListener,var itemClick: OnItemClickListener) : RecyclerViewItemClickListener(context,itemClick) {

    override fun onInterceptTouchEvent(rv: RecyclerView?, e: MotionEvent?): Boolean {

        val child:View? = rv?.findChildViewUnder(e!!.x,e.y)
        if(gestureDetector.onTouchEvent(e)) {
            if(rv?.getChildAdapterPosition(child)!! >= 0) {
                if (rv?.getChildAdapterPosition(child) == 0) {
                    headerClick.onHeaderClick()
                    return true
                } else {
                    recyclerViewItem.onItemClick(child, (rv?.getChildAdapterPosition(child)?.minus(1)))
                    return true
                }
            }else {
                return false
            }
        }
        return false
    }

    interface OnHeaderClickListener {
        fun onHeaderClick()
    }
}