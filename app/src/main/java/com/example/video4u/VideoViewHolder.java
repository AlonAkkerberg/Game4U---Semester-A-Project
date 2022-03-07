package com.example.video4u;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class VideoViewHolder extends RecyclerView.ViewHolder{

    public CardView card;
    public ImageView avatar;
    public TextView gamename;
    public TextView price;

    public VideoViewHolder(@NonNull View itemView)
    {
        super(itemView);

        card = itemView.findViewById(R.id.card);
        avatar = itemView.findViewById(R.id.avatar);
        gamename = itemView.findViewById(R.id.gamename);
        price = itemView.findViewById(R.id.price);

    }
}

