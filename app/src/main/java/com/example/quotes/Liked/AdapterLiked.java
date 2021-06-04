package com.example.quotes.Liked;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quotes.R;

import java.util.ArrayList;

public class AdapterLiked extends RecyclerView.Adapter<AdapterLiked.ViewHolder> {
    private Context context;
    private ArrayList<LikedDataHandle> datalist;

    public AdapterLiked(Context context, ArrayList<LikedDataHandle> datalist) {
        this.context = context;
        this.datalist = datalist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =  LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_latest_saved_card_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            LikedDataHandle dbhandle =  datalist.get(position);
            holder.quoteText.setText(dbhandle.getQuoteText());
            holder.genreText.setText(dbhandle.getQuoteGenre());
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView quoteText,genreText;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            quoteText = itemView.findViewById(R.id.quoteTextView);
            genreText = itemView.findViewById(R.id.tagTextView);

        }
    }
}
