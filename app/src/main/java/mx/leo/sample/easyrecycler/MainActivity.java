package mx.leo.sample.easyrecycler;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import org.jetbrains.annotations.Nullable;

import mx.leo.easyrecycler.util.RecyclerViewItemClickListener;
import mx.leo.easyrecycler.util.extensions.RecyclerViewExtensionsKt;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.sample_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final SampleHeaderAdapter sampleAdapter = new SampleHeaderAdapter();
        //final SampleAdapter sampleAdapter = new SampleAdapter();
        recyclerView.setAdapter(sampleAdapter);

        sampleAdapter.addItem("hola");
        sampleAdapter.addItem("mundo");

        RecyclerViewExtensionsKt.OnItemClickListener(recyclerView, new RecyclerViewItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(@Nullable View view, @Nullable Integer position) {
                Log.d("item", sampleAdapter.getItems().get(position));
            }
        });
    }
}
