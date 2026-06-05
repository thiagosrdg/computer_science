// Conta corrente: tem número de transações realizadas
public class ContaCorrente extends ContaBancaria {

    private int transacoes; // quantas vezes sacou, depositou ou tirou extrato

    public ContaCorrente(int numero, String senha) {
        super(numero, senha);
        this.transacoes = 0;
    }

    @Override
    public void saca(double valor) {
        if (valor > saldo) {
            System.out.println("Saldo insuficiente.");
        } else {
            saldo -= valor;
            transacoes++;
            System.out.printf("Saque de R$%.2f realizado. Saldo: R$%.2f%n", valor, saldo);
        }
    }

    @Override
    public void deposita(double valor) {
        saldo += valor;
        transacoes++;
        System.out.printf("Depósito de R$%.2f realizado. Saldo: R$%.2f%n", valor, saldo);
    }

    @Override
    public void tiraExtrato() {
        transacoes++;
        System.out.printf("-- Extrato Conta Corrente #%d | Saldo: R$%.2f | Transações: %d --%n",
                numero, saldo, transacoes);
    }

    public int getTransacoes() { return transacoes; }
}
