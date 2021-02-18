package lab4_20227250_SalgadoEspinoza;

/**
 * Una clase para representar la lista de etiquetas que contendrán las preguntas.
 * Se utiliza para agrupar todas las etiquetas en una lista.
 * @author Dyllan Salgado
 */

public class ListaDeEtiquetas {
        //Atributos de la clase ListaDeEtiqueta.
	nodoEtiqueta cabeza;
	int tamano;
        /**
        * Una clase para representar el nodo una lista, es por este motivo que esta en privado.
        * Se utilizan solo en las listas y nada mas.
        * @author Dyllan Salgado
        */
	private class nodoEtiqueta{
                //Atributos de la clase nodoEtiqueta.
		private etiqueta myEtiqueta;
		private nodoEtiqueta siguiente;
                //Constructor de la clase nodoEtiqueta.
		public nodoEtiqueta(etiqueta myEtiqueta) {
			this.setMyEtiqueta(myEtiqueta);
			setSiguiente(null);
		}
                //Selectores de la clase nodoEtiqueta.
		public nodoEtiqueta getSiguiente(){
                    return siguiente;
                }
                public etiqueta getMyEtiqueta() {
                    return myEtiqueta;
                }
                //Modificadores de la clase nodoEtiqueta.
		public void setSiguiente(nodoEtiqueta siguiente) {
                    this.siguiente = siguiente;
                }
		public void setMyEtiqueta(etiqueta myEtiqueta) {
                    this.myEtiqueta = myEtiqueta;
                }
	}
        //Metodos para trabajar con la ListaDeEtiquetas.
	public ListaDeEtiquetas() {}
        /**
	* Insertar la inicio de la lista
	* @param miEtiqueta corresponde a la etiqueta que se quiere agregar al inicio de la lista.
 	* @author Dyllan Salgado
	*/
	public void insertarPrincipio(etiqueta miEtiqueta){
		nodoEtiqueta nodo = new nodoEtiqueta(miEtiqueta);
		//EL siguiente elemento es la cabeza
		nodo.setSiguiente(cabeza);
		//Y la nueva cabeza es el nodo
		setCabeza(nodo);
		setTamano(tamano+1);
	}
        /**
	* Insertar una etiqueta al final de la lista
	* @param miEtiqueta etiqueta que se quiere agregar al final de la lista.
 	* @author Dyllan Salgado
	*/
	//Insertar al final
	public void insertarFinal(etiqueta miEtiqueta) {
		nodoEtiqueta etiqueta = new nodoEtiqueta(miEtiqueta);
		nodoEtiqueta puntero = getCabeza() ;
		//Mientras no llegemos al final del puntero
		while(puntero.siguiente !=null) {
			puntero = puntero.getSiguiente();}
		//Una vez llegado al final, asignamos el nuevo nodo
		puntero.setSiguiente(etiqueta);	
		setTamano(tamano +1);		
	}
	/**
	* Agregar una etiqueta a la lista de etiquetas.
	* @param miEtiqueta etiqueta que se quiere agregar a la lista.
 	* @author Dyllan Salgado
	*/
	public void agregarEtiquetas(etiqueta miEtiqueta) {
                //Si la lista esta vacia se ingresa al inicio.
		if (isEmpty()) {
			insertarPrincipio(miEtiqueta);
                //Si no al final.
		}else {
			insertarFinal(miEtiqueta);
		}
	}	
	/**
	* Método que consulta si una etiqueta se encuentra ya en la lista.
	* @param myEtiqueta que se va a comparar con el resto de las etiquetas, se compara solo el nombre.
	* @return Boolean true si se encuentra dentro, false si no se encuentra
 	* @author Dyllan Salgado
	*/
	public Boolean isInside(etiqueta myEtiqueta) {
		nodoEtiqueta puntero = getCabeza();
		while (puntero != null) {
			//Comparamos solo con el nombre
			if (myEtiqueta.getEtiqueta().equals(puntero.getMyEtiqueta().getEtiqueta())) {
				return true;
			}else {
				puntero = puntero.getSiguiente();	
			}	
		}
		return false;
	}
        /**
	* Método que consulta si una etiqueta se encuentra ya en la lista.
	* @param etiqueta que se va a comparar con el resto de las etiquetas, se compara solo el nombre.
	* @return Boolean true si se encuentra dentro, false si no se encuentra
 	* @author Dyllan Salgado
	*/
	public Boolean isInside(String etiqueta) {
		nodoEtiqueta puntero = getCabeza();
		while (puntero != null) {
			//Comparamos solo con el nombre
			if (etiqueta.equals(puntero.getMyEtiqueta().getEtiqueta())) {
				return true;
			}else {
				puntero = puntero.getSiguiente();	
			}	
		}
		return false;
	}
        /**
	* Devolver todos las etiquetas y su contenido en un string.
	* @return mensaje por pantalla o las etiquetas.
	*/
	public String etiquetas2String1() {
                //Si la lista es distinta de vacio se muestran.
		if (!isEmpty()) {
			nodoEtiqueta puntero =  getCabeza();
			String salidaString = "Etiquetas :";
                        //Se recorre la lista con un while y se va imprimiendo las etiqutas.
			while (puntero != null) {
				salidaString = salidaString + puntero.myEtiqueta.getEtiqueta() +" - ";
				puntero = puntero.getSiguiente();
			}
			return (salidaString +"\n");
                //Si la lista esta vacia no existen etiquetas.
		}else {
			return("No existen preguntas en el stack\n");
		}
	}
        /**
	* Devolver todos las etiquetas y su contenido en un string.
	* @return mensaje por pantalla o las preguntas.
	*/
	public String etiquetas2String2() {
                //Si la lista es distinta de vacio se muestran.
		if (!isEmpty()) {
			nodoEtiqueta puntero =  getCabeza();
			String salidaString = "Etiquetas realizadas : \n";
			int i = 0;
                        //Se recorre la lista con un while y se va imprimiendo las etiquetas.
			while (puntero != null) {
				salidaString = salidaString +"\n"+ i + ".-";
				salidaString = salidaString + puntero.myEtiqueta.getEtiqueta() + ":  " + puntero.myEtiqueta.getDescripcionEtiqueta() ;
				puntero = puntero.getSiguiente();
				i++;
			}
			return (salidaString +"\n");
                //Si la lista esta vacia no existen etiquetas.
		}else {
			return("\nNo existen etiquetas\n");
		}
	}
	
