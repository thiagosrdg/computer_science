public class ArCondicionado {
    
    private double temperaturaAtual;

    public ArCondicionado(double temperaturaAtual) {
        this.temperaturaAtual = temperaturaAtual;
    }

    public void aumentaTemperatura(double tempMais) {
        try {
            double novaTemperatura = this.temperaturaAtual + tempMais;

            if (novaTemperatura < 16 || novaTemperatura > 32) {
                throw new IllegalArgumentException(
                    "Temperatura inválida! O valor deve ficar entre 16 e 32 graus."
                );
            }

            this.temperaturaAtual = novaTemperatura;
            System.out.println("Temperatura aumentada para: " + this.temperaturaAtual);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao aumentar temperatura: " + e.getMessage());
        }
    }

    public void diminuiTemperatura(double tempMenos) {
        try {
            double novaTemperatura = this.temperaturaAtual - tempMenos;

            if (novaTemperatura < 16 || novaTemperatura > 32) {
                throw new IllegalArgumentException(
                    "Temperatura inválida! O valor deve ficar entre 16 e 32 graus."
                );
            }

            this.temperaturaAtual = novaTemperatura;
            System.out.println("Temperatura diminuída para: " + this.temperaturaAtual);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao diminuir temperatura: " + e.getMessage());
        }
    }

    public double getTemperaturaAtual() {
        return temperaturaAtual;
    }
}