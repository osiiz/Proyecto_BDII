/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package baseDatos;

import aplicacion.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author basesdatos
 */
public class FachadaBaseDatos {
    private aplicacion.FachadaAplicacion fa;
    private java.sql.Connection conexion;
    private DAOCategorias daoCategorias;
    private DAOUsuarios daoUsuarios;
    private DAOTareas daoTareas;

    public FachadaBaseDatos (aplicacion.FachadaAplicacion fa){
        
        Properties configuracion = new Properties();
        this.fa=fa;
        FileInputStream arqConfiguracion;

        try {
            arqConfiguracion = new FileInputStream("baseDatos.properties");
            configuracion.load(arqConfiguracion);
            arqConfiguracion.close();

            Properties usuario = new Properties();
     

            String gestor = configuracion.getProperty("gestor");

            usuario.setProperty("user", configuracion.getProperty("usuario"));
            usuario.setProperty("password", configuracion.getProperty("clave"));
            this.conexion=java.sql.DriverManager.getConnection("jdbc:"+gestor+"://"+
                    configuracion.getProperty("servidor")+":"+
                    configuracion.getProperty("puerto")+"/"+
                    configuracion.getProperty("baseDatos"),
                    usuario);

            daoCategorias = new DAOCategorias(conexion, fa);
            daoUsuarios = new DAOUsuarios(conexion, fa);     
            daoTareas = new DAOTareas(conexion, fa);


        } catch (FileNotFoundException f){
            System.out.println(f.getMessage());
            fa.muestraExcepcion(f.getMessage());
        } catch (IOException | java.sql.SQLException i){
            System.out.println(i.getMessage());
            fa.muestraExcepcion(i.getMessage());
        }
        
        
        
    }
    
    

    public Usuario validarUsuario(String idUsuario, String clave){
        return daoUsuarios.validarUsuario(idUsuario, clave);
    }
   
    public java.util.List<Categoria> consultarCategorias(){
        return daoCategorias.consultarCategorias();
    }
    
    public java.util.List<Usuario> consultarUsuarios(String id, String nombre){
        return daoUsuarios.consultarUsuarios(id,nombre);
    }
    
    public void insertarUsuario(Usuario u){
        daoUsuarios.insertarUsuario(u);
    }
    
    public void modificarUsuario(Usuario u){
        daoUsuarios.modificarUsuario(u);
    }

    public void borrarUsuario(Usuario usuario){
        daoUsuarios.borrarUsuario(usuario);
    }

    public void borrarCategoria(String nombre) {
        daoCategorias.borrarCategoria(nombre);
    }

    public void anhadirCategoria(Categoria categoria) {
        daoCategorias.anhadirCategoria(categoria);
    }

    public List<Tarea> consultarTareas(String nombre, String categoria, Boolean completada, Usuario usuario) {
        return daoTareas.obtenerTareasBasicas(nombre, categoria, completada, usuario);
    }
}
