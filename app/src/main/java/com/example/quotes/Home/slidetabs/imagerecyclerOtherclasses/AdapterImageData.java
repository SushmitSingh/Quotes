package com.example.quotes.Home.slidetabs.imagerecyclerOtherclasses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.quotes.Home.slidetabs.ModelHeadlines;
import com.example.quotes.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.List;

public class AdapterImageData extends FirebaseRecyclerAdapter<ImageDataHandling,AdapterImageData.ImageHolder>{

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public AdapterImageData(@NonNull FirebaseRecyclerOptions<ImageDataHandling> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ImageHolder holder, int position, @NonNull ImageDataHandling model) {
        holder.mTextView.setText(model.getTag());
        Glide.with(holder.mImageView.getContext()).load(model.getiUrl()).into(holder.mImageView);
    }

    @NonNull
    @Override
    public ImageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.image_card,parent,false);
      return new ImageHolder(v);
    }

    public class ImageHolder extends RecyclerView.ViewHolder{
        ImageView mImageView;
        TextView mTextView;
      public ImageHolder(@NonNull View itemView) {
          super(itemView);
          mImageView=itemView.findViewById(R.id.imageView);
          mTextView=itemView.findViewById(R.id.tagText);



      }
  }
}
