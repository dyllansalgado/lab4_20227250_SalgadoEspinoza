import lab4_20227250_SalgadoEspinoza_modelo.*;
import vista.*;
import controlador.*;

public class Main {
    /**
    * Mostrar los comandos de StackOverflow
    * @param args
    */
    public static void main(String[] args) {
        Vista view = new Vista();
        //Creando usuarios
        
        //USUARIO 1
        String nameUser = "Dyllan";
        String passUser = "123";
        int reputacion = 10;
        //StackOverflow.registrarUsuario(nameUser,passUser,reputacion);
        stack StackOverflow = new stack(nameUser, passUser,reputacion);
        StackOverflow.logout();
        //USUARIO 2
        nameUser = "Diego";
        passUser = "diegito123";
        StackOverflow.registrarUsuario(nameUser,passUser,reputacion);
        //USUARIO 3
        nameUser = "Zapallo";
        passUser = "12345";
        StackOverflow.registrarUsuario(nameUser,passUser,reputacion);
        //USUARIO 4
        nameUser = "polka";
        passUser = "1";
        StackOverflow.registrarUsuario(nameUser,passUser,reputacion);
        //Registrar etiquetas
        StackOverflow.agregarEtiqueta("C#", "Lenguaje de programacion C#, desarrollado por Windows");
        StackOverflow.agregarEtiqueta("Python","Python el lengiaje mas popular del momento");
        StackOverflow.agregarEtiqueta("C", "nerd");
        StackOverflow.agregarEtiqueta("Unity", "GameDev");
        StackOverflow.agregarEtiqueta("Java", "javita");

        //Registrar Preguntas
        //Registrar preguntas y sus respuestas
        //PREGUNTA 1 : 
        StackOverflow.ask("Como agrego un elemento a una lista\n",
        "Hola gente, tengo una duda, no se como agregar un elemnto, soy nuevo en python\n", 
        "Dyllan",StackOverflow.etiquetas.getEtiquetaN(1),0);
        //PREGUNTA 2 :
        StackOverflow.ask("Como limito la velocidad\n",
        "Hola gente, tengo una duda, no se como limitar la velocidad de mi personaje\n", 
        "polka",StackOverflow.etiquetas.getEtiquetaN(3),0);
        StackOverflow.preguntas.getPreguntaN(1).autorRecompensa= "polka";
        //PREGUNTA 3:
        StackOverflow.ask("Commit\n","tengo una duda, no se hacer un commit\n", "Zapallo",StackOverflow.etiquetas.getEtiquetaN(2),0);
        //PREGUNTA 4:
        StackOverflow.ask("Programacion\n","tengo una duda, como hago un ciclo\n", "Zapallo",StackOverflow.etiquetas.getEtiquetaN(1),0);
        //PREGUNTA 5:
        StackOverflow.ask("Listas en C\n","tengo una duda, como hago una lista enlazada en C \n", "Zapallo",StackOverflow.etiquetas.getEtiquetaN(2),0);

        //RESPUESTA 1:
        StackOverflow.answer(1, 
        "Declara una variable float que sea la velociad maxima, en update que tenga un if que limite la velocidad maxima\n", 
        "Zapallo");
        //RESPUESTA 2:
        StackOverflow.answer(0, "Debes ocupar el metodo append \n", "polka");
        //RESPUESTA 3:
        StackOverflow.answer(2, "Debes abrir la consola ingresar git commit -m \n", "Dyllan");
        //RESPUESTA 4:
        StackOverflow.answer(2, "Debes instalar en la consola git primero y luego ingresar git clone, luego git commit -m \n", "polka");
        //RESPUESTA 5:
        StackOverflow.answer(1, "Debes buscar en la siguiente pagina www.holi.com\n", "Dyllan");
        //RESPUESTA 6:
        StackOverflow.answer(1, "Debes ingresar un if para que te limite la velocidad\n", "Diego");
        //RESPUESTA 7:
        StackOverflow.answer(3, "Dbes hacer un while y asignar el limite hasta que llegue i", "Diego");
        //RESPUESTA 8:
        StackOverflow.answer(3, "Con un ciclo for la haces mas simple\n", "Dyllan");
        //RESPUESTA 9:
        StackOverflow.answer(0, "Supongo que es similar que en java", "Diego");
        //RESPUESTA 10:
        StackOverflow.answer(0, "Mi respuesta es troll xD\n", "Zapallo");
        StackOverflow.preguntas.getPreguntaN(0).autorRecompensa= "Dyllan";

        //Iniciamos la ventana.
        Controlador control = new Controlador(view,StackOverflow);
        control.iniciar();
    }
}
