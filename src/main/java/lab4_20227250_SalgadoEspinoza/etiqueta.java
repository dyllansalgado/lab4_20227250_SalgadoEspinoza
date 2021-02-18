package lab4_20227250_SalgadoEspinoza;

/**
 * Una clase para representar la etiqueta para las preguntas.
 * Se utiliza esta clase para saber a que area de informacion va enfocada la pregunta.
 * Los atributos de la clase es nombre de la etiqueta y una descripción de esta misma.
 * @author Dyllan Salgado
 */
public class etiqueta {
    //Atributos de la clase etiqueta.
    String etiqueta;
    String descripcionEtiqueta;
    //Constructor para la clase etiqueta.
    public etiqueta(String etiqueta, String descripcionEtiqueta) {
        this.etiqueta = etiqueta;
        this.descripcionEtiqueta = descripcionEtiqueta;   
    }
    //Selectores para la clase etiqueta.
    public String getEtiqueta(){
        return etiqueta;
    }
    public String getDescripcionEtiqueta(){
        return descripcionEtiqueta;
    }
    //Modificadores para la clase etiqueta.
    public void setDescripcionEtiqueta(String descripcionEtiqueta){
        this.descripcionEtiqueta = descripcionEtiqueta;
    }
    public void setEtiqueta(String etiqueta){
        this.etiqueta = etiqueta;
    }
}
