[![](https://jitpack.io/v/leomindez/easyrecycler.svg)](https://jitpack.io/#leomindez/easyrecycler) [![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-EasyRecycler-green.svg?style=flat)](http://android-arsenal.com/details/1/4766)
# EasyRecycler
Library to use Recycler View easily. 
# Usage

```gradle		
maven { url 'https://jitpack.io' }
compile 'com.github.leomindez:easyrecycler:1.0.1'
```

# SimpleAdapter
## Create ViewHolder 

```java
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

```java
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
```java
 RecyclerViewExtensionsKt.OnItemClickListener(recyclerView, new RecyclerViewItemClickListener.OnItemClickListener() {
            @Override
            public void onClick(@Nullable View view, @Nullable Integer position) {
                Log.d("item", sampleAdapter.getItems().get(position));
            }
        });
```
# Header Adapter
## Create Holders
``` java
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
```java
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
```java
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
## Add Elements 
```java
      SampleHeaderAdapter sampleAdapter = new SampleHeaderAdapter();
        sampleAdapter.addItem("hola");
        sampleAdapter.addItem("mundo");
        
        ArrayList<String> items = new ArrayList<String>();
        items.add("hola");
        items.add("mundo");
        
        sampleAdapter.addItems(items);
 ```
## Example
 ![1](https://github.com/BraulioMendez/EasyRecycler/blob/master/art/1.png "Recycler View With Header")  ![2](https://github.com/BraulioMendez/EasyRecycler/blob/master/art/2.png)  ![3](https://github.com/BraulioMendez/EasyRecycler/blob/master/art/3.png)  ![4](https://github.com/BraulioMendez/EasyRecycler/blob/master/art/4.png)  




