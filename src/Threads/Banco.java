/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marti
 */
public class Banco {
    
    public static void main (String[]args){
        ejecuciontransferencias r=new ejecuciontransferencias(1,2,500);
        Thread t=new Thread(r);
        t.start();
        
    }
}





class creobanco {
    private final double[] cuentas;
    
    public creobanco(){
        cuentas=new double[100];    
        
        for(int i=0;i<cuentas.length;i++){
            cuentas [i]=2000;
            
        }
     }
    
    
    public void transferencia(int cuentaorigen,int cuentadestino, double transferencia){
        
        if (transferencia> cuentas[cuentaorigen]){
            //Evaluamos si el usuario tiene suficiente dinero como para realizar la transferencia.
            System.out.println("No tienes suficiente dinero :(.");
        }
        
        System.out.println(Thread.currentThread());//Imprimimos el thread que se hará cargo de esta acción
        
        cuentas[cuentaorigen] -=transferencia;//Quitamos el dinero que va a ser transferido a la otra cuenta
        cuentas[cuentadestino] +=transferencia;//Agregamos el dinero que está siendo transferido
        
        System.out.printf("$%10.2f de la cuenta n°%d, para la cuenta n°%d",transferencia,cuentaorigen,cuentadestino);
        System.out.printf(" ,Saldo total: %10.2f",getSaldoTotal());
    }
    
    public double getSaldo(int numerodecuenta){
        return cuentas[numerodecuenta];
    }
    
    public double getSaldoTotal(){
        double e=0;
        
        for(double i:cuentas){
            e += i;
        }
        return e;
    }
}
class ejecuciontransferencias implements Runnable{
    
    public ejecuciontransferencias(int o,int d,double t){//Pasamos por parametros estos datos para que al llamar la clase podamos elegir los datos
        this.t=t;//Transferencia
        this.d=d;//Destino 
        this.o=o;//Origen
    }
    
    public void run() {
        
        while(true){
        creobanco c=new creobanco();
        
        c.transferencia(o, d, t);//Pasamos origen ,destino, transferencia.
            try {
                Thread.sleep(400);
            } catch (InterruptedException ex) {
                Logger.getLogger(ejecuciontransferencias.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    private int o,d;
    private double t;
    
}
