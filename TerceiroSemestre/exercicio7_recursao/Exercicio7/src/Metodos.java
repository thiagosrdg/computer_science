public class Metodos {

    // Metodo 1
    // Imprime o vetor ao contrario usando recursao
    public static void arrayReverso1(int[] vetor1)throws IllegalArgumentException {
        if (vetor1 == null) throw new IllegalArgumentException("O vetor nao pode ser nulo.");
        arrayReverso1(vetor1, vetor1.length - 1);
    }

    private static void arrayReverso1(int[] vetor1, int i) {
        if(i >= 0) { 
            System.out.print(vetor1[i]);
            arrayReverso1(vetor1, i - 1); //ou (vetor1, --i)
        }
    }

    //Metodo 2
    //Crie  um  método  recursivo  que  recebe  um  array  bidimensional  de  double  e 
    //retorna a soma dos elementos deste array
    public double somaValoresArrayBidimensional (double [][] m) throws IllegalArgumentException {
        if (m == null) throw new IllegalArgumentException("A matriz nao pode ser nula.");
        return somaValoresArrayBidimensional(m, 0, 0);
    }
    
    private double somaValoresArrayBidimensional (double [][] m, int i, int j) {
        if(i >= m.length) return 0; //condicao de parada 
        if(j >= m[i].length) return somaValoresArrayBidimensional(m, i + 1, 0); //passa para a proxima linha
        return m[i][j] + somaValoresArrayBidimensional(m, i, j + 1); //soma o valor atual e vai para a proxima coluna
    }

    //Metodo 3
    //Crie um método chamado encontraPosicaoMenorValor. Este método deve 
    //encontrar  a  posição  do  menor  valor  de  um  array  de  inteiros  V  (recebido  por 
    //parâmetro). 
    public int encontraPosicaoMenorValor(int[] V) throws IllegalArgumentException {
        if (V == null || V.length == 0) throw new IllegalArgumentException("O vetor nao pode ser nulo ou vazio.");
        return encontraPosicaoMenorValor(V, 0, 0);
    }

    private int encontraPosicaoMenorValor(int[] V, int i, int posicaoMenor) {
        if(i >= V.length) return posicaoMenor; //condicao de parada
        if(V[i] < V[posicaoMenor]) posicaoMenor = i; //atualiza a posicao do menor valor
        return encontraPosicaoMenorValor(V, i + 1, posicaoMenor); //vai para a proxima posicao
    }

    //Metodo 4
    //Crie um método recursivo chamado printPrimaryDiagonal, que imprime a 
    //diagonal primária de uma matriz qualquer. No método público, apenas a matriz 
    //deve ser passada por parâmetro. 
    public void printPrimaryDiagonal(int[][] matriz) throws IllegalArgumentException {
        if (matriz == null) throw new IllegalArgumentException("A matriz nao pode ser nula.");
        if (matriz.length != matriz[0].length) throw new IllegalArgumentException("A matriz deve ser quadrada.");
        printPrimaryDiagonal(matriz, 0);
    }

    private void printPrimaryDiagonal(int[][] matriz, int i) {
        if (i < matriz.length) {
            System.out.print(matriz[i][i]);
            printPrimaryDiagonal(matriz, i + 1);
        }
    }

    //Metodo 5
    public int binaryToDecimal(String binary) throws IllegalArgumentException {
        if (binary == null || binary.length() != 8) throw new IllegalArgumentException("A string deve ser de 8 caracteres.");
        return binaryToDecimal(binary, 0);
    }

    private int binaryToDecimal(String binary, int i) {
        if (i >= binary.length()) return 0; //condicao de parada
        char bit = binary.charAt(binary.length() - 1 - i); //pega o bit da direita para a esquerda
        if (bit == '1') return (int)Math.pow(2, i) + binaryToDecimal(binary, i + 1); //se o bit for 1, soma o valor correspondente
        if (bit == '0') return binaryToDecimal(binary, i + 1); //se o bit for 0, apenas vai para o proximo bit
        return binaryToDecimal(binary, i + 1); //se o bit for diferente de 0 ou 1, apenas vai para o proximo bit
    }    
}