        /**
	* Metodo que dado un indice n, devuelva la etiqueta correspondiente en la lista
	* @param n, indice donde se encuentra la etiqueta.
	* @return miEtiqueta, etiqueta con el indice || null si el indice supera los limites
 	* @author Dyllan Salgado
	*/
	public etiqueta getEtiquetaN(int n){
		//Si el n ingresado no supera el tamano total de etiquetas.
		if (n > tamano || n < 0) {
			System.out.println("El indice excede al limite de archivos");
			return null;
		}else{
			nodoEtiqueta puntero =  getCabeza();
			int i = 0 ;
			//Mientras el puntero no sea nulo
			while (i < n && puntero != null) {
				puntero = puntero.getSiguiente();
				i++;
                        //Si es i es distinto de n no hay preguntas disponibles.
			}if (i!= n) {
				System.out.println("No hay archivos disponibles");
				return null;
			}else {
				//Creamos una etiqueta desde 0
				etiqueta miEtiqueta = new etiqueta(puntero.myEtiqueta.getEtiqueta(), puntero.myEtiqueta.getDescripcionEtiqueta());
				return miEtiqueta;
			}
		}
	}
	//Esta vaci­a la lista de etiquetas
	public Boolean isEmpty() {return tamano == 0;}
	//Selectores de la clase ListaDeEtiquetas.
	public nodoEtiqueta getCabeza() {return cabeza;}
        public int getTamano() {return tamano;}
        //Modificadores de la clase ListaDeEtiquetas.
	public void setCabeza(nodoEtiqueta cabeza) {this.cabeza = cabeza;}
	public void setTamano(int tamano) {this.tamano = tamano;}
}