/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorialarquivos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Jonatha
 */
public class Conta {
    private int cod;
    private int codAg;
    private double saldo;
    ArrayList<Agencia> agencia = new ArrayList<Agencia>();
    
    public int getCod() {
        return cod;
    }
    
    public void salvar(DataOutputStream dos) throws IOException{
        dos.writeInt(cod);
        dos.writeInt(codAg);
        dos.writeDouble(saldo);
    }
    
    public void ler(DataInputStream dis) throws IOException{
        System.out.println("-------------------------------");
        System.out.println("Conta");
        System.out.println("Codigo: " + dis.readInt());
        System.out.println("Codigo da agencia: " + dis.readInt());
        System.out.println("Saldo: " + dis.readDouble());
        System.out.println("-------------------------------");
    }
    

    public void setCod(int cod) {
        this.cod = cod;
    }

    public int getCodAg() {
        return codAg;
    }

    public void setCodAg(int codAg) {
        this.codAg = codAg;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */