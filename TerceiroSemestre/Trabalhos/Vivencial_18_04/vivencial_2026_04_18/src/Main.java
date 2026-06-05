// Grupo: Murilo Neves dos Santos, Thiago da Silva Rodrigues, Rodrigo Py

public class Main {
    public static void main(String[] args) {
        
        int[][] mapa = {
        {0, 0, 0, 1},
        {1, 0, 1, 0},
        {0, 0, 0, 0},
        {1, 1, 0, 0}
        };

        int[][] mapa2 = {
        {0, 0, 1, 0},
        {0, 1, 0, 0},
        {0, 1, 0, 0},
        {1, 0, 1, 0}
        };
    
    System.out.println("\nMapa 1:");    

    boolean caminhoEncontrado = BuscaCaminho.encontrarCaminho(mapa);
    
    System.out.println("\nCaminho encontrado: " + caminhoEncontrado);

    System.out.println("\nMapa final:");
    BuscaCaminho.imprimirMapa(mapa);


    System.out.println("\nMapa 2:");
    System.out.println("\nCaminho encontrado: " + caminhoEncontrado);

    System.out.println("\nMapa final:");
    BuscaCaminho.imprimirMapa(mapa2);
        
    }
}
