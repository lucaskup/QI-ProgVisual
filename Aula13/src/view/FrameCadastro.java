package view;

import db.DAOPersonagem;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import model.Personagem;

public class FrameCadastro extends JFrame {
    private JLabel lblId;
    private JLabel lblNome;
    private JTextField txtId;
    private JTextField txtNome;
    private JButton btnCriar;
    private JButton btnSalvar;
    
    private JCheckBox chkHumano;
    private JLabel lblProfissao;
    
    private JRadioButton radDeus;
    private JRadioButton radEmpresario;
    private JRadioButton radCientista;
    private JButton btnCarregar;
    
    private ArrayList<Personagem> lista;
    private DAOPersonagem dao;
    private ModeloParaTabela modeloTabela;
    
    
    public FrameCadastro(DAOPersonagem dao, ModeloParaTabela m) throws HeadlessException {
        this.dao = dao;
        this.modeloTabela = m;
        
        this.setSize(300, 400);
        
        
        lista = new ArrayList<Personagem>();
        lblId = new JLabel("id:");
        lblNome = new JLabel("nome:");
        chkHumano = new JCheckBox("Humano");
        
        txtId = new JTextField(3);
        txtNome = new JTextField(10);
        btnCriar = new JButton("Criar");
        btnSalvar = new JButton("Salvar");
        btnCarregar = new JButton("Carregar");
        
        lblProfissao = new JLabel("Profissão");
        radDeus = new JRadioButton("Deus");
        radDeus.setSelected(true);
        radCientista = new JRadioButton("Cientista");
        radEmpresario = new JRadioButton("Empresário");
        ButtonGroup bg = new ButtonGroup();
        bg.add(radDeus);
        bg.add(radEmpresario);
        bg.add(radCientista);
        
        
        this.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        //Define a posição x e y na qual queremos adicionar o campo
        gc.insets = new Insets(5, 5, 5, 5);
        gc.anchor = GridBagConstraints.EAST;
        gc.gridx = 0;
        gc.gridy = 0;
        //Adiciona o campo conforme as restricoes definidas em gc
        this.add(lblId,gc);
        
        gc.anchor = GridBagConstraints.WEST;
        gc.gridx = 1;
        gc.gridy = 0;
        this.add(txtId,gc);
        
        gc.anchor = GridBagConstraints.EAST;
        gc.gridx = 0;
        gc.gridy = 1;
        this.add(lblNome,gc);
        
        gc.anchor = GridBagConstraints.WEST;
        gc.gridx = 1;
        gc.gridy = 1;
        this.add(txtNome,gc);

        gc.anchor = GridBagConstraints.WEST;
        gc.gridx = 1;
        gc.gridy = 2;
        this.add(chkHumano,gc);
        
        gc.anchor = GridBagConstraints.EAST;
        gc.gridx = 0;
        gc.gridy = 3;
        this.add(lblProfissao,gc);
        
        gc.anchor = GridBagConstraints.WEST;
        gc.gridx = 1;
        gc.gridy = 3;
        this.add(radDeus,gc);

        gc.anchor = GridBagConstraints.WEST;
        gc.gridx = 1;
        gc.gridy = 4;
        this.add(radEmpresario,gc);
        
        gc.anchor = GridBagConstraints.WEST;
        gc.gridx = 1;
        gc.gridy = 5;
        this.add(radCientista,gc);
        
        gc.anchor = GridBagConstraints.EAST;
        gc.gridx = 0;
        gc.gridy = 6;
        this.add(btnCriar,gc);
        
        gc.anchor = GridBagConstraints.WEST;
        gc.gridx = 1;
        gc.gridy = 6;
        this.add(btnSalvar,gc);
        
        gc.anchor = GridBagConstraints.EAST;
        gc.gridx = 0;
        gc.gridy = 7;
        this.add(btnCarregar,gc);
        Container c = this.getContentPane();

        c.setBackground(Color.red);
        
        btnCriar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id;
                String nome;
                try{
                    

                    id = Integer.parseInt(txtId.getText());
                    nome = txtNome.getText();
                    boolean humano = chkHumano.isSelected();
                    String profissao;
                    if(radDeus.isSelected()){
                        profissao = "Deus";
                    }else if(radEmpresario.isSelected()){
                        profissao = "Empresário";
                    }else{
                        profissao = "Cientista";
                    }
                    int idade = 0;

                    Personagem p = new Personagem(nome,profissao,humano,idade);
        
                    dao.insert(p);
                    modeloTabela.atualizar(dao.getAll());
                    
                    JOptionPane.showMessageDialog(null,
                                    "Nome: "+p.getNome()
                                    + " Id: "+p.getId()
                                    + " Humano: "+p.isHumano()
                                    + " Profissão: "+p.getProfissao());
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(FrameCadastro.this,
                            "Revise os campos do formulário, possível id em branco");
                }
                
            }
        });
        

        
        this.setJMenuBar(this.criarMenu());
        
        this.setVisible(true);
    }
    
    public JMenuBar criarMenu(){
        JMenuBar menu = new JMenuBar();
        JMenu menuArquivo = new JMenu("Arquivo");
        JMenuItem menuIAbrir = new JMenuItem("Abrir");
        JMenuItem menuISalvar = new JMenuItem("Salvar");
        JMenuItem menuISair = new JMenuItem("Sair");
        
        menuISair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        menu.add(menuArquivo);
        menuArquivo.add(menuIAbrir);
        menuArquivo.add(menuISalvar);
        menuArquivo.add(new JSeparator());
        menuArquivo.add(menuISair);
        
        
        return menu;
    }   
}
