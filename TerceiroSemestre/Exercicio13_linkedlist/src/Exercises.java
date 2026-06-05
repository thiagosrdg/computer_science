// Métodos dos exercícios 1, 2, 4, 6, 7 e 8
// (Ex 3 está em SinglyLinkedList.split | Ex 5 está em DoublyLinkedList.swap)
public class Exercises {

    // Ex 1: converte lista de dígitos no inteiro que ela representa
    // Ex: [1, 2, 3] → 123
    public static int convertToInt(SinglyLinkedList<Integer> list) {
        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            result = result * 10 + list.get(i);
        }
        return result;
    }

    // Ex 2: soma recursiva de todos os elementos da lista
    public static int sum(SinglyLinkedList<Integer> list) {
        return sumHelper(list, 0);
    }

    private static int sumHelper(SinglyLinkedList<Integer> list, int index) {
        if (index >= list.size()) return 0;
        return list.get(index) + sumHelper(list, index + 1);
    }

    // Ex 4: retorna pilha com todos os elementos negativos da lista de doubles
    public static StaticStack<Double> negativeToStack(SinglyLinkedList<Double> list) {
        StaticStack<Double> stack = new StaticStack<>(list.size());
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < 0) stack.push(list.get(i));
        }
        return stack;
    }

    // Ex 6: converte lista duplamente encadeada de Strings em pilha estática
    // onde o topo da pilha é o primeiro elemento da lista.
    public static StaticStack<String> toStack(DoublyLinkedList<String> list) {
        StaticStack<String> stack = new StaticStack<>(list.size());
        toStackHelper(list, 0, stack);
        return stack;
    }

    // Empurra APÓS a recursão → elementos são inseridos de trás para frente
    // → primeiro elemento da lista fica no topo da pilha
    private static void toStackHelper(DoublyLinkedList<String> list, int index, StaticStack<String> stack) {
        if (index >= list.size()) return;
        toStackHelper(list, index + 1, stack);
        stack.push(list.get(index));
    }

    // Ex 7: verifica recursivamente se a lista duplamente encadeada está ordenada
    public static boolean isSorted(DoublyLinkedList<Integer> list) {
        if (list.size() <= 1) return true;
        return isSortedHelper(list, 0);
    }

    private static boolean isSortedHelper(DoublyLinkedList<Integer> list, int index) {
        if (index >= list.size() - 1) return true;
        if (list.get(index) > list.get(index + 1)) return false;
        return isSortedHelper(list, index + 1);
    }

    // Ex 8: pesquisa binária recursiva em lista duplamente encadeada de inteiros.
    // Retorna o índice do elemento, ou -1 se não encontrado.
    // Lança exceção se a lista não estiver ordenada.
    public static int pesquisaBinaria(DoublyLinkedList<Integer> list, int target) {
        if (!isSorted(list)) throw new IllegalArgumentException("Lista não está ordenada");
        return binarySearchHelper(list, 0, list.size() - 1, target);
    }

    private static int binarySearchHelper(DoublyLinkedList<Integer> list, int left, int right, int target) {
        if (left > right) return -1;
        int mid = (left + right) / 2;
        int midVal = list.get(mid);
        if (midVal == target)  return mid;
        if (midVal < target)   return binarySearchHelper(list, mid + 1, right, target);
        return                        binarySearchHelper(list, left, mid - 1, target);
    }
}
