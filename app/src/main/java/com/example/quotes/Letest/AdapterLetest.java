package com.example.quotes.Letest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.quotes.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.ArrayList;


public class AdapterLetest extends FirebaseRecyclerAdapter<LetestDataHendle,AdapterLetest.LetestHolder> {


    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public AdapterLetest(@NonNull FirebaseRecyclerOptions<LetestDataHendle> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull LetestHolder holder, int position, @NonNull LetestDataHendle model) {
        holder.latestText.setText(model.getTitle());
    }

    @NonNull
    @Override
    public LetestHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate( R.layout.popular_latest_saved_card_layout,parent,false);
        return new LetestHolder(view);
    }

    class LetestHolder extends RecyclerView.ViewHolder{
        TextView latestText;
        public LetestHolder(@NonNull View itemView) {
            super(itemView);
            latestText=itemView.findViewById(R.id.quoteTextView);
        }
    }

}
