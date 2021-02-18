package lab4_20227250_SalgadoEspinoza;
/**
 * Una clase para representar la lista de Respuestas que contendrán las preguntas.
 * Se utiliza para agrupar todas las respuestas en una lista.
 * @author Dyllan Salgado
 */
public class ListaDeRespuestas {
        //Atributos de la clase ListaDeRespuestas.
	private nodoRespuesta cabeza = null;
	private int tamano;
        /**
        * Una clase para representar el nodo una lista, es por este motivo que esta en privado.
        * Se utilizan solo en las listas y nada mas.
        * @author Dyllan Salgado
        */
	private class nodoRespuesta {
                //Atributos de la clase nodoRespuesta.
		private respuesta myRespuesta;
		private nodoRespuesta siguiente = null;
		//Constructor de la clase nodoRespuesta.
		public nodoRespuesta(respuesta miRespuesta) {
			myRespuesta = miRespuesta;
			siguiente = null;
		}
                //Selectores de la clase nodoRespuesta.
		public nodoRespuesta getSiguiente() { 
                    return siguiente;
                }
                //Modificadores de la clase nodoRespuesta.
		public void setSiguiente(nodoRespuesta siguiente) {
                    this.siguiente = siguiente;
                }
	}
	//Metodos para trabajar con la ListaDeRespuestas.
	public ListaDeRespuestas() {}
        /**
	* Insertar la inicio de la lista
	* @param miRespuesta corresponde a la respuesta que se quiere agregar al inicio de la lista.
 	* @author Dyllan Salgado
	*/
	public void insertarPrincipio(respuesta miRespuesta){
		nodoRespuesta nodo = new nodoRespuesta(miRespuesta);
		//EL siguiente elemento es la cabeza
		nodo.setSiguiente(cabeza);
		//Y la nueva cabeza es el nodo
		setCabeza(nodo);
		setTamano(tamano+1);
	}
        /**
	* Insertar una respuesta al final de la lista
	* @param miRespuesta respuesta que se quiere agregar al final de la lista.
 	* @author Dyllan Salgado
	*/
	//Insertar al final
	public void insertarFinal(respuesta miRespuesta) {
		nodoRespuesta respuesta= new nodoRespuesta(miRespuesta);
		nodoRespuesta puntero = getCabeza() ;
		//Mientras no llegemos al final del puntero
		while(puntero.siguiente !=null) {
			puntero = puntero.getSiguiente();}
		//Una vez llegado al final, asignamos el nuevo nodo
		puntero.setSiguiente(respuesta);	
		setTamano(tamano +1);		
	}
	/**
	* Agregar una respuesta a la lista de respuestas.
	* @param miRespuesta etiqueta que se quiere agregar a la lista.
 	* @author Dyllan Salgado
	*/
	public void agregarRespuesta(respuesta miRespuesta) {
                //Si la lista esta vacia se ingresa al inicio.
		if (isEmpty()) {
			insertarPrincipio(miRespuesta);
                //Si no al final.
		}else {
			insertarFinal(miRespuesta);
		}
	}	
        /**
	* Devolver todos las respuestas y su contenido en un string.
	* @return mensaje por pantalla o las respuestas.
	*/
	public String respuestas2String() {
                //Si la lista es distinta de vacio se muestran.
		if (!isEmpty()) {
			nodoRespuesta puntero =  getCabeza();
			String salidaString = "\n\nRespuestas realizadas : ";
			int i = 0 ;
                        //Se recorre la lista con un while y se va imprimiendo las etiqutas.
			while (puntero != null) {
				salidaString = salidaString+"\n\n" + i + ".-";
				salidaString = salidaString + puntero.myRespuesta.respuesta2String();
				puntero = puntero.getSiguiente();
				i++;
			}
			return (salidaString +"\n");
                //Si la lista esta vacia no existen respuestas.
		}else {
			return("\nNo existen respuestas a esta pregunta\n");
		}
	}
	/**
	* Metodo que dado un indice n, devuelva la respuesta correspondiente en la lista.
	* @param n, indice donde se encuentra la respuesta.
	* @return respuesta con el indice || null si el indice supera los limites
 	* @author Dyllan Salgado
	*/
	public respuesta getRespuestaN(int n) {
		//Si el n ingresado no supera el tamano total de archivos
		if (n > tamano || n < 0) {
			System.out.println("El indice excede al limite de respuestas");
			return null;
		}else{
			nodoRespuesta puntero =  getCabeza();
			int i = 0 ;
			//Mientras el puntero no sea nulo
			while (i < n && puntero != null) {
				System.out.println(i+".-");
				puntero = puntero.getSiguiente();
				i++;
			}if (i!= n) {
                                //Si es i es distinto de n no hay preguntas disponibles.
				System.out.println("No hay respuestas disponibles");
				return null;
			}else {
				//Creamos lista de respuestas desde 0
				return puntero.myRespuesta;
			}
		}
		
	}
	
	//Esta vaci­a la lista de respuestas
	public Boolean isEmpty() {
            return tamano == 0;
        }
	//Selectores de la clase ListaDeRespuestas.
	public int getTamano() {
            return tamano;
        }
        public nodoRespuesta getCabeza() {
            return cabeza;
        }
        //Modificadores de la clase ListaDeEtiquetas.
	public void setTamano(int tamano) {
            this.tamano = tamano;
        }
	public void setCabeza(nodoRespuesta cabeza) {
            this.cabeza = cabeza;
        }
}