package mx.leo.easyrecycler

import android.support.v7.widget.RecyclerView
import android.view.View

abstract class EasyViewHolder<Item>(view: View):RecyclerView.ViewHolder(view) {
    abstract fun bindItem(item: Item, position:Int);
}