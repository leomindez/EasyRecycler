package mx.leo.easyrecycler.adapter


import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import mx.leo.easyrecycler.viewholder.EasyHeaderViewHolder
import mx.leo.easyrecycler.viewholder.EasyItemViewHolder
import mx.leo.easyrecycler.viewholder.EasyViewHolder

abstract class EasyHeaderAdapter<Item> : EasyAdapter<EasyViewHolder, Item>() {

    object ViewHolderTypes {
        var HEADER_TYPE: Int = 0x001
        var ITEM_TYPE: Int = 0x010
    }

    abstract fun createHeaderViewHolder(parent: ViewGroup?): EasyHeaderViewHolder
    abstract fun createItemViewHolder(parent: ViewGroup?): EasyItemViewHolder
    abstract fun onBindHeaderViewHolder(headerHolder:EasyViewHolder)


    override fun onBindViewHolder(holder: EasyViewHolder, position: Int) {
        if(holder is EasyHeaderViewHolder && position == 0) {
            onBindHeaderViewHolder(holder)
        }else if(holder is EasyItemViewHolder) {
            onBindItemViewHolder(holder,items.get(position-1),position)
        }else{}
    }

    override fun createHolder(parent: ViewGroup?, viewType: Int): EasyViewHolder {
        if (viewType == ViewHolderTypes.HEADER_TYPE)
            return createHeaderViewHolder(parent)
        else
            return createItemViewHolder(parent)

    }

    override fun getItemViewType(position: Int): Int {
        if(position == 0)
            return ViewHolderTypes.HEADER_TYPE
        else
            return ViewHolderTypes.ITEM_TYPE
    }

    override fun getItemCount(): Int {
        return items.size + 1
    }



    override fun onAttachedToRecyclerView(recyclerView: RecyclerView?) {
        val manager = recyclerView?.layoutManager
        if(manager is GridLayoutManager){
            manager.spanSizeLookup = HeaderSpanSize(manager)
        }

    }

    class HeaderSpanSize(val manager:GridLayoutManager) : SpanSizeLookup(){
        override fun getSpanSize(position: Int): Int {
            if (position == 0)
                return manager.spanCount
            else
                return 1
        }
    }
}
