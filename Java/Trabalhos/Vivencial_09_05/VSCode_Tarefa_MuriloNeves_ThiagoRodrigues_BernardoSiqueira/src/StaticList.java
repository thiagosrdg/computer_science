/* Integranetes:
- Murilo Neves
- Thiago Rodrigues
- Bernardo Siqueira
 */
public class StaticList<E> implements List<E> {
    protected E[] elements;
    protected int numElements;

    public StaticList(int tamanho) {
        elements = (E[]) new Object[tamanho];
        numElements = 0;
    }

    @Override
    public int numElements() {
        int numElements = 0;
        for (E x : elements) {
            if (x != null) {
                numElements++;
            }
        }
        return numElements;
    }

    @Override
    public boolean isEmpty() {
        for (E x : elements) {
            if (x != null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isFull() {
        for (E x : elements) {
            if (x == null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public E get(int pos) {
        if (elements[pos] != null)
            return elements[pos];
        else
            return null;
    }

    @Override
    public void insert(E element, int pos) {
        if (elements[pos] == null)
            elements[pos] = element;
    }

    @Override
    public E remove(int pos) {
        E element = elements[pos];
        elements[pos] = null;
        return element;
    }

    @Override
    public int search(E element) {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == element)
                return i;
        }
        return -1;
    }

    public int pesquisaBinariaCandidatos(int numero) {
        int inicio = 0;
        int fim = elements.length - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;

            Candidato c = (Candidato) elements[meio];
            if (c.getNumero() == numero) {
                return meio;
            } else if (c.getNumero() < numero) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        return -1;
    }

    public void insertionSortCandidatos() {
        for (int i = 1; i < elements.length; i++) {
            Candidato atual = (Candidato) elements[i];
            int anterior = i - 1;

            while (anterior >= 0 && (Candidato) elements[anterior] != null && ((Candidato) elements[anterior]).getNumero() > ((Candidato) atual).getNumero()) {
                elements[anterior + 1] = elements[anterior];
                anterior--;
            }
            elements[anterior + 1] = (E) atual;
        }
    }
}