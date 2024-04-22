/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;
import javax.swing.table.*;
import java.util.List;
import java.util.ArrayList;
import aplicacion.Foro;

/**
 *
 * @author alumnogreibd
 */
public class ModeloTablaForos extends AbstractTableModel {
    private List<Foro> foros;
    
    public ModeloTablaForos(){
        this.foros = new ArrayList<>();
    }
    
    @Override
    public int getColumnCount(){
        return 2;
    }
    
    @Override
    public int getRowCount(){
        return foros.size();
    }

    @Override
    public String getColumnName(int col){
        String nombre="";

        switch (col){
            case 0: nombre= "Id"; break;
            case 1: nombre= "Título"; break;
        }
        return nombre;
    }
    
    @Override
    public Class getColumnClass(int col){
        Class clase=null;

        switch (col){
            case 0: clase= java.lang.Integer.class; break;
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
            case 0: resultado= foros.get(row).getIdForo(); break;
            case 1: resultado= foros.get(row).getTitulo(); break;
        }
        return resultado;
    }

    public void setFilas(List<Foro> foros){
        this.foros=foros;
        fireTableDataChanged();
    }

    public Foro obtenerUsuario(int i){
        return this.foros.get(i);
    }
    
    
    
}
