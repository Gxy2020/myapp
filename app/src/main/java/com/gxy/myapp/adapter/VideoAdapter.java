package com.gxy.myapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gxy.myapp.R;
import com.gxy.myapp.entity.VideoEntity;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * @author GUO
 * @Classname VideoAdapter
 * @Description TODO
 * @Date 2020/11/7 19:23
 */
public class VideoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private  List<VideoEntity> data;
    public VideoAdapter(Context context, List<VideoEntity> data){
        this.mContext=context;
        this.data=data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.item_video_layout,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder vh=(ViewHolder)holder;
        VideoEntity videoEntity=data.get(position);
        vh.tvTitle.setText(videoEntity.getVtitle());
        vh.tvAuthor.setText(videoEntity.getAuthor());
        vh.tvDz.setText(String.valueOf(videoEntity.getLikeNum()));
        vh.tvCollect.setText(String.valueOf(videoEntity.getCollectNum()));
        vh.tvComment.setText(String.valueOf(videoEntity.getCommentNum()));
        /*异步加载图片*/
        Picasso.with(mContext).load(videoEntity.getHeadurl()).into(vh.imgHeader);
        Picasso.with(mContext).load(videoEntity.getCoverurl()).into(vh.imgCover);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    static  class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvTitle;
        private TextView tvAuthor;
        private TextView tvDz;
        private TextView tvComment;
        private TextView tvCollect;
        private ImageView imgHeader;
        private ImageView imgCover;

        public ViewHolder(@NonNull View view) {
            super(view);
            tvTitle=view.findViewById(R.id.title);
            tvAuthor=view.findViewById(R.id.author);
            tvDz=view.findViewById(R.id.dz);
            tvComment=view.findViewById(R.id.comment);
            tvCollect=view.findViewById(R.id.collect);
            imgHeader=view.findViewById(R.id.img_header);
            imgCover=view.findViewById(R.id.img_cover);
        }
    }
}
