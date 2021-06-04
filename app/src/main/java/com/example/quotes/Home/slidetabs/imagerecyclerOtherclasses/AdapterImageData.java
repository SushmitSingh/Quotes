package com.example.quotes.Home.slidetabs.imagerecyclerOtherclasses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quotes.Home.slidetabs.ModelHeadlines;
import com.example.quotes.R;

import java.util.List;

public class AdapterImageData extends RecyclerView.Adapter<AdapterImageData.ViewHolder> {

    private Context context;
    private List<ImageDataHandling> dataList;

    public AdapterImageData(Context context, List<ImageDataHandling> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_card,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ImageDataHandling imageData = dataList.get(position);
         holder.text.setText(imageData.getType());
         holder.image.setBackgroundResource(imageData.getImage());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        private  TextView   text;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.imageView);
            text = itemView.findViewById(R.id.tagText);



        }
    }
}
