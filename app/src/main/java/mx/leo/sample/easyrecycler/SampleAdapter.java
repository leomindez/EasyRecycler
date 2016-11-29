package mx.leo.sample.easyrecycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import mx.leo.easyrecycler.adapter.EasyAdapter;
import mx.leo.easyrecycler.viewholder.EasyItemViewHolder;

public class SampleAdapter extends EasyAdapter<SampleAdapter.SampleViewHolder, String> {


    @NotNull
    @Override
    public SampleViewHolder createHolder(@Nullable ViewGroup parent, int viewType) {
        return new SampleViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.sample_item_layout,parent,false));
    }

    @Override
    public void onBindItemViewHolder(@NotNull SampleViewHolder holder, String s, int position) {
        holder.bindItem(s);
    }

    static class SampleViewHolder extends EasyItemViewHolder {

        TextView sampleItem;

        public SampleViewHolder(@NotNull View view) {
            super(view);
            sampleItem = (TextView)view.findViewById(R.id.sample_item);
        }

        public void bindItem(String s){
            sampleItem.setText(s);
        }
    }

}
