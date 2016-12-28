package mx.leo.sample.easyrecycler.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import mx.leo.easyrecycler.util.RecyclerViewHeaderClickListener;
import mx.leo.easyrecycler.util.RecyclerViewItemClickListener;
import mx.leo.easyrecycler.util.extensions.RecyclerViewExtensionsKt;
import mx.leo.sample.easyrecycler.R;
import mx.leo.sample.easyrecycler.adapter.SampleHeaderAdapter;
import mx.leo.sample.easyrecycler.model.Language;
import mx.leo.sample.easyrecycler.presenter.SampleHeaderPresenter;

public class SampleHeaderActivity extends AppCompatActivity implements SampleHeaderView {

    @BindView(R.id.sample_header_recycler_view) RecyclerView recyclerView;
    int [] images = { R.drawable.java, R.drawable.ceylon, R.drawable.python, R.drawable.elixir };

    private SampleHeaderAdapter sampleHeaderAdapter = new SampleHeaderAdapter();
    private SampleHeaderPresenter sampleHeaderPresenter;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_header);
        ButterKnife.bind(this);
        initializePresenter();
        setUpRecyclerView();
    }

    private void initializePresenter() {
        sampleHeaderPresenter = new SampleHeaderPresenter(this);
        sampleHeaderPresenter.setData(images,
                getResources().getStringArray(R.array.names), getResources().getStringArray(R.array.info));
    }

    private void setUpRecyclerView() {
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(sampleHeaderAdapter);
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

    @Override public void setItems(List<Language> languages) {
        sampleHeaderAdapter.addItems((ArrayList<Language>) languages);
    }

    private void showOptions(String name, String info, final SampleHeaderAdapter adapter,
                             final int position) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle(name);
        dialog.setMessage(info);
        dialog.setPositiveButton(getResources().getString(R.string.delete_text),
                new DialogInterface.OnClickListener() {
            @Override public void onClick(DialogInterface dialog, int which) {
                adapter.deleteItem(position);
            }
        });
        dialog.setNegativeButton(getResources().getString(R.string.cancel_text),
                new DialogInterface.OnClickListener() {
            @Override public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        dialog.show();
    }
}
