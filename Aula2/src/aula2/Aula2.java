/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula2;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;

public class Aula2 {

    public static void main(String[] args) {
        //exemploJOptionPane();
        MeioDeTransporte m1 = new Uber();
        MeioDeTransporte m2 = new Onibus();
        JOptionPane.showMessageDialog(null, Float.MAX_VALUE);
        JOptionPane.showMessageDialog(null, "O custo de andar"
                + " 10km com o transporte m1 é: " + m1.locomover(10)
                +".\n  Com o transporte m2 é: "+ m2.locomover(10));
        
    }
    
    
    

    private static void exemploJOptionPane() throws HeadlessException, NumberFormatException {
        //Exibe uma mensagem informativa para o usuário
        JOptionPane.showMessageDialog(null, "Alo \nMundo!");
        
        String informacaoDigitada;
        //Solicita que o usuario digite uma informação
        informacaoDigitada = JOptionPane
                .showInputDialog("Digite a sua idade");
        JOptionPane.showMessageDialog(null, informacaoDigitada);
        //Para converter o valor digitado para um inteiro,
        //necessitamos efetuar conversao
        //Solicitamos confirmação do usuário para mostrar suad
        //idade daqui a 20 anos
        int resposta = JOptionPane.showConfirmDialog(null,
                "Você quer saber a sua idade daqui a 20 anos?");
        //Aqui realizamos um teste para saber o que o usuario
        //respondeu
        //Caso afirmativo
        if(resposta == JOptionPane.YES_OPTION){
            int idade = Integer.parseInt(informacaoDigitada);
            idade += 20;
            JOptionPane.showMessageDialog(null,
                    "Sua idade depois de 20 anos vai ser: " + idade);
            //caso negativo
        }else{
            JOptionPane.showMessageDialog(null, "Ok, não vou mostrar");
        }
    }
    
}
