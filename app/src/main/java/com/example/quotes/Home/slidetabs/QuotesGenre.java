package com.example.quotes.Home.slidetabs;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import com.example.quotes.R;
import com.example.quotes.databinding.FragmentHomeBinding;
import com.example.quotes.databinding.FragmentQuotesGenreBinding;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuotesGenre#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuotesGenre extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView recyclerView;
    private AdapterGenreRecycle adapter;
    public QuotesGenre() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment QuotesGenre.
     */
    // TODO: Rename and change types and number of parameters


    private ArrayList<ModelHeadlines> ModelHeadlinesArrayList;
    Context thiscontext;

    public static QuotesGenre newInstance(String param1, String param2) {
        QuotesGenre fragment = new QuotesGenre();
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
        View view = inflater.inflate(R.layout.fragment_quotes_genre, container, false);
        // Inflate the layout for this fragment
        recyclerView = view.findViewById(R.id.quoteGenreRV);





        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        FirebaseRecyclerOptions<ModelHeadlines> options = new FirebaseRecyclerOptions.Builder<ModelHeadlines>()
                .setQuery(FirebaseDatabase.getInstance().getReference("main"), ModelHeadlines.class)

                .build();
        adapter = new AdapterGenreRecycle(options);
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