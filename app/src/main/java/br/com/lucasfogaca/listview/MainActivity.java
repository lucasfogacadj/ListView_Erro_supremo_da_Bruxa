package br.com.lucasfogaca.listview;

import android.content.Intent;
import android.sax.StartElementListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<String> nomes = new ArrayList<>();

    EditText edit;
    Button botao;
    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit = (EditText) findViewById(R.id.nome);
        botao = (Button) findViewById(R.id.Botao);
        lista = (ListView) findViewById(R.id.Lista);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, nomes);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(edit.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Prencha o nome" , Toast.LENGTH_LONG).show();

                }else {
                    nomes.add(edit.getText().toString());
                    Toast.makeText(MainActivity.this, "Parabens", Toast.LENGTH_LONG).show();
                    edit.setText("");
                    lista.setAdapter(adapter);
                }

            }
        });

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selecao = (String) parent.getAdapter().getItem(position);
                //nomes.remove(selecao);
                lista.setAdapter(adapter);
                Toast.makeText(MainActivity.this, selecao, Toast.LENGTH_LONG).show();


               int p = nomes.indexOf(selecao);
                Intent i = new Intent(MainActivity.this, AlteracaoActivity.class);
                i.putExtra("p", p);
                startActivity(i);
            }
        });

    }
}
