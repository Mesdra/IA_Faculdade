package pacote;

import java.util.Collections;

import java.util.LinkedList;

import java.util.List;

public class Mochila {

	private List<Objeto> listaObjetos;

	private int pesoMaximo;

	public Mochila() {

		listaObjetos = new LinkedList<Objeto>();

		pesoMaximo = 0;

	}

	public Mochila(List<Objeto> listaObjetos, int pesoMaximo) {

		this.listaObjetos = new LinkedList<Objeto>(listaObjetos);

		this.pesoMaximo = pesoMaximo;

	}

	public List<Objeto> resolver() {

		List<Objeto> res = new LinkedList<Objeto>();

		// Collections.sort(listaObjetos);

		List<Qualidade> qualidade = new LinkedList<Qualidade>();

		for (int i = 0; i < listaObjetos.size(); i++) {
			Objeto o = listaObjetos.get(i);
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

		String res = "Peso m�ximo: " + pesoMaximo + "\nLista de objetos: ";

		res += listaObjetos.toString();

		return res;

	}

}
