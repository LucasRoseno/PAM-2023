package br.teste;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MeuAdapter extends RecyclerView.Adapter<MeuAdapter.MeuViewholder> {

    List<Contatos> lst;

    public MeuAdapter(List<Contatos> lst)
    {
        this.lst = lst;
    }

    public MeuViewholder onCreateViewHolder(ViewGroup parent,int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.meu_item_recycler, parent, false);
        return new MeuAdapter.MeuViewholder(view);
       // return new MeuAdapter.MeuViewholder(view);
    }

    @Override
    public void onBindViewHolder(MeuViewholder holder, int position) {
        holder.lblNome.setText(lst.get(position).getNome());
        holder.lblSobrenome.setText(lst.get(position).getSobrenome());
        holder.lblIdade.setText(lst.get(position).getIdade());
    }

    @Override
    public int getItemCount() {
        return lst.size();
    }

    public class MeuViewholder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView lblNome, lblSobrenome, lblIdade;

        public MeuViewholder(View itemView)
        {
            super(itemView);
            lblNome = itemView.findViewById(R.id.lblNome);
            lblSobrenome = itemView.findViewById(R.id.lblSobrenome);
            lblIdade = itemView.findViewById(R.id.lblIdade);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            lst.get(getAdapterPosition());
            Toast.makeText(itemView.getContext(),lblIdade.getText()+" ,"+lblNome.getText()+" "+lblSobrenome.getText(), Toast.LENGTH_SHORT).show();
        }
    }


}


