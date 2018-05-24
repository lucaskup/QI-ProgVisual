package aula7arraylist;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Aula7ArrayList {
    public static void main(String[] args) {
        ArrayList<Coisa> lista = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Coisa c = new Coisa();
            c.setId(i+100);
            lista.add(c);       
        }
        
        //Encontra um elemento no arraylist
        //Pode ser usado para navegar entre os elementos
        System.out.println("O meu arraylist possui: "+lista.size() +" elementos");
        int valorMostrar = 0;
        valorMostrar = Integer.parseInt(JOptionPane
                .showInputDialog("Usuário, qual coisa você quer ver?"));
        System.out.println(lista.get(valorMostrar).getId());
        
        
        //Remove um elemento da lista
        int idExcluir = Integer.parseInt(JOptionPane
                .showInputDialog("Usuário, qual id você quer excluir?"));
        
        for (int i = 0; i < lista.size(); i++) {
            Coisa coisaDaLista = lista.get(i);
            if(coisaDaLista.getId() == idExcluir){
                lista.remove(i);
            }
        }
        
        //Atualiza um elemento da lista
        lista.get(2).setId(333);
        
        String texto = "";
        for (int i = 0; i < lista.size(); i++) {
            Coisa c = lista.get(i);
            texto += c.getId() + " - ";
        }
        JOptionPane.showMessageDialog(null, texto);
                
        
        
    }
    
}
