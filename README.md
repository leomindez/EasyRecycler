# EasyRecycler
Library to use Recycler View easily. 

## Create ViewHolder 

```
 lass SampleViewHolder extends EasyItemViewHolder {

        TextView sampleItem;

        public SampleViewHolder(@NotNull View view) {
            super(view);
            sampleItem = (TextView)view.findViewById(R.id.sample_item);
        }

        public void bindItem(String s){
            sampleItem.setText(s);
        }
    }
```
## Create Adapter 

```
class SampleAdapter extends EasyAdapter<SampleAdapter.SampleViewHolder, String> {

    @NotNull
    @Override
    public SampleViewHolder createHolder(@Nullable ViewGroup parent, int viewType) {
        return new SampleViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.sample_item_layout,parent,false));
    }

    @Override
    public void onBindItemViewHolder(@NotNull SampleViewHolder holder, String s, int position) {
        holder.bindItem(s);
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
