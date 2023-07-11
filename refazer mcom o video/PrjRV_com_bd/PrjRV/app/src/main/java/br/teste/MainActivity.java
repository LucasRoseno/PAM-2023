package br.teste;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    MeuAdapter adapter;
    List<Contatos> lstContatos;
    List<String> mDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        new SincronismoHTTP().execute();





      /*  lstContatos.add(new Contatos("Teste1","T1","21"));
        lstContatos.add(new Contatos("Teste2","T2","21"));
        lstContatos.add(new Contatos("Teste3","T3","23"));
        lstContatos.add(new Contatos("Teste4","T4","24"));
*/
      //  adapter = new MeuAdapter(lstContatos);
      //  recyclerView.setAdapter(adapter);
    }

    class SincronismoHTTP extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                ConexaoHTTP.conectarHttp("http://10.0.2.2/consulta.aspx");
            } catch (Exception e) {
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void vd) {
            super.onPostExecute(vd);
           // mDados = new ArrayList<String>();
            mDados = ConexaoHTTP.getDados();
            lstContatos = new ArrayList<>();

            for (int i = 0; i < mDados.size(); i++) {
                String dadobd = mDados.get(i);
                String[] convDadobd = dadobd.split(",");
                lstContatos.add(new Contatos(
                        convDadobd[1],
                        convDadobd[2],
                        convDadobd[0]
                ));
            }
            adapter = new MeuAdapter(lstContatos);
            recyclerView.setAdapter(adapter);



        }
    }
}


