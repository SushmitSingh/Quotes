package com.example.quotes.Home.slidetabs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.quotes.R;
import com.example.quotes.mainFrag;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.card.MaterialCardView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterGenreRecycle extends FirebaseRecyclerAdapter<ModelHeadlines,AdapterGenreRecycle.MainViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public AdapterGenreRecycle(@NonNull FirebaseRecyclerOptions<ModelHeadlines> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull MainViewHolder holder, int position, @NonNull ModelHeadlines model) {
        holder.mTextView.setText(model.getTitle());
        Glide.with(holder.mImageView.getContext()).load(model.getMUrl()).into(holder.mImageView);
        holder.mMaterialCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity appCompatActivity= (AppCompatActivity) v.getContext();
                appCompatActivity.getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,new mainFrag(model.getTitle().toString())).addToBackStack(null).commit();

            }
        });
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.genre_card_layout,parent,false);
        return new MainViewHolder(v);
    }

    public class MainViewHolder extends RecyclerView.ViewHolder{
        CircleImageView mImageView;
        TextView mTextView;
        MaterialCardView mMaterialCardView;
        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView=itemView.findViewById(R.id.imageGenre);
            mTextView =itemView.findViewById(R.id.genreHeadLine);
            mMaterialCardView=itemView.findViewById(R.id.quoteCard);


        }
    }
}
