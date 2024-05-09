package com.example.barberapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.barberapplication.databinding.ActivityMainBinding;
import com.example.barberapplication.view.Home;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater()); //basicamente cria uma instância binding da classe xml activity_main. Tem que ser escrito desta forma. É só para criar a instância mesmo. Sem segredo, eu acho.
        setContentView(binding.getRoot());

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        binding.buttonLogin.setOnClickListener(view -> {
           String nome = binding.editNome.getText().toString();
           String senha = binding.editSenha.getText().toString();

           if(nome.isEmpty()){
            mensagem(view, "Coloque seu nome");
           }else if(senha.isEmpty()){
               mensagem(view, "Coloque sua senha");
           } else if(senha.length() <= 5){
               mensagem(view, "A senha é muito curta");
           }else{
               navegarParaHome(nome);
           }
        });
    }
    //esse método será executado caso haja alguma exception na hora de cadastrar (usuário não colocou senha, nome ou a senha é curta)
    private void mensagem(View view, String mensagem){
        Snackbar snackbar = Snackbar.make(view, mensagem, BaseTransientBottomBar.LENGTH_SHORT);
        snackbar.setBackgroundTint(Color.parseColor("#FF0000"));
        snackbar.setTextColor(Color.parseColor("#FFFFFF"));
        snackbar.show();
    }

    //faz duas coisas: Navega para a Home e manda uma informação extra - nesse caso, o nome. Essa
    //info aparece no topo da tela.
    private void navegarParaHome(String nome){
        Intent intent = new Intent(MainActivity.this, Home.class); //muda de activity
        intent.putExtra("nome", nome);
        startActivity(intent);
    }
}