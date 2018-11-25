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
public class FragPageOne extends Fragment {


    public FragPageOne() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_frag_page_one, container, false);
    }

    public static FragPageOne newInstance() {
        
        Bundle args = new Bundle();
        
        FragPageOne fragment = new FragPageOne();
        fragment.setArguments(args);
        return fragment;
    }

}
