package com.praticrud.repository;

import com.praticrud.model.Aluno;
import com.praticrud.model.Pessoa;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wesle
 */
public class DAO {

    List<Pessoa> pessoas;
    List<Aluno> alunos;

    public DAO() {
        pessoas = new ArrayList<>();
        alunos = new ArrayList<>();
    }

    public void inserirPes(String nome, Long telefone, String datanascimento, String datacadastro, String datalastup) {
        Pessoa objpes = new Pessoa();
        objpes.setNome(nome);
        objpes.setTelefone(telefone);
        objpes.setDatanascimento(datanascimento);
        objpes.setDatacadastro(datacadastro);
        objpes.setDatalastup(datalastup);
        pessoas.add(objpes);
        System.out.println("Pessoa registrada...");
    }

    public void inserirAlu(String nome, Long telefone, String datanascimento, String datacadastro, String datalastup, Double nota) {
        Aluno objalu = new Aluno();
        objalu.setNome(nome);
        objalu.setTelefone(telefone);
        objalu.setDatanascimento(datanascimento);
        objalu.setDatacadastro(datacadastro);
        objalu.setDatalastup(datalastup);
        objalu.setNota(nota);
        alunos.add(objalu);
        System.out.println("Aluno registrado...");
    }

    public void listarPes() {
        System.out.println("\n Lista de pessoas:");
        if (pessoas.isEmpty()) {
            System.out.println("\n Não há registro de pessoas...");
        } else {
            for (Pessoa pessoa : pessoas) {
                System.out.println("\t Nome: " + pessoa.getNome() + " |"
                        + "\t| Número de telefone: " + pessoa.getTelefone() + " |"
                        + "\t| Data de Nascimento: " + pessoa.getDatanascimento() + " |"
                        + "\t| Data de Cadastro: " + pessoa.getDatacadastro() + " |"
                        + "\t| Data da última alteração: " + pessoa.getDatalastup() + " |"
                        + "\n");
            }
        }
    }

    public void listarAlu() {
        System.out.println("\n Lista de alunos:");
        if (alunos.isEmpty()) {
            System.out.println("\n Não há registro de alunos...");
        } else {
            for (Aluno aluno : alunos) {
                System.out.println("\t Nome: " + aluno.getNome() + " |"
                        + "\t| Número de telefone: " + aluno.getTelefone() + " |"
                        + "\t| Data de Nascimento: " + aluno.getDatanascimento() + " |"
                        + "\t| Nota: " + aluno.getNota() + " |"
                        + "\t| Data de Cadastro: " + aluno.getDatacadastro() + " |"
                        + "\t| Data da última alteração: " + aluno.getDatalastup() + " |"
                        + "\n");

            }
        }
    }

    public boolean buscaPes(Long antigoTel) {
        for (int i = 0; i < pessoas.size(); i++) {
            if (pessoas.get(i).getTelefone().equals(antigoTel)) {
                return true;
            }
        }
        return false;
    }

    public boolean buscaAlu(Long antigoTel) {
        for (int i = 0; i < alunos.size(); i++) {
            if (alunos.get(i).getTelefone().equals(antigoTel)) {
                return true;
            }
        }
        return false;
    }
    public void atualizarPes(Long antigoTel, String novoNome, Long novoTelefone, String novaDatanascimento, String novaDatalastup) {
        for (int i = 0; i < pessoas.size(); i++) {
            pessoas.get(i).setNome(novoNome);
            pessoas.get(i).setTelefone(novoTelefone);
            pessoas.get(i).setDatanascimento(novaDatanascimento);
            pessoas.get(i).setDatalastup(novaDatalastup);
            System.out.println("Pessoa atualizada!");
        }
    }
    public void atualizarAlu(Long antigoTel, String novoNome, Long novoTelefone, String novaDatanascimento, String novaDatalastup, Double novaNota) {
        for (int i = 0; i < alunos.size(); i++) {
            alunos.get(i).setNome(novoNome);
            alunos.get(i).setTelefone(novoTelefone);
            alunos.get(i).setDatanascimento(novaDatanascimento);
            alunos.get(i).setDatalastup(novaDatalastup);
            alunos.get(i).setNota(novaNota);
            System.out.println("Aluno atualizado");
        }
    }
    public void deletarPes(Long telDelete) {
        for (int i = 0; i < pessoas.size(); i++) {
            pessoas.remove(i);
            System.out.println("Pessoa deletada");
        }
    }
    public void deletarAlu(Long telDelete) {
        for (int i = 0; i < alunos.size(); i++) {
            alunos.remove(i);
            System.out.println("Aluno deletado");
        }
    }
}