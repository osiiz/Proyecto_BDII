/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;
import java.time.LocalDate;

/**
 *
 * @author alumnogreibd
 */
public class Tarea {
    private int idTarea;
    private String nombre;
    private Boolean completada;
    private LocalDate fechaFin;
    private Categoria categoria;

    public Tarea(int id_tarea, String nombre, Boolean completada, LocalDate fechaFin, Categoria categoria) {
        this.idTarea = id_tarea;
        this.nombre = nombre;
        this.categoria = categoria;
        this.completada = completada;
        this.fechaFin = fechaFin;
    }

    public int getIdTarea() {
        return idTarea;
    }

    public String getNombre() {
        return nombre;
    }

    public Boolean getCompletada() {
        return completada;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public Categoria getCategoria() {
        return categoria;
    }
    
    
    
    
    
}
