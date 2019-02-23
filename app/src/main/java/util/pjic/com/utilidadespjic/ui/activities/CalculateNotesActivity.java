package util.pjic.com.utilidadespjic.ui.activities;

import android.app.Dialog;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Objects;

import util.pjic.com.utilidadespjic.R;
import util.pjic.com.utilidadespjic.adapters.NotaAdapter;
import util.pjic.com.utilidadespjic.models.Nota;

public class CalculateNotesActivity extends AppCompatActivity {

    private NotaAdapter notaAdapter;
    private ArrayList<Nota> notas = new ArrayList<>();
    private Dialog dialogCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_note);

        RecyclerView recyclerView = findViewById(R.id.listaNotas);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        notaAdapter = new NotaAdapter(this, notas);
        final Nota nota = new Nota();
        nota.setNote(null);
        nota.setPercentage(null);
        notas.add(nota);
        recyclerView.setAdapter(notaAdapter);
        Button btnCalculate = findViewById(R.id.btnCalculate);
        btnCalculate.setOnClickListener(v -> {

            int imageToView;
            String messageText;
            String messageResult;

            Float totalPercentage = (float) 0;
            Float total = (float) 0;
            Double failureToWin;
            for (Nota nota1 : notas) {
                if (nota1.getNote() == null) {
                    Snackbar.make(v, "Debes agregar una nota", Snackbar.LENGTH_SHORT);
                    return;
                }

                if (nota1.getPercentage() == null) {
                    Snackbar.make(v, "Debes agregar el porcentaje de la nota", Snackbar.LENGTH_SHORT);
                    return;
                }

                totalPercentage += nota1.getPercentage();
                float percentage = nota1.getPercentage() / 100;
                total += percentage * (nota1.getNote());
            }

            DecimalFormat df = new DecimalFormat();
            df.setMaximumFractionDigits(2);

            if (totalPercentage == 100) {
                if (total >= 3.0) {
                    imageToView = R.drawable.ic_star;
                    messageText = "Tu nota final es de " + df.format(total);
                    messageResult = "Relajate lograste ganarla";
                } else {
                    imageToView = R.drawable.ic_depression;
                    messageText = "tu nota final fue de " + df.format(total);
                    messageResult = "Lo sentimos, no alcanzaste la meta";
                }
            } else {
                Float failureToWinPercentage = 100 - totalPercentage;

                if (total > 4.5) {
                    imageToView = R.drawable.ic_geek;
                    messageText = "No necesitas sacar nota para el final, la tienes en: " + df.format(total);
                    messageResult = "Pero esfuérzate para dejarla altica";
                } else {
                    failureToWin = 5.0 - total;
                    if (failureToWin > 5.0) {
                        imageToView = R.drawable.ic_depression;
                        messageText = "Ya no alcanzaras la nota";
                        messageResult = "Lo sentimos";
                    }else {
                        imageToView = R.drawable.ic_surprise;
                        messageText = "Te hace falta sacar " + df.format(failureToWin) + " En el " + df.format(failureToWinPercentage) + "% restante";
                        messageResult = "No te descuides";
                    }
                }
            }
            openCalculateDialog(imageToView, messageText, messageResult);
        });

        FloatingActionButton floatingActionButton = findViewById(R.id.floatBtnAdd);
        floatingActionButton.setOnClickListener(v -> {
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
                AlertDialog.Builder dialog = new AlertDialog.Builder(CalculateNotesActivity.this);
                dialog.setMessage("Debes llenar todos los campos para poder añadir uno nuevo");
                dialog.setPositiveButton("OK",
                        (arg0, arg1) -> {
                            arg0.dismiss();
                        });
                dialog.create().show();
            } else {
                if (percentageTotal > 100) {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(CalculateNotesActivity.this);
                    dialog.setMessage("Error: la suma de los porcentajes no debe ser mayor a 100");
                    dialog.setPositiveButton("OK",
                            (arg0, arg1) -> {
                                arg0.dismiss();
                            });
                    dialog.create().show();
                } else {
                    notas.add(new Nota());
                    notaAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    public void openCalculateDialog(int imageToView, String messaget, String messageR) {
        dialogCalculate = new Dialog(CalculateNotesActivity.this);
        dialogCalculate.requestWindowFeature(Window.FEATURE_NO_TITLE);
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
        Objects.requireNonNull(dialogCalculate.getWindow()).setLayout((6 * width)/7, (4 * height)/5);
        dialogCalculate.show();


        Button closeButton = dialogCalculate.findViewById(R.id.closeButton);
        closeButton.setOnClickListener(v -> dialogCalculate.dismiss());
    }
}
