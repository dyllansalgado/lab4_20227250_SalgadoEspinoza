/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import lab4_20227250_SalgadoEspinoza_modelo.stack;
import lab4_20227250_SalgadoEspinoza_modelo.pregunta;
import vista.Vista;
import vista.VistaAccept;
import vista.VistaEtiquetas;
import vista.VistaLogeado;
import vista.VistaPregunta;
import vista.VistaRespuesta;
import vista.VistaReward;
import vista.VistaVentanaPreguntas;

/**
 *
 * @author dyllan
 */
public class Controlador implements ActionListener{
    private Vista view; 
    private stack StackOverflow;
    private VistaLogeado vistaLogeado;
    private VistaAccept vistaAccept;
    private VistaEtiquetas vistaEtiquetas;
    private VistaPregunta vistaPregunta;
    private int activate = 0;
    private int activa =0;
    private VistaRespuesta vistaRespuesta;
    private VistaReward vistaReward;
    private VistaVentanaPreguntas vistaVentanaPreguntas;
    
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
    
    //FUNCION PARA INICIAR VENTANA LOGEADO.
    public void ventanaLogeado(String nombre, int reputacion){
        vistaLogeado = new VistaLogeado();
        int n = StackOverflow.preguntas.getTamano();	
        String matriz [][]= new String [n][9]; 
	for (int i = 0; i < n; i++) {
            matriz [i][0] = String.valueOf(StackOverflow.preguntas.getPreguntaN(i).getIdPregunta()) ;
            matriz [i][1] = StackOverflow.preguntas.getPreguntaN(i).getTituloPregunta() ;
            matriz [i][2] = StackOverflow.preguntas.getPreguntaN(i).getContenidoPregunta() ;
            matriz [i][3] = StackOverflow.preguntas.getPreguntaN(i).etiquetas.etiquetas2String3();
            matriz [i][4] = StackOverflow.preguntas.getPreguntaN(i).getFechaPublicacion() ;
            matriz [i][5] = StackOverflow.preguntas.getPreguntaN(i).getAutorPregunta();
            matriz [i][6] = String.valueOf(StackOverflow.preguntas.getPreguntaN(i).getRecompensa());
            matriz [i][7] = StackOverflow.preguntas.getPreguntaN(i).autorRecompensa;
            matriz [i][8] = String.valueOf(StackOverflow.preguntas.getPreguntaN(i).estado);
	}
        vistaLogeado.TablaPreguntas.setModel(new javax.swing.table.DefaultTableModel(
        matriz, new String [] {
        "ID", "Titulo", "Contenido", "Etiquetas" ,"FechaPublicacion", "Autor", "Recompensa", "AutorRecompesa", "Estado"
        }));

        vistaLogeado.setTitle("Simulacion de StackOverflow por Dyllan Salgado");
        vistaLogeado.setLocationRelativeTo(null);
        vistaLogeado.InputUsuario.setText(nombre);
        vistaLogeado.InputReputacion.setText(String.valueOf(reputacion));
        vistaLogeado.BtnCerrarSesion.addActionListener(this);
        vistaLogeado.BotonPregunta.addActionListener(this);
        vistaLogeado.BotonAceptarRespuesta.addActionListener(this);
        vistaLogeado.BotonRecompensa.addActionListener(this);
        vistaLogeado.BotonCrearEtiquetas.addActionListener(this);
        vistaLogeado.BotonVerPregunta.addActionListener(this);
        vistaLogeado.setVisible(true);

    }
    //FUNCION PARA INICIAR VENTANA PREGUNTA.
    public void ventanaPregunta(pregunta miPregunta, int id){
        vistaVentanaPreguntas = new VistaVentanaPreguntas();
        vistaVentanaPreguntas.NameUser.setText(StackOverflow.ActivoUsuario.getNombreUsuario());
        vistaVentanaPreguntas.ReputacionUser.setText(String.valueOf(StackOverflow.ActivoUsuario.getReputacionUsuario()));
        vistaVentanaPreguntas.id  =id;
        vistaVentanaPreguntas.VerPregunta.setText(miPregunta.pregunta2String());
        vistaVentanaPreguntas.BotonRespuesta.addActionListener(this);
        vistaVentanaPreguntas.BotonVolver.addActionListener(this);    
        vistaVentanaPreguntas.VerPregunta.setEditable(false); 
        vistaVentanaPreguntas.VerPregunta.setLineWrap(true);   
        vistaVentanaPreguntas.setVisible(true);
    }
    
