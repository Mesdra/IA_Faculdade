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
		
		int condSb = 1;
		while(cond  != 0) {
			sc.next();
			if(terreno.getLin() == 0 && terreno.getCol() != 0) {
			terreno.atualizaTerreno(terreno.getLin(), terreno.getCol(),'#');
			  condSb  = 1;
			  terreno .setCol(terreno.getCol()+1); 
			}
			if(terreno.getLin() == 4)
			{
			  terreno.atualizaTerreno(terreno.getLin(), terreno.getCol(),'#');
			  condSb = 2;
			  terreno .setCol(terreno.getCol()+1); 
			}
			if(condSb ==1) {
			  terreno.descendo(terreno);
			  }else {terreno.subindo(terreno);}
			
			terreno.atualizaTela();
		}
		
		
	}

}
