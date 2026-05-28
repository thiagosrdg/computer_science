import java.util.Scanner;

public class Metodos {

    // Metodo 1 - Recebe um array de inteiros e imprime ao contrario
    public void exercicio1(int[] numeros) {
        for (int i = numeros.length - 1; i >= 0; i--) {
            System.out.println(numeros[i]);
        }
    }

    // Metodo 2 - Recebe um array de inteiros e retorna um array com as posicoes invertidas
    public int[] exercicio2(int[] numeros2) {
        int[] invertido = new int[numeros2.length];

        int j = 0;
        for (int i = numeros2.length - 1; i >= 0; i--) {
            invertido[j] = numeros2[i];
            j++;
        }

        return invertido;
    }

    // Metodo 3 - Recebe um array de inteiros e retorna um array somente com os valores pares
    public int[] exercicio3(int[] numeros3) {
        int quantidadePares = 0;

        for (int i = 0; i < numeros3.length; i++) {
            if (numeros3[i] % 2 == 0) {
                quantidadePares++;
            }
        }

        int[] pares = new int[quantidadePares];

        int j = 0;
        for (int i = 0; i < numeros3.length; i++) {
            if (numeros3[i] % 2 == 0) {
                pares[j] = numeros3[i];
                j++;
            }
        }

        return pares;
    }

    // Metodo 4 - Recebe um array de String e uma String x por parametro
    // Depois retorna a posicao da String x no array ou -1 se nao estiver no array
    public int exercicio4(String[] times, String x) {
        for (int i = 0; i < times.length; i++) {
            if (times[i].equals(x)) {
                return i;
            }
        }

        return -1;
    }

    // Metodo 5 - Recebe um array de boolean e retorna um array de inteiros
    // Contendo 1 nas posições true e 0 nas posições false
    public  int[] exercicio5 (boolean[] numeros5) {
        int[] resultado5 = new int[numeros5.length];
        
        for (int i = 0; i < numeros5.length; i++) {
            if (numeros5[i] == true) {
                resultado5[i] = 1;
            } else {
                resultado5[i] = 0;
            }
        }
        
        return resultado5;
    }
    //Metodo 6 - Recebe dois arrays de inteiros e retorna um terceiro array
    // Com todos os elementos dos dois arrays
    public int[] exercicio6(int[] numeros1, int[] numeros2) {
        int[] resultado6 = new int[numeros1.length + numeros2.length];

        int j = 0;

        for(int i = 0; i < numeros1.length; i++){
            resultado6[j] = numeros1[i];
            j++;
        }

        for (int i = 0; i < numeros2.length; i++) {
            resultado6[j] = numeros2[i];
            j++;
        }
        return resultado6;
    }

