package pacote;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Formiga[] formigas = new Formiga[4];
		Objeto[][] matrisObjetos = new Objeto[20][20];
		int[] listadeferomonio = new int[10];
		for(int i =0;i < 10;i++) {
			for(int j =0;j < 10;j++) {
				matrisObjetos[i][j] = new Objeto(0 ,0, 0);
			}
		}
		Objeto[] dados = new Objeto[8]; 
		dados[0] = new Objeto(4, 4,5);
		dados[1] = new Objeto(4, 2,5);
		dados[2] = new Objeto(7, 9,5);
		dados[3] = new Objeto(3, 6,5);
		dados[4] = new Objeto(4, 5,5);
		dados[5] = new Objeto(8, 3,5);
		dados[6] = new Objeto(6, 6,5);
		dados[7] = new Objeto(6, 6,5);
		
		matrisObjetos[1][1] = new Objeto(4, 4,dados[0].ferormonio);
		matrisObjetos[3][6] = new Objeto(4, 2,dados[1].ferormonio);
		matrisObjetos[2][3] = new Objeto(7, 9,dados[2].ferormonio);
		matrisObjetos[8][8] = new Objeto(3, 6,dados[3].ferormonio);
		matrisObjetos[4][1] = new Objeto(4, 5,dados[4].ferormonio);
		matrisObjetos[1][6] = new Objeto(8, 3,dados[5].ferormonio);
		matrisObjetos[2][8] = new Objeto(6, 6,dados[6].ferormonio);
		matrisObjetos[8][3] = new Objeto(3, 3,dados[7].ferormonio);
		
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
		 Scanner scanner = new Scanner(System.in);
		boolean cond = true;
		Objeto obj = new Objeto(0, 0, 0);
		while(cond){
			int i = scanner.nextInt();
			for(int j =0;j < 4;j++) {
				formigas[j] = obj.encherMochilas(formigas[j],matrisObjetos);
				i = scanner.nextInt();
				for(int u =0;u < 10;u++) {
					for(int v =0;v < 10;v++) {
						matrisObjetos[u][v] = new Objeto(0 ,0, 0);
					}
				}
				
				matrisObjetos[1][1] = new Objeto(4, 4,dados[0].ferormonio);
				matrisObjetos[3][6] = new Objeto(4, 2,dados[1].ferormonio);
				matrisObjetos[2][3] = new Objeto(7, 9,dados[2].ferormonio);
				matrisObjetos[8][8] = new Objeto(3, 6,dados[3].ferormonio);
				matrisObjetos[4][1] = new Objeto(4, 5,dados[4].ferormonio);
				matrisObjetos[1][6] = new Objeto(8, 3,dados[5].ferormonio);
				matrisObjetos[2][8] = new Objeto(6, 6,dados[6].ferormonio);
				matrisObjetos[8][3] = new Objeto(3, 3,dados[7].ferormonio);
				
				for(int o =0;o < 4;o++) {
					System.out.print("|"+formigas[o].toString()+"|");
					System.out.print("\n");
				}
				for(int o =0;o < 10;o++) {
					System.out.println();
					for(int h =0;h < 10;h++) {
						System.out.print("|"+matrisObjetos[o][h].toString()+"|");
					}
				}
			}
			matrisObjetos =matrisObjetos[0][0].addFeromonio(matrisObjetos,formigas,dados);
		};
		
	}




}
