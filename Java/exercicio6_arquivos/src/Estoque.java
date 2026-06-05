import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;  
import java.io.FileWriter;
import java.io.IOException;
import java.text.Normalizer;

public class Estoque {
    // Este array guarda todos os produtos lidos do arquivo.
    // Cada posição do vetor passará a armazenar um objeto do tipo Produto
    // ou de alguma classe filha, como Alimento, Vestuario ou Eletrodomestico.
    private Produto[] produtos;

    // Retorna o vetor completo de produtos já carregados em memória.
    // O método é usado, por exemplo, na classe Principal para mostrar
    // quantos produtos foram lidos.
    public Produto[] getProdutos() {
        return produtos;
    }

    // Lê o arquivo informado, descobre quantos produtos válidos existem
    // e depois preenche o vetor "produtos" com os objetos criados a partir
    // de cada linha.
    public void preencheEstoque(String nomeArquivo) throws IOException {
        // Primeiro, conta quantas linhas realmente possuem dados.
        // Isso é necessário porque o array precisa nascer com tamanho fixo.
        int quantidade = contarLinhasValidas(nomeArquivo);
        produtos = new Produto[quantidade];

        // Depois de saber o tamanho do vetor, o arquivo é lido novamente.
        // Nesta segunda leitura, cada linha válida é transformada em objeto.
        try (BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            int indice = 0;

            while ((linha = leitor.readLine()) != null) {
                // Ignora linhas em branco para não tentar criar produtos inválidos.
                if (linha.isBlank()) {
                    continue;
                }

                // Converte a linha textual em um objeto Produto adequado
                // e coloca esse objeto na posição atual do vetor.
                produtos[indice] = criarProduto(linha);

                // Avança para a próxima posição do array.
                indice++;
            }
        }
    }

    // Faz uma primeira leitura do arquivo apenas para contar quantas linhas
    // realmente representam produtos.
    private int contarLinhasValidas(String nomeArquivo) throws IOException {
        int quantidade = 0;

        // Conta apenas as linhas que possuem conteúdo.
        try (BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;

            while ((linha = leitor.readLine()) != null) {
                // Só incrementa o contador quando a linha não está vazia.
                if (!linha.isBlank()) {
                    quantidade++;
                }
            }
        }

        // Retorna o total para que o vetor de produtos seja criado com o tamanho correto.
        return quantidade;
    }

    // Recebe uma linha do arquivo, separa os dados e cria o tipo correto de produto.
    private Produto criarProduto(String linha) throws IOException {
        // Divide a linha usando o caractere '*' como separador.
        // Exemplo esperado:
        // nome*descricao*preco*tipo*infoExtra
        String[] partes = linha.split("\\*");

        // Se não existir a quantidade mínima de campos, a linha é considerada inválida.
        if (partes.length < 5) {
            throw new IOException("Linha invalida no arquivo: " + linha);
        }

        // Lê os dados básicos comuns a qualquer produto.
        // O trim() remove espaços extras no começo e no fim.
        String nome = partes[0].trim();
        String descricao = partes[1].trim();

        // O preço é convertido para double por um método auxiliar.
        double preco = lerDouble(partes[2]);

        // O tipo é normalizado para facilitar comparações.
        // Assim, "Eletrodoméstico", "eletrodomestico" e variações parecidas
        // ficam mais fáceis de tratar no switch.
        String tipo = normalizarTexto(partes[3]);

        // O último campo muda conforme o tipo do produto.
        // Para alimento, pode ser a validade.
        // Para vestuário, a quantidade em estoque.
        // Para eletrodoméstico, o valor do IPI.
        String infoExtra = partes[4].trim();

        // Cria o objeto específico conforme o tipo lido no arquivo.
        // Isso é um exemplo de polimorfismo: todos são guardados como Produto,
        // mas cada item é instanciado com sua classe real.
        switch (tipo) {
            case "alimento":
                // Para alimento, o campo extra é tratado como String.
                return new Alimento(nome, descricao, preco, infoExtra);
            case "vestuario":
                // Para vestuário, o campo extra precisa virar inteiro,
                // pois representa a quantidade em estoque.
                return new Vestuario(nome, descricao, preco, Integer.parseInt(infoExtra));
            case "eletrodomestico":
            case "eletrodomesticos":
                // Para eletrodoméstico, o campo extra é um número decimal,
                // então ele é convertido com o método lerDouble.
                return new Eletrodomestico(nome, descricao, preco, lerDouble(infoExtra));
            default:
                // Se o tipo não for reconhecido, o método interrompe a leitura
                // informando exatamente qual valor veio incorreto.
                throw new IOException("Tipo de produto invalido: " + partes[3].trim());
        }
    }

