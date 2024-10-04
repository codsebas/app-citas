/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.citas.controlador;

import app.citas.dao.DAOEspecialidad;
import app.citas.modelos.ModeloEspecialidad;
import app.citas.vistas.VistaInicio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.WindowListener;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author sebas
 */
public class ControladorEspecialidad implements ActionListener, WindowListener, MouseListener {

    ModeloEspecialidad modelo;
    DAOEspecialidad dao = new DAOEspecialidad();

    public ControladorEspecialidad(ModeloEspecialidad modelo) {
        this.modelo = modelo;
    }

    String mensajeConfirmacion = "La operacion  se realizó exitosamente";
    String mensajeError = "La operacion no se realizó exitosamente";
    String titulo = "Aviso!";

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(modelo.getVista().btnGuardar.getActionCommand())) {
            boolean resultado;
            if (modelo.getVista().txtEspecialidad.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Error", "Datos no válidos", 1);
            } else {
                ModeloEspecialidad modelo = new ModeloEspecialidad();
                modelo.setNombreEspecialidad(this.modelo.getVista().txtEspecialidad.getText());
                resultado = dao.insertarEspecialidad(modelo);
                if (!resultado) {
                    JOptionPane.showMessageDialog(null, mensajeConfirmacion, titulo, JOptionPane.INFORMATION_MESSAGE);
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, mensajeError, titulo, JOptionPane.INFORMATION_MESSAGE);
                }
            }

            modelo.getVista().tblEspecialidades.setModel(dao.modeloTablaEspecialidad());

        } else if (e.getActionCommand().equals(modelo.getVista().btnActualizar.getActionCommand())) {
            boolean resultado;
            if (modelo.getVista().txtIdEspecialidad.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Error", "Datos no válidos", 1);
            } else {
                ModeloEspecialidad modelo = new ModeloEspecialidad();
                modelo.setIdEspecialidad(Integer.parseInt(this.modelo.getVista().txtIdEspecialidad.getText()));
                modelo.setNombreEspecialidad(this.modelo.getVista().txtEspecialidad.getText());
                resultado = dao.actualizarEspecialidad(modelo);
                if (!resultado) {
                    JOptionPane.showMessageDialog(null, mensajeConfirmacion, titulo, JOptionPane.INFORMATION_MESSAGE);
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, mensajeError, titulo, JOptionPane.INFORMATION_MESSAGE);
                }
            }

            modelo.getVista().tblEspecialidades.setModel(dao.modeloTablaEspecialidad());

        } else if (e.getActionCommand().equals(modelo.getVista().btnEliminar.getActionCommand())) {
            boolean resultado;
            if (modelo.getVista().txtEspecialidad.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Error", "Datos no válidos", 1);
            } else {
                int respuesta = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas eliminar el registro?",
                        "Confirmación", JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.YES_OPTION) {
                    resultado = dao.eliminarEspecialidad(modelo.getVista().txtIdEspecialidad.getText());
                    if (!resultado) {
                        JOptionPane.showMessageDialog(null, mensajeConfirmacion, titulo, JOptionPane.INFORMATION_MESSAGE);
                        limpiar();
                    } else {
                        JOptionPane.showMessageDialog(null, mensajeError, titulo, JOptionPane.INFORMATION_MESSAGE);
                    }

                }
            }
            modelo.getVista().tblEspecialidades.setModel(dao.modeloTablaEspecialidad());

        } else if (e.getActionCommand().equals(modelo.getVista().btnReload.getActionCommand())) {
            modelo.getVista().tblEspecialidades.setModel(dao.modeloTablaEspecialidad());

        } else if (e.getActionCommand().equals(modelo.getVista().btnLimpiar.getActionCommand())) {
            limpiar();
        } else if (e.getActionCommand().equals(modelo.getVista().btnRegresar.getActionCommand())) {
            modelo.getVista().setVisible(false);
            VistaInicio vistaInicial = new VistaInicio();
            vistaInicial.setVisible(true);

        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        if (e.getComponent().equals(modelo.getVista())) {
            modelo.getVista().txtIdEspecialidad.setEditable(false);
            modelo.getVista().tblEspecialidades.setModel(dao.modeloTablaEspecialidad());
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getComponent().equals(modelo.getVista().tblEspecialidades)) {
            modelo.getVista().txtIdEspecialidad.setText(String.valueOf(modelo.getVista().tblEspecialidades.getValueAt(modelo.getVista().tblEspecialidades.getSelectedRow(), 0)));
            modelo.getVista().txtEspecialidad.setText(String.valueOf(modelo.getVista().tblEspecialidades.getValueAt(modelo.getVista().tblEspecialidades.getSelectedRow(), 1)));
        } else {
            limpiar();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    public void limpiar() {
        modelo.getVista().txtEspecialidad.setText("");
        modelo.getVista().txtIdEspecialidad.setText("");
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }
}
