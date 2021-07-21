package com.example.quotes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.quotes.Home.HomeFrag;
import com.example.quotes.Home.slidetabs.QuotesGenre;
import com.example.quotes.Letest.LatestFreag;
import com.example.quotes.Liked.LikedFrag;
import com.example.quotes.Populer.PopulerFrag;
import com.example.quotes.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
 private Integer backToExitPressedCounter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        checkConnection();
        FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
        trans.replace(R.id.framelayout,new HomeFrag());
        trans.commit();


        binding.bottamNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
                switch (item.getItemId()){
                    case R.id.home:
                        checkConnection();
                        trans.replace(R.id.framelayout,new HomeFrag());
                        break;
                    case R.id.popular:
                        checkConnection();
                        trans.replace(R.id.framelayout,new PopulerFrag());
                        break;
                    case R.id.latest:
                        checkConnection();
                        trans.replace(R.id.framelayout,new LatestFreag());
                        break;
                    case R.id.liked:
                        checkConnection();
                        trans.replace(R.id.framelayout,new LikedFrag());
                        break;
                }
                trans.commit();
                return true;

            }

        });


    }
    public  void checkConnection(){
        ConnectivityManager manager=(ConnectivityManager) getApplicationContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activtNet=manager.getActiveNetworkInfo();
        if(null!=activtNet)
        {
            if(activtNet.getType()==ConnectivityManager.TYPE_WIFI){
                Toast.makeText(this, "wifi enabled", Toast.LENGTH_SHORT).show();
            }
            else if(activtNet.getType()==ConnectivityManager.TYPE_MOBILE){
                Toast.makeText(this, "data network enabled", Toast.LENGTH_SHORT).show();
            }


        } else {
            Toast.makeText(this, "please connect to internet!!", Toast.LENGTH_SHORT).show();

        }
    }
    @Override
    public void onBackPressed() {
        if(backToExitPressedCounter==2){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("EXIT");
            builder.setMessage("Are You Sure Want to Exit?")
                    .setNegativeButton("No", null)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finishAffinity();
                        }
                    }).show();
        } else {
            binding.bottamNav.getMenu().getItem(0).setChecked(true);
            FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
            trans.replace(R.id.framelayout,new QuotesGenre());
            trans.commit();
            backToExitPressedCounter++;
            Toast.makeText(this, "Double Press to exit", Toast.LENGTH_SHORT).show();
        }


    }

}