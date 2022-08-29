/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets;

import java.io.Serializable;

/**
 *
 * @author marti
 */
public class paquete implements Serializable{
    
    public paquete(String nick,String mensaje,String ip){
        this.mensaje=mensaje;
        this.ip=ip;
        this.nick=nick;
    }
    
    private String nick,mensaje,ip;

    public String getNick() {
        return nick;
    }


    public String getMensaje() {
        return mensaje;
    }

    public String getIp() {
        return ip;
    }

}

