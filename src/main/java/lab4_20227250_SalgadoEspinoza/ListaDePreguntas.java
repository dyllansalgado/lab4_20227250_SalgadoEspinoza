package lab4_20227250_SalgadoEspinoza;

/**
 * Una clase para representar la lista de preguntas que contendrá el stack.
 * Se utiliza para agrupar todas las preguntas en una lista.
 * @author Dyllan Salgado
 */
public class ListaDePreguntas {
        //Atributos de la clase ListaDePreguntas.
	nodoPregunta cabeza;
	int tamano;
	/**
        * Una clase para representar el nodo una lista, es por este motivo que esta en privado.
        * Se utilizan solo en las listas y nada mas.
        * @author Dyllan Salgado
        */
	private class nodoPregunta{
                //Atributos de la clase nodoPregunta.
		private pregunta myPregunta;
		private nodoPregunta siguiente;
                //Constructor de la clase nodoPregunta.
		public nodoPregunta(pregunta myPregunta) {
			setMyPregunta(myPregunta);
			setSiguiente(null);
		}
                //Selectores de la clase nodoPregunta.
		public nodoPregunta getSiguiente() {return siguiente;}
                public pregunta getMyPregunta() {return myPregunta;}
                //Modificadores de la clase nodoPregunta.
		public void setSiguiente(nodoPregunta siguiente) {this.siguiente = siguiente;}
		public void setMyPregunta(pregunta myPregunta) {this.myPregunta = myPregunta;}	
	}
        //Metodos para trabajar con la ListaDePreguntas.
	public ListaDePreguntas() {}
        /**
	* Insertar la inicio de la lista.
	* @param miPregunta corresponde a la pregunta que se quiere agregar al inicio de la lista.
 	* @author Dyllan Salgado
	*/
	public void insertarPrincipio(pregunta miPregunta){
		nodoPregunta nodo = new nodoPregunta(miPregunta);
		//EL siguiente elemento es la cabeza
		nodo.setSiguiente(cabeza);
		//Y la nueva cabeza es el nodo
		setCabeza(nodo);
		setTamano(tamano+1);
	}
        /**
	* Insertar una etiqueta al final de la lista.
	* @param miPregunta etiqueta que se quiere agregar al final de la lista.
 	* @author Dyllan Salgado
	*/
	//Insertar al final
	public void insertarFinal(pregunta miPregunta) {
		nodoPregunta pregunta = new nodoPregunta(miPregunta);
		nodoPregunta puntero = getCabeza() ;
		//Mientras no llegemos al final del puntero
		while(puntero.siguiente !=null) {
			puntero = puntero.getSiguiente();}
		//Una vez llegado al final, asignamos el nuevo nodo
		puntero.setSiguiente(pregunta);	
		setTamano(tamano +1);		
	}
	/**
	* Agregar una pregunta a la lista de preguntas.
	* @param miPregunta etiqueta que se quiere agregar a la lista.
 	* @author Dyllan Salgado
	*/
	public void agregarPreguntas(pregunta miPregunta) {
                //Si la lista esta vacia se ingresa al inicio.
		if (isEmpty()) {
			insertarPrincipio(miPregunta);
                //Si no al final.
		}else {
			insertarFinal(miPregunta);
		}
	}	
	
	/**
	* Método que consulta si una pregunta se encuentra ya en la lista.
	* @param myPregunta que se va a comparar con el resto de las preguntas, se compara solo el titulo.
	* @return Boolean true si se encuentra dentro, false si no se encuentra
 	* @author Dyllan Salgado
	*/
	public Boolean isInside(pregunta myPregunta) {
		nodoPregunta puntero = getCabeza();
		while (puntero != null) {
			//Comparamos solo con el nombre
			if (myPregunta.getTituloPregunta().equals(puntero.getMyPregunta().getTituloPregunta())) {
				return true;
			}else {
				puntero = puntero.getSiguiente();	
			}	
		}
		return false;
	}
	
