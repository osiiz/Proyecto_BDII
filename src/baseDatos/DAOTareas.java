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
        
        String consultaTareas = "SELECT id_tarea, tb.nombre, completada, fecha_fin, categoria "+
                "FROM tarea_basica tb JOIN categoria_tarea_basica ctb ON (tb.id_tarea = ctb.tarea_basica) JOIN categoria c ON (ctb.categoria = c.nombre) "+
                "WHERE tb.nombre LIKE ? AND c.nombre LIKE ? AND completada = ? AND id_usuario LIKE ?";


        try  {
            stmTareas = con.prepareStatement(consultaTareas);
            stmTareas.setString(1, "%"+nombre+"%");
            stmTareas.setString(2, "%"+categoria+"%");
            stmTareas.setBoolean(3, completada);
            stmTareas.setString(4, "%"+usuario.getIdUsuario()+"%");
            rsTareas = stmTareas.executeQuery();
            while (rsTareas.next()){
                tareaActual = new Tarea(rsTareas.getInt("id_tarea"), rsTareas.getString("nombre"), rsTareas.getBoolean("completada"), 
                        LocalDate.parse(rsTareas.getString("fecha_fin")), new Categoria("cat1", "descripcion1")); //rsTareas.getString("categoria"));

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

    void actualizarCompletada(int idTarea, Boolean completada) {
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

    void borrarTarea(int idTarea) {
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
}
