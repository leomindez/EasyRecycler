package brauliomendez.com.kotlin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import brauliomendez.com.kotlin.R
import brauliomendez.com.kotlin.model.Language
import brauliomendez.com.kotlin.viewholder.SampleItemViewHolder
import mx.leo.easyrecycler.adapter.EasyAdapter

/**
 * Created by Braulio on 26/12/2016.
 */
class SampleItemAdapter : EasyAdapter<SampleItemViewHolder, Language>() {

    override fun createHolder(parent: ViewGroup?, viewType: Int): SampleItemViewHolder {
        return SampleItemViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_layout, parent, false))
    }

    override fun onBindItemViewHolder(holder: SampleItemViewHolder, item: Language, position: Int) {
        holder.bindItem(item)
    }
}