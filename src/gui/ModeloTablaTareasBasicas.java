/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;
import aplicacion.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alumnogreibd
 */
public class ModeloTablaTareasBasicas extends AbstractTableModel {
    private List<Tarea> tareas;

    public ModeloTablaTareasBasicas() {
        this.tareas = new ArrayList<>();
    }
    
    @Override
    public int getColumnCount(){
        return 5;
    }
    
    @Override
    public int getRowCount(){
        return tareas.size();
    }

    @Override
    public String getColumnName(int col){
        String nombre="";

        switch (col){
            case 0: nombre= "Id"; break;
            case 1: nombre= "Nombre"; break;
            case 2: nombre= "Categoría"; break;
            case 3: nombre= "Fecha_fin"; break;
            case 4: nombre= "Completada"; break;
        }
        return nombre;
    }
    
    @Override
    public Class getColumnClass(int col){
        Class clase=null;

        switch (col){
            case 0: clase= java.lang.Integer.class; break;
            case 1: clase= java.lang.String.class; break;
            case 2: clase=java.lang.String.class; break;
            case 3: clase=java.time.LocalDate.class; break;
            case 4: clase=java.lang.Boolean.class; break;
        }
        return clase;
    }

    @Override
    public boolean isCellEditable(int row, int col){
        return false;
    }

    @Override
    public Object getValueAt(int row, int col){
        Object resultado=null;

        switch (col){
            case 0: resultado= tareas.get(row).getIdTarea(); break;
            case 1: resultado= tareas.get(row).getNombre(); break;
            case 2: resultado= tareas.get(row).getCategoria();break;
            case 3: resultado= tareas.get(row).getFechaFin(); break;
            case 4: resultado= tareas.get(row).getCompletada(); break;
        }
        return resultado;
    }

    public void setFilas(List<Tarea> tareas){
        this.tareas=tareas;
        fireTableDataChanged();
    }

    public Tarea obtenerTareas(int i){
        return this.tareas.get(i);
    }
    
    
}
