package aula6;

import javax.swing.JOptionPane;

public class Aula6 {
    public static void main(String[] args) throws NumeroParException {
        System.out.println("Primeira Linha");
        /*
        try {
            int i = 5/5;
        } catch (ArithmeticException e) {
            System.out.println("Ocorreu uma divisão por zero");
        }*/
        /*
        Teste2 t2 = new Teste2();
        System.out.println(t2);
        */
        try {
            int i = Integer.parseInt(JOptionPane.showInputDialog("Digite um número inteiro"));
            if(i%2==0){
                throw new NumeroParException("Esse programa não aceita números pares, "
                                             +" número digitado: "+i);
            }
            System.out.println("Foi digitado o número "+i);
        } catch (NumberFormatException e) {
            System.out.println("Querido usuário, eu te pedi para digitar um número.");
        } catch (NumeroParException e){
            System.out.println(e.getMessage());
        }
        
        
        
    }
    
}
