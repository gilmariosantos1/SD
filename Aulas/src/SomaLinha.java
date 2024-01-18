public class SomaLinha extends Thread {
	private int[][] m1;
	private int linha;

	public SomaLinha(int[][] m1, int linha) {
		this.m1 = m1;
		this.linha = linha;
	}

	public void run() {
		int soma = 0;
		for (int j = 0; j < m1[0].length; j++) {
			soma = soma + m1[linha][j];
		}
		System.out.println("Linha: " + linha + ": " + soma);
	}

}
