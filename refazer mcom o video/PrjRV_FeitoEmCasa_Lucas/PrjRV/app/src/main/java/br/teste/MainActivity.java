package br.teste;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    MeuAdapter adapter;
    List<Contatos> lstContatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        lstContatos = new ArrayList<>();
        lstContatos.add(new Contatos("Teste1","T1","21"));
        lstContatos.add(new Contatos("Teste2","T2","21"));
        lstContatos.add(new Contatos("Teste3","T3","23"));
        lstContatos.add(new Contatos("Teste4","T4","24"));

        adapter = new MeuAdapter(lstContatos);
        recyclerView.setAdapter(adapter);
    }
}