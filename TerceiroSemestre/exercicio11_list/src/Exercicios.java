import java.util.ArrayList;
import java.util.List;


public class Exercicios {

    // Ex. 1
    public static Integer[] evenNumbers(List<Integer> lista) {
        // lista auxiliar para guardar apenas os números pares
        List<Integer> pares = new ArrayList<>();

        // percorre cada elemento da lista pelo índice
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i) % 2 == 0) {
                pares.add(lista.get(i)); // adiciona o par na lista auxiliar
            }
        }
        // converte a lista de pares para um array e retorna
        return pares.toArray(new Integer[0]);
    }

    // Ex. 2
    public static List<Character> mergeLists(List<Character> t1, List<Character> t2) {
        int maior = Math.max(t1.size(), t2.size());
        
        List<Character> resultado = new ArrayList<>();

        for(int i = 0; i < maior; i++){
            if (i < t1.size()){
                resultado.add(t1.get(i));
            }
            if ( i < t2.size()){
                resultado.add(t2.get(i));
            }
        }
        return resultado; 
    }

    // Ex. 3
    public static void prependList(List<Double> t1, List<Double> t2) {
        
        t1.addAll(0, t2);

    }
}
