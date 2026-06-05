// Superclasse abstrata — não pode ser instanciada diretamente
public abstract class ContaBancaria {

    private String senha;
    protected int numero;
    protected double saldo;

    // Toda conta é criada já com uma senha
    public ContaBancaria(int numero, String senha) {
        this.numero = numero;
        this.senha = senha;
        this.saldo = 0;
    }

    // Métodos abstratos: cada subclasse decide como implementar
    public abstract void saca(double valor);
    public abstract void deposita(double valor);
    public abstract void tiraExtrato();

    // Altera a senha somente se o usuário confirmar a senha atual
    // Recebe o Scanner de fora para não criar/fechar System.in múltiplas vezes
    public void alteraSenha(String novaSenha, java.util.Scanner sc) {
        System.out.print("Digite a senha atual para confirmar: ");
        String senhaDigitada = sc.nextLine();

        if (senhaDigitada.equals(this.senha)) {
            this.senha = novaSenha;
            System.out.println("Senha alterada com sucesso!");
        } else {
            System.out.println("Senha incorreta. Operação cancelada.");
        }
    }

    // Verifica se a senha passada é correta (usada na criação pelo main)
    public boolean verificaSenha(String s) {
        return this.senha.equals(s);
    }

    public int getNumero() { return numero; }
    public double getSaldo() { return saldo; }
}
