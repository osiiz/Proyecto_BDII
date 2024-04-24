/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;
/**
 *
 * @author alumnogreibd
 */
public class Notificacion {
    private int idNotificacion;
    private String mensaje;
    private boolean leida;
    private String fecha;
    private int idTarea;
    private TipoNotificacion tipo;

    public Notificacion(int idNotificacion, String mensaje, boolean leida, String fecha, int idTarea, TipoNotificacion tipo) {
        this.idNotificacion = idNotificacion;
        this.mensaje = mensaje;
        this.leida = leida;
        this.fecha = fecha;
        this.idTarea = idTarea;
        this.tipo = tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setTipo(TipoNotificacion tipo) {
        this.tipo = tipo;
    }

    public TipoNotificacion getTipo() {
        return tipo;
    }

    public int getIdNotificacion() {
        return idNotificacion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public boolean isLeida() {
        return leida;
    }

    public int getIdTarea() {
        return idTarea;
    }

    public void setIdNotificacion(int idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setLeida(boolean leida) {
        this.leida = leida;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }
    
       
}
