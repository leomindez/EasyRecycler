package brauliomendez.com.kotlin.view

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.View
import brauliomendez.com.kotlin.R
import brauliomendez.com.kotlin.adapter.SampleItemAdapter
import brauliomendez.com.kotlin.model.Language
import brauliomendez.com.kotlin.presenter.SampleItemPresenter
import kotlinx.android.synthetic.main.activity_sample_header.*
import mx.leo.easyrecycler.util.RecyclerViewItemClickListener
import mx.leo.easyrecycler.util.extensions.onItemClickListener
import java.util.*

/**
 * Created by Braulio on 26/12/2016.
 */
class SampleItemActivity : AppCompatActivity(), SampleItemView {

    private var adapter: SampleItemAdapter
    private var presenter : SampleItemPresenter
    private val images : Array<Int>

    init {
        adapter = SampleItemAdapter()
        presenter = SampleItemPresenter(this)
        images = arrayOf( R.drawable.java, R.drawable.ceylon, R.drawable.python, R.drawable.elixir )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample_header)
        setUpRecyclerView()
        presenter.setData(images, resources.getStringArray(R.array.names), resources.getStringArray(R.array.info))
    }

    fun setUpRecyclerView() {
        header_recycler_view.layoutManager = GridLayoutManager(this, 2)
        header_recycler_view.adapter = adapter
        header_recycler_view.onItemClickListener( object :
                RecyclerViewItemClickListener.OnItemClickListener{
            override fun onItemClick(view: View?, position: Int?) {
                val language = adapter.items[position!!]
                showOptions(language.name, language.info, position)
            }
        })
    }

    override fun setItems(language: List<Language>) {
        adapter.items = language as ArrayList<Language>
    }

    fun showOptions(name: String?, info: String?, position: Int?) {
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle(name)
        dialog.setMessage(info)
        dialog.setPositiveButton(resources.getString(R.string.delete_text)) { dialogInterface, which ->
            adapter.deleteItem(position!!)
        }
        dialog.setNegativeButton(resources.getString(R.string.cancel_text), { dialogInterface, which -> })
        dialog.show()
    }
}