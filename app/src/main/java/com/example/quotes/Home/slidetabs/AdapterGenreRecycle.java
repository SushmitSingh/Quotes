package com.example.quotes.Home.slidetabs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quotes.R;
import java.util.List;

public class AdapterGenreRecycle extends RecyclerView.Adapter<AdapterGenreRecycle.ViewHolder> {
    private Context context;
    private  List<ModelHeadlines> dataList;

    public AdapterGenreRecycle(Context context, List<ModelHeadlines> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public AdapterGenreRecycle.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.genre_card_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterGenreRecycle.ViewHolder holder, int position) {
        ModelHeadlines model = dataList.get(position);
        holder.headline.setText(model.getHeadline());
        holder.text.setText("" + model.getTextline());
        holder.imageview.setImageResource(model.getImage());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageview;
        private TextView headline, text;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageview = itemView.findViewById(R.id.imageGenre);
            headline = itemView.findViewById(R.id.genreHeadLine);
            text = itemView.findViewById(R.id.textForContinue);
        }
    }
}
