package mx.leo.sample.easyrecycler.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import mx.leo.easyrecycler.adapter.EasyHeaderAdapter;
import mx.leo.easyrecycler.viewholder.EasyViewHolder;
import mx.leo.sample.easyrecycler.R;
import mx.leo.sample.easyrecycler.model.Language;

public class SampleHeaderAdapter extends EasyHeaderAdapter<Language> {

    @NotNull @Override public SampleHeaderViewHolder createHeaderViewHolder(@Nullable ViewGroup parent) {
        return new SampleHeaderViewHolder(LayoutInflater.from(parent.getContext()).
                inflate(R.layout.header_layout,parent,false));
    }

    @NotNull @Override public SampleItemViewHolder createItemViewHolder(@Nullable ViewGroup parent) {
        return new SampleItemViewHolder(LayoutInflater.from(parent.getContext()).
                inflate(R.layout.sample_item_layout,parent,false));
    }

    @Override public void onBindHeaderViewHolder(@NotNull EasyViewHolder headerHolder) {
        ((SampleHeaderViewHolder)headerHolder).bindHeader();
    }

    @Override public void onBindItemViewHolder(@NotNull EasyViewHolder holder, Language s, int position) {
        ((SampleItemViewHolder) holder).bindItem(s);
    }
}
