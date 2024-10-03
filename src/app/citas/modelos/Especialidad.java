/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.citas.modelos;

/**
 *
 * @author DanyB
 */
public class Especialidad {
    
    // PROPIEDADES (CAMPOS DE LA TABLA DE LA BD)
    private int idEspecialidad;
    private String nombreEspecialidad;
    
    // CONSTRUCTORES
    // Constructor Vacio
    public Especialidad() {
    }
    
    // Constructor con los campos del modelo, pero sin la PK
    public Especialidad(String nombreEspecialidad) {
        this.nombreEspecialidad = nombreEspecialidad;
    }
    
    // Constructor con todo los campos
    public Especialidad(int idEspecialidad, String nombreEspecialidad) {
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

}
