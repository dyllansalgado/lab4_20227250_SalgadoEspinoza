/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import lab4_20227250_SalgadoEspinoza_modelo.stack;
import vista.Vista;
import vista.VistaLogeado;

/**
 *
 * @author dyllan
 */
public class Controlador implements ActionListener{
    private Vista view; 
    private stack StackOverflow;
    private VistaLogeado vistaLogeado;
   
    
    public Controlador(){
    }
    
    public Controlador(Vista view, stack StackOverflow){
        this.view = view;
        this.StackOverflow = StackOverflow;
    }
    //FUNCION PARA INICIAR LA PRIMERA VENTANA.
    public void iniciar(){
        view.setTitle("Simulacion de StackOverflow por Dyllan Salgado");
        view.setLocationRelativeTo(null);
        view.BotonRegistrar.addActionListener(this);
        view.BotonLogearse.addActionListener(this);
        view.setVisible(true);
    }
    
    //FUNCION PARA INICIAR SEGUNDA VENTANA.
    public void ventanaLogeado(){
        vistaLogeado = new VistaLogeado();
        vistaLogeado.setTitle("Simulacion de StackOverflow por Dyllan Salgado");
        vistaLogeado.setLocationRelativeTo(null);
        vistaLogeado.setVisible(true);
    }
            
    @Override
    public void actionPerformed(ActionEvent e) {
        //VENTANA INICIAL.
        //Apretando boton registrar.
        if (e.getSource()==view.BotonRegistrar){
            if(view.InputNameUser.getText().equals("") || String.valueOf(view.InputPassUser.getPassword()).equals("") ){
                view.statusLabel.setText("Rellenar nombre y contraseña");    
            }
            else{
                this.StackOverflow.registrarUsuario(view.InputNameUser.getText(),String.valueOf(view.InputPassUser.getPassword()));
                view.statusLabel.setText("USUARIO REGISTRADO CON EXITO");
                view.InputNameUser.setText("");
                view.InputPassUser.setText("");
            }
        }
        //Aprentando boton logear.
        if(e.getSource()== view.BotonLogearse){
            if(this.StackOverflow.login(view.InputNameUser.getText(), String.valueOf(view.InputPassUser.getPassword()))){
                view.setVisible(false);
                ventanaLogeado();
            }
            else{
                view.statusLabel.setText("USUARIO INCORRECTO");
            }   
        }
    }  
}


