package aula3;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FrameCadastro extends JFrame {
    private JLabel lblId;
    private JLabel lblNome;
    private JTextField txtId;
    private JTextField txtNome;
    private JButton btnCriar;
    private JButton btnExcluir;
    
    public FrameCadastro() throws HeadlessException {
        this.setSize(200, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        lblId = new JLabel("id:");
        lblNome = new JLabel("nome:");

        txtId = new JTextField(3);
        txtNome = new JTextField(10);
        btnCriar = new JButton("Criar");
        btnExcluir = new JButton("Excluir");
        
        this.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        //Define a posição x e y na qual queremos adicionar o campo
        gc.gridx = 0;
        gc.gridy = 0;
        //Adiciona o campo conforme as restricoes definidas em gc
        this.add(lblId,gc);
        
        gc.gridx = 1;
        gc.gridy = 0;
        this.add(txtId,gc);
        
        this.setVisible(true);
    }
    
    
}
