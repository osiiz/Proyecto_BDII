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
    
    public List<Tarea> obtenerTareasBasicas(String nombre, Boolean completada, Usuario usuario, int descendente){
        List<Tarea> resultado = new java.util.ArrayList<>();
        List<Categoria> categoriasActuales;
        
        Tarea tareaActual;
        Connection con;
        PreparedStatement stmTareas = null;
        PreparedStatement stmCategorias = null;
        ResultSet rsTareas = null;
        ResultSet rsCategorias = null;
        String ascDesc = "asc";
        
        if (descendente == 1) ascDesc = "desc";

        con=this.getConexion();
        
        String consultaTareas = "SELECT id_tarea, tb.nombre, completada, fecha_fin "+
                "FROM tarea_basica tb WHERE tb.nombre LIKE ? AND completada = ? AND id_usuario = ? " +
                "order by fecha_fin " + ascDesc;
        String consultaCategorias = "SELECT categoria FROM categoria_tarea_basica ctb WHERE tarea_basica = ? ";
                
        
        try  {
            stmTareas = con.prepareStatement(consultaTareas);
            stmTareas.setString(1, "%"+nombre+"%");
            stmTareas.setBoolean(2, completada);
            stmTareas.setString(3, usuario.getIdUsuario());
            stmCategorias = con.prepareStatement(consultaCategorias);
            
            rsTareas = stmTareas.executeQuery();
            while (rsTareas.next()){
                stmCategorias.setInt(1, rsTareas.getInt("id_tarea"));
                categoriasActuales = new ArrayList<>();
                rsCategorias = stmCategorias.executeQuery();
                while (rsCategorias.next()){
                    categoriasActuales.add(new Categoria(rsCategorias.getString("categoria")));
                }
                tareaActual = new Tarea(rsTareas.getInt("id_tarea"), rsTareas.getString("nombre"), rsTareas.getBoolean("completada"), 
                        LocalDate.parse(rsTareas.getString("fecha_fin")), categoriasActuales);

                resultado.add(tareaActual);
            }

        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
            try {
                if (stmTareas != null) stmTareas.close();
                if (stmCategorias != null) stmCategorias.close();
                if (rsTareas != null) rsTareas.close();
                if (rsCategorias != null) rsCategorias.close();
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
        List<Categoria> categoriasActuales;
        
        Connection con;
        PreparedStatement stmTarea=null;
        ResultSet rsTarea;
        PreparedStatement stmCategorias = null;
        ResultSet rsCategorias = null;
        

        con=super.getConexion();
        
        try{
            stmTarea = con.prepareStatement("SELECT id_tarea, nombre, completada, fecha_fin "+
                "FROM tarea_basica tb WHERE id_tarea = ?");
            stmTarea.setInt(1, idTarea);
            stmCategorias = con.prepareStatement("SELECT categoria FROM categoria_tarea_basica ctb WHERE tarea_basica = ?");
            stmCategorias.setInt(1, idTarea);
            rsTarea = stmTarea.executeQuery();
            if (rsTarea.next()){
                categoriasActuales = new ArrayList<>();
                rsCategorias = stmCategorias.executeQuery();
                while (rsCategorias.next()){
                    categoriasActuales.add(new Categoria(rsCategorias.getString("categoria")));
                }
                resultado = new Tarea(rsTarea.getInt("id_tarea"), rsTarea.getString("nombre"), rsTarea.getBoolean("completada"), 
                        LocalDate.parse(rsTarea.getString("fecha_fin")), categoriasActuales);
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

    public void eliminarCategoriaTarea(int idTarea, String nombre) {
        Connection con;
        PreparedStatement stmEliminarCategoriaTarea;
        con=super.getConexion();
        
        try{
            stmEliminarCategoriaTarea = con.prepareStatement("delete from categoria_tarea_basica where tarea_basica = ? and categoria = ?");
            stmEliminarCategoriaTarea.setInt(1, idTarea);
            stmEliminarCategoriaTarea.setString(2, nombre);
            
            stmEliminarCategoriaTarea.executeUpdate();
            
        }catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }
    }

    public void cambiarCategoriaTarea(int idTarea, String nombre) {
        Connection con;
        PreparedStatement stmAnhadirCategoriaTarea;
        con=super.getConexion();
        
        try{
            stmAnhadirCategoriaTarea = con.prepareStatement("insert into categoria_tarea_basica (tarea_basica, categoria) values (?, ?)");
            stmAnhadirCategoriaTarea.setInt(1, idTarea);
            stmAnhadirCategoriaTarea.setString(2, nombre);
            
            stmAnhadirCategoriaTarea.executeUpdate();
            
        }catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }
    }

    public Tarea anhadirTarea(Tarea t, String idUsuario) {
        Tarea resultado = null;
        Connection con;
        PreparedStatement stmTarea;
        PreparedStatement stmIdTarea;
        ResultSet rsIdTarea;
        con=super.getConexion();
        
        try{
            stmTarea = con.prepareStatement("insert into tarea_basica (id_usuario, nombre, completada, fecha_fin) "
                    + "values (?, ?, ?, ?)");
            stmTarea.setString(1, idUsuario);
            stmTarea.setString(2, t.getNombre());
            stmTarea.setBoolean(3, t.getCompletada());
            stmTarea.setDate(4, Date.valueOf(t.getFechaFin()));
            stmTarea.executeUpdate();
            
            stmIdTarea=con.prepareStatement("select currval('tarea_basica_id_seq') as idTarea");
            rsIdTarea=stmIdTarea.executeQuery();
            rsIdTarea.next();
            t.setIdTarea(rsIdTarea.getInt("idTarea"));
            
            resultado = t;
            
            rsIdTarea.close();
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }
        return resultado;
    }
}
