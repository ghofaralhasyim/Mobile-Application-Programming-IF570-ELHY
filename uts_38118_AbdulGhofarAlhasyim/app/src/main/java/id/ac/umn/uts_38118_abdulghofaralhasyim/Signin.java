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

public class Signin extends AppCompatDialogFragment {
    EditText name;
    Button next;
    SinginListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.signin,null);

        builder.setView(view)
                .setTitle("Login Page");

        name = view.findViewById(R.id.name);
        next = view.findViewById(R.id.btnNext);

        next.setOnClickListener(v-> {
            if(TextUtils.isEmpty(name.getText())) {
                name.setError("Nama Wajib Diisi.");
            }else{
                String username = name.getText().toString();
                listener.SignInAction(username);
            }
        });

        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (SinginListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    "Error Implement SinginListener");
        }
    }

    public interface SinginListener {
        void SignInAction(String username);
    }

}