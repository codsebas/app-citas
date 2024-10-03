/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app.citas;

import app.citas.dao.EspecialidadDAO;
import java.sql.Connection;
import java.util.List;
import app.citas.modelos.Especialidad;
import app.citas.vistas.InterfazUsuario;
import app.citas.vistas.VistaInicio;

/**
 *
 * @author DanyB
 */
public class AppCitas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       VistaInicio inicio = new VistaInicio();
       inicio.setVisible(true);
       
    }
    
    
}
