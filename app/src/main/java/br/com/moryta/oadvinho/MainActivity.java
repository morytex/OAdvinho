package br.com.moryta.oadvinho;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Random geradorNumero;
    private int numeroGerado;
    private int numeroChutado;
    private int tentativas;
    private EditText etChute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        geradorNumero = new Random();
        numeroGerado = geradorNumero.nextInt(11);

        etChute = (EditText) findViewById(R.id.etChute);
    }

    public void chutar(View view) {
        if (TextUtils.isEmpty(etChute.getText().toString())) {
            Toast.makeText(this, "Digitar um valor entre 0 e 10", Toast.LENGTH_SHORT).show();
            return;
        }

        numeroChutado = Integer.parseInt(etChute.getText().toString());

        if (numeroChutado > numeroGerado) {
            Toast.makeText(this, "Errou, numero chutado maior que numero gerado", Toast.LENGTH_SHORT).show();
        } else if (numeroChutado < numeroGerado) {
            Toast.makeText(this, "Errou, numero chutado menor que numero gerado", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Acertou", Toast.LENGTH_SHORT).show();
        }
    }
}
