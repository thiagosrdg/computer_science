public class OrdenaPlaca {

    public void algoritmo1(Placa[] placas){
        int n = placas.length;

        for (int i = 1; i < n; i++){
            Placa current = placas[i];

            int j = i - 1;

            while (j >= 0 && placas[j].getNumeros().compareTo(current.getNumeros()) > 0) {
                placas[j + 1] = placas[j];
                j--;
            }
            placas[j + 1] = current;
        }
    }

    public void algoritmo2(Placa[] placas){
        int n = placas.length;

        for (int i = 0; i < n - 1; i++){
            for(int j = 0; j < n - 1 - i; j++){
                if (placas[j].getLetras().compareTo(placas[j + 1].getLetras()) > 0){
                    Placa temp = placas[j];
                    placas[j] = placas[j + 1];
                    placas[j + 1] = temp;
                }
            }
        }
    }

    public void ordena(Placa[] placas){
        algoritmo1(placas);
        algoritmo2(placas);
    }

}
