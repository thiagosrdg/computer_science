import java.util.Stack;

public class MinhaPilha<E> extends Stack<E> {

    // Exercicio 10 - verifica se a pilha contém o elemento
    @Override
    public boolean contains(Object element) {
        Stack<E> aux = new Stack<>();
        boolean found = false;
        while (!isEmpty()) {
            E val = pop();
            if (val.equals(element)) found = true;
            aux.push(val);
        }
        while (!aux.isEmpty()) super.push(aux.pop());
        return found;
    }

    // Exercicio 11 - inverte os elementos da pilha
    public void flip() {
        Stack<E> aux = new Stack<>();
        while (!isEmpty()) aux.push(pop());
        addAll(aux); // itera aux da base ao topo, preservando a inversão
    }

    // Exercicio 12 - sobrecarga: empilha todos os elementos de outra pilha mantendo a ordem
    public void push(Stack<E> other) {
        Stack<E> aux = new Stack<>();
        while (!other.isEmpty()) aux.push(other.pop());
        while (!aux.isEmpty()) {
            E val = aux.pop();
            other.push(val);
            super.push(val);
        }
    }

    // Exercicio 13 - duas pilhas são iguais se tiverem os mesmos elementos na mesma ordem
    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof MinhaPilha)) return false;
        MinhaPilha<E> other = (MinhaPilha<E>) obj;
        if (size() != other.size()) return false;
        Stack<E> aux1 = new Stack<>(), aux2 = new Stack<>();
        boolean equal = true;
        while (!isEmpty()) {
            E v1 = pop(), v2 = other.pop();
            if (!v1.equals(v2)) equal = false;
            aux1.push(v1);
            aux2.push(v2);
        }
        while (!aux1.isEmpty()) {
            super.push(aux1.pop());
            other.push(aux2.pop());
        }
        return equal;
    }

    // Exercicio 14 - retorna nova pilha com os mesmos elementos (shallow copy)
    @Override
    public MinhaPilha<E> clone() {
        MinhaPilha<E> clone = new MinhaPilha<>();
        Stack<E> aux = new Stack<>();
        while (!isEmpty()) aux.push(pop());
        while (!aux.isEmpty()) {
            E val = aux.pop();
            super.push(val);
            clone.push(val);
        }
        return clone;
    }
}
