public class Main {
    public static void main(String[] args){
        System.out.println("\nHello, world!\n");

        //Chamada do método 1
        Metodos mt = new Metodos();
        int[] numeros = {77, 88, 99};
        System.out.println("Exercício 1");
        mt.exercicio1(numeros);
        System.out.println();

        //Chamada do método 2
        int[] numeros2 = {1, 2, 3};
        int[] resultado2 = mt.exercicio2(numeros2);
        System.out.println("Exercício 2");
        for (int i = 0; i<resultado2.length; i++){
        System.out.println(resultado2[i]);
        }

        System.out.println();
        
        //Chamada método 3
        int[] numeros3 = {2, 3, 10, 11, 90, 91};
        int[] resultado3 = mt.exercicio3(numeros3);
        System.out.println("Exercício 3");
        for (int i = 0; i < resultado3.length; i++){
        System.out.println(resultado3[i]);
        }

        System.out.println();
      
        //Chamada método 4
        String[] times = {"Barcelona", "Milan", "Bayern", "PSG"};
        int posicao = mt.exercicio4(times, "Barcelona");
        System.out.println("Exercicio 4");
        System.out.println(posicao);
        System.out.println();

        //Chamada método 5
        boolean[] numeros5 = {true, false, false, false};
        int[] resultado5 = mt.exercicio5(numeros5);
        System.out.println("Exercício 5");
        for (int i = 0; i < resultado5.length; i++){
        System.out.println(resultado5[i]);
        }
        System.out.println();

        //Chamada método 6
        int[] array1 = {2, 4, 6};
        int[] array2 = {9, 14, 21};
        int[] resultado6  = mt.exercicio6(array1, array2);
        System.out.println("Exercicio 6");
        for(int i = 0; i < resultado6.length; i++){
            System.out.println(resultado6[i]);
        }
        System.out.println();

        //Chamada método 7
        int[] conjunto1 = {-1, 27, 89};
        int[] conjunto2 = {-77, -2, 84};
        int[] resultado7 = mt.exercicio7(conjunto1, conjunto2);
        System.out.println("Exercicio 7");
        for(int i = 0; i < resultado7.length; i++){
            System.out.println(resultado7[i]);
        }
        System.out.println();

        //Chamada método 8
        char[] palavra = {'I', 'n', 't', 'e', 'r'};
        System.out.println("Exercicio 8");
        mt.exercicio8(palavra);
        System.out.println("\n");

        //Chamada método 9
        int[] conjuntonumeros = {17, 99, 123};
        double media = mt.exercicio9(conjuntonumeros);
        System.out.println("Exercicio 9");
        System.out.println(media);
        System.out.println();

        //Chamada método 10
        int[] mediapares = {2, 59, 137, 188, 200, 236};
        double mediap = mt.exercicio10(mediapares);
        System.out.println("Exercicio 10");
        System.out.println(mediap);
        System.out.println();

        //Chamada método 11
        int[] numeros11 = {5, 55, 555, 5555};
        int valor11 = mt.exercicio11(numeros11, 2);
        System.out.println("Exercicio 11");
        System.out.println(valor11);
        System.out.println();

        //Chamada método 12
        double[] numeros12 = {1.8, -3.7, 44.3};
        boolean temNegativo = mt.exercicio12(numeros12);
        System.out.println("Exercicio 12");
        System.out.println(temNegativo);
        System.out.println();

        //Chamada método 13
        int[] numeros13 = {1, 13, 99};
        int maior = mt.exercicio13(numeros13);
        System.out.println("Exercicio 13");
        System.out.println(maior);
        System.out.println();

        //Chamada método 14
        int[] numeros14 = {99, 999, 109, 55};
        int posicaoMaior = mt.exercicio14(numeros14);
        System.out.println("Exercicio 14");
        System.out.println(posicaoMaior);
        System.out.println();

        //Chaamada método 15
        int[] numeros15 = {4, 9, 2, 15, 7};
        int menor = mt.exercicio15(numeros15);
        System.out.println("Exercício 15");
        System.out.println(menor);
        System.out.println();

        //Chamada método 16
        int[] numeros16 = {13, 33, 29, 11};
        int menor16 = mt.exercicio16(numeros16);
        System.out.println("Exercicio 16");
        System.out.println(menor16);
        System.out.println();  
        
        //Chamada método 17
        int[] numeros17a = {1, 2, 3};
        int[] numeros17b = {1, 2, 3};
        boolean iguais = mt.exercicio17(numeros17a, numeros17b);
        System.out.println("Exercício 17");
        System.out.println(iguais);
        System.out.println();

        //Chamada do método 18
        char[] letras18 = {'C', 'O', 'L', 'O', 'R', 'A', 'D', 'O'};
        String palavra18 = mt.exercicio18(letras18);
        System.out.println("Exercício 18");
        System.out.println(palavra18);
        System.out.println();

        //Chamada do método 19
        String[] resultado19 = mt.exercicio19(3);

        System.out.println("Exercício 19");
        for (String resultado191 : resultado19) {
            System.out.println(resultado191);
        }
        System.out.println();

        //Chamada do método 20
        String[] nomes20 = {"Ana", "Bruno", "Carlos", "Diana"};
        String[] resultado20 = mt.exercicio20(nomes20, 2);
        System.out.println("Exercício 20");
        for (String resultado201 : resultado20) {
            System.out.println(resultado201);
        }
        System.out.println();

        //Chamada do método 21
        double[] numeros21 = {1.5, 2.8, 3.2, 4.9, 5.1, 6.7};
        System.out.println("Exercício 21");
        mt.exercicio21(numeros21);
        System.out.println();
    }
}
