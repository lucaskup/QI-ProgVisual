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
public class Aluno extends Pessoa {

    public Aluno(int idade, String nome) {
        super(idade, nome);
    }

    @Override
    public String falar() {
        return "Sou um Aluno, "+ super.falar() ; 
    }
    
    
}
