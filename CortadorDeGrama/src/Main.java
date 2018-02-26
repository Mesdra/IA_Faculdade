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
			if(sit.charAt(0)  == 's') {
				cond = 0;
				break;
			}
			linha = sc.nextInt();
			coluna = sc.nextInt();
			
			char situacao = sit.charAt(0);
			terreno.atualizaTerreno(--linha, --coluna, situacao);
			terreno.atualizaTela();
		}
		cond = 1;
		if(terreno.pegaPosicao(0, 0) == '#' )
			terreno.gravaPosicao(0, 0, 'O');
		terreno.atualizaTela();
		int lin = 0;
		int col = 0;
		int condSb = 1;
		while(cond  != 0) {
			sc.next();
			if(lin == 0 && col != 0)
			  condSb  = 1;
			  col = col+1;
			if(lin == 4)
			  condSb = 2;
			  col = col+1;
			if(condSb ==1) {
			  terreno.descendo(lin, col, terreno);
			  }else {terreno.subindo(lin, col, terreno);}
			
			terreno.atualizaTela();
		}
		
		
	}

}
