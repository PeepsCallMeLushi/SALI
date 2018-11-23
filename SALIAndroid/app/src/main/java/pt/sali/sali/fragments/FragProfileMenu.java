package pt.sali.sali.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.squareup.picasso.Picasso;

import androidx.fragment.app.FragmentTransaction;
import pt.sali.sali.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragProfileMenu extends Fragment {

    BottomNavigationView bottomNavigationView;



    public FragProfileMenu() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_frag_profile, container, false);

        bottomNavigationView = v.findViewById(R.id.av_fl_bnv);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_me:
                        if (bottomNavigationView.getSelectedItemId()!=R.id.navigation_me){
                            setFragment(new FragMyProfile());
                        }
                        return true;
                    case R.id.navigation_parceiro:
                        if (bottomNavigationView.getSelectedItemId()!=R.id.navigation_parceiro){
                            setFragment(new FragPartnerProfile());
                        }
                        return true;
                }
                return false;
            }
        });
        setFragment(new FragMyProfile());
        return v;
    }



    public void setFragment(Fragment fragment){
        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.av_fl_profile, fragment);
        ft.commit();
    }

}
