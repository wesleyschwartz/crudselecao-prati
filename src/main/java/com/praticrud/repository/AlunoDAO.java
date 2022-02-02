package com.praticrud.repository;

import com.praticrud.controller.Controller;
import com.praticrud.model.Aluno;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlunoDAO {
    List<Aluno> alunos = new ArrayList<>();
    Controller control = new Controller();

    public void listar() {
        System.out.println("\n Lista de alunos:");
        if (alunos.isEmpty()) {
            System.out.println("\n Não há registro de alunos...");
        } else {
            for (Aluno aluno : alunos) {
                System.out.println("\t| ID: " + aluno.getIdAluno() + " |"
                        + "\t Nome: " + aluno.getNome() + " |"
                        + "\t| Número de telefone: " + aluno.getTelefone() + " |"
                        + "\t| Data de Nascimento: " + aluno.getDataNascimento() + " |"
                        + "\t| Nota: " + aluno.getNota() + " |"
                        + "\t| Data de Cadastro: " + aluno.getDataCadastro() + " |"
                        + "\t| Data da última alteração: " + aluno.getDataLastUp() + " |"
                        + "\n");

            }
        }
    }

    public void atualizarDados(Scanner ler) {
        System.out.println("Informe o ID");
        int id = control.checkId(ler);
        boolean alunoExiste = buscaId(id);
        if (alunoExiste) {
            System.out.println("Digite um novo nome");
            String novoNome = ler.next();
            System.out.println("Informe novo telefone: ");
            Long novoTelefone = control.checkTelefone(ler);
            //registrar data de nascimento
            System.out.println("Informe nova data de nascimento como no exemplo: 22/04/1995 || dd/MM/YYYY");
            String novaDatanascimento = control.checkDataNascimento(ler);
            //registrar data do ultimo update
            String novaDatalastup = control.checkDataLastUp();
            //registar nova nova
            System.out.println("Informe a nova nota");
            String linha = ler.next();
            Double novaNota = control.checkNota(linha, ler);
            atualizar(id, novoNome, novoTelefone, novaDatanascimento, novaDatalastup, novaNota);
        } else {
            System.out.println("Aluno não encontrado");
        }
    }

    public boolean buscaId(int id) {
        for (Aluno aluno : alunos) {
            if (aluno.getIdAluno().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public void atualizar(Integer id, String novoNome, Long novoTelefone, String novaDatanascimento, String novaDatalastup, Double novaNota) {
        alunos.get(id).setNome(novoNome);
        alunos.get(id).setTelefone(novoTelefone);
        alunos.get(id).setDataNascimento(novaDatanascimento);
        alunos.get(id).setDataLastUp(novaDatalastup);
        alunos.get(id).setNota(novaNota);
        System.out.println("Aluno atualizado");
    }

    public void deletar(Scanner ler) {
        System.out.println("Informe o ID");
        int id = control.checkId(ler);
        boolean alunoExiste = buscaId(id);
        if (alunoExiste) {
            alunos.remove(id);
            System.out.println("Aluno deletado");
        }else{
            System.out.println("Aluno não encontrado");
        }
    }
}

