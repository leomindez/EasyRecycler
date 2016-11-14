# EasyRecycler
Library to user Recycler View easily. 

## Create ViewHolder 

```
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
```
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

## Recycler Item Click
```
 RecyclerViewExtensionsKt.OnItemClickListener(recyclerView, new RecyclerViewItemClickListener.OnItemClickListener() {
            @Override
            public void onClick(@Nullable View view, @Nullable Integer position) {
                Log.d("item", sampleAdapter.getItems().get(position));
            }
        });
```
