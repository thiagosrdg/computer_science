// Conta poupança: tem taxa de rendimento e implementa Rentavel
public class ContaPoupanca extends ContaBancaria implements Rentavel {

    private double taxaRendimento; // ex: 0.05 = 5%

    public ContaPoupanca(int numero, String senha, double taxaRendimento) {
        super(numero, senha);
        this.taxaRendimento = taxaRendimento;
    }

    @Override
    public void saca(double valor) {
        if (valor > saldo) {
            System.out.println("Saldo insuficiente.");
        } else {
            saldo -= valor;
            System.out.printf("Saque de R$%.2f realizado. Saldo: R$%.2f%n", valor, saldo);
        }
    }

    @Override
    public void deposita(double valor) {
        saldo += valor;
        System.out.printf("Depósito de R$%.2f realizado. Saldo: R$%.2f%n", valor, saldo);
    }

    @Override
    public void tiraExtrato() {
        System.out.printf("-- Extrato Conta Poupança #%d | Saldo: R$%.2f | Taxa: %.0f%% --%n",
                numero, saldo, taxaRendimento * 100);
    }

    // Calcula o rendimento: saldo * taxa
    @Override
    public double calculaRendimento() {
        return saldo * taxaRendimento;
    }

    public double getTaxaRendimento() { return taxaRendimento; }
}
