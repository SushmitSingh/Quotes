package com.example.quotes.Liked;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.quotes.MainActivity;
import com.example.quotes.R;
import com.example.quotes.databinding.FragmentLikedBinding;

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
        private ArrayList<LikedDataHandle> dataList;
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
        // Inflate the layout for this fragment
        binding = FragmentLikedBinding.inflate(inflater,container,false);
        View view=binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        dataList = new ArrayList<>();
        dataList.add(new LikedDataHandle("this is super s is super cool textcool text and you bring it here because u like this peace of shit ","lamao text"));
        dataList.add(new LikedDataHandle("this is super cool ts is supes is super cool textr cool textext and you bring it here because u like this peace of shit ","lamao text"));
        dataList.add(new LikedDataHandle("this is super cool text and u bring it s is sause u like this peace of shit ","lamao text"));
        dataList.add(new LikedDataHandle("this is supes is super s per cool textyou bring it here because u like this peace of shit ","lamao text"));
        dataList.add(new LikedDataHandle("this is super coolol texttext and you bring it here because u like this peace of shit ","lamao text"));
        dataList.add(new LikedDataHandle("this is super cs is super cool textool texs s is super cool textis super cool textt and you bring it here because u like this peace of shit ","lamao text"));
        dataList.add(new LikedDataHandle("this is super cool text and you bring s is super cool textit here because u like this peace of shit ","lamao text"));
        dataList.add(new LikedDataHandle("this is super cools is super cool text text ans is super cool textd you bring it here because u like this peace of shit ","lamao text"));
        dataList.add(new LikedDataHandle("this is super cool text s is super cool textand you s is super cool textbring it here because u like this peace of shit ","lamao text"));
        dataList.add(new LikedDataHandle("this is super cool text and you bring it here because u like this peace of shit ","lamao text"));dataList.add(new LikedDataHandle("this is super cool text and u bring it s is sause u like this peace of shit ","lamao text"));
        dataList.add(new LikedDataHandle("this is supes is super s per cool textyou bring it here because u like this peace of shit ","lamao text"));
        dataList.add(new LikedDataHandle("this is super coolol texttext and you bring it here because u like this peace of shit ","lamao text"));
        dataList.add(new LikedDataHandle("this is super cs is super cool textool texs s is super cool textis super cool textt and you bring it here because u like this peace of shit ","lamao text"));
        dataList.add(new LikedDataHandle("this is super cool text and you bring s is super cool textit here because u like this peace of shit ","lamao text"));
        dataList.add(new LikedDataHandle("this is super cools is super cool text text ans is super cool textd you bring it here because u like this peace of shit ","lamao text"));
        dataList.add(new LikedDataHandle("this is super cool text s is super cool textand you s is super cool textbring it here because u like this peace of shit ","lamao text"));
        dataList.add(new LikedDataHandle("this is super cool text and you bring it here because u like this peace of shit ","lamao text"));


        LinearLayoutManager lm=new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        AdapterLiked adL=new AdapterLiked(getContext(),dataList);

        binding.likedRV.setLayoutManager(lm);
        binding.likedRV.setAdapter(adL);
        super.onViewCreated(view, savedInstanceState);
    }
}