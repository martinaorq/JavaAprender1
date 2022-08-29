/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Programaciongenerica;

/**
 *
 * @author marti
 */
public class Metodosgenericos {
    public static void main (String []args){
        
        String []nombre={"José", "María", "Pepe","Ana"};
        System.out.println(MisMatrices.buscamenor(nombre));
    }
}
class MisMatrices <T>{
    //Este método nos va a devolver un String que nos dirá la longitud de un array de cualquier tipo
    /*public static <T> String metodo(T []a){
         return "El array tiene "+a.length+ " elementos"; 
    }*/
    
     //Este otro devuelve el valo menor de un array       
    
    public static <T extends Comparable> T buscamenor(T []a){
        T elementomenor=a[0];
        
            if (a==null || a.length==0){
                return (T) "Has introducido mal el array.";}
        
                
            for (int i=1;i<a.length;i++){
                //Voy a tratar de explicar el código, está un poco chingón..
                if (elementomenor.compareTo(a[i])>0){
                    /*Para arreglar el error en compare to nos tenemos que fijar en el metodo compare to, 
                    esto ocurre porque el metodo viene de la interfaz comparable, por lo tanto
                    cada objeto que utilice este elemento tiene que implementar la interfaz comparable
                    como se indica?
                                    en la definicion del metodo, cuando ponemos que el metodo tiene
                                   que manejar datos de tipo generico, ponemos extends Comparable.
                    Tiene sentido porque todos los objectos que utilicemos van a tener la interfa comparable*/
                    
                    /*En la variable T, que es el primer elemento, en este método se lo
                    compara con aquel elemneto que esté en la posición i, por eso no ponemos
                    en el FOR que i es igual a 0, porque estaríamos comparando un elemento 
                    con el mismo,
                    osea que cuando el codigo entra en el codigo estamos comparando a0 con a1
                    si hay dudas, ver video numero 166*/
                    
                    elementomenor=a[i];
                }
            
            }
            return elementomenor;
    }
    
    
}


