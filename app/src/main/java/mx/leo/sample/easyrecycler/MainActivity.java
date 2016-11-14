package mx.leo.sample.easyrecycler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.sample_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SampleAdapter sampleAdapter = new SampleAdapter();
        recyclerView.setAdapter(sampleAdapter);

        sampleAdapter.addItem("hola");
        sampleAdapter.addItem("mundo");


    }
}
