package mx.leo.sample.easyrecycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import mx.leo.easyrecycler.adapter.EasyHeaderAdapter;
import mx.leo.easyrecycler.viewholder.EasyHeaderViewHolder;
import mx.leo.easyrecycler.viewholder.EasyItemViewHolder;
import mx.leo.easyrecycler.viewholder.EasyViewHolder;

public class SampleHeaderAdapter extends EasyHeaderAdapter<String> {

    @NotNull
    @Override
    public HeaderAdapter createHeaderViewHolder(@Nullable ViewGroup parent) {
        return new HeaderAdapter(LayoutInflater.from(parent.getContext()).inflate(R.layout.header_layout,parent,false));
    }

    @NotNull
    @Override
    public ItemAdapter createItemViewHolder(@Nullable ViewGroup parent) {
        return new ItemAdapter(LayoutInflater.from(parent.getContext()).inflate(R.layout.sample_item_layout,parent,false));
    }

    @Override
    public void onBindHeaderViewHolder(@NotNull EasyViewHolder headerHolder) {
        ((HeaderAdapter)headerHolder).bindHeader();
    }

    @Override
    public void onBindItemViewHolder(@NotNull EasyViewHolder holder, String s, int position) {
        ((ItemAdapter) holder).bindItem(s);
    }


    private static class HeaderAdapter extends EasyHeaderViewHolder{

        public HeaderAdapter(@NotNull View view) {
            super(view);
        }
        public void bindHeader(){

        }
    }

    private static class ItemAdapter extends EasyItemViewHolder{
        TextView textView;

        public ItemAdapter(@NotNull View view) {
            super(view);
            textView = (TextView) view.findViewById(R.id.sample_item);
        }

        public void bindItem(String s) {
            textView.setText(s);
        }
    }
}
