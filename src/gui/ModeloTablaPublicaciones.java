/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;
import javax.swing.table.*;
import java.util.List;
import java.util.ArrayList;
import aplicacion.Publicacion;
import java.time.LocalDateTime;

/**
 *
 * @author alumnogreibd
 */
public class ModeloTablaPublicaciones extends AbstractTableModel {
    private List<Publicacion> publicaciones;
    
    public ModeloTablaPublicaciones(){
        this.publicaciones = new ArrayList<>();
    }
    
    @Override
    public int getColumnCount(){
        return 4;
    }
    
    @Override
    public int getRowCount(){
        return publicaciones.size();
    }

    @Override
    public String getColumnName(int col){
        String nombre="";

        switch (col){
            case 0: nombre= "Id Publicacion"; break;
            case 1: nombre= "Texto"; break;
            case 2: nombre= "Id Usuario"; break;
            case 3: nombre= "Fecha envío"; break;
        }
        return nombre;
    }
    
    @Override
    public Class getColumnClass(int col){
        Class clase=null;

        switch (col){
            case 0: clase= java.lang.Integer.class; break;
            case 1: clase= java.lang.String.class; break;
            case 2: clase= java.lang.String.class; break;
            case 3: clase= java.time.LocalDateTime.class; break;
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
            case 0: resultado = publicaciones.get(row).getIdPublicacion(); break;
            case 1: resultado = publicaciones.get(row).getTexto(); break;
            case 2: resultado = publicaciones.get(row).getIdUsuario(); break;
            case 3: resultado = publicaciones.get(row).getFecha(); break;
        }
        return resultado;
    }

    public void setFilas(List<Publicacion> publicaciones){
        this.publicaciones=publicaciones;
        fireTableDataChanged();
    }

    public Publicacion obtenerUsuario(int i){
        return this.publicaciones.get(i);
    }
    
    
    
}
