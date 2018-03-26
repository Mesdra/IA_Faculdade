package pacote;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Qualidade {
	int qualidade;
	Objeto objeto;
	private static final int QUANTIDADE_OBJETOS = 8;

	public Qualidade() {
		qualidade = 0;
		objeto = new Objeto();
	}

	public Qualidade(int q, Objeto o) {
		qualidade = q;
		objeto = o;
	}

	public Mochila[] geralFilhos(Mochila[] lista) {

		Objeto[] lista1 = lista[0].listaObjetos;
		Objeto[] lista2 = lista[1].listaObjetos;
		Objeto[] aux = lista1.clone();

		for (int i = 0; i < lista1.length / 2; i++) {
			lista1[i] = lista2[i];
		}
		for (int i = lista1.length / 2; i < lista1.length; i++) {
			aux[i] = lista2[i];
		}
		int peso = 25;
		int valor = 0;
		Mochila mochila1 = new Mochila(lista1, peso, valor);
		Mochila mochila2 = new Mochila(aux, peso, valor);
		Mochila[] filhos = new Mochila[2];
		filhos[0] = mochila1;
		filhos[1] = mochila2;
		filhos = validarFilhos(filhos);
		return filhos;

	}

	public Mochila[] validarFilhos(Mochila[] lista) {

		Objeto[] filho1 = lista[0].listaObjetos;
		Objeto[] filho2 = lista[1].listaObjetos;
		int peso = 0;

		for (int i = 0; i < filho1.length; i++) {
			peso += filho1[i].peso;
		}
		if (peso > 25) {
			filho1 = mochilaInvalidaPeso(filho1, peso);
		}
		peso = 0;

		for (int i = 0; i < filho2.length; i++) {
			peso += filho2[i].peso;
		}
		if (peso > 25) {
			filho2 = mochilaInvalidaPeso(filho2, peso);
		}
		for (int i = 0; i < filho1.length; i++) {
			for (int j = 0; j < filho1.length; j++) {
				if (filho1[i] == filho1[j] && i != j && !filho1[i].codigo.equals("0000")) {
					filho1 = mochilaInvalidaDuplicidade(filho1, filho1[i]);
				}
			}
		}

		for (int i = 0; i < filho2.length; i++) {
			for (int j = 0; j < filho2.length; j++) {
				if (filho2[i] == filho2[j] && i != j && !filho2[i].codigo.equals("0000")) {
					filho2 = mochilaInvalidaDuplicidade(filho2, filho2[i]);
				}
			}
		}
		int valor = 0;
		for (int i = 0; i < filho1.length; i++) {
			valor += filho1[i].valor;
		}
		int valor1 = 0;
		for (int i = 0; i < filho2.length; i++) {
			valor1 += filho2[i].valor;
		}

		lista[0] = new Mochila(filho1, 25, valor);
		lista[1] = new Mochila(filho2, 25, valor1);
		return lista;
	}

	private Objeto[] mochilaInvalidaPeso(Objeto[] filho, int peso) {
		Random rand = new Random();
		boolean condicao = true;
		int peso1 = 0;
		Objeto ob = new Objeto();
		while (condicao) {
			int posicao = rand.nextInt(QUANTIDADE_OBJETOS);
			filho[posicao] = novoObjeto(rand.nextInt(QUANTIDADE_OBJETOS));
			ob = filho[posicao];
			peso1 = 0;

			for (int i = 0; i < filho.length; i++) {
				peso1 = filho[i].peso;
			}
			if (peso1 <= 25) {
				condicao = false;
			} else if (peso1 > peso) {
				filho[posicao] = ob;
			}
		}
		return filho;
	}

	private Objeto[] mochilaInvalidaDuplicidade(Objeto[] filho, Objeto dup) {
		Random rand = new Random();
		boolean condicao = true;
		int cont = 0;

		for (int i = 0; i < filho.length; i++) {
			if (filho[i] == dup) {
				Objeto dadoAtual = filho[i];
				while (condicao) {
					Objeto obj = novoObjeto(rand.nextInt(QUANTIDADE_OBJETOS));
					for (int j = 0; j < filho.length; j++) {
						if (obj.codigo.equals(filho[j].codigo) && !filho[j].codigo.equals("0000")) {
							cont++;
						}
					}
					if (cont == 0) {
						filho[i] = obj;
						int peso = 0;
						for (int k = 0; k < filho.length; k++) {
							peso = peso + filho[k].peso;
						}
						if (peso <= 25) {
							return filho;
						}
					} else {
						cont = 0;
					}
				}

			}
		}

		return filho;
	}

	public Objeto novoObjeto(int nextInt) {
		Objeto ob = new Objeto();
		ob = ItemString(nextInt);

		return ob;
	}

	private Objeto ItemString(int i) {
		switch (i) {
		case 0:
			return new Objeto(5, 3, "0001");
		case 1:
			return new Objeto(4, 3, "0010");
		case 2:
			return new Objeto(7, 2, "0011");
		case 3:
			return new Objeto(8, 4, "0100");
		case 4:
			return new Objeto(4, 2, "0101");
		case 5:
			return new Objeto(4, 3, "0110");
		case 6:
			return new Objeto(5, 6, "0111");
		case 7:
			return new Objeto(8, 2, "1000");
		case 8:
			return new Objeto(8, 2, "0000");
		default:
			return new Objeto(9, 9, "9999");
		}

	}
}
