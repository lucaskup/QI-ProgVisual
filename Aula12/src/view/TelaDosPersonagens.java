package view;

import db.DAOPersonagem;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import model.Personagem;

public class TelaDosPersonagens extends JFrame {
    private JButton btnCriar;
    private DAOPersonagem dao;
    private ModeloParaTabela modelo;
    
    public TelaDosPersonagens() throws HeadlessException {
        this.setSize(700,400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        this.setLayout(new BorderLayout());
        JPanel p = new JPanel();
        
        modelo = new ModeloParaTabela();
        dao = new DAOPersonagem();
        modelo.atualizar(dao.getAll());
        
        JTable tabela = new JTable(modelo);
        
        p.add(new JScrollPane(tabela));
        
        this.add(p, BorderLayout.CENTER);
        
        btnCriar = new JButton("Criar");
        JPanel painelBtn = new JPanel();
        painelBtn.setLayout(new FlowLayout(FlowLayout.RIGHT));
        painelBtn.add(btnCriar);
        this.add(painelBtn, BorderLayout.SOUTH);
        btnCriar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dao.insert(new Personagem("Deadpool", "mercenário", true, 35));
                modelo.atualizar(dao.getAll());
            }
        });
        
        this.setVisible(true);
    }
    
    
}
