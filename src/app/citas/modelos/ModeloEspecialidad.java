package app.citas.modelos;
import app.citas.vistas.VistaEspecialidad;

public class ModeloEspecialidad {
    
    // PROPIEDADES (CAMPOS DE LA TABLA DE LA BD)
    private int idEspecialidad;
    private String nombreEspecialidad;
    public VistaEspecialidad vista;
    
    
    // CONSTRUCTORES
    // Constructor Vacio
    public ModeloEspecialidad() {
    }
    
    public ModeloEspecialidad(VistaEspecialidad vista){
        this.vista = vista;
    }
    
    // Constructor con los campos del modelo, pero sin la PK
    public ModeloEspecialidad(String nombreEspecialidad) {
        this.nombreEspecialidad = nombreEspecialidad;
    }
    
    // Constructor con todo los campos
    public ModeloEspecialidad(int idEspecialidad, String nombreEspecialidad) {
        this.idEspecialidad = idEspecialidad;
        this.nombreEspecialidad = nombreEspecialidad;
    }
    
    // GET Y SET
    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public String getNombreEspecialidad() {
        return nombreEspecialidad;
    }

    public void setNombreEspecialidad(String nombreEspecialidad) {
        this.nombreEspecialidad = nombreEspecialidad;
    }

    public VistaEspecialidad getVista() {
        return vista;
    }

    public void setVista(VistaEspecialidad vista) {
        this.vista = vista;
    }
    
    

}
