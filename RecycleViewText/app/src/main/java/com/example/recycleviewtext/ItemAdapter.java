package com.example.recycleviewtext;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder>{
    Context ct;
    int[] myImages;
    String[] myNames,myPrices;
    MyInterface myInterface;

    public ItemAdapter(MainActivity mainActivity, int[] images, String[] itemNames, String[] itemPrices,MyInterface myInterface) {
        ct = mainActivity;
        myImages = images;
        myNames = itemNames;
        myPrices = itemPrices;
        this.myInterface 

    }
    public interface MyInterface{
        void selectedItems(String itemName,String itemPrice,int position);
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public ItemAdapter.MyViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ct).inflate(R.layout.item_row,parent,false);
        MyViewHolder holder = new MyViewHolder(v);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull ItemAdapter.MyViewHolder holder, int position) {
        holder.iv.setImageResource(myImages[position]);
        holder.tv1.setText(myNames[position]);
        holder.tv2.setText(myPrices[position]);

    }

    @Override
    public int getItemCount() {
        return myImages.length;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tv1,tv2;
        ElegantNumberButton button;
        public MyViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.itemImage);
            tv1 = itemView.findViewById(R.id.itemName);
            tv2 = itemView.findViewById(R.id.itemPrice);
        }
    }

}
