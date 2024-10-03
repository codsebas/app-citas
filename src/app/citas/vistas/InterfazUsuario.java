/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.citas.vistas;

import app.citas.dao.EspecialidadDAO;
import app.citas.modelos.Especialidad;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author DanyB
 */
public class InterfazUsuario {
    
    EspecialidadDAO esp = new EspecialidadDAO();
    Scanner scanner = new Scanner(System.in);
    public void leerDatos() {
        List<Especialidad> especialidades = esp.getEspecialidades();
        for(Especialidad e: especialidades) {
            System.out.println(e.getIdEspecialidad() + " - " + e.getNombreEspecialidad());
        }
    }
    
    public void agregarEspecialidad() {
        System.out.println("INGRESE EL NOMBRE DE LA ESPECIALIDAD");
        String nombreEspecialidad = scanner.next();
        esp.addEspecialidad(nombreEspecialidad);
    }
    
    public void leerUnDato() {
        System.out.println("INGRESE EL ID A CONSULTAR");
        int pIdEspecialidad = scanner.nextInt();
        Especialidad especialidad = esp.getOneEspecialidad(pIdEspecialidad);
        if(especialidad.getIdEspecialidad() == 0) {
            System.out.println("NO SE ENCONTRARON DATOS PARA EL ID: " + pIdEspecialidad);
        } else {
            System.out.println("VALOR OBTENIDO: ID - " + especialidad.getIdEspecialidad() + ", NOMBRE - " + especialidad.getNombreEspecialidad());
        }
    }
    
    public void actualizar() {
        System.out.println("INGRESE EL ID A ACTUALIZAR");
        int pIdEspecialidad = scanner.nextInt();
        System.out.println("INGRESE EL NUEVO NOMBRE DE LA ESPECIALIDAD");
        String pNombreEspecialidad = scanner.next();
        esp.updateEspecialidad(pIdEspecialidad, pNombreEspecialidad);
    }
    
}
