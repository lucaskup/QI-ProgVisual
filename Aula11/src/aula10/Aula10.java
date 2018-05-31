package aula10;

import db.DAOPersonagem;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Personagem;

public class Aula10 {
    public static void main(String[] args) {
        DAOPersonagem d = new DAOPersonagem();
        ArrayList<Personagem> lista = d.getAll();
        for (Personagem p : lista) {
            System.out.println("Personagem: "+p.getId()+" - "+p.getNome());
            
        }
        /*
        Personagem p = new Personagem("DeadPool", "Mercenário", true, 30);
        d.insert(p);
        
         p = new Personagem(JOptionPane.showInputDialog("Digite o nome do personagem!"),
                 JOptionPane.showInputDialog("Digite a profissao do personagem!"),
                 true,
                 29);
         d.insert(p);
         JOptionPane.showMessageDialog(null, "O personagem de id: "
                 +p.getId()+" foi criado!");
         
         p.setNome("Dolores");
         d.update(p);
         */
         //d.delete(8);
         Personagem p = d.getByID(10);
         JOptionPane.showMessageDialog(null, "Nome Personagem: "
                 + p.getNome());
         
        
        
    }
    
}
