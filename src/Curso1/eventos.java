/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Curso1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author marti
 */
public class eventos {
    public static void main (String []args){
        marco m=new marco();
        
    }
}
class marco extends JFrame{
    public marco(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setBounds(200,200,500,200);
        setTitle("Eventos versión 1");
        
        lamina lamina=new lamina();
        add(lamina);
        
    }
}
class lamina extends JPanel{
    JButton boton;
    JTextField contrasena; 
    JTextField usuario;    
    JLabel resultadodecontrasena,usuariolabel, contralabel;
    JPanel panelcajasdetexto;
    
    
    public lamina(){
        
        //Declaramos variables y las agregamos a la lamina__________________________________
        setBackground(Color.lightGray);
        setLayout(new BorderLayout());
        
        usuariolabel=new JLabel("Usuario:");
        contralabel=new JLabel("Contraseña:");
        panelcajasdetexto=new JPanel();
        boton=new JButton("Aceptar");
        contrasena=new JTextField(10);
        usuario=new JTextField(10);
        resultadodecontrasena= new JLabel();
        
        panelcajasdetexto.add(usuariolabel);
        panelcajasdetexto.add(usuario);
        panelcajasdetexto.add(contralabel);
        panelcajasdetexto.add(contrasena);
        
        add(panelcajasdetexto, BorderLayout.NORTH);
        add(boton, BorderLayout.CENTER);
        add(resultadodecontrasena, BorderLayout.SOUTH);
        
        //Agrgamos ActionListener a objetos.
        contrasena.addActionListener(new manejaeventos());
        boton.addActionListener(new manejaeventos());
        usuario.addActionListener(new manejaeventos());
        
        
        
        
        
    }
    /*Clase que maneja eventos.
    Implementa ActionListener
    */
    private class manejaeventos implements ActionListener{

        
        public void actionPerformed(ActionEvent e) {
            
            if (e.getSource()==boton){
                resultadodecontrasena.setText("2");
                
                
                
                if (usuario.getText().equals("FillingMussel28")&& contrasena.getText().equals("martina23") ){
                    resultadodecontrasena.setText("Ah c mamo.");
                    System.out.println("K wen easter egg");
                }
            }
            
        }
       }
    
    
    
    
    
    
    
    
    
    /* Se puede tener más de un event handler*/
    private class manejaeventos2 implements ActionListener{
    public void actionPerformed(ActionEvent e) {}
    }
        
    
}

