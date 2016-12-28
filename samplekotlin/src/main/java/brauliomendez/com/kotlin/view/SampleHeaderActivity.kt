package brauliomendez.com.kotlin.view

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.View
import brauliomendez.com.kotlin.R
import brauliomendez.com.kotlin.adapter.SampleHeaderAdapter
import brauliomendez.com.kotlin.model.Language
import brauliomendez.com.kotlin.presenter.SampleHeaderPresenter
import kotlinx.android.synthetic.main.activity_sample_header.*
import mx.leo.easyrecycler.util.RecyclerViewHeaderClickListener
import mx.leo.easyrecycler.util.RecyclerViewItemClickListener
import mx.leo.easyrecycler.util.extensions.onHeaderAndItemClickListener
import java.util.*

class SampleHeaderActivity : AppCompatActivity(), SampleHeaderView {

    private var adapter: SampleHeaderAdapter
    private var presenter : SampleHeaderPresenter
    private val images = arrayOf( R.drawable.java, R.drawable.ceylon, R.drawable.python, R.drawable.elixir )
    private val names = arrayOf("Java", "Ceylon", "Python", "Elixir")
    private val info = arrayOf("Java", "Ceylon", "Python", "Elixir")

    init {
        adapter = SampleHeaderAdapter()
        presenter = SampleHeaderPresenter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_header)
        setUpRecyclerView()
        presenter.setData(images, names, info)
    }

    fun setUpRecyclerView() {
        header_recycler_view.layoutManager = GridLayoutManager(this, 2)
        header_recycler_view.adapter = adapter
        header_recycler_view.onHeaderAndItemClickListener(object :
                RecyclerViewHeaderClickListener.OnHeaderClickListener {
            override fun onHeaderClick() {
                startActivity(Intent(this@SampleHeaderActivity, SampleItemActivity::class.java))
            }
        }, object : RecyclerViewItemClickListener.OnItemClickListener {
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
        dialog.setPositiveButton("DELETE ITEM") { dialogInterface, which ->
            adapter.deleteItem(position!!)
        }
        dialog.setNegativeButton("CANCEL", { dialogInterface, which -> })
        dialog.show()
    }
}
