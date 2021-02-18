package lab4_20227250_SalgadoEspinoza;

import java.util.Scanner;

/**
 * Una clase para representar al stack.
 * Se utiliza para ingresar los metodos especificos del laboratorio.
 * Los atributos de la clase ActivoUsuario, todos los usuarios,todas las preguntas y todas las etiquetas.
 * @author Dyllan Salgado
 */
public class stack {
	//Atributos de la clase stack
	public usuario ActivoUsuario; //Usuario actual
	public ListaDeUsuarios usuarios;//Usuarios totales	
	public ListaDePreguntas preguntas;//Lista de preguntas
	public ListaDeEtiquetas etiquetas;//Lista de etiquetas
	
	//Constructor de usuario
	public stack(String userName,String password,int reputacion) {
		usuarios = new ListaDeUsuarios();
		ActivoUsuario = new usuario(userName, password,reputacion);
		ActivoUsuario.reputacionUsuario = reputacion;
		usuarios.agregarUsuario(ActivoUsuario);	
		preguntas = new ListaDePreguntas();
		etiquetas = new ListaDeEtiquetas();
			
	}
        //Metodos.
        /**
	* login nos permite logear a un usuario ya registrado en el stack.
	* Se solicitan los datos nombre y clave para logearse.
 	* @author Dyllan Salgado
	*/
	public void login() {
		@SuppressWarnings("resource")
		Scanner entradaEscaner = new Scanner(System.in);
		System.out.println("Ingrese nombre de usuario");
		String user = entradaEscaner.nextLine();
		System.out.println("Ingrese contrasena de usuario");
		String pass = entradaEscaner.nextLine();
		//Usuario temporal
		usuario miUsuario = new usuario(user, pass);
		//Preguntamos si se encuentra registrado un usuario con el nombre dado
		if(usuarios.isInside(miUsuario) == true) {
                        //Si el nombre es correcto pero la clave es incorrecta se muestra que se equivoco en la clave.
			if (usuarios.correctPass(miUsuario) == true) {
				ActivoUsuario = usuarios.getUsuarioName(miUsuario.nombreUsuario);
				System.out.println("Usuario Logeado");
			}else {
				System.out.println("Contrasena incorrecta");
			}
                //Si el nombre no existe se muestra en pantalla que no hay nadie registrado con ese nombre.
		}else {
			System.out.println("No existe un usuario registrado como " + user);
		}
	}
        /**
	* logout nos permite deslogear a un usuario que se encuentra logeado.
 	* @author Dyllan Salgado
	*/
	public void logout() {
		ActivoUsuario = null;
	}
        
        /**
	* Nos permite mostrar en pantalla si existe alguien logeado o no.
 	* @author Dyllan Salgado
        * @return salidaString.
	*/
	public String activoUsuario2String() {
		String salidaString ;
		if (ActivoUsuario == null) {
			salidaString = "##  No hay usuario logeado actualmente  ##";
		}else {
			salidaString = "## Registrado como:" + ActivoUsuario.getNombreUsuario()+ "  Rep : " + ActivoUsuario.reputacionUsuario + "  ##";
		}
		return salidaString;

	}
        
