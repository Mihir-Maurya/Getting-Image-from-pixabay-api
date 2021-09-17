package com.example.volleylibraryexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    ArrayList<ModelClass> modelClassArrayList;
     private static OnItemClickListener mListener;

    public interface OnItemClickListener {
        void OnItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public MyAdapter(Context context, ArrayList<ModelClass> modelClassArrayList) {
        this.context = context;
        this.modelClassArrayList = modelClassArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.single_row_layout, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ModelClass modelClass = modelClassArrayList.get(position);
        String imageUrl = modelClass.getImageUrl();
        String creatorName = modelClass.getUserName();
        int likesCount = modelClass.getLikes();
        holder.creator.setText(creatorName);
        holder.likes.setText("Likes: " + likesCount);
        Picasso.get().load(imageUrl).fit().centerInside().into(holder.mImagerView);
    }

    @Override
    public int getItemCount() {
        return modelClassArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView mImagerView;
        TextView creator;
        TextView likes;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mImagerView = itemView.findViewById(R.id.image_view);
            creator = itemView.findViewById(R.id.text_view1);
            likes = itemView.findViewById(R.id.text_view2);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mListener != null ){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            mListener.OnItemClick(position);
                        }
                    }
                }
            });
        }
    }

}
