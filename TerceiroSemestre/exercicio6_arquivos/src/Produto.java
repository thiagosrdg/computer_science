public abstract class Produto {
    //Atributos
    private String nome;
    private String descricao;
    private double preco;

    //Construtor
    public Produto(String nome, String descricao, double preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }
    //Getters
    public String getNome(){
        return nome;
    }
    public String getDescricao(){
        return descricao;
    }
    public double getPreco(){
        return preco;
    }

    public abstract String getTipo();

    public abstract String getInfoExtra();

    @Override
    public String toString() {
        return "Produto: " + nome + "\n" +
                "Descrição: " + descricao + "\n" +
                "Preço: R$ " + preco + "\n" +
                "Tipo: " + getTipo() + "\n" +
                getInfoExtra();
    }
}
