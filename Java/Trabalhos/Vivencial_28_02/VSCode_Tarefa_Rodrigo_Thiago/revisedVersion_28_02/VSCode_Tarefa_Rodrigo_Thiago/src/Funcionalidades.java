// CÓDIGO CRIADO PELA DUPLA RODRIGO PY && THIAGO RODRIGUES

import java.util.Scanner;

public class Funcionalidades {
    
    Produto[][] estoque = new Produto[4][5];

    Scanner sc = new Scanner(System.in);

    public void armazenarProduto() {
        System.out.print("Digite o corredor: ");
        int corredor;
        try {
            corredor = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida para corredor.");
            return;
        }

        System.out.print("Digite a posição: ");
        int posicao;
        try {
            posicao = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida para posição.");
            return;
        }

        if (corredor < 0 || corredor >= estoque.length || posicao < 0 || posicao >= estoque[corredor].length) {
            System.out.println("Corredor ou posição inválidos.");
            return;
        }

        if (estoque[corredor][posicao] == null) {
            System.out.print("\nDigite o código do produto: ");
            int codigo = Integer.parseInt(sc.nextLine());

            System.out.print("Digite a descrição do produto: ");
            String descricao = sc.nextLine();

            System.out.print("Digite a quantidade: ");
            int quantidade = Integer.parseInt(sc.nextLine());

            System.out.print("Digite o peso: ");
            double peso = Double.parseDouble(sc.nextLine());

            estoque[corredor][posicao] = new Produto(codigo, descricao, quantidade, peso);
            System.out.println("Produto armazenado com sucesso!");
        } else {
            System.out.println("A posição [" + corredor + "][" + posicao + "] já está ocupada.");
        }
    }
    
    public void listarEstoque() {
        for (int i = 0; i < estoque.length; i++) {
            for (int j = 0; j < estoque[i].length; j++) {
                Produto produto = estoque[i][j];
                if (produto != null) {
                    System.out.println("Descrição: " + produto.getDescricao() + 
                                       ", Código: " + produto.getCodigo() + 
                                       ", Quantidade: " + produto.getQuantidade() + 
                                       ", Peso: " + produto.getPeso() +
                                       ", Localização: Corredor [" + i + "] Posição [" + j + "]");
                }
            }
        }
    }
    
    public void buscarProduto() {
        System.out.println("Qual o código do produto deseja buscar? ");
        int codigoBusca = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < estoque.length; i++) {
            for (int j = 0; j < estoque[i].length; j++) {
                Produto produto = estoque[i][j];
                if (produto != null && produto.getCodigo() == codigoBusca) {
                    System.out.println("Produto encontrado!");
                    System.out.println("Corredor: " + i);
                    System.out.println("Posição: " + j);
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
        System.out.print("Digite o corredor: ");
        int corredor = Integer.parseInt(sc.nextLine());

        System.out.print("Digite a posição: ");
        int posicao = Integer.parseInt(sc.nextLine());

        if (corredor < 0 || corredor >= estoque.length || posicao < 0 || posicao >= estoque[corredor].length) {
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
