import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Exercicios {

    // ---- Exercicio 1 ----
    public static void exercicio1() throws Exception {
        Stack<Integer> p1 = new Stack<>();
        Stack<Integer> p2 = new Stack<>();
        Stack<Integer> p3 = new Stack<>();

        p1.push(1); p1.push(2); p1.push(3); p1.push(4);
        System.out.println("Inicial -> p1:" + p1 + " p2:" + p2 + " p3:" + p3);

        p2.push(p1.pop());
        p3.push(p1.pop());
        p2.push(p1.pop());
        p3.push(p1.pop());
        p1.push(p2.pop());
        p3.push(p2.pop());
        p3.push(p1.pop());

        System.out.println("Final   -> p1:" + p1 + " p2:" + p2 + " p3:" + p3);
    }

    // ---- Exercicio 2 ----
    public static void exercicio2() throws Exception {
        Stack<Integer> p1 = new Stack<>();
        Stack<Integer> p2 = new Stack<>();
        Stack<Integer> p3 = new Stack<>();

        p1.push(10); p1.push(20); p1.push(30); p1.push(40);
        System.out.println("Inicial -> p1:" + p1 + " p2:" + p2 + " p3:" + p3);

        p2.push(p1.pop());
        p2.push(p1.pop());
        p3.push(p1.pop());
        p3.push(p1.pop());
        p1.push(p2.pop());
        p3.push(p2.pop());
        p3.push(p1.pop());

        System.out.println("Final   -> p1:" + p1 + " p2:" + p2 + " p3:" + p3);
    }

    // ---- Exercicio 3 ----
    // retorna array com elementos de p sem ocorrências de number; preserva p
    static Integer[] itemsExcept(int number, Stack<Integer> p) {
        Stack<Integer> aux = new Stack<>();
        List<Integer> lista = new ArrayList<>();
        while (!p.isEmpty()) aux.push(p.pop());
        while (!aux.isEmpty()) {
            int val = aux.pop();
            p.push(val);
            if (val != number) lista.add(val);
        }
        return lista.toArray(new Integer[0]);
    }

    public static void exercicio3() {
        Stack<Integer> p = new Stack<>();
        p.push(1); p.push(2); p.push(3); p.push(2); p.push(4);
        System.out.println("p: " + p);
        System.out.println("sem o 2: " + Arrays.toString(itemsExcept(2, p)));
        System.out.println("p preservada: " + p);
    }

    // ---- Exercicio 4 ----
    // transfere elementos de s1 para s2 mantendo a mesma ordem; s1 fica vazia
    static <E> void transferElements(Stack<E> s1, Stack<E> s2) {
        Stack<E> aux = new Stack<>();
        while (!s1.isEmpty()) aux.push(s1.pop());
        while (!aux.isEmpty()) s2.push(aux.pop());
    }

    public static void exercicio4() {
        Stack<Integer> s1 = new Stack<>(), s2 = new Stack<>();
        s1.push(1); s1.push(2); s1.push(3);
        s2.push(10); s2.push(20);
        System.out.println("s1:" + s1 + " s2:" + s2);
        transferElements(s1, s2);
        System.out.println("após: s1:" + s1 + " s2:" + s2);
    }

    // ---- Exercicio 5 ----
    // insere elementos de p2 abaixo dos de p1, preservando ambas as ordens
    static void prependStack(Stack<Integer> p1, Stack<Integer> p2) {
        Stack<Integer> aux1 = new Stack<>(), aux2 = new Stack<>();
        while (!p1.isEmpty()) aux1.push(p1.pop());
        while (!p2.isEmpty()) aux2.push(p2.pop());
        while (!aux2.isEmpty()) p1.push(aux2.pop());
        while (!aux1.isEmpty()) p1.push(aux1.pop());
    }

    public static void exercicio5() {
        Stack<Integer> p1 = new Stack<>(), p2 = new Stack<>();
        p1.push(1); p1.push(2);
        p2.push(3); p2.push(4);
        System.out.println("p1:" + p1 + " p2:" + p2);
        prependStack(p1, p2);
        System.out.println("após: p1:" + p1);
    }

    // ---- Exercicio 6 ----
    static void add(Stack<Integer> p) { p.push(p.pop() + p.pop()); }
    static void sub(Stack<Integer> p) { p.push(-1 * p.pop() + p.pop()); }
    static void mul(Stack<Integer> p) { p.push(p.pop() * p.pop()); }
    static void moo(Stack<Integer> p) { int x = p.pop(), y = p.pop(); p.push(y); p.push(x); }

    public static void exercicio6() {
        Stack<Integer> p = new Stack<>();

        p.push(4); p.push(2); p.push(2); mul(p); moo(p);
        System.out.println("a) " + (p.peek() == 4 ? "V" : "F") + " topo=" + p.peek());
        p.clear();

        // moo() troca x e y mas repõe na mesma ordem — não inverte
        p.push(1); p.push(2); moo(p);
        System.out.println("b) F - moo() mantém a ordem (topo=" + p.peek() + ")");
        p.clear();

        p.push(2); p.push(5); p.push(3); mul(p); p.push(1); add(p);
        System.out.println("c) " + (p.size() == 2 ? "V" : "F") + " size=" + p.size());
        p.clear();

        p.push(8); p.push(5); sub(p);
        System.out.println("d) " + (p.peek() == -3 ? "V" : "F") + " topo=" + p.peek());
        p.clear();

        p.push(5); p.push(2); p.push(3); mul(p); sub(p);
        System.out.println("e) " + (p.peek() == (5 - 2 * 3) ? "V" : "F") + " topo=" + p.peek());
    }

    // ---- Exercicio 7 ----
    public static void exercicio7() {
        System.out.println("a) 4 3 2 1 0 9 8 7 6 5 -> POSSÍVEL");
        System.out.println("b) 4 6 8 7 5 3 2 9 0 1 -> IMPOSSÍVEL (ao tentar sair 0, o 1 ainda está no topo)");
        System.out.println("c) 2 5 6 7 4 8 9 3 1 0 -> POSSÍVEL");
        System.out.println("d) 4 3 2 1 0 5 6 7 8 9 -> POSSÍVEL");
    }

    // ---- Exercicio 8 ----
    // inverte a pilha usando apenas pilhas auxiliares
    static void invertStack(Stack<Integer> p) {
        Stack<Integer> aux = new Stack<>();
        while (!p.isEmpty()) aux.push(p.pop());
        p.addAll(aux); // addAll itera aux da base ao topo, preservando a inversão
    }

    public static void exercicio8() {
        Stack<Integer> p = new Stack<>();
        p.push(1); p.push(2); p.push(3); p.push(4);
        System.out.println("original:  " + p);
        invertStack(p);
        System.out.println("invertida: " + p);
    }

    // ---- Exercicio 9 ----
    // retorna posição do elemento (base=0) ou -1 se não encontrado; preserva p
    static int findInStack(int element, Stack<Integer> p) {
        Stack<Integer> aux = new Stack<>();
        while (!p.isEmpty()) aux.push(p.pop());
        int pos = -1, idx = 0;
        while (!aux.isEmpty()) {
            int val = aux.pop();
            if (val == element) pos = idx;
            p.push(val);
            idx++;
        }
        return pos;
    }

    public static void exercicio9() {
        Stack<Integer> p = new Stack<>();
        p.push(5); p.push(3); p.push(7); p.push(3); p.push(1);
        System.out.println("pilha: " + p);
        System.out.println("posição do 7: " + findInStack(7, p));
        System.out.println("posição do 9: " + findInStack(9, p));
        System.out.println("pilha preservada: " + p);
    }

    // ---- Exercicio 10 ----
    public static void exercicio10() {
        MinhaPilha<Integer> p = new MinhaPilha<>();
        p.push(1); p.push(2); p.push(3);
        System.out.println("pilha: " + p);
        System.out.println("contém 2? " + p.contains(2));
        System.out.println("contém 5? " + p.contains(5));
        System.out.println("pilha preservada: " + p);
    }

    // ---- Exercicio 11 ----
    public static void exercicio11() {
        MinhaPilha<Integer> p = new MinhaPilha<>();
        p.push(1); p.push(2); p.push(3);
        System.out.println("original:  " + p);
        p.flip();
        System.out.println("após flip: " + p);
    }

    // ---- Exercicio 12 ----
    public static void exercicio12() {
        MinhaPilha<Integer> p1 = new MinhaPilha<>();
        MinhaPilha<Integer> p2 = new MinhaPilha<>();
        p1.push(1); p1.push(2);
        p2.push(3); p2.push(4);
        System.out.println("p1:" + p1 + " p2:" + p2);
        p1.push(p2);
        System.out.println("após push(p2): p1:" + p1 + " p2:" + p2);
    }

    // ---- Exercicio 13 ----
    public static void exercicio13() {
        MinhaPilha<Integer> p1 = new MinhaPilha<>();
        MinhaPilha<Integer> p2 = new MinhaPilha<>();
        MinhaPilha<Integer> p3 = new MinhaPilha<>();
        p1.push(1); p1.push(2); p1.push(3);
        p2.push(1); p2.push(2); p2.push(3);
        p3.push(1); p3.push(2); p3.push(4);
        System.out.println("p1.equals(p2): " + p1.equals(p2));
        System.out.println("p1.equals(p3): " + p1.equals(p3));
    }

    // ---- Exercicio 14 ----
    public static void exercicio14() {
        MinhaPilha<Integer> p = new MinhaPilha<>();
        p.push(1); p.push(2); p.push(3);
        MinhaPilha<Integer> clone = p.clone();
        System.out.println("original: " + p);
        System.out.println("clone:    " + clone);
        System.out.println("iguais? " + p.equals(clone) + " | mesmo objeto? " + (p == clone));
    }
}
