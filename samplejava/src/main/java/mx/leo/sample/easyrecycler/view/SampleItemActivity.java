package mx.leo.sample.easyrecycler.view;

import android.content.DialogInterface;
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
import mx.leo.easyrecycler.util.RecyclerViewItemClickListener;
import mx.leo.easyrecycler.util.extensions.RecyclerViewExtensionsKt;
import mx.leo.sample.easyrecycler.R;
import mx.leo.sample.easyrecycler.adapter.SampleItemAdapter;
import mx.leo.sample.easyrecycler.model.Language;
import mx.leo.sample.easyrecycler.presenter.SampleItemPresenter;

public class SampleItemActivity extends AppCompatActivity implements SampleItemView {

    @BindView(R.id.sample_header_recycler_view) RecyclerView recyclerView;

    private SampleItemPresenter sampleItemPresenter;
    private SampleItemAdapter sampleItemAdapter = new SampleItemAdapter();
    private int[] images = {R.drawable.java, R.drawable.ceylon, R.drawable.python, R.drawable.elixir};

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_header);
        ButterKnife.bind(this);
        initializePresenter();
        setUpRecyclerView();

    }

    private void initializePresenter() {
        sampleItemPresenter = new SampleItemPresenter(this);
        sampleItemPresenter.setData(images, getResources().getStringArray(R.array.names),
                getResources().getStringArray(R.array.info));
    }

    private void setUpRecyclerView() {
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(sampleItemAdapter);
        RecyclerViewExtensionsKt.OnItemClickListener(recyclerView,
                new RecyclerViewItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(@Nullable View view, @Nullable Integer position) {
                        Language language = sampleItemAdapter.getItems().get(position);
                        showOptions(language.getName(), language.getInfo(), sampleItemAdapter,
                                position);
                    }
                });

    }

    @Override public void setItems(List<Language> languages) {
        sampleItemAdapter.addItems((ArrayList<Language>) languages);
    }

    private void showOptions(String name, String info, final SampleItemAdapter adapter,
                             final int position) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle(name);
        dialog.setMessage(info);
        dialog.setPositiveButton(getResources().getString(R.string.delete_text), new DialogInterface.OnClickListener() {
            @Override public void onClick(DialogInterface dialog, int which) {
                adapter.deleteItem(position);
            }
        });
        dialog.setNegativeButton(getResources().getString(R.string.cancel_text), new DialogInterface.OnClickListener() {
            @Override public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        dialog.show();
    }
}
