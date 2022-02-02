package com.praticrud.repository;

import com.praticrud.controller.Controller;
import com.praticrud.model.Pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PessoaDAO {
    List<Pessoa> pessoas = new ArrayList<>();
    Controller control = new Controller();

    public void listar() {
        System.out.println("\n Lista de pessoas:");
        if (pessoas.isEmpty()) {
            System.out.println("\n Não há registro de pessoas...");
        } else {
            for (Pessoa pessoa : pessoas) {
                System.out.println("\t| ID: " + pessoa.getIdPessoa() + " |"
                        + "\t Nome: " + pessoa.getNome() + " |"
                        + "\t| Número de telefone: " + pessoa.getTelefone() + " |"
                        + "\t| Data de Nascimento: " + pessoa.getDataNascimento() + " |"
                        + "\t| Data de Cadastro: " + pessoa.getDataCadastro() + " |"
                        + "\t| Data da última alteração: " + pessoa.getDataLastUp() + " |"
                        + "\n");
            }
        }
    }

    public void atualizarDados(Scanner ler) {
        System.out.println("Informe o ID");
        int id = control.checkId(ler);
        boolean pessoaExiste = buscaId(id);
        if (pessoaExiste) {
            System.out.println("Digite um novo nome");
            String novoNome = ler.next();
            System.out.println("Informe novo telefone: ");
            Long novoTelefone = control.checkTelefone(ler);
            //registrar data de nascimento
            System.out.println("Informe nova data de nascimento como no exemplo: 22/04/1995 || dd/MM/YYYY");
            String novaDatanascimento = control.checkDataNascimento(ler);
            //registrar data do ultimo update
            String novaDatalastup = control.checkDataLastUp();

            atualizar(id, novoNome, novoTelefone, novaDatanascimento, novaDatalastup);
        } else {
            System.out.println("Pessoa não encontrada");
        }
    }

    public boolean buscaId(int id) {

        for (Pessoa pessoa : pessoas) {
            if (pessoa.getIdPessoa().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public void atualizar(Integer id, String novoNome, Long novoTelefone, String novaDatanascimento, String novaDatalastup) {
        pessoas.get(id).setNome(novoNome);
        pessoas.get(id).setTelefone(novoTelefone);
        pessoas.get(id).setDataNascimento(novaDatanascimento);
        pessoas.get(id).setDataLastUp(novaDatalastup);
        System.out.println("Pessoa atualizada!");
    }

    public void deletar(Scanner ler) {
        System.out.println("Informe o ID");
        int id = control.checkId(ler);
        boolean pessoaExiste = buscaId(id);
        if (pessoaExiste) {
            pessoas.remove(id);
            System.out.println("Pessoa deletada");
        } else {
            System.out.println("Pessoa não encontrada");
        }

    }
}


