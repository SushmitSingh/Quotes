package com.example.quotes.Letest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.quotes.R;

import java.util.ArrayList;


public class AdapterLetest extends RecyclerView.Adapter<AdapterLetest.ViewHolder> {
    private ArrayList<LetestDataHendle> dataList;
    private Context context;

    public AdapterLetest(ArrayList<LetestDataHendle> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate( R.layout.popular_latest_saved_card_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
          LetestDataHendle dbHandle = dataList.get(position);
          holder.quoteText.setText(dbHandle.getQuoteText());
          holder.genreText.setText(dbHandle.getQuoteGenre());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView quoteText,genreText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            quoteText = itemView.findViewById(R.id.quoteTextView);
            genreText = itemView.findViewById(R.id.tagTextView);
        }
    }
}
