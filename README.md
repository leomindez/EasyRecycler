[![](https://jitpack.io/v/leomindez/easyrecycler.svg)](https://jitpack.io/#leomindez/easyrecycler)
# EasyRecycler
Library to use Recycler View easily. 
# Usage

```		
maven { url 'https://jitpack.io' }
compile 'com.github.leomindez:easyrecycler:1.0.0'
```

# SimpleAdapter
## Create ViewHolder 

```
 class SampleViewHolder extends EasyItemViewHolder {

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
# Header Adapter
## Create Holders
``` 
private static class HeaderAdapter extends EasyHeaderViewHolder {

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
```

## Create Header Adapter 
```
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
}
```
## Recycler Header and Item Click
```
     RecyclerViewExtensionsKt.OnHeaderAndItemClickListener(recyclerView, new RecyclerViewHeaderClickListener.OnHeaderClickListener() {
            @Override
            public void onHeaderClick() {
                Log.d("Header", "header click");
            }
        }, new RecyclerViewItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(@Nullable View view, @Nullable Integer position) {
                Log.d("Item", sampleAdapter.getItems().get(position));
            }
        });
```


