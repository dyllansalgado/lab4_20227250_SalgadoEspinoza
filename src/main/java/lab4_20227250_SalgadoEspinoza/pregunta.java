package lab4_20227250_SalgadoEspinoza;

/**
 * Una clase para representar la pregunta.
 * Se utiliza esta clase para realizar las preguntas.
 * Los atributos de la clase es idPregunta,tituloPregunta,contenidoPregunta,fechaPublicacion,autorPregunta,estado,recompensa,
 * las lista con respuestas y la lista con etiquetas, autorRecompensa.
 * @author Dyllan Salgado
 */
public class pregunta {
        //Atributos de la clase pregunta.
	int idPregunta;
	String tituloPregunta;
	String contenidoPregunta;
	String fechaPublicacion;
	String autorPregunta;
	//Respuestas y Etiquetas
	ListaDeRespuestas respuestas;
	ListaDeEtiquetas etiquetas;
	int estado;
	int recompensa;
	String autorRecompensa;
        //Constructor de la pregunta sin recompensa.
	public pregunta(String tituloPregunta,String contenidoPregunta,String autor,etiqueta miEtiqueta,int id) {
		setTituloPregunta(tituloPregunta);
		setContenidoPregunta(contenidoPregunta);
		setAutorPregunta(autor);
		this.etiquetas = new ListaDeEtiquetas();
		this.etiquetas.agregarEtiquetas(miEtiqueta);
		setFechaPublicacion(tiempo.getActualTime());
		setIdPregunta(id);
		respuestas = new ListaDeRespuestas();
        }
        //Constructor de la pregunta con recompensas.
	public pregunta(String tituloPregunta,String contenidoPregunta,String autor,etiqueta miEtiqueta,int id,int recompensa) {
		setTituloPregunta(tituloPregunta);
		setContenidoPregunta(contenidoPregunta);
		setAutorPregunta(autor);
		this.etiquetas = new ListaDeEtiquetas();
		this.etiquetas.agregarEtiquetas(miEtiqueta);
		setFechaPublicacion(tiempo.getActualTime());
		setIdPregunta(id);
		setRecompensa(recompensa);
		respuestas = new ListaDeRespuestas();
	}
        /**
	* Metodo para transformar las preguntas en string
	* @return salidaString 
	*/
	public String pregunta2String() {
		String salidaString;
		salidaString = 
				"ID : " + (idPregunta-1) + 
				"\nTitulo : " + getTituloPregunta() +
				"\nContenido : "+ getContenidoPregunta() + 
				"\nFecha de Publicacion : " + getFechaPublicacion()+
				"\nAutor:" + getAutorPregunta()+
				"\nEstado: " + estado +
				"\nRecompensa : " + recompensa +
				respuestas.respuestas2String() +
				etiquetas.etiquetas2String1();
		return salidaString;
	}
        /**
	* Metodo para asignar una respuesta a una pregunta.
        * @param miRespuesta  es la respuesta que se asigna a la pregunta.
	*/
	public void answer(respuesta miRespuesta) {
		if (respuestas.getTamano() == 0) {
			respuestas = new ListaDeRespuestas() ;
			respuestas.agregarRespuesta(miRespuesta);
		}
		
	}
        //Selectores y modificares de la clase pregunta.
	public int getIdPregunta() {return idPregunta;}
	public void setIdPregunta(int idPregunta) {this.idPregunta = idPregunta;}
	public int getRecompensa() {return recompensa;}
	public void setRecompensa(int recompensa) {this.recompensa = recompensa;}
	public String getTituloPregunta() {return tituloPregunta;}
	public void setTituloPregunta(String tituloPregunta) {this.tituloPregunta = tituloPregunta;}
	public String getContenidoPregunta() {return contenidoPregunta;}
	public void setContenidoPregunta(String contenidoPregunta) {this.contenidoPregunta = contenidoPregunta;}
	public String getFechaPublicacion() {return fechaPublicacion;}
	public void setFechaPublicacion(String fechaPublicacion) {this.fechaPublicacion = fechaPublicacion;}
	public void setFechaPublicacion() {this.fechaPublicacion = tiempo.getActualTime();}
	public String getAutorPregunta() {return autorPregunta;}
	public void setAutorPregunta(String autorPregunta) {this.autorPregunta = autorPregunta;}
}
