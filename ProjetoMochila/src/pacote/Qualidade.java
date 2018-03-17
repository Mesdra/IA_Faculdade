package pacote;

public class Qualidade {
	int qualidade;
	Objeto objeto;
	
	public Qualidade(){
		qualidade =0;
		objeto = new Objeto();
	}
	public Qualidade(int q,Objeto o){
		qualidade =q;
		objeto = o;
	}
}
