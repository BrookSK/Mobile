package etim.phila.app_contato;

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
public class PessoaAdapter extends ArrayAdapter<Pessoa> {
    private final Context context;
    private final ArrayList<Pessoa> elementos;

    public PessoaAdapter(Context context, ArrayList<Pessoa> elementos) {
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

        //Informo a linha do planeta
        TextView tv_pessoa = (TextView) rowView.findViewById(R.id.tv_contato);

        //Informo a imagem
        ImageView img_astro = (ImageView) rowView.findViewById(R.id.img_pessoa);

        //Colocando os dados
        img_astro.setImageResource(elementos.get(position).getFoto());
        tv_pessoa.setText(elementos.get(position).getNome().toString() + "\n" +
                          elementos.get(position).getTelefone().toString());

        return rowView;
    }

}
