public class Main {
    public static void main(String[] args) {
        ArCondicionado ar = new ArCondicionado(20);

        try {
            ar.aumentaTemperatura(5);   // 25
            ar.aumentaTemperatura(10);  // 35 -> lança exceção
            ar.diminuiTemperatura(2);   // esta linha não executa se a exceção ocorrer antes
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            ar.diminuiTemperatura(10);  // pode gerar exceção
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}