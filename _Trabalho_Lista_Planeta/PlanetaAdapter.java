package br.com.philadelpho.app_apagar2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Alexei on 09/04/2020.
 */
public class PlanetaAdapter extends ArrayAdapter<Planeta> {
    private final Context context;
    private final ArrayList<Planeta> elementos;

    public PlanetaAdapter(Context context, ArrayList<Planeta> elementos) {
        super(context, R.layout.item, elementos);
        this.context = context;
        this.elementos = elementos;
    }

    //Obtendo cada item
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //Informo a linha personalizada
        View rowView = inflater.inflate(R.layout.item, parent, false);

        //Informo a linha do texto
        TextView tv_planeta = (TextView) rowView.findViewById(R.id.tv_planeta);

        //Informo a imagem
        ImageView img_astro = (ImageView) rowView.findViewById(R.id.img_planeta);

        //Colocando os dados
        img_astro.setImageResource(elementos.get(position).getImagem());
        tv_planeta.setText(elementos.get(position).getNome().toString());

        return rowView;
    }
}
