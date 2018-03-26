package pacote;


 
 
 

import java.util.LinkedList; 
 
import java.util.List; 
 
 
 
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
        
        Objeto[] lista1 = new Objeto[8]; ;
        Objeto[] lista2 = new Objeto[8];;
        
        lista1[0]= (listaObjetos[0]);
        lista1[1]= (listaObjetos[5]);
        lista1[2]= (listaObjetos[8]);
        lista1[3]= (listaObjetos[3]);
        lista1[4]= (listaObjetos[8]);
        lista1[5]= (listaObjetos[2]);
        lista1[6]= (listaObjetos[8]);
        lista1[7]= (listaObjetos[8]);
        int valor = 0;
        for (int i = 0; i < lista1.length; i++) {
        	valor = valor + lista1[i].valor;
		}
        System.out.println("valor anterior = " + valor);
        Mochila mochila = new Mochila(lista1, peso, valor); 
        listaMochilas[0] = (mochila);
       
        peso = 30;
        lista2[0]= (listaObjetos[4]);
        lista2[1]= (listaObjetos[2]);
        lista2[2]= (listaObjetos[8]);
        lista2[3]= (listaObjetos[6]);
        lista2[4]= (listaObjetos[7]);
        lista2[5]= (listaObjetos[8]);
        lista2[6]= (listaObjetos[1]);
        lista2[7]= (listaObjetos[8]);
        valor = 0;
        for (int i = 0; i < lista1.length; i++) {
        	valor = valor + lista1[i].valor;
		}
        System.out.println("valor anterior2 = " + valor);
        mochila = new Mochila(lista2, peso, valor); 
        listaMochilas[1] = mochila;
        
        Qualidade  qualidade = new Qualidade();
        Mochila[] filhos= qualidade.geralFilhos(listaMochilas);
        
        System.out.println(filhos[0].toString());
        System.out.println(filhos[1].toString());
 
        
 
    } 
 
} 
 
