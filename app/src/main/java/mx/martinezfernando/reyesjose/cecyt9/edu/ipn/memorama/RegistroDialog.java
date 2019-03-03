package mx.martinezfernando.reyesjose.cecyt9.edu.ipn.memorama;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistroDialog extends DialogFragment {

    private String mensaje = "";
    private EditText nombre;
    private TextView puntos;

    private DatabaseReference database;

    public RegistroDialog setMensaje(String mensaje) {
        this.mensaje = mensaje;
        return this;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.AlertDialogTheme);
        LayoutInflater inflater = getActivity().getLayoutInflater();

        database = FirebaseDatabase.getInstance().getReference("Registros");

        View v = inflater.inflate(R.layout.registro_dialog, null);

        builder.setView(v)
            .setCancelable(false)
            .setPositiveButton(R.string.positive_answer, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    registraPuntaje();
                }
            })
            .setNegativeButton(R.string.negative_answer, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dismiss();
                }
            });

        nombre = v.findViewById(R.id.nombre);
        puntos = v.findViewById(R.id.puntos);

        puntos.setText(mensaje);
        return builder.create();
    }

    public void registraPuntaje() {
        String nom = nombre.getText().toString().trim();
        String punt = puntos.getText().toString().trim();

        if (!TextUtils.isEmpty(nom)) {
            String id = database.push().getKey();
            Puntaje n = new Puntaje(id, nom, punt);
            database.child("Puntajes").child(id).setValue(n);

            Toast.makeText(getActivity(), "Puntaje registrado!!", Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(getActivity(), "Debe introducir un nombre", Toast.LENGTH_LONG).show();
        }
    }
}
