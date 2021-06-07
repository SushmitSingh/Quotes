package com.example.quotes.Home.slidetabs;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.quotes.Home.slidetabs.imagerecyclerOtherclasses.AdapterImageData;
import com.example.quotes.Home.slidetabs.imagerecyclerOtherclasses.ImageDataHandling;
import com.example.quotes.Letest.AdapterLetest;
import com.example.quotes.Letest.LetestDataHendle;
import com.example.quotes.R;
import com.example.quotes.databinding.FragmentImageStatusBinding;
import com.example.quotes.databinding.FragmentQuotesGenreBinding;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ImageStatus#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ImageStatus extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView recyclerView;
    private AdapterImageData adapter;


    public ImageStatus() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ImageStatus.
     */
    // TODO: Rename and change types and number of parameters



    private FragmentImageStatusBinding binding;

    public static ImageStatus newInstance(String param1, String param2) {
        ImageStatus fragment = new ImageStatus();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_image_status, container, false);
        // Inflate the layout for this fragment
        recyclerView = view.findViewById(R.id.ImagestatusrecyclerView);





        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        FirebaseRecyclerOptions<ImageDataHandling> options = new FirebaseRecyclerOptions.Builder<ImageDataHandling>()
                .setQuery(FirebaseDatabase.getInstance().getReference("image"), ImageDataHandling.class)

                .build();
        adapter = new AdapterImageData(options);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
//        binding = FragmentLatestFreagBinding.inflate(inflater,container,false);
//        View view=binding.getRoot();

        return view;
    }
    // Read from the database



    @Override
    public void onStart() {
        super.onStart();
        if (adapter != null) {
            adapter.startListening();
        }

    }

    @Override
    public void onStop() {
        super.onStop();
        if (adapter != null) {
            adapter.stopListening();
        }

    }



}