/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Colecciones;

import java.util.Objects;

/**
 *
 * @author marti
 *
 * */
//Clase encargada de construir nuestros clientes
public class clientes {
    public clientes(String nombre,String numcuenta,double saldo){
        this.nombre=nombre;
        this.numerodecuenta=numcuenta;
        this.saldo=saldo;
    }
   /* public boolean equals(Object obj){
        if(obj instanceof clientes){
            clientes c=(clientes)obj;
            
            if (Integer.parseInt(this.numerodecuenta)==Integer.parseInt(c.numerodecuenta)){
                return true;
            }else{
            return false;
        }
       }else{
            return false;
        }
        
    }*/

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.numerodecuenta);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final clientes other = (clientes) obj;
        if (!Objects.equals(this.numerodecuenta, other.numerodecuenta)) {
            return false;
        }
        return true;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumerodecuenta() {
        return numerodecuenta;
    }

    public void setNumerodecuenta(String numerodecuenta) {
        this.numerodecuenta = numerodecuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    
    
    private String nombre,numerodecuenta;
    private double saldo;
}
