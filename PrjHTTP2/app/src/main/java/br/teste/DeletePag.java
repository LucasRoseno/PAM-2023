package br.teste;

import androidx.appcompat.app.AppCompatActivity;



import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeletePag extends AppCompatActivity {


    EditText edtId;

    Button btnDel;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_pag);


        edtId = findViewById(R.id.edtId);

        btnDel = findViewById(R.id.btnDel);

        btnDel.setOnClickListener(new View.OnClickListener() {
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
            ConexaoHTTP.conectarHttp("http://10.0.2.2/delete.aspx?id="+edtId.getText().toString());


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