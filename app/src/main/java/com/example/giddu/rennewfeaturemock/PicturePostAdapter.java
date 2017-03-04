package com.example.giddu.rennewfeaturemock;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by giddu on 3/2/17.
 */

public class PicturePostAdapter extends RecyclerView.Adapter<PicturePostViewHolder> {

    private ArrayList<PicturePost> picturePosts;

    public PicturePostAdapter(ArrayList<PicturePost> input){
        picturePosts = input;
    }

    @Override
    public int getItemCount() {
        return picturePosts.size();
    }

    @Override
    public PicturePostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.list_item, parent, false);

        return new PicturePostViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PicturePostViewHolder holder, int position) {
        PicturePost currentPost = picturePosts.get(position);
        holder.username.setText(currentPost.getUsername());
        holder.mainPost.setImageBitmap(currentPost.getPicPostID());
        holder.timePosted.setText(currentPost.getTimePosted());
        holder.numComments.setText(String.valueOf(currentPost.getNum_comments()));
        holder.numLikes.setText(String.valueOf(currentPost.getNum_likes()));
        holder.profilePicture.setImageResource(currentPost.getProfPicID());
    }

    public void updateDataSet(ArrayList<PicturePost> input){
        picturePosts = input;
    }

}
