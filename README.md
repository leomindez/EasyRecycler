# EasyRecycler
Library to user Recycler View easily. 

## Create ViewHolder 

## Create Adapter 

```
public class SampleAdapter extends EasyAdapter<SampleAdapter.SampleViewHolder, String> {

    @NotNull
    @Override
    public SampleViewHolder createViewHolder(@Nullable ViewGroup parent) {
        return new SampleViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.sample_item_layout,parent,false));
    }
}
```