    //FUNCION PARA INICIAR VENTANA CREAR ETIQUETAS.
    public void ventanaEtiquetas(){
        vistaEtiquetas = new VistaEtiquetas();
        vistaEtiquetas.NombreUsuario.setText(StackOverflow.ActivoUsuario.getNombreUsuario());
        vistaEtiquetas.ReputacionUsuario.setText(String.valueOf(StackOverflow.ActivoUsuario.getReputacionUsuario()));
        vistaEtiquetas.BotonAgregarEtiqueta.addActionListener(this);
        vistaEtiquetas.BotonCerrarSesion.addActionListener(this);
        vistaEtiquetas.BotonVolver.addActionListener(this);
        vistaEtiquetas.EtiquetasYDescripcion.setText(StackOverflow.etiquetas.etiquetas2String2());
        vistaEtiquetas.setVisible(true);
    }
    
    //FUNCION PARA INICIAR VENTANA REALIZAR PREGUNTA.
    public void ventanaRealizarPregunta(){
        vistaPregunta = new VistaPregunta();
        String[] options = StackOverflow.etiquetas.etiquetas2Array();
        for (int i = 0; i < options.length; i++) {
            vistaPregunta.InputEtiqueta.addItem(options[i]);
        }
        
        int n = StackOverflow.preguntas.getTamano();	
        String matriz [][]= new String [n][9]; 
	for (int i = 0; i < n; i++) {
            matriz [i][0] = String.valueOf(StackOverflow.preguntas.getPreguntaN(i).getIdPregunta()) ;
            matriz [i][1] = StackOverflow.preguntas.getPreguntaN(i).getTituloPregunta() ;
            matriz [i][2] = StackOverflow.preguntas.getPreguntaN(i).getContenidoPregunta() ;
            matriz [i][3] = StackOverflow.preguntas.getPreguntaN(i).etiquetas.etiquetas2String3();
            matriz [i][4] = StackOverflow.preguntas.getPreguntaN(i).getFechaPublicacion() ;
            matriz [i][5] = StackOverflow.preguntas.getPreguntaN(i).getAutorPregunta();
            matriz [i][6] = String.valueOf(StackOverflow.preguntas.getPreguntaN(i).getRecompensa());
            matriz [i][7] = StackOverflow.preguntas.getPreguntaN(i).autorRecompensa;
            matriz [i][8] = String.valueOf(StackOverflow.preguntas.getPreguntaN(i).estado);
	}
        vistaPregunta.TablaConPreguntas.setModel(new javax.swing.table.DefaultTableModel(
        matriz, new String [] {
        "ID", "Titulo", "Contenido", "Etiquetas" ,"FechaPublicacion", "Autor", "Recompensa", "AutorRecompesa", "Estado"
        }));
        vistaPregunta.setLocationRelativeTo(null);
        vistaPregunta.InputUsuario.setText(StackOverflow.ActivoUsuario.getNombreUsuario());
        vistaPregunta.InputReputacion.setText(String.valueOf(StackOverflow.ActivoUsuario.getReputacionUsuario()));
        vistaPregunta.BotonCerrarSesion.addActionListener(this);
        vistaPregunta.BotonVolverMenu.addActionListener(this);
        vistaPregunta.BotonPublicarPregunta.addActionListener(this);
        vistaPregunta.setVisible(true);
       
    
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
        //SELECCIONA BOTON DE VER PREGUNTA.
        else if(e.getSource()== vistaLogeado.BotonVerPregunta){
            
            String[] options = StackOverflow.preguntas.preguntas2Array();
            String salida = (String)JOptionPane.showInputDialog(null, "Las preguntas son las siguientes", 
                    "Elige una pregunta para visualizarlas", JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
            
            if (salida != null && !salida.equals(null)) {   
                int i = 0;
                while (i<StackOverflow.preguntas.getTamano()) {
                    if (salida.equals(options[i])) {
                        break;
                    }
                    i++;
                }
                pregunta miPregunta =  StackOverflow.preguntas.getPreguntaN(i);
                ventanaPregunta(miPregunta,i);
            }    
        }
        //SELECCIONA EL BOTON DE CERRAR SESION EN VISTALOGEADO.
        else if(e.getSource()== vistaLogeado.BtnCerrarSesion ){
            StackOverflow.logout();
            view.InputNameUser.setText("");
            view.InputPassUser.setText("");
            view.statusLabel.setText("Esperando una accion...");
            vistaLogeado.setVisible(false);
            view.setVisible(true);
        }

        //SELECCIONA BOTON DE REALIZAR PREGUNTA.
        else if(e.getSource()== vistaLogeado.BotonPregunta){
            ventanaRealizarPregunta();
            this.activate = 1 ;
        }
        else if(activate == 1 && e.getSource()== vistaPregunta.BotonPublicarPregunta){
            String titulo =vistaPregunta.InputTituloPregunta.getText();
            String contenido = vistaPregunta.InputContenidoPregunta.getText();
            String autor = StackOverflow.ActivoUsuario.getNombreUsuario();
            String etiqueta = vistaPregunta.InputEtiqueta.getName();
            int index = (int) vistaPregunta.InputEtiqueta.getSelectedIndex();
            System.out.println(index);
            int reputacion = Integer.parseInt(vistaPregunta.InputRecompensa.getText());
            System.out.println(StackOverflow.etiquetas.getEtiquetaN(index));
            if (index != -1) {                   
                StackOverflow.ask(titulo, contenido, autor, StackOverflow.etiquetas.getEtiquetaN(index), reputacion);
                JOptionPane.showMessageDialog (null, "Pregunta insertada", "Succes", JOptionPane.INFORMATION_MESSAGE);
                int n = StackOverflow.preguntas.getTamano();	
                String matriz [][]= new String [n][9]; 
                for (int i = 0; i < n; i++) {
                    matriz [i][0] = String.valueOf(StackOverflow.preguntas.getPreguntaN(i).getIdPregunta()) ;
                    matriz [i][1] = StackOverflow.preguntas.getPreguntaN(i).getTituloPregunta() ;
                    matriz [i][2] = StackOverflow.preguntas.getPreguntaN(i).getContenidoPregunta() ;
                    matriz [i][3] = StackOverflow.preguntas.getPreguntaN(i).etiquetas.etiquetas2String3();
                    matriz [i][4] = StackOverflow.preguntas.getPreguntaN(i).getFechaPublicacion() ;
                    matriz [i][5] = StackOverflow.preguntas.getPreguntaN(i).getAutorPregunta();
                    matriz [i][6] = String.valueOf(StackOverflow.preguntas.getPreguntaN(i).getRecompensa());
                    matriz [i][7] = StackOverflow.preguntas.getPreguntaN(i).autorRecompensa;
                    matriz [i][8] = String.valueOf(StackOverflow.preguntas.getPreguntaN(i).estado);
                }
                vistaPregunta.TablaConPreguntas.setModel(new javax.swing.table.DefaultTableModel(
                matriz, new String [] {
                    "ID", "Titulo", "Contenido", "Etiquetas" ,"FechaPublicacion", "Autor", "Recompensa", "AutorRecompesa", "Estado"
                }));
            }else{
                JOptionPane.showMessageDialog(vistaVentanaPreguntas, "Ingrese minimo una etiqueta", "Alerta",
                JOptionPane.WARNING_MESSAGE);
            } 
        }
        else if(activate == 1 && e.getSource()== vistaPregunta.BotonVolverMenu){
            vistaPregunta.setVisible(false);
            vistaPregunta.dispose();
            vistaLogeado.setVisible(true);
            int n = StackOverflow.preguntas.getTamano();	
            String matriz [][]= new String [n][9]; 
            for (int i = 0; i < n; i++) {
                matriz [i][0] = String.valueOf(StackOverflow.preguntas.getPreguntaN(i).getIdPregunta()) ;
                matriz [i][1] = StackOverflow.preguntas.getPreguntaN(i).getTituloPregunta() ;
                matriz [i][2] = StackOverflow.preguntas.getPreguntaN(i).getContenidoPregunta() ;
                matriz [i][3] = StackOverflow.preguntas.getPreguntaN(i).etiquetas.etiquetas2String3();
                matriz [i][4] = StackOverflow.preguntas.getPreguntaN(i).getFechaPublicacion() ;
                matriz [i][5] = StackOverflow.preguntas.getPreguntaN(i).getAutorPregunta();
                matriz [i][6] = String.valueOf(StackOverflow.preguntas.getPreguntaN(i).getRecompensa());
                matriz [i][7] = StackOverflow.preguntas.getPreguntaN(i).autorRecompensa;
                matriz [i][8] = String.valueOf(StackOverflow.preguntas.getPreguntaN(i).estado);
            }
            vistaLogeado.TablaPreguntas.setModel(new javax.swing.table.DefaultTableModel(
            matriz, new String [] {
            "ID", "Titulo", "Contenido", "Etiquetas" ,"FechaPublicacion", "Autor", "Recompensa", "AutorRecompesa", "Estado"
            }));
        }
        else if(activate == 1 && e.getSource()== vistaPregunta.BotonCerrarSesion){
            StackOverflow.logout();
            view.InputNameUser.setText("");
            view.InputPassUser.setText("");
            view.statusLabel.setText("Esperando una accion...");
            vistaPregunta.setVisible(false);
            vistaLogeado.setVisible(false);
            view.setVisible(true);
        }
        

        
        //SELECCIONA BOTON DE OFRECER RECOMPENSA.
        //SELECCIONA BOTON DE ACEPTAR RESPUESTA.
        
        
        
        
        //SELECCIONA BOTON DE CREAR ETIQUETAS.
        else if(e.getSource()== vistaLogeado.BotonCrearEtiquetas){
            ventanaEtiquetas(); 
            this.activa = 1 ;
        }
        else if(activa == 1 && e.getSource()== vistaEtiquetas.BotonAgregarEtiqueta){
            int x = StackOverflow.agregarEtiqueta(vistaEtiquetas.InputNombreEtiqueta.getText(), vistaEtiquetas.InputContenido.getText());
            //Si el nombre de etiqueta esta vacio muestra el mensaje.
            if(vistaEtiquetas.InputNombreEtiqueta.getText().equals("")){
                vistaEtiquetas.StatusLabel.setText("Ingrese nombre de la etiqueta");
            //Si el contenido de etiqueta esta vacio muestra el mensaje.    
            }else if(vistaEtiquetas.InputContenido.getText().equals("")){
                vistaEtiquetas.StatusLabel.setText("Ingrese contenido de la etiqueta");
            }
            //Si la etiqueta se encuentra registrada muestra el mensaje.
            else if(x==1){
                vistaEtiquetas.StatusLabel.setText("La etiqueta ya se encuentra registrada");
            //Si la etiqueta no se encuentra registrada se añade.    
            }else if(x==2){
                vistaEtiquetas.StatusLabel.setText("Etiqueta añadida con exito");
                vistaEtiquetas.EtiquetasYDescripcion.setText(StackOverflow.etiquetas.etiquetas2String2());
            }
        }
        else if(activa == 1 && e.getSource()== vistaEtiquetas.BotonCerrarSesion){
            StackOverflow.logout();
            view.InputNameUser.setText("");
            view.InputPassUser.setText("");
            view.statusLabel.setText("Esperando una accion...");
            vistaEtiquetas.setVisible(false);
            vistaLogeado.setVisible(false);
            view.setVisible(true);
            
        }
        else if(activa == 1 && e.getSource()== vistaEtiquetas.BotonVolver){
            vistaEtiquetas.setVisible(false);
            vistaEtiquetas.dispose();
            vistaLogeado.setVisible(true);
            
        }
                
        //VENTANA PREGUNTA
        else if(e.getSource()== vistaVentanaPreguntas.BotonRespuesta){
            if(vistaVentanaPreguntas.InputRespuesta.getText().equals("")){
                JOptionPane.showMessageDialog(vistaVentanaPreguntas, "Rellene el espacio de respuesta", "Alerta",
                JOptionPane.WARNING_MESSAGE);
            }
            else{
                int id = vistaVentanaPreguntas.id;
                String respuesta = vistaVentanaPreguntas.InputRespuesta.getText() ;
                String autor = StackOverflow.ActivoUsuario.getNombreUsuario();
                StackOverflow.answer(id, respuesta, autor);
                vistaVentanaPreguntas.VerPregunta.setText(StackOverflow.preguntas.getPreguntaN(id).pregunta2String());
                vistaVentanaPreguntas.InputRespuesta.setText("");
            } 
        }
        
        else if(e.getSource()== vistaVentanaPreguntas.BotonVolver){
            vistaVentanaPreguntas.setVisible(false);
            vistaVentanaPreguntas.dispose();
            vistaLogeado.setVisible(true);
        }
    }  
}


