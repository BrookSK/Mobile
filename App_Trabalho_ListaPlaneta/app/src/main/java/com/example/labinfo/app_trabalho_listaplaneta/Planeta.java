package com.example.labinfo.app_trabalho_listaplaneta;

/**
 * Created by LABINFO on 22/11/2021.
 */
public class Planeta {
    //Atributos
    private String nome;
    private int imagem;
    private String informacoes;

    //Construtor
    public Planeta(String nome, int imagem, String informacoes){
        this.nome = nome;
        this.imagem = imagem;
        this.informacoes = informacoes;
    }


    //Métodos acessores
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getImagem() {
        return imagem;
    }
    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public String getInformacoes() {
        return informacoes;
    }
    public void setInformacoes(String informaceos) {
        this.informacoes = informaceos;
    }

}
