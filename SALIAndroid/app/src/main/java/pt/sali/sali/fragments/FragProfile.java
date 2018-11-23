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
public class FragProfile extends Fragment {


    public FragProfile() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_frag_profile, container, false);
        return v;
    }

}
