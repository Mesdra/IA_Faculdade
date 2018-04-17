package pacote;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Formiga[] formigas = new Formiga[4];
		Objeto[][] matrisObjetos = new Objeto[20][20];
		
		for(int i =0;i < 10;i++) {
			for(int j =0;j < 10;j++) {
				matrisObjetos[i][j] = new Objeto(0, 0);
			}
		}
		matrisObjetos[1][1] = new Objeto(3, 4);
		matrisObjetos[3][6] = new Objeto(4, 2);
		matrisObjetos[9][9] = new Objeto(7, 9);
		matrisObjetos[6][5] = new Objeto(2, 6);
		matrisObjetos[2][7] = new Objeto(5, 5);
		
		formigas[0] = new Formiga((float) 1.75 ,25);
		formigas[1] = new Formiga((float) 0.75 ,25);
		formigas[2] = new Formiga((float) 2 ,25);
		formigas[3] = new Formiga((float) 0.5 ,25);
		
		for(int i =0;i < 10;i++) {
			System.out.println();
			for(int j =0;j < 10;j++) {
				System.out.print("|"+matrisObjetos[i][j].toString()+"|");
			}
		}
		
	}

}
