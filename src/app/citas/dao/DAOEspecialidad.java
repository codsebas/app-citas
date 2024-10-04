package app.citas.dao;
import app.citas.interfaces.IEspecialidad;
import app.citas.modelos.ModeloEspecialidad;
import app.citas.sql.QuerysEspecialidad;
import app.citas.sql.Conector;

import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOEspecialidad implements IEspecialidad{
    
    Conector conector = new Conector();
    QuerysEspecialidad sql = new QuerysEspecialidad();
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public boolean insertarEspecialidad(ModeloEspecialidad modelo) {
        boolean resultado = true;
        conector.conectar();
        ps = conector.preparar(sql.getINSERTAR_ESPECIALIDAD());

        try {
            ps.setString(1, modelo.getNombreEspecialidad());
            return ps.execute();
        } catch (SQLException ex) {
            conector.mensaje("Error en la insersción", "Error", 1);
            return resultado;
        }
    }

    @Override
    public boolean eliminarEspecialidad(String codigoEspecialidad) {
        boolean resultado = true;
        conector.conectar();

        try {
            ps = conector.preparar(sql.getELIMINAR_ESPECIALIDAD());
            ps.setInt(1, Integer.parseInt(codigoEspecialidad));
            return ps.execute();
        } catch (SQLException ex) {
            conector.mensaje("Error al eliminar", "Error", 1);
            return resultado;
        }
    }

    @Override
    public boolean actualizarEspecialidad(ModeloEspecialidad modelo) {
        boolean resultado = true;
        conector.conectar();
        ps = conector.preparar(sql.getACTUALIZAR_ESPECIALIDAD());
        
        try {
            ps.setString(1, modelo.getNombreEspecialidad());
            ps.setInt(2, modelo.getIdEspecialidad());
            resultado = ps.execute();
        } catch (SQLException ex) {
            conector.mensaje(ex.getMessage(), "Error al actualizar", 1);
        }
        return resultado;
    }

    @Override
    public DefaultTableModel modeloTablaEspecialidad() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"Id", "Especialidad"});
        conector.conectar();

        try {
            ps = conector.preparar(sql.getSELECCIONAR_ESPECIALIDADES());
            System.out.println(ps);
            rs = ps.executeQuery();

            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getString("id_especialidad"),
                    rs.getString("nombre_especialidad")
                });
            }
            conector.desconectar();

        } catch (SQLException ex) {
            conector.mensaje(ex.getMessage(), "Error", 1);
            conector.desconectar();
        }
        return modelo;
    }

    @Override
    public DefaultTableModel modeloTablaEspecialidad(int idEspecialidad) {
         DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"Codigo", "Descripcion"});
        conector.conectar();

        try {
            ps = conector.preparar(sql.getSELECCIONAR_ESPECIALIDADES());
            ps.setInt(1, idEspecialidad);
            rs = ps.executeQuery();

            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getString("id_especialidad"),
                    rs.getString("nombre_especialidad")
                });
            }
            conector.desconectar();

        } catch (SQLException ex) {
            conector.mensaje("trono aqui", "error", 1);
            conector.mensaje(ex.getMessage(), "Error", 1);
            conector.desconectar();
        }
        return modelo;
    }

    @Override
    public ModeloEspecialidad mostrarEspecialidad(int idEspecialidad) {
        ModeloEspecialidad modelo = new ModeloEspecialidad();
        conector.conectar();

        try {
            ps = conector.preparar(sql.getSELECCIONAR_ESPECIALIDAD());
            ps.setInt(1, idEspecialidad);
            System.out.println(ps);
            rs = ps.executeQuery();

            while (rs.next()) {
                modelo.setIdEspecialidad(Integer.parseInt(rs.getString(1)));
                modelo.setNombreEspecialidad(rs.getString(2));
            }
            conector.desconectar();

        } catch (SQLException ex) {
            conector.mensaje(ex.getMessage(), "Error", 1);
            conector.desconectar();
        }
        return modelo;
    }
    
}
