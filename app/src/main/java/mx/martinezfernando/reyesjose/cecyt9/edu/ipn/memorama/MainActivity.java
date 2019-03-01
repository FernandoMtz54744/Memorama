package mx.martinezfernando.reyesjose.cecyt9.edu.ipn.memorama;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ImageButton b1c,b2c,b3c,b4c,b5c,b6c,b7c,b8c,b9c,b10c,b11c,b12c,b13c,b14c,b15c,b16c;
    ArrayList<ImageButton> botones = new ArrayList();
    String tagAnterior = "";
    int idAnterior;
    int id;
    String tag;
    boolean anterior = false;
    int correcto = 0;
    Handler hand = new Handler();
    TextView timer;
    int segundos = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1c = (ImageButton)findViewById(R.id.b1);
        b2c =(ImageButton) findViewById(R.id.b2);
        b3c = (ImageButton)findViewById(R.id.b3);
        b4c = (ImageButton)findViewById(R.id.b4);
        b5c =(ImageButton) findViewById(R.id.b5);
        b6c = (ImageButton)findViewById(R.id.b6);
        b7c = (ImageButton)findViewById(R.id.b7);
        b8c = (ImageButton)findViewById(R.id.b8);
        b9c = (ImageButton)findViewById(R.id.b9);
        b10c =(ImageButton) findViewById(R.id.b10);
        b11c =(ImageButton) findViewById(R.id.b11);
        b12c = (ImageButton)findViewById(R.id.b12);
        b13c =(ImageButton) findViewById(R.id.b13);
        b14c =(ImageButton) findViewById(R.id.b14);
        b15c = (ImageButton)findViewById(R.id.b15);
        b16c = (ImageButton)findViewById(R.id.b16);
        timer = findViewById(R.id.timer);

        botones.add(b1c);
        botones.add(b2c);
        botones.add(b3c);
        botones.add(b4c);
        botones.add(b5c);
        botones.add(b6c);
        botones.add(b7c);
        botones.add(b8c);
        botones.add(b9c);
        botones.add(b10c);
        botones.add(b11c);
        botones.add(b12c);
        botones.add(b13c);
        botones.add(b14c);
        botones.add(b15c);
        botones.add(b16c);

        revolver();
        hand.postDelayed(tiempo, 1000);
    }

    public void revolver(){
        String tags [] = {"ix1","ix1","ix2","ix2","ix3","ix3","ix4","ix4","ix5","ix5","ix6","ix6","ix7","ix7","ix8","ix8"};
        int arreglo[] = new int[16];
        arreglo [0] = (int)(Math.random()*16);
        for (int i = 0 ; i < 16; i++) {
            arreglo[i] = (int)(Math.random()*16);
            for (int j = 0; j < i; j++) {
                if(arreglo[i] == arreglo[j]){
                    i--;
                }
            }
        }
        Log.d("arreglo", Arrays.toString(arreglo));

        for(int i = 0; i < 16; i++){
            botones.get(i).setTag(tags[arreglo[i]]);
            Log.d("tag"+i, botones.get(i).getTag().toString());
        }
    }



    public void voltear(View v){
        tag = v.getTag().toString();
        id = v.getId();
        findViewById(id).setClickable(false);

        if(tag.equals("ix1")){
            findViewById(id).setBackgroundResource(R.drawable.ix1);
               verificar();
        }else{
            if(tag.equals("ix2")){
                findViewById(id).setBackgroundResource(R.drawable.ix2);
                verificar();
            }else{
                if(tag.equals("ix3")){
                    findViewById(id).setBackgroundResource(R.drawable.ix3);
                    verificar();
                }else{
                    if(tag.equals("ix4")){
                        findViewById(id).setBackgroundResource(R.drawable.ix4);
                        verificar();
                    }else{
                        if(tag.equals("ix5")){
                            findViewById(id).setBackgroundResource(R.drawable.ix5);
                            verificar();
                        }else {
                            if(tag.equals("ix6")){
                                findViewById(id).setBackgroundResource(R.drawable.ix6);
                                verificar();
                            }else{
                                if(tag.equals("ix7")){
                                    findViewById(id).setBackgroundResource(R.drawable.ix7);
                                    verificar();
                                }else{
                                    //tag=ix8
                                    findViewById(id).setBackgroundResource(R.drawable.ix8);
                                    verificar();
                                }
                            }
                        }
                    }
                }
            }
        }

        if(correcto == 8){
            //parar tiempo, el jugador ha terminado
            Toast.makeText(this, "Has Ganado :)", Toast.LENGTH_SHORT).show();
            hand.removeCallbacks(tiempo);
        }
    }

    Runnable voltearNuevamente = new Runnable (){
        @Override
            public void run(){
            findViewById(id).setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorAccent));
            findViewById(idAnterior).setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorAccent));
            //se habilitan todos los botones
            habilitar();
            }
    };

    public void verificar (){
        if(anterior){
            if(tag.equals(tagAnterior)){
                //las tarjetas son iguales, se desabilitan y se queda la imagen
                findViewById(idAnterior).setEnabled(false);
                findViewById(id).setEnabled(false);
                correcto++;
                anterior = false;
            }else{
                //deshabilitan todos los botones aqui
                deshabilitar();
                //se deben voltear ambas imagenes despues de un tiempo
                hand.postDelayed(voltearNuevamente, 1000);
                anterior = false;
            }
        }else{
            //se  guardaen los datos
            tagAnterior = tag;
            idAnterior = id;
            anterior = true;
        }
    }

    Runnable tiempo = new Runnable() {
        @Override
        public void run() {
            segundos++;
            timer.setText(Integer.toString(segundos) + " segundos");
            hand.postDelayed(tiempo, 1000);
        }
    };

    public void habilitar(){
        for(int i = 0; i < 16; i++){
            botones.get(i).setClickable(true);
        }
    }

    public void deshabilitar(){
        for(int i = 0; i < 16; i++){
            botones.get(i).setClickable(false);
        }
    }

    public void restart(View v) {
        Intent i = new Intent(this, MainActivity.class);
        finish();
        startActivity(i);
    }

    public void regresar(View v) {
        Intent i = new Intent(this, Menu.class);
        finish();
        startActivity(i);
    }
}
