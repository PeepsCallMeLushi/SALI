package pt.sali.sali.fragments;


import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import pt.sali.sali.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragPageOne extends Fragment {

    CardView cardView;
    TextView textView;
    TimePicker timePicker;
    Calendar calendar;
    SimpleDateFormat simpleDateFormat;
    public FragPageOne() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_frag_page_one, container, false);
        cardView = v.findViewById(R.id.cv);
        textView = v.findViewById(R.id.tv);
        //timePicker = v.findViewById(R.id.tp);
        calendar = Calendar.getInstance();
        simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

        textView.setText(simpleDateFormat.format(calendar.getTime()));
//        timePicker.setIs24HourView(true);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createCalendarView();
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

    private void createCalendarView(){
        cardView.setCardBackgroundColor(getResources().getColor(R.color.colorAccent));
        textView.setVisibility(View.GONE);

        //Layout Params
        LinearLayout.LayoutParams layoutParams =new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(15,0,15,10);

        //Butões
        Button btAccept = new Button(getActivity().getApplicationContext());
        Button btCancel = new Button(getActivity().getApplicationContext());
        btAccept.setText("Submeter");
        btCancel.setText("Cancelar");
        btCancel.setBackground(getResources().getDrawable(R.drawable.button));
        btAccept.setBackground(getResources().getDrawable(R.drawable.button));
        btAccept.setLayoutParams(layoutParams);

        //Linear Layout com os butões
        LinearLayout linearLayoutButtons = new LinearLayout(getActivity().getApplicationContext());
        linearLayoutButtons.setOrientation(LinearLayout.HORIZONTAL);
        linearLayoutButtons.addView(btCancel);
        linearLayoutButtons.addView(btAccept);
        linearLayoutButtons.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        linearLayoutButtons.setGravity(Gravity.END);
        linearLayoutButtons.setPadding(0,0,10,10);

        //Calendário
        final CalendarView calendarView = new CalendarView(getActivity().getApplicationContext());

        //Linear Layout Com tudo
        final LinearLayout linearLayout = new LinearLayout(getActivity().getApplicationContext());
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.addView(calendarView);
        linearLayout.addView(linearLayoutButtons);
        cardView.addView(linearLayout);

        try{
            calendarView.setMaxDate(simpleDateFormat.parse(simpleDateFormat.format(calendar.getTime())).getTime());
            calendarView.setDate(simpleDateFormat.parse(textView.getText().toString()).getTime());
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

        btAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(simpleDateFormat.format(calendarView.getDate()));
                textView.setVisibility(View.VISIBLE);
                cardView.removeView(linearLayout);
                cardView.setCardBackgroundColor(Color.WHITE);
            }
        });

        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setVisibility(View.VISIBLE);
                cardView.removeView(linearLayout);
                cardView.setCardBackgroundColor(Color.WHITE);
            }
        });
    }

}
