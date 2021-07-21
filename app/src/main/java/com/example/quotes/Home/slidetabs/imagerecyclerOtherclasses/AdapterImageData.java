package com.example.quotes.Home.slidetabs.imagerecyclerOtherclasses;

import android.Manifest;
import android.app.DownloadManager;
import android.content.ContentValues;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.quotes.Home.slidetabs.ImageStatus;
import com.example.quotes.Home.slidetabs.ModelHeadlines;
import com.example.quotes.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class AdapterImageData extends FirebaseRecyclerAdapter<ImageDataHandling,AdapterImageData.ImageHolder>{
    private static final int WRITE_EXTERNAL_STORAGE_CODE=1;
    DownloadManager manager;

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public AdapterImageData(@NonNull FirebaseRecyclerOptions<ImageDataHandling> options) {
        super(options);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onBindViewHolder(@NonNull ImageHolder holder, int position, @NonNull ImageDataHandling model) {
        holder.mTextView.setText(model.getTag());
        Glide.with(holder.mImageView.getContext()).load(model.getiUrl()).into(holder.mImageView);
        holder.mAppCompatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AppCompatActivity appCompatActivity= (AppCompatActivity) v.getContext();
                if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M)
                {
                    if(appCompatActivity.checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)== PackageManager.PERMISSION_DENIED){
                        String[] permission={Manifest.permission.WRITE_EXTERNAL_STORAGE};
                        appCompatActivity.requestPermissions(permission,WRITE_EXTERNAL_STORAGE_CODE);
                    }else{
//
                        String time=new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault())
                                .format(System.currentTimeMillis());
//
                        String imageName=model.getTag()+time+".jpg";
//
                        try{
                            DownloadManager dm = (DownloadManager) v.getContext().getSystemService(Context.DOWNLOAD_SERVICE);
                            Uri downloadUri = Uri.parse(model.getiUrl());
                            DownloadManager.Request request = new DownloadManager.Request(downloadUri);
                            request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE)
                                    .setAllowedOverRoaming(false)
                                    .setTitle(imageName)
                                    .setMimeType("image/jpeg") // Your file type. You can use this code to download other file types also.
                                    .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                                    .setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES,File.separator + imageName + ".jpg");
                            dm.enqueue(request);
                            Toast.makeText(v.getContext(), "Wooo!! Image downloaded...", Toast.LENGTH_SHORT).show();
                        }catch (Exception e){
                            Toast.makeText(v.getContext(), "OPS!! Image download failed.", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                holder.mAppCompatButton.setText(R.string.saved);

            }
        });
        holder.sharAppCompatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.sharAppCompatButton.setText(R.string.ShareItem);
                Drawable mDrawable = holder.mImageView.getDrawable();
                Bitmap mBitmap = ((BitmapDrawable) mDrawable).getBitmap();

                String path = MediaStore.Images.Media.insertImage(v.getContext().getContentResolver(), mBitmap, "Image Description", model.getiUrl()+"pls ownload Quotes App");
                Uri uri = Uri.parse(path);

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("image/jpeg");
                intent.putExtra(Intent.EXTRA_STREAM, uri);
                v.getContext().startActivity(Intent.createChooser(intent, "Share Image"));
            }
        });


    }



    @NonNull
    @Override
    public ImageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.image_card,parent,false);
      return new ImageHolder(v);
    }

    public class ImageHolder extends RecyclerView.ViewHolder{
        ImageView mImageView;
        TextView mTextView;
        AppCompatButton mAppCompatButton,sharAppCompatButton;
      public ImageHolder(@NonNull View itemView) {
          super(itemView);
          mImageView=itemView.findViewById(R.id.imageView);
          mTextView=itemView.findViewById(R.id.tagText);
            mAppCompatButton=itemView.findViewById(R.id.Download);
            sharAppCompatButton=itemView.findViewById(R.id.imageShare);


      }
  }
}