    // Gera um arquivo de saída contendo:
    // a) o alimento mais caro;
    // b) o eletrodoméstico mais barato;
    // c) a lista de produtos de vestuário com quantidade em estoque.
    public void gerarArquivoInfo(String nomeArquivoSaida) throws IOException {
        // Se o vetor ainda não foi preenchido, não existe o que processar.
        if (produtos == null) {
            throw new IllegalStateException("O estoque ainda nao foi preenchido.");
        }

        // Variáveis auxiliares para guardar os resultados pedidos no exercício.
        Produto alimentoMaisCaro = null;
        Produto eletrodomesticoMaisBarato = null;
        StringBuilder roupas = new StringBuilder();

        // Percorre todo o vetor de produtos para analisar cada item.
        for (Produto produto : produtos) {
            // Segurança extra: ignora posições nulas, caso existam.
            if (produto == null) {
                continue;
            }

            // Usa a classe real do objeto para descobrir qual subtipo foi armazenado.
            if (produto instanceof Alimento) {
                // Se ainda não existe alimento registrado ou se o alimento atual
                // é mais caro que o anterior, ele passa a ser o novo "mais caro".
                if (alimentoMaisCaro == null || produto.getPreco() > alimentoMaisCaro.getPreco()) {
                    alimentoMaisCaro = produto;
                }
            } else if (produto instanceof Eletrodomestico) {
                // Se ainda não existe eletrodoméstico registrado ou se o atual
                // é mais barato que o anterior, ele passa a ser o novo "mais barato".
                if (eletrodomesticoMaisBarato == null || produto.getPreco() < eletrodomesticoMaisBarato.getPreco()) {
                    eletrodomesticoMaisBarato = produto;
                }
            } else if (produto instanceof Vestuario) {
                // Aqui o código precisa acessar um método específico de Vestuario,
                // então faz um cast para transformar a referência Produto em Vestuario.
                Vestuario vestuario = (Vestuario) produto;

                // Monta o texto que será gravado no item (c) do arquivo final.
                roupas.append(vestuario.getNome())
                      .append(" - ")
                      .append(vestuario.getQuantidadeEstoque())
                      .append(System.lineSeparator());
            }
        }

        // Depois de processar tudo, grava o relatório em arquivo.
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(nomeArquivoSaida))) {
            // Bloco (a): alimento mais caro.
            escritor.write("a) Alimento mais caro");
            escritor.newLine();
            escritor.write(formatarProduto(alimentoMaisCaro, "Nenhum alimento encontrado."));
            escritor.newLine();
            escritor.newLine();

            // Bloco (b): eletrodoméstico mais barato.
            escritor.write("b) Eletrodomestico mais barato");
            escritor.newLine();
            escritor.write(formatarProduto(eletrodomesticoMaisBarato, "Nenhum eletrodomestico encontrado."));
            escritor.newLine();
            escritor.newLine();

            // Bloco (c): lista dos produtos de vestuário.
            escritor.write("c) Produtos de vestuario");
            escritor.newLine();
            if (roupas.length() > 0) {
                // Se encontrou roupas, escreve todas as linhas acumuladas no StringBuilder.
                escritor.write(roupas.toString());
            } else {
                // Caso contrário, escreve uma mensagem padrão.
                escritor.write("Nenhum produto de vestuario encontrado.");
            }
        }
    }

    // Recebe um produto e devolve um texto padronizado para o relatório.
    private String formatarProduto(Produto produto, String mensagemPadrao) {
        // Se nenhum produto daquele tipo foi encontrado, retorna a mensagem padrão.
        if (produto == null) {
            return mensagemPadrao;
        }

        // Caso exista produto, monta uma linha com nome e preço formatado.
        return produto.getNome() + " - R$ " + String.format("%.2f", produto.getPreco());
    }

    // Converte um texto para double.
    // Antes da conversão, troca vírgula por ponto para aceitar os dois formatos.
    private double lerDouble(String valor) {
        return Double.parseDouble(valor.trim().replace(",", "."));
    }

    // Remove acentos, espaços extras e padroniza para letras minúsculas.
    // Isso evita erros de comparação quando o texto vem escrito de formas diferentes.
    private String normalizarTexto(String texto) {
        String textoNormalizado = Normalizer.normalize(texto, Normalizer.Form.NFD);
        return textoNormalizado.replaceAll("\\p{M}", "").trim().toLowerCase();
    }
}
