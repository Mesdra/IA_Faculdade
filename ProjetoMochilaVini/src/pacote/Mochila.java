package pacote;



import java.util.ArrayList;
import java.util.LinkedList;

import java.util.List;

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

	public String toString() {

		String res = "Peso maximo: " + pesoMaximo +"valor"+ qualidade + "\nLista de objetos: ";
       for (int i = 0; i < listaObjetos.length; i++) {
    	   res += listaObjetos[i].toString();
	}
		

		return res;

	}

}
