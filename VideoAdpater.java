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
import com.darshankateshiya.interviewdemo.model.VIdeoListPojo.Video;
import com.squareup.picasso.Picasso;

import java.util.List;

public class VideoAdpater extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Video> videos;
    Context context;

    public VideoAdpater(List<Video> videos, Context context) {
        this.videos = videos;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ItemVideoList itemVideoList =  new ItemVideoList(LayoutInflater.from(context).inflate(R.layout.adapter_video_layout, viewGroup, false));
        return itemVideoList;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        ItemVideoList list = (ItemVideoList) viewHolder;


        Picasso.get().load(videos.get(i).getCanvasImage320()).into(list.imgVideoRcyImage);
        list.tvVideoRcyTitle.setText(videos.get(i).getTitle());
        list.tvVideoRcyDuration.setText(videos.get(i).getDuration());

    }

    @Override
    public int getItemCount() {
        return videos.size();
    }

    class ItemVideoList extends RecyclerView.ViewHolder {

        ImageView imgVideoRcyImage;
        TextView tvVideoRcyTitle,tvVideoRcyDuration;


        public ItemVideoList(@NonNull View itemView) {
            super(itemView);
            imgVideoRcyImage = (ImageView)itemView.findViewById( R.id.imgVideoRcyImage );
            tvVideoRcyTitle = (TextView)itemView.findViewById( R.id.tvVideoRcyTitle );
            tvVideoRcyDuration = (TextView)itemView.findViewById(R.id.tvVideoRcyDuration);
        }
    }
}
