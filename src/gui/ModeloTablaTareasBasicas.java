/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;
import aplicacion.Libro;
import javax.swing.table.*;
/**
 *
 * @author basesdatos
 */
public class ModeloTablaTareasBasicas extends AbstractTableModel{
    private java.util.List<Libro> libros;

    public ModeloTablaTareasBasicas(){
        this.libros=new java.util.ArrayList<>();
    }

    @Override
    public int getColumnCount (){
        return 5;
    }

    @Override
    public int getRowCount(){
        return libros.size();
    }

    @Override
    public String getColumnName(int col){
        String nombre="";

        switch (col){
            case 0: nombre= "Id"; break;
            case 1: nombre= "Nombre"; break;
            case 2: nombre="Categoría"; break;
            case 3: nombre="Fecha fin"; break;
            case 4: nombre="Completada"; break;
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
            case 3: clase=java.lang.String.class; break;
            case 4: clase=java.lang.String.class; break;
        }
        return clase;
    }

    @Override
    public boolean isCellEditable(int row, int col){
        return false;
    }

    public Object getValueAt(int row, int col){
        Object resultado=null;

        switch (col){
            case 0: resultado= libros.get(row).getIdLibro(); break;
            case 1: resultado= libros.get(row).getAutoresAsString(); break;
            case 2: resultado=libros.get(row).getTitulo();break;
            case 3: resultado=libros.get(row).getEditorial(); break;
            case 4: resultado=libros.get(row).getAno(); break;
        }
        return resultado;
    }

    public void setFilas(java.util.List<Libro> libros){
        this.libros=libros;
        fireTableDataChanged();
    }

    public Libro obtenerLibro(int i){
        return this.libros.get(i);
    }

}
