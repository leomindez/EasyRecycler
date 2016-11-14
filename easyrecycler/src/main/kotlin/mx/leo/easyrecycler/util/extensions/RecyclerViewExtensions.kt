package mx.leo.easyrecycler.util.extensions

import android.support.v7.widget.RecyclerView
import android.view.View
import mx.leo.easyrecycler.util.RecyclerViewItemClickListener

@JvmName("OnItemClickListener")
fun RecyclerView.onItemClickListener(listener: RecyclerViewItemClickListener.OnItemClickListener) {
    this.addOnItemTouchListener(RecyclerViewItemClickListener(this.context,listener))
}