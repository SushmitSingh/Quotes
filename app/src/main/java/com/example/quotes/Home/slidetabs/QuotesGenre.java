package com.example.quotes.Home.slidetabs;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import com.example.quotes.R;
import com.example.quotes.databinding.FragmentHomeBinding;
import com.example.quotes.databinding.FragmentQuotesGenreBinding;

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

    private FragmentQuotesGenreBinding binding;
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
        binding = FragmentQuotesGenreBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        thiscontext = container.getContext();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ModelHeadlinesArrayList = new ArrayList<>();
        ModelHeadlinesArrayList.add(new ModelHeadlines("Saddd", "Lets Continue", R.drawable.facebook));
        ModelHeadlinesArrayList.add(new ModelHeadlines("lobhh", "Here somethgig special", R.drawable.ghome));
        ModelHeadlinesArrayList.add(new ModelHeadlines("pata nhi", "Lets Continue", R.drawable.power));
        ModelHeadlinesArrayList.add(new ModelHeadlines("joiiii", "Lets Continue", R.drawable.heart));
        ModelHeadlinesArrayList.add(new ModelHeadlines("freidlyyyyy", "Here somethgig special", R.drawable.users));
        ModelHeadlinesArrayList.add(new ModelHeadlines("atttttitude", "Lets Continue", R.drawable.starfull));
        ModelHeadlinesArrayList.add(new ModelHeadlines("brokkken Hoert", "Here somethgig special", R.drawable.instagram));
        ModelHeadlinesArrayList.add(new ModelHeadlines("pata nhi", "Lets Continue", R.drawable.power));
        ModelHeadlinesArrayList.add(new ModelHeadlines("Saddd", "Lets Continue", R.drawable.facebook));
        ModelHeadlinesArrayList.add(new ModelHeadlines("lobhh", "Here somethgig special", R.drawable.ghome));


       // passing Array to adapterGenreRecycle

        AdapterGenreRecycle genreData= new AdapterGenreRecycle(thiscontext,ModelHeadlinesArrayList);

        //setting a layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(thiscontext, LinearLayoutManager.VERTICAL, false);

        binding.quoteGenreRV.setLayoutManager(linearLayoutManager);
        binding.quoteGenreRV.setAdapter(genreData);

    }
}