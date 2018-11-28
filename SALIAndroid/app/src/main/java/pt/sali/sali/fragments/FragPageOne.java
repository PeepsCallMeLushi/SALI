package pt.sali.sali.fragments;


import android.opengl.Visibility;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Switch;
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
    private TextView tvData, tvCalAccept, tvCalCancel,
            tvVeiculoAtual,  tvVeiAccept, tvVeiCancel,
            tvInciAccept, tvInciCancel,
            tvChegada, tvChegadaAccept, tvChegadaCancel,
            tvCaminho, tvCaminhoAccept, tvCaminhoCancel,
            tvSaida, tvSaidaAccept, tvSaidaCancel,
            tvEstablecimento, tvEstablecimentoAccept, tvEstablecimentoCancel,
            tvDisponivel, tvDisponivelAccept, tvDisponivelCancel;
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
        tvCalAccept = v.findViewById(R.id.tv_ocorrencia_calendario_submeter);
        tvCalCancel = v.findViewById(R.id.tv_ocorrencia_calendario_cancelar);
        tvVeiculoAtual = v.findViewById(R.id.tv_ocorrencia_veiculo_atual);
        tvVeiAccept = v.findViewById(R.id.tv_ocorrencia_veiculo_submeter);
        tvVeiCancel = v.findViewById(R.id.tv_ocorrencia_veiculo_cancelar);
        tvInciAccept = v.findViewById(R.id.tv_ocorrencia_incidente_submeter);
        tvInciCancel = v.findViewById(R.id.tv_ocorrencia_incidente_cancelar);
        tvChegada = v.findViewById(R.id.tv_ocorrencia_horasChegada);
        tvChegadaAccept = v.findViewById(R.id.tv_ocorrencia_horasChegada_submeter);
        tvChegadaCancel = v.findViewById(R.id.tv_ocorrencia_horasChegada_cancelar);
        tvCaminho = v.findViewById(R.id.tv_ocorrencia_horasCaminho);
        tvCaminhoAccept = v.findViewById(R.id.tv_ocorrencia_horasCaminho_submeter);
        tvCaminhoCancel = v.findViewById(R.id.tv_ocorrencia_horasCaminho_cancelar);
        tvSaida = v.findViewById(R.id.tv_ocorrencia_horasSaida);
        tvSaidaAccept = v.findViewById(R.id.tv_ocorrencia_horasSaida_submeter);
        tvSaidaCancel = v.findViewById(R.id.tv_ocorrencia_horasSaida_cancelar);
        tvEstablecimento = v.findViewById(R.id.tv_ocorrencia_horasEstabelecimento);
        tvEstablecimentoAccept = v.findViewById(R.id.tv_ocorrencia_horasEstabelecimento_submeter);
        tvEstablecimentoCancel = v.findViewById(R.id.tv_ocorrencia_horasEstabelecimento_cancelar);
        tvDisponivel = v.findViewById(R.id.tv_ocorrencia_horasDisponivel);
        tvDisponivelAccept = v.findViewById(R.id.tv_ocorrencia_horasDisponivel_submeter);
        tvDisponivelCancel = v.findViewById(R.id.tv_ocorrencia_horasDisponivel_cancelar);

        tvData.setText(simpleDateFormat.format(calendar.getTime()));

        //calendários
        calendarView = v.findViewById(R.id.calv_ocorrencia_calendario);

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
        carvIncidente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createIncidenteOptions();
            }
        });
        carvHoras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (llHoras.getVisibility()==View.GONE){
                    createHorasOptions();
                } else {
                    llHoras.setVisibility(View.GONE);
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

        tvCalAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvData.setText(simpleDateFormat.format(calendarView.getDate()));
                tvData.setVisibility(View.VISIBLE);
                llCalendario.setVisibility(View.GONE);
                carvVeiculo.setVisibility(View.VISIBLE);
            }
        });

        tvCalCancel.setOnClickListener(new View.OnClickListener() {
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
        tvVeiAccept.setOnClickListener(new View.OnClickListener() {
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
        tvVeiCancel.setOnClickListener(new View.OnClickListener() {
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
        tvInciAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llIncidentes.setVisibility(View.GONE);
            }
        });
        tvInciCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llIncidentes.setVisibility(View.GONE);
            }
        });
    }

    private void createHorasOptions(){
        llHoras.setVisibility(View.VISIBLE);
        tvCaminho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                horasSelector(CAMINHO);
            }
        });
        tvDisponivel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                horasSelector(DISPONIVEL);
            }
        });
        tvChegada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                horasSelector(CHEGADA);
            }
        });
        tvSaida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                horasSelector(SAIDA);
            }
        });
        tvEstablecimento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                horasSelector(ESTABLECIMENTO);
            }
        });
    }

    private void horasSelector(int selector){
        switch (selector){
            case CHEGADA:{
                horasController(llHorasChegada, tvChegadaAccept, tvChegadaCancel);
                horasClose(llHorasDisponivel);
                horasClose(llHorasCaminho);
                horasClose(llHorasSaida);
                horasClose(llHorasEstablecimento);
                break;
            }
            case CAMINHO:{
                horasController(llHorasCaminho, tvCaminhoAccept, tvCaminhoCancel);
                horasClose(llHorasDisponivel);
                horasClose(llHorasChegada);
                horasClose(llHorasSaida);
                horasClose(llHorasEstablecimento);
                break;
            }
            case SAIDA:{
                horasController(llHorasSaida, tvSaidaAccept, tvSaidaCancel);
                horasClose(llHorasDisponivel);
                horasClose(llHorasCaminho);
                horasClose(llHorasChegada);
                horasClose(llHorasEstablecimento);
                break;
            }
            case ESTABLECIMENTO:{
                horasController(llHorasEstablecimento, tvEstablecimentoAccept, tvEstablecimentoCancel);
                horasClose(llHorasDisponivel);
                horasClose(llHorasCaminho);
                horasClose(llHorasSaida);
                horasClose(llHorasChegada);
                break;
            }
            case DISPONIVEL:{
                horasController(llHorasDisponivel, tvDisponivelAccept, tvDisponivelCancel);
                horasClose(llHorasChegada);
                horasClose(llHorasCaminho);
                horasClose(llHorasSaida);
                horasClose(llHorasEstablecimento);
                break;
            }
        }
    }

    private void horasController(final LinearLayout linearLayout, TextView textView1, TextView textView2){
        linearLayout.setVisibility(View.VISIBLE);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayout.setVisibility(View.GONE);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
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
