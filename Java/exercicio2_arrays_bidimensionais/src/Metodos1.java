public class Metodos1 {

    //Exercicio 1a
    public static int [][] exercicio1a(){
        int[][] matriz1 = new int [3][10];

        for(int i = 0; i < matriz1.length; i++){
            for(int j = 0; j < matriz1[i].length; j++){
                matriz1[i][j] = j;
            }
        }
    
        return matriz1;
    }
    //Exercicio 1b
    public static int [][] exercicio1b(){
        int[][] matriz2 = new int [5][10];

        for(int i = 0; i < matriz2.length; i++){
            for(int j = 0; j < matriz2[i].length; j++){
                matriz2[i][j] = j * j;
            }
        }

        return matriz2;
    }
    //Exercicio 1c
    public static int [][] exercicio1c(){
        int[][] matriz3 = new int [6][6];

        for(int i = 0; i < matriz3.length; i++){
            for(int j = 0; j < matriz3[i].length; j++){
                matriz3[i][j] = i;
            }
        }

        return matriz3;
    }
    //Exercicio 1d
    public static int [][] exercicio1d(){
        int[][] matriz4 = new int [6][9];

        for(int i = 0; i < matriz4.length; i++){
            for(int j = 0; j < matriz4[i].length; j++){
                if (i % 2 == 0){
                    matriz4[i][j] = -1;
                } else {
                    matriz4[i][j] = 0;
                }
            }
        }

        return matriz4;
    }
}

