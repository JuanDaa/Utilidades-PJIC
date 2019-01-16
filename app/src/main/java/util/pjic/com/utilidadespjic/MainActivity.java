package util.pjic.com.utilidadespjic;

import android.support.design.widget.FloatingActionButton;
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
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        notaAdapter = new NotaAdapter(this, notas);
        final Nota nota = new Nota();
        nota.setNote(4);
        nota.setPercentage(4);
        notas.add(nota);
        textView = findViewById(R.id.textView5);
        recyclerView.setAdapter(notaAdapter);
        btnCalculate = findViewById(R.id.btnCalculate);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (Nota nota : notas) {
                   total = nota.getNote() * nota.getPercentage();
                }
                textView.setText(String.valueOf((int) total));
            }
        });

        floatingActionButton = findViewById(R.id.floatBtnAdd);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notas.add(new Nota());
                notaAdapter.notifyDataSetChanged();
            }
        });
    }
}