        /**
	* registrarUsuario nos permite registrar a un usuario en el stack
	* Se solicitan los datos nombre y clave para registrarse.
        * Si el nombre ya existe se muestra en pantalla y vuelve a mostrar el menu.
 	* @author Dyllan Salgado
	*/
	public void registrarUsuario() {
		int x = 0;
		@SuppressWarnings("resource")
		Scanner entradaEscaner = new Scanner(System.in);
			while (x==0) {
                                //Se solicita el nombre de usuario.
				System.out.println("Ingrese nombre de usuario");
				String nameUser = entradaEscaner.nextLine();
				usuario myUsuario= new usuario(nameUser, "") ; 
				//Preguntamos si el usuario ya se encuentra en la lista de usuarios
				if(usuarios.isInside(myUsuario) == false) {
					System.out.println("Ingrese contrasena de usuario");
					String passUser = entradaEscaner.nextLine();
					myUsuario= new usuario(nameUser, passUser); 
					usuarios.agregarUsuario(myUsuario);
					x = 1;
				}else {
					System.out.println("Ya existe un usuario registrado con ese nombre, desea continuar? S/N");
					String answer  =  entradaEscaner.nextLine();
					if (answer.equals("N")||answer.equals("n")) {
						x = 1;
					}
				}
			}
	}
        //Constructor del nuevo usuario registrado.
	public void registrarUsuario(String nameUser,String password, int reputacion) {
		usuario myUsuario= new usuario(nameUser, password,reputacion); 
            //    Se agrega a la lista de usuarios.
		usuarios.agregarUsuario(myUsuario);
	}
        /**
	* ask nos permite formular una pregunta con un usuario logeado.
	* Se solicitan un titulo de pregunta, contenido y la etiqueta a agregar.
 	* @author Dyllan Salgado
	*/
	public void ask() {
		@SuppressWarnings("resource")
		Scanner entradaEscaner = new Scanner(System.in);
		System.out.println("Ingrese el titulo de la pregunta");
		String titulo = entradaEscaner.nextLine();
		System.out.println("Ingrese el contenido de la pregunta");
		String contenido = entradaEscaner.nextLine();
		System.out.println(etiquetas.etiquetas2String2());
		System.out.println("Indique la etiqueta que quiere agregar");
		int x = entradaEscaner.nextInt();
		etiqueta miEtiqueta ;
		if (etiquetas.getEtiquetaN(x)!= null) {
			miEtiqueta =  etiquetas.getEtiquetaN(x);
		}else {
			miEtiqueta = new etiqueta("NULL","NULL");
		}
		pregunta miPregunta = new pregunta(titulo, contenido, ActivoUsuario.getNombreUsuario(),miEtiqueta, preguntas.getTamano()+1);
		miPregunta.autorRecompensa = ActivoUsuario.getNombreUsuario();
		//Solo si su recompensa es distinta de 0
		if (ActivoUsuario.reputacionUsuario != 0) {
			System.out.println("Desea asignar recompensa? S/N" );
			@SuppressWarnings("resource")
			Scanner entradaEscaner2 = new Scanner(System.in);
			String respuesta = "N"; 
			try {
				respuesta= entradaEscaner2.nextLine();
			} catch (Exception e) {
			}
			miPregunta.autorRecompensa =  ActivoUsuario.nombreUsuario;
			miPregunta.setRecompensa(0);
			if (respuesta.equals("S")||respuesta.equals("s")) {
				System.out.println("Ingrese recompensa a asignar" );
				int recompensa = entradaEscaner2.nextInt();
				miPregunta.setRecompensa(recompensa);
				miPregunta.autorRecompensa =  ActivoUsuario.nombreUsuario;
				
			}
		}
                //Se agrega la pregunta.
		preguntas.agregarPreguntas(miPregunta);
		System.out.println("Pregunta agregada");
	}
        //Constructor de la nueva pregunta.
	public void ask(String titulo,String contenido, String autor,etiqueta miEtiqueta, int reputacion) {
		pregunta myPregunta = new pregunta(titulo, contenido, autor,miEtiqueta,preguntas.getTamano() + 1 ,reputacion);
		//Se agrega a la lista de preguntas.
                preguntas.agregarPreguntas(myPregunta);
	}
        /**
	* answer nos permite formular una respuesta con un usuario logeado.
	* Se solicita la pregunta a responder e indicar la respuesta.
 	* @author Dyllan Salgado
	*/
	public void answer() {
		@SuppressWarnings("resource")
		Scanner entradaEscaner = new Scanner(System.in);
		System.out.println(preguntas.preguntas2String1());
		System.out.println("Elija pregunta a responder");
		int x  = entradaEscaner.nextInt();
                //Si el indice de pregunta se excede muestra el mensaje fuera de rango.
		if (x<0 || x>=preguntas.getTamano()) {
			System.out.println("Indice fuera de rango");
                //Si no lo supera se selecciona y se puede responder.
		}else {
			System.out.println("Indique la respuesta");
			String respuestaString = "My answe";
			@SuppressWarnings("resource")
			Scanner entradaEscaner2 = new Scanner(System.in);
			respuestaString = entradaEscaner2.nextLine();
			pregunta miPregunta = preguntas.getPreguntaN(x);
			respuesta miRespuesta = new respuesta(respuestaString, ActivoUsuario.getNombreUsuario(), miPregunta.respuestas.getTamano()+1);
			preguntas.answerN(x,miRespuesta);
			System.out.println(miPregunta.respuestas.respuestas2String());
		}
	}
        //Constructor de la nueva respuesta.
	public void answer(int x,String respuesta , String autor) {
		pregunta miPregunta = preguntas.getPreguntaN(x);
		respuesta miRespuesta = new respuesta(respuesta, autor, miPregunta.respuestas.getTamano()+1);
		miPregunta.respuestas.agregarRespuesta(miRespuesta);
	}
        /**
	* reward nos permite entregar una recompensa a  una pregunta.
	* Se solicitan el indice de la pregunta a dar recompensa.
 	* @author Dyllan Salgado
	*/
	public void reward() {
		@SuppressWarnings("resource")
		Scanner entradaEscaner = new Scanner(System.in);
		System.out.println(preguntas.preguntas2String1());
		System.out.println("Elija pregunta para ofrecer recompensa");
		int x  = entradaEscaner.nextInt();
                //Si no existe el indice muestra fuera de rango.
		if (preguntas.getPreguntaN(x) == null) {
			System.out.println("Indice fuera de rango");}
                //Si esta en rango se asigna la recompensa a la pregunta.
		else {
			pregunta miPregunta = preguntas.getPreguntaN(x);
			int ok  = 0;
			while (ok == 0) {
				System.out.println("Indique cuanta recompensa quiere agregar");
				System.out.println("Su reputacion actual es : "+ ActivoUsuario.reputacionUsuario);
				x = entradaEscaner.nextInt();
                                //Si la reputacion es mayor a 0 se ve si puede dar recompensa
				if (x <= ActivoUsuario.getReputacionUsuario() && x > 0) {	
					int recompensaActual  =  miPregunta.recompensa;
                                        //Si la reputacion del usuario que ofrece recompensa es menor a lo que da muestra en pantalla el mensaje.
					if (x > ActivoUsuario.reputacionUsuario) {
						System.out.println("No tiene la reputacion necesaria para ofrecer recompensa");
                                        //Si es mayor puede darla sin problemas.
					}else if (recompensaActual>x) {
						System.out.println("Actualmente existe una recompensa mayor por esta pregunta");
                                        //Si no ofrece no pasa nada.       
					}else {
						miPregunta.autorRecompensa = ActivoUsuario.getNombreUsuario();
						miPregunta.recompensa = x;
						ok= 1;
						System.out.println("Recompensa actualizada");
					}
                                //Si la reputacion es igual a 0 no puede dar recompensa.      
				}else {
					System.out.println("La reputacion no es suficiente para ofrecer recompensa");
                                            ok=1;
				}
			}
		}
	}
        /**
	* accept permite a un usuario que genero la pregunta aceptar una respuesta a esta misma.
	* Solo el usuario que genero la pregunta puede aceptar respuestas a esta.
 	* @author Dyllan Salgado
	*/ 
	public void accept() {
		@SuppressWarnings("resource")
		Scanner entradaEscaner = new Scanner(System.in);
		System.out.println(preguntas.preguntas2String1());
		int x  = entradaEscaner.nextInt();
                //Se le pide que ingrese la pregunta a aceptar si se pasa del rango muestra el mensaje.
		if (preguntas.getPreguntaN(x) == null) {
			System.out.println("Indice fuera de rango");
		}
                //Si la pregunta ya esta marcada como respondida se avisa que esta respondida.
		else if (preguntas.getPreguntaN(x)!= null &&preguntas.getPreguntaN(x).estado == 1) {
			System.out.println("Esta pregunta ya esta respondida");
		}
                
		//Si el autor selecteado no es nulo y corresponde al que realizo la pregunta
		else if (preguntas.getPreguntaN(x)!= null &&preguntas.getPreguntaN(x).autorPregunta.equals(ActivoUsuario.nombreUsuario) ) {
			pregunta miPregunta  = preguntas.getPreguntaN(x);
                        //Si no hay respuestas en la pregunta se muestra el sgte mensaje.
			if(miPregunta.respuestas.isEmpty()) {
				System.out.println("No existen respuestas a esta pregunta");
                        //Si existen respuestas se pregunta cual quiere aceptar.
			}else {
				System.out.println(miPregunta.respuestas.respuestas2String());
				System.out.println("Eliga cual pregunta quiere aceptar");
				int y  = entradaEscaner.nextInt();
                                //Ingresa una respuesta fuera de indice.
				if (miPregunta.respuestas.getRespuestaN(y) == null) {
					System.out.println("Indice fuera de rango");
				}else {
                                    //Se le asignan los valores, si habia recompensa se dan y si la recompensa era 0 se le da 15 al usuario
                                    //que respondio y 2 al que acepto la respuesta.
                                    miPregunta.estado = 1 ;
                                    System.out.println("Respuesta aceptada");	
                                    usuario userRecompensa = usuarios.getUsuarioName(miPregunta.autorRecompensa);
                                    usuario userPregunta = usuarios.getUsuarioName(miPregunta.autorPregunta);
                                    usuario userRespuesta = usuarios.getUsuarioName(miPregunta.respuestas.getRespuestaN(y).getAutor());
                                    userRecompensa.reputacionUsuario = userRecompensa.reputacionUsuario - miPregunta.recompensa;
                                    userPregunta.reputacionUsuario = userPregunta.reputacionUsuario + 2;
                                    userRespuesta.reputacionUsuario = userRespuesta.reputacionUsuario + 15 + miPregunta.recompensa;
				}	
			}
                //Usuario logeado trata de aceptar respuestas que no son de su pregunta.
		}else {
			System.out.println("Usted no ha realizado la pregunta");
		}		
	}
        /**
	* agregarEtiqueta permite a un usuario crear nuevas etiquetas para el stack, 
        * estas pueden ser utilizadas por todos lo usuarios que esten registrados.
 	* @author Dyllan Salgado
	*/
	public void agregarEtiqueta() {
		@SuppressWarnings("resource")
                //Solicitamos el nombre de la etiqueta.        
		Scanner entradaEscaner = new Scanner(System.in);
		System.out.println("Ingrese nombre de Etiqueta");
		String nombre  = entradaEscaner.nextLine();
                //Si el nombre de etiqueta ya existe, muestra en pantalla que ya existe esa etiqueta.
		if (etiquetas.isInside(nombre) == true) {
			System.out.println("Ya existe una etiqueta con ese nombre");
		}
                //Si no existe el nombre, se debe ingresar una descripcion de esta misma y se añade.
		else {
			System.out.println("Ingrese descripcion sobre ella");
			String descripcion = entradaEscaner.nextLine();
			etiqueta myEtiqueta = new etiqueta(nombre,descripcion);
			etiquetas.agregarEtiquetas(myEtiqueta);
		}
	}
        //Constructor de la etiqueta nueva que se va a agregar.
	public void agregarEtiqueta(String nombre,String descripcion) {
		etiqueta myEtiqueta = new etiqueta(nombre,descripcion);
		etiquetas.agregarEtiquetas(myEtiqueta);
	}
	/**
	 * Funcion que muestra usuario
	 */
	public void mostrarUsuarios() {System.out.println(usuarios.usuarios2String());}
	public void mostrarPreguntas() {System.out.println(preguntas.preguntas2String());}
}