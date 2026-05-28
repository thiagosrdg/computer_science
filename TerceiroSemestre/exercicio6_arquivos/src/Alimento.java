public class Alimento extends Produto {
    private String dataValidade;

    public Alimento(String nome, String descricao, double preco, String dataValidade) {
        super(nome, descricao, preco);
        this.dataValidade = dataValidade;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    @Override
    public String getTipo() {
        return "Alimento";
    }

    @Override
    public String getInfoExtra() {
        return "Validade: " + dataValidade;
    }
}