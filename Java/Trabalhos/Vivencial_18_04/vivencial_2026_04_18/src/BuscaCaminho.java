// Grupo: Murilo Neves dos Santos, Thiago da Silva Rodrigues, Rodrigo Py

public class BuscaCaminho {

    public static boolean encontrarCaminho(int[][] mapa) {
        return encontrarCaminhoRecursivo(mapa, 0, 0);
    }

    private static boolean encontrarCaminhoRecursivo(int[][] mapa, int linha, int coluna) {
        if (linha >= mapa.length || coluna >= mapa[0].length || linha < 0 || coluna < 0) {
            return false;
        }
        if (mapa[linha][coluna] == 1 || mapa[linha][coluna] == 2) {
            return false;
        }
        // Caso base: chegou no destino, retorna true e encerra a recursão
        if (linha == mapa.length - 1 && coluna == mapa[0].length - 1) {
            return true;
        }
        mapa[linha][coluna] = 2;
        return 
        encontrarCaminhoRecursivo(mapa, linha - 1, coluna) // olha para cima
        || encontrarCaminhoRecursivo(mapa, linha + 1, coluna) // olha para baixo
        || encontrarCaminhoRecursivo(mapa, linha, coluna - 1) // olha para esquerda
        || encontrarCaminhoRecursivo(mapa, linha, coluna + 1); // olha para direita
    }

    public static void imprimirMapa(int[][] mapa) {
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[0].length; j++) {
                System.out.print(mapa[i][j] + " ");
            }
            System.out.println();
        }
    }

}
