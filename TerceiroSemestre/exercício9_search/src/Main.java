public class Main {

    public static void main(String[] args) throws Exception {
        
        int[] vetor = { 10, 34, 65, 76, 78, 81, 86, 87, 90, 95, 104, 120 };
        System.out.println("Pesquisa sequencial:");
        int posicao = Exercicio1.encontra95(vetor);
        System.out.println("--------------------------------");
        System.out.println("O número está na posição: " + posicao);

        System.out.println("--------------------------------");
        System.out.println("Pesquisa binária recursiva:");
        int posicaoBinaria = Exercicio3.pesquisaBinariaRecursiva(vetor, 95);
        System.out.println("O número está na posição: " + posicaoBinaria);

    }
}

