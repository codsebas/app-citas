package app.citas.interfaces;
import app.citas.modelos.ModeloEspecialidad;
import javax.swing.table.DefaultTableModel;

public interface IEspecialidad {
    public boolean insertarEspecialidad(ModeloEspecialidad modelo);
    public boolean eliminarEspecialidad(String  codigoEstado);
    public boolean actualizarEspecialidad(ModeloEspecialidad modelo);
    public DefaultTableModel modeloTablaEspecialidad();
    public DefaultTableModel modeloTablaEspecialidad(int idEspecialidad);
    public ModeloEspecialidad mostrarEspecialidad(int idEspecialidad);
}
