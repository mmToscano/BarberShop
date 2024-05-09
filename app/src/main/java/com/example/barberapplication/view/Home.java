package com.example.barberapplication.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.barberapplication.R;
import com.example.barberapplication.adapter.ServicosAdapter;
import com.example.barberapplication.databinding.ActivityHomeBinding;
import com.example.barberapplication.model.Servicos;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    private ActivityHomeBinding binding; //elemento que vai acessar os outros elementos da activity activity_home.xml
    private ServicosAdapter servicosAdapter;
    private ArrayList<Servicos> listaServicos = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        String nome = getIntent().getExtras() != null ? getIntent().getExtras().getString("nome") : null; //extra que a mainActivity mandou para aqui
        binding.txtNomeUsuario.setText("Bem vindo, " + nome);
        RecyclerView recyclerViewServicos = binding.recyclerViewServicos;
        recyclerViewServicos.setLayoutManager(new GridLayoutManager(this, 2));
        servicosAdapter = new ServicosAdapter(this, listaServicos);
        recyclerViewServicos.setHasFixedSize(true);
        recyclerViewServicos.setAdapter(servicosAdapter);
        getServicos();

        binding.buttonAgendar.setOnClickListener(view -> {
            Intent intent = new Intent(Home.this, Agendamento.class);
            intent.putExtra("nome", nome);
            startActivity(intent);
        });
    }

    //se esse app houvesse conexão com banco de dados, seria aqui que aconteceria a
    //conexão de fato. Seria aqui que estaria o "fetch"
    private void getServicos(){
        Servicos servico1 = new Servicos(R.drawable.img1, "Corte de cabelo");
        Servicos servico2 = new Servicos(R.drawable.img2, "Bigode");
        Servicos servico3 = new Servicos(R.drawable.img3, "Peruca");
        Servicos servico4 = new Servicos(R.drawable.img4, "Manicure");
        listaServicos.add(servico1);
        listaServicos.add(servico2);
        listaServicos.add(servico3);
        listaServicos.add(servico4);
    }
}