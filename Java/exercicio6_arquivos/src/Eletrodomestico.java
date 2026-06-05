public class Eletrodomestico extends Produto {
    private double ipi;

    public Eletrodomestico(String nome, String descricao, double preco, double ipi) {
        super(nome, descricao, preco);
        this.ipi = ipi;
    }

    public double getIpi() {
        return ipi;
    }

    @Override
    public String getTipo() {
        return "Eletrodoméstico";
    }

    @Override
    public String getInfoExtra() {
        return "IPI: R$ " + String.format("%.2f", ipi);
    }
}