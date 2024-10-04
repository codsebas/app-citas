package app.citas.sql;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conector {

    // DEFINIR LAS PROPIEDADES DE LA CONEXIÓN
    private static final String CLASE = "com.mysql.jdbc.Driver";
    private final String HOST = "localhost";
    private final String USUARIO = "root";
    private final String CLAVE = "TitiGordo@00";
    private final String BASEDATOS = "db_citas";
    private final String URL;

    private Connection link;
    private PreparedStatement ps;

    
    public Conector() {
        this.URL = "jdbc:mysql://localhost:3306/db_citas?serverTimezone=UTC";
    }

    public void conectar() {
        try {
            Class.forName(CLASE).getDeclaredConstructor().newInstance();
            this.link = DriverManager.getConnection(this.URL, this.USUARIO, this.CLAVE);
            System.out.println("Conexion");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void desconectar() {
        try {
            this.link.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public PreparedStatement preparar(String sql) {
        try {
            ps = link.prepareStatement(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return ps;
    }

    public void mensaje(String mensaje, String titulo, int tipoMensaje) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, tipoMensaje);
    }

}
