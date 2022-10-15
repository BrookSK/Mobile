package br.gov.sp.etec.app_compra;

import com.orm.SugarRecord;

/**
 * Created by LABINFO on 10/02/2022.
 */
public class Compra extends SugarRecord {
    Long id;
    String compra;

    public Compra(){

    }


    public Compra(String compra){
        this.compra=compra;
    }

    public String toString(){
        return compra;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getCompra() {
        return compra;
    }

    public void setCompra(String compra) {
        this.compra = compra;
    }
}
