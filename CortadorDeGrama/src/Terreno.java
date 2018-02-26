import java.util.concurrent.Semaphore;

public class Terreno {

	private char[][] Mat = new char[5][7];
	private int lin;
	private int col;
	private int finalizado;

	public boolean atualizaTerreno(int lin, int col, char situacao) {

		if (lin >= 5 || col >= 7)
			return false;
		if (situacao != 'g' && situacao != 'f' && situacao != 'O' && situacao != '#')
			return false;
		this.Mat[lin][col] = situacao;
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

	public char pegaPosicao(int lin, int col) {
		return this.Mat[lin][col];

	}

	public void gravaPosicao(int lin, int col, char val) {
		this.Mat[lin][col] = val;
	}

	public boolean tamanhoCampo(int lin, int col) {

		if (lin >= 0 && lin < 5 && col >= 0 && col < 7)
			return true;
		return false;
	}

	public char[][] getMat() {
		return Mat;
	}

	public void setMat(char[][] mat) {
		Mat = mat;
	}

	public void subindo(Terreno terreno) {
		if (terreno.tamanhoCampo(lin - 1, col) && terreno.pegaPosicao(lin - 1, col) == '#') {
			terreno.atualizaTerreno(lin, col, '#');
			lin = lin - 1;
			terreno.atualizaTerreno(lin, col, 'O');
		} else if (terreno.tamanhoCampo(lin - 1, col) && terreno.pegaPosicao(lin - 1, col) == 'g') {
			terreno.atualizaTerreno(lin, col, '#');
			lin = lin - 1;
			terreno.atualizaTerreno(lin, col, 'O');
		} else if (terreno.tamanhoCampo(lin - 1, col) && terreno.pegaPosicao(lin - 1, col) == 'f') {
			terreno.atualizaTerreno(lin, col, '#');
			if (terreno.tamanhoCampo(lin, col + 1) && terreno.pegaPosicao(lin, col + 1) != 'f') {
				terreno.atualizaTerreno(lin, col + 1, 'O');
				col = col + 1;
				for (int i = 0; i < 2; i++) {
					if (terreno.tamanhoCampo(lin - 1, col) && terreno.pegaPosicao(lin - 1, col) != 'f') {
						terreno.atualizaTerreno(lin, col, '#');
						terreno.atualizaTerreno(lin - 1, col, 'O');
						lin = lin + 1;
					}
				}
				if (terreno.tamanhoCampo(lin, col - 1) && terreno.pegaPosicao(lin, col - 1) != 'f') {
					terreno.atualizaTerreno(lin, col, '#');
					terreno.atualizaTerreno(lin, col - 1, 'O');
					col = col - 1;
				}

			} else if (terreno.tamanhoCampo(lin - 1, col)) {
				terreno.atualizaTerreno(lin - 1, col, 'O');
				lin = lin - 1;
				if (terreno.tamanhoCampo(lin, col + 1) && terreno.pegaPosicao(lin, col + 1) != 'f') {
					terreno.atualizaTerreno(lin, col, '#');
					terreno.atualizaTerreno(lin, col + 1, 'O');
					col = col + 1;
				}
			}
		}

	}

	public int getLin() {
		return lin;
	}

	public void setLin(int lin) {
		this.lin = lin;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public void descendo(Terreno terreno) {
		boolean cond = false;
	
			if (terreno.tamanhoCampo(lin + 1, col) && terreno.pegaPosicao(lin + 1, col) == '#') {
				terreno.atualizaTerreno(lin, col, '#');
				lin = lin + 1;
				terreno.atualizaTerreno(lin, col, 'O');
			} else if (terreno.tamanhoCampo(lin + 1, col) && terreno.pegaPosicao(lin + 1, col) == 'g') {
				terreno.atualizaTerreno(lin, col, '#');
				lin = lin + 1;
				terreno.atualizaTerreno(lin, col, 'O');
			} else if (terreno.tamanhoCampo(lin + 1, col) && terreno.pegaPosicao(lin + 1, col) == 'f') {
				terreno.atualizaTerreno(lin, col, '#');

				if (terreno.tamanhoCampo(lin, col + 1) && terreno.pegaPosicao(lin, col + 1) != 'f') {
					terreno.atualizaTerreno(lin, col + 1, 'O');
					col = col + 1;
					finalizado ++;

					for (int i = 0; i < 2; i++) {
						if (terreno.tamanhoCampo(lin + 1, col) && terreno.pegaPosicao(lin + 1, col) != 'f') {
							terreno.atualizaTerreno(lin, col, '#');
							terreno.atualizaTerreno(lin + 1, col, 'O');
							lin = lin + 1;
							cond = true;
						}
					}
					if (terreno.tamanhoCampo(lin, col - 1) && terreno.pegaPosicao(lin, col - 1) != 'f'
							&& cond == true ) {
						terreno.atualizaTerreno(lin, col, '#');
						terreno.atualizaTerreno(lin, col - 1, 'O');
						col = col - 1;
						cond = false;
						finalizado--;

						if (terreno.tamanhoCampo(lin, col-1) && terreno.pegaPosicao(lin, col-1) != 'f' && finalizado >= 0 ) {
							atualizaTerreno(lin, col, '#');
							col = col-1;
							finalizado --;
							atualizaTerreno(lin, col, 'O');
							if (terreno.pegaPosicao(lin-1, col ) != 'f') {
								atualizaTerreno(lin, col, '#');
								lin = lin-1;
								atualizaTerreno(lin, col, 'O');

							}else if(terreno.tamanhoCampo(lin + 1, col - 1) &&  terreno.pegaPosicao(lin + 1, col-1) != 'f' && finalizado >= 0  ) {
								if(terreno.pegaPosicao(lin + 1, col) != 'f') {
									terreno.atualizaTerreno(lin, col, '#');
									lin = lin +1;
									terreno.atualizaTerreno(lin, col, '#');
									terreno.atualizaTerreno(lin, col-1, 'O');
									col =col -1;
									finalizado --;
								}
							}
							
						}
					}

				}
			}
		
	}

}
