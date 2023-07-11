package br.teste;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btn1,btnInserir, btnDeletar, btnUpdate;
    private ProgressDialog mProgressDialog;
    List<String> mDados;
    //ArrayList<String> listMostrar = new ArrayList<>();
    ListView listV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listV = findViewById(R.id.listV);
        btnDeletar = findViewById(R.id.btnDeletar);
        btn1 = findViewById(R.id.btnCarregar);
        btnInserir = findViewById(R.id.btnInserir);
        btnUpdate = findViewById(R.id.btnUpdate);

        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                new SincronismoHTTP().execute();
            }
        });
        btnInserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent it = new Intent(getBaseContext(),Tela2.class);
                startActivity(it);
            }
        });
        btnDeletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it2 = new Intent(getBaseContext(),DeletePag.class);
                startActivity(it2);
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it3 = new Intent(getBaseContext(),UpdatePage.class);
                startActivity(it3);
            }
        });
    }

    class SincronismoHTTP extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(MainActivity.this);
            mProgressDialog.setTitle("Sincronizando");
            mProgressDialog.setMessage("Buscando Dados...");
            mProgressDialog.setIcon(R.mipmap.ic_launcher_round);
            mProgressDialog.setCancelable(false);
            mProgressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params){
            try{
                ConexaoHTTP.conectarHttp("http://10.0.2.2/consulta.aspx");
            }
            catch (Exception e){}
            return null;
        }

        @Override
        protected void onPostExecute(Void vd){
            super.onPostExecute(vd);
            mDados = new ArrayList<String>();
            mDados = ConexaoHTTP.getDados();
            ArrayAdapter<String> adp = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_list_item_1,mDados);
            listV.setAdapter(adp);

         /*   Toast.makeText(getBaseContext(),mDados.get(0),Toast.LENGTH_LONG).show();*/
            mProgressDialog.dismiss();
        }



    }
}