package br.com.lucasfogaca.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AlteracaoActivity extends AppCompatActivity {

    EditText edit;
    Button btnUp;
    Button btnDel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alteracao);

        edit = (EditText) findViewById(R.id.EditUp);
        btnUp = (Button) findViewById(R.id.up);
        btnDel = (Button) findViewById(R.id.remove);

        final Bundle extra = getIntent().getExtras();
        final int p = extra.getInt("p");

        edit.setText(MainActivity.nomes.get(p));

        btnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String novoNome = edit.getText().toString();
                MainActivity.nomes.set(p, novoNome);
                onBackPressed();
            }
        });
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.nomes.remove(p);
                onBackPressed();
            }
        });


    }
}
