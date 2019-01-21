package util.pjic.com.utilidadespjic;

import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

import util.pjic.com.utilidadespjic.adapters.NotaAdapter;
import util.pjic.com.utilidadespjic.models.Nota;

public class MainActivity extends AppCompatActivity {

    private NotaAdapter notaAdapter;
    private RecyclerView recyclerView;
    private ArrayList<Nota> notas = new ArrayList<>();
    private Button btnCalculate;
    private FloatingActionButton floatingActionButton;
    private TextView textView;
    private float total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.listaNotas);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        notaAdapter = new NotaAdapter(this, notas);
        final Nota nota = new Nota();
        nota.setNote(null);
        nota.setPercentage(null);
        notas.add(nota);
        textView = findViewById(R.id.textView5);
        recyclerView.setAdapter(notaAdapter);
        btnCalculate = findViewById(R.id.btnCalculate);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (Nota nota : notas) {
                    if (nota.getNote() == null || nota.getPercentage() == null) {
                        return;
                    }
                    float percentage = nota.getPercentage() / 100;
                    total += percentage * (nota.getNote());
                }
                textView.setText(String.valueOf((total)));
                total = 0;
            }
        });

        floatingActionButton = findViewById(R.id.floatBtnAdd);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInvalid = false;
                float percentageTotal = 0;
                for (Nota notaValid : notas) {
                    if (notaValid.getNote() == null || notaValid.getPercentage() == null) {
                        isInvalid = true;
                    } else if (notaValid.getNote() == 0.0 || notaValid.getPercentage() == 0.0) {
                        isInvalid = true;
                    }

                    if (notaValid.getPercentage() != null) {
                        percentageTotal += notaValid.getPercentage();
                    }
                }

                if (isInvalid) {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                    dialog.setMessage("Debes llenar todos los campos para poder añadir uno nuevo");
                    dialog.setPositiveButton("OK",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface arg0, int arg1) {
                                          return;
                                        }
                                    });
                    dialog.create().show();
                } else {
                    if (percentageTotal > 100) {
                        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                        dialog.setMessage("Error: la suma de los porcentajes no debe ser mayor a 100");
                        dialog.setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface arg0, int arg1) {
                                        return;
                                    }
                                });
                        dialog.create().show();
                        return;
                    } else {
                        notas.add(new Nota());
                        notaAdapter.notifyDataSetChanged();
                    }
                }
            }
        });
    }
}
