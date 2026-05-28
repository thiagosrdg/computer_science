public class Exercicio2 {

    public void prependQueue(Queue<Integer> q1, Queue<Integer> q2) throws OverflowException, UnderflowException {
        
        StaticQueue<Integer> q3 = new StaticQueue<>(q1.size() + q2.size());
        
        while(!q1.isEmpty()){
            q3.enqueue(q1.dequeue());
        }
        while(!q2.isEmpty()){
            q1.enqueue(q2.dequeue());
        }
        while(!q3.isEmpty()){
            q1.enqueue(q3.dequeue());
        }
    }
}