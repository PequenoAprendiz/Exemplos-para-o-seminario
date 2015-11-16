package br.edu.ifnmg.wellington.systemavalidacpf;

import java.util.Scanner;

/**
 *
 * @author Weré
 */
public class SystemaValidaCpf {
    Scanner teclado = null;
    public static void main(String[] args) {
        SystemaValidaCpf systemaValidaCpf = new SystemaValidaCpf();
        systemaValidaCpf.inicio();
    }
    public void inicio() {
        teclado = new Scanner(System.in);
        System.out.println("......Validação de CPF......\n");
        System.out.println("Insira o Cpf:");
        String cpf = teclado.nextLine();
        ValidaCpf novaValidacao = new ValidaCpf();       
        try{
            novaValidacao.validar(cpf);
        }catch(cpfInformadoIncorretoException e){
            System.out.println(e.getMessage());
        }
        
    }
}
