// Classe que concentra todas as resolucoes recursivas dos exercicios.
public class Exercicios {

    // Exercicio 1:
    // verifica recursivamente se um numero existe dentro de um array.
    public boolean exercicio1(int[] array, int n) throws IllegalArgumentException {
        if (array == null) {
            throw new IllegalArgumentException("O array nao pode ser nulo.");
        }

        // Inicia a busca a partir da primeira posicao.
        return exercicio1(array, n, 0);
    }

    // Metodo privado recursivo que percorre o array por indice.
    private boolean exercicio1(int[] array, int n, int i) {
        // Se o indice ultrapassou o fim do array, o numero nao foi encontrado.
        if (i >= array.length) {
            return false;
        }
        // Se o valor atual eh o procurado, encerramos com verdadeiro.
        if (array[i] == n) {
            return true;
        }
        // Caso contrario, seguimos para a proxima posicao.
        return exercicio1(array, n, i + 1);
    }

    // Exercicio 2:
    // verifica recursivamente se um numero eh primo.
    public boolean exercicio2(int n) {
        // Por definicao, numeros menores ou iguais a 1 nao sao primos.
        if (n <= 1) {
            return false;
        }

        // Inicia os testes de divisibilidade em 2.
        return exercicio2(n, 2);
    }

    // Metodo privado recursivo que testa divisores.
    private boolean exercicio2(int n, int i) {
        // Se chegamos alem da metade do numero, nenhum divisor foi encontrado.
        if (i > n / 2) {
            return true;
        }

        // Se o numero for divisivel por i, ele nao eh primo.
        if (n % i == 0) {
            return false;
        }

        // Continua o teste com o proximo divisor.
        return exercicio2(n, i + 1);
    }

    // Exercicio 3:
    // devolve uma nova string invertida usando um acumulador.
    public String exercicio3(String original) throws IllegalArgumentException {
        // Verifica se a string existe antes de processar.
        if (original == null) {
            throw new IllegalArgumentException("A string nao pode ser nula.");
        }

        // Inicia a recursao na posicao 0 com a string invertida vazia.
        return exercicio3(original, 0, "");
    }

    // Metodo privado recursivo que monta a string invertida.
    private String exercicio3(String original, int i, String invertida) {
        // Quando o indice chega ao fim, a string invertida ja esta pronta.
        if (i >= original.length()) {
            return invertida;
        }

        // Coloca o caractere atual na frente da string acumulada.
        invertida = original.charAt(i) + invertida;

        // Continua a partir da proxima posicao.
        return exercicio3(original, i + 1, invertida);
    }

    // Exercicio 3 v2:
    // segunda forma de inverter string, agora montando o retorno na volta da recursao.
    public String exercicio3_v2(String original) throws IllegalArgumentException {
        // Verifica se a string existe antes de processar.
        if (original == null) {
            throw new IllegalArgumentException("A string nao pode ser nula.");
        }

        // Inicia a recursao na posicao 0.
        return exercicio3_v2(original, 0);
    }

    // Metodo privado recursivo da segunda versao da inversao.
    private String exercicio3_v2(String original, int i) {
        // Quando chegamos ao fim, devolvemos string vazia.
        if (i >= original.length()) {
            return "";
        }

        // Primeiro resolve o resto da string, depois concatena o caractere atual.
        return exercicio3_v2(original, i + 1) + original.charAt(i);
    }

    // Exercicio 4:
    // calcula a soma 1 + 1/2 + 1/3 + ... + 1/N de forma recursiva.
    public double exercicio4(int n) throws IllegalArgumentException {
        // O valor precisa ser positivo.
        if (n <= 0) {
            throw new IllegalArgumentException("N deve ser maior que zero.");
        }

        // Comeca a soma pelo termo 1.
        return exercicio4(n, 1);
    }

    // Metodo privado recursivo que soma os termos da sequencia.
    private double exercicio4(int n, double i) {
        // Caso base: chegou ao ultimo termo da soma.
        if (i >= n) {
            return 1 / i;
        }

        // Soma o termo atual com o restante da recursao.
        return 1 / i + exercicio4(n, i + 1);
    }

