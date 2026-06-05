import java.util.Scanner;
import java.util.Random;

public class Metodos2 {
    public static Scanner scanner = new Scanner(System.in);

    //Exercicio 2
    public static int[][] exercicioAleatorio() {
        Random random = new Random();

        System.out.print("Digite a quantidade de linhas: ");
        int linhas = scanner.nextInt();

        System.out.print("Digite a quantidade de colunas: ");
        int colunas = scanner.nextInt();

        int[][] matriz5 = new int[linhas][colunas];

        for (int i = 0; i < matriz5.length; i++) {
            for (int j = 0; j < matriz5[i].length; j++) {
                matriz5[i][j] = random.nextInt(100);
            }
        }

        return matriz5;
    }
    //Exercicio 3
    public static double[][] exercicio3() {
        double[][] matriz6 = new double[2][5];

        for (int i = 0; i < matriz6.length; i++) {
            for (int j = 0; j < matriz6[i].length; j++) {
                System.out.print("Digite um número para a posição [" + i + "][" + j + "]: ");
                matriz6[i][j] = scanner.nextDouble();
            }
        }

        return matriz6;
    }
    //Exercicio 4
    public static int exercicio4(double[][] matriz7) {
        int quantidade = 0;

        for (int i = 0; i < matriz7.length; i++) {
            for (int j = 0; j < matriz7[i].length; j++) {
                quantidade++;
            }
        }

        return quantidade;
    }
    //Exercicio 5
    public static int exercicio5(double[][] matriz8) {
        int quantidade = 0;

        for (int i = 0; i < matriz8.length; i++) {
            for (int j = 0; j < matriz8[i].length; j++) {
                quantidade++;
            }
        }

        return quantidade;
    }
    //Exercicio 6
    public static String exercicio6(double[][] matriz9) {
        String saida = "";

        for (int i = 0; i < matriz9.length; i++) {
            for (int j = 0; j < matriz9[i].length; j++) {
                saida += matriz9[i][j];

                if (j < matriz9[i].length - 1) {
                    saida += " - ";
                }
            }

            if (i < matriz9.length - 1) {
                saida += "\n";
            }
        }

        return saida;
    }
    //Exercicio 7
    public static double exercicio7(double[][] matriz10) {
        double maior = matriz10[0][0];

        for (int i = 0; i < matriz10.length; i++) {
            for (int j = 0; j < matriz10[i].length; j++) {
                if (matriz10[i][j] > maior) {
                    maior = matriz10[i][j];
                }
            }
        }

        return maior;
    }
    //Exercicio 8
    public static int exercicio8(int[][] matriz11) {
        int soma = 0;

        for (int i = 0; i < matriz11.length; i++) {
            for (int j = 0; j < matriz11[i].length; j++) {
                soma += matriz11[i][j];
            }
        }

        return soma;
    }
    //Exercicio 9
    public static double exercicio9(double[][] matriz12) {
        double soma = 0;
        int quantidade = 0;

        for (int i = 0; i < matriz12.length; i++) {
            for (int j = 0; j < matriz12[i].length; j++) {
                soma += matriz12[i][j];
                quantidade++;
            }
        }

        return soma / quantidade;
    }
    //Exercicio 10
    public static char[][] exercicio10() {
        Random random = new Random();

        int linhas = random.nextInt(5) + 1;
        int colunas = random.nextInt(3) + 1;

        char[][] matriz13 = new char[linhas][colunas];

        System.out.println("Quantidade de linhas sorteada: " + linhas);
        System.out.println("Quantidade de colunas sorteada: " + colunas);

        for (int i = 0; i < matriz13.length; i++) {
            for (int j = 0; j < matriz13[i].length; j++) {
                System.out.print("Digite um caractere para a posição [" + i + "][" + j + "]: ");
                matriz13[i][j] = scanner.next().charAt(0);
            }
        }

        return matriz13;
    }
    //Exercicio 11
    public static int[] exercicio11(int[][] matriz14) {
        int quantidadePositivos = 0;

        for (int i = 0; i < matriz14.length; i++) {
            for (int j = 0; j < matriz14[i].length; j++) {
                if (matriz14[i][j] > 0) {
                    quantidadePositivos++;
                }
            }
        }

        int[] vetorPositivos = new int[quantidadePositivos];
        int indice = 0;

        for (int i = 0; i < matriz14.length; i++) {
            for (int j = 0; j < matriz14[i].length; j++) {
                if (matriz14[i][j] > 0) {
                    vetorPositivos[indice] = matriz14[i][j];
                    indice++;
                }
            }
        }

        return vetorPositivos;
    }
}
