package com.example.quotes.Populer;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import com.example.quotes.Home.slidetabs.imagerecyclerOtherclasses.ImageDataHandling;
import com.example.quotes.R;
import com.example.quotes.databinding.FragmentPopulerBinding;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PopulerFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PopulerFrag extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PopulerFrag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PopulerFrag.
     */
    // TODO: Rename and change types and number of parameters

    private  FragmentPopulerBinding binding;
    private ArrayList<DataHandlerPopular> quoteDataList;


    public static PopulerFrag newInstance(String param1, String param2) {
        PopulerFrag fragment = new PopulerFrag();
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
        binding = FragmentPopulerBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        quoteDataList = new ArrayList<>();
        quoteDataList.add(new DataHandlerPopular("ye Mere Hi shayri hai or han me Hi shayar Hun","wtf"));
        quoteDataList.add(new DataHandlerPopular("samle text written by sushmit singh wtf movement sooooo ","wtf"));
        quoteDataList.add(new DataHandlerPopular("ye Mere Hi shayri hai or han me Hi shayar Hun","wtf"));
        quoteDataList.add(new DataHandlerPopular("samle text written by sushmit singh wtf movement sooooo ","wtf"));
        quoteDataList.add(new DataHandlerPopular("ye Mere Hi shayri hai or han me Hi shayar Hun","wtf"));
        quoteDataList.add(new DataHandlerPopular("samle text written by sushmit singh wtf movement sooooo ","wtf"));
        quoteDataList.add(new DataHandlerPopular("ye Mere Hi shayri hai or han me Hi shayar Hun","wtf"));
        quoteDataList.add(new DataHandlerPopular("samle text written by sushmit singh wtf movement sooooo ","wtf"));
        quoteDataList.add(new DataHandlerPopular("ye Mere Hi shayri hai or han me Hi shayar Hun","wtf"));
        quoteDataList.add(new DataHandlerPopular("samle text written by sushmit singh wtf movement sooooo ","wtf"));
        quoteDataList.add(new DataHandlerPopular("ye Mere Hi shayri hai or han me Hi shayar Hun","wtf"));
        quoteDataList.add(new DataHandlerPopular("samle text written by sushmit singh wtf movement sooooo ","wtf"));
        quoteDataList.add(new DataHandlerPopular("ye Mere Hi shayri hai or han me Hi shayar Hun","wtf"));
        quoteDataList.add(new DataHandlerPopular("samle text written by sushmit singh wtf movement sooooo ","wtf"));
        quoteDataList.add(new DataHandlerPopular("ye Mere Hi shayri hai or han me Hi shayar Hun","wtf"));
        quoteDataList.add(new DataHandlerPopular("samle text written by sushmit singh wtf movement sooooo ","wtf"));
        quoteDataList.add(new DataHandlerPopular("ye Mere Hi shayri hai or han me Hi shayar Hun","wtf"));
        quoteDataList.add(new DataHandlerPopular("samle text written by sushmit singh wtf movement sooooo ","wtf"));
        quoteDataList.add(new DataHandlerPopular("ye Mere Hi shayri hai or han me Hi shayar Hun","wtf"));
        quoteDataList.add(new DataHandlerPopular("samle text written by sushmit singh wtf movement sooooo ","wtf"));
        quoteDataList.add(new DataHandlerPopular("ye Mere Hi shayri hai or han me Hi shayar Hun","wtf"));
        quoteDataList.add(new DataHandlerPopular("samle text written by sushmit singh wtf movement sooooo ","wtf"));
        quoteDataList.add(new DataHandlerPopular("ye Mere Hi shayri hai or han me Hi shayar Hun","wtf"));

        AdapterQuotesText aqt=new AdapterQuotesText(getContext(),quoteDataList);
        LinearLayoutManager lm=new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        binding.populerListView.setAdapter(aqt);
        binding.populerListView.setLayoutManager(lm);

        super.onViewCreated(view, savedInstanceState);
    }
}