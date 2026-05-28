public class Metodos {

	// Percorre a matriz inteira e imprime seus valores linha por linha.
	public void imprimeArray(int[][] m){
		for(int i = 0; i < m.length; i++){
			for(int j = 0; j < m [i].length; j++)
				System.out.print(m[i][j] + " ");
			System.out.println();
		}
	}
	
	// Percorre um vetor simples e imprime seus valores.
	public void imprimeArray(int[] m){
		for(int i = 0; i < m.length; i++)
			System.out.print(m[i] + " ");
	}
	
	// Imprime apenas a linha escolhida pelo índice "lin".
	public void imprimeLinhaArray(int[][] m, int lin){
		for(int i = 0; i < m[lin].length; i++)
			System.out.print(m[lin][i] + " ");
	}
	
	// Imprime apenas a coluna escolhida pelo índice "col".
	public void imprimeColunaArray(int[][] m, int col){
		for(int i = 0; i < m.length; i++)
			System.out.println(m[i][col]);
	}

	// Soma os valores da diagonal principal: [0][0], [1][1], [2][2]...
	public int somaDiagonalPrincipal(int[][] m) throws MinhaExcecao{
		// Só é possível fazer isso corretamente quando a matriz é quadrada.
		if(m.length != m[0].length)
			throw new MinhaExcecao("Matriz não é quadrada.");
		
		int soma = 0;
		
		// Na diagonal principal, linha e coluna têm o mesmo índice.
		for(int i = 0; i < m.length; i++)
			soma += m[i][i];
		
		return soma;
	}
	
	// Guarda em um vetor todos os números pares encontrados na matriz.
	public int[] encontraPares(int[][] m){
		int[] retorno = new int[m.length * m[0].length];
		int contPares = 0;
		
		for(int i = 0; i < m.length; i++)
			for(int j = 0; j < m[i].length; j++)
				if(m[i][j] % 2 == 0)
					retorno[contPares++] = m[i][j];
		
		// Se não encontrou nenhum par, retorna null.
		// Caso contrário, retorna o vetor com os pares nas primeiras posições.
		return contPares == 0 ? null : retorno;
		
		//OU
		/*if(contPares == 0)
			return null;
		return retorno;*/
	}
	
	// Guarda em um vetor todos os números primos encontrados na matriz.
	public int[] encontraPrimos(int[][] m){
		int[] retorno = new int[m.length * m[0].length];
		int quantPrimos = 0;
		
		for(int i = 0; i < m.length; i++)
			for(int j = 0; j < m[i].length; j++)
				if(verificaPrimo(m[i][j]))
					retorno[quantPrimos++] = m[i][j];
		
		return quantPrimos == 0 ? null : retorno;
	}
	
	// Verifica se um número é primo.
	public boolean verificaPrimo(int d){
		if(d < 2)
			return false;
		
		// Testa se existe algum divisor entre 2 e a raiz quadrada do número.
		for(int i = 2; i <= Math.sqrt(d); i++)
			if(d % i == 0)
				return false;
		
		return true;
	}
	
	// Calcula a média de todos os elementos da matriz.
	public double calculaMedia(int[][] m){
		int quantElementos = 0;
		double soma = 0;
		
		for(int i = 0; i < m.length; i++)
			for(int j = 0; j < m[i].length; j++){
				soma += m[i][j];
				quantElementos++;
			}
		
		return soma/quantElementos;
	}
	
	// Calcula uma média separada para cada linha da matriz.
	public double[] calculaMediaLinhas(int[][] m){
		double[] retorno = new double[m.length];
		double soma = 0;
		int posicaoRetorno = 0;
		
		for(int i = 0; i < m.length; i++){
			// Soma todos os valores da linha atual.
			for(int j = 0; j < m[i].length; j++)
				soma += m[i][j];
			// Guarda a média no vetor de retorno.
			retorno[posicaoRetorno++] = soma/m[i].length;
			// Zera a soma para começar a próxima linha.
			soma = 0;
		}
		
		return retorno;
	}
	
	// Calcula uma média separada para cada coluna da matriz.
	public double[] calculaMediasColunas(int[][] m){
		double[] retorno = new double[m[0].length];
		int posicaoRetorno = 0;
		double soma = 0;
		
		for(int j = 0; j < m[0].length; j++){
			// Para cada coluna, percorre todas as linhas.
			for(int i = 0; i < m.length; i++)
				soma += m[i][j];
			retorno[posicaoRetorno++] = soma/m.length;
			soma = 0;
		}
		
		return retorno;
	}
	
	// Calcula a média juntando todos os elementos das duas matrizes.
	public double calculaMedia(int[][] m, int[][] n){
		double soma = 0;
		int quantElementos = 0;
		
		// Soma todos os elementos da primeira matriz.
		for(int i = 0; i < m.length; i++)
			for(int j = 0; j < m[i].length; j++){
				soma += m[i][j];
				quantElementos++;
			}
		
		// Soma todos os elementos da segunda matriz.
		for(int i = 0; i < n.length; i++)
			for(int j = 0; j < n[i].length; j++){
				soma += n[i][j];
				quantElementos++;
			}
		
		return soma/quantElementos;
	}
	
	// Soma todos os valores da primeira matriz com todos os valores da segunda.
	public int somaArrays(int[][] m, int[][] n){
		int soma = 0;
		
		for(int i = 0; i < m.length; i++)
			for(int j = 0; j < m[i].length; j++)
				soma += m[i][j];
		
		for(int i = 0; i < n.length; i++)
			for(int j = 0; j < n[i].length; j++)
				soma += n[i][j];
		
		return soma;
	}
	
	// Soma as matrizes posição por posição.
	public int[][] somaPosicoesArrays(int[][] a, int[][] b) throws MinhaExcecao{
		// Para somar posição por posição, os tamanhos precisam ser iguais.
		if(a.length != b.length || a[0].length != b[0].length)
			throw new MinhaExcecao("Arrays de tamanhos diferentes.");
		
		int[][] retorno = new int[a.length][a[0].length];
		
		for(int i = 0; i < retorno.length; i++)
			for(int j = 0; j < retorno[i].length; j++)
				retorno[i][j] = a[i][j] + b[i][j];
		
		return retorno;
	}
	
}
