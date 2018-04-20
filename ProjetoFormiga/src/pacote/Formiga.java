package pacote;

public class Formiga {
	float coFerormonio;
	int tamanhoMochila;
	Objeto[] listaObjetos;
	int posicao=0;
	int quantMochila =0;
	int valorMochila =0;
	
	public Formiga(float fer,int tamanho) {
		this.coFerormonio = fer;
		this.tamanhoMochila = tamanho;
	}

	public void add(Objeto objeto) {
		listaObjetos[posicao]= objeto;
		posicao++;
		
	}

	@Override
	public String toString() {
		return "Formiga [coFerormonio=" + coFerormonio + ", tamanhoMochila=" + tamanhoMochila + ", posicao=" + posicao
				+ ", quantMochila=" + quantMochila + ", valorMochila=" + valorMochila + "]";
	}


}
