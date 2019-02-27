package mx.martinezfernando.reyesjose.cecyt9.edu.ipn.memorama;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Puntajes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntajes);
    }

    public void regreso(View v) {
        Intent i = new Intent(this, Menu.class);
        finish();
        startActivity(i);
    }
}
