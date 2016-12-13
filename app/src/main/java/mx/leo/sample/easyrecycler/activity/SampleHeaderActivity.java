package mx.leo.sample.easyrecycler.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.jetbrains.annotations.Nullable;

import butterknife.BindView;
import butterknife.ButterKnife;
import mx.leo.easyrecycler.util.RecyclerViewHeaderClickListener;
import mx.leo.easyrecycler.util.RecyclerViewItemClickListener;
import mx.leo.easyrecycler.util.extensions.RecyclerViewExtensionsKt;
import mx.leo.sample.easyrecycler.R;
import mx.leo.sample.easyrecycler.adapter.SampleHeaderAdapter;
import mx.leo.sample.easyrecycler.model.Language;

public class SampleHeaderActivity extends AppCompatActivity {

    @BindView(R.id.sample_header_recycler_view) RecyclerView recyclerView;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_header);
        ButterKnife.bind(this);
        setUpRecyclerView();
    }

    private void setUpRecyclerView() {
        final SampleHeaderAdapter sampleHeaderAdapter = new SampleHeaderAdapter();
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(sampleHeaderAdapter);
        setData(sampleHeaderAdapter);
        RecyclerViewExtensionsKt.OnHeaderAndItemClickListener(recyclerView,
                new RecyclerViewHeaderClickListener.OnHeaderClickListener() {
                    @Override public void onHeaderClick() {
                        startActivity(new Intent(SampleHeaderActivity.this, SampleItemActivity.class));
                    }
                }, new RecyclerViewItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(@Nullable View view, @Nullable Integer position) {
                        Language language = sampleHeaderAdapter.getItems().get(position);
                        showOptions(language.getName(), language.getInfo(), sampleHeaderAdapter,
                                position);
                    }
                });
    }

    private void setData(SampleHeaderAdapter sampleHeaderAdapter){
        int [] photos = { R.drawable.java, R.drawable.ceylon, R.drawable.python, R.drawable.elixir};
        String [] names = { getResources().getString(R.string.name_java), getResources().getString(R.string.name_ceylon),
                getResources().getString(R.string.name_python), getResources().getString(R.string.name_elixir) };
        String [] info = { getResources().getString(R.string.info_java), getResources().getString(R.string.info_ceylon),
                getResources().getString(R.string.info_python), getResources().getString(R.string.info_elixir)};
        for (int i = 0; i < photos.length; i++){
            Language language = new Language();
            language.setPhoto(photos[i]);
            language.setName(names[i]);
            language.setInfo(info[i]);
            sampleHeaderAdapter.addItem(language);
        }
    }

    private void showOptions(String name, String info, final SampleHeaderAdapter adapter,
                             final int position){
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle(name);
        dialog.setMessage(info);
        dialog.setPositiveButton("DELETE ITEM", new DialogInterface.OnClickListener() {
            @Override public void onClick(DialogInterface dialog, int which) {
                adapter.deleteItem(position);
            }
        });
        dialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override public void onClick(DialogInterface dialogInterface, int i) { }
        });
        dialog.show();
    }
}
