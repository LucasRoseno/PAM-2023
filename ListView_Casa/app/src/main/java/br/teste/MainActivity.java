package br.teste;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnCadastro, btnMostrar;
    EditText edtNome;
    ListView listView;
    List<String> lstNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    btnCadastro = findViewById(R.id.btnCadastro);
    btnMostrar = findViewById(R.id.btnMostrar);
    edtNome = findViewById(R.id.edtNome);
    listView = findViewById(R.id.listView);
    lstNome = new ArrayList<>();

    btnCadastro.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
        String nom = edtNome.getText().toString();
        lstNome.add(nom);
        edtNome.setText("");
        }
    });

    btnMostrar.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            String x = "";
            for(int i=0; i<lstNome.toArray().length;i++){
                x = x + lstNome.get(i).toString();
            }
            ArrayAdapter<String>adpN = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_list_item_1,lstNome);

            listView.setAdapter(adpN);

        }
    });


    }
}