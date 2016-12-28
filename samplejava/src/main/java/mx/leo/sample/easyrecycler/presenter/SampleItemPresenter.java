package mx.leo.sample.easyrecycler.presenter;

import java.util.ArrayList;
import java.util.List;

import mx.leo.sample.easyrecycler.model.Language;
import mx.leo.sample.easyrecycler.view.SampleItemView;

/**
 * Created by Braulio on 22/12/2016.
 */

public class SampleItemPresenter {

    private SampleItemView sampleItemView;

    public SampleItemPresenter(SampleItemView sampleItemView) {
        this.sampleItemView = sampleItemView;
    }

    public void setData(int [] photos, String [] names, String [] info){
        List<Language> languages = new ArrayList<>();
        for (int i = 0; i < photos.length; i++){
            Language language = new Language();
            language.setPhoto(photos[i]);
            language.setName(names[i]);
            language.setInfo(info[i]);
            languages.add(language);
        }
        sampleItemView.setItems(languages);
    }
}
