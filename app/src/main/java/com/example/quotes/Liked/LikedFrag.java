package com.example.quotes.Liked;

import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.airbnb.lottie.L;
import com.example.quotes.DBManager;
import com.example.quotes.Letest.AdapterLetest;
import com.example.quotes.Letest.LetestDataHendle;
import com.example.quotes.MainActivity;
import com.example.quotes.R;
import com.example.quotes.databinding.FragmentLikedBinding;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LikedFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LikedFrag extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private RecyclerView recyclerView;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LikedFrag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LikedFrag.
     */
    // TODO: Rename and change types and number of parameters

        private FragmentLikedBinding binding;
         ArrayList<LikedDataHandle> dataList=new ArrayList<>();
    LikedDataHandle obj;
    public static LikedFrag newInstance(String param1, String param2) {
        LikedFrag fragment = new LikedFrag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_liked, container, false);

        // Inflate the layout for this fragment
        recyclerView = view.findViewById(R.id.likedRV);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        Cursor cursor= new DBManager(getContext()).readAllData();
        while (cursor.moveToNext()){
             obj=new LikedDataHandle(cursor.getString(1),cursor.getString(2));
            dataList.add(obj);
        }
        AdapterLiked adapterLiked=new AdapterLiked(dataList);
        recyclerView.setAdapter(adapterLiked);

        return view;
    }
    // Read from the database


}