package mx.leo.sample.easyrecycler.viewholder;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;

import butterknife.BindView;
import butterknife.ButterKnife;
import mx.leo.easyrecycler.viewholder.EasyItemViewHolder;
import mx.leo.sample.easyrecycler.R;
import mx.leo.sample.easyrecycler.model.Language;

/**
 * Created by Braulio on 12/12/2016.
 */

public class SampleItemViewHolder extends EasyItemViewHolder {

    @BindView(R.id.sample_image_view) ImageView sampleImageView;

    public SampleItemViewHolder(@NotNull View view) {
        super(view);
        ButterKnife.bind(this, view);
    }

    public void bindItem(Language language) {
        Glide.with(sampleImageView.getContext()).load(language.getPhoto()).into(sampleImageView);
    }
}

