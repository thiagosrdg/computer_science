public class Main {
    public static void main(String[] args) throws Exception {
        
        int[] vetor1 = {1, 2, 3, 4, 5};

        // Chamada do metodo 1: imprime o vetor ao contrario usando recursao.
        System.out.println();
        System.out.println("Metodo 1 - vetor invertido com recursao: ");
        Metodos.arrayReverso1(vetor1);

        //Criacao do array bidimensional de double para o metodo 2
        double[][] m = {
            {1.5, 2.5, 3.5},
            {4.5, 5.5, 6.5},
            {7.5, 8.5, 9.5}
        };
        // Chamada do metodo 2: soma dos elementos de um array bidimensional de double usando recursao.
        Metodos metodos = new Metodos();
        double soma = metodos.somaValoresArrayBidimensional(m);
        System.out.println();
        System.out.println("Metodo 2 - soma dos elementos do array bidimensional: " + soma);

        // Chamada do metodo 3: encontra a posicao do menor valor de um array de inteiros usando recursao.
        int[] V = {5, 3, 8, 1, 4};
        int posicaoMenor = metodos.encontraPosicaoMenorValor(V);
        System.out.println("Metodo 3 - posicao do menor valor do array: " + posicaoMenor);

        // Chamada do metodo 4: imprime a diagonal primaria de uma matriz usando recursao.
        int[][] matriz = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println("Metodo 4 - diagonal primaria da matriz: ");
        metodos.printPrimaryDiagonal(matriz);

        //Chamada do metodo 5
        String binary = "10110011";
        int decimal = metodos.binaryToDecimal(binary);
        System.out.println();
        System.out.println("Metodo 5 - conversao de binario para decimal: " + decimal);

  
    }
}
