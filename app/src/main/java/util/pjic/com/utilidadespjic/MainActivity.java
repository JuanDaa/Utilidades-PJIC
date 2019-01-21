package util.pjic.com.utilidadespjic;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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
    private float total;
    private float totalPercentage;
    private float failureToWinPercentage;
    private double failureToWin;
    private Dialog dialogCalculate;

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
        recyclerView.setAdapter(notaAdapter);
        btnCalculate = findViewById(R.id.btnCalculate);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int imageToView;
                String messageText = "";
                String messageResult = "";

                for (Nota nota : notas) {
                    if (nota.getNote() == null) {
                        return;
                    }

                    if (nota.getPercentage() == null) {
                        return;
                    }
                    totalPercentage += nota.getPercentage();
                    float percentage = nota.getPercentage() / 100;
                    total += percentage * (nota.getNote());
                }

                if (totalPercentage == 100) {
                    if (total == 5.0) {
                        imageToView = R.drawable.ic_star;
                        messageText = "Tu nota final es de" + " " + total;
                        messageResult = "Relajate";
                    } else {
                        imageToView = R.drawable.ic_depression;
                        failureToWin = 5.0 - total;
                        messageText = "tu nota final fue de" + " " + total;
                        messageResult = "Lo sentimos, no alcanzaste la meta";
                    }
                } else {
                    failureToWinPercentage = 100 - totalPercentage;

                    if (total > 4.5) {
                        imageToView = R.drawable.ic_geek;
                        messageText = "No necesitas sacar nota para el final";
                        messageResult = "Pero esfuérzate para dejarla altica";
                    } else {
                        failureToWin = 5.0 - total;
                        if (failureToWin > 5.0) {
                            imageToView = R.drawable.ic_depression;
                            messageText = "Ya no alcanzaras la nota";
                            messageResult = "Lo sentimos";
                        }else {
                            imageToView = R.drawable.ic_surprise;
                            messageText = "Te hace falta sacar" + " " + failureToWin + "En el " + failureToWinPercentage + " restante";
                            messageResult = "No te descuides";
                        }
                    }
                }
                openCalculateDialog(imageToView, messageText, messageResult);
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

    public void openCalculateDialog(int imageToView, String messaget, String messageR) {
        dialogCalculate = new Dialog(MainActivity.this);
        dialogCalculate.setContentView(R.layout.calculate_note_dialog);

        ImageView imageResult = dialogCalculate.findViewById(R.id.imageResult);
        TextView messageText = dialogCalculate.findViewById(R.id.messageText);
        TextView messageResult = dialogCalculate.findViewById(R.id.messageResult);

        dialogCalculate.setTitle("Tus resultados");
        imageResult.setImageResource(imageToView);
        messageText.setText(messaget);
        messageResult.setText(messageR);
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
        dialogCalculate.getWindow().setLayout((6 * width)/7, (4 * height)/5);
        dialogCalculate.show();


        Button closeButton = dialogCalculate.findViewById(R.id.closeButton);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogCalculate.dismiss();
            }
        });
    }
}
