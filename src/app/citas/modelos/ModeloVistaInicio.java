
package app.citas.modelos;
import app.citas.vistas.VistaInicio;
/**
 *
 * @author sebas
 */
public class ModeloVistaInicio {
    
    public VistaInicio vista;

    public ModeloVistaInicio(VistaInicio vista) {
        this.vista = vista;
    }

    public VistaInicio getVista() {
        return vista;
    }

    public void setVista(VistaInicio vista) {
        this.vista = vista;
    }
    
    
}
