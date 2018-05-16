package aula3;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class TelaPrincipal extends JFrame {
    private JTextArea txtATexto;
    private JButton btnBotaoOK;
    
    public TelaPrincipal() throws HeadlessException {
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(400, 400);
        this.setLayout(new BorderLayout());
        
        //Instanciando os componentes da tela
        txtATexto = new JTextArea();
        btnBotaoOK = new JButton("OK");
        
        //Adicionando os componentes na tela
        this.add(txtATexto,BorderLayout.CENTER);
        this.add(btnBotaoOK,BorderLayout.SOUTH);
        this.setVisible(true);
        
        
    }

}
