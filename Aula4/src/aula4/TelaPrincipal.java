package aula4;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
        
        //Adicionar eventos aos botoes
        btnBotaoOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtATexto.append("Oi, meu nome é Lucas\n");
            }
        });
        
        this.setVisible(true);
        
        
    }

}
