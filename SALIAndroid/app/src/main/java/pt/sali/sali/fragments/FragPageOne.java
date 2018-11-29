package pt.sali.sali.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

import com.google.android.material.textfield.TextInputEditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import androidx.recyclerview.widget.RecyclerView;
import pt.sali.sali.R;
import pt.sali.sali.model.Utente;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragPageOne extends Fragment {

    private final static int NENHUM =0, CHEGADA = 1, CAMINHO = 2, SAIDA = 3, ESTABLECIMENTO = 4, DISPONIVEL = 5;


    //Funcoes
    private Calendar calendar;
    private SimpleDateFormat simpleDateFormat;

    //Objectos do XML
    private CardView carvData,carvVeiculo, carvIncidente, carvHoras;
    private TextView tvData,
            tvVeiculoAtual;
    private Button btChegada, btCaminho, btSaida, btEstablecimento, btDisponivel, btCalAccept, btCalCancel, btVeiAccept, btVeiCancel,
            btHoras, btIncidentes,
            btInciAccept, btInciCancel,
            btChegadaAccept, btChegadaCancel,
            btCaminhoAccept, btCaminhoCancel,
            btSaidaAccept, btSaidaCancel,
            btEstablecimentoAccept, btEstablecimentoCancel,
            btDisponivelAccept, btDisponivelCancel;
    private TimePicker tpCaminho, tpChegada, tpSaida, tpEstablecimento,tpDisponivel;
    private CalendarView calendarView;
    private LinearLayout llCalendario, llVeiculo, llIncidentes, llHoras, llHorasCaminho, llHorasSaida, llHorasChegada,llHorasEstablecimento, llHorasDisponivel;
    private RadioButton rbAmbulancia, rbCarro, rbMota, rbNenhum;
    private CheckBox rbVeiDuasRodas, rbVeiLigeiro, rbMaqIndus, rbVeiPesa, rbComboio, rbVeiAgro, rbAtropel, rbQueda, rbArmaFogo, rbArmaBranca, rbSubmersao, rbQueima, rbIntox, rbParto, rbDoenca, rbOutra;
    private TextInputEditText etQueda, etOutra;

    public FragPageOne() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_frag_page_one, container, false);

        calendar = Calendar.getInstance();
        simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

        //Atribuções
        //Cardviews
        carvData = v.findViewById(R.id.carv_ocorrencia_data);
        carvVeiculo = v.findViewById(R.id.carv_ocorrencia_veiculo);
        carvIncidente = v.findViewById(R.id.carv_ocorrencia_incidente);
        carvHoras = v.findViewById(R.id.cardv_ocorrencia_horas);

        //TextViews
        tvData = v.findViewById(R.id.tv_ocorrencia_data);
        tvVeiculoAtual = v.findViewById(R.id.tv_ocorrencia_veiculo_atual);

        tvData.setText(simpleDateFormat.format(calendar.getTime()));

        //Buttons
        btCalAccept = v.findViewById(R.id.bt_ocorrencia_calendario_submeter);
        btCalCancel = v.findViewById(R.id.bt_ocorrencia_calendario_cancelar);
        btVeiAccept = v.findViewById(R.id.bt_ocorrencia_veiculo_submeter);
        btVeiCancel = v.findViewById(R.id.bt_ocorrencia_veiculo_cancelar);
        btChegada = v.findViewById(R.id.bt_ocorrencia_horasChegada);
        btCaminho = v.findViewById(R.id.bt_ocorrencia_horasCaminho);
        btSaida = v.findViewById(R.id.bt_ocorrencia_horasSaida);
        btEstablecimento = v.findViewById(R.id.bt_ocorrencia_horasEstabelecimento);
        btDisponivel = v.findViewById(R.id.bt_ocorrencia_horasDisponivel);
        btInciAccept = v.findViewById(R.id.bt_ocorrencia_incidente_submeter);
        btInciCancel = v.findViewById(R.id.bt_ocorrencia_incidente_cancelar);
        btChegadaAccept = v.findViewById(R.id.bt_ocorrencia_horasChegada_submeter);
        btChegadaCancel = v.findViewById(R.id.bt_ocorrencia_horasChegada_cancelar);
        btCaminhoAccept = v.findViewById(R.id.bt_ocorrencia_horasCaminho_submeter);
        btCaminhoCancel = v.findViewById(R.id.bt_ocorrencia_horasCaminho_cancelar);
        btSaidaAccept = v.findViewById(R.id.bt_ocorrencia_horasSaida_submeter);
        btSaidaCancel = v.findViewById(R.id.bt_ocorrencia_horasSaida_cancelar);
        btEstablecimentoAccept = v.findViewById(R.id.bt_ocorrencia_horasEstabelecimento_submeter);
        btEstablecimentoCancel = v.findViewById(R.id.bt_ocorrencia_horasEstabelecimento_cancelar);
        btDisponivelAccept = v.findViewById(R.id.bt_ocorrencia_horasDisponivel_submeter);
        btDisponivelCancel = v.findViewById(R.id.bt_ocorrencia_horasDisponivel_cancelar);
        btHoras = v.findViewById(R.id.bt_ocorrencia_horas);
        btIncidentes = v.findViewById(R.id.bt_ocorrencia_incidentes);

        //Radio Buttons
        rbAmbulancia = v.findViewById(R.id.rb_ocorrencia_veiculo_ambulancia);
        rbCarro = v.findViewById(R.id.rb_ocorrencia_veiculo_carro);
        rbMota = v.findViewById(R.id.rb_ocorrencia_veiculo_mota);
        rbNenhum = v.findViewById(R.id.rb_ocorrencia_veiculo_nenhum);

        //Check Box
        rbVeiDuasRodas = v.findViewById(R.id.rb_ocorrencia_incidente_veiduasrodas);
        rbVeiLigeiro = v.findViewById(R.id.rb_ocorrencia_incidente_veiligeiro);
        rbMaqIndus = v.findViewById(R.id.rb_ocorrencia_incidente_maqindus);
        rbVeiPesa = v.findViewById(R.id.rb_ocorrencia_incidente_veipesado);
        rbComboio = v.findViewById(R.id.rb_ocorrencia_incidente_comboio);
        rbVeiAgro = v.findViewById(R.id.rb_ocorrencia_incidente_veiagricula);
        rbAtropel = v.findViewById(R.id.rb_ocorrencia_incidente_atropelamento);
        rbQueda = v.findViewById(R.id.rb_ocorrencia_incidente_queda);
        rbArmaFogo = v.findViewById(R.id.rb_ocorrencia_incidente_armafogo);
        rbArmaBranca = v.findViewById(R.id.rb_ocorrencia_incidente_armabranca);
        rbSubmersao = v.findViewById(R.id.rb_ocorrencia_incidente_submersao);
        rbQueima = v.findViewById(R.id.rb_ocorrencia_incidente_queimadura);
        rbIntox = v.findViewById(R.id.rb_ocorrencia_incidente_intoxicacao);
        rbParto = v.findViewById(R.id.rb_ocorrencia_incidente_parto);
        rbDoenca = v.findViewById(R.id.rb_ocorrencia_incidente_doeca);
        rbOutra = v.findViewById(R.id.rb_ocorrencia_incidente_outra);

        //Edit Text
        etQueda = v.findViewById(R.id.et_ocorrencia_incidente_queda);
        etOutra = v.findViewById(R.id.et_ocorrencia_incidente_outro);

        //Layouts
        llCalendario = v.findViewById(R.id.ll_ocorrencia_date_picker);
        llVeiculo = v.findViewById(R.id.ll_ocorrencia_veiculos_opcoes);
        llIncidentes = v.findViewById(R.id.ll_ocorrencia_incidentes_opcoes);
        llHoras = v.findViewById(R.id.ll_ocorrencia_horas_opcoes);
        llHorasCaminho = v.findViewById(R.id.ll_ocorrencia_horasCaminho);
        llHorasChegada = v.findViewById(R.id.ll_ocorrencia_horasChegada);
        llHorasDisponivel = v.findViewById(R.id.ll_ocorrencia_horasDisponivel);
        llHorasEstablecimento = v.findViewById(R.id.ll_ocorrencia_horasEstablecimento);
        llHorasSaida = v.findViewById(R.id.ll_ocorrencia_horasSaida);

        //Calendar Views
        calendarView = v.findViewById(R.id.calv_ocorrencia_calendario);

        //Time Pickers
        tpCaminho = v.findViewById(R.id.tp_ocorrencia_horasCaminho);
        tpChegada = v.findViewById(R.id.tp_ocorrencia_horasChegada);
        tpSaida = v.findViewById(R.id.tp_ocorrencia_horasSaida);
        tpDisponivel = v.findViewById(R.id.tp_ocorrencia_horasDisponivel);
        tpEstablecimento = v.findViewById(R.id.tp_ocorrencia_horasEstablecimento);

        tpCaminho.setIs24HourView(true);
        tpChegada.setIs24HourView(true);
        tpSaida.setIs24HourView(true);
        tpEstablecimento.setIs24HourView(true);
        tpDisponivel.setIs24HourView(true);

        //On Click Listeners
        carvData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createCalendarView();
            }
        });
        carvVeiculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createVeiculoOptions();
            }
        });
        btIncidentes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (llIncidentes.getVisibility()==View.GONE){
                    createIncidenteOptions();
                } else {
                    llIncidentes.setVisibility(View.GONE);
                }

            }
        });
        btHoras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (llHoras.getVisibility()==View.GONE){
                    createHorasOptions();
                } else {
                    llHoras.setVisibility(View.GONE);
                    llHorasCaminho.setVisibility(View.GONE);
                    llHorasChegada.setVisibility(View.GONE);
                    llHorasDisponivel.setVisibility(View.GONE);
                    llHorasEstablecimento.setVisibility(View.GONE);
                    llHorasSaida.setVisibility(View.GONE);
                }

            }
        });

        return v;
    }

    public static FragPageOne newInstance() {
        
        Bundle args = new Bundle();
        
        FragPageOne fragment = new FragPageOne();
        fragment.setArguments(args);
        return fragment;
    }

    //Metodos
    private void createCalendarView(){
        carvVeiculo.setVisibility(View.GONE);
        tvData.setVisibility(View.GONE);
        llCalendario.setVisibility(View.VISIBLE);

        try{
            calendarView.setMaxDate(simpleDateFormat.parse(simpleDateFormat.format(calendar.getTime())).getTime());
            calendarView.setDate(simpleDateFormat.parse(tvData.getText().toString()).getTime());
        }  catch (ParseException e){

        }
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String s = String.valueOf(dayOfMonth)+"-"+String.valueOf(month+1)+"-"+String.valueOf(year);
                try{
                    view.setDate(simpleDateFormat.parse(s).getTime());
                }  catch (ParseException e){

                }
            }
        });

        btCalAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvData.setText(simpleDateFormat.format(calendarView.getDate()));
                tvData.setVisibility(View.VISIBLE);
                llCalendario.setVisibility(View.GONE);
                carvVeiculo.setVisibility(View.VISIBLE);
            }
        });

        btCalCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvData.setVisibility(View.VISIBLE);
                llCalendario.setVisibility(View.GONE);
                carvVeiculo.setVisibility(View.VISIBLE);
            }
        });
    }

    private void createVeiculoOptions(){
        carvData.setVisibility(View.GONE);
        tvVeiculoAtual.setVisibility(View.GONE);
        llVeiculo.setVisibility(View.VISIBLE);
        rbNenhum.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    if(buttonView.isChecked()){
                        rbAmbulancia.setChecked(false);
                        rbCarro.setChecked(false);
                        rbMota.setChecked(false);
                    }
                }
            }
        });
        rbAmbulancia.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    rbNenhum.setChecked(false);
                    rbCarro.setChecked(false);
                    rbMota.setChecked(false);

                }
            }
        });
        rbCarro.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    rbNenhum.setChecked(false);
                    rbAmbulancia.setChecked(false);
                    rbMota.setChecked(false);

                }
            }
        });
        rbMota.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    rbNenhum.setChecked(false);
                    rbCarro.setChecked(false);
                    rbAmbulancia.setChecked(false);

                }
            }
        });
        btVeiAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rbAmbulancia.isChecked()){
                    tvVeiculoAtual.setText("Veículo: Ambulancia");
                } else if(rbCarro.isChecked()){
                    tvVeiculoAtual.setText("Veículo: Carro");
                } else if (rbMota.isChecked()){
                    tvVeiculoAtual.setText("Veículo: Mota");
                } else if (rbNenhum.isChecked()){
                    tvVeiculoAtual.setText("Veículo: Sem Veículo");
                }
                tvVeiculoAtual.setVisibility(View.VISIBLE);
                llVeiculo.setVisibility(View.GONE);
                carvData.setVisibility(View.VISIBLE);
            }
        });
        btVeiCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvVeiculoAtual.setVisibility(View.VISIBLE);
                llVeiculo.setVisibility(View.GONE);
                carvData.setVisibility(View.VISIBLE);
            }
        });
    }

    private void createIncidenteOptions(){
        llIncidentes.setVisibility(View.VISIBLE);
        rbVeiDuasRodas.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });
        rbVeiLigeiro.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });
        rbMaqIndus.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });
        rbVeiPesa.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });
        rbComboio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });
        rbComboio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });
        rbVeiAgro.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });
        rbAtropel.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });
        rbQueda.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    etQueda.setEnabled(true);
                }else{
                    etQueda.setEnabled(false);
                    etQueda.getText().clear();
                }
            }
        });
        rbArmaFogo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });
        rbArmaBranca.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });
        rbSubmersao.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });
        rbQueima.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });
        rbIntox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });
        rbParto.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });
        rbDoenca.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });
        rbOutra.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    etOutra.setEnabled(true);
                }else{
                    etOutra.setEnabled(false);
                    etOutra.getText().clear();
                }

            }
        });
        btInciAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llIncidentes.setVisibility(View.GONE);
            }
        });
        btInciCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llIncidentes.setVisibility(View.GONE);
            }
        });
    }

    private void createHorasOptions(){
        llHoras.setVisibility(View.VISIBLE);
        btCaminho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                horasSelector(CAMINHO);
            }
        });
        btDisponivel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                horasSelector(DISPONIVEL);
            }
        });
        btChegada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                horasSelector(CHEGADA);
            }
        });
        btSaida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                horasSelector(SAIDA);
            }
        });
        btEstablecimento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                horasSelector(ESTABLECIMENTO);
            }
        });
    }

    private void horasSelector(int selector){
        switch (selector){
            case CHEGADA:{
                horasController(llHorasChegada, btChegadaAccept, btChegadaCancel);
                horasClose(llHorasDisponivel);
                horasClose(llHorasCaminho);
                horasClose(llHorasSaida);
                horasClose(llHorasEstablecimento);
                break;
            }
            case CAMINHO:{
                horasController(llHorasCaminho, btCaminhoAccept, btCaminhoCancel);
                horasClose(llHorasDisponivel);
                horasClose(llHorasChegada);
                horasClose(llHorasSaida);
                horasClose(llHorasEstablecimento);
                break;
            }
            case SAIDA:{
                horasController(llHorasSaida, btSaidaAccept, btSaidaCancel);
                horasClose(llHorasDisponivel);
                horasClose(llHorasCaminho);
                horasClose(llHorasChegada);
                horasClose(llHorasEstablecimento);
                break;
            }
            case ESTABLECIMENTO:{
                horasController(llHorasEstablecimento, btEstablecimentoAccept, btEstablecimentoCancel);
                horasClose(llHorasDisponivel);
                horasClose(llHorasCaminho);
                horasClose(llHorasSaida);
                horasClose(llHorasChegada);
                break;
            }
            case DISPONIVEL:{
                horasController(llHorasDisponivel, btDisponivelAccept, btDisponivelCancel);
                horasClose(llHorasChegada);
                horasClose(llHorasCaminho);
                horasClose(llHorasSaida);
                horasClose(llHorasEstablecimento);
                break;
            }
        }
    }

    private void horasController(final LinearLayout linearLayout, Button button1, Button button2){
        linearLayout.setVisibility(View.VISIBLE);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayout.setVisibility(View.GONE);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayout.setVisibility(View.GONE);
            }
        });
    }

    private void horasClose(LinearLayout linearLayout){
        linearLayout.setVisibility(View.GONE);
    }

    public class AAUtente extends RecyclerView.Adapter<AAUtente.VHUtente>{

        ArrayList<Utente> dataBank;

        public AAUtente(ArrayList<Utente> dataBank) {
            this.dataBank = dataBank;
        }

        @NonNull
        @Override
        public VHUtente onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_utentes, parent, false);
            return new VHUtente(v);
        }

        @Override
        public void onBindViewHolder(@NonNull VHUtente holder, int position) {

        }

        @Override
        public int getItemCount() {
            return dataBank.size();
        }

        public class VHUtente extends  RecyclerView.ViewHolder{
            public VHUtente(@NonNull View itemView) {
                super(itemView);
            }
        }
    }

}
