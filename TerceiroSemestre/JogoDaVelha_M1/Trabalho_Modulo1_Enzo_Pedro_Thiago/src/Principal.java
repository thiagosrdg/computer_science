// Ciência da Computação - Unisinos
// Resposta ao Desafio do Módulo 1 - Algoritmos e Programação: Estruturas Lineares
// Alunos: Enzo Janssen, Pedro Dias, Thiago da Silva Rodrigues

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws Exception {

        System.out.println("   ___________________________ ");
        System.out.println("  |                           |");
        System.out.println("  |  Bem-vindos ao Jogo da    |");
        System.out.println("  |         Velha! ^.^        |");
        System.out.println("  |___________________________|");
        System.out.println("            \\\\               ");
        System.out.println("             \\\\              ");
        System.out.println("             [o_o]             ");
        System.out.println("            /( : )\\           ");
        System.out.println("             /| |\\            ");
        System.out.println("            /_/ \\_\\          ");
        System.out.println();

        //Scanner para ler os dados digitados pelos jogadores
        Scanner scanner = new Scanner(System.in);

        //Solicitar os nomes dos jogadores
        System.out.print("Digite o nome do Jogador 1 (X): ");
        String nome1 = scanner.nextLine();

        System.out.print("Digite o nome do Jogador 2 (O): ");
        String nome2 = scanner.nextLine();

        //Cria os objetos jogador
        Jogador jogador1 = new Jogador(nome1);
        Jogador jogador2 = new Jogador(nome2);

        //Controle para jogar novamente
        boolean jogarNovamente = true;

        //Loop principal do jogo que executa uma partida enquanto jogarNovamente = True
        while (jogarNovamente) {
            // Ler o tamanho do tabuleiro
            System.out.print("Digite o tamanho do tabuleiro: ");
            int tamanho = scanner.nextInt();

            JogoDaVelha jogo = new JogoDaVelha(tamanho);

            boolean ganhou = false;
            int turno = 0;
            int totalJogadas = tamanho * tamanho;

            while (!ganhou && turno < totalJogadas) {
                System.out.println("\n" + jogo);

                int linha, coluna;
                char simbolo;

                if (turno % 2 == 0) {
                    System.out.println(jogador1.getNome() + " (X)");
                    simbolo = 'X';
                } else {
                    System.out.println(jogador2.getNome() + " (O)");
                    simbolo = 'O';
                }
                //Recebe a linha e coluna da jogada do jogador
                System.out.print("Linha: ");
                linha = scanner.nextInt();

                System.out.print("Coluna: ");
                coluna = scanner.nextInt();
                //Realiza a jogada e verifica se é válida, caso contrário, solicita novamente
                if (!jogo.realizaJogada(linha, coluna, simbolo)) {
                    System.out.println("Jogada inválida, tente novamente!");
                    continue;
                }
                //Verifica se existe um ganhador após a jogada
                if (jogo.verificaGanhador()) {
                    ganhou = true;
                    System.out.println("\n" + jogo);

                    if (turno % 2 == 0) {
                        System.out.println("Vencedor: " + jogador1.getNome());
                        jogador1.adicionarPontos();
                    } else {
                        System.out.println("Vencedor: " + jogador2.getNome());
                        jogador2.adicionarPontos();
                    }

                    break;
                }

                turno++;
            }
            // Verifica se houve empate caso o número de turnos seja igual ao total de jogadas possíveis e ninguém tenha ganhado
            if (!ganhou) {
                System.out.println("\n" + jogo);
                System.out.println("Empate! Todas as posições foram ocupadas.");
            }
            System.out.println();

            System.out.print("Desejam jogar novamente? (true/false): ");
            jogarNovamente = scanner.nextBoolean();
        }

        // Verifica vencedor final
        Jogador vencedor = null;

        if (jogador1.getPontos() > jogador2.getPontos()) {
            vencedor = jogador1;
        } else if (jogador2.getPontos() > jogador1.getPontos()) {
            vencedor = jogador2;
        }

        // Salvar resultado
        try {
            FileWriter arquivo = new FileWriter("resultado.txt");
            PrintWriter escrever = new PrintWriter(arquivo);

            if (vencedor != null) {
                escrever.println("Vencedor final:");
                escrever.println(vencedor.toString());
            } else {
                escrever.println("Empate final!");
                escrever.println(jogador1.toString());
                escrever.println(jogador2.toString());
            }

            escrever.close();
            arquivo.close();

        } catch (Exception e) {
            System.out.println("Erro ao salvar arquivo.");
        }

        scanner.close();
    }
}
