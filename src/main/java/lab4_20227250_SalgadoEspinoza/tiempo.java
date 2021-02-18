package lab4_20227250_SalgadoEspinoza;
import java.text.SimpleDateFormat;
import java.util.Date; 
/**
 * Una clase para representar la fecha.
 * Se utiliza esta clase para las preguntas y respuestas.
 * Se usa para obtener el tiempo real del momento de generar respuestas y preguntas.
 * @author Dyllan Salgado
 */
public class tiempo {
	//Atributo de clase String
	private static String actualTime;
	/**
	 * Obtener el tiempo actual
	 * @return un string con el tiempo actualmente
	 */
	public static String getActualTime() {
		tiempo.setActualTime() ;
		return actualTime;
	}
	/**
	 * Actualizar el tiempo a actual
	 */
	public static void setActualTime() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		tiempo.actualTime = formato.format(date);
	}
}
