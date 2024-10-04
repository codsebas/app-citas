package app.citas.sql;

public class QuerysEspecialidad {
    private final String INSERTAR_ESPECIALIDAD = "insert into especialidad(nombre_especialidad)"
            + " values(?)";
    private final String ELIMINAR_ESPECIALIDAD = "delete from especialidad where id_especialidad = ?";
    private final String ACTUALIZAR_ESPECIALIDAD = "update especialidad set nombre_especialidad = ? where"
            + " id_especialidad = ?";
    private final String SELECCIONAR_ESPECIALIDADES = "select * from especialidad";
    private final String SELECCIONAR_ESPECIALIDAD = "select * from especialidad where id_especialidad = ?";

    public String getINSERTAR_ESPECIALIDAD() {
        return INSERTAR_ESPECIALIDAD;
    }

    public String getELIMINAR_ESPECIALIDAD() {
        return ELIMINAR_ESPECIALIDAD;
    }

    public String getACTUALIZAR_ESPECIALIDAD() {
        return ACTUALIZAR_ESPECIALIDAD;
    }

    public String getSELECCIONAR_ESPECIALIDADES() {
        return SELECCIONAR_ESPECIALIDADES;
    }

    public String getSELECCIONAR_ESPECIALIDAD() {
        return SELECCIONAR_ESPECIALIDAD;
    }
    
    
}
