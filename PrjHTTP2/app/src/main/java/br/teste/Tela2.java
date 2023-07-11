package br.teste;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Tela2 extends AppCompatActivity {

    Button btnCadastrar;
    private ProgressDialog mProgressDialog;
    EditText edtNome, edtFone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);
        edtNome = findViewById(R.id.edtNome);
        edtFone = findViewById(R.id.edtFone);
        btnCadastrar = findViewById(R.id.btnCadastrar);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new SincronismoHTTP().execute();
            }
        });
    }

        private class SincronismoHTTP extends AsyncTask<Void, Void, Void> {
            @Override
            protected void onPreExecute(){
                super.onPreExecute();
                mProgressDialog = new ProgressDialog(Tela2.this);
                mProgressDialog.setTitle("Sincronizando");
                mProgressDialog.setMessage("Buscando Dados...");
                mProgressDialog.setIcon(R.mipmap.ic_launcher_round);
                mProgressDialog.setCancelable(false);
                mProgressDialog.show();
            }

            @Override
            protected Void doInBackground(Void... params){
                try{
                ConexaoHTTP.conectarHttp("http://10.0.2.2/inserir.aspx?nome="+edtNome.getText().toString()+"&fone="+edtFone.getText().toString());
               // mDados.add(edtNome + "," + edtFone);
                }
                catch (Exception e){}
                return null;
            }

            @Override
            protected void onPostExecute(Void vd){
                super.onPostExecute(vd);
                Toast.makeText(getBaseContext(),"foi, inserido com sucesso",Toast.LENGTH_LONG).show();
                mProgressDialog.dismiss();


    }
}
}