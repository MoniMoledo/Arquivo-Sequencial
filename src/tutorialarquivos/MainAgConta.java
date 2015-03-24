/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorialarquivos;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Carlos Daniel, Fernando D, João M, Jonatha N e Monique M
 */
public class MainAgConta {

    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        ArrayList<Conta> contas = new ArrayList<Conta>();
        ArrayList<Agencia> agencias = new ArrayList<Agencia>();
        DataOutputStream out = null;
        DataInputStream in = null;
        Agencia ag;
        Conta cc;
        String resp;
        String arq = null;
        System.out.println("Deseja gravar em contas.dat ou agencias.dat?");
        arq = teclado.nextLine();
        //tratando o caso de contas e escrevendo do arquivo
        if (arq.equals("contas.dat")) {
            do {
                cc = new Conta();
                System.out.println("Digite o codigo:");
                cc.setCod(teclado.nextInt());
                teclado.nextLine();
                System.out.println("Digite o codigo da agencia:");
                cc.setCodAg(teclado.nextInt());
                teclado.nextLine();
                System.out.println("Digite o saldo:");
                cc.setSaldo(teclado.nextDouble());
                teclado.nextLine();
                contas.add(cc);
                System.out.println("Deseja adicionar mais alguma conta?");
                resp = teclado.nextLine();
            } while (resp.equals("sim"));
            try {
                
                out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("contas.dat", true)));
                for (int i = 0; i < contas.size(); i++) {
                    System.out.println("printando o array de contas codigo:   "+ contas.get(i).getCod());
                    contas.get(i).salvar(out);
                }

            } finally {

                if (out != null) {
                    out.close();
                }

            }
        }

        //Tratando o caso de agências e escrevendo no arquivo
        if (arq.equals("agencias.dat")) {
            do {
                ag = new Agencia();
                System.out.println("Digite o codigo da agencia:");
                ag.setCod(teclado.nextInt());
                teclado.nextLine();
                System.out.println("Digite o nome da agencia:");
                ag.setNome(teclado.nextLine());
                System.out.println("Digite o nome do gerente:");
                ag.setGerente(teclado.nextLine());
                agencias.add(ag);

                System.out.println("Deseja adicionar mais alguma agencia?");
                resp = teclado.nextLine();
            } while (resp.equals("sim"));
            try {

                out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("agencias.dat", true)));
                for (int i = 0; i < agencias.size(); i++) {
                    agencias.get(i).salvar(out);
                }

            } finally {

                if (out != null) {
                    out.close();
                }

            }
        }

        //Leitura
        System.out.println("Deseja ler contas.dat ou agencias.dat?");
        arq = teclado.nextLine();
        //lendo arquivo de contas
        if (arq.equals("contas.dat")) {
            try {
                in = new DataInputStream(new BufferedInputStream(new FileInputStream("contas.dat")));
                while (true) {
                    cc = new Conta();
                    cc.ler(in);
                }

            } catch (EOFException e) {

            } finally {
                if (in != null) {
                    in.close();
                }
            }
        }

        //lendo arquivo de agências
        if (arq.equals("agencias.dat")) {
            try {
                in = new DataInputStream(new BufferedInputStream(new FileInputStream("agencias.dat")));
                while (true) {
                    ag = new Agencia();
                    ag.ler(in);
                }

            } catch (EOFException e) {

            } finally {
                if (in != null) {
                    in.close();
                }
            }
        }
    }
}
