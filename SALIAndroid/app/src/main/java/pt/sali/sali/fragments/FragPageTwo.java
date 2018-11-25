package pt.sali.sali.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pt.sali.sali.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragPageTwo extends Fragment {


    public FragPageTwo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frag_page_two, container, false);
    }

    public static FragPageTwo newInstance() {
        
        Bundle args = new Bundle();
        
        FragPageTwo fragment = new FragPageTwo();
        fragment.setArguments(args);
        return fragment;
    }
}