        /**
	* Devolver todos las preguntas y su contenido en un string.
	* @return mensaje por pantalla o las preguntas.
	*/
	public String preguntas2String() {
                //Si la lista es distinta de vacio se muestran.
		if (!isEmpty()) {
			nodoPregunta puntero =  getCabeza();
			String salidaString = "Preguntas realizadas : \n";
			int i = 0 ;
                        //Se recorre la lista con un while y se va imprimiendo las preguntas.
			while (puntero != null) {
				salidaString = salidaString +"\nPREGUNTA "+ i + ":\n";
				salidaString = salidaString + puntero.myPregunta.pregunta2String();
				puntero = puntero.getSiguiente();
				i++;
			}
			return (salidaString +"\n");
                //Si la lista esta vacia no existen preguntas.
		}else {
			return("No existen preguntas en el stack\n");
		}
	}
	/**
	* Devolver todos las preguntas y su contenido en un string.
	* @return mensaje por pantalla o las preguntas.
	*/
	public String preguntas2String1() {
                //Si la lista es distinta de vacio se muestran.
		if (!isEmpty()) {
			nodoPregunta puntero =  getCabeza();
			String salidaString = "Preguntas realizadas : \n";
			int i = 0 ;
                        //Se recorre la lista con un while y se va imprimiendo las preguntas.
			while (puntero != null) {
				salidaString = salidaString +"\n"+ i + ".-\n";
				salidaString = salidaString + puntero.myPregunta.getTituloPregunta();
				puntero = puntero.getSiguiente();
				i++;
			}
			return (salidaString +"\n");
                //Si la lista esta vacia no existen preguntas.
		}else {
			return("No existen preguntas en el stack\n");
		}
	}
	/**
	* Metodo que dado un indice n, devuelva la pregunta correspondiente en la lista
	* @param n, indice donde se encuentra la pregunta.
	* @return pregunta con el indice || null si el indice supera los limites
 	* @author Dyllan Salgado
	*/
	public pregunta getPreguntaN(int n){
		//Si el n ingresado no supera el tamano total de preguntas.
		if (n > tamano || n < 0) {
			System.out.println("El indice excede al limite de archivos");
			return null;
		}else{
			nodoPregunta puntero =  getCabeza();
			int i = 0 ;
			//Mientras el puntero no sea nulo
			while (i < n && puntero != null) {
				puntero = puntero.getSiguiente();
				i++;
			}if (i!= n) {
                                //Si es i es distinto de n no hay preguntas disponibles.
				System.out.println("No hay preguntas disponibles");
				return null;
			}else {
				return puntero.getMyPregunta();
			}
		}
	}
        /**
	* Metodo que dado un indice n devuelva la pregunta correspondiente en la lista para que sea respondida.
	* @param n, miRespuesta indice donde se encuentra la pregunta y respuesta.
 	* @author Dyllan Salgado
	*/
	public void answerN(int n,respuesta miRespuesta){
		nodoPregunta puntero =  getCabeza();
		int i = 0 ;
		//Mientras el puntero no sea nulo
		while (i < n && puntero != null) {
			puntero = puntero.getSiguiente();
			i++;
		}if (i!= n) {
			System.out.println("No hay preguntas disponibles");
		}else {
			puntero.myPregunta.answer(miRespuesta);
		}
	}
	//Esta vaci­a la lista de preguntas.
	public Boolean isEmpty() {
            return tamano == 0;
        }
	//Selectores de la clase ListaDeEtiquetas.
	public nodoPregunta getCabeza() {
            return cabeza;
        }
        public int getTamano() {
            return tamano;
        }
        //Modificadores de la clase ListaDeEtiquetas.
	public void setCabeza(nodoPregunta cabeza) {
            this.cabeza = cabeza;
        }
	public void setTamano(int tamano) {
            this.tamano = tamano;
        }
}

