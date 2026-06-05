public class Main {
    public static void main(String[] args) {
        ArCondicionado ar = new ArCondicionado(20);

        ar.aumentaTemperatura(5);   // vai para 25
        ar.aumentaTemperatura(10);  // tentaria ir para 35 -> erro tratado no método
        ar.diminuiTemperatura(3);   // vai para 22
        ar.diminuiTemperatura(10);  // tentaria ir para 12 -> erro tratado no método
    }
}