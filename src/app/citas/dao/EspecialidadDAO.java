/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.citas.dao;

import app.citas.DBConnection;
import java.sql.Connection;
import java.util.List;

import app.citas.modelos.Especialidad;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author DanyB
 */
public class EspecialidadDAO {
    
    // Establecer la conexión con la BD
    Connection conn = DBConnection.getConnection();
    
    // OBTENER LOS DATOS - LECTURA DE DATOS
    public List<Especialidad> getEspecialidades() {
        
        List<Especialidad> especialidades = new ArrayList<>();
        
        String sql = "select * from especialidad";
        
        try {
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
                
                int idEspecialidad = rs.getInt("id_especialidad");
                String nombreEspecialidad = rs.getString("nombre_especialidad");
                
                Especialidad especialidad = new Especialidad(idEspecialidad, nombreEspecialidad);
                
                especialidades.add(especialidad);
                
            }

        } catch (Exception e) {
            System.out.println("Error getEspecialidades: " + e.getMessage());
        }
        
        return especialidades;
        
    }
    
    // AGREGAR UNA NUEVA ESPECIALIDAD
    public void addEspecialidad(String nombreEspecialidad) {
    
        // DEFINIR LA SENTENCIA DE SQL PARA HACER INSERTAR EN LA TABLA
        String sql = "insert into especialidad (nombre_especialidad) values (?)";
        
        try {
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, nombreEspecialidad);
            
            stmt.executeUpdate();
            
            System.out.println("ESPECIALIDAD AGREGADA");
            
        } catch (Exception e) {
            System.out.println("Error addEspecialidad: " + e.getMessage());
        }
        
    }
    
    // OBTENER UNA ESPECIALIDAD SEGÚN UN PARÁMETRO
    public Especialidad getOneEspecialidad(int pIdEspecialidad) {
        
        Especialidad especialidad = new Especialidad();
        
        String sql = "select * from especialidad where id_especialidad = ?";
        
        try {
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, pIdEspecialidad);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
                
                int idEspecialidad = rs.getInt("id_especialidad");
                String nombreEspecialidad = rs.getString("nombre_especialidad"); 
                
                especialidad.setIdEspecialidad(idEspecialidad);
                especialidad.setNombreEspecialidad(nombreEspecialidad);
                
            }

        } catch (Exception e) {
            System.out.println("Error getOneEspecialidad: " + e.getMessage());
        }
        
        return especialidad;
        
    }
    
    // ACTUALIZAR UNA ESPECIALIDAD
    public void updateEspecialidad(int pIdEspecialidad, String pNombreEspecialidad) {
    
        String sql = "update especialidad set nombre_especialidad = ? where id_especialidad = ?";
        
        try {
            
            // BUSCAR LA ESPECIALIDAD
            Especialidad especialidadBD = this.getOneEspecialidad(pIdEspecialidad);
            
            if(especialidadBD.getIdEspecialidad() != 0) {
                
                PreparedStatement stmt = conn.prepareStatement(sql);
                
                stmt.setString(1, pNombreEspecialidad);
                stmt.setInt(2, pIdEspecialidad);
                
                stmt.executeUpdate();
            
                System.out.println("ESPECIALIDAD ACTUALIZADA");
                
            } else {
                
                System.out.println("LA ESPECIALIDAD A ACTUALIZAR NO EXISTE");
                
            }
            
        } catch (Exception e) {
            System.out.println("Error updateEspecialidad: " + e.getMessage());
        }
        
    }
    
    
}
