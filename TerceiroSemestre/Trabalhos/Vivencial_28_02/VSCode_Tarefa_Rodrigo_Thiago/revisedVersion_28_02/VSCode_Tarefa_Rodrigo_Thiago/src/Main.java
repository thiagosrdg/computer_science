// CÓDIGO CRIADO PELA DUPLA RODRIGO PY && THIAGO RODRIGUES

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        System.out.println("Bem-vindo ao programa de controle de estoque!\n");
       
        Scanner sc = new Scanner(System.in);

        Funcionalidades sistema = new Funcionalidades();
        int opcao;

        do {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Armazenar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Buscar produto");
            System.out.println("4 - Remover produto");
            System.out.println("5 - Sair");
            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 1:
                    sistema.armazenarProduto();
                    break;
                case 2:
                    sistema.listarEstoque();
                    break;
                case 3:
                    sistema.buscarProduto();
                    break;
                case 4:
                    sistema.removerProduto();
                    break;
                case 5:
                    System.out.println("\nEncerrando o programa. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);
        sc.close();
    }
}

