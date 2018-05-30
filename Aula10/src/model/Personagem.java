package model;
public class Personagem {
    private int id;
    private String nome;
    private String profissao;
    private boolean humano;
    private int idade;

    public Personagem(int id, String nome, String profissao, boolean humano, int idade) {
        this.id = id;
        this.nome = nome;
        this.profissao = profissao;
        this.humano = humano;
        this.idade = idade;
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
