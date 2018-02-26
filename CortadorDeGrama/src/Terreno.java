
public class Terreno {

	private char[][] Mat = new char[5][7];

	 public boolean atualizaTerreno(int linha, int coluna, char situacao) {

		if (linha >= 5 || coluna >= 7)
			return false;
		if (situacao != 'g' && situacao != 'f' && situacao != 'O')
			return false;
		this.Mat[linha][coluna] = situacao;

		return true;
	}

	public void atualizaTela() {
		for (int i = 0; i < 5; i++) {
			System.out.print("\n");
			for (int j = 0; j < 7; j++) {
				System.out.printf("|" + this.Mat[i][j] + "|");
			}
		}

	}

	public Terreno() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 7; j++) {
				this.Mat[i][j] = '#';
			}
		} 
	}
	

	public char[][] getMat() {
		return Mat;
	}

	public void setMat(char[][] mat) {
		Mat = mat;
	}

	public void moveCortador() {}

}
