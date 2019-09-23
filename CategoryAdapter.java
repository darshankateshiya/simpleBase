package com.darshankateshiya.interviewdemo.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.darshankateshiya.interviewdemo.R;
import com.darshankateshiya.interviewdemo.model.VIdeoListPojo.Category;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Category> categories;
    Context context;

    public CategoryAdapter(List<Category> categories, Context context) {
        this.categories = categories;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ItemCategories(LayoutInflater.from(context).inflate(R.layout.adapter_category_layout, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ItemCategories list = (ItemCategories) viewHolder;
        Picasso.get().load(categories.get(i).getImage200()).transform(new CircleTransform()).into(list.ImgCatRcyImage);
        list.tvCatRcyTitle.setText(categories.get(0).getName());
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    class ItemCategories extends RecyclerView.ViewHolder {


        ImageView ImgCatRcyImage;
        TextView tvCatRcyTitle;

        public ItemCategories(@NonNull View itemView) {
            super(itemView);

            ImgCatRcyImage = (ImageView)itemView.findViewById( R.id.ImgCatRcyImage );
            tvCatRcyTitle = (TextView)itemView.findViewById( R.id.tvCatRcyTitle );

        }

    }



}
