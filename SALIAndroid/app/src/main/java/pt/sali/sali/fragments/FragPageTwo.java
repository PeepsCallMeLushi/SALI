package pt.sali.sali.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import pt.sali.sali.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragPageTwo extends Fragment {

    Button btAddEstado;


    public FragPageTwo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_frag_page_two, container, false);
        btAddEstado = v.findViewById(R.id.bt_utente_adicionar_estado);

        btAddEstado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragEstados fragEstados = new FragEstados();
                fragEstados.show(getActivity().getSupportFragmentManager(), fragEstados.getTag());
            }
        });

        return v;
    }

    public static FragPageTwo newInstance() {
        
        Bundle args = new Bundle();
        
        FragPageTwo fragment = new FragPageTwo();
        fragment.setArguments(args);
        return fragment;
    }
}
