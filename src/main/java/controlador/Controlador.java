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
        
        int n = StackOverflow.usuarios.getTamano();
        for (int i = 0; i < n; i++) {
            String nombreUsuario = StackOverflow.usuarios.getUsuarioN(i).getNombreUsuario() ;
            view.listaRegistrados.addElement(nombreUsuario);
        }
        
    }
    
    //FUNCION PARA INICIAR SEGUNDA VENTANA.
    public void ventanaLogeado(String nombre, int reputacion){
        vistaLogeado = new VistaLogeado();
        int n = StackOverflow.preguntas.getTamano();	
        String matriz [][]= new String [n][8]; 

		for (int i = 0; i < n; i++) {
			matriz [i][0] = String.valueOf(StackOverflow.preguntas.getPreguntaN(i).getIdPregunta()) ;
            matriz [i][1] = StackOverflow.preguntas.getPreguntaN(i).getTituloPregunta() ;
            matriz [i][2] = StackOverflow.preguntas.getPreguntaN(i).getContenidoPregunta() ;
            matriz [i][3] = StackOverflow.preguntas.getPreguntaN(i).getFechaPublicacion() ;
            matriz [i][4] = StackOverflow.preguntas.getPreguntaN(i).getAutorPregunta();
            matriz [i][5] = String.valueOf(StackOverflow.preguntas.getPreguntaN(i).getRecompensa());
            matriz [i][6] = StackOverflow.preguntas.getPreguntaN(i).autorRecompensa;
            matriz [i][7] = String.valueOf(StackOverflow.preguntas.getPreguntaN(i).estado);
		}
        vistaLogeado.TablaPreguntas.setModel(new javax.swing.table.DefaultTableModel(
        matriz, new String [] {
        "ID", "Titulo", "Contenido", "FechaPublicacion", "Autor", "Recompensa", "AutorRecompesa", "Estado"
        }));

        vistaLogeado.setTitle("Simulacion de StackOverflow por Dyllan Salgado");
        vistaLogeado.setLocationRelativeTo(null);
        vistaLogeado.InputUsuario.setText(nombre);
        vistaLogeado.InputReputacion.setText(String.valueOf(reputacion));
        vistaLogeado.BtnCerrarSesion.addActionListener(this);
        vistaLogeado.setVisible(true);

    }
            
    @Override
    public void actionPerformed(ActionEvent e) {
        //VENTANA INICIAL.

        //Apretando boton registrar.
        if (e.getSource()==view.BotonRegistrar){
            //Si falta rellenar el nombre o pass entrega el mensaje que debe rellenar todo.
            if(view.InputNameUser.getText().equals("") || String.valueOf(view.InputPassUser.getPassword()).equals("") ){
                view.statusLabel.setText("Rellenar nombre y contrasena");    
            }
            //Si el nombre de usuario a registrar ya se encuentra entrega el mensaje que ya esta registrado.
            else if (StackOverflow.registrarUsuario(view.InputNameUser.getText(),String.valueOf(view.InputPassUser.getPassword())) == false){
                view.statusLabel.setText("Usuario ya se encuentra registrado");
            }
            //Si el nombre se encuentra disponible y rellena la pass, se muestra mensaje que se ha registrado con exito.
            else{
                this.StackOverflow.registrarUsuario(view.InputNameUser.getText(),String.valueOf(view.InputPassUser.getPassword()));
                view.statusLabel.setText("USUARIO REGISTRADO CON EXITO");
                view.InputNameUser.setText("");
                view.InputPassUser.setText("");
                int n = StackOverflow.usuarios.getTamano() -1;
                String nombreUsuario = StackOverflow.usuarios.getUsuarioN(n).getNombreUsuario() ;
                view.listaRegistrados.addElement(nombreUsuario);
            }
        }

        //Aprentando boton logear.
        else if(e.getSource()== view.BotonLogearse){
            //X obtiene los valores del login, 1 esta todo correcto, 2 la clave no es correcta, 3 usuario no es correcto.
            int x = StackOverflow.login(view.InputNameUser.getText(), String.valueOf(view.InputPassUser.getPassword()));
            //Cuando el nombre de usuario y clave corresponden a un usuario se abre la nueva ventana.
            if(1 ==x){
                view.setVisible(false);
                String nombreUsuario = StackOverflow.usuarios.getUsuarioName(view.InputNameUser.getText()).getNombreUsuario();
                int reputacion =  StackOverflow.usuarios.getUsuarioName(view.InputNameUser.getText()).getReputacionUsuario();
                ventanaLogeado(nombreUsuario,reputacion);

            }
            //x  =2
            else if(x == 2){
                view.statusLabel.setText("contrasena incorrecta");
            } 
            //x = 3  
            else{
                 view.statusLabel.setText("el usuario no es correcto");
            }
        }
        

        //VENTANA LOGEADO.
        else if(e.getSource()== vistaLogeado.BtnCerrarSesion ){
            StackOverflow.logout();
            view.InputNameUser.setText("");
            view.InputPassUser.setText("");
            view.statusLabel.setText("Esperando una accion...");
            vistaLogeado.setVisible(false);
            view.setVisible(true);
        }
    }  
}


