package br.teste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
        EditText edtNome;
        Button btnCadastrar, btnMostrar;
        Compartilha cp = new Compartilha();
		List<String> lstDados;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNome = findViewById(R.id.edtNome);
        btnCadastrar = findViewById(R.id.btnCadastrar);
        btnMostrar = findViewById(R.id.btnMostrar);
		
		lstDados = new ArrayList<String>();

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent it = new Intent(getBaseContext(),TelaMostrar.class);
                startActivity(it);
            }
        });

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = edtNome.getText().toString();
				lstDados.add(nome);
                cp.setList(lstDados);
                edtNome.setText("");
            }
        });

    }
}