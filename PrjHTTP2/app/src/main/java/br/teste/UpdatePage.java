package br.teste;

import androidx.appcompat.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdatePage extends AppCompatActivity {
    EditText edtNomeUp, edtFoneUp, edtIdUp;
    Button btnUpdateUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_page);

       edtFoneUp = findViewById(R.id.edtFoneUp);
       edtIdUp = findViewById(R.id.edtIdUp);
       edtNomeUp = findViewById(R.id.edtNomeUp);
       btnUpdateUp = findViewById(R.id.btnUpdateUp);

       btnUpdateUp.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
             new SincronismoHTTP().execute();
           }
       });


    }
    private class SincronismoHTTP extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params){
            try{
                ConexaoHTTP.conectarHttp("http://10.0.2.2/update.aspx?id="+edtIdUp.getText().toString()+"&nome="+edtNomeUp.getText().toString()+"&fone="+edtFoneUp.getText().toString());


            }
            catch (Exception e){}
            return null;
        }

        @Override
        protected void onPostExecute(Void vd){
            ;
            super.onPostExecute(vd);
            Toast.makeText(getBaseContext(),"foi, inserido com sucesso",Toast.LENGTH_LONG).show();



        }
    }


}