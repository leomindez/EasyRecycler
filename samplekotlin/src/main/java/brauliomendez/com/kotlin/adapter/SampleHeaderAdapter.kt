package brauliomendez.com.kotlin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import brauliomendez.com.kotlin.R
import brauliomendez.com.kotlin.model.Language
import brauliomendez.com.kotlin.viewholder.SampleHeaderViewHolder
import brauliomendez.com.kotlin.viewholder.SampleItemViewHolder
import mx.leo.easyrecycler.adapter.EasyHeaderAdapter
import mx.leo.easyrecycler.viewholder.EasyHeaderViewHolder
import mx.leo.easyrecycler.viewholder.EasyItemViewHolder
import mx.leo.easyrecycler.viewholder.EasyViewHolder

/**
 * Created by Braulio on 25/12/2016.
 */
class SampleHeaderAdapter : EasyHeaderAdapter<Language>() {

    override fun createHeaderViewHolder(parent: ViewGroup?): EasyHeaderViewHolder {
       return SampleHeaderViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.header_layout, parent, false))
    }

    override fun onBindHeaderViewHolder(headerHolder: EasyViewHolder) {
        val header = headerHolder as SampleHeaderViewHolder
        header.bindHeader()
    }

    override fun createItemViewHolder(parent: ViewGroup?): EasyItemViewHolder {
        return SampleItemViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_layout, parent, false))
    }

    override fun onBindItemViewHolder(holder: EasyViewHolder, language: Language, position: Int) {
        val item = holder as SampleItemViewHolder
        item.bindItem(language)
    }
}