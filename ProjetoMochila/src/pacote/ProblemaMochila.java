package pacote;


 
 
 
import java.util.LinkedList; 
 
import java.util.List; 
 
 
 
public class ProblemaMochila { 
 
 
 
    public static void main(String[] args) { 
 
        int peso = 25; 
 
        List<Objeto> listaObjetos= new LinkedList<Objeto>(); 
 
        listaObjetos.add(new Objeto(5,3)); 
 
        listaObjetos.add(new Objeto(4,3)); 
 
        listaObjetos.add(new Objeto(7,2)); 
 
        listaObjetos.add(new Objeto(8,4)); 
 
        listaObjetos.add(new Objeto(4,2));
        
        listaObjetos.add(new Objeto(4,3));

        listaObjetos.add(new Objeto(5,6));
        
        listaObjetos.add(new Objeto(8,2));
        
        listaObjetos.add(new Objeto(3,1));
        
        listaObjetos.add(new Objeto(1,-10));
        
        
        Mochila mochila = new Mochila(listaObjetos, peso); 
 
        System.out.println(mochila.toString()); 
 
        List<Objeto> solucion = mochila.resolver(); 
 
        System.out.println("Solu�ao: " + solucion.toString()); 
 
    } 
 
} 
 
