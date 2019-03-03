package mx.martinezfernando.reyesjose.cecyt9.edu.ipn.memorama;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class Puntajes extends AppCompatActivity {

    private DatabaseReference db;
    private ValueEventListener event;

    TableLayout datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntajes);
        datos = findViewById(R.id.datos);

        db = FirebaseDatabase.getInstance().getReference("Registros");

        db.child("Puntajes").orderByChild("puntos").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int num = 0;
                for (DataSnapshot snapshot: dataSnapshot.getChildren()) {
                    num++;
                    TableRow row = new TableRow(getApplicationContext());
                    row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));

                    // Text view para la posicion
                    TextView pos = new TextView(getApplicationContext());
                    pos.setTextColor(Color.parseColor("#000000"));
                    pos.setTextSize(18);
                    pos.setText("" + Integer.toString(num));
                    pos.setGravity(Gravity.CENTER);
                    TableRow.LayoutParams parameter = new TableRow.LayoutParams(
                            TableRow.LayoutParams.FILL_PARENT,
                            TableRow.LayoutParams.WRAP_CONTENT
                    );
                    parameter.weight = 0.5f;
                    parameter.setMargins(0,0,0,10);
                    pos.setLayoutParams(parameter);

                    row.addView(pos);

                    // Text view para el nombre
                    TextView nom = new TextView(getApplicationContext());
                    nom.setTextColor(Color.parseColor("#000000"));
                    nom.setTextSize(18);
                    nom.setText("" + snapshot.child("nombre").getValue().toString());
                    nom.setGravity(Gravity.CENTER);

                    nom.setLayoutParams(parameter);

                    row.addView(nom);

                    // Text view para el tiempo
                    TextView tie = new TextView(getApplicationContext());
                    tie.setTextColor(Color.parseColor("#000000"));
                    tie.setTextSize(18);
                    tie.setText("" + snapshot.child("puntos").getValue().toString());
                    tie.setGravity(Gravity.CENTER);

                    tie.setLayoutParams(parameter);

                    row.addView(tie);

                    datos.addView(row);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        /*event = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.i("datos","DATOS: " + dataSnapshot.child("Puntajes").getValue().toString());

                for (DataSnapshot snapshot: dataSnapshot.getChildren()) {
                    TextView x = new TextView(getApplicationContext());
                    x.setId(Integer.parseInt(snapshot.child("id").getValue().toString()));
                    x.setText("" + snapshot.child("nombre").getValue().toString() + "\t" + snapshot.child("puntos").getValue().toString());
                    x.setGravity(Gravity.CENTER);
                    x.setLayoutParams(new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.FILL_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                    ));

                    datos.addView(x);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("error", "Error:", databaseError.toException());
            }
        };*/
    }

    public void regreso(View v) {
        Intent i = new Intent(this, Menu.class);
        finish();
        startActivity(i);
    }
}
