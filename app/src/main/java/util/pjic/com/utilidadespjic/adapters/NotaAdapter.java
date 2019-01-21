package util.pjic.com.utilidadespjic.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

import util.pjic.com.utilidadespjic.R;
import util.pjic.com.utilidadespjic.models.Nota;

/**
 * Created by emine on 25/08/2016.
 */
public class NotaAdapter extends RecyclerView.Adapter<NotaAdapter.Myvistaholder>{

    private Context contexto;
    private ArrayList<Nota> nota;
    private String[] noteAdd;
    private String[] parameterAdd;

    public NotaAdapter(Context contexto, ArrayList<Nota> nota) {
        this.contexto = contexto;
        this.nota = nota;
    }

    @Override
    public Myvistaholder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Myvistaholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_notas_recycler,null));
    }

    @Override
    public void onBindViewHolder(Myvistaholder holder,final int position) {

        holder.note.setText(String.valueOf(nota.get(position).getNote() == null ? "" : nota.get(position).getNote()));
        holder.percentage.setText(String.valueOf(nota.get(position).getPercentage() == null ? "" : (nota.get(position).getPercentage())));

        holder.closeButtonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nota.remove(holder.getAdapterPosition());
                notifyItemRemoved(holder.getAdapterPosition());
                notifyItemRangeChanged(holder.getAdapterPosition(),nota.size());

                Toast.makeText(contexto,"Removido con exito",Toast.LENGTH_SHORT).show();
            }
        });

        holder.note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().equals("")) {
                    return;
                }

                if (Float.parseFloat(s.toString()) > 5.0) {
                    holder.note.setError("No debe ser mayor a 5");
                    nota.get(holder.getAdapterPosition()).setNote(null);
                    holder.note.setText("");
                    return;
                }
                nota.get(holder.getAdapterPosition()).setNote(Float.parseFloat(s.toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        holder.percentage.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().equals("")) {
                    return;
                }

                if (Float.parseFloat(s.toString()) > 100) {
                    holder.percentage.setError("No debe ser mayor a 100");
                    nota.get(holder.getAdapterPosition()).setPercentage(null);
                    holder.percentage.setText("");
                    return;
                }
                nota.get(holder.getAdapterPosition()).setPercentage(Float.parseFloat(s.toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return nota.size();
    }

    public class Myvistaholder extends RecyclerView.ViewHolder {

        EditText note,percentage;
        ImageButton closeButtonCalculate;

        public Myvistaholder(final View itemView) {
            super(itemView);
            note = itemView.findViewById(R.id.note);
            percentage = itemView.findViewById(R.id.percent);
            closeButtonCalculate = itemView.findViewById(R.id.closeButtonCalculate);
        }

    }

    public class InputFilterMinMax implements InputFilter {
        private int min, max;

        public InputFilterMinMax(int min, int max) {
            this.min = min;
            this.max = max;
        }

        public InputFilterMinMax(String min, String max) {
            this.min = Integer.parseInt(min);
            this.max = Integer.parseInt(max);
        }

        @Override
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
            try {
                int input = Integer.parseInt(dest.toString() + source.toString());
                if (isInRange(min, max, input))
                    return null;
            } catch (NumberFormatException nfe) { }
            return "";
        }

        private boolean isInRange(int a, int b, int c) {
            return b > a ? c >= a && c <= b : c >= b && c <= a;
        }

    }

}
