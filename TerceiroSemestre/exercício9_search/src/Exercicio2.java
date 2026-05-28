public class Exercicio2 {

    public static int pesquisaBinaria(int[] v, int x) {
    int n = v.length;
    int inf = 0;
    int sup = n - 1;
    while (inf <= sup) {
        int meio = (inf + sup) / 2;
        if (v[meio] == x)
        return meio;
        if (x < v[meio])
            sup = meio - 1;
        else
            inf = meio + 1;
        }
        return -1;
    }
}       
