package aula5;

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
    
    
    
    public FrameCadastro() throws HeadlessException {
        this.setSize(300, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
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
        
        btnCriar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id;
                String nome;
                
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
                
                
                Personagem p = new Personagem(id,nome,humano,profissao);
                lista.add(p);
                JOptionPane.showMessageDialog(null,
                                "Nome: "+p.getNome()
                                + " Id: "+p.getId()
                                + " Humano: "+p.isHumano()
                                + " Profissão: "+p.getProfissao());
                
            }
        });
        
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileWriter fw =
                            new FileWriter("C:\\Users\\QI\\Documents\\Personagens.csv");
                    for (Personagem personagem : lista) {
                        fw.write(personagem.mostrarEmCSV()
                                + System.lineSeparator());
                    }
                    fw.close();
                } catch (IOException ex) {
                    Logger.getLogger(FrameCadastro.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        btnCarregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    lista = new ArrayList<>();
                    FileReader fr = 
                            new FileReader("C:\\Users\\QI\\Documents\\Personagens.csv");
                    BufferedReader br = new BufferedReader(fr);
                    while(br.ready()){
                        String linha = br.readLine();
                        //Realiza um split da linha para facilitar
                        //a busca das informações [id,nome,humano,profissao]
                        String[] csv = linha.split(";");
                        //Extrai do csv cada atributo do nosso personagem
                        int id = Integer.parseInt(csv[0]);
                        String nome = csv[1];
                        boolean isHumano = Boolean.parseBoolean(csv[2]);
                        String profissao = csv[3];
                        
                        Personagem p =
                                new Personagem(id, nome, isHumano, profissao);
                        lista.add(p);
                    }
                    br.close();
                    JOptionPane
                            .showMessageDialog(FrameCadastro.this,
                                    "Foram importados "+lista.size()+" personagens");
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(FrameCadastro.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(FrameCadastro.class.getName()).log(Level.SEVERE, null, ex);
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
