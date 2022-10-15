package br.gov.sp.etec.app_conta_corrente;

/**
 * Created by LABINFO on 10/03/2022.
 */

import  com.orm.SugarRecord;

public class Conta extends SugarRecord {
    Long id;
    String descricao, data, tipo;
    double valor;

    public Conta(){}

    public Conta(String descricao, String data, String tipo, double valor) {
        this.descricao = descricao;
        this.data = data;
        this.tipo = tipo;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return tipo +" - "+descricao+"\nData: "+data+"\nR$: "+valor+"\n";
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
