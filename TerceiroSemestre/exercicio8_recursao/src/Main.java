// Classe principal usada para testar os metodos da classe Exercicios.
public class Main {

    // Interface funcional simples para permitir testes com lambdas.
    @FunctionalInterface
    private interface Teste {
        // Executa um teste e devolve o resultado em formato generico.
        Object executar();
    }

    // Metodo principal do programa.
    public static void main(String[] args) {
        // Cria o objeto que contem todos os exercicios.
        Exercicios exercicios = new Exercicios();

        // Testa o exercicio 1 procurando o valor 6 no array.
        executarTeste("Exercicio 1", () -> exercicios.exercicio1(new int[] {2, 4, 6, 8, 10}, 6));

        // Testa o exercicio 2 verificando se 17 eh primo.
        executarTeste("Exercicio 2", () -> exercicios.exercicio2(17));

        // Testa a primeira versao do exercicio 3.
        executarTeste("Exercicio 3", () -> exercicios.exercicio3("recursao"));

        // Testa a segunda versao do exercicio 3.
        executarTeste("Exercicio 3 v2", () -> exercicios.exercicio3_v2("recursao"));

        // Testa o exercicio 4 com N igual a 5.
        executarTeste("Exercicio 4", () -> exercicios.exercicio4(5));

        // Testa o exercicio 5 com uma frase palindroma.
        executarTeste("Exercicio 5", () -> exercicios.exercicio5("Eva, asse essa ave"));

        // Testa o exercicio 6 contando quantos palindromos existem no vetor.
        executarTeste(
            "Exercicio 6",
            () -> exercicios.exercicio6(new String[] {"Ana", "Java", "Renner", "O teu dueto"})
        );

        // Testa o exercicio 7 contando quantas vezes o digito 1 aparece no numero.
        executarTeste("Exercicio 7", () -> exercicios.exercicio7(1, 161451811));

        // Testa o exercicio 8 calculando a media dos digitos de 6845.
        executarTeste("Exercicio 8", () -> exercicios.exercicio8(6845));

        // Testa o exercicio 9 verificando se 28 eh um numero perfeito.
        executarTeste("Exercicio 9", () -> exercicios.exercicio9(28));
    }

    // Metodo auxiliar que executa cada teste sem interromper os demais.
    private static void executarTeste(String descricao, Teste teste) {
        // Tenta executar o teste informado.
        try {
            // Exibe a descricao junto do valor retornado.
            System.out.println(descricao + ": " + teste.executar());
        } catch (IllegalArgumentException e) {
            // Mostra uma mensagem amigavel caso a entrada seja invalida.
            String mensagem = e.getMessage() == null ? "Entrada invalida." : e.getMessage();
            System.out.println(descricao + ": " + mensagem);
        }
    }
}
