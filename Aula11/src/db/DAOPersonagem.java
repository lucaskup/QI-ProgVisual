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
                Personagem p = new Personagem(nome, profissao, humano, idade);
                p.setId(id);
                lista.add(p);
            }            
        } catch (SQLException ex) {
            Logger.getLogger(DAOPersonagem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public void insert(Personagem p){
        try {
            PreparedStatement ps
                    = c.prepareStatement("INSERT INTO personagem "+
                            "(nome,profissao,idade,humano) "+
                            " values (?,?,?,?)",
                            PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, p.getNome());
            ps.setString(2, p.getProfissao());
            ps.setInt(3, p.getIdade());
            ps.setBoolean(4, p.isHumano());
            
            ps.executeUpdate();
            ResultSet r = ps.getGeneratedKeys();
            if(r.next()){
                p.setId(r.getInt(1));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOPersonagem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update(Personagem p){
        try {
            PreparedStatement ps = c.prepareStatement("UPDATE personagem "+
                    " SET nome = ?, profissao = ?, "+
                    " idade = ?, humano = ? " +
                    " WHERE id = ?");
            ps.setString(1, p.getNome());
            ps.setString(2, p.getProfissao());
            ps.setInt(3, p.getIdade());
            ps.setBoolean(4, p.isHumano());
            ps.setInt(5, p.getId());
            
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOPersonagem.class.getName()).log(Level.SEVERE, null, ex);
        }
 
        
    }
    
    public void delete(int id){
        try {
            PreparedStatement p = c.prepareCall("DELETE FROM personagem "+
                    "WHERE id = ?");
            p.setInt(1, id);
            p.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOPersonagem.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
  
    public Personagem getByID(int id){
        Personagem p = null;
        try {            
            PreparedStatement st = c.prepareStatement("SELECT id, nome,"
                    +" profissao, idade, humano "
                    +"FROM personagem"
                    +" WHERE id = ?");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                String nome = rs.getString(2);
                String profissao = rs.getString(3);
                int idade = rs.getInt(4);
                boolean humano = rs.getBoolean(5);
                p = new Personagem(nome, profissao, humano, idade);
                p.setId(id);

            }            
        } catch (SQLException ex) {
            Logger.getLogger(DAOPersonagem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
    
}
