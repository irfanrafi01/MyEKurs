package com.example.MyEKurs.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import com.example.MyEKurs.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChangerFragment extends Fragment {

    public ChangerFragment() {
        // Required empty public constructor
    }

    EditText edtAngka1, edtAngka2;
    Button btnTmbh;
    TextView txtHasil;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_changer, container, false);
        edtAngka1 = rootView.findViewById(R.id.edtAngka1);
        edtAngka2 = rootView.findViewById(R.id.edtAngka2);
        btnTmbh = rootView.findViewById(R.id.btnTmbh);
        txtHasil = rootView.findViewById(R.id.txtHasil);
        btnTmbh.setOnClickListener(v -> {
            if (v.getId() == R.id.btnTmbh) {
                String angka1 = edtAngka1.getText().toString().trim();
                String angka2 = edtAngka2.getText().toString().trim();

                int hasil = Integer.parseInt(angka1) * Integer.parseInt(angka2);

                txtHasil.setText(getString(R.string.hasil_konversi) + hasil);
            }
        });
        return rootView;
    }

}