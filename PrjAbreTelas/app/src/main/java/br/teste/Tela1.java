package br.teste;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Tela1 extends AppCompatActivity {
    Button btnLog;
    EditText edtLogNome, edtLogSenha;
    List<String> mDados;
    ListView listV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1);

        edtLogNome = findViewById(R.id.edtLogNome);
        edtLogSenha = findViewById(R.id.edtLogSenha);
        btnLog = findViewById(R.id.btnLog);

        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mDados.size() > 0) {
                    Intent it = new Intent(getBaseContext(), Tela2.class);
                    startActivity(it);

                } else {
                    Toast.makeText(getBaseContext(), "CREDENCIAL INVALIDA", Toast.LENGTH_LONG).show();
                }

            }

        });


       class SincronismoHTTP extends AsyncTask<Void, Void, Void> {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();

            }

            @Override
            protected Void doInBackground(Void... params) {
                try {
                    ConexaoHTTP.conectarHttp("http://10.0.2.2/login.aspx?nome=" + edtLogNome.getText().toString() + "&fone=" + edtLogSenha.getText().toString());
                } catch (Exception e) {
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void vd) {
                super.onPostExecute(vd);


                mDados = ConexaoHTTP.getDados();


            }
       }
    }
}

