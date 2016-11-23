package mx.leo.easyrecycler


import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import mx.leo.easyrecycler.viewholder.EasyHeaderViewHolder
import mx.leo.easyrecycler.viewholder.EasyViewHolder

abstract class EasyHeaderAdapter<Item> : EasyAdapter<EasyViewHolder<Item>,Item>() {

    object ViewHolderTypes {
        var HEADER_TYPE: Int = 0x001
        var ITEM_TYPE: Int = 0x010
    }

    abstract fun createHeaderViewHolder(parent:ViewGroup?): EasyHeaderViewHolder<Item>
    abstract fun createItemViewHolder(parent: ViewGroup?): EasyViewHolder<Item>

    override fun createHolder(parent: ViewGroup?, viewType: Int): EasyViewHolder<Item> {
        if (viewType == ViewHolderTypes.HEADER_TYPE)
            return createHeaderViewHolder(parent)
        else
            return createItemViewHolder(parent)

    }

    override fun getItemCount(): Int {
        return super.getItemCount()  + 1
    }

    override fun getItemViewType(position: Int): Int {
        if(position == 0)
            return ViewHolderTypes.HEADER_TYPE
        else
            return ViewHolderTypes.ITEM_TYPE
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView?) {
        if(recyclerView?.layoutManager is GridLayoutManager){

        }

    }
}
