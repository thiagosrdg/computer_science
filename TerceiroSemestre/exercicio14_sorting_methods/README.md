# Exercícios sobre Métodos de Ordenação — Unisinos

## Exercício 1

Considere o array abaixo:

`4 -3 18 22 50 1 47 -29`

Mostre os passos necessários para ordenar este array utilizando os métodos:

- Bubble Sort
- Inserção Direta
- Seleção Direta

---

## Exercício 2

Pesquise e responda: qual a importância e utilização de algoritmos de ordenação estáveis? Em que contextos são importantes?

---

## Exercício 3

Dos 3 algoritmos de ordenação estudados, quais deles são estáveis e quais deles são instáveis (ou não-estáveis)? Você deve se basear nas implementações vistas nas videoaulas. Caso você julgue que algum dos algoritmos **não seja estável**, justifique sua resposta (apresentando exemplos ou indicando no próprio código o que faz com que ele não seja estável).

---

## Exercício 4

De acordo com sua resposta do Exercício 3, faça o que se pede:

- Crie uma classe chamada **Placa**, que possui dois atributos: letras e números (utilize os dois atributos do tipo String). Crie o construtor, métodos de acesso e *toString()* para esta classe.

- Crie uma classe chamada **OrdenaPlaca**. Nesta classe, você deve escolher 2 métodos de ordenação **diferentes** (dentre os 3 que trabalhamos) para realizar a ordenação de um array de placas: um dos métodos deve ordenar um array de objetos do tipo Placa (recebido por parâmetro) **em relação às letras, ou seja em ordem alfabética**; e o outro método deve ordenar um array de objetos do tipo Placa (recebido por parâmetro) **em relação aos números (em ordem crescente)**. As assinaturas dos métodos são:

```java
private void algoritmoDeOrdenacao1(Placa[] placas)
private void algoritmoDeOrdenacao2(Placa[] placas)
```

> **Dica:** para ordenar as placas pelas letras, utilize o método `compareTo` da classe String. Veja na API do Java o funcionamento do método. Abaixo podemos ver um exemplo deste método, execute na sua IDE para ver a saída.

```java
public class Main {
    public static void main(String[] args) {
        String primeira = "GAF";
        String segunda = "CDS";

        if(primeira.compareTo(segunda) > 0)
            System.out.println(segunda + " | " + primeira);
        else
            System.out.println(primeira + " | " + segunda);
    }
}
```

- Depois disso, ainda na classe *OrdenaPlaca*, você deve criar um método chamado **ordena**, que recebe por parâmetro um array de objetos do tipo Placa. Este método chama os métodos de ordenação criados anteriormente para que o array fique ordenado de acordo com as letras das placas, em ordem alfabética. Por exemplo, para as placas abaixo:

| ABC 1874 | AAF 9984 | XIJ 2943 | DKA 3212 | DJ 8835 |

O array resultante seria:

| AAF 9984 | ABC 1874 | DKA 3212 | DJ 8835 | XIJ 2943 |

**ENTRETANTO**, é possível que existam placas com as mesmas letras. Quando isto acontecer, **seu método deve garantir que as placas ficarão ordenadas também pelo número**. Por exemplo, para as placas abaixo:

| ABC 1874 | AAF 9984 | XIJ 2943 | AAF 3212 | DJ 8835 |

O array resultante seria:

| AAF 3212 | AAF 9984 | ABC 1874 | DJ 8835 | XIJ 2943 |

Assim sendo, o método *ordena* está pronto, e possui apenas 2 linhas de código:

```java
public void ordena(Placa[] placas){
    algoritmoDeOrdenacao1(placas);
    algoritmoDeOrdenacao2(placas);
}
```

Cabe a você escolher os algoritmos corretos e invocá-los na ordem correta, de acordo com o que estudamos e falamos sobre estabilidade de algoritmos, juntamente com o que foi pesquisado para responder os Exercícios 2 e 3.

Abaixo é possível encontrar um exemplo de main para testar a criação e ordenação das placas:

```java
public class TestePlaca {
    public static void main(String[] args) {
        Placa[] placas = new Placa[(int)(Math.random()*100+1)];

        for(int i=0; i<placas.length; i++){
            String numero = "";
            for(int j=0; j<4; j++)
                numero += (int)(Math.random()*10);
            String letras = "";
            for(int j=0; j<3; j++)
                letras += (char)((int)(Math.random()*26) + 65);
            placas[i] = new Placa(letras, numero);
        }

        OrdenaPlaca op = new OrdenaPlaca();
        op.ordena(placas);

        for(Placa p: placas)
            System.out.println(p);
    }
}
```

---


