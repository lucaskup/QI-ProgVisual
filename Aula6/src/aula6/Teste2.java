package aula6;
public class Teste2 {
    public String toString(){
        try {
            Teste1 t1 = new Teste1();
            return "Estou na Teste 2 e " + t1.toString();
        } catch (ArithmeticException e) {
            return "Estou na Teste 2";
        }

    }
}
