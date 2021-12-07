package com.example.quotes;

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

import com.airbnb.lottie.L;
import com.example.quotes.Home.slidetabs.ModelHeadlines;
import com.example.quotes.Letest.LetestDataHendle;
import com.example.quotes.Liked.AdapterLiked;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.button.MaterialButton;

public class mainFragAdapter extends FirebaseRecyclerAdapter<mainFragModel,mainFragAdapter.mainFragHolder> {
    Context mContext;

    public mainFragAdapter(@NonNull FirebaseRecyclerOptions<mainFragModel> options, Context context) {
        super(options);
        mContext = context;
    }
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public mainFragAdapter(@NonNull FirebaseRecyclerOptions<mainFragModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull mainFragHolder holder, int position, @NonNull mainFragModel model) {
        LetestDataHendle latest=new LetestDataHendle();
        holder.mTextView.setText(model.getTitle());
        holder.mMaterialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.mMaterialButton.setText(R.string.itemCopy);
                AppCompatActivity appCompatActivity= (AppCompatActivity) v.getContext();
                    ClipboardManager clipboardManager = (ClipboardManager) appCompatActivity.getSystemService(Context.CLIPBOARD_SERVICE);
                    ClipData clipData = (ClipData) ClipData.newPlainText("text", model.getTitle());
                    clipboardManager.setPrimaryClip(clipData);

                    Toast.makeText(appCompatActivity, "Quote Copied", Toast.LENGTH_SHORT).show();

            }
        });
        holder.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.share.setText(R.string.ShareItem);
                AppCompatActivity appCompatActivity= (AppCompatActivity) v.getContext();
                Intent i=new Intent(Intent.ACTION_SEND);
                i.setType("text/plane");
                i.putExtra(Intent.EXTRA_TEXT, model.getTitle());
              appCompatActivity.startActivity(i);

            }
        });
        holder.saveButton.setOnClickListener(new View.OnClickListener() {
            ModelHeadlines mModelHeadlines=new ModelHeadlines();
            @Override
            public void onClick(View v) {
                holder.saveButton.setText(R.string.saved);
                AppCompatActivity appCompatActivity= (AppCompatActivity) v.getContext();
                String res=new DBManager(appCompatActivity).addRecord(model.getTitle(),mModelHeadlines.getTitle());
                Toast.makeText(appCompatActivity, "Quote saved", Toast.LENGTH_SHORT).show();


            }
        });

    }

    @NonNull
    @Override
    public mainFragHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =  LayoutInflater.from(parent.getContext()).inflate(R.layout.mainfrag_card,parent,false);
        return new mainFragHolder(view);
    }

    class mainFragHolder extends RecyclerView.ViewHolder{
        TextView mTextView;
        MaterialButton mMaterialButton,share,saveButton;
        public mainFragHolder(@NonNull View itemView) {

            super(itemView);
            mTextView=itemView.findViewById(R.id.mainfragTxt);
            mMaterialButton =itemView.findViewById(R.id.copyMain);
            share =itemView.findViewById(R.id.mainShare);
            saveButton =itemView.findViewById(R.id.save);
        }
    }
}
