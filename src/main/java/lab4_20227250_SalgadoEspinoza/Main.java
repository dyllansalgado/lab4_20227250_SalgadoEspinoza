package lab4_20227250_SalgadoEspinoza;
import java.util.Scanner;
public class Main {
	/**
	 * Mostrar los comandos de StackOverflow
	 * @param args
	 */
	public static void main(String[] args) {	
            //Creando usuarios
            Scanner entradaEscaner = new Scanner(System.in);
            //USUARIO 1
            String nameUser = "Dyllan";
            String passUser = "123";
            int reputacion = 100;
            stack myStack = new stack(nameUser, passUser,reputacion);
            myStack.logout();
            //USUARIO 2
            nameUser = "Diego";
            passUser = "diegito123";
            myStack.registrarUsuario(nameUser,passUser,reputacion);
            //USUARIO 3
            nameUser = "Zapallo";
            passUser = "12345";
            myStack.registrarUsuario(nameUser,passUser,reputacion);
            //USUARIO 4
            nameUser = "polka";
            passUser = "1";
            myStack.registrarUsuario(nameUser,passUser,reputacion);
            //Registrar etiquetas
            myStack.agregarEtiqueta("C#", "Lenguaje de programacion C#, desarrollado por Windows");
            myStack.agregarEtiqueta("Python","Python el lengiaje mas popular del momento");
            myStack.agregarEtiqueta("C", "nerd");
            myStack.agregarEtiqueta("Unity", "GameDev");
            myStack.agregarEtiqueta("Java", "javita");
            //Registrar preguntas y sus respuestas
                
            //PREGUNTA 1 : 
            myStack.ask("Como agrego un elemento a una lista\n",
            "Hola gente, tengo una duda, no se como agregar un elemnto, soy nuevo en python\n", 
            "Dyllan",myStack.etiquetas.getEtiquetaN(1),0);
            myStack.preguntas.getPreguntaN(0).autorRecompensa= "Dyllan";
            //PREGUNTA 2 :
            myStack.ask("Como limito la velocidad\n",
            "Hola gente, tengo una duda, no se como limitar la velocidad de mi personaje\n", 
            "polka",myStack.etiquetas.getEtiquetaN(3),0);
            myStack.preguntas.getPreguntaN(1).autorRecompensa= "polka";
            //PREGUNTA 3:
            myStack.ask("Commit\n","tengo una duda, no se hacer un commit\n", "Zapallo",myStack.etiquetas.getEtiquetaN(2),0);
            //PREGUNTA 4:
            myStack.ask("Programacion\n","tengo una duda, como hago un ciclo\n", "Zapallo",myStack.etiquetas.getEtiquetaN(1),0);
            //PREGUNTA 5:
            myStack.ask("Listas en C\n","tengo una duda, como hago una lista enlazada en C \n", "Zapallo",myStack.etiquetas.getEtiquetaN(2),0);
                
            //RESPUESTA 1:
            myStack.answer(1, 
            "Declara una variable float que sea la velociad maxima, en update que tenga un if que limite la velocidad maxima\n", 
            "Zapallo");
            //RESPUESTA 2:
            myStack.answer(0, "Debes ocupar el metodo append \n", "polka");
            //RESPUESTA 3:
            myStack.answer(2, "Debes abrir la consola ingresar git commit -m \n", "Dyllan");
            //RESPUESTA 4:
            myStack.answer(2, "Debes instalar en la consola git primero y luego ingresar git clone, luego git commit -m \n", "polka");
            //RESPUESTA 5:
            myStack.answer(1, "Debes buscar en la siguiente pagina www.holi.com\n", "Dyllan");
            //RESPUESTA 6:
            myStack.answer(1, "Debes ingresar un if para que te limite la velocidad\n", "Diego");
            //RESPUESTA 7:
            myStack.answer(3, "Dbes hacer un while y asignar el limite hasta que llegue i", "Diego");
            //RESPUESTA 8:
            myStack.answer(3, "Con un ciclo for la haces mas simple\n", "Dyllan");
            //RESPUESTA 9:
            myStack.answer(0, "Supongo que es similar que en java", "Diego");
            //RESPUESTA 10:
            myStack.answer(0, "Mi respuesta es troll xD\n", "Zapallo");
            int x = -1;
            while(x == -1){
                try{
                    entradaEscaner = new Scanner (System.in);
                    System.out.println("### SISTEMA DE PREGUNTAS Y RESPUESTAS ###\n ");
                    System.out.println(myStack.activoUsuario2String());
                    System.out.println( "\nEscoja una opcion:\n"
                    + "1.   Registrar Usuario\n"
                    + "2.   Logear Usuario\n"
                    + "3.   Crear etiqueta\n" 
                    + "4.   Realizar pregunta\n"
                    + "5.   Realizar respuesta\n"
                    + "6.   Ofrecer recompensa \n"
                    + "7.   Aceptar respuesta\n"
                    + "8.   Cerrar sesion\n"
                    + "9.   Cerrar aplicacion\n"
                    + "10.  Mostrar usuarios \n"
                    + "11.  Mostrar preguntas \n"
                    + "12.  Mostrar etiquetas \n"
                    +"Su opcion es:"
                    + " _\n");
                    x = entradaEscaner.nextInt();
                    switch(x){
                        case 1:{
                            try {
          			myStack.registrarUsuario();
                            } catch (Exception e) {
				System.out.println(e);
                            }
          		x = -1;
          		break;
                        }
                        case 2:{
                            try {
				myStack.login();
                            } catch (Exception e) {
				}
          		x = -1;
          		break;
          	}
          	case 3:{
          		try {
          			if (myStack.ActivoUsuario != null) {
						myStack.agregarEtiqueta();
					}
				} catch (Exception e) {
				}
          		
          		x = -1;
          		break;
          	}
          	case 4:{   
          		try {
          			if (myStack.ActivoUsuario != null) {
						myStack.ask();
					}
				} catch (Exception e) {
					System.out.println(e);
				}
          		x = -1;
          		break;
          	}
          	case 5:{
          		try {
          			if (myStack.ActivoUsuario != null) {
						myStack.answer();
					}					
				} catch (Exception e) {
					// TODO: handle exception
				}
          		x = -1;
          		break;
          	}
          	case 6:{
          		try {
          			if (myStack.ActivoUsuario != null) {
          				if (myStack.ActivoUsuario.reputacionUsuario !=0) {
          					myStack.reward();
						}else {
							System.out.println("Usted no tiene reputacion necesaria para ofrecer recompensas");
						}
						
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
          		x = -1;
          		break;
          	}
          	case 7:{
      			if (myStack.ActivoUsuario != null) {
      				myStack.accept();
				}
          		x = -1;
          		break;
          	}
          	case 8:{
          		myStack.logout();
          		x = -1;
          		break;
          	}
          	case 9:{
          		x= 3;
          		break;
          	}
          	case 10:{
          		myStack.mostrarUsuarios();
          		x = -1;
          		break; 
		    }
        	case 11:{
          		myStack.mostrarPreguntas();
          		x = -1;
          		break; 
		    }
        	case 12:{
        		System.out.println(myStack.etiquetas.etiquetas2String2()); 
        		x = -1;
        	}
          	default :{
          		System.out.println("Ingrese una opcion valida\n");
                        x=-1;
    		  	break;
            }
        }
      }catch (Exception s){
      System.out.println("Algo salio mal" + s);
	  }
    }
    entradaEscaner.close();
  }
}

