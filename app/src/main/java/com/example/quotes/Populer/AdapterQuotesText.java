package com.example.quotes.Populer;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quotes.DBManager;
import com.example.quotes.Letest.AdapterLetest;
import com.example.quotes.Letest.LetestDataHendle;
import com.example.quotes.R;
import com.example.quotes.mainFrag;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

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
    protected void onBindViewHolder(@NonNull LetestHolder holder, int position, @NonNull LetestDataHendle model) {
     holder.popularText.setText(model.getTitle());
        holder.mMaterialTextView.setText(model.getTag());
        holder.mMaterialTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity appCompatActivity= (AppCompatActivity) v.getContext();
                appCompatActivity.getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,new mainFrag(model.getTag())).addToBackStack(null).commit();
            }
        });
        holder.mMaterialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.mMaterialButton.setText(R.string.itemCopy);
                holder.mMaterialButton.setSoundEffectsEnabled(true);
                AppCompatActivity appCompatActivity= (AppCompatActivity) v.getContext();
                ClipboardManager clipboardManager = (ClipboardManager) appCompatActivity.getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = (ClipData) ClipData.newPlainText("text", model.getTitle());
                clipboardManager.setPrimaryClip(clipData);

                Toast.makeText(appCompatActivity, "Quote Copied", Toast.LENGTH_SHORT).show();

            }
        });
        holder.saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.saveButton.setText(R.string.saved);
                AppCompatActivity appCompatActivity= (AppCompatActivity) v.getContext();
                String res=new DBManager(appCompatActivity).addRecord(model.getTitle(),model.getTag());
                Toast.makeText(appCompatActivity, "Quote saved", Toast.LENGTH_SHORT).show();


            }
        });
        holder.sMaterialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.sMaterialButton.setText(R.string.ShareItem);
       AppCompatActivity appCompatActivity= (AppCompatActivity) v.getContext();
                Intent i=new Intent(Intent.ACTION_SEND);
                i.setType(model.getTag());
                i.putExtra(Intent.EXTRA_TEXT, model.getTitle());
                appCompatActivity.startActivity(i);

            }
        });

    }


    @NonNull
    @Override
    public LetestHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate( R.layout.popular_latest_saved_card_layout,parent,false);
        return new LetestHolder(view);
    }

    class LetestHolder extends RecyclerView.ViewHolder{
        TextView popularText;
        MaterialButton mMaterialTextView;
        MaterialButton mMaterialButton;
        MaterialButton sMaterialButton;
        MaterialButton saveButton;


        public LetestHolder(@NonNull View itemView) {
            super(itemView);
            popularText=itemView.findViewById(R.id.quoteTextView);
            mMaterialTextView=itemView.findViewById(R.id.tagTextView);
            mMaterialButton=itemView.findViewById(R.id.copy);
            sMaterialButton=itemView.findViewById(R.id.share);
            saveButton=itemView.findViewById(R.id.save);


        }
    }

}
