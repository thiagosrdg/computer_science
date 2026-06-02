# Exercícios: Listas Lineares

1. Implemente um método, em uma classe qualquer, que receba como parâmetro uma lista sequencial de números inteiros (objetos do tipo Integer) e retorne um vetor contendo apenas os números pares desta lista.
   ```java
   public Integer[] evenNumbers(List<Integer> lista)
   ```

2. Implemente um método que recebe duas listas e retorna uma terceira, contendo a intercalação dos métodos das duas iniciais. Por exemplo, dadas as listas t1 = (A, B, C) e t2 = (D, E, F), a intercalação das duas deve produzir (A, D, B, E, C, F). As listas originais não devem ser alteradas.
   ```java
   public List<Character> mergeLists(List<Character> t1, List<Character> t2)
   ```

3. Implemente um método que recebe duas listas `t1` e `t2` e copia os elementos da segunda para o início da primeira.
   ```java
   public void prependList(List<Double> t1, List<Double> t2)
   ```

> Nos exercícios a seguir, os métodos solicitados devem ser implementados dentro das classes que implementam listas. Salvo indicação em contrário, as estruturas passadas como parâmetro (arrays, outras listas, etc.) devem ser preservadas, ou seja, seus elementos não devem ser removidos ou trocados de ordem.

4. Implemente um método que remove da lista um elemento passado como parâmetro. Esse método retorna *true* quando o elemento é achado e removido, *false* caso contrário. Será removida apenas a primeira ocorrência do elemento.
   ```java
   public boolean remove(E element)
   ```

5. Implemente um método *insertAfter*, abaixo, que insere o elemento `obj2` uma posição após o elemento `obj1`. Considere a primeira ocorrência de `obj1`. Se `obj1` não for encontrado, gere uma exceção apropriada.
   ```java
   public void insertAfter(E obj1, E obj2)
   ```

6. Implemente um método que troca de lugar os objetos localizados nas posições passadas como parâmetro. Se alguma das posições for inválida, deve ser gerada a exceção do Java *IndexOutOfBoundsException*.
   ```java
   public void swap(int pos1, int pos2)
   ```

7. Implemente um método que inverte a ordem dos elementos da lista.
   ```java
   public void flip()
   ```

8. Implemente uma sobrecarga do método *insert* que recebe como parâmetro uma lista, em vez de um elemento. Esse método deve adicionar à lista corrente os elementos daquela passada como parâmetro, a partir da posição indicada.

9. Implemente um método que remove ocorrências múltiplas de elementos na lista. Para cada elemento contido na lista, somente a primeira ocorrência deve ser mantida.
   ```java
   public void dedup()
   ```

10. Implemente um método `equals` para a lista. Uma lista será igual a outra se contiver os mesmos elementos, dispostos na mesma ordem. Para comparar os elementos, use também o método `equals`. Pesquise como desenvolver o método `equals` de um objeto no Java.

11. Implemente um método *clone* para a lista. Esse método deve retornar uma nova lista contendo os mesmos elementos da atual. Os elementos em si não devem ser duplicados.

12. Implemente um método que remove da lista os elementos compreendidos entre as posições `ini` e `fim` (inclusive). Ele deve retornar a quantidade de elementos removidos.
    ```java
    public int remove(int ini, int fim)
    ```

13. Implemente um método *split* que divide a lista em duas partes. A lista corrente deve ficar somente com os elementos do início até uma posição antes da indicada, e o método deve retornar uma nova lista contendo os elementos da posição indicada até o final.
    ```java
    public List<E> split(int pos)
    ```
