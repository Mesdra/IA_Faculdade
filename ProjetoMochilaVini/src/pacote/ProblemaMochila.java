package pacote;

import java.util.Scanner;

public class ProblemaMochila {

	public static void main(String[] args) {

		int peso = 25;
		Mochila[] listaMochilas = new Mochila[10];
		Objeto[] listaObjetos = new Objeto[10];
		Qualidade q = new Qualidade();
		listaObjetos[0] = new Objeto(5, 3, "0001");

		listaObjetos[1] = (new Objeto(4, 3, "0010"));

		listaObjetos[2] = (new Objeto(7, 2, "0011"));

		listaObjetos[3] = (new Objeto(3, 4, "0100"));

		listaObjetos[4] = (new Objeto(4, 2, "0101"));

		listaObjetos[5] = (new Objeto(4, 3, "0110"));

		listaObjetos[6] = (new Objeto(5, 6, "0111"));

		listaObjetos[7] = (new Objeto(4, 2, "1000"));
		listaObjetos[8] = (new Objeto(0, 0, "0000"));

		Mochila mochila = new Mochila(listaObjetos, 45, 45);
		Mochila[] mochilas = new Mochila[20];
		Scanner s = new Scanner(System.in);
		for (int i = 0; i < 20; i++) {
			Mochila[] criacao = mochila.novaMochilas();
			mochilas[i] = criacao[0];
			i++;
			mochilas[i] = criacao[1];

		}
		for (int i = 0; i < 20; i++) {

			System.out.println(mochilas[i].toString());

		}

		boolean condicao = true;
		while (condicao) {
			
		
			int condd2 = s.nextInt();
			int[] qualidades = new int[20];
			for (int i = 0; i < 20; i++) {
				Mochila atual = mochilas[i];
				int dado = 0;
				for (int j = 0; j < 8; j++) {
					dado += atual.qualidade;
				}
				qualidades[i] = dado;
			}
			
		 
			Mochila[] filhos = new Mochila[20];
			for (int i = 0; i < 20; i++) {
				Mochila[] pais = new Mochila[2];
				pais[0] = mochilas[i];
				i++;
				pais[1] = mochilas[i];
				Mochila[] filho =  q.geralFilhos(pais);
				i--;
			  filhos[i] = filho[0];
			  i++;
			  filhos[i] = filho[1];
				
			}
			for (int i = 0; i < 20; i++) {

				System.out.println(filhos[i].toString());

			}
			
		}

	}

}
