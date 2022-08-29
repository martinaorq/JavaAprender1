/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets;

import java.awt.BorderLayout;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/**
 *
 * @author marti
 */
public class Servidor {
    
public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoServidor mimarco=new MarcoServidor();
                
		
                
	}	
}

class MarcoServidor extends JFrame implements Runnable{
    	
	private	JTextArea areatexto;
	
	public MarcoServidor(){
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
		setBounds(200,300,280,350);				
			
		JPanel milamina= new JPanel();
		
		milamina.setLayout(new BorderLayout());
		
		areatexto=new JTextArea();
		
		milamina.add(areatexto,BorderLayout.CENTER);
		
		add(milamina);
		
		setVisible(true);
		
                
                Thread t=new Thread(this);
                t.start();
                
                
		}


    
private paquete p;
//lo nuevo
private Socket conexion,conexion2;//Fijarme en el socket de la otra clase creo que eso esta mal xdxd
private ServerSocket servidor;
private ObjectOutputStream salida;
private ObjectInputStream entrada;
private String ip,nick,mensaje;

private void ejecutarservidor(){
            try {
                sperarconexion();
                iniciarflujos();
                manejarconexion();//Falta agregar do while o while true
            } catch (IOException ex) {
                Logger.getLogger(MarcoServidor.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                cerrarconexion();
            }
}
private void cerrarconexion(){
            try {
                salida.close();
                entrada.close();
                conexion.close();
            } catch (IOException ex) {
                mostrartexto("Error al cerrar la conexión.");
            }
    
}
private void sperarconexion() throws IOException{
    servidor=new ServerSocket(9999,100);
    mostrartexto("Esperando conexión...");
    conexion=servidor.accept();
    conexion2=new Socket("192.168.1.9",9090);
    mostrartexto("Conexión recibida de: "+conexion.getInetAddress().getHostName() );
    
}
private void iniciarflujos() throws IOException{
    mostrartexto("Iniciando flujos...");
    entrada= new ObjectInputStream(conexion.getInputStream());
    
    salida=new ObjectOutputStream(conexion2.getOutputStream());
    salida.flush();
    mostrartexto("Se iniciaron los flujos.");
}
private void mostrartexto(final String g){
    SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            areatexto.append(g+"\n");
        }
    });
}
private void manejarconexion() throws IOException{
            do{
            try {
                p=(paquete) entrada.readObject();
                nick=p.getNick();
                ip=p.getIp();
                mensaje=p.getMensaje();
                mostrartexto(nick+">>> "+mensaje);
            } catch (ClassNotFoundException ex) {
                mostrartexto("No se encontró el mensaje.");
            }
        }while(!mensaje.equals("TERMINAR"));      
}
public void enviardatos(paquete e){//Quizás haya algo mal aquí
            try {
                salida.writeObject(p);
            } catch (IOException ex) {
               mostrartexto("Error al enviar datos.");
            }
}

    public void run() {
        ejecutarservidor();
    }


}





