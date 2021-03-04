package lab4_20227250_SalgadoEspinoza_modelo;
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

    public stack(){
        usuarios = new ListaDeUsuarios();	
        preguntas = new ListaDePreguntas();
        etiquetas = new ListaDeEtiquetas();
        ActivoUsuario = null;
    }
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
    * login nos permite logear a un usuario ya registrado en el stack.Se solicitan los datos nombre y clave para logearse.
    * @author Dyllan Salgado
    * @param inputUsuario se obtienen el nombre de usuario para realizar el logeo.
    * @param inputPassword se obtiene la pass de usuario para realizar el logeo.
    * @return 1 quiere decir que el nombre y clave es correcto y permite realizar el login, return 2 se ha equivocado en la clave
    * return 3 el nombre no existe en el stack de registrados.
    */
    public int login(String inputUsuario,String inputPassword){
	String user = inputUsuario;
	String pass = inputPassword;
	//Usuario temporal
	usuario miUsuario = new usuario(user, pass);
	//Si se encuentra el nombre de usuario registrado pasa lo siguiente.
	if(usuarios.isInside(miUsuario) == true) {
            //Si el nombre es correcto y la clave es correcta entrega 1.
            if (usuarios.correctPass(miUsuario) == true) {
		ActivoUsuario = usuarios.getUsuarioName(miUsuario.nombreUsuario);
                return 1;
            //Si la clave no es la correcta se retorna 2.
            }else {
                return 2;
            }
        //Si el nombre no existe retorna 3
	}else {
            return 3;
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
    * registrarUsuario nos permite registrar a un usuario en el stack
    * Se solicitan los datos nombre y clave para registrarse.Si el nombre ya existe se muestra en pantalla y vuelve a mostrar el menu.
    * @author Dyllan Salgado
    * @param inputUsuario se ingresa nombre de usuario para realizar registro.
    * @param inputPassword se ingresa clave de usuario para realizar registro.
    * @return true si es que se logra registrar correctamente. return false si el usuario se encuentra registrado. 
    */
    public boolean registrarUsuario(String inputUsuario,String inputPassword) {
        int x = 0;
        while (x==0) {
        //Se solicita el nombre de usuario.
            String nameUser = inputUsuario;
            usuario myUsuario= new usuario(nameUser, "") ; 
            //Preguntamos si el usuario ya se encuentra en la lista de usuarios
            if(usuarios.isInside(myUsuario) == false) {
                String passUser = inputPassword;
                myUsuario= new usuario(nameUser, passUser); 
                usuarios.agregarUsuario(myUsuario);
                x = 1;
                return true;
            //Si el usuario se encuentra entrega false.	
            }else {
                x = 1;
                return false;
            }
        }
        return false;
    }
    /**
     * Constructor del nuevo usuario registrado.
     * @param nameUser corresponde al nombre de usuario registrado.
     * @param password corresponde a la clave del usuario registrado.
     * @param reputacion corresponde a la reputacion que tiene el usuario registrado.
     */
    public void registrarUsuario(String nameUser,String password, int reputacion) {
        usuario myUsuario= new usuario(nameUser, password,reputacion); 
        //Se agrega a la lista de usuarios.
        usuarios.agregarUsuario(myUsuario);
    }
    /**
    * ask nos permite formular una pregunta con un usuario logeado.Se solicitan un titulo de pregunta, contenido y la etiqueta a agregar.
    * @author Dyllan Salgado
    * @param titulo es el titulo de la pregunta.
    * @param contenido contiene el contenido de la pregunta.
    * @param autor contiene al autor que ha realizado la pregunta.
    * @param miEtiqueta es la etiqueta que se ha seleccionado en la pregunta.
    * @param reputacion es la reputacion que tiene el usuario.
    */
    public void ask(String titulo,String contenido, String autor,etiqueta miEtiqueta, int reputacion) {
	pregunta myPregunta = new pregunta(titulo, contenido, autor,miEtiqueta,preguntas.getTamano() + 1 ,reputacion);
	//Se agrega a la lista de preguntas.
        preguntas.agregarPreguntas(myPregunta);
        //usuario miUsuario= usuarios.getUsuarioName(autor);
        //miUsuario.reputacionUsuario = miUsuario.reputacionUsuario-reputacion;
    }
    /**
    * answer nos permite formular una respuesta con un usuario logeado.Se solicita la pregunta a responder e indicar la respuesta.
    * @author Dyllan Salgado
    * @param x es la pregunta seleccionada.
    * @param respuesta corresponde a la respuesta que se ha creado.
    * @param autor es el autor de la pregunta.
    */
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
    public int reward(int inputPregunta,int inputRecompensa) {
        int pregunta = inputPregunta-1;
        int recompensa= inputRecompensa;
        //Si no existe el indice muestra fuera de rango.
        if (preguntas.getPreguntaN(pregunta) == null) {
            System.out.println("Indice fuera de rango");
            return 0;
        }
        //Si esta en rango se asigna la recompensa a la pregunta.
	else {
            pregunta miPregunta = preguntas.getPreguntaN(pregunta);
            int ok  = 0;
            while (ok == 0) {
		System.out.println("Indique cuanta recompensa quiere agregar");
		System.out.println("Su reputacion actual es : "+ ActivoUsuario.reputacionUsuario);
                //Si la reputacion es mayor a 0 se ve si puede dar recompensa
		if (recompensa <= ActivoUsuario.getReputacionUsuario() && recompensa > 0) {	
                    int recompensaActual  =  miPregunta.recompensa;
                    //Si la reputacion del usuario que ofrece recompensa es menor a lo que da muestra en pantalla el mensaje.
                    if (recompensa > ActivoUsuario.reputacionUsuario) {
			System.out.println("No tiene la reputacion necesaria para ofrecer recompensa");
                        return 1;
                    //Si es mayor puede darla sin problemas.
                    }else if (recompensaActual>recompensa) {
			System.out.println("Actualmente existe una recompensa mayor por esta pregunta");
                        return 2;
                    //Si no ofrece no pasa nada.
                    }else{
                        miPregunta.autorRecompensa = ActivoUsuario.getNombreUsuario();
                        miPregunta.recompensa = recompensa;
                        ok= 1;
                        System.out.println("Recompensa actualizada");
                        return 3;
                    }
                //Si la reputacion es igual a 0 no puede dar recompensa.      
		}else {
                    System.out.println("La reputacion no es suficiente para ofrecer recompensa");
                    ok=1;
                    return 4;
		}
            }
        return 5;
	}
    }
    /**
    * accept permite a un usuario que genero la pregunta aceptar una respuesta a esta misma.
    * Solo el usuario que genero la pregunta puede aceptar respuestas a esta.
    * @author Dyllan Salgado
    */ 
    public boolean accept(int inputNumeroRespuesta,int preguntaSeleccionada) {
	int numPregunta  = preguntaSeleccionada;
        int numRespuesta = inputNumeroRespuesta;
        pregunta miPregunta  = preguntas.getPreguntaN(numPregunta);
        respuesta miRespuesta = miPregunta.respuestas.getRespuestaN(numRespuesta);
        System.out.println("ID pregunta :  "+ numPregunta + " ID respuesta "+ numRespuesta + " Total de respuestas : " +  miPregunta.respuestas.getTamano());
        if ( miRespuesta != null) {
            miPregunta.estado = 1 ;
            System.out.println("Respuesta aceptada");	
            usuario userRecompensa = usuarios.getUsuarioName(miPregunta.autorRecompensa);
            usuario userPregunta = usuarios.getUsuarioName(miPregunta.autorPregunta);
            System.out.println(userRecompensa);
            System.out.println("me caigo aca?");
            usuario userRespuesta = usuarios.getUsuarioName(miPregunta.respuestas.getRespuestaN(numRespuesta).getAutor());
            System.out.println("me caigo acaaaaa?");
            userRecompensa.reputacionUsuario = userRecompensa.reputacionUsuario - miPregunta.recompensa;
            userPregunta.reputacionUsuario = userPregunta.reputacionUsuario + 2;
            userRespuesta.reputacionUsuario = userRespuesta.reputacionUsuario + 15 + miPregunta.recompensa;
            System.out.println(userPregunta.nombreUsuario);
            System.out.println(userRespuesta.nombreUsuario);
            return true;
        }
        
        else{
            System.out.println("ta mal");
            return false;
        }
    }  
    /**
    * agregarEtiqueta permite a un usuario crear nuevas etiquetas para el stack, 
    * estas pueden ser utilizadas por todos lo usuarios que esten registrados.
    * @author Dyllan Salgado
    */
    public int agregarEtiqueta(String nombreEtiqueta,String descripcionEtiqueta) {      
	String nombre  = nombreEtiqueta;
        //Si el nombre de etiqueta ya existe, muestra en pantalla que ya existe esa etiqueta.
	if (etiquetas.isInside(nombre) == true) {
            //System.out.println("Ya existe una etiqueta con ese nombre");
            return 1;
	}
        //Si no existe el nombre, se debe ingresar una descripcion de esta misma y se a�ade.
	else {
            //System.out.println("Ingrese descripcion sobre ella");
            String descripcion = descripcionEtiqueta;
            etiqueta myEtiqueta = new etiqueta(nombre,descripcion);
            etiquetas.agregarEtiquetas(myEtiqueta);
            return 2;
	}
    }
    
    //Constructor de la etiqueta nueva que se va a agregar.
    /*public void agregarEtiqueta(String nombre,String descripcion) {
	etiqueta myEtiqueta = new etiqueta(nombre,descripcion);
	etiquetas.agregarEtiquetas(myEtiqueta);
    }*/
    
    /**
    * Funcion que muestra usuario
    */
    public void mostrarUsuarios() {System.out.println(usuarios.usuarios2String());}
    public void mostrarPreguntas() {System.out.println(preguntas.preguntas2String());}
}