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
    private FachadaAplicacion fa;

    public ModeloTablaTareasBasicas(FachadaAplicacion fa) {
        this.tareas = new ArrayList<>();
        this.fa = fa;
    }
    
    @Override
    public int getColumnCount(){
        return 4;
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
            case 2: nombre= "Fecha_fin"; break;
            case 3: nombre= "Completada"; break;
        }
        return nombre;
    }
    
    @Override
    public Class getColumnClass(int col){
        Class clase=null;

        switch (col){
            case 0: clase= java.lang.Integer.class; break;
            case 1: clase= java.lang.String.class; break;
            case 2: clase=java.time.LocalDate.class; break;
            case 3: clase=java.lang.Boolean.class; break;
        }
        return clase;
    }

    @Override
    public boolean isCellEditable(int row, int col){
        return col == 3;
    }

    @Override
    public Object getValueAt(int row, int col){
        Object resultado=null;

        switch (col){
            case 0: resultado= tareas.get(row).getIdTarea(); break;
            case 1: resultado= tareas.get(row).getNombre(); break;
            case 2: resultado= tareas.get(row).getFechaFin(); break;
            case 3: resultado= tareas.get(row).getCompletada(); break;
        }
        return resultado;
    }
    
    @Override
    public void setValueAt(Object value, int row, int column) {
        if (column == 3) {
            tareas.get(row).setCompletada((Boolean) value);
            fa.actualizarCompletada(tareas.get(row).getIdTarea(), tareas.get(row).getCompletada());
        }
    }
    

    public void setFilas(List<Tarea> tareas){
        this.tareas=tareas;
        fireTableDataChanged();
    }

    public Tarea obtenerTareas(int i){
        return this.tareas.get(i);
    }
    
    
}
