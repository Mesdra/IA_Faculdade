package pacote;



import java.util.ArrayList;
import java.util.LinkedList;

import java.util.List;
import java.util.Random;

public class Mochila {

	Objeto[] listaObjetos =  new Objeto[8];

	 int pesoMaximo;
	
	 int qualidade;

	

	public Mochila(Objeto[] listaObjetos, int pesoMaximo,int valor) {

		this.listaObjetos = listaObjetos.clone();
        this.qualidade = valor;
		this.pesoMaximo = pesoMaximo;

	}

	public List<Objeto> resolver() {

		List<Objeto> res = new LinkedList<Objeto>();

		// Collections.sort(listaObjetos);

		List<Qualidade> qualidade = new LinkedList<Qualidade>();

		for (int i = 0; i < listaObjetos.length; i++) {
			Objeto o = listaObjetos[i];
			Qualidade q = new Qualidade(o.valor - o.peso, o);
			qualidade.add(q);
		}
		List<Qualidade> mQualidade = new LinkedList<Qualidade>();
		for (int y = 0; y < qualidade.size(); y++) {
			if (mQualidade.isEmpty()) {
				mQualidade.add(qualidade.get(y));
			} else {
				boolean cond = true;
				int k = 0;
				while (cond) {
					if (mQualidade.size() <= k) {
						mQualidade.add(qualidade.get(y));
						cond = false;
					}
					if (mQualidade.get(k).qualidade < qualidade.get(y).qualidade) {
						mQualidade.add(k, qualidade.get(y));
						cond = false;
					}
					k++;

				}

			}
		}

		int peso = 0;
		int i = 0;
		while (!mQualidade.isEmpty() && pesoMaximo >= peso) {
			res.add(mQualidade.get(i).objeto);
			peso = peso + mQualidade.get(i).objeto.peso;
			i++;
		}
		if (pesoMaximo < peso) {
			i--;
			res.remove(i);
		}
		if (pesoMaximo > peso) {
			boolean cond = true;
			while (cond) {
				Objeto obj = mQualidade.get(i).objeto;
				if (obj.peso + peso <= pesoMaximo) {
					res.add(obj);
					peso = peso + obj.peso;
				}
				if (mQualidade.size() < i) {
					i++;
				} else {
					cond = false;
				}
				if (pesoMaximo == peso)
					cond = false;
			}
		}

		return res;

	}
	public Mochila[] novaMochilas(){
		 Mochila[] mochilas = new Mochila[2]; 
		 Objeto[] lista = new Objeto[8];
		 Qualidade q = new Qualidade();
		 Random rand = new Random();
		 for (int i = 0; i < lista.length; i++) {
			lista[i] = q.novoObjeto(8);
		}
		 int cond = 2 + rand.nextInt(6);
		 for (int i = 0; i < cond; i++) {
				lista[rand.nextInt(8)] = q.novoObjeto(rand.nextInt(8));
			}
		 
		 int valor = 0;
		 for (int j = 0; j < lista.length;j++) {
				valor += lista[j].valor;
				
			}
		mochilas[0] = new Mochila(lista, 25, valor);
		
		 Objeto[] lista2 = new Objeto[8];
		

		 for (int i = 0; i < lista2.length; i++) {
			lista2[i] = q.novoObjeto(8);
		}
		 int cond2 = 2 + rand.nextInt(5);
		 for (int i = 0; i < cond2; i++) {
				lista2[rand.nextInt(8)] = q.novoObjeto(rand.nextInt(8));
			}
		 
		 int valor2 = 0;
		 for (int j = 0; j < lista2.length;j++) {
				valor2 += lista2[j].valor;
				
			}
		mochilas[1] = new Mochila(lista2, 25, valor2);
		
		
		return q.validarFilhos(mochilas);
	}

	public String toString() {

		String res = "Peso maximo: " + pesoMaximo +"valor"+ qualidade + "\nLista de objetos: ";
       for (int i = 0; i < listaObjetos.length; i++) {
    	   res += listaObjetos[i].toString();
	}
		

		return res;

	}

}
