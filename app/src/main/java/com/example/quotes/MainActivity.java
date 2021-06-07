package com.example.quotes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.quotes.Home.HomeFrag;
import com.example.quotes.Letest.LatestFreag;
import com.example.quotes.Liked.LikedFrag;
import com.example.quotes.Populer.PopulerFrag;
import com.example.quotes.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
        trans.replace(R.id.framelayout,new HomeFrag());
        trans.commit();


        binding.bottamNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
                switch (item.getItemId()){
                    case R.id.home:
                        trans.replace(R.id.framelayout,new HomeFrag());
                        break;
                    case R.id.popular:
                        trans.replace(R.id.framelayout,new PopulerFrag());
                        break;
                    case R.id.latest:
                        trans.replace(R.id.framelayout,new LatestFreag());
                        break;
                    case R.id.liked:
                        trans.replace(R.id.framelayout,new LikedFrag());
                        break;
                }
                trans.commit();
                return true;

            }

        });


    }
    @Override
    public void onBackPressed() {
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
    }
}