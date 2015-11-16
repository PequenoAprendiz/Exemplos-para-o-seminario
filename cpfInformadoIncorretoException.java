/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.wellington.systemavalidacpf;

/**
 *
 * @author Weré
 */
class cpfInformadoIncorretoException extends RuntimeException {
    public cpfInformadoIncorretoException(String cpf){
        System.out.println("Você está insrido um número com padrão incorreto de CPF!"+cpf);
    }    
}
