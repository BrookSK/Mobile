package br.gov.sp.etec.app_portaria;

import com.orm.SugarRecord;

/**
 * Created by LABINFO on 17/02/2022.
 */
public class Visitante extends SugarRecord {
    //Campos
    Long id;
    String nome, rg, cidade;

    //Construtor Vazio
    public Visitante(){

    }

    public Visitante(String cidade, String rg, String nome) {
        this.cidade = cidade;
        this.rg = rg;
        this.nome = nome;
    }

    //Mostrar no ListView

    @Override
    public String toString() {
        return nome + "\n" + cidade;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
}
