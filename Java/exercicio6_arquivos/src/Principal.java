import java.io.IOException;
import java.util.Scanner;

public class Principal{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Estoque estoque = new Estoque();

        System.out.print("Digite o nome do arquivo de produtos: ");
        String nomeArquivo = scanner.nextLine();

        try {
            estoque.preencheEstoque(nomeArquivo);
            estoque.gerarArquivoInfo("info.txt");

            System.out.println("Estoque preenchido com sucesso.");
            System.out.println("Quantidade de produtos lidos: " + estoque.getProdutos().length);
            System.out.println("Arquivo info.txt gerado com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao processar o arquivo: " + e.getMessage());
        } finally {
            // Fecha o teclado no fim da execucao.
            scanner.close();
        }
    }
}
