package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Personagem;

public class DAOPersonagem {
    private Connection c;
    public DAOPersonagem() {
        c = ConectarBD.getConnection();
    }
    
    public ArrayList<Personagem> getAll(){
        ArrayList<Personagem> lista = new ArrayList<>();
        try {            
            PreparedStatement st = c.prepareStatement("SELECT id, nome,"
                    +" profissao, idade, humano "
                    +"FROM personagem");
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                int id = rs.getInt(1);
                String nome = rs.getString(2);
                String profissao = rs.getString(3);
                int idade = rs.getInt(4);
                boolean humano = rs.getBoolean(5);
                Personagem p = new Personagem(id, nome, profissao, humano, idade);
                lista.add(p);
            }            
        } catch (SQLException ex) {
            Logger.getLogger(DAOPersonagem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    
}
