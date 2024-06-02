package com.estudo.intentbundle;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button btnSalvar;
    private EditText etNome;
    private EditText etCPF;
    private EditText etIdade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnSalvar = findViewById(R.id.btnSalvar);
        etNome = findViewById(R.id.etNome);
        etCPF = findViewById(R.id.etCPF);
        etIdade = findViewById(R.id.etIdade);

        btnSalvar.setOnClickListener(op -> calc());
    }
    public void calc(){
        String nome = etNome.getText().toString();
        String cpf = etCPF.getText().toString();
        String idade = etIdade.getText().toString();

        Bundle bundle = new Bundle();
        bundle.putString("nome", nome);
        bundle.putString("cpf", cpf);
        bundle.putString("idade", idade);
        trocar(bundle);

    }
    private void trocar(Bundle bundle){
        Intent i = new Intent(this, SaidaActivity.class);
        i.putExtras(bundle);
        this.startActivity(i);
        this.finish();
    }
}