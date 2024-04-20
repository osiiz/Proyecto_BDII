/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baseDatos;

import aplicacion.Categoria;
import java.sql.Connection;
import java.util.List;
import aplicacion.Tarea;
import aplicacion.Usuario;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author alumnogreibd
 */
public class DAOTareas extends AbstractDAO {
    
    public DAOTareas (Connection conexion, aplicacion.FachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }
    
    public List<Tarea> obtenerTareasBasicas(String nombre, String categoria, Boolean completada, Usuario usuario){
        List<Tarea> resultado = new java.util.ArrayList<>();
        
        Tarea tareaActual;
        Connection con;
        PreparedStatement stmTareas = null;
        ResultSet rsTareas;

        con=this.getConexion();
        
        String consultaTareas = "SELECT id_tarea, tb.nombre, completada, fecha_fin, ctb.categoria as categoria "+
                "FROM tarea_basica tb LEFT JOIN categoria_tarea_basica ctb ON (tb.id_tarea = ctb.tarea_basica)"+
                "WHERE tb.nombre LIKE ? AND completada = ? AND id_usuario = ? ";
        String consultaTareasCategoria = "AND categoria LIKE ?";
        
        if (!categoria.isBlank()){
            consultaTareas += consultaTareasCategoria;
        }

        try  {
            stmTareas = con.prepareStatement(consultaTareas);
            stmTareas.setString(1, "%"+nombre+"%");
            stmTareas.setBoolean(2, completada);
            stmTareas.setString(3, usuario.getIdUsuario());
            if (!categoria.isBlank()) stmTareas.setString(4, "%"+categoria+"%");
            rsTareas = stmTareas.executeQuery();
            while (rsTareas.next()){
                tareaActual = new Tarea(rsTareas.getInt("id_tarea"), rsTareas.getString("nombre"), rsTareas.getBoolean("completada"), 
                        LocalDate.parse(rsTareas.getString("fecha_fin")), new Categoria(rsTareas.getString("categoria")));

                resultado.add(tareaActual);
            }

        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
            try {
                if (stmTareas != null) stmTareas.close();
            } catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
        
    }

    public void actualizarCompletada(int idTarea, Boolean completada) {
        Connection con;
        PreparedStatement stmCompletar=null;

        con=super.getConexion();
        
        try{
            stmCompletar = con.prepareStatement("UPDATE tarea_basica SET completada = ? WHERE id_tarea = ? ");
            stmCompletar.setBoolean(1, completada);
            stmCompletar.setInt(2, idTarea);
            stmCompletar.executeUpdate();
            stmCompletar.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }
        
    }

    public void borrarTarea(int idTarea) {
        Connection con;
        PreparedStatement stmBorrar=null;

        con=super.getConexion();
        
        try{
            stmBorrar = con.prepareStatement("delete from tarea_basica where id_tarea = ?");
            stmBorrar.setInt(1, idTarea);
            stmBorrar.executeUpdate();
            stmBorrar.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }
    }

    public Tarea consultarTarea(Integer idTarea) {
        Tarea resultado=null;
        Connection con;
        PreparedStatement stmTarea=null;
        ResultSet rsTarea;
        

        con=super.getConexion();
        
        try{
            stmTarea = con.prepareStatement("SELECT id_tarea, tb.nombre, completada, fecha_fin, c.nombre as categoria "+
                "FROM tarea_basica tb JOIN categoria_tarea_basica ctb ON (tb.id_tarea = ctb.tarea_basica) JOIN categoria c ON (ctb.categoria = c.nombre) "+
                "WHERE id_tarea = ?");
            stmTarea.setInt(1, idTarea);
            rsTarea = stmTarea.executeQuery();
            if (rsTarea.next()){
                resultado = new Tarea(rsTarea.getInt("id_tarea"), rsTarea.getString("nombre"), rsTarea.getBoolean("completada"), 
                        LocalDate.parse(rsTarea.getString("fecha_fin")), new Categoria(rsTarea.getString("categoria")));
            }
            stmTarea.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }
        return resultado;
    }

    public List<String> obtenerRestoCategorias(Integer idTarea) {
        List <String> resultado = new ArrayList<>();
        Connection con;
        PreparedStatement stmRestoCategorias=null;
        ResultSet rsRestoCategorias;
        con=super.getConexion();
        
        try{
            stmRestoCategorias = con.prepareStatement("select c.nombre from categoria c where not exists " +
                    "(select * from categoria_tarea_basica ctb where ctb.tarea_basica = ? and ctb.categoria = c.nombre)");
            stmRestoCategorias.setInt(1, idTarea);
            rsRestoCategorias = stmRestoCategorias.executeQuery();
            while (rsRestoCategorias.next()){
                resultado.add(rsRestoCategorias.getString("nombre"));
            }
            stmRestoCategorias.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }
        return resultado;
    }

    public void actualizarTarea(Tarea t) {
        Connection con;
        PreparedStatement stmActualizarTarea;
        con=super.getConexion();
        
        try{
            stmActualizarTarea = con.prepareStatement("UPDATE tarea_basica "
                    + "SET nombre = ?, completada = ?, fecha_fin = ? "
                    + "WHERE id_tarea = ?");
            stmActualizarTarea.setString(1, t.getNombre());
            stmActualizarTarea.setBoolean(2, t.getCompletada());
            stmActualizarTarea.setDate(3, Date.valueOf(t.getFechaFin()));
            stmActualizarTarea.setInt(4, t.getIdTarea());
            
            stmActualizarTarea.executeUpdate();
            
        }catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }
    }

    public void eliminarCategoriaTarea(int idTarea) {
        Connection con;
        PreparedStatement stmEliminarCategoriaTarea;
        con=super.getConexion();
        
        try{
            stmEliminarCategoriaTarea = con.prepareStatement("UPDATE tarea_basica "
                    + "SET categoria = null WHERE id_tarea = ?");
            stmEliminarCategoriaTarea.setInt(1, idTarea);
            
            stmEliminarCategoriaTarea.executeUpdate();
            
        }catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }
    }
}
