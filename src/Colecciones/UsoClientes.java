/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Colecciones;

import java.util.*;
import java.util.Set;

/**
 *
 * @author marti
 */
//Clase encargada de formar colecciones
public class UsoClientes {

    public static void main(String[] args) {

        clientes c1 = new clientes("Pedro perez", "00001", 200000);
        clientes c2 = new clientes("Juana Nahir", "00002", 140000);
        clientes c3 = new clientes("Rosa melano", "00003", 700000);
        clientes c4 = new clientes("Armando Esteban Quito", "00004", 90000);
        clientes c5 = new clientes("Pedro perez", "00001", 200000);

        //Vamos a crear una colección
        Set<clientes> clientesbanco = new HashSet<clientes>();

        clientesbanco.add(c1);
        clientesbanco.add(c2);
        clientesbanco.add(c3);
        clientesbanco.add(c4);
        clientesbanco.add(c5);
         if (c5.equals(c1)){
             System.out.println("Son iwales");
         }else{
             System.out.println("No son iwales :(");
         }
        for (clientes clientes : clientesbanco) {
            System.out.println(clientes.getNombre() + " " + clientes.getNumerodecuenta() + " " + clientes.getSaldo());
        }

    }
}
