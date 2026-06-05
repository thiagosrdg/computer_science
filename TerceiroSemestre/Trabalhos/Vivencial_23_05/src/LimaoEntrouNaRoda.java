public class LimaoEntrouNaRoda {
    
    private Node inicio;
    private int quantidade;

    public LimaoEntrouNaRoda(int n){
        this.quantidade = n;

        Pessoa pessoa1 = new Pessoa("Josézinho", 1);
        this.inicio = new Node(pessoa1);

        Node atual = this.inicio; 

        for(int i = 2; i <= n; i++){
            Pessoa pessoa = new Pessoa("Pessoa " + i, i);
            Node newNode = new Node(pessoa);

            atual.setNext(newNode);
            atual = newNode;
        }
        atual.setNext(this.inicio);
    } 
    
    public void imprimeRoda(){
        Node x = inicio;
        for(int i = 0; i < quantidade; i++){
            System.out.println(x.getData());
            x = x.getNext();
        }
    }
    
    public int passaObjeto(int x) {
        if (quantidade <= 0) {
            return 0;
        }
        Node temp = inicio;
        int pos = 0;
        for (int i = 0; i < x; i++) {
            temp = temp.getNext();
            pos = (pos + 1) % quantidade;
        }
        return pos;
    }

    public Pessoa removePosicao(int x) {
        if (quantidade <= 0) {
            return null;
        }
        
        // Em uma lista circular, precisamos encontrar o nó anterior ao início para começar
        Node prev = inicio;
        while (prev.getNext() != inicio) {
            prev = prev.getNext();
        }
        
        Node target = inicio;
        for (int i = 0; i < x; i++) {
            prev = target;
            target = target.getNext();
        }
        
        // Remove o nó target
        prev.setNext(target.getNext());
        
        // Atualiza o início para o próximo participante
        inicio = target.getNext();
        
        quantidade--;
        
        // Se restar apenas uma pessoa, ela é a vencedora
        if (quantidade == 1) {
            return inicio.getData();
        }
        
        return null;
    }
}
