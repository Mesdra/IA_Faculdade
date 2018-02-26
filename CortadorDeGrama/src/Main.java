import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Terreno terreno = new Terreno();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		terreno.atualizaTela();
		int cond = -1;
		int linha;
		int coluna;
		String sit;
		while(cond != 0) {
			System.out.printf("\n\nf para Adicionar Formigueiro/ g para Grama\n");
			sit = sc.next();
			if(sit  == "s")
				cond =0;
			linha = sc.nextInt();
			coluna = sc.nextInt();
			
			char situacao = sit.charAt(0);
			terreno.atualizaTerreno(--linha, --coluna, situacao);
			terreno.atualizaTela();
		}
	}

}
