// Ciência da Computação - Unisinos
// Resposta ao Desafio do Módulo 1 - Algoritmos e Programação: Estruturas Lineares
// Alunos: Enzo Janssen, Pedro Dias, Thiago da Silva Rodrigues

public class JogoDaVelha {
    //Atributo - Matriz que representa o tabuleiro do jogo da velha
    private char[][] tabuleiro;
   
    //Construtor do tabuleiro que inicializa as posições com espaços vazios
    public JogoDaVelha(int tamanho) {
        tabuleiro = new char[tamanho][tamanho];
        
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                tabuleiro[i][j] = ' ';
            }
        }
    }

    //Método para realizar uma jogada no tabuleiro
    //Retorna false se a posição for inválida ou já estiver ocupada
    public boolean realizaJogada(int linha, int coluna, char jogada) {
        if (linha < 0 || linha >= tabuleiro.length || coluna < 0 || coluna >= tabuleiro.length) {
            return false;
        }

        if (jogada != 'X' && jogada != 'O') {
            return false;
        }

        if (tabuleiro[linha][coluna] != ' ') {
            return false;
        }

        tabuleiro[linha][coluna] = jogada;
        return true;
    }

    //Método que verifica se existe um ganhador no tabuleiro
    public boolean verificaGanhador() {
        int tamanho = tabuleiro.length;
        //Verificador de linhas
        for (int i = 0; i < tamanho; i++) {
            char simboloLinha = tabuleiro[i][0];

            if (simboloLinha != ' ') {
                boolean linhaCompleta = true;

                for (int j = 1; j < tamanho; j++) {
                    if (tabuleiro[i][j] != simboloLinha) {
                        linhaCompleta = false;
                        break;
                    }
                }

                if (linhaCompleta) {
                    return true;
                }
            }
        }
        //Verificador de colunas
        for (int j = 0; j < tamanho; j++) {
            char simboloColuna = tabuleiro[0][j];

            if (simboloColuna != ' ') {
                boolean colunaCompleta = true;

                for (int i = 1; i < tamanho; i++) {
                    if (tabuleiro[i][j] != simboloColuna) {
                        colunaCompleta = false;
                        break;
                    }
                }

                if (colunaCompleta) {
                    return true;
                }
            }
        }
        //Verificador de diagonaL 1
        char simboloDiagonalPrincipal = tabuleiro[0][0];
        if (simboloDiagonalPrincipal != ' ') {
            boolean diagonalPrincipalCompleta = true;

            for (int i = 1; i < tamanho; i++) {
                if (tabuleiro[i][i] != simboloDiagonalPrincipal) {
                    diagonalPrincipalCompleta = false;
                    break;
                }
            }

            if (diagonalPrincipalCompleta) {
                return true;
            }
        }
        //Verificador de diagonal 2
        char simboloDiagonalSecundaria = tabuleiro[0][tamanho - 1];
        if (simboloDiagonalSecundaria != ' ') {
            boolean diagonalSecundariaCompleta = true;

            for (int i = 1; i < tamanho; i++) {
                if (tabuleiro[i][tamanho - 1 - i] != simboloDiagonalSecundaria) {
                    diagonalSecundariaCompleta = false;
                    break;
                }
            }

            if (diagonalSecundariaCompleta) {
                return true;
            }
        }

        return false;
    }

    //Método que desenha o estado do tabuleiro
    @Override
    public String toString() {
        String texto = "";

     for (int i = 0; i < tabuleiro.length; i++) {
        for (int j = 0; j < tabuleiro.length; j++) {
            texto += tabuleiro[i][j];

            if (j < tabuleiro.length - 1) {
                texto += " | ";
            }
        }

        texto += "\n";

        if (i < tabuleiro.length - 1) {
            texto += "---------\n";
        }
    }

        return texto;
    }
}