    // Exercicio 5:
    // verifica se um texto eh palindromo depois de normalizar a entrada.
    public boolean exercicio5(String texto) throws IllegalArgumentException {
        // Garante que a string nao seja nula.
        if (texto == null) {
            throw new IllegalArgumentException("O texto nao pode ser nulo.");
        }

        // Remove alguns caracteres especiais e espacos, depois padroniza em maiusculas.
        texto = texto.replaceAll("[\\\\,.?!@(){}\\[\\] \\/]", "").toUpperCase();

        // Inicia a verificacao recursiva a partir das extremidades.
        return exercicio5(texto, 0);
    }

    // Metodo privado recursivo que compara os caracteres espelhados.
    private boolean exercicio5(String texto, int i) {
        // Se chegamos ao meio da string, todas as comparacoes deram certo.
        if (i >= texto.length() / 2) {
            return true;
        }

        // Compara o caractere atual com o correspondente do fim.
        return texto.charAt(i) == texto.charAt(texto.length() - 1 - i)
            ? exercicio5(texto, i + 1)
            : false;
    }

    // Exercicio 6:
    // conta quantas posicoes de um array de strings sao palindromos.
    public int exercicio6(String[] textos) throws IllegalArgumentException {
        if (textos == null) {
            throw new IllegalArgumentException("O array de textos nao pode ser nulo.");
        }
        // Inicia a contagem na primeira posicao.
        return exercicio6(textos, 0);
    }

    // Metodo privado recursivo que percorre o array e conta palindromos.
    private int exercicio6(String[] textos, int i) {
        // Caso base: ao chegar ao fim do array, nao ha mais elementos para analisar.
        if (i >= textos.length) {
            return 0;
        }
        // Se o texto atual for palindromo, soma 1; caso contrario, apenas continua a recursao.
        return exercicio5(textos[i]) ? 1 + exercicio6(textos, i + 1) : exercicio6(textos, i + 1);
    }

    // Exercicio 7:
    // conta quantas vezes um digito aparece em um numero inteiro positivo.
    public int exercicio7(int d, int n) throws IllegalArgumentException {
        // O digito deve estar entre 0 e 9 e o numero nao pode ser negativo.
        if (d < 0 || n < 0 || d > 9) {
            throw new IllegalArgumentException("Digite um digito valido e um numero nao negativo.");
        }
        // Chama o metodo recursivo que faz a contagem matematica.
        return exercicio7r(d, n);
    }
    // Metodo privado recursivo do exercicio 7.
    private int exercicio7r(int d, int n) {
        // Quando o numero zera, todos os digitos ja foram analisados.
        if (n == 0) {
            return 0;
        }
        // Se o ultimo digito for igual ao procurado, soma 1.
        return n % 10 == d ? 1 + exercicio7r(d, n / 10) : exercicio7r(d, n / 10);
    }
    // Exercicio 8:
    // calcula a media dos digitos de um numero usando apenas operacoes matematicas.
    public double exercicio8(int n) throws IllegalArgumentException {
        // O numero deve ser positivo.
        if (n <= 0) {
            throw new IllegalArgumentException("N deve ser maior que zero.");
        }

        // Inicia a recursao com soma zero e zero digitos contados.
        return exercicio8(n, 0, 0);
    }
    // Metodo privado recursivo que acumula soma e quantidade de digitos.
    private double exercicio8(int n, double soma, int quantDigitos) {
        // Quando o numero zera, a media pode ser calculada.
        if (n == 0) {
            return soma / quantDigitos;
        }
        // Soma o ultimo digito e segue com o restante do numero.
        return exercicio8(n / 10, soma + (n % 10), quantDigitos + 1);
    }
    // Exercicio 9:
    // verifica se um numero eh perfeito.
    public boolean exercicio9(int n) throws IllegalArgumentException {
        // O numero deve ser positivo.
        if (n <= 0) {
            throw new IllegalArgumentException("N deve ser maior que zero.");
        }

        // Inicia a soma dos divisores proprios a partir de 1.
        return exercicio9(n, 0, 1);
    }
    // Metodo privado recursivo que soma os divisores proprios do numero.
    private boolean exercicio9(int n, int soma, int i) {
        // Quando passamos da metade do numero, terminamos os testes.
        if (i > n / 2) {
            return soma == n;
        }

        // Se i for divisor de n, soma esse valor; caso contrario, apenas avanca.
        return n % i == 0 ? exercicio9(n, soma + i, i + 1) : exercicio9(n, soma, i + 1);
    }  
}
