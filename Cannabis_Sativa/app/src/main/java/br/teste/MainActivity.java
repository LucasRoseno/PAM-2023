package br.teste;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    TextView txtMostrar;
    Button btnAdd, btnMostrar;
    EditText editNome;
    String lista;
    ArrayList<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtMostrar = findViewById(R.id.txtMostrar);
        btnAdd = findViewById(R.id.btnAdd);
        btnMostrar = findViewById(R.id.btnMostrar);
        editNome = findViewById(R.id.editNome);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.add(editNome.getText().toString());
                editNome.setText("");
            }
        });

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String x="";
                for(int i = 0; i < list.toArray().length;i++){
                  x =  x + list.get(i).toString() + "\n";
                }
                txtMostrar.setText(x);
            }
        });








    }
}