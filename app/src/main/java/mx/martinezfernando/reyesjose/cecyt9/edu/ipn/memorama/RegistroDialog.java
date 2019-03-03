package mx.martinezfernando.reyesjose.cecyt9.edu.ipn.memorama;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;

public class RegistroDialog extends DialogFragment {

    private String mensaje = "";

    public RegistroDialog setMensaje(String mensaje) {
        this.mensaje = mensaje;
        return this;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.AlertDialogTheme);
        LayoutInflater inflater = getActivity().getLayoutInflater();

        builder.setView(inflater.inflate(R.layout.registro_dialog, null))
            .setCancelable(false)
            .setMessage(mensaje)
            .setPositiveButton(R.string.positive_answer, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    //TODO db connection
                }
            })
            .setNegativeButton(R.string.negative_answer, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dismiss();
                }
            });
        return builder.create();
    }
}
