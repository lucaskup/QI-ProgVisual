package aula7;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Tela extends JFrame {
    private JLabel lblNome;
    private JTextField txtNome;
    private JButton btnConfirmar;
    private JRadioButton radCientista;
    private JRadioButton radEmpresario;
    private JRadioButton radMercenario;
    private JRadioButton radEstudante;
    private JRadioButton radJornalista;
    private JRadioButton radMilitar;

    public Tela() throws HeadlessException {
        lblNome = new JLabel("Digite o nome:");
        txtNome = new JTextField(6);
        btnConfirmar = new JButton();
        radCientista = new JRadioButton("Cientista");
        radEmpresario = new JRadioButton("Empresario");
        radEstudante = new JRadioButton("Estudante");
        radJornalista = new JRadioButton("Jornalista");
        radMercenario = new JRadioButton("Mercenário");
        radMilitar = new JRadioButton("Militar");
        
        ButtonGroup btg = new ButtonGroup();
        btg.add(radCientista);
        btg.add(radEmpresario);
        btg.add(radEstudante);
        btg.add(radJornalista);
        btg.add(radMercenario);
        btg.add(radMilitar);
        
        BufferedImage buttonIcon = null;
        BufferedImage buttonPressIcon = null;

        try {
            // Get the image and set it to the imageicon
            buttonIcon = ImageIO.read(getClass().getClassLoader().getResource("aula7/botao.png"));
            buttonPressIcon = ImageIO.read(getClass().getClassLoader().getResource("aula7/botao1.png"));
        }
        catch(Exception ex) {

        }
        
        Image img = buttonIcon.getScaledInstance( 100, 40,  java.awt.Image.SCALE_SMOOTH ) ;  
        Image imgPressed = buttonPressIcon.getScaledInstance( 100, 40,  java.awt.Image.SCALE_SMOOTH ) ;
        
        btnConfirmar.setBorderPainted(false);
        btnConfirmar.setContentAreaFilled(false);
        btnConfirmar.setFocusPainted(false);
        btnConfirmar.setOpaque(false);
        
        btnConfirmar.setIcon(new ImageIcon(img));
        btnConfirmar.setPressedIcon(new ImageIcon(imgPressed));
        
        
        
        
        this.setSize(400,400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout());
        
        GridBagConstraints gc = new GridBagConstraints();
        
        JPanel panSuperior = new JPanel();
        panSuperior.setLayout(new GridBagLayout());
        gc.gridx = 0;
        gc.gridy = 0;
        panSuperior.add(lblNome,gc);
        
        gc.gridx = 0;
        gc.gridy = 1;
        panSuperior.add(txtNome,gc);
        
        gc.gridx = 1;
        gc.gridy = 1;
        panSuperior.add(btnConfirmar,gc);
        
        JPanel panInferior = new JPanel();
        panInferior.setLayout(new GridBagLayout());
        
        gc = new GridBagConstraints();
        gc.gridx = 0;
        gc.gridy = 0;
        panInferior.add(radCientista,gc);
        
        gc.gridx = 1;
        gc.gridy = 0;
        panInferior.add(radEmpresario,gc);
        
        gc.gridx = 2;
        gc.gridy = 0;
        panInferior.add(radEstudante,gc);
        
        gc.gridx = 0;
        gc.gridy = 1;
        panInferior.add(radJornalista,gc);
        
        gc.gridx = 1;
        gc.gridy = 1;
        panInferior.add(radMercenario,gc);
        
        gc.gridx = 2;
        gc.gridy = 1;
        panInferior.add(radMilitar,gc);
        
        gc = new GridBagConstraints();
        
        gc.gridx = 0;
        gc.gridy = 0;
        this.add(panSuperior,gc);
        
        panInferior.setBorder(BorderFactory
                .createTitledBorder("Selecione uma profissão"));
        
        gc.gridx = 0;
        gc.gridy = 1;
        this.add(panInferior,gc);
        
        this.setVisible(true);
        
    }
    
    
    
}
