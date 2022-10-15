package etim.phila.app_contato;

/**
 * Created by LABINFO on 20/09/2021.
 */
public class Pessoa {
    String nome, telefone, cidade, profissao;
    int foto;

    public Pessoa(String nome, int foto, String profissao, String cidade, String telefone) {
        this.nome = nome;
        this.foto = foto;
        this.profissao = profissao;
        this.cidade = cidade;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
