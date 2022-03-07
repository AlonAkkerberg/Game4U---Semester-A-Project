package com.example.video4u;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoViewHolder> {
    private List<Video> VideoList;

    public VideoAdapter(List<Video> VideoList) {
        this.VideoList = VideoList;
    }

    public void AddContact(Video Video) {
        VideoList.add(Video);
        notifyDataSetChanged();
        DataPersistencyHelper.StoreData(VideoList);
    }

    public void DeleteContact(int position) {
        VideoList.remove(position);
        notifyDataSetChanged();
        DataPersistencyHelper.StoreData(VideoList);
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_photo, parent, false);
        VideoViewHolder vh = new VideoViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        Video video = VideoList.get(position);
        if (video.getUri() == null)
            holder.avatar.setImageResource(video.getPhoto());
        else {
            holder.avatar.setImageURI(Uri.parse(video.getUri()));
        }

        Video Video = VideoList.get(position);
        holder.avatar.setImageResource(Video.getPhoto());
        holder.gamename.setText(Video.getGameName());
        holder.price.setText(Video.getPrice());
        {
            holder.card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent i = new Intent(v.getContext(), MainActivity2.class);
                    i.putExtra("Video", Video);
                    ActivityOptionsCompat options =
                            ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) v.getContext(),
                                    holder.avatar,
                                    "avatarTrasnition"
                            );
                    v.getContext().startActivity(i, options.toBundle());
                }
            });
        }
    }


    @Override
    public int getItemCount(){ return VideoList.size(); }

}
