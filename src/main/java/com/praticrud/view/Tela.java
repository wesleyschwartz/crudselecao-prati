package com.praticrud.view;

import com.praticrud.repository.AlunoDAO;
import com.praticrud.repository.DAO;
import com.praticrud.repository.PessoaDAO;

import java.util.Scanner;

/**
 * @author wesle
 */
public class Tela {

    public static void Menu() {

        DAO dao = new DAO();
        Scanner ler = new Scanner(System.in);
        int op;
        int e; // variavel para chamar alunoDAO(e = 1) ou pessoaDAO(e = 2)
        do {
            System.out.println("\n O que deseja fazer?");
            System.out.println("\t 1-> Criar Pessoa/Aluno\t 2-> Gerenciar Alunos\t 3-> Gerenciar Pessoas\t 0-> Encerrar sistema");
            op = ler.nextInt();
            switch (op) {
                case 1:

                    dao.cadastrarDados(ler);
                    break;

                case 2: //MENU GERENCIAR ALUNOS
                    int op2;
                    e = 1;
                    do {
                        System.out.println("\t 1-> Listar alunos\t 2-> Atualizar alunos\t 3-> Deletar alunos\t 9-> Para voltar");
                        op2 = ler.nextInt();
                        switch (op2) {
                            case 1:
                                dao.listar(e);
                                break;

                            case 2:
                                dao.atualizarDados(e, ler);
                                break;

                            case 3:
                                dao.deletar(e, ler);
                                break;
                            case 9:
                                System.out.println("Voltando...");
                                break;
                            default:
                                System.out.println(" Opção inválida!!");
                        }
                    } while (op2 != 9);

                    break;

                case 3: //MENU GERENCIAR PESSOAS
                    int op3;
                    e = 2;
                    do {
                        System.out.println("\t 1-> Listar pessoas\t 2-> Atualizar pessoas\t 3-> Deletar pessoas\t 9-> Para voltar");
                        //variavel para chamar o pessoaDAO.listar();
                        op3 = ler.nextInt();
                        switch (op3) {
                            case 1:
                                dao.listar(e);
                                break;

                            case 2:
                                dao.atualizarDados(e, ler);
                                break;

                            case 3:
                                dao.deletar(e, ler);
                                break;
                            case 9:
                                System.out.println("Voltando...");
                                break;
                            default:
                                System.out.println(" Opção inválida!!");
                        }
                    } while (op3 != 9);

                    break;
                case 0:
                    System.out.println(" Encerrando Sistema..");
                    break;
                default:
                    System.out.println(" Opção inválida!!");
            }

        } while (op != 0);
        ler.close();
    }

}
