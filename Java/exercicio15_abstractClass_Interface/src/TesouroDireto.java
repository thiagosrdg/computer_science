// Exercício 4: outro objeto rentável — um título do Tesouro Direto
public class TesouroDireto implements Rentavel {

    private String nome;
    private double valorInvestido;
    private double taxaAnual; // ex: 0.12 = 12% ao ano

    public TesouroDireto(String nome, double valorInvestido, double taxaAnual) {
        this.nome = nome;
        this.valorInvestido = valorInvestido;
        this.taxaAnual = taxaAnual;
    }

    // Rendimento = valor investido * taxa anual
    @Override
    public double calculaRendimento() {
        return valorInvestido * taxaAnual;
    }

    public String getNome() { return nome; }
    public double getValorInvestido() { return valorInvestido; }
}
