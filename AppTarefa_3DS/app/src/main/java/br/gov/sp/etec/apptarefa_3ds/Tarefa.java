package br.gov.sp.etec.apptarefa_3ds;

import com.orm.SugarRecord;

/**
 * Created by LABINFO on 10/02/2022.
 */
public class Tarefa extends SugarRecord {
    //campos
    Long id;
    String tarefa;

    //construtor vazio
    public Tarefa(){

    }

    public Tarefa(String nome){
        this.tarefa=nome;
    }

    public String toString(){
        return tarefa;
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

    public String getTarefa() {
        return tarefa;
    }

    public void setTarefa(String tarefa) {
        this.tarefa = tarefa;
    }
}
