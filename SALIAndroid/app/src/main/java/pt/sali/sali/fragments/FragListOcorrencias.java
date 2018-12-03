package pt.sali.sali.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import pt.sali.sali.AvOcorrencia;
import pt.sali.sali.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragListOcorrencias extends Fragment {

    Button btAddOcorrencia;


    public FragListOcorrencias() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_frag_list_ocorrencias, container, false);
        btAddOcorrencia = v.findViewById(R.id.bt_lista_ocorrencias_add);
        btAddOcorrencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity().getApplicationContext(), AvOcorrencia.class));
            }
        });
        return v;
    }

}
