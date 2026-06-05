public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        System.out.println();
        
        //Chamada do exercicio 1a
        int[][] resultado1 = Metodos1.exercicio1a();

        for (int i = 0; i < resultado1.length; i++){
            for (int j = 0; j < resultado1[i].length; j++){
                System.out.print(resultado1[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        //Chamada do exercicio 1b
        int[][] resultado2 = Metodos1.exercicio1b();

        for (int i = 0; i < resultado2.length; i++){
            for (int j = 0; j < resultado2[i].length; j++){
                System.out.print(resultado2[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        //Chamada do exercicio 1c
        int[][] resultado3 = Metodos1.exercicio1c();

        for (int i = 0; i < resultado3.length; i++){
            for (int j = 0; j < resultado3[i].length; j++){
                System.out.print(resultado3[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        //Chamada do exercicio 1d
        int[][] resultado4 = Metodos1.exercicio1d();

        for (int i = 0; i < resultado4.length; i++){
            for (int j = 0; j < resultado4[i].length; j++){
                System.out.print(resultado4[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        //Chamada do exercicio 2
        int[][] resultado5 = Metodos2.exercicioAleatorio();

        for (int i = 0; i < resultado5.length; i++){
            for (int j = 0; j < resultado5[i].length; j++){
                System.out.print(resultado5[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        //Chamada do exercicio 3
        double[][] resultado6 = Metodos2.exercicio3();

        for (int i = 0; i < resultado6.length; i++){
            for (int j = 0; j < resultado6[i].length; j++){
                System.out.print(resultado6[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        //Chamada do exercicio 4
        int quantidade = Metodos2.exercicio4(resultado6);   
        System.out.println("\nQuantidade de elementos na matriz: " + quantidade);

        System.out.println();
        //Chamada Exercicio 5
        int quantidade2 = Metodos2.exercicio5(resultado6);
        System.out.println("Quantidade de elementos na matriz: " + quantidade2);

        System.out.println();
        //Chamada Exercicio 6
        String saidaMatriz = Metodos2.exercicio6(resultado6);
        System.out.println(saidaMatriz);

        System.out.println();
        //Chamada Exercicio 7
        double maiorValor = Metodos2.exercicio7(resultado6);
        System.out.println("Maior valor da matriz: " + maiorValor);

        System.out.println();
        //Chamada Exercicio 8
        int soma = Metodos2.exercicio8(resultado5);
        System.out.println("Soma dos elementos da matriz: " + soma);

        System.out.println();
        //Chamada Exercicio 9
        double media = Metodos2.exercicio9(resultado6);
        System.out.println("Média dos valores da matriz: " + media);

        System.out.println();
        //Chamada Exercicio 10
        char[][] resultado10 = Metodos2.exercicio10();

        for (int i = 0; i < resultado10.length; i++){
            for (int j = 0; j < resultado10[i].length; j++){
                System.out.print(resultado10[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
        //Chamada Exercicio 11
        int[] resultado11 = Metodos2.exercicio11(resultado5);

        for (int i = 0; i < resultado11.length; i++){
            System.out.print(resultado11[i] + " ");
        }
        System.out.println();
    }
}
