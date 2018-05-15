/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula1;

/**
 *
 * @author QI
 */
public class Professor extends Pessoa {

    public Professor(int idade, String nome) {
        super(idade, nome);
    }

    @Override
    public String falar() {
        return "Olá turma, eu sou um professor super legal. "
                + super.falar(); 
    }
    
    
}
