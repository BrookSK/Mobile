    package br.gov.sp.etec.app_compra;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.orm.SugarContext;

import java.util.List;

    public class TelaPrincipal extends AppCompatActivity {

    EditText edt_compra;
    ListView lst_compra;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        edt_compra=(EditText)findViewById(R.id.edt_compra);
        lst_compra=(ListView)findViewById(R.id.lst_compra);

        SugarContext.init(this);
    }

        public void incluir_clique(View V){
            String nome_compra=edt_compra.getText().toString();
            if(nome_compra.equals("")){Toast.makeText(this, "Digite a compra",Toast.LENGTH_SHORT).show();}
            else {//Cadastra
                new Compra(nome_compra).save();

                edt_compra.setText("");
                Toast.makeText(this, "Sucesso", Toast.LENGTH_SHORT).show();

                //Lista
                List<Compra> compras = Compra.listAll(Compra.class);
                ArrayAdapter<Compra> adaptador = new ArrayAdapter<Compra>(this, R.layout.item, R.id.tv_compra, compras);
                lst_compra.setAdapter(adaptador);
                listar();
            }
        }

        public void  listar(){
        List<Compra>compras=Compra.listAll(Compra.class);
            ArrayAdapter<Compra> adaptador = new ArrayAdapter<Compra>(this,R.layout.item,R.id.tv_compra,compras);
            lst_compra  .setAdapter(adaptador);
        }

        private void excluir (final Compra compra){
            AlertDialog.Builder alerta=new AlertDialog.Builder(this);
            alerta.setTitle("Atenção!");
            alerta.setMessage("Deseja excluir " + compra.getCompra() + "?");
            alerta.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    compra.delete();
                    listar();
                }
            });
            alerta.setNeutralButton("Não",null);
            alerta.show();
        }
}
