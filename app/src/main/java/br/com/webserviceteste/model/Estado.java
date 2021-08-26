package br.com.webserviceteste.model;

public class Estado {

    private int cod_est; // PK
    private String sigla;
    private String nome;

    public Estado(){}

    public Estado(int id, String sigla, String nome){

        this.setCod_est(id);
        this.setSigla(sigla);
        this.setNome(nome);
    }

    public int getCod_est() {
        return cod_est;
    }

    public void setCod_est(int cod_est) {
        this.cod_est = cod_est;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
