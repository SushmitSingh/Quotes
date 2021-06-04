package com.example.quotes.Populer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.quotes.R;

import java.util.List;

public class AdapterQuotesText extends RecyclerView.Adapter<AdapterQuotesText.ViewHolder> {
    private Context context;
    private List<DataHandlerPopular> dataList;

    public AdapterQuotesText(Context context, List<DataHandlerPopular> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public AdapterQuotesText.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_latest_saved_card_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            DataHandlerPopular dbHandle = dataList.get(position);
            holder.quoteText.setText(dbHandle.getQuote());
            holder.qouteTag.setText(dbHandle.getTagType());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView quoteText,qouteTag;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            quoteText = itemView.findViewById(R.id.quoteTextView);
            qouteTag = itemView.findViewById(R.id.tagTextView);

        }
    }
}
