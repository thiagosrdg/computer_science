public class ArCondicionado {
    private double temperaturaAtual;

    public ArCondicionado(double temperaturaAtual) {
        this.temperaturaAtual = temperaturaAtual;
    }

    public void aumentaTemperatura(double tempMais) {
        double novaTemperatura = this.temperaturaAtual + tempMais;

        if (novaTemperatura < 16 || novaTemperatura > 32) {
            throw new IllegalArgumentException(
                "Temperatura inválida! O valor deve ficar entre 16 e 32 graus."
            );
        }

        this.temperaturaAtual = novaTemperatura;
        System.out.println("Temperatura aumentada para: " + this.temperaturaAtual);
    }

    public void diminuiTemperatura(double tempMenos) {
        double novaTemperatura = this.temperaturaAtual - tempMenos;

        if (novaTemperatura < 16 || novaTemperatura > 32) {
            throw new IllegalArgumentException(
                "Temperatura inválida! O valor deve ficar entre 16 e 32 graus."
            );
        }

        this.temperaturaAtual = novaTemperatura;
        System.out.println("Temperatura diminuída para: " + this.temperaturaAtual);
    }

    public double getTemperaturaAtual() {
        return temperaturaAtual;
    }
}