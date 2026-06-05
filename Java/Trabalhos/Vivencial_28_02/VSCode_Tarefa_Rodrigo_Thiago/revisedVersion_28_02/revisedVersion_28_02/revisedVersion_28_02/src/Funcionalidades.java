import java.util.Scanner;

public class Funcionalidades {

    private Produto[][] estoque;
    private Scanner sc;

    public Funcionalidades(Scanner sc) {
        this.sc = sc;
        this.estoque = new Produto[4][5];
    }

    private int lerInt(String mensagem) {
        System.out.print(mensagem);

        while (!sc.hasNextInt()) {
            System.out.println("Entrada inválida. Digite um número inteiro.");
            sc.next();
            System.out.print(mensagem);
        }

        int valor = sc.nextInt();
        sc.nextLine();
        return valor;
    }

    private double lerDouble(String mensagem) {
        System.out.print(mensagem);

        while (!sc.hasNextDouble()) {
            System.out.println("Entrada inválida. Digite um número (ex: 10,5 ou 10.5).");
            sc.next();
            System.out.print(mensagem);
        }

        double valor = sc.nextDouble();
        sc.nextLine();
        return valor;
    }

    private boolean posicaoValida(int corredor, int posicao) {
        return corredor >= 0 && corredor < estoque.length
            && posicao >= 0 && posicao < estoque[corredor].length;
    }

    private boolean codigoJaExiste(int codigo) {
        for (int i = 0; i < estoque.length; i++) {
            for (int j = 0; j < estoque[i].length; j++) {
                Produto p = estoque[i][j];
                if (p != null && p.getCodigo() == codigo) {
                    return true;
                }
            }
        }
        return false;
    }

    public void armazenarProduto() {
        int corredor = lerInt("Digite o corredor (1 a 4): ") - 1;
        int posicao = lerInt("Digite a posição (1 a 5): ") - 1;

        if (!posicaoValida(corredor, posicao)) {
            System.out.println("Corredor ou posição inválidos.");
            return;
        }

        if (estoque[corredor][posicao] != null) {
            System.out.println("A posição [" + (corredor + 1) + "][" + (posicao + 1) + "] já está ocupada.");
            return;
        }

        int codigo = lerInt("Digite o código do produto: ");
        if (codigoJaExiste(codigo)) {
            System.out.println("Já existe um produto com esse código. Operação cancelada.");
            return;
        }

        System.out.print("Digite a descrição do produto: ");
        String descricao = sc.nextLine();

        int quantidade = lerInt("Digite a quantidade: ");
        double peso = lerDouble("Digite o peso: ");

        estoque[corredor][posicao] = new Produto(codigo, descricao, quantidade, peso);
        System.out.println("Produto armazenado com sucesso!");
    }

    public void listarEstoque() {
    System.out.println("\nMapa completo do estoque:\n");

    for (int i = 0; i < estoque.length; i++) {
        for (int j = 0; j < estoque[i].length; j++) {
            Produto produto = estoque[i][j];

            if (produto == null) {
                System.out.println("Corredor " + (i + 1) + ", Posição " + (j + 1) + " -> Vazio");
            } else {
                System.out.println(
                    "Corredor " + (i + 1) + ", Posição " + (j + 1) +
                    " -> Código: " + produto.getCodigo() +
                    ", Descrição: " + produto.getDescricao()
                );
            }
        }
    }
}

    public void buscarProduto() {
        int codigoBusca = lerInt("Qual o código do produto deseja buscar? ");

        for (int i = 0; i < estoque.length; i++) {
            for (int j = 0; j < estoque[i].length; j++) {
                Produto produto = estoque[i][j];

                if (produto != null && produto.getCodigo() == codigoBusca) {
                    System.out.println("Produto encontrado!");
                    System.out.println("Corredor: " + (i + 1));
                    System.out.println("Posição: " + (j + 1));
                    System.out.println("Código: " + produto.getCodigo());
                    System.out.println("Descrição: " + produto.getDescricao());
                    System.out.println("Quantidade: " + produto.getQuantidade());
                    System.out.println("Peso: " + produto.getPeso());
                    return;
                }
            }
        }

        System.out.println("Produto não encontrado.");
    }

    public void removerProduto() {
        int corredor = lerInt("Digite o corredor (1 a 4): ") - 1;
        int posicao = lerInt("Digite a posição (1 a 5): ") - 1;

        if (!posicaoValida(corredor, posicao)) {
            System.out.println("Corredor ou posição inválidos.");
            return;
        }

        if (estoque[corredor][posicao] != null) {
            estoque[corredor][posicao] = null;
            System.out.println("Produto removido com sucesso!");
        } else {
            System.out.println("Não há produto nessa posição para remover.");
        }
    }
}