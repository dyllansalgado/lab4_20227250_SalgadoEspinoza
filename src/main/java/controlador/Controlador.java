

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
import vista.VistaReward;
import vista.VistaVentanaPreguntas;
import vista.VerRespuestas;
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
    private int act=0;
    private int activo=0;
    private VerRespuestas verRespuestas;
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
        vistaVentanaPreguntas.setLocationRelativeTo(null);
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
        vistaEtiquetas.EtiquetasYDescripcion.setEditable(false); 
        vistaEtiquetas.EtiquetasYDescripcion.setLineWrap(true);
        vistaEtiquetas.setLocationRelativeTo(null);
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
    
    //FUNCION PARA INICIAR VENTANA REWARD.
    public void ventanaRealizarReward(){
        vistaReward = new VistaReward();
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
        vistaReward.tablaPreguntas.setModel(new javax.swing.table.DefaultTableModel(
        matriz, new String [] {
        "ID", "Titulo", "Contenido", "Etiquetas" ,"FechaPublicacion", "Autor", "Recompensa", "AutorRecompesa", "Estado"
        }));
        vistaReward.BotonDarRecompensa.addActionListener(this);
        vistaReward.BotonCerrarSesion.addActionListener(this);
        vistaReward.BotonVolver.addActionListener(this);
        vistaReward.setLocationRelativeTo(null);
        vistaReward.setVisible(true);
    }
    //FUNCION PARA INICIAR VENTANA ACEPTAR
    public void ventanaAccept(){
        vistaAccept = new VistaAccept();
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
        vistaAccept.TablaPreguntasUsuario.setModel(new javax.swing.table.DefaultTableModel(
        matriz, new String [] {
        "ID", "Titulo", "Contenido", "Etiquetas" ,"FechaPublicacion", "Autor", "Recompensa", "AutorRecompesa", "Estado"
        }));
        vistaAccept.VerRespuestas.addActionListener(this);
        vistaAccept.BotonCerrarSesion.addActionListener(this);
        vistaAccept.BotonVolver.addActionListener(this);
        vistaAccept.setLocationRelativeTo(null);
        vistaAccept.setVisible(true);
    }
    //FUNCION PARA VER RESPUESTAS PARA ACEPTAR.
    public void ventanaVerRespuestas(pregunta miPregunta, int id){
        verRespuestas = new VerRespuestas();
        verRespuestas.BotonAceptarRespuesta.addActionListener(this);
        verRespuestas.BotonCerrarSesion.addActionListener(this);
        verRespuestas.id  =id;
        verRespuestas.BotonVolver.addActionListener(this);
        verRespuestas.VerPreguntaSeleccionada.setText(miPregunta.pregunta2String());
        verRespuestas.VerPreguntaSeleccionada.setEditable(false);
        verRespuestas.VerPreguntaSeleccionada.setLineWrap(true); 
        verRespuestas.setLocationRelativeTo(null);
        verRespuestas.setVisible(true);
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
            //x  =2 quiere decir que la contrasena es incorrecta.
            else if(x == 2){
                view.statusLabel.setText("contrasena incorrecta");
            } 
            //x = 3 quiere decir que el usuario es incorrecto.
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
        //Selecciona el boton para publicar pregunta.
        else if(activate == 1 && e.getSource()== vistaPregunta.BotonPublicarPregunta){
            String titulo =vistaPregunta.InputTituloPregunta.getText();
            String contenido = vistaPregunta.InputContenidoPregunta.getText();
            String autor = StackOverflow.ActivoUsuario.getNombreUsuario();
            String etiqueta = vistaPregunta.InputEtiqueta.getName();
            int index = (int) vistaPregunta.InputEtiqueta.getSelectedIndex();
            int reputacion = Integer.parseInt(vistaPregunta.InputRecompensa.getText());
            //Si el usuario ingresa mas reputacion de la que tiene muestra un mensaje y no se publica la pregunta.
            if (StackOverflow.ActivoUsuario.getReputacionUsuario() < reputacion){
                vistaPregunta.StatusLabelPregunta.setText("No tiene reputacion necesaria"); 
            }
            //Si ingresa recompensa menor a la que tiene se puede publicar la pregunta.
            else{
                //Se ingresa la etiqueta.
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
                    vistaPregunta.StatusLabelPregunta.setText("Agregada con exito");
                //Si no ingresa etiqueta.
                }else{
                    JOptionPane.showMessageDialog(vistaVentanaPreguntas, "Ingrese minimo una etiqueta", "Alerta",
                    JOptionPane.WARNING_MESSAGE);
                    vistaPregunta.StatusLabelPregunta.setText("Ingrese etiqueta");
                }  
            }
        }
        //SE VUELVE AL MENU DESDE LA VISTA PREGUNTA.
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
        //SE CIERRA SESION DESDE LA VENTANA PREGUNTA.
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
        else if(e.getSource()== vistaLogeado.BotonRecompensa){
            ventanaRealizarReward();
            this.act = 1 ;
        }
        //VOLVER A MENU.
        else if(act == 1 && e.getSource()== vistaReward.BotonVolver){
            vistaReward.setVisible(false);
            vistaReward.dispose();
            vistaLogeado.setVisible(true);
        }
        //CERRAR SESION DE VISTA REWARD
        else if(act == 1 && e.getSource()== vistaReward.BotonCerrarSesion){
            StackOverflow.logout();
            view.InputNameUser.setText("");
            view.InputPassUser.setText("");
            view.statusLabel.setText("Esperando una accion...");
            vistaReward.setVisible(false);
            vistaLogeado.setVisible(false);
            view.setVisible(true);
        }
        //SELECIONAR BOTON DARRecompensa.
        else if(act == 1 && e.getSource()==vistaReward.BotonDarRecompensa){
            if(vistaReward.InputID.getText().equals("") || vistaReward.InputRecompensa.getText().equals("") ){
                JOptionPane.showMessageDialog(null, "Rellene los campos disponibles", "Alerta", JOptionPane.WARNING_MESSAGE); 
            } 
            int reward= StackOverflow.reward(Integer.valueOf(vistaReward.InputID.getText()), Integer.valueOf(vistaReward.InputRecompensa.getText()));
            if(reward == 0){
                JOptionPane.showMessageDialog(null, "Ingrese ID existente", "Alerta", JOptionPane.WARNING_MESSAGE);
            }
            else if(reward == 1){
                JOptionPane.showMessageDialog(null, "No tiene suficiente reputacion", "Alerta", JOptionPane.WARNING_MESSAGE);
            }
            else if(reward == 2){
                JOptionPane.showMessageDialog(null, "Existe una recompensa mayor a la que esta dando", "Alerta", JOptionPane.WARNING_MESSAGE);
            }
            else if(reward == 3){
                JOptionPane.showMessageDialog(null, "Recompensa entregada con exito", "Successful", JOptionPane.WARNING_MESSAGE);
            }
            
        }
        //SELECCIONA BOTON DE ACEPTAR RESPUESTA.
        else if(e.getSource()== vistaLogeado.BotonAceptarRespuesta){
            ventanaAccept();
            this.activo = 1 ;
        }
        //VOLVER A MENU DESDE ACCEPT
        else if(activo == 1 && e.getSource()== vistaAccept.BotonVolver){
            vistaAccept.setVisible(false);
            vistaAccept.dispose();
            vistaLogeado.setVisible(true);
        }
        //Mostrar las respuestas de la pregunta que ha realizado el usuario.
        else if(activo==1 && e.getSource()== vistaAccept.VerRespuestas){
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
                if(!miPregunta.getAutorPregunta().equals(StackOverflow.ActivoUsuario.getNombreUsuario()) ){
                    ventanaVerRespuestas(miPregunta,i);
                    verRespuestas.setVisible(false);
                    JOptionPane.showMessageDialog(null, "La pregunta seleccionada no es de su autoria", "Alerta", 
                    JOptionPane.WARNING_MESSAGE);
                }
                else{
                    ventanaVerRespuestas(miPregunta,i);
                }
            }
            else{
                JOptionPane.showMessageDialog(vistaVentanaPreguntas, "No tiene preguntas", "Alerta",
                JOptionPane.WARNING_MESSAGE);
            }    
        }
        else if(activo == 1 && e.getSource() == verRespuestas.BotonCerrarSesion){
            StackOverflow.logout();
            view.InputNameUser.setText("");
            view.InputPassUser.setText("");
            view.statusLabel.setText("Esperando una accion...");
            verRespuestas.dispose();
            vistaAccept.dispose();
            vistaLogeado.dispose();
            view.setVisible(true);  
        }
        //BOTON DE VOLVER AL MENU DE VISTA VER RESPUESTAS EN ACCEPT.
        else if(activo==1 && e.getSource()== verRespuestas.BotonVolver){
            verRespuestas.setVisible(false);
            verRespuestas.dispose();
            vistaAccept.setVisible(true);
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
        else if(activo == 1 && e.getSource()==verRespuestas.BotonAceptarRespuesta){
            int IDrespuesta = Integer.valueOf (verRespuestas.InputIDRespuesta.getText());
            int preguntaID = verRespuestas.id;
            Boolean verificador = StackOverflow.accept(IDrespuesta,preguntaID) ;
            System.out.println("IDS : "+ verificador + IDrespuesta+ preguntaID);
            if(verificador == true ){
                verRespuestas.StatusLabel.setText("Respuesta aceptada con exito");
                verRespuestas.InputIDRespuesta.setText("");

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
            else{
              verRespuestas.StatusLabel.setText("no se pudo" + IDrespuesta + preguntaID);  
            }
        }
        //CERRAR SESION DE VISTA ACCEPT
        else if(activo == 1 && e.getSource()== vistaAccept.BotonCerrarSesion){
            StackOverflow.logout();
            view.InputNameUser.setText("");
            view.InputPassUser.setText("");
            view.statusLabel.setText("Esperando una accion...");
            vistaAccept.setVisible(false);
            vistaLogeado.setVisible(false);
            view.setVisible(true);
        }
        
        //SELECCIONA BOTON DE CREAR ETIQUETAS.
        else if(e.getSource()== vistaLogeado.BotonCrearEtiquetas){
            ventanaEtiquetas(); 
            this.activa = 1 ;
        }
        //SELECCIONA BOTON AGREGAR ETIQUETAS.
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
            //Si la etiqueta no se encuentra registrada se a�ade.    
            }else if(x==2){
                vistaEtiquetas.StatusLabel.setText("Etiqueta agregada con exito");
                vistaEtiquetas.EtiquetasYDescripcion.setText(StackOverflow.etiquetas.etiquetas2String2());
            }
        }
        //SELECCIONA BOTON CERRAR SESION.
        else if(activa == 1 && e.getSource()== vistaEtiquetas.BotonCerrarSesion){
            StackOverflow.logout();
            view.InputNameUser.setText("");
            view.InputPassUser.setText("");
            view.statusLabel.setText("Esperando una accion...");
            vistaEtiquetas.setVisible(false);
            vistaLogeado.setVisible(false);
            view.setVisible(true);
            
        }
        //SELECCIONA BOTON VOLVER.
        else if(activa == 1 && e.getSource()== vistaEtiquetas.BotonVolver){
            vistaEtiquetas.setVisible(false);
            vistaEtiquetas.dispose();
            vistaLogeado.setVisible(true);
            
        }

           
        //VENTANA PREGUNTA
        //SELECCIONAMOS EL BOTON PARA REALIZAR RESPUESTA.
        else if(e.getSource()== vistaVentanaPreguntas.BotonRespuesta){
            //Si la respuesta esta vacia se muestra un mensaje.
            if(vistaVentanaPreguntas.InputRespuesta.getText().equals("")){
                JOptionPane.showMessageDialog(vistaVentanaPreguntas, "Rellene el espacio de respuesta", "Alerta",
                JOptionPane.WARNING_MESSAGE);
            }
            //Si esta rellenada se puede ingresar la respuesta.
            else{
                int id = vistaVentanaPreguntas.id;
                String respuesta = vistaVentanaPreguntas.InputRespuesta.getText() ;
                String autor = StackOverflow.ActivoUsuario.getNombreUsuario();
                StackOverflow.answer(id, respuesta, autor);
                vistaVentanaPreguntas.VerPregunta.setText(StackOverflow.preguntas.getPreguntaN(id).pregunta2String());
                vistaVentanaPreguntas.InputRespuesta.setText("");
            } 
        }
        //SELECCIONAMOS EL BOTON DE VOLVER AL MENU.
        else if(e.getSource()== vistaVentanaPreguntas.BotonVolver){
            vistaVentanaPreguntas.setVisible(false);
            vistaVentanaPreguntas.dispose();
            vistaLogeado.setVisible(true);
        }
    }  
}


