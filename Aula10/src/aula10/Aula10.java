package aula10;

import db.DAOPersonagem;
import java.util.ArrayList;
import model.Personagem;

public class Aula10 {
    public static void main(String[] args) {
        DAOPersonagem d = new DAOPersonagem();
        ArrayList<Personagem> lista = d.getAll();
        for (Personagem p : lista) {
            System.out.println("Personagem: "+p.getId()+" - "+p.getNome());
            
        }
        
    }
    
}
