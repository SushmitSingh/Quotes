package com.example.quotes;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link mainFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class mainFrag extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String quotes;
    private RecyclerView recyclerView;
    mainFragAdapter adapter;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public mainFrag() {
        // Required empty public constructor
    }

    public mainFrag(String quotes) {
        this.quotes=quotes;

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment mainFrag.
     */
    // TODO: Rename and change types and number of parameters
    public static mainFrag newInstance(String param1, String param2) {
        mainFrag fragment = new mainFrag();
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
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        // Inflate the layout for this fragment
        recyclerView = view.findViewById(R.id.mainFragRV);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        FirebaseRecyclerOptions<mainFragModel> options = new FirebaseRecyclerOptions.Builder<mainFragModel>()
                .setQuery(FirebaseDatabase.getInstance().getReference(quotes), mainFragModel.class)
                .build();
        adapter = new mainFragAdapter(options);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
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