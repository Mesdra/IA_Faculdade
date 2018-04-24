package pacote;

import java.util.Random;

public class Objeto {
	float ferormonio;
	int peso;
	int valor;
	Formiga formiga;
	public Objeto(int peso,int valor, float fer) {
		this.peso = peso;
		this.valor = valor;
		this.ferormonio = fer;
		this.formiga = new Formiga(-1, -1);
	}
	
	public void ObjetoFormiga(Formiga fo) {
		this.formiga = fo;
	}
	@Override
	public String toString() {
		return "F" + ferormonio + "/P" + peso + "/ V" + valor;
	}
	public Formiga encherMochilas(Formiga formiga, Objeto[][] matrisObjetos) {
		Random rand = new Random();
		int x = rand.nextInt(10);
		int y = rand.nextInt(10);
				
				matrisObjetos[x][y].formiga = formiga;
		
		return procurarMelhorNo(matrisObjetos,x,y,formiga);
	}
	void somaFer(int fer){
		this.ferormonio +=fer;
		
	}

	private Formiga procurarMelhorNo(Objeto[][] matrisObjetos, int x, int y,Formiga formiga) {
		boolean fim  = true;
		while(fim) {
		float[] qualidade = new float[8] ;
		int distancia = 0;
		int o =0;
		for(int i =0;i < 10;i++) {
			for(int j =0;j < 10;j++) {
				if(matrisObjetos[i][j].valor != 0 && matrisObjetos[i][j].formiga.tamanhoMochila == -1) {
					distancia = (x+y) - (i+j);
					distancia = Math.abs(distancia);
					qualidade[o] = matrisObjetos[i][j].ferormonio-distancia;
					o++;
				}
			}
		}
		int melhor=0;
		float conts = 0;
		for(int i =0;i < 5;i++) {
		   if(qualidade[i] > conts) {
			   conts = qualidade[i];
			   melhor = i;
		   }
		}
		
		int contador = 0 ;
		if(conts == 0) {
			Random rand = new Random();;
			melhor =  rand.nextInt(qualidade.length);
		}
		for(int i =0;i < 10;i++) {
			for(int j =0;j < 10;j++) {
				if(matrisObjetos[i][j].valor != 0  && matrisObjetos[i][j].formiga.tamanhoMochila == -1) {
					if(contador == melhor) {
						formiga.add(matrisObjetos[i][j]);
						matrisObjetos[i][j].formiga = formiga;
						x = i;
						y = j;
						contador++;
					}else
						contador++;
				}
			}
		}
		formiga.quantMochila = 0;
		formiga.valorMochila = 0;
		
		for(int j =0;j < formiga.posicao;j++) {		
			formiga.quantMochila = formiga.quantMochila + formiga.listaObjetos[j].peso;
			formiga.valorMochila = formiga.valorMochila + formiga.listaObjetos[j].valor;
		}
		if(formiga.quantMochila == formiga.tamanhoMochila) {
			return formiga;
		}else if(formiga.quantMochila > formiga.tamanhoMochila) {
			formiga.listaObjetos[formiga.posicao-1] = null;
			formiga.posicao = formiga.posicao-1;
			formiga.quantMochila = 0;
			formiga.valorMochila = 0;
			for(int j =0;j < formiga.posicao;j++) {		
				formiga.quantMochila = formiga.quantMochila + formiga.listaObjetos[j].peso;
				formiga.valorMochila = formiga.valorMochila + formiga.listaObjetos[j].valor;
			}
			return formiga;
			
		}
		
		
		}
		return formiga;
	}

	

	public Objeto[][] addFeromonio(Objeto[][] matrisObjetos, Formiga[] formigas, Objeto[] dados) {
		
		for(int i = 0;i < formigas.length;i++){
			Formiga formiga = formigas[i];
			for(int o=0;o < formiga.listaObjetos.length;o++) {
				for(int k =0;k < 10;k++) {
					for(int j =0;j < 10;j++) {
						if(matrisObjetos[k][j].peso == formiga.listaObjetos[i].peso && matrisObjetos[k][j].valor == formiga.listaObjetos[i].valor) {
							for(int n = 0;n < dados.length;n++){
								if(dados[n].peso == formiga.listaObjetos[i].peso && dados[n].valor == formiga.listaObjetos[i].valor) {
									dados[n].ferormonio += formiga.listaObjetos[i].ferormonio;
								}
							}
						}
					}}
			}
		}
		
		return matrisObjetos;
	}

	
	
	
	
}

