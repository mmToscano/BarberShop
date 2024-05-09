package com.example.barberapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.barberapplication.databinding.ServicosItemBinding;
import com.example.barberapplication.model.Servicos;

import java.util.ArrayList;

public class ServicosAdapter extends RecyclerView.Adapter<ServicosAdapter.ServicosViewHolder> {

    private final Context context;
    private final ArrayList<Servicos> listaServicos;

    public ServicosAdapter(Context context, ArrayList<Servicos> listaServicos) {
        this.context = context;
        this.listaServicos = listaServicos;
    }


    @NonNull
    @Override
    public ServicosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ServicosItemBinding listItem;
        listItem = ServicosItemBinding.inflate(LayoutInflater.from(context), parent, false);
        return new ServicosViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ServicosViewHolder holder, int position) {
        holder.binding.imgServico.setImageResource(listaServicos.get(position).getImg());
        holder.binding.txtServico.setText(listaServicos.get(position).getNome());

    }

    @Override
    public int getItemCount() {
        return listaServicos.size();
    }

    public static class ServicosViewHolder extends RecyclerView.ViewHolder{

        ServicosItemBinding binding;

        public ServicosViewHolder(ServicosItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
