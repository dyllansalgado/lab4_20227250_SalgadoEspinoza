package lab4_20227250_SalgadoEspinoza;

/**
 * Una clase para representar la respuesta.
 * Se utiliza esta clase para realizar las respuestas de las preguntas.
 * Los atributos de la clase es contenido,autor,fechaDeSubida y el id.
 * @author Dyllan Salgado
 */
public class respuesta {
        //Atributos de la clase respuesta.
	private String contenido;
	private String autor;
	private String fechaDeSubida;
	private int id;
        //Constructor de la respuesta.
	public respuesta(String respuesta,String autor,int id) {
		setContenido(respuesta);
		setAutor(autor);
		setId(id);
		setFechaDeSubida(tiempo.getActualTime());
	}
                /**
	* Metodo para transformar las respuestas en string
	* @return salidaString 
	*/
	public String respuesta2String() {
		String salidaString = "ID : " + (id-1) 
				+ "\nAutor : " + autor 
				+ "\nRespuesta : " +contenido 
				+ "\nFecha de publicacion : " + fechaDeSubida + "\n";
		return salidaString;
	}
        //Selectores y modificares de la clase respuesta.
	public String getContenido() {return contenido;}
	public void setContenido(String contenido) {this.contenido = contenido;}
	public String getAutor() {return autor;}
	public void setAutor(String autor) {this.autor = autor;}
	public String getFechaDeSubida() {return fechaDeSubida;}
	public void setFechaDeSubida(String fechaDeSubida) {this.fechaDeSubida = fechaDeSubida;}
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}

}