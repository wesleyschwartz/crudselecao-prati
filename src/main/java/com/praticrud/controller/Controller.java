package com.praticrud.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author Wesley Schwartz
 */
public class Controller {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy kk:mm:ss");
    Boolean check = false;

    public long checkTelefone(Scanner ler) {
        check = false;
        Long telefone = 0L;
        while (!check) {
            try {
                String sTelefone = ler.next();
                telefone = Long.parseLong(sTelefone);
                check = true;
            } catch (NumberFormatException e) {
                System.out.println("Por favor, informe apenas números");
            }

        }
        return telefone;
    }

    public String checkDataNascimento(Scanner ler) {
        check = false;
        String dataNascimento = "";
        while (!check) {
            try {
                String lerNascimento = ler.next();
                Date parseDataNascimento = sdf.parse(lerNascimento);
                dataNascimento = sdf.format(parseDataNascimento);
                check = true;
            } catch (ParseException e) {
                System.out.println("Por favor informe a data no formato correto como no exemplo: 01/01/2021 || dd/MM/YYYY");
            }
        }
        return dataNascimento;
    }

    public String checkDataCadastro() {
        Date dateDataCadastro = new Date();
        dateDataCadastro.getTime();
        String dataCadastro = sdf2.format(dateDataCadastro);
        return dataCadastro;
    }

    public String checkDataLastUp() {
        Date dateDataLastUp = new Date();
        dateDataLastUp.getTime();
        String dataLastUp = sdf2.format(dateDataLastUp);
        return dataLastUp;
    }

    public Double checkNota(String linha, Scanner ler) {
        Double nota = 0D;
        check = false;
        while (!check) {
            try {
                nota = Double.parseDouble(linha);
                if (nota >= 0 && nota <= 10) {
                    check = true;
                } else {
                    System.out.println("Informe números entre 0  e 10");
                    linha = ler.next();
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, informe apenas números...");
                linha = ler.next();
            }
        }
        return nota;
    }

    public int checkId(Scanner ler) {

        check = false;
        int id = 0;
        while (!check) {
            try {
                String sId = ler.next();
                id = Integer.parseInt(sId);
                check = true;
            } catch (NumberFormatException e) {
                System.out.println("Por favor, informe apenas números");
            }

        }
        return id;
    }
}





