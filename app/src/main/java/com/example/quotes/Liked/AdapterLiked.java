package com.example.quotes.Liked;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.example.quotes.DBManager;
import com.example.quotes.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;
import java.util.ArrayList;
public class AdapterLiked extends RecyclerView.Adapter<AdapterLiked.savedHolder>{

    ArrayList<LikedDataHandle> dataholder;

    public AdapterLiked(ArrayList<LikedDataHandle> dataholder) {
        this.dataholder=dataholder;
    }

    @NonNull
    @Override
    public savedHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_card,parent,false);
        return new savedHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull savedHolder holder, int position) {
        holder.tMaterialTextView.setText(dataholder.get(position).getTag());
            holder.mMaterialTextView.setText(dataholder.get(position).getQuote());

        holder.removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.removeButton.setText(R.string.RemoveItem);
                AppCompatActivity appCompatActivity= (AppCompatActivity) v.getContext();
                new DBManager(appCompatActivity).deleteOnerecord(dataholder.get(position).getQuote());
                Toast.makeText(appCompatActivity, "Quote Deleted", Toast.LENGTH_SHORT).show();
                dataholder.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, dataholder.size());
            }

        });

        holder.shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.shareButton.setText(R.string.ShareItem);
                AppCompatActivity appCompatActivity= (AppCompatActivity) v.getContext();
                Intent i=new Intent(Intent.ACTION_SEND);
                i.setType("text/plane");
                i.putExtra(Intent.EXTRA_TEXT, dataholder.get(position).getQuote());
                appCompatActivity.startActivity(i);

            }
        });
        holder.copyButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                holder.copyButton.setText(R.string.itemCopy);
                AppCompatActivity appCompatActivity= (AppCompatActivity) v.getContext();
                ClipboardManager clipboardManager = (ClipboardManager) appCompatActivity.getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = (ClipData) ClipData.newPlainText("text", dataholder.get(position).getQuote());
                clipboardManager.setPrimaryClip(clipData);
                Toast.makeText(appCompatActivity, "Quote Copied", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return dataholder.size();
    }

    class savedHolder extends RecyclerView.ViewHolder{
        MaterialTextView mMaterialTextView,tMaterialTextView;
        MaterialButton copyButton,shareButton,removeButton;
        public savedHolder(@NonNull View itemView) {
            super(itemView);
            mMaterialTextView=itemView.findViewById(R.id.mainfragTxt);
            tMaterialTextView=itemView.findViewById(R.id.materialTextView2);
            copyButton=itemView.findViewById(R.id.likedCopy);
            shareButton=itemView.findViewById(R.id.likedShare);
            removeButton=itemView.findViewById(R.id.likedremove);

                }
    }
}

