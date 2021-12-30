package com.praticrud.model;

/**
 *
 * @author wesley
 */
public class Pessoa {

    private String nome;
    private Long telefone;
    private String datanascimento;
    private String datacadastro;
    private String datalastup;

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
    public String getDatanascimento() {
        return datanascimento;
    }

    /**
     * @param datanascimento the datanascimento to set
     */
    public void setDatanascimento(String datanascimento) {
        this.datanascimento = datanascimento;
    }

    /**
     * @return the datacadastro
     */
    public String getDatacadastro() {
        return datacadastro;
    }

    /**
     * @param datacadastro the datacadastro to set
     */
    public void setDatacadastro(String datacadastro) {
        this.datacadastro = datacadastro;
    }

    /**
     * @return the datalastup
     */
    public String getDatalastup() {
        return datalastup;
    }

    /**
     * @param datalastup the datalastup to set
     */
    public void setDatalastup(String datalastup) {
        this.datalastup = datalastup;
    }

}
