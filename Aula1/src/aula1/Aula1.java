package aula1;

import java.util.ArrayList;
import java.util.Scanner;

public class Aula1 {

    public static void main(String[] args) {
        //testeCastDeTipos();
        //segundaParteHeranca();
        ArrayList<Animal> lista = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        
        do{
            System.out.println("Digite 1 para Gato ou 2 para Cachorro");

            int opcao = sc.nextInt();
            Animal a;
            if(opcao == 1){
                a = new Gato();
            }else{
                a = new Cachorro();
            }
            lista.add(a);

            System.out.println("Deseja continuar inserindo animais? [1 para sim ou 2 para não");
        }while(sc.nextInt() == 1);
        for (Animal animal : lista) {
            System.out.println(animal.falar());
        }
        
        
    }

    private static void segundaParteHeranca() {
        
        Pessoa p1 = new Professor(29,"Lucas");
        Pessoa p2 = new Aluno(15,"Joaozinho");
        Pessoa p3 = new Pessoa(20,"Mariazinha");
        
        ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
        pessoas.add(p1);
        pessoas.add(p2);
        pessoas.add(p3);
        
        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa.falar());
        }
    }
/***
 * Método criado no começo da aula para teste de tipos
 * e conversão entre eles
 * @throws NumberFormatException 
 */
    private static void testeCastDeTipos() throws NumberFormatException {
        //Declaração de variáveis
        byte b = 10;
        int i = 120;
        long l = 10;

        //System.out.println("O valor do byte é: "+ b + b);
        //Exemplo de cast explícito de int para byte
        b = (byte) (i + b);
        System.out.println("O valor máximo de um Byte "
                + Byte.MAX_VALUE
                + "\nO Valor mínimo de um Byte é:"
                + Byte.MIN_VALUE);
        //Exemplo de cast implícito para String
        System.out.println("O valor do int é: " + b);

        Scanner sc = new Scanner(System.in);
        System.out.println("Insira um número: ");
        String usuarioDigitou = sc.nextLine();
        //Exemplo de cast explícito para int
        //esse cast pode gerar uma exception
        //em tempo de execução

        i = i + Integer.parseInt(usuarioDigitou);

        System.out.println(i);
    }

}
