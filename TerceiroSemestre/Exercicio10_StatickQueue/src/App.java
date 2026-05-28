public class App {

    public static void main(String[] args) throws Exception{
        
        Exercicio2 e2 = new Exercicio2();
        StaticQueue<Integer> q1 = new StaticQueue<>(5);
        StaticQueue<Integer> q2 = new StaticQueue<>(5);
        try {
            q1.enqueue(1);
            q1.enqueue(2);
            q1.enqueue(3);
            q1.enqueue(4);
            q2.enqueue(5);
            q2.enqueue(6);
            q2.enqueue(7);
            q2.enqueue(8);
            e2.prependQueue(q1, q2);
            System.out.println(q1);
            System.out.println(q2);
        } catch (OverflowException | UnderflowException e) {
            e.printStackTrace();
        }
    }


}
