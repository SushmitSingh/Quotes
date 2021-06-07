package com.example.quotes.Populer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quotes.Letest.AdapterLetest;
import com.example.quotes.Letest.LetestDataHendle;
import com.example.quotes.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.List;

public class AdapterQuotesText extends FirebaseRecyclerAdapter<LetestDataHendle,AdapterQuotesText.LetestHolder> {


    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public AdapterQuotesText(@NonNull FirebaseRecyclerOptions<LetestDataHendle> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull AdapterQuotesText.LetestHolder holder, int position, @NonNull LetestDataHendle model) {
        holder.popularText.setText(model.getTitle());
    }

    @NonNull
    @Override
    public AdapterQuotesText.LetestHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate( R.layout.popular_latest_saved_card_layout,parent,false);
        return new AdapterQuotesText.LetestHolder(view);
    }

    class LetestHolder extends RecyclerView.ViewHolder{
        TextView popularText;
        public LetestHolder(@NonNull View itemView) {
            super(itemView);
            popularText=itemView.findViewById(R.id.quoteTextView);
        }
    }

}
