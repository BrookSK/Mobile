package br.gov.sp.etec.app_gerencia_anotacoes;

import com.orm.SugarRecord;

/**
 * Created by LABINFO on 17/03/2022.
 */
public class Nota extends SugarRecord {
    Long id;
    String titulo, nota;
    public Nota(){
    }
    public Nota(String titulo, String nota){
        this.titulo = titulo;
        this.nota = nota;
    }
    @Override
    public String toString() {
        return titulo;
    }
    @Override
    public Long getId() {
        return id;
    }
    @Override
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getNota() {
        return nota;
    }
    public void setNota(String nota) {
        this.nota = nota;
    }
}
