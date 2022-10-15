package br.gov.sp.etec.app_login_phila;

import com.orm.SugarRecord;

public class Usuario extends SugarRecord{
    //Guarda o nome do usuario
    public static String usuario_logado;

    Long id;
    String nome, senha;

    public Usuario(){

    }

    //MOstra o nome no ListView
    @Override
    public String toString(){
        return nome;
    }

    public Usuario(String usuario, String senha){
        this.nome = usuario;
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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
}
