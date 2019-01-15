package util.pjic.com.utilidadespjic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import util.pjic.com.utilidadespjic.adapters.NotaAdapter;
import util.pjic.com.utilidadespjic.models.Nota;

public class MainActivity extends AppCompatActivity {

    private NotaAdapter notaAdapter;
    private RecyclerView recyclerView;
    private ArrayList<Nota> notas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.listaNotas);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        notaAdapter = new NotaAdapter(this, notas);
        Nota nota = new Nota();
        nota.setNote(4);
        nota.setNote(4);
        notas.add(nota);

        recyclerView.setAdapter(notaAdapter);
    }
}
