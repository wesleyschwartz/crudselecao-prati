package com.praticrud.model;

/**
 * @author wesley
 */
public class Pessoa {
    private static Integer sequencial = 0;
    private Integer idPessoa;
    private String nome;
    private Long telefone;
    private String dataNascimento;
    private String dataCadastro;
    private String dataLastUp;

    public Pessoa(Integer id, String nome, Long telefone, String dataNascimento, String dataCadastro, String dataLastUp) {
        this.idPessoa = sequencial++;
        this.nome = nome;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.dataCadastro = dataCadastro;
        this.dataLastUp = dataLastUp;
    }

    public Pessoa(String nome, Long telefone, String dataNascimento, String dataCadastro, String dataLastUp) {
        this.nome = nome;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.dataCadastro = dataCadastro;
        this.dataLastUp = dataLastUp;
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the telefone
     */
    public Long getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the datanascimento
     */
    public String getDataNascimento() {
        return dataNascimento;
    }

    /**
     * @param dataNascimento the datanascimento to set
     */
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /**
     * @return the datacadastro
     */
    public String getDataCadastro() {
        return dataCadastro;
    }

    /**
     * @param dataCadastro the datacadastro to set
     */
    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    /**
     * @return the datalastup
     */
    public String getDataLastUp() {
        return dataLastUp;
    }

    /**
     * @param dataLastUp the datalastup to set
     */
    public void setDataLastUp(String dataLastUp) {
        this.dataLastUp = dataLastUp;
    }

}
