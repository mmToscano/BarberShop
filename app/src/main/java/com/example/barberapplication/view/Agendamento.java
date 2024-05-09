package com.example.barberapplication.view;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.TimePicker;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.barberapplication.R;
import com.example.barberapplication.databinding.ActivityAgendamentoBinding;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.Calendar;

public class Agendamento extends AppCompatActivity {

    private ActivityAgendamentoBinding binding;
    private Calendar calendar = Calendar.getInstance();
    private String data = "";
    private String hora = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAgendamentoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        String nome = getIntent().getExtras() != null ? getIntent().getExtras().getString("nome") : null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            binding.datePicker.setOnDateChangedListener((view, year, monthOfYear, dayOfMonth) -> {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, monthOfYear);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                String dia = String.valueOf(dayOfMonth);
                String mes;

                //serve para fica no padrão 00:00
                if (dayOfMonth < 10){
                    dia = "0" + dayOfMonth;
                }
                if(monthOfYear < 10){
                    mes = "" + (monthOfYear+1);
                }else{
                    mes = String.valueOf(monthOfYear+1);
                }

                data = dia + " / " + mes + " / " + year;
            });
        }

        binding.timePicker.setOnTimeChangedListener((view, hourOfDay, minute) -> {
            String minuto;

            //serve para fica no padrão 00:00
            if(minute < 10){
                minuto = "0" + minute;
            }else{
                minuto = String.valueOf(minute);
            }

            hora = hourOfDay + "; " + minuto;
        });
        binding.timePicker.setIs24HourView(true); //formato de 24 horas

        binding.buttonAgendar1.setOnClickListener(view -> {
            //Double horaEmDouble = Double.parseDouble(hora.replace(":", "."));
            CheckBox barbeiro1 = binding.barbeiro1;
            CheckBox barbeiro2 = binding.barbeiro2;
            CheckBox barbeiro3 = binding.barbeiro3;

            if(hora.isEmpty()){
                mensagem(view, "Preencha o horário", "#FF0000");
            }else

//            if(horaEmDouble < 8.0 && horaEmDouble > 19.0d){
//                mensagem(view, "Barbeiro indisponível - horário de atendimento: 08:00 às 19:00", "#FF0000");
//            }

            if(data.isEmpty()){
                mensagem(view, "Preencha a data", "#FF0000");
            }else if(barbeiro1.isChecked() && !data.isEmpty() && !hora.isEmpty()){
                mensagem(view, "Agendamento realizado com sucesso", "#FF03DAC5");
            }else if(barbeiro2.isChecked() && !data.isEmpty() && !hora.isEmpty()){
                mensagem(view, "Agendamento realizado com sucesso", "#FF03DAC5");
            } else if(barbeiro3.isChecked() && !data.isEmpty() && !hora.isEmpty()){
                mensagem(view, "Agendamento realizado com sucesso", "#FF03DAC5");
            }else {
                mensagem(view, "Escolha um barbeiro", "#FF0000");
            }
        });

    }

    private void mensagem(View view, String mensagem, String cor){
        Snackbar snackbar = Snackbar.make(view, mensagem, BaseTransientBottomBar.LENGTH_SHORT);
        snackbar.setBackgroundTint(Color.parseColor(cor));
        snackbar.setTextColor(Color.parseColor("#FFFFFF"));
        snackbar.show();
    }
}