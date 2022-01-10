package com.praticrud.controller;
import com.praticrud.repository.DAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
/**
 *
 * @author wesle
 */
public class Controller {

    DAO dao = new DAO();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy kk:mm:ss");
    public void cadastrarDados(Scanner ler) {
        System.out.println(
                "Digite o nome da pessoa:");
        String nome = ler.next();
        //registrar telefone

        System.out.println(
                "Informe o telefone: ");
        Boolean tel = false;
        String stelefone = "";
        Long telefone = 0L;
        while (!tel) {
            try {
                stelefone = ler.next();
                telefone = Long.parseLong(stelefone);
                tel = true;
            } catch (NumberFormatException e) {
                System.out.println("Por favor, informe apenas números");
            }
        }
        //registrar data de nascimento

        System.out.println(
                "Informe a data de nascimento como no exemplo: 22/04/1995 || dd/MM/YYYY");
        String snasc = "";
        Date dnasc = null;
        String datanascimento = "";
        Boolean datapronta = false;
        while (!datapronta) {
            try {
                snasc = ler.next();
                dnasc = sdf.parse(snasc);
                datanascimento = sdf.format(dnasc);
                datapronta = true;
            } catch (ParseException e) {
                System.out.println("Por favor informe a data no formato correto como no exemplo: 01/01/2021 || dd/MM/YYYY");
            }
        }
        //registrar data de cadastro
        Date ddatacadastro = new Date();

        ddatacadastro.getTime();
        String datacadastro = sdf2.format(ddatacadastro);

        //registrar data do ultimo update
        Date ddatalastup = new Date();

        ddatalastup.getTime();
        String datalastup = sdf2.format(ddatalastup);

        //adicionar a Alunos se nota preenchido, se não adicionar a Seres
        System.out.println(
                "\nQuer registar um Aluno? \nSe sim, informe uma nota.\t Se não, aperte enter e registre uma pessoa.");
        boolean ok = false;
        ler.nextLine();
        while (!ok) {
            String linha = ler.nextLine();
            if (linha.isEmpty()) {
                dao.inserirPes(nome, telefone, datanascimento, datacadastro, datalastup);
                ok = true;
            } else {
                Double nota = 0D;
                try {
                    nota = Double.parseDouble(linha);
                    if (nota >= 0 && nota <= 10) {
                        dao.inserirAlu(nome, telefone, datanascimento, datacadastro, datalastup, nota);
                        ok = true;
                    } else {
                        System.out.println("Informe números entre 0  e 10");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Por favor, informe apenas números...");
                }
            }
        }
    }
    public void listarDadosPes() {
        dao.listarPes();
    }

    public void listarDadosAlu() {
        dao.listarAlu();
    }
    public void atualizarDadosPes(Scanner ler) {
        System.out.println("Informe o número de telefone da pessoa para atualizar");
        Boolean oktel = false;
        String stelefone = "";
        Long antigoTel = 0L;
        while (!oktel) {
            try {
                stelefone = ler.next();
                antigoTel = Long.parseLong(stelefone);
                oktel = true;
            } catch (NumberFormatException e) {
                System.out.println("Por favor, informe apenas números");
            }
        }
        boolean pessoaExiste = dao.buscaPes(antigoTel);
        if (pessoaExiste == true) {
            System.out.println("Digite um novo nome");
            String novoNome = ler.next();
            System.out.println("Informe novo telefone: ");
            Boolean tel = false;
            String stelefone2 = "";
            Long novoTelefone = 0L;
            while (!tel) {
                try {
                    stelefone2 = ler.next();
                    novoTelefone = Long.parseLong(stelefone2);
                    tel = true;
                } catch (NumberFormatException e) {
                    System.out.println("Por favor, informe apenas números");
                }
            }
            //registrar data de nascimento
            System.out.println("Informe nova data de nascimento como no exemplo: 22/04/1995 || dd/MM/YYYY");
            String pnsnasc = "";
            Date pndnasc = null;
            String novaDatanascimento = "";
            Boolean pndatapronta = false;
            while (!pndatapronta) {
                try {
                    pnsnasc = ler.next();
                    pndnasc = sdf.parse(pnsnasc);
                    novaDatanascimento = sdf.format(pndnasc);
                    pndatapronta = true;
                } catch (ParseException e) {
                    System.out.println("Por favor informe a data no formato correto como no exemplo: 01/01/2021 || dd/MM/YYYY");
                }
            }
            //registrar data do ultimo update
            Date ddatalastup = new Date();
            ddatalastup.getTime();
            String novaDatalastup = sdf2.format(ddatalastup);
            dao.atualizarPes(antigoTel, novoNome, novoTelefone, novaDatanascimento, novaDatalastup);
        } else {
            System.out.println("Pessoa não encontrada");
        }
    }

    public void atualizarDadosAlu(Scanner ler) {

        System.out.println("Informe o número de telefone da pessoa para atualizar");
        Boolean oktel = false;
        String stelefone = "";
        Long antigoTel = 0L;
        while (!oktel) {
            try {
                stelefone = ler.next();
                antigoTel = Long.parseLong(stelefone);
                oktel = true;
            } catch (NumberFormatException e) {
                System.out.println("Por favor, informe apenas números");
            }
        }
        boolean alunoExiste = dao.buscaAlu(antigoTel);
        if (alunoExiste == true) {
            System.out.println("Digite um novo nome");
            String novoNome = ler.next();
            System.out.println("Informe novo telefone: ");
            Boolean tel = false;
            String stelefone2 = "";
            Long novoTelefone = 0L;
            while (!tel) {
                try {
                    stelefone2 = ler.next();
                    novoTelefone = Long.parseLong(stelefone2);
                    tel = true;
                } catch (NumberFormatException e) {
                    System.out.println("Por favor, informe apenas números");
                }
            }
            //registrar data de nascimento
            System.out.println("Informe nova data de nascimento como no exemplo: 22/04/1995 || dd/MM/YYYY");
            String snasc = "";
            Date dnasc = null;
            String novaDatanascimento = "";
            Boolean datapronta = false;
            while (!datapronta) {
                try {
                    snasc = ler.next();
                    dnasc = sdf.parse(snasc);
                    novaDatanascimento = sdf.format(dnasc);
                    datapronta = true;
                } catch (ParseException e) {
                    System.out.println("Por favor informe a data no formato correto como no exemplo: 01/01/2021 || dd/MM/YYYY");
                }
            }
            //registrar data do ultimo update
            Date ddatalastup = new Date();
            ddatalastup.getTime();
            String novaDatalastup = sdf2.format(ddatalastup);
            //registra nota
            System.out.println("Informe a nova nota:");
            boolean ok = false;
            Double novaNota = 0D;
            ler.nextLine();
            while (!ok) {
                String linha = ler.nextLine();
                try {
                    novaNota = Double.parseDouble(linha);
                    if (novaNota >= 0 && novaNota <= 10) {
                        dao.atualizarAlu(antigoTel, novoNome, novoTelefone, novaDatanascimento, novaDatalastup, novaNota);
                        ok = true;
                    } else {
                        System.out.println("Informe números entre 0  e 10");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Por favor, informe apenas números...");
                }
            }
        } else {
            System.out.println("Aluno não encontrado");
        }
    }

    public void deletarPes(Scanner ler) {

        System.out.println("Informe o telefone para realizar exclusão");
        Boolean tel = false;
        String stelefone = "";
        Long telDelete = 0L;
        while (!tel) {
            try {
                stelefone = ler.next();
                telDelete = Long.parseLong(stelefone);
                tel = true;
            } catch (NumberFormatException e) {
                System.out.println("Por favor, informe apenas números");
            }
        }
        boolean pessoaExiste = dao.buscaPes(telDelete);
        if (pessoaExiste == true) {
            dao.deletarPes(telDelete);
        } else {
            System.out.println("Pessoa não encontrada");
        }
    }
    public void deletarAlu(Scanner ler) {
        System.out.println("Informe o telefone para realizar exclusão");
        Boolean tel = false;
        String stelefone = "";
        Long telDelete = 0L;
        while (!tel) {
            try {
                stelefone = ler.next();
                telDelete = Long.parseLong(stelefone);
                tel = true;
            } catch (NumberFormatException e) {
                System.out.println("Por favor, informe apenas números");
            }
        }
        boolean alunoExiste = dao.buscaAlu(telDelete);
        if (alunoExiste == true) {
            dao.deletarAlu(telDelete);
        } else {
            System.out.println("Aluno não encontrada");
        }
    }
}
