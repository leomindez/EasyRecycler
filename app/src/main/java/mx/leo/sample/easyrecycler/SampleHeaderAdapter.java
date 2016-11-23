package mx.leo.sample.easyrecycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import mx.leo.easyrecycler.adapter.EasyHeaderAdapter;
import mx.leo.easyrecycler.viewholder.EasyHeaderViewHolder;
import mx.leo.easyrecycler.viewholder.EasyViewHolder;

public class SampleHeaderAdapter extends EasyHeaderAdapter<String> {

    @NotNull
    @Override
    public EasyHeaderViewHolder<String> createHeaderViewHolder(@Nullable ViewGroup parent) {
        return new HeaderAdapter(LayoutInflater.from(parent.getContext()).inflate(R.layout.header_layout,parent,false));
    }

    @NotNull
    @Override
    public EasyViewHolder<String> createItemViewHolder(@Nullable ViewGroup parent) {
        return new ItemAdapter(LayoutInflater.from(parent.getContext()).inflate(R.layout.sample_item_layout,parent,false));
    }

    static class HeaderAdapter extends EasyHeaderViewHolder<String>{

        public HeaderAdapter(@NotNull View view) {
            super(view);
        }

        @Override
        public void bindItem(String s, int position) {

        }
    }

    static class ItemAdapter extends EasyViewHolder<String> {

        public ItemAdapter(@NotNull View view) {
            super(view);
        }

        @Override
        public void bindItem(String s, int position) {

        }
    }
}
