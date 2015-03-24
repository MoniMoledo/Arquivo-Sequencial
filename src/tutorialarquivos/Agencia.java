
package tutorialarquivos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 *
 * @author Carlos Daniel, Fernando D, João M, Jonatha N e Monique M
 */
public class Agencia {
    private int cod;
    private String nome;
    private String gerente;
    public int getCod() {
        return cod;
    }

    
    
    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGerente() {
        return gerente;
    }

    public void setGerente(String gerente) {
        this.gerente = gerente;
    }
    
    public void salvar(DataOutputStream dos) throws IOException{
        dos.writeInt(cod);
        dos.writeUTF(nome);
        dos.writeUTF(gerente);
    }
    
    public void ler(DataInputStream dis) throws IOException{
        System.out.println("-------------------------------");
        System.out.println("Agencia");
        System.out.println("Codigo: " + dis.readInt());
        System.out.println("Nome: " + dis.readUTF());
        System.out.println("Gerente: " + dis.readUTF());
        System.out.println("-------------------------------");
    }
    
   
}
