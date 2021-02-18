package lab4_20227250_SalgadoEspinoza;

/**
 * Una clase para representar la lista de usuarios que contendrá el stack.
 * Se utiliza para agrupar todas los usuarios en una lista.
 * @author Dyllan Salgado
 */
public class ListaDeUsuarios {
        //Atributos de la clase ListaDePreguntas.
	private nodoUsuario cabeza = null;
	private int tamano;
        /**
        * Una clase para representar el nodo una lista, es por este motivo que esta en privado.
        * Se utilizan solo en las listas y nada mas.
        * @author Dyllan Salgado
        */
	private class nodoUsuario {
                //Atributos de la clase nodoUsuario.
		private usuario myUsuario;
		private nodoUsuario siguiente = null;
		//Constructor de la clase nodoUsuario.
		public nodoUsuario(usuario myUsuario) {
                    this.myUsuario = myUsuario;
                }
                //Selector de la clase nodoUsuario.
		public nodoUsuario getSiguiente() {
                    return siguiente;
                }
                //Modificadores de la clase nodoUsuario.
		public void setSiguiente(nodoUsuario siguienteUsuario) {
                    this.siguiente= siguienteUsuario;
                }
	}
	//Metodos para trabajar con la ListaDeUsuarios.
	public ListaDeUsuarios() {}
        /**
	* Insertar la inicio de la lista.
	* @param miUsuario corresponde al usuario que se quiere agregar al inicio de la lista.
 	* @author Dyllan Salgado
	*/
	public void insertarPrincipio(usuario miUsuario){
		nodoUsuario nodo = new nodoUsuario(miUsuario) ;
		//EL siguiente elemento es la cabeza
		nodo.setSiguiente(cabeza);
		//Y la nueva cabeza es el nodo
		setCabeza(nodo);
		setTamano(tamano+1);
	}
        /**
	* Insertar una etiqueta al final de la lista.
	* @param miUsuario etiqueta que se quiere agregar al final de la lista.
 	* @author Dyllan Salgado
	*/
	//Insertar al final
	public void insertarFinal(usuario miUsuario) {
		nodoUsuario usuario = new nodoUsuario(miUsuario);
		nodoUsuario puntero = getCabeza() ;
		//Mientras no llegemos al final del puntero
		while(puntero.siguiente !=null) {
			puntero = puntero.getSiguiente();}
		//Una vez llegado al final, asignamos el nuevo nodo
		puntero.setSiguiente(usuario);	
		setTamano(tamano +1);		
	}
	/**
	* Agregar un usuario a la lista de usuarios.
	* @param miUsuario etiqueta que se quiere agregar a la lista.
 	* @author Dyllan Salgado
	*/
	public void agregarUsuario(usuario miUsuario) {
                //Si la lista esta vacia se ingresa al inicio.
		if (isEmpty()) {
			insertarPrincipio(miUsuario);
                //Si no al final.
		}else {
			insertarFinal(miUsuario);
		}
	}	
	
	/**
	* Método que consulta si un usuario se encuentra ya en la lista.
	* @param myUsuario que se va a comparar con el resto de las usuarios, se compara solo el nombre.
	* @return Boolean true si se encuentra dentro, false si no se encuentra
 	* @author Dyllan Salgado
	*/
	public Boolean isInside(usuario myUsuario) {
		nodoUsuario puntero = getCabeza();
		while (puntero != null) {
			//Comparamos solo con el nombre
			if (myUsuario.getNombreUsuario().equals(puntero.myUsuario.getNombreUsuario())) {
				return true;
			}else {
				puntero = puntero.getSiguiente();	
			}	
		}
		return false;
	}
	/**
	* Metodo que consulta si la clave de un usuario corresponde al nombre de usuario dentro de la lista de Usuarios
	* @param myUsuario que se va a comparar con el resto de los usuarios, se compara solo el nombre y la clave para ver si están correctas.
	* @return Boolean true si se encuentra dentro, false si no se encuentra
	*/
	public Boolean correctPass(usuario myUsuario) {
		nodoUsuario puntero = getCabeza();
		while (puntero != null) {
			//Comparamos solo con el nombre
			if (myUsuario.getNombreUsuario().equals(puntero.myUsuario.getNombreUsuario())) {
				if (myUsuario.getClaveUsuario().equals(puntero.myUsuario.getClaveUsuario())) {
					return true;
				}
				return false;
			}else {
				puntero = puntero.getSiguiente();	
			}	
		}
		return false;
	}
	
	/**
	* Devolver todos los usuarios y su contenido en un string.
        * @return mensaje por pantalla.
	*/
	public String usuarios2String() {
		if (!isEmpty()) {
			nodoUsuario puntero =  getCabeza();
			String salidaString = "Usuarios registrados : ";
			int i = 0 ;
			while (puntero != null) {
				salidaString = salidaString +"\n"+ i + ".-";
				salidaString = salidaString + puntero.myUsuario.getNombreUsuario() + "  Rep  : " + puntero.myUsuario.reputacionUsuario;
				puntero = puntero.getSiguiente();
				i++;
			}
			return (salidaString +"\n");
		}else {
			return("Lista de usuarios vaci­a\n");
		}
	}
        /**
	* Metodo que dado un indice n, devuelva el usuario correspondiente en la lista.
	* @param n, indice donde se encuentra el usuario.
	* @return usuario, usuario con el indice || null si el indice supera los limites
 	* @author Dyllan Salgado
	*/
	public usuario getUsuarioN (int n) {
		//Si el n ingresado no supera el tamano total de archivos
		if (n > tamano || n < 0) {
			System.out.println("El indice excede al limite de usuarios");
			return null;
		}else{
			nodoUsuario puntero =  getCabeza();
			int i = 0 ;
			//Mientras el puntero no sea nulo
			while (i < n && puntero != null) {
				System.out.println(i+".-");
				puntero = puntero.getSiguiente();
				i++;
			}if (i!= n) {
				System.out.println("No hay usuarios disponibles");
				return null;
			}else {
				//Creamos un archivo desde 0
				return puntero.myUsuario;
			}
		}
	}
        /**
	* Metodo que dado un nombre, devuelva el usuario correspondiente en la lista.
	* @param nombre, nombre del usuario.
	* @return usuario con el nombre || null si el nombre supera los limites
 	* @author Dyllan Salgado
	*/
	public usuario getUsuarioName (String nombre) {
		nodoUsuario puntero =  getCabeza();
		//Mientras el puntero no sea nulo
		while (puntero != null) {
			if (puntero.myUsuario.nombreUsuario.equals(nombre)) {
				return puntero.myUsuario;
			}
			puntero = puntero.getSiguiente();
		}
		return null;
	}
	
	//Esta vaci­a la lista de usuarios.
	public Boolean isEmpty() {
            return tamano == 0;
        }
	//Selectores de la clase ListaDeUsuarios.
	public int getTamano() {
            return tamano;
        }
        public nodoUsuario getCabeza() {
            return cabeza;
        }
        //Modificadores de la clase ListaDeEtiquetas.
	public void setTamano(int tamano) {
            this.tamano = tamano;
        }
	public void setCabeza(nodoUsuario cabeza) {
            this.cabeza = cabeza;
        }
}
