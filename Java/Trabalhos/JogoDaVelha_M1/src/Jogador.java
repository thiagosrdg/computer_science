// Ciência da Computação - Unisinos
// Resposta ao Desafio do Módulo 1 - Algoritmos e Programação: Estruturas Lineares
// Alunos: Enzo Janssen, Pedro Dias, Thiago da Silva Rodrigues

public class Jogador {
    //Atributos
    private String nome;
    private int pontos;
    //Construtor
    public Jogador(String nome) {
        this.nome = nome;
        this.pontos = 0;
    }
    //Getters
    public String getNome() {
        return nome;
    }

    public int getPontos() {
        return pontos;
    }
    //Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
    //Método para adicionar pontos ao jogador
    public void adicionarPontos(){
        pontos++;
    }
    @Override
    public String toString() {
        return "O jogador: " + nome + ", possui " + pontos + " pontos!";
    }

}
