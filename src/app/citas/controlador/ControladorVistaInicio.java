package app.citas.controlador;
import app.citas.modelos.ModeloVistaInicio;
import app.citas.modelos.ModeloEspecialidad;
import app.citas.vistas.VistaEspecialidad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ControladorVistaInicio implements ActionListener, WindowListener{
    
    public ModeloVistaInicio modelo;

    public ControladorVistaInicio(ModeloVistaInicio modelo) {
        this.modelo = modelo;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(modelo.getVista().btnGoToEspecialidades.getActionCommand())){
            modelo.getVista().setVisible(false);
            VistaEspecialidad vistaEspecialidad = new VistaEspecialidad();
            ModeloEspecialidad modeloEspecialidad = new ModeloEspecialidad(vistaEspecialidad);
            modeloEspecialidad.getVista().setVisible(true);
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        modelo.getVista().setTitle("Inicio");
        modelo.getVista().setLocationRelativeTo(null);
        modelo.getVista().setVisible(true);
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
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
    
}
