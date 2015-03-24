/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorialarquivos;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
  * @author Carlos Daniel, Fernando D, João M, Jonatha N, Monique M e Vanessa
 */
public class ManipulaFuncionarioOO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        //Declara o outputStream
        DataOutputStream out = null;
        //cria uma lista de funcionários
        List<FuncionarioOO> funcs = null;
        funcs = new ArrayList<FuncionarioOO>();
        
        //objeto para manipular Funcionário
        FuncionarioOO f;
        String resp;
       
        
        
        Scanner teclado = new Scanner(System.in);
        
        do{
        System.out.println("Digite o codigo do funcionario");
        f = new FuncionarioOO();
        f.setCodFuncionario(teclado.nextInt());
        
        teclado.nextLine();
        System.out.println("Digite o nome do funcionario");
        f.setNome(teclado.nextLine());
        
        System.out.println("Digite o CPF");
        f.setCpf(teclado.nextLine());
        
        System.out.println("Digite a data de nascimento");
        f.setDataNascimento(teclado.nextLine());
        
        System.out.println("Digite o salario");
        f.setSalario(teclado.nextDouble());
        teclado.nextLine();
        
        funcs.add(f);
        
        System.out.println("Deseja gravar um funcionario?");
        
        resp = teclado.nextLine();
        
        } while(resp.equals("sim"));
        

        try {
            System.out.println("Abrindo arquivo Funcionario.dat para gravação...");
            //passando true no FileOutputStrem, novos registros são adicionados ao arquivo, caso ele já exista
            out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("funcionario.dat", true)));
            System.out.println("Gravando dados no arquivo Funcionario.dat ...");
            for (int i = 0; i < funcs.size(); i++) {
                
                funcs.get(i).salva(out);  
   
            }
                  
        } finally {
            System.out.println("Fechando arquivo Funcionario.dat ...");
            if (out != null)
                out.close();
        }
        //Trecho para ler os dados
        //Declara o InputStream
        DataInputStream in = null;
        //Zera a lista de funcionários
        funcs = new ArrayList<FuncionarioOO>();        
        try {
            System.out.println("Abrindo arquivo Funcionario.dat para leitura...");
            in = new DataInputStream(new BufferedInputStream(new FileInputStream("funcionario.dat")));
            System.out.println("Lendos os dados do arquivo Funcionario.dat ...");

            while (true) {
                f = new FuncionarioOO();
                f.le(in);
                f.imprime();
                funcs.add(f);
                System.out.println();                
            }

        } catch (EOFException e) {
            //arquivo terminou
        } finally {
            System.out.println("Fechando arquivo Funcionario.dat ...");
            if (in != null)
                in.close();
        }
        System.out.println("Total de " + funcs.size() + " funcionários lidos!");
    }
}
