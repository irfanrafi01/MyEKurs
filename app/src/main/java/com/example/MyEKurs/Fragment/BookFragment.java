package com.example.MyEKurs.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.MyEKurs.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BookFragment extends Fragment {

    public BookFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_book, container, false);
        final Spinner spinner_benua = (Spinner) rootView.findViewById(R.id.spinner_benua);
        final Spinner spinner_negara = (Spinner) rootView.findViewById(R.id.spinner_negara);
        TextView mata_uang = (TextView) rootView.findViewById(R.id.book_currency);

        // Create an ArrayAdapter using the string array and
        // a default spinner layout
        ArrayAdapter<CharSequence> ad_benua = ArrayAdapter.createFromResource(getActivity(), R.array.nama_benua, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of
        // choices appears
        ad_benua.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner_benua.setAdapter(ad_benua);

        spinner_benua.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                if (adapterView.getSelectedItem().toString().equals("Australia")) {
                    ArrayAdapter<CharSequence> ad_negara = ArrayAdapter.createFromResource(getActivity().getApplicationContext(), R.array.australia, android.R.layout.simple_spinner_item);
                    ad_negara.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner_negara.setAdapter(ad_negara);
                }
                else if (adapterView.getSelectedItem().toString().equals("Amerika")) {
                    ArrayAdapter<CharSequence> ad_negara = ArrayAdapter.createFromResource(getActivity().getApplicationContext(), R.array.amerika, android.R.layout.simple_spinner_item);
                    ad_negara.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner_negara.setAdapter(ad_negara);
                }
                else if (adapterView.getSelectedItem().toString().equals("Eropa")) {
                    ArrayAdapter<CharSequence> ad_negara = ArrayAdapter.createFromResource(getActivity().getApplicationContext(), R.array.eropa, android.R.layout.simple_spinner_item);
                    ad_negara.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner_negara.setAdapter(ad_negara);
                }
                else if (adapterView.getSelectedItem().toString().equals("Asia")) {
                    ArrayAdapter<CharSequence> ad_negara = ArrayAdapter.createFromResource(getActivity().getApplicationContext(), R.array.asia, android.R.layout.simple_spinner_item);
                    ad_negara.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner_negara.setAdapter(ad_negara);
                }
                else {
                    ArrayAdapter<CharSequence> ad_negara = ArrayAdapter.createFromResource(getActivity().getApplicationContext(), R.array.afrika, android.R.layout.simple_spinner_item);
                    ad_negara.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner_negara.setAdapter(ad_negara);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // blank
            }
        });

        spinner_negara.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                String pilihan = adapterView.getSelectedItem().toString();
                switch (pilihan) {
                    case "Afrika Selatan":
                        mata_uang.setText(getString(R.string.matauang_afrikaselatan));
                        break;
                    case "Aljazair":
                        mata_uang.setText(getString(R.string.matauang_aljazair));
                        break;
                    case "Angola":
                        mata_uang.setText(getString(R.string.matauang_angola));
                        break;
                    case "Benin":
                        mata_uang.setText(getString(R.string.matauang_benin));
                        break;
                    case "Botswana":
                        mata_uang.setText(getString(R.string.matauang_botswana));
                        break;
                    default:
                        mata_uang.setText(getString(R.string.book_currency));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // blank
            }
        });

        return rootView;
    }
}