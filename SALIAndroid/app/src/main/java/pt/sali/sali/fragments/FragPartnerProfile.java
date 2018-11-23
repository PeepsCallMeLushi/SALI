package pt.sali.sali.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import pt.sali.sali.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragPartnerProfile extends Fragment {

    TextView tvNome, tvCedula, tvProf, tvEsp;
    ImageView ivImagem;
    Spinner spLista;


    public FragPartnerProfile() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_frag_partner_profile, container, false);
        tvNome = v.findViewById(R.id.tv_partner_nome);
        tvCedula = v.findViewById(R.id.tv_partner_id);
        tvProf = v.findViewById(R.id.tv_partner_prof);
        tvEsp = v.findViewById(R.id.tv_partner_esp);
        ivImagem = v.findViewById(R.id.iv_parner_image);
        spLista = v.findViewById(R.id.sp_partner_list);
        Picasso.get().load("https://api.adorable.io/avatars/128/ola+adeus").into(ivImagem);
        return v;
    }

}
