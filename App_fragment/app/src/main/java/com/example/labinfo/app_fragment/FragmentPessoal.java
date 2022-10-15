package com.example.labinfo.app_fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentPessoal extends Fragment {


    public FragmentPessoal() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View tela = inflater.inflate(R.layout.fragment_fragment_pessoal, container, false);

        Button btn_gravar = (Button)tela.findViewById(R.id.btn_gravar);

        btn_gravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(tela.getContext(), "Gravado!!", Toast.LENGTH_SHORT).show();
            }
        });

        return tela;
    }


}
