package mx.martinezfernando.reyesjose.cecyt9.edu.ipn.memorama;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

    Button juego, puntajes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        juego = findViewById(R.id.juego);
        puntajes = findViewById(R.id.puntajes);
    }

    public void jugar(View v) {
        Intent i = new Intent(this, MainActivity.class);
        finish();
        startActivity(i);
    }

    public void puntaje(View v) {
        Intent i = new Intent(this, Puntajes.class);
        finish();
        startActivity(i);
    }
}
