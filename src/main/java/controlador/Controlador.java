//ESTE PACKAGE SE ENCARGA DE REALIZAR EL CONTROL DE LAS VISTAS Y BOTONES DEL LABORATORIO.
package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
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
 * Se importan todas las vistas que tendra el controlador dentro de la clase controlador.
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
    /**
    *Se crea el constructor de la clase,recibe el la vista view que es la inicial y el stack el
    * cual contiene los metodos.
    * @author dyllan
    * @param view Es la ventana inicial de nuestro programa.
    * @param StackOverflow Es el stack que contiene las funciones.
    */
    public Controlador(Vista view, stack StackOverflow){
        this.view = view;
        this.StackOverflow = StackOverflow;
    }
    
    //FUNCION PARA INICIAR LA PRIMERA VENTANA.
    public void iniciar(){
        //Se le asiga el nombre que tendra la ventana.
        view.setTitle("Simulacion de StackOverflow por Dyllan Salgado");
        view.setLocationRelativeTo(null);
        //Ingresamos los botones que tiene la ventana.
        view.BotonRegistrar.addActionListener(this);
        view.BotonLogearse.addActionListener(this);
        view.setVisible(true);
        //Este ciclo nos permite mostrar a los usuarios que se encuentran ya registrados en el stack.
        int n = StackOverflow.usuarios.getTamano();
        for (int i = 0; i < n; i++) {
            String nombreUsuario = StackOverflow.usuarios.getUsuarioN(i).getNombreUsuario() ;
            view.listaRegistrados.addElement(nombreUsuario);
        }
        
    }
    //FUNCION PARA INICIAR VENTANA LOGEADO.
    /**
    * La ventana logeado recibe como entrada el nombre y la reputacion del usuario que se ha logeado.
    * @author dyllan
    * @param nombre corresponde al nombre del usuario que se ha logeado.
    * @param reputacion corresponde a la reputacion que tiene el usuario que se ha logeado.
    */
    public void ventanaLogeado(String nombre, int reputacion){
        //Instanciamos la vistalogeado.
        vistaLogeado = new VistaLogeado();
        //Se muestran las preguntas dentro de la tabla en la vista logeado.
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
        //Se le asigna un nombre a la ventana.
        vistaLogeado.setTitle("Simulacion de StackOverflow por Dyllan Salgado");
        vistaLogeado.setLocationRelativeTo(null);
        //Asignamos el nombre y reputacion del usuario en la ventana.
        vistaLogeado.InputUsuario.setText(nombre);
        vistaLogeado.InputReputacion.setText(String.valueOf(reputacion));
        //Se llama a los botones para que funcionen al momento de llamar a la ventana.
        vistaLogeado.BtnCerrarSesion.addActionListener(this);
        vistaLogeado.BotonPregunta.addActionListener(this);
        vistaLogeado.BotonAceptarRespuesta.addActionListener(this);
        vistaLogeado.BotonRecompensa.addActionListener(this);
        vistaLogeado.BotonCrearEtiquetas.addActionListener(this);
        vistaLogeado.BotonVerPregunta.addActionListener(this);
        //Se muestra la ventana.
        vistaLogeado.setVisible(true);
    }
    
    //FUNCION PARA INICIAR VENTANA PREGUNTA.
    /**
    *La ventana logeado recibe como entrada el nombre y la reputacion del usuario que se ha logeado.
    *@author dyllan
    * @param miPregunta corresponde a la pregunta que se va a seleccionar con el id.
    * @param id corresponde al id de la pregunta que se ha seleccionado.
    */
    public void ventanaPregunta(pregunta miPregunta, int id){
        //Instanciamos la ventana de preguntas.
        vistaVentanaPreguntas = new VistaVentanaPreguntas();
        //Se ingresa el nombre y reputacion del usuario.
        vistaVentanaPreguntas.NameUser.setText(StackOverflow.ActivoUsuario.getNombreUsuario());
        vistaVentanaPreguntas.ReputacionUser.setText(String.valueOf(StackOverflow.ActivoUsuario.getReputacionUsuario()));
        //id de pregunta para al momento de seleccionar las preguntas.
        vistaVentanaPreguntas.id  =id;
        //Se obtiene la pregunta seleccionada.
        vistaVentanaPreguntas.VerPregunta.setText(miPregunta.pregunta2String());
        //Se obtienen los botones de la ventana pregunta.
        vistaVentanaPreguntas.BotonRespuesta.addActionListener(this);
        vistaVentanaPreguntas.BotonVolver.addActionListener(this);    
        vistaVentanaPreguntas.VerPregunta.setEditable(false); 
        vistaVentanaPreguntas.VerPregunta.setLineWrap(true);  
        vistaVentanaPreguntas.setLocationRelativeTo(null);
        //Se muestra la ventana.
        vistaVentanaPreguntas.setVisible(true);
    }
    
    //FUNCION PARA INICIAR VENTANA CREAR ETIQUETAS.
    //Permite abrir la ventana para crear las etiquetas.
    public void ventanaEtiquetas(){
        //Se instancia la vista de etiquetas.
        vistaEtiquetas = new VistaEtiquetas();
        //Se ingresa el nombre y reputacion del usuario.
        vistaEtiquetas.NombreUsuario.setText(StackOverflow.ActivoUsuario.getNombreUsuario());
        vistaEtiquetas.ReputacionUsuario.setText(String.valueOf(StackOverflow.ActivoUsuario.getReputacionUsuario()));
        //Se obtienen los botones de la ventana etiqueta.
        vistaEtiquetas.BotonAgregarEtiqueta.addActionListener(this);
        vistaEtiquetas.BotonCerrarSesion.addActionListener(this);
        vistaEtiquetas.BotonVolver.addActionListener(this);
        //Se obtiene etiqueta y descripcion de la lista de etiquetas.
        vistaEtiquetas.EtiquetasYDescripcion.setText(StackOverflow.etiquetas.etiquetas2String2());
        vistaEtiquetas.EtiquetasYDescripcion.setEditable(false); 
        vistaEtiquetas.EtiquetasYDescripcion.setLineWrap(true);
        vistaEtiquetas.setLocationRelativeTo(null);
        //Se muestra la ventana.
        vistaEtiquetas.setVisible(true);
    }
    //FUNCION PARA INICIAR VENTANA REALIZAR PREGUNTA.
    //Permite abrir la ventana para realizar las preguntas.
    public void ventanaRealizarPregunta(){
        //Se instancia la vista de pregunta.
        vistaPregunta = new VistaPregunta();
        //Se muestra la lista con etiquetas.
        String[] options = StackOverflow.etiquetas.etiquetas2Array();
        for (int i = 0; i < options.length; i++) {
            vistaPregunta.InputEtiqueta.addItem(options[i]);
        }
        //Se muestra una tabla con todas las preguntas que se tengan.
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
        //Se ingresa el nombre y reputacion del usuario.
        vistaPregunta.InputUsuario.setText(StackOverflow.ActivoUsuario.getNombreUsuario());
        vistaPregunta.InputReputacion.setText(String.valueOf(StackOverflow.ActivoUsuario.getReputacionUsuario()));
        //Se obtienen los botones de la ventana pregunta.
        vistaPregunta.BotonCerrarSesion.addActionListener(this);
        vistaPregunta.BotonVolverMenu.addActionListener(this);
        vistaPregunta.BotonPublicarPregunta.addActionListener(this);
        //Se muestra la ventana.
        vistaPregunta.setVisible(true);
    }
    
    //FUNCION PARA INICIAR VENTANA REWARD.
    //Permite abrir la ventana para realizar el reward.
    public void ventanaRealizarReward(){
        //Se instancia la vista de reward.
        vistaReward = new VistaReward();
        //Se muestran todas las preguntas del stack en la tabla.
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
        //Se obtienen los botones de la ventana reward.
        vistaReward.BotonDarRecompensa.addActionListener(this);
        vistaReward.BotonCerrarSesion.addActionListener(this);
        vistaReward.NameUser.setText(StackOverflow.ActivoUsuario.getNombreUsuario());
        vistaReward.ReputacionUser.setText(String.valueOf(StackOverflow.ActivoUsuario.getReputacionUsuario()));
        vistaReward.BotonVolver.addActionListener(this);
        vistaReward.setLocationRelativeTo(null);
        //Se muestra la ventana.
        vistaReward.setVisible(true);
    }
    //FUNCION PARA INICIAR VENTANA ACEPTAR
    //Permite abrir la ventana para realizar el accept.
    public void ventanaAccept(){
        //Se instancia la vista accept.
        vistaAccept = new VistaAccept();
        //Se muestra una lista con todas las preguntas en una tabla.
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
        //Se obtienen los botones de la ventana accept.
        vistaAccept.VerRespuestas.addActionListener(this);
        vistaAccept.BotonCerrarSesion.addActionListener(this);
        vistaAccept.BotonVolver.addActionListener(this);
        vistaAccept.NameUser.setText(StackOverflow.ActivoUsuario.getNombreUsuario());
        vistaAccept.ReputacionUser.setText(String.valueOf(StackOverflow.ActivoUsuario.getReputacionUsuario()));
        vistaAccept.setLocationRelativeTo(null);
        //Se muestra la ventana.
        vistaAccept.setVisible(true);
    }
    //FUNCION PARA VER RESPUESTAS PARA ACEPTAR.
    /**
    * Permite abrir la ventana de ver respuestas.
    * @param miPregunta es la pregunta seleccionada.
    * @param id es el id de la pregunta que se ha selecionado.
    */
    public void ventanaVerRespuestas(pregunta miPregunta, int id){
        //Se instancia la vista ver repuesta.
        verRespuestas = new VerRespuestas();
        //Se obtienen los botones para que sean utilizados.
        verRespuestas.BotonAceptarRespuesta.addActionListener(this);
        verRespuestas.BotonCerrarSesion.addActionListener(this);
        verRespuestas.id  =id;
        verRespuestas.BotonVolver.addActionListener(this);
        //Mustra la pregunta selecionada.
        verRespuestas.VerPreguntaSeleccionada.setText(miPregunta.pregunta2String());
        verRespuestas.VerPreguntaSeleccionada.setEditable(false);
        verRespuestas.VerPreguntaSeleccionada.setLineWrap(true);
        verRespuestas.NombreUsuario.setText(StackOverflow.ActivoUsuario.getNombreUsuario());
        verRespuestas.NombreReputacion.setText(String.valueOf(StackOverflow.ActivoUsuario.getReputacionUsuario()));
        //verRespuestas.NombreReputacion.setText(String.valueOf(repuActualizado));
        verRespuestas.setLocationRelativeTo(null);
        //Se muestra la ventana.
        verRespuestas.setVisible(true);
    }
    
    //actionPerformed permite realizar los eventos de los botones de las vistas.
    //Es override porque todos los botones tienen esta funcion definida.
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
            if(view.InputNameUser.getText().equals("") || String.valueOf(view.InputPassUser.getPassword()).equals("")){
                view.statusLabel.setText("Rellenar todos los campos disponibles");
            }
            //Cuando el nombre de usuario y clave corresponden a un usuario se abre la nueva ventana.
            else if(x==1){
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
            //Se pregunta que pregunta se quiere ver con un JOptionPane.
            String[] options = StackOverflow.preguntas.preguntas2Array();
            String salida = (String)JOptionPane.showInputDialog(null, "Las preguntas son las siguientes", 
            "Elige una pregunta para visualizarlas", JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
            //Si salida es distinto de null se muestran las preguntas dentro del stack.
            if (salida != null && !salida.equals(null)) {   
                int i = 0;
                while (i<StackOverflow.preguntas.getTamano()) {
                    if (salida.equals(options[i])) {
                        break;
                    }
                    i++;
                }
                //Se abre la ventana pregunta con la pregunta que ha sido seleccionada.
                pregunta miPregunta =  StackOverflow.preguntas.getPreguntaN(i);
                ventanaPregunta(miPregunta,i);
            }    
        }
        //SELECCIONA EL BOTON DE CERRAR SESION EN VISTALOGEADO.
        else if(e.getSource()== vistaLogeado.BtnCerrarSesion ){
            //Se deslogea el usuario.
            StackOverflow.logout();
            //Se reinicia los textos.
            view.InputNameUser.setText("");
            view.InputPassUser.setText("");
            view.statusLabel.setText("Esperando una accion...");
            //Se cierra vista logeado.
            vistaLogeado.setVisible(false);
            //Se ve la vista view.
            view.setVisible(true);
        }
        //SELECCIONA BOTON DE REALIZAR PREGUNTA.
        else if(e.getSource()== vistaLogeado.BotonPregunta){
            //Se inicia la ventana pregunta.
            ventanaRealizarPregunta();
            this.activate = 1 ;
        }
        //Selecciona el boton para publicar pregunta.
        else if(activate == 1 && e.getSource()== vistaPregunta.BotonPublicarPregunta){
            //Se obtienen los datos de las preguntas.
            String titulo =vistaPregunta.InputTituloPregunta.getText();
            String contenido = vistaPregunta.InputContenidoPregunta.getText();
            String autor = StackOverflow.ActivoUsuario.getNombreUsuario();
            String etiqueta = vistaPregunta.InputEtiqueta.getName();
            int index = (int) vistaPregunta.InputEtiqueta.getSelectedIndex();
            if(vistaPregunta.InputRecompensa.getText().equals("")||titulo.equals("")||contenido.equals("")){
               vistaPregunta.StatusLabelPregunta.setText("Rellene todos los campos disponibles"); 
            }
            else{
                int reputacion = Integer.parseInt(vistaPregunta.InputRecompensa.getText());
                //Si el usuario ingresa mas reputacion de la que tiene muestra un mensaje y no se publica la pregunta.
                if (StackOverflow.ActivoUsuario.getReputacionUsuario() < reputacion){
                    vistaPregunta.StatusLabelPregunta.setText("No tiene reputacion necesaria"); 
                }
                //Si el usuario ingresa una recompensa menor a 0.
                else if(reputacion < 0){
                    vistaPregunta.StatusLabelPregunta.setText("Ingrese valores positivos"); 
                }
                //Si ingresa recompensa menor a la que tiene se puede publicar la pregunta.
                else{
                    //Se ingresa la etiqueta.
                    if (index != -1) {
                        StackOverflow.ask(titulo, contenido, autor, StackOverflow.etiquetas.getEtiquetaN(index), reputacion);
                        JOptionPane.showMessageDialog (null, "Pregunta insertada", "Succes", JOptionPane.INFORMATION_MESSAGE);
                        //Se muestran las preguntas dentro de la ventana realizar pregunta.
                       
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
        }
        //SE VUELVE AL MENU DESDE LA VISTA PREGUNTA.
        else if(activate == 1 && e.getSource()== vistaPregunta.BotonVolverMenu){
            //Se cierra la vista pregunta.
            vistaPregunta.setVisible(false);
            vistaPregunta.dispose();
            //Se abre la vista logeado.
            vistaLogeado.setVisible(true);
            //Se muestran las preguntas del stack.
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
            //Se cierra la sesion.
            StackOverflow.logout();
            //Se reinician las entrada de nombre y password.
            view.InputNameUser.setText("");
            view.InputPassUser.setText("");
            view.statusLabel.setText("Esperando una accion...");
            //Se cierran las ventanas.
            vistaPregunta.setVisible(false);
            vistaLogeado.setVisible(false);
            //Se muestra view.
            view.setVisible(true);
        }
        
        //SELECCIONA BOTON DE OFRECER RECOMPENSA.
        else if(e.getSource()== vistaLogeado.BotonRecompensa){
            //Se abre la ventana de realizar reward.
            ventanaRealizarReward();
            this.act = 1 ;
        }
        //VOLVER A MENU DESDE LA VISTA REWARD.
        else if(act == 1 && e.getSource()== vistaReward.BotonVolver){
            //Se cierra la vista reward.
            vistaReward.setVisible(false);
            vistaReward.dispose();
            //Se abre la vista logeado.
            vistaLogeado.setVisible(true);
        }
        //CERRAR SESION DE VISTA REWARD
        else if(act == 1 && e.getSource()== vistaReward.BotonCerrarSesion){
            //Se cierra la sesion.
            StackOverflow.logout();
            //Se reinician las entrada de nombre y password.
            view.InputNameUser.setText("");
            view.InputPassUser.setText("");
            view.statusLabel.setText("Esperando una accion...");
            //Se cierran las ventanas.
            vistaReward.setVisible(false);
            vistaLogeado.setVisible(false);
            //Se abre la vista logeado.
            view.setVisible(true);
        }
        //SELECIONAR BOTON DARRECOMPENSA.
        else if(act == 1 && e.getSource()==vistaReward.BotonDarRecompensa){
            //Si no se ingresa nada en id y recompensa se muestra un mensaje
            if(vistaReward.InputID.getText().equals("") || vistaReward.InputRecompensa.getText().equals("") ){
                JOptionPane.showMessageDialog(null, "Rellene los campos disponibles", "Alerta", JOptionPane.WARNING_MESSAGE); 
            }
            //Si se ingresan datos dependera de lo que se ingrso.
            else{
                int reward= StackOverflow.reward(Integer.valueOf(vistaReward.InputID.getText()), Integer.valueOf(vistaReward.InputRecompensa.getText()));
                //Si se ingresa un id inexistente se muestra un mensaje.
                if(reward == 0){
                    JOptionPane.showMessageDialog(null, "Ingrese ID existente", "Alerta", JOptionPane.WARNING_MESSAGE);
                }
                //Si no tiene recompensa para dar se muestra un mensaje.
                else if(reward == 4){
                    JOptionPane.showMessageDialog(null, "No tiene suficiente reputacion", "Alerta", JOptionPane.WARNING_MESSAGE);
                }
                //Si ya existe una recompensa mayor a la que esta dando se muestra mensaje.
                else if(reward == 2){
                    JOptionPane.showMessageDialog(null, "Existe una recompensa mayor a la que esta dando", "Alerta", JOptionPane.WARNING_MESSAGE);
                }
                //Si tiene recompensa y no hay ninguna mayor se puede otorgar.
                else if(reward == 3){
                    JOptionPane.showMessageDialog(null, "Recompensa entregada con exito", "Successful", JOptionPane.WARNING_MESSAGE);
                    //Se muestra las preguntas en la tabla.
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
                }
            }  
        }
        //SELECCIONA BOTON DE ACEPTAR RESPUESTA.
        else if(e.getSource()== vistaLogeado.BotonAceptarRespuesta){
            //Se abre la ventana de aceptar respuesta.
            ventanaAccept();
            this.activo = 1 ;
        }
        //VOLVER A MENU DESDE ACCEPT
        else if(activo == 1 && e.getSource()== vistaAccept.BotonVolver){
            //Se cierra la ventana de aceptar.
            vistaAccept.setVisible(false);
            vistaAccept.dispose();
            //Se abre la ventana logeado.
            vistaLogeado.setVisible(true);
        }
        //Mostrar las respuestas de la pregunta que ha realizado el usuario.
        else if(activo==1 && e.getSource()== vistaAccept.VerRespuestas){
            //Se muestra como opciones las preguntas que se tienen.
            String[] options = StackOverflow.preguntas.preguntas2Array();
            String salida = (String)JOptionPane.showInputDialog(null, "Las preguntas son las siguientes", 
            "Elige una pregunta para visualizarlas", JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
            //Si existen preguntas se busca la que se ha selecionado.
            if (salida != null && !salida.equals(null)) {   
                int i = 0;
                while (i<StackOverflow.preguntas.getTamano()) {
                    if (salida.equals(options[i])) {
                        break;
                    }
                    i++;
                }
                //Se obtiene la pregunta.
                pregunta miPregunta =  StackOverflow.preguntas.getPreguntaN(i);
                //Si la pregunta seleccionada no pertenece al usuario que la realizo no se puede visualzar.
                if(!miPregunta.getAutorPregunta().equals(StackOverflow.ActivoUsuario.getNombreUsuario()) ){
                    ventanaVerRespuestas(miPregunta,i);
                    verRespuestas.setVisible(false);
                    //Se muestra mensaje diciendo que no se puede ver.
                    JOptionPane.showMessageDialog(null, "La pregunta seleccionada no es de su autoria", "Alerta", 
                    JOptionPane.WARNING_MESSAGE);
                }
                else if (miPregunta.estado==1){
                    JOptionPane.showMessageDialog(null, "La pregunta ya tiene respuesta aceptada", "Alerta", 
                    JOptionPane.WARNING_MESSAGE);
                }
                //Si la pregunta corresponde al usuario, se abre la ventana para ver las respuestas.
                else{
                    ventanaVerRespuestas(miPregunta,i);
                }
            }
            //Si no selecciona ninguna se muestra mensaje.
            else{
                JOptionPane.showMessageDialog(vistaVentanaPreguntas, "No ha seleccionado pregunta", "Alerta",
                JOptionPane.WARNING_MESSAGE);
            }    
        }
        //BOTON PARA CERRAR SESION DE VISTARESPUESTA.
        else if(activo == 1 && e.getSource() == verRespuestas.BotonCerrarSesion){
            //Se cierra la cuenta.
            StackOverflow.logout();
            //Se reinician los datos.
            view.InputNameUser.setText("");
            view.InputPassUser.setText("");
            view.statusLabel.setText("Esperando una accion...");
            verRespuestas.dispose();
            vistaAccept.dispose();
            vistaLogeado.dispose();
            //Se muesta la vista view.
            view.setVisible(true);  
        }
        
        //BOTON DE VOLVER AL MENU DE VISTA VER RESPUESTAS EN ACCEPT.
        else if(activo==1 && e.getSource()== verRespuestas.BotonVolver){
            //Se cierra la ventana respuetas.
            verRespuestas.setVisible(false);
            verRespuestas.dispose();
            //Se abre la ventana accept.
            vistaAccept.setVisible(true);
            //Se muestran las prepguntas de accept.
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
        //BOTON PARA ACEPTAR RESPUESTAS.
        else if(activo == 1 && e.getSource()==verRespuestas.BotonAceptarRespuesta){
            //Se obtiene el id de pregunta e id de respuesta.
            int IDrespuesta = Integer.valueOf (verRespuestas.InputIDRespuesta.getText());
            int preguntaID = verRespuestas.id;
            //Se verifica si es true, si es verdad se acepta la respuesta.
            Boolean verificador = StackOverflow.accept(IDrespuesta,preguntaID) ;
            if(verificador == true){
                verRespuestas.StatusLabel.setText("Respuesta aceptada con exito");
                verRespuestas.InputIDRespuesta.setText("");
                //Se muestran las preguntas.
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
            //Si no se puede aceptar la respuesta se muestra mensaje.
            else{
              verRespuestas.StatusLabel.setText("La respuesta ya se encuentra aceptada, por ende no se puede volver a aceptar" + IDrespuesta + preguntaID);  
            }
        }
        //CERRAR SESION DE VISTA ACCEPT
        else if(activo == 1 && e.getSource()== vistaAccept.BotonCerrarSesion){
            //Se cierra la sesion.
            StackOverflow.logout();
            //Se reinician los datos.
            view.InputNameUser.setText("");
            view.InputPassUser.setText("");
            view.statusLabel.setText("Esperando una accion...");
            //Se cierran las ventanas.
            vistaAccept.setVisible(false);
            vistaLogeado.setVisible(false);
            //Se muestra view.
            view.setVisible(true);
        }
        
        //SELECCIONA BOTON DE CREAR ETIQUETAS.
        else if(e.getSource()== vistaLogeado.BotonCrearEtiquetas){
            //Se abre la ventana etiquetas.
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
            //Se cierra la sesion.
            StackOverflow.logout();
            //Se reinician los datos.
            view.InputNameUser.setText("");
            view.InputPassUser.setText("");
            view.statusLabel.setText("Esperando una accion...");
            //Se cierran las ventanas.
            vistaEtiquetas.setVisible(false);
            vistaLogeado.setVisible(false);
            //Se hace visible el view.
            view.setVisible(true);
            
        }
        //SELECCIONA BOTON VOLVER DESDE ETIQUETAS.
        else if(activa == 1 && e.getSource()== vistaEtiquetas.BotonVolver){
            //Se cierra la ventana.
            vistaEtiquetas.setVisible(false);
            vistaEtiquetas.dispose();
            //Se abre la vista logeado.
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