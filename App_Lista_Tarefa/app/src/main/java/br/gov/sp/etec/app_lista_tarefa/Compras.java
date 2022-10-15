package br.gov.sp.etec.app_lista_tarefa;

import com.orm.SugarRecord;

/**
 * Created by LABINFO on 10/02/2022.
 */
public class Compras extends SugarRecord {
    //campos
    Long id;
    String compras;

    //construtor vazio
    public Compras(){

    }

    public Compras(String nome){
        this.compras=nome;
    }

    public String toString(){
        return compras;
    }

    //gero os get e set
    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getCompras() {
        return compras;
    }

    public void setCompras(String compras) {
        this.compras = compras;
    }
}
