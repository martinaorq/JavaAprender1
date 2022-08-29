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
public class UsoParejas {
    public static void main(String []args){
        
        Parejas <String> instancia= new Parejas<String>();
        
        instancia.setprimero("Pedro");
        System.out.println(instancia.getprimero());
        
        personita per1=new personita("Pepe");
        
        Parejas <personita> per2=new Parejas<personita>();
        
        per2.setprimero(per1);
        
        System.out.println(per2.getprimero());
        
        
    }
}
class personita{
    public personita(String nombre){
        this.nombre=nombre;
        
        
        
    }
    public String toString(){
        return this.nombre;
    }
    private String nombre;
}