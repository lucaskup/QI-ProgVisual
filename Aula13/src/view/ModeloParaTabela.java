package view;

import java.util.Collections;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Personagem;

public class ModeloParaTabela extends AbstractTableModel {
    private List<Personagem> lista;
    private String[] nomesColuna = 
        {"id","nome","profissão","humano", "idade"};

    @Override
    public String getColumnName(int column) {
        return nomesColuna[column];
    }
    
    
   
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Personagem pers = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return pers.getId();
            case 1:
                return pers.getNome();
            case 2:
                return pers.getProfissao();
            case 3:
                return pers.isHumano();
            case 4:
                return pers.getIdade();
            default:
                throw new AssertionError();
        }
    }
    public void atualizar(List<Personagem> lista){
        this.lista = lista;
        Collections.sort(this.lista);
        this.fireTableDataChanged();
        
    }
    
}
