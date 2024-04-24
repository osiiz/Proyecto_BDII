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
    
    public List<Tarea> obtenerTareasBasicas(String nombre, String categoria, Boolean completada, Usuario usuario, int descendente){
        List<Tarea> resultado = new java.util.ArrayList<>();
        
        Tarea tareaActual;
        Connection con;
        PreparedStatement stmTareas = null;
        ResultSet rsTareas;
        String ascDesc = "asc";
        
        if (descendente == 1) ascDesc = "desc";

        con=this.getConexion();
        
        String consultaTareas = "SELECT id_tarea, tb.nombre, completada, fecha_fin, ctb.categoria as categoria "+
                "FROM tarea_basica tb LEFT JOIN categoria_tarea_basica ctb ON (tb.id_tarea = ctb.tarea_basica)"+
                "WHERE tb.nombre LIKE ? AND completada = ? AND id_usuario = ? ";
                
        
        if (!categoria.isBlank()) consultaTareas += "AND categoria LIKE ? order by fecha_fin " + ascDesc;
        else consultaTareas += "order by fecha_fin " + ascDesc;
        
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
            stmTarea = con.prepareStatement("SELECT id_tarea, tb.nombre, completada, fecha_fin, categoria "+
                "FROM tarea_basica tb LEFT JOIN categoria_tarea_basica ctb ON (tb.id_tarea = ctb.tarea_basica)"+
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
            stmEliminarCategoriaTarea = con.prepareStatement("delete from categoria_tarea_basica where tarea_basica = ?");
            stmEliminarCategoriaTarea.setInt(1, idTarea);
            
            stmEliminarCategoriaTarea.executeUpdate();
            
        }catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }
    }

    public void cambiarCategoriaTarea(int idTarea, String nombre) {
        Connection con;
        PreparedStatement stmQuitarCategoriaTarea;
        PreparedStatement stmAnhadirCategoriaTarea;
        con=super.getConexion();
        
        try{
            stmQuitarCategoriaTarea = con.prepareStatement("delete from categoria_tarea_basica where tarea_basica = ?");
            stmAnhadirCategoriaTarea = con.prepareStatement("insert into categoria_tarea_basica (tarea_basica, categoria) values (?, ?)");
            stmQuitarCategoriaTarea.setInt(1, idTarea);
            stmAnhadirCategoriaTarea.setInt(1, idTarea);
            stmAnhadirCategoriaTarea.setString(2, nombre); 
            
            stmQuitarCategoriaTarea.executeUpdate();
            stmAnhadirCategoriaTarea.executeUpdate();
            
            
        }catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }
    }

    public Tarea actualizarDatosTarea(int idTarea) {
        Tarea resultado = null;
        Connection con;
        PreparedStatement stmTarea;
        ResultSet rsTarea;
        con=super.getConexion();
        
        try{
            stmTarea = con.prepareStatement("select id_tarea, nombre, completada, fecha_fin, categoria "
                    + "from tarea_basica tb left join categoria_tarea_basica ctb on (tb.id_tarea = ctb.tarea_basica) "
                    + "where id_tarea = ?");
            stmTarea.setInt(1, idTarea);
            rsTarea = stmTarea.executeQuery();
            if (rsTarea.next()){
                resultado = new Tarea(idTarea, rsTarea.getString("nombre"), rsTarea.getBoolean("completada"), 
                rsTarea.getDate("fecha_fin").toLocalDate(), new Categoria(rsTarea.getString("categoria")));
            }
            rsTarea.close();
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }
        return resultado;
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
    
    public List<Tarea> notiTareaBasica(String idUsuario){
        List<Tarea> resultado = new java.util.ArrayList<>();
        Tarea tareaActual;
        Connection con;
        PreparedStatement stmTarea;
        ResultSet rsTarea;
        con=super.getConexion();
        
        try{
            stmTarea = con.prepareStatement("select id_tarea, nombre, completada, fecha_fin "
                    + "from tarea_basica tb "
                    + "where id_usuario = ? "
                    + "and fecha_fin - CURRENT_DATE <= 1");
            stmTarea.setString(1, idUsuario);
            rsTarea = stmTarea.executeQuery();
            while (rsTarea.next()){
                tareaActual = new Tarea(rsTarea.getInt("id_tarea"), rsTarea.getString("nombre"), rsTarea.getBoolean("completada"), 
                rsTarea.getDate("fecha_fin").toLocalDate(), null);
                
                resultado.add(tareaActual);
            }
            rsTarea.close();
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }
        return resultado;
    }
    
    public List<Tarea> notiTareaProyecto(String idUsuario){
        List<Tarea> resultado = new java.util.ArrayList<>();
        Tarea tareaActual;
        Connection con;
        PreparedStatement stmTarea;
        ResultSet rsTarea;
        con=super.getConexion();
        
        try{
            stmTarea = con.prepareStatement("select tp.id_tarea, tp.nombre, tp.completada, tp.fecha_fin "
                    + "from Tarea_de_proyecto tp, Participar p, Seccion s "
                    + "where s.id_proyecto = p.id_proyecto "
                    + "and tp.id_seccion = s.id_seccion "
                    + "and p.id_usuario = ? "
                    + "and fecha_fin - CURRENT_DATE <= 1");
            stmTarea.setString(1, idUsuario);
            rsTarea = stmTarea.executeQuery();
            while (rsTarea.next()){
                tareaActual = new Tarea(rsTarea.getInt("id_tarea"), rsTarea.getString("nombre"), rsTarea.getBoolean("completada"), 
                rsTarea.getDate("fecha_fin").toLocalDate(), null);
                
                resultado.add(tareaActual);
            }
            rsTarea.close();
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }
        return resultado;
    }
}
