public class Main {
    public static void main(String[] args) {

        // Ex 1: convertToInt — [1, 2, 3] deve virar 123
        SinglyLinkedList<Integer> digits = new SinglyLinkedList<>();
        digits.add(1); digits.add(2); digits.add(3);
        System.out.println("Ex 1 - convertToInt " + digits + " = " + Exercises.convertToInt(digits));

        // Ex 2: soma recursiva — 10 + 20 + 30 = 60
        SinglyLinkedList<Integer> nums = new SinglyLinkedList<>();
        nums.add(10); nums.add(20); nums.add(30);
        System.out.println("Ex 2 - sum " + nums + " = " + Exercises.sum(nums));

        // Ex 3: split em 3 — prefixo [1,2,3], restante [4,5]
        SinglyLinkedList<Integer> list3 = new SinglyLinkedList<>();
        for (int i = 1; i <= 5; i++) list3.add(i);
        System.out.print("Ex 3 - split " + list3 + " no divisor 3 → prefixo: ");
        SinglyLinkedList<Integer> prefix = list3.split(3);
        System.out.println(prefix + " | restante: " + list3);

        // Ex 4: negativos para pilha — apenas -2.0 e -4.5
        SinglyLinkedList<Double> doubles = new SinglyLinkedList<>();
        doubles.add(1.5); doubles.add(-2.0); doubles.add(3.0); doubles.add(-4.5);
        System.out.println("Ex 4 - negativos de " + doubles + " → " + Exercises.negativeToStack(doubles));

        // Ex 5: swap nas posições 1 e 3 — [1,2,3,4,5] vira [1,4,3,2,5]
        DoublyLinkedList<Integer> dlist = new DoublyLinkedList<>();
        for (int i = 1; i <= 5; i++) dlist.add(i);
        System.out.print("Ex 5 - swap pos 1 e 3 em " + dlist + " → ");
        dlist.swap(1, 3);
        System.out.println(dlist);

        // Ex 6: lista ["A","B","C"] → pilha com "A" no topo
        DoublyLinkedList<String> strings = new DoublyLinkedList<>();
        strings.add("A"); strings.add("B"); strings.add("C");
        System.out.println("Ex 6 - toStack " + strings + " → " + Exercises.toStack(strings));

        // Ex 7: isSorted
        DoublyLinkedList<Integer> sorted   = new DoublyLinkedList<>();
        DoublyLinkedList<Integer> unsorted = new DoublyLinkedList<>();
        sorted.add(1); sorted.add(2); sorted.add(3);
        unsorted.add(3); unsorted.add(1); unsorted.add(2);
        System.out.println("Ex 7 - isSorted " + sorted   + " = " + Exercises.isSorted(sorted));
        System.out.println("Ex 7 - isSorted " + unsorted + " = " + Exercises.isSorted(unsorted));

        // Ex 8: pesquisaBinaria em [2,4,6,8,10,12,14]
        DoublyLinkedList<Integer> blist = new DoublyLinkedList<>();
        for (int i = 1; i <= 7; i++) blist.add(i * 2);
        System.out.println("Ex 8 - pesquisaBinaria " + blist + " por 8  → índice " + Exercises.pesquisaBinaria(blist, 8));
        System.out.println("Ex 8 - pesquisaBinaria " + blist + " por 5  → índice " + Exercises.pesquisaBinaria(blist, 5));

        // Ex 9: discussão conceitual
        System.out.println();
        System.out.println("Ex 9 - Faz sentido usar pesquisa binária em lista encadeada?");
        System.out.println("  Não. Listas encadeadas não têm acesso direto (O(1)) aos elementos.");
        System.out.println("  Encontrar o meio exige percorrer n/2 nós a cada passo recursivo.");
        System.out.println("  A complexidade total resulta em O(n), igual à busca linear.");
        System.out.println("  Logo, o benefício do O(log n) da pesquisa binária é perdido.");
    }
}
