package util.pjic.com.utilidadespjic.ui.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ingoskr.eminen.enelmoment.R;
import com.ingoskr.eminen.enelmoment.ui.activitys.Login;
import com.ingoskr.eminen.enelmoment.utilidades.PrefManager;

import util.pjic.com.utilidadespjic.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Inicio extends Fragment {


    public Inicio() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_inicio, container, false);

        //recyclerView = (RecyclerView) findViewById(R.id.listaNotas);
        return view;
    }


}


