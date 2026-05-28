/* Integranetes:
- Murilo Neves
- Thiago Rodrigues
- Bernardo Siqueira
 */
import java.util.Random;

public class PrincipalCandidatos {
    public static void main(String[] args) throws Exception {
        StaticList<Candidato> candidatos = new StaticList<>(20);

        String[] nomes = { "João", "Maria", "Pedro", "Ana", "Lucas", "Julia", "Carlos", "Fernanda", "Rafael", "Beatriz",
                "Gustavo", "Camila", "Bruno", "Larissa", "Felipe", "Mariana", "Ricardo", "Sofia", "Diego",
                "Amanda" };
        String[] partidos = { "Partido A", "Partido B", "Partido C", "Partido D"};
        boolean[] numerosUsados = new boolean[21];

        for (int i = nomes.length - 1; i >= 0; i--) {
            String nome = nomes[i];
            String partido = partidos[i % partidos.length];

            int numero;
            do {
                numero = new Random().nextInt(20) + 1;
            } while (numerosUsados[numero]);

            numerosUsados[numero] = true;
            candidatos.insert(new Candidato(numero, nome, partido), i);

            candidatos.get(i).setIntencoesVotos(new Random().nextInt(5000));
        }
        
        System.out.println("Candidatos antes da ordenação:");
        System.out.println();

        for (int i = 0; i < candidatos.numElements(); i++) {
            System.out.println(candidatos.get(i));
        }

        candidatos.insertionSortCandidatos();

        System.out.println();
        System.out.println("Candidatos depois da ordenação:");
        System.out.println();

        for (int i = 0; i < candidatos.numElements(); i++) {
            System.out.println(candidatos.get(i));
        }

        int numeroPesquisado = new Random().nextInt(20) + 1;
        int pos = candidatos.pesquisaBinariaCandidatos(numeroPesquisado);

        System.out.println();
        System.out.println("Pesquisa binária para o número do candidato de número: " + numeroPesquisado);
        System.out.println();

        if (pos != -1) {
            System.out.println("Candidato encontrado: " + candidatos.get(pos));
        } else {
            System.out.println("Candidato não encontrado.");
        }
    }
}