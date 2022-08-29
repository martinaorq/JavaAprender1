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
public class Parejas <T> {
    private T primero;
    
    public Parejas(){
        primero=null;
    }
    
    public void setprimero(T nuevovalor){
        primero=nuevovalor;
    }
    
    public T getprimero(){
        return primero;
    }
}
