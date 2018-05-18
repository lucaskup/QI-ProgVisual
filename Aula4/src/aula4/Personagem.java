package aula4;
public class Personagem {
    private int id;
    private String nome;
    private boolean humano;
    private String profissao;

    public String mostrarEmCSV(){
        return id+";"+nome+";"+humano+";"+profissao;
    }
    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public boolean isHumano() {
        return humano;
    }

    public void setHumano(boolean humano) {
        this.humano = humano;
    }

    public Personagem(int id, String nome,
            boolean humano, String profissao) {
        this.id = id;
        this.nome = nome;
        this.humano = humano;
        this.profissao = profissao;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
