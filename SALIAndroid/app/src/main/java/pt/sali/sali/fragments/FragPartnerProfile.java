package pt.sali.sali.fragments;


import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import pt.sali.sali.AppSali;
import pt.sali.sali.R;
import pt.sali.sali.model.Utilizador;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragPartnerProfile extends Fragment {

    TextView tvNome, tvCedula, tvProf, tvEsp;
    ImageView ivImagem;
    Toolbar toolbar;
    AppSali mApp;


    public FragPartnerProfile() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_frag_partner_profile, container, false);
        mApp = (AppSali) getActivity().getApplication();
        tvNome = v.findViewById(R.id.tv_partner_nome);
        tvCedula = v.findViewById(R.id.tv_partner_id);
        tvProf = v.findViewById(R.id.tv_partner_prof);
        tvEsp = v.findViewById(R.id.tv_partner_esp);
        ivImagem = v.findViewById(R.id.iv_parner_image);
        toolbar = getActivity().findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.menu_spinner);


        MenuItem item = toolbar.getMenu().findItem(R.id.toolbar_spinner);
        final Spinner spinner = (Spinner) item.getActionView();
        ArrayList<String> arUsers = new ArrayList<>();
        arUsers.add("Escolha o seu parceiro parceiro...");
        for (Utilizador u : mApp.getArUtilizadores()){
                arUsers.add(u.getNome());

        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_spinner_item, arUsers){
            @Override
            public boolean isEnabled(int position) {
                if (position == 0){
                    return false;
                }else {
                    return true;
                }
            }

            @Override
            public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view =  super.getDropDownView(position, convertView, parent);
                view.setBackgroundColor(Color.WHITE);
                TextView tv = (TextView) view;
                tv.setTextSize(20);
                if (position == 0 ){
                    tv.setTextColor(Color.GRAY);
                }else {
                    tv.setTextColor(Color.BLACK);
                    tv.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
                }
                return view;
            }

        };

        spinner.setAdapter(adapter);
        spinner.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView tv = (TextView) view;
                tv.setTextColor(Color.WHITE);
                if (position!=0) {
                    mApp.setParceiro(mApp.getArUtilizadores().get(position - 1));
                    tvNome.setText(mApp.getParceiro().getNome());
                    tvCedula.setText(mApp.getParceiro().getIdentificador());
                    tvProf.setText(mApp.getParceiro().getRole().getNome());
                    tvEsp.setText(mApp.getParceiro().getEspecializacao());
                    Log.e("ola", "onItemSelected: Nothing selected");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                spinner.setSelection(0);

            }
        });
        //Picasso.get().load("https://api.adorable.io/avatars/128/123").into(ivImagem);
        return v;
    }
}
