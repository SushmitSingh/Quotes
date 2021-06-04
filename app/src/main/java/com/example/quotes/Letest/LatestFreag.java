package com.example.quotes.Letest;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.quotes.R;
import com.example.quotes.databinding.FragmentLatestFreagBinding;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LatestFreag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LatestFreag extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LatestFreag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LatestFreag.
     */
    // TODO: Rename and change types and number of parameters
    
   private FragmentLatestFreagBinding binding;
   private ArrayList<LetestDataHendle> quoteDataList;
    
    public static LatestFreag newInstance(String param1, String param2) {
        LatestFreag fragment = new LatestFreag();
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
        binding = FragmentLatestFreagBinding.inflate(inflater,container,false);
        View view=binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        quoteDataList = new ArrayList<>();
        quoteDataList.add(new LetestDataHendle("ye Mere Hi shayri hai or he Hi shayri hai or he Hi shayri hai or he Hi shayri hai or han me Hi shayar Hun","wtf"));
        quoteDataList.add(new LetestDataHendle("samle text written by sushmit singh wtf movement sooooo ","wtf"));
        quoteDataList.add(new LetestDataHendle("ye Mere Hi shayri hai ore Hi shayri hai or he Hi shayri hai or h han me Hi shayar Hun","wtf"));
        quoteDataList.add(new LetestDataHendle("samle text written by sushmit singh wtf movement sooooo ","wtf"));
        quoteDataList.add(new LetestDataHendle("ye Mere Hi shayri hai ore Hi shayri hai or he Hi shayri hai or h han me Hi shayar Hun","wtf"));
        quoteDataList.add(new LetestDataHendle("samle text written by sushmit singh wtf movement sooooo ","wtf"));
        quoteDataList.add(new LetestDataHendle("ye Mere Hi shayri hai or han me Hi shayar Hun","wtf"));
        quoteDataList.add(new LetestDataHendle("samle text written by sue Hi shayri hai or he Hi shayri hai or hshmit singh wtf movement sooooo ","wtf"));
        quoteDataList.add(new LetestDataHendle("ye Mere Hi shayri hai or han me Hi shayar Hun","wtf"));
        quoteDataList.add(new LetestDataHendle("samle text written by e Hi shayri hai or hsushmit singh wtf movement sooooo ","wtf"));
        quoteDataList.add(new LetestDataHendle("ye Mere Hi shayri hai or han me Hi shayar Hun","wtf"));
        quoteDataList.add(new LetestDataHendle("samle text written by se Hi shayri hai or hushmit singh wtf movement sooooo ","wtf"));
        quoteDataList.add(new LetestDataHendle("ye Mere Hi shayri hai or han me Hi shayar Hun","wtf"));
        quoteDataList.add(new LetestDataHendle("samle text written by sushme Hi shayri hai or hit singh wtf movement sooooo ","wtf"));
        quoteDataList.add(new LetestDataHendle("ye Mere Hi shayri hai or han me Hi shayar Hun","wtf"));
        quoteDataList.add(new LetestDataHendle("samle text written by sushmit singh wtf movement sooooo ","wtf"));
        quoteDataList.add(new LetestDataHendle("ye Mere Hi shayri hai or han me Hi shayar Hun","wtf"));
        quoteDataList.add(new LetestDataHendle("samle text written by sushmit singh wtf movement sooooo ","wtf"));
        quoteDataList.add(new LetestDataHendle("ye Mere Hi shayri hai or han me Hi shayar Hun","wtf"));
        quoteDataList.add(new LetestDataHendle("samle text written by sushmit singh wtf movement sooooo ","wtf"));
        quoteDataList.add(new LetestDataHendle("ye Mere Hi shayri hai or han me Hi shayar Hun","wtf"));
        quoteDataList.add(new LetestDataHendle("samle text written by sushmit singh wtf movement sooooo ","wtf"));
        quoteDataList.add(new LetestDataHendle("ye Mere Hi shayri hai or han me Hi shayar Hun","wtf"));

        LinearLayoutManager lm= new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        AdapterLetest adL= new AdapterLetest(quoteDataList,getContext());
        binding.LetestRV.setLayoutManager(lm);
        binding.LetestRV.setAdapter(adL);
        super.onViewCreated(view, savedInstanceState);

    }
}