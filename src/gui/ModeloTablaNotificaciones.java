/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;
import javax.swing.table.*;
import java.util.List;
import java.util.ArrayList;
import aplicacion.Notificacion;
/**
 *
 * @author alumnogreibd
 */
public class ModeloTablaNotificaciones extends AbstractTableModel{
    private List<Notificacion> notis;
    
    public ModeloTablaNotificaciones(){
        this.notis = new ArrayList<>();
    }
    
    @Override
    public int getColumnCount(){
        return 2;
    }
    
    @Override
    public int getRowCount(){
        return notis.size();
    }

    @Override
    public String getColumnName(int col){
        String nombre="";

        switch (col){
            case 0: nombre= "Fecha"; break;
            case 1: nombre= "Mensaje"; break;
        }
        return nombre;
    }
    
    @Override
    public Class getColumnClass(int col){
        Class clase=null;

        switch (col){
            case 0: clase= java.lang.String.class; break;
            case 1: clase= java.lang.String.class; break;
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
            case 0: resultado= notis.get(row).getFecha(); break;
            case 1: resultado= notis.get(row).getMensaje(); break;
        }
        return resultado;
    }

    public void setFilas(List<Notificacion> notis){
        this.notis=notis;
        fireTableDataChanged();
    }

    public Notificacion obtenerNotificacion(int i){
        return this.notis.get(i);
    }
    
}
