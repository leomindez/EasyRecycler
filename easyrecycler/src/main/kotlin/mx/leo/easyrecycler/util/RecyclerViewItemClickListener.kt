package mx.leo.easyrecycler.util


import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View

class RecyclerViewItemClickListener(context: Context, var recyclerViewItem: OnItemClickListener): RecyclerView.OnItemTouchListener{

    lateinit var gestureDetector:GestureDetector
    init {
        gestureDetector = GestureDetector(context, object:GestureDetector.SimpleOnGestureListener(){
            override fun onSingleTapUp(e: MotionEvent?): Boolean {
                return true
            }

        })
    }
    override fun onTouchEvent(rv: RecyclerView?, e: MotionEvent?) {
    }

    override fun onInterceptTouchEvent(rv: RecyclerView?, e: MotionEvent?): Boolean {
        val child:View? = rv?.findChildViewUnder(e!!.x,e.y)
        if(gestureDetector.onTouchEvent(e)) {
            recyclerViewItem.onItemClick(child, rv?.getChildAdapterPosition(child))
        }
        return false
    }

    override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
    }

    interface OnItemClickListener {
        fun onItemClick(view: View?, position: Int?)
    }
}