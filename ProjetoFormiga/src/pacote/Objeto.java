package pacote;

public class Objeto {
	float ferormonio;
	int peso;
	int valor;
	public Objeto(int peso,int valor) {
		this.peso = peso;
		this.valor = valor;
	}
	@Override
	public String toString() {
		return "F" + ferormonio + "/P" + peso + "/ V" + valor;
	}
	
	
	
}
