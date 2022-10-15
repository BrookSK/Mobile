package br.gov.sp.etec.app_agenda;

import com.orm.SugarRecord;


    public class Contato extends SugarRecord {
        //Atributos que serão os campos da tabela
        Long id;
        String nome, telefone, cidade;
        //Construtor vazio que é obrigatório
        public Contato(){
        }
        //Construtor com parâmetros para ajudar na inclusão no banco de dados
        public Contato(String nome, String telefone, String cidade) {
            this.nome = nome;
            this.telefone = telefone;
            this.cidade = cidade;
        }
        //Vou mostrar o nome e o telefone no ListView
        @Override
        public String toString() {
            return nome + "\n" + telefone+"\n"+cidade;
        }
        //Get e set gerado automaticamente
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
        public String getTelefone() {
            return telefone;
        }
        public void setTelefone(String telefone) {
            this.telefone = telefone;
        }
        public String getCidade() {
            return cidade;
        }
        public void setCidade(String cidade) {
            this.cidade = cidade;
        }

    }
