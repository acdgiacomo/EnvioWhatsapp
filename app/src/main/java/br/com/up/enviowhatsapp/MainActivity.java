package br.com.up.enviowhatsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout textInputLayoutNumero;
    private TextInputLayout textInputLayoutMensagem;
    private TextInputEditText textInputEditTextNumero;
    private TextInputEditText textInputEditTextMensagem;
    private Button buttonEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textInputLayoutNumero = findViewById(R.id.textInputLayoutNumero);
        textInputLayoutMensagem = findViewById(R.id.textInputLayoutMensagem);
        textInputEditTextNumero = findViewById(R.id.textInputEditNumero);
        textInputEditTextMensagem = findViewById(R.id.textInputEditMensagem);
        buttonEnviar = findViewById(R.id.btnEnviar);

        buttonEnviar.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    enviaTextoParaNumero();
                }
            });

    }

    private void enviaTextoParaNumero() {
        String num = textInputEditTextNumero.getText().toString();
        String texto = textInputEditTextMensagem.getText().toString();
        texto = texto.replace(" ", "%20");

        Uri webpage = Uri.parse("https://wa.me/" + num + "?text=" + texto);
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(webIntent);
    }
}