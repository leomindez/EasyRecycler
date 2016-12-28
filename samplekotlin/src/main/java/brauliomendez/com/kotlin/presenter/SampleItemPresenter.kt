package brauliomendez.com.kotlin.presenter

import brauliomendez.com.kotlin.model.Language
import brauliomendez.com.kotlin.view.SampleItemView
import java.util.*

/**
 * Created by Braulio on 26/12/2016.
 */
class SampleItemPresenter(var view : SampleItemView){

    fun setData(photos: Array<Int>, names: Array<String>, info: Array<String>) {
        val languageList : MutableList<Language> = ArrayList()
        photos.forEachIndexed { index, value ->
            languageList.add(Language(value, names[index], info[index]))
        }
        view.setItems(languageList)
    }
}