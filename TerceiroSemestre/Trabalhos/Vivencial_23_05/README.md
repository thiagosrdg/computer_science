# ATIVIDADE VIVENCIAL 5 — ESTRUTURA ENCADEADA

Nesta atividade, vamos trabalhar conceitos importantes vistos na disciplina:

- Estruturas encadeadas
- Nós (Node)
- Manipulação de ponteiros
- Remoção de elementos
- Simulação utilizando estruturas de dados

O objetivo é implementar uma estrutura que simule a brincadeira **"O limão entrou na roda"**.

---

## Contexto

Uma brincadeira clássica entre crianças é "O limão entrou na roda".

Todos formam uma roda e um objeto é passado entre os participantes. Quando a música termina, quem estiver com o objeto sai da roda. A brincadeira continua até restar apenas uma pessoa.

Seu trabalho será implementar esta brincadeira utilizando estrutura encadeada.

---

## Objetivo

- Implementar a estrutura
- Utilizar nós para representar participantes
- Simular passagem do objeto
- Remover participantes
- Identificar corretamente o vencedor

---

## Parte 1 — Classe Pessoa

Criar a classe `Pessoa` com os atributos:

```java
private String nome;
private int idade;
```

Criar construtor, métodos `get`, métodos `set` (caso necessário) e `toString()`.

---

## Parte 2 — Classe LimaoEntrouNaRoda

Criar a estrutura principal da brincadeira. A estrutura deve possuir atributos equivalentes a:

```java
private Node inicio;
private int quantidade;
```

- Cada nó deve armazenar um objeto `Pessoa`.
- **Não utilizar** `ArrayList`, `LinkedList` ou estruturas prontas.

---

## Parte 3 — Construtor

Receber a quantidade de participantes e criar automaticamente a estrutura.

---

## Parte 4 — Método passaObjeto

```java
public int passaObjeto(int x)
```

Deve simular a passagem do objeto e retornar a posição em que ele parou.

---

## Parte 5 — Método removePosicao

```java
public Pessoa removePosicao(int x)
```

Deve remover corretamente o participante, atualizar ponteiros e retornar a vencedora quando restar apenas uma pessoa.

---

## Parte 6 — Classe Principal

Exemplo de `main` para testar a estrutura criada:

```java
public static void main(String[] args) {
    LimaoEntrouNaRoda l = new LimaoEntrouNaRoda(10);
    l.imprimeRoda();
    System.out.println("*****");

    boolean acabou = false;
    Pessoa p = null;

    while (!acabou) {
        int posicao = l.passaObjeto(14);
        p = l.removePosicao(posicao);
        l.imprimeRoda();
        System.out.println("************");
        acabou = p != null;
    }

    System.out.println(p);
}
```

> O professor poderá utilizar uma classe de teste própria para validação da estrutura implementada.

---

## Critérios de Avaliação — 1,0 ponto

| Critério | Pontos |
|---|---|
| Classe Pessoa | 0,15 |
| Estrutura encadeada circular | 0,20 |
| Construtor da estrutura | 0,20 |
| Método `passaObjeto(int x)` | 0,15 |
| Método `removePosicao(int x)` | 0,20 |
| Simulação final (PrincipalLimao) | 0,10 |
| **Total** | **1,0** |

### Detalhamento

**0,15 — Classe Pessoa**
- Atributos corretos
- Construtor
- Métodos get
- Método `toString()`

**0,20 — Estrutura encadeada circular**
- Criação correta dos nós
- Encadeamento circular funcionando
- Ponteiro de início correto
- Controle correto da quantidade de elementos

**0,20 — Construtor da estrutura**
- Criação automática dos participantes
- Montagem correta da roda
- Estrutura inicia corretamente

**0,15 — Método passaObjeto(int x)**
- Deslocamento correto pela estrutura
- Funcionamento circular
- Retorno correto da posição

**0,20 — Método removePosicao(int x)**
- Remoção correta
- Atualização dos ponteiros
- Atualização do início
- Retorno correto da pessoa vencedora

**0,10 — Simulação final (PrincipalLimao)**
- Execução completa
- Funcionamento com a `main` fornecida
- Impressão adequada dos resultados

---

## Penalizações

| Situação | Nota máxima |
|---|---|
| Código que não compila | 0,50 |
| Uso de `ArrayList`, `LinkedList` ou estruturas prontas | 0,50 |
| Estrutura sem funcionamento correto | 0,50 |
| Sem método `passaObjeto` | 0,75 |
| Sem método `removePosicao` | 0,75 |
| Falta do nome completo dos integrantes nos arquivos `.java` | 0,75 |

---

## Forma de Entrega

A atividade deverá ser enviada por meio da tarefa disponibilizada no Moodle, no formato envio de arquivo único.

Os estudantes deverão:

- Compactar todos os arquivos do projeto em um único arquivo `.zip`
- Incluir obrigatoriamente todos os arquivos-fonte `.java`
- Garantir que o projeto esteja completo e organizado

Os nomes **completos** dos integrantes devem constar no cabeçalho dos arquivos `.java`, identificados como autores do código.

O nome do arquivo `.zip` deve seguir o formato:

```
IDE_Tarefa_Nome1Completo_Nome2Completo.zip
```

**Exemplo:**

```
Eclipse_Tarefa_MarcosKich_AnaSilva.zip
```

> **Importante:** caso os arquivos-fonte `.java` não sejam enviados, ou o projeto não esteja compactado corretamente em um único arquivo `.zip`, a atividade não será avaliada.