    // Metodo 7- Recebe dois arrays de inteiros e retorna um terceiro array
    // Com os elementos negativos dos dois arrays na primeira parte 
    // E todos os elementos positivos incluindo o 0 na segunda parte
    public int[] exercicio7(int[] conjunto1, int[] conjunto2) {
        int[] resultado7 = new int[conjunto1.length + conjunto2.length];

        int j = 0;

        for (int i = 0; i < conjunto1.length; i++){
            if(conjunto1[i] < 0){
                resultado7[j] = conjunto1[i];
                j++;
            }
        }

        for (int i = 0; i < conjunto2.length; i++){
            if(conjunto2[i] < 0){
                resultado7[j] = conjunto2[i];
                j++;
            }
        }

        for (int i = 0; i < conjunto1.length; i++){
            if(conjunto1[i] >= 0){
                resultado7[j] = conjunto1[i];
                j++;
            }
        }

        for (int i = 0; i < conjunto2.length; i++){
            if(conjunto2[i] >= 0){
                resultado7[j] = conjunto2[i];
                j++;
            }
        }

        return resultado7;
    }
    //Metodo 8 - Recebe um array de Char e imprime na mesma linha todos os elementos
    public void exercicio8(char[] letras){
        for(int i = 0; i < letras.length; i++){
            System.out.print(letras[i]);
        }
    }
    //Metodo 9 - recebe um array de inteiros e retorna a média de todos os elementos
    public double exercicio9(int[] array9){
        int soma = 0;
        
        for(int i = 0; i < array9.length; i++){
            soma += array9[i];
        }
        
        return (double) soma / array9.length;
    }
    //Metodo 10 - recebe um array de inteiros e retorna a media dos elementos pares
    public double exercicio10(int[] array10){
        int soma = 0;
        int quantidadePares = 0;

        for (int i = 0; i < array10.length; i++){
            if (array10[i] % 2 == 0){
                soma += array10[i];
                quantidadePares++;
            }
        }

        return (double) soma / quantidadePares;
    }
    //Metodo 11 - recebe um array de inteiros e um inteiro x
    // Retorna o elemento da posição x do array
    public int exercicio11(int[] arrayX, int x){
        return arrayX[x]; 
    }
    //Metodo 12 - Recebe um array de double e retorna ttrue se algum elemento for negativo
    //Retorna false false se todos os elementos forem positivos
    public boolean exercicio12(double[] array12){
        for (int i = 0; i < array12.length; i++){
            if (array12[i] < 0){
                return true;
            }
        }

        return false;
    }
    //Metodo 13 - Recebe um array de inteiros e retorna o maior elemento
    public int exercicio13(int[] array13){
        int maior = array13[0];

        for(int i = 0; i < array13.length; i++){
            if (array13[i] > maior){
                maior = array13[i];
            }
        }

        return maior;
    }
    //Metodo 14 - Recebe um array de inteiros e retorna a posição do maior elemento
    public int exercicio14(int[] array14){
        int maior14 = array14[0];
        int posicaoMaior = 0;

        for(int i = 0; i < array14.length; i++){
            if(array14[i] > maior14){
                maior14 = array14[i];
                posicaoMaior = i;
            }
        }

        return posicaoMaior;
    }
    //Metodo 15 - Recebe um array de inteiros e retorna o menor elemento.
    public int exercicio15 (int[] array15){
        int menor = array15[0];

        for (int i = 0; i < array15.length; i++){
            if(array15[i] < menor){
                menor = array15[i];
            }
        } 

        return menor;
    }
    //Metodo 16 - Recebe um array de inteiros e retorna a posição do menor elemento
    public int exercicio16(int[] array16){
        int menor16 = array16[0];
        int posicaoMenor = 0;

        for (int i = 0; i < array16.length; i++){
            if(array16[i] < menor16){
                menor16 = array16[i];
                posicaoMenor = i;
            }
        }

        return posicaoMenor;
    }
    //Metodo 17 - Recebe dois arrays de inteiros e retorna true se forem iguals
    // retorna false se forem diferentes
    public boolean exercicio17(int[] numeros1, int[] numeros2){
        if (numeros1.length != numeros2.length){
            return false;
        }

        for (int i = 0; i < numeros1.length; i++){
            if (numeros1[i] != numeros2[i]){
                return false;
            }
        }

        return true;
    }
    //Metodo 18 - Recebe um array de char e retorna uma String que representa o array
    public String exercicio18(char[] letras){
        String texto = "";

        for (int i = 0; i < letras.length; i++){
            texto = texto + letras[i];
        }

        return texto;
    }
    //Metodo 19 - Recebe um inteiro e retorna um array String preenchido com valores
    //via teclado
    public String[] exercicio19(int tamanho){
        try (Scanner sc = new Scanner(System.in)) {
            String[] palavras = new String[tamanho];

            for (int i = 0; i < palavras.length; i++){
                System.out.println("Digite a string da posição " + i + ":");
                palavras[i] = sc.nextLine();
            }

            return palavras;
        }

        
    }
    //Metodo 20 - Recebe um array de String e um inteiro x
    // Exclui o elemento da posição x, se possível, e retorna o novo array
    public String[] exercicio20(String[] array20, int x){
        if (x < 0 || x >= array20.length){
            return array20;
        }

        String[] resultado20 = new String[array20.length - 1];
        int j = 0;

        for (int i = 0; i < array20.length; i++){
            if (i != x){
                resultado20[j] = array20[i];
                j++;
            }
        }

        return resultado20;
    }
    //Metodo 21 - Recebe um array de double e imprime somente as posições pares
    public void exercicio21(double[] array21){
        for (int i = 0; i < array21.length; i = i + 2){
            System.out.println(i);
        }
    }
}
