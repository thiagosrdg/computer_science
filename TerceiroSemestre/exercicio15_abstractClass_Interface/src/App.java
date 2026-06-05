import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ---- Exercício 2: criar contas via teclado ----
        System.out.print("Quantas contas deseja criar? ");
        int qtd = sc.nextInt();
        sc.nextLine(); // limpa o buffer após nextInt

        ContaBancaria[] contas = new ContaBancaria[qtd];

        for (int i = 0; i < qtd; i++) {
            System.out.printf("Conta %d - tipo (1=Corrente, 2=Poupanca): ", i + 1);
            int tipo = sc.nextInt();
            sc.nextLine();

            System.out.print("Número da conta: ");
            int numero = sc.nextInt();
            sc.nextLine();

            System.out.print("Senha: ");
            String senha = sc.nextLine();

            if (tipo == 1) {
                contas[i] = new ContaCorrente(numero, senha);
            } else {
                System.out.print("Taxa de rendimento (ex: 0.05 para 5%): ");
                double taxa = sc.nextDouble();
                sc.nextLine();
                contas[i] = new ContaPoupanca(numero, senha, taxa);
            }
        }

        // Informa a taxa de rendimento de cada ContaPoupanca criada
        System.out.println("\n-- Taxas das contas poupança --");
        for (ContaBancaria c : contas) {
            if (c instanceof ContaPoupanca cp) {
                System.out.printf("Conta #%d: taxa %.0f%%%n", cp.getNumero(), cp.getTaxaRendimento() * 100);
            }
        }

        // Realiza algumas operações nas contas
        System.out.println("\n-- Operações --");
        for (ContaBancaria c : contas) {
            c.deposita(1000);
            c.saca(200);
            c.tiraExtrato();
        }

        // Imprime transações das correntes e taxas das poupanças
        System.out.println("\n-- Resumo final --");
        for (ContaBancaria c : contas) {
            if (c instanceof ContaCorrente cc) {
                System.out.printf("Conta Corrente #%d: %d transações%n", cc.getNumero(), cc.getTransacoes());
            } else if (c instanceof ContaPoupanca cp) {
                System.out.printf("Conta Poupança #%d: taxa %.0f%%%n", cp.getNumero(), cp.getTaxaRendimento() * 100);
            }
        }

        // ---- Exercício 5: array de Rentavel ----
        System.out.println("\n-- Rendimentos (array Rentavel) --");
        Rentavel[] rentaveis = new Rentavel[3];
        rentaveis[0] = new ContaPoupanca(99, "abc", 0.05); // poupança com R$0 investido
        ((ContaPoupanca) rentaveis[0]).deposita(2000);      // deposita para ter saldo
        rentaveis[1] = new TesouroDireto("Tesouro IPCA+", 5000, 0.12);
        rentaveis[2] = new TesouroDireto("Tesouro Selic", 3000, 0.10);

        for (Rentavel r : rentaveis) {
            System.out.printf("Rendimento: R$%.2f%n", r.calculaRendimento());
        }

        sc.close();
    }
}
