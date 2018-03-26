package pacote;


 
 
import java.util.Scanner; 
 
 
 
public class ProblemaMochila { 
 
 
 
    public static void main(String[] args) { 
 
        int peso = 25; 
        Mochila[] listaMochilas = new Mochila[10];
        Objeto[] listaObjetos = new Objeto[10]; 
 
        listaObjetos[0] = new Objeto(5,3,"0001"); 
 
        listaObjetos[1] = (new Objeto(4,3,"0010")); 
 
        listaObjetos[2] = (new Objeto(7,2,"0011")); 
 
        listaObjetos[3] = (new Objeto(3,4,"0100")); 
 
        listaObjetos[4] = (new Objeto(4,2,"0101"));
        
        listaObjetos[5] = (new Objeto(4,3,"0110"));

        listaObjetos[6] = (new Objeto(5,6,"0111"));
        
        listaObjetos[7] = (new Objeto(4,2,"1000"));
        listaObjetos[8] = (new Objeto(0,0,"0000"));
        
       Mochila mochila = new Mochila(listaObjetos, 45, 45);
       Mochila[] mochilas = new Mochila[20];
        Scanner s = new Scanner(System.in);
        for(int i =0; i < 20;i++) {
        	Mochila[] criacao = mochila.novaMochilas();
        	mochilas[i] = criacao[0];
        	i++;
        	mochilas[i] = criacao[1];
        
        }
        //Qualidade qualidade = new Qualidade();
        //Mochila[] filhos= qualidade.geralFilhos(listaMochilas);
        boolean condicao = true ;
        while(condicao){
        int idade = s.nextInt();
        for(int i =0; i < 20;i++) {
        	for(int y=0;y < 8;y++)
        	System.out.println(mochilas[i].listaObjetos[y].toString());
        	// debogar  novamochila algo esta errado
        }
     
        }
        
 
    } 
 
} 
 
