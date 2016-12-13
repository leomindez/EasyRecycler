package mx.leo.sample.easyrecycler.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import mx.leo.easyrecycler.adapter.EasyAdapter;
import mx.leo.sample.easyrecycler.R;
import mx.leo.sample.easyrecycler.model.Language;

/**
 * Created by Braulio on 12/12/2016.
 */
public class SampleItemAdapter extends EasyAdapter<SampleItemViewHolder, Language> {

    @NotNull @Override public SampleItemViewHolder createHolder(@Nullable ViewGroup parent, int viewType) {
        return new SampleItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.sample_item_layout,parent,false));
    }

    @Override public void onBindItemViewHolder(@NotNull SampleItemViewHolder holder, Language language, int position) {
        holder.bindItem(language);
    }
}
