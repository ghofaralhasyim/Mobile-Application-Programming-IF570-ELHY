package id.ac.umn.uts_38118_abdulghofaralhasyim;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Delete extends AppCompatDialogFragment {
    Button delete;
    DeleteListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.signin,null);

        builder.setView(view)
                .setTitle("Confirmation");

        delete = view.findViewById(R.id.delete);

        delete.setOnClickListener(v-> {
//            HOW TO OPEN DIALOG ON RECYCLE VIEW HMMMMMMMMM
        });

        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (DeleteListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    "Error Implement DeleteListener");
        }
    }

    public interface DeleteListener {
        void DeleteAction();
    }

}