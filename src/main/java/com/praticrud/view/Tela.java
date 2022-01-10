package com.praticrud.view;

import com.praticrud.controller.Controller;
import java.util.Scanner;

/**
 *
 * @author wesle
 */
public class Tela {

    public static void Menu() {

        Controller control = new Controller();

        Scanner ler = new Scanner(System.in);
        int op;
        do {
            System.out.println("\n O que deseja fazer?");
            System.out.println("\t 1-> Criar Pessoa/Aluno\t 2-> Gerenciar Alunos\t 3-> Gerenciar Pessoas\t 0-> Encerrar sistema");
            op = ler.nextInt();
            switch (op) {
                case 1:

                    control.cadastrarDados(ler);
                    break;

                case 2: //MENU GERENCIAR ALUNOS
                    int op2;
                    do {
                        System.out.println("\t 1-> Listar alunos\t 2-> Atualizar alunos\t 3-> Deletar alunos\t 9-> Para voltar");

                        op2 = ler.nextInt();
                        switch (op2) {
                            case 1:
                                control.listarDadosAlu();
                                break;

                            case 2:
                                control.atualizarDadosAlu(ler);
                                break;

                            case 3:
                                control.deletarAlu(ler);
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
                    do {
                        System.out.println("\t 1-> Listar pessoas\t 2-> Atualizar pessoas\t 3-> Deletar pessoas\t 9-> Para voltar");

                        op3 = ler.nextInt();
                        switch (op3) {
                            case 1:
                                control.listarDadosPes();
                                break;

                            case 2:
                                control.atualizarDadosPes(ler);
                                break;

                            case 3:
                                control.deletarPes(ler);
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
