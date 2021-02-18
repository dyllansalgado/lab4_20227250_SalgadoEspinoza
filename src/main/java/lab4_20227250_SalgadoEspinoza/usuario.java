package lab4_20227250_SalgadoEspinoza;

/**
 * Una clase para representar al usuario.
 * Se utiliza esta clase para representar a los usuarios.
 * Los atributos de la clase es nombreUsuario, claveUsuario y reputacionUsuario.
 * @author Dyllan Salgado
 */
public class usuario {
        //Atributos de usuario.
	String nombreUsuario;
	String claveUsuario;
	int reputacionUsuario;
	//Constructor de la clase usuario
	public usuario(String nombreUsuario, String claveUsuario) {
            setClaveUsuario(claveUsuario);
            setNombreUsuario(nombreUsuario); 
        }
        //Constructor de la clase usuario
	public usuario(String nombreUsuario, String claveUsuario,int rep) {
            setClaveUsuario(claveUsuario);
            setNombreUsuario(nombreUsuario);  
        this.reputacionUsuario = rep;
        }
	//Selectores de la clase usuario
	public String getNombreUsuario() {
            return nombreUsuario;
        }	
	public String getClaveUsuario() {
            return claveUsuario;
        }	
	public int getReputacionUsuario() {
            return reputacionUsuario;
        }	
	//Modificadores de la clase usuario
	public void setNombreUsuario(String nombreUsuario) {
            this.nombreUsuario = nombreUsuario;
        }
	public void setClaveUsuario(String claveUsuario) {
            this.claveUsuario = claveUsuario;
        }
	public void setReputacionUsuario(int reputacionUsuario) {
            this.reputacionUsuario = reputacionUsuario;
        }
}
