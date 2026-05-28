public class Exercicio1 {

    public static int encontra95(int[] vetor){
        for(int i = 0; i <vetor.length; i++){
            System.out.println(i);
            if (vetor[i] == 95){
                return i;
            }
        }
        return -1;
    }
}
