package util.pjic.com.utilidadespjic.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;

import util.pjic.com.utilidadespjic.R;
import util.pjic.com.utilidadespjic.models.Nota;

/**
 * Created by emine on 25/08/2016.
 */
public class NotaAdapter extends RecyclerView.Adapter<NotaAdapter.Myvistaholder>{

    private Context contexto;
    private ArrayList<Nota> nota;

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

        holder.note.setText(String.valueOf((int) nota.get(position).getNote()));
        holder.percentage.setText(String.valueOf((int) nota.get(position).getPercentage()));




    }

    @Override
    public int getItemCount() {
        return nota.size();
    }

    public class Myvistaholder extends RecyclerView.ViewHolder {

        EditText note,percentage;

        public Myvistaholder(View itemView) {
            super(itemView);

            note = itemView.findViewById(R.id.note);
            percentage = itemView.findViewById(R.id.percent);



        }
    }
}
