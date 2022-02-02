package com.praticrud.repository;

import com.praticrud.controller.Controller;
import com.praticrud.model.Aluno;
import com.praticrud.model.Pessoa;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * @author wesle
 */
public class DAO {

    Controller control = new Controller();

    AlunoDAO alunoDAO = new AlunoDAO();
    PessoaDAO pessoaDAO = new PessoaDAO();

    public void cadastrarDados(Scanner ler) {

        System.out.println("Digite o nome da pessoa:");
        String nome = ler.next();

        //registrar telefone
        System.out.println("Informe o telefone: ");
        long telefone = control.checkTelefone(ler);

        //registrar data de nascimento

        System.out.println("Informe a data de nascimento como no exemplo: 22/04/1995 || dd/MM/YYYY");
        String dataNascimento = control.checkDataNascimento(ler);

        //registrar data de cadastro

        String dataCadastro = control.checkDataCadastro();

        //registrar data do ultimo update
        String dataLastUp = control.checkDataLastUp();

        int id = 0;

        //adicionar a Alunos se nota preenchido, se não adicionar a pessoas
        System.out.println("\nQuer registar um Aluno? \nSe sim, informe uma nota.\t Se não, aperte enter e registre uma pessoa.");
        ler.nextLine();
        String linha = ler.nextLine();
        if (linha.isEmpty()) {
            Pessoa pessoa = new Pessoa(id, nome, telefone, dataNascimento, dataCadastro, dataLastUp);
            pessoaDAO.pessoas.add(pessoa);
            System.out.println("Pessoa cadastrada");
        } else {
            Double nota = control.checkNota(linha, ler);
            Aluno aluno = new Aluno(nome, telefone, dataNascimento, dataCadastro, dataLastUp, id, nota);
            alunoDAO.alunos.add(aluno);
            System.out.println("Aluno cadastrado");
        }
    }

    public void listar(int e) {
        if (e == 2) {
            pessoaDAO.listar();
        } else if (e == 1) {
            alunoDAO.listar();
        }
    }

    public void atualizarDados(int e, Scanner ler) {
        if (e == 2) {
            pessoaDAO.atualizarDados(ler);
        } else if (e == 1) {
            alunoDAO.atualizarDados(ler);
        }
    }
    public void deletar(int e, Scanner ler) {
        if (e == 2) {
            pessoaDAO.deletar(ler);
        } else if (e == 1) {
            alunoDAO.deletar(ler);
        }
    }

}