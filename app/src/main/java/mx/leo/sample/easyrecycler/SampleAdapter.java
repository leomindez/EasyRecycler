package mx.leo.sample.easyrecycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import mx.leo.easyrecycler.EasyAdapter;
import mx.leo.easyrecycler.EasyViewHolder;

/**
 * Created by Leo on 13/11/16.
 */

public class SampleAdapter extends EasyAdapter<SampleAdapter.SampleViewHolder, String> {

    @NotNull
    @Override
    public SampleViewHolder createViewHolder(@Nullable ViewGroup parent) {
        return new SampleViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.sample_item_layout,parent,false));
    }

    static class SampleViewHolder extends EasyViewHolder<String> {

        TextView sampleItem;

        public SampleViewHolder(@NotNull View view) {
            super(view);
            sampleItem = (TextView)view.findViewById(R.id.sample_item);
        }

        @Override
        public void bindItem(String s, int position) {
            sampleItem.setText(s);
        }
    }
}
