/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author alumnogreibd
 */
public class Tarea {
    private int idTarea;
    private String nombre;
    private Boolean completada;
    private LocalDate fechaFin;
    private List<Categoria> categorias;

    public Tarea(int id_tarea, String nombre, Boolean completada, LocalDate fechaFin, List<Categoria> categorias) {
        this.idTarea = id_tarea;
        this.nombre = nombre;
        this.categorias = categorias;
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

    public List <Categoria> getCategorias() {
        return categorias;
    }

    public void setCompletada(Boolean completada) {
        this.completada = completada;
    }

    public void setCategoria(List <Categoria> categorias) {
        this.categorias = categorias;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }
    
    

    
    
    
    
    
    
}
