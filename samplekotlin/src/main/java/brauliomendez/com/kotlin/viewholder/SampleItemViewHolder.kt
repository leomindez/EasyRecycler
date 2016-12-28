package brauliomendez.com.kotlin.viewholder

import android.view.View
import brauliomendez.com.kotlin.model.Language
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_layout.view.*
import mx.leo.easyrecycler.viewholder.EasyItemViewHolder

/**
 * Created by Braulio on 26/12/2016.
 */
class SampleItemViewHolder(view : View) : EasyItemViewHolder(view) {

    fun bindItem(language : Language) {
        Glide.with(itemView.sample_image_view.context).load(language.image).into(itemView.sample_image_view)
    }
}