package mx.martinezfernando.reyesjose.cecyt9.edu.ipn.memorama;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    Button back;

    FirebaseDatabase database;
    DatabaseReference myRef;

    String tiempo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        back = findViewById(R.id.back);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("puntaje");
    }

    public void regreso(View v) {
        Intent i = new Intent(this, Menu.class);
        finish();
        startActivity(i);
    }

    public void getTime(View v) {
        tiempo = "01:15";

        myRef.push().setValue(tiempo);
    }
}
