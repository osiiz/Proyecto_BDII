/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package baseDatos;
import aplicacion.Usuario;
import aplicacion.TipoUsuario;
import java.sql.*;
/**
 *
 * @author basesdatos
 */
public class DAOUsuarios extends AbstractDAO {

    public DAOUsuarios (Connection conexion, aplicacion.FachadaAplicacion fa){
        try {
            conexion.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(ex.getMessage());
        }
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public Usuario validarUsuario(String idUsuario, String clave){
        Usuario resultado=null;
        Connection con;
        PreparedStatement stmUsuario=null;
        PreparedStatement stmGestor = null;
        PreparedStatement stmAdmin = null;
        ResultSet rsUsuario;
        ResultSet rsGestor;
        ResultSet rsAdmin;

        con=this.getConexion();

        try {
            stmUsuario = con.prepareStatement("select id_usuario, contraseña, nombre, direccion, email "+
                                            "from usuario "+
                                            "where id_usuario = ? and contraseña = hash(?);");
            stmUsuario.setString(1, idUsuario);
            stmUsuario.setString(2, clave);

            stmGestor = con.prepareStatement("select id_gestor, contraseña, nombre, direccion, email "+
                                            "from usuario_gestor "+
                                            "where id_gestor = ? and contraseña = hash(?);");
            stmGestor.setString(1, idUsuario);
            stmGestor.setString(2, clave);

            stmAdmin = con.prepareStatement("select id_administrador, contraseña, nombre "+
                                            "from administrador "+
                                            "where id_administrador = ? and contraseña = hash(?);");
            stmAdmin.setString(1, idUsuario);
            stmAdmin.setString(2, clave);

            rsUsuario = stmUsuario.executeQuery();
            rsGestor = stmGestor.executeQuery();
            rsAdmin = stmAdmin.executeQuery();
            if (rsUsuario.next()) {
                resultado = new Usuario(rsUsuario.getString("id_usuario"), rsUsuario.getString("contraseña"),
                                          rsUsuario.getString("nombre"), rsUsuario.getString("direccion"),
                                          rsUsuario.getString("email"), TipoUsuario.valueOf("Normal"));

            }else if (rsGestor.next()){
                resultado = new Usuario(rsGestor.getString("id_gestor"), rsGestor.getString("contraseña"),
                                          rsGestor.getString("nombre"), rsGestor.getString("direccion"),
                                          rsGestor.getString("email"), TipoUsuario.valueOf("Gestor"));
            }else if (rsAdmin.next()){
                resultado = new Usuario(rsAdmin.getString("id_administrador"), rsAdmin.getString("contraseña"),
                                        rsAdmin.getString("nombre"), null, null, TipoUsuario.valueOf("Administrador"));
            
            }
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
            try {
                if (stmUsuario != null) stmUsuario.close();
                if (stmGestor != null) stmGestor.close();
                if (stmAdmin != null) stmAdmin.close();
            } catch (SQLException e){
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }
    
    
    public java.util.List<Usuario> consultarUsuarios(String id, String nombre){
        java.util.List<Usuario> resultado = new java.util.ArrayList<>();
        Usuario usuarioActual;
        Connection con;
        PreparedStatement stmUsuarios=null;
        ResultSet rsUsuarios;
        PreparedStatement stmGestores=null;
        ResultSet rsGestores;
        PreparedStatement stmAdmin=null;
        ResultSet rsAdmin;

        con=this.getConexion();
        
        String consultaUs = "select id_usuario, nombre, email, contraseña, direccion " +
                                         "from usuario as u " +
                                         "where id_usuario like ?" +
                                         "and nombre like ?";
        
        String consultaGest = "select id_gestor, nombre, email, contraseña, direccion " +
                                         "from usuario_gestor as ug " +
                                         "where id_gestor like ?" +
                                         "and nombre like ?";
        
        String consultaAdmin= "select id_administrador, nombre, contraseña " +
                                         "from administrador as ad " +
                                         "where id_administrador like ?" +
                                         "and nombre like ?";
    
        try  {
            stmUsuarios = con.prepareStatement(consultaUs);
            stmGestores = con.prepareStatement(consultaGest);
            stmAdmin = con.prepareStatement(consultaAdmin);
            stmUsuarios.setString(1, "%"+id+"%");
            stmUsuarios.setString(2, "%"+nombre+"%");
            stmGestores.setString(1, "%"+id+"%");
            stmGestores.setString(2, "%"+nombre+"%");
            stmAdmin.setString(1, "%"+id+"%");
            stmAdmin.setString(2, "%"+nombre+"%");
            rsUsuarios = stmUsuarios.executeQuery();
            rsGestores = stmGestores.executeQuery();
            rsAdmin = stmAdmin.executeQuery();
            while (rsUsuarios.next()){
                usuarioActual = new Usuario(rsUsuarios.getString("id_usuario"), rsUsuarios.getString("contraseña"),
                                          rsUsuarios.getString("nombre"), rsUsuarios.getString("direccion"),
                                          rsUsuarios.getString("email"), TipoUsuario.valueOf("Normal"));

                resultado.add(usuarioActual);
            }
            while (rsGestores.next()){
                usuarioActual = new Usuario(rsGestores.getString("id_gestor"), rsGestores.getString("contraseña"),
                                          rsGestores.getString("nombre"), rsGestores.getString("direccion"),
                                          rsGestores.getString("email"), TipoUsuario.valueOf("Gestor"));

                resultado.add(usuarioActual);
            }
            while (rsAdmin.next()){
                usuarioActual = new Usuario(rsAdmin.getString("id_administrador"), rsAdmin.getString("contraseña"),
                                          rsAdmin.getString("nombre"), "-", "-", TipoUsuario.valueOf("Administrador"));

                resultado.add(usuarioActual);
            }

        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
            try {
                if (stmUsuarios != null) stmUsuarios.close();
                if (stmGestores != null) stmGestores.close();
                if (stmAdmin != null) stmAdmin.close();
            } catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }
    
    public void insertarUsuario(Usuario u, String idAntiguo){
        Connection con;
        PreparedStatement stmUsuario=null;
        PreparedStatement stmBorrar=null;

        con=super.getConexion();

        try {
            switch (u.getTipoUsuario().toString()){
                case "Normal":
                    con.setAutoCommit(false);
                    stmBorrar = con.prepareStatement("delete from usuario where id_usuario = ?");
                    stmUsuario=con.prepareStatement("insert into usuario(id_usuario, nombre, email, contraseña, direccion) "+
                                              "values (?,?,?,hash(?),?)");
                    stmBorrar.setString(1, idAntiguo);
                    stmUsuario.setString(1, u.getIdUsuario());
                    stmUsuario.setString(2, u.getNombre());
                    stmUsuario.setString(3, u.getEmail());
                    stmUsuario.setString(4, u.getClave());
                    stmUsuario.setString(5, u.getDireccion());
                    stmBorrar.executeUpdate();
                    stmUsuario.executeUpdate();
                    con.commit();
                    break;
                case "Gestor": 
                    con.setAutoCommit(false);
                    stmBorrar = con.prepareStatement("delete from usuario_gestor where id_gestor = ?");
                    stmUsuario=con.prepareStatement("insert into usuario_gestor(id_gestor, nombre, email, contraseña, direccion) "+
                                              "values (?,?,?, hash(?),?)");
                    stmBorrar.setString(1, idAntiguo);
                    stmUsuario.setString(1, u.getIdUsuario());
                    stmUsuario.setString(2, u.getNombre());
                    stmUsuario.setString(3, u.getEmail());
                    stmUsuario.setString(4, u.getClave());
                    stmUsuario.setString(5, u.getDireccion());
                    stmBorrar.executeUpdate();
                    stmUsuario.executeUpdate();
                    con.commit();
                    break;
                case "Administrador": 
                    con.setAutoCommit(false);
                    stmBorrar = con.prepareStatement("delete from administrador where id_administrador = ?");
                    stmUsuario=con.prepareStatement("insert into administrador(id_administrador, nombre, contraseña) "+
                                              "values (?,?,hash(?))");
                    stmBorrar.setString(1, idAntiguo);
                    stmUsuario.setString(1, u.getIdUsuario());
                    stmUsuario.setString(2, u.getNombre());
                    stmUsuario.setString(3, u.getClave());
                    stmBorrar.executeUpdate();
                    stmUsuario.executeUpdate();
                    con.commit();
                    break;
            }
            
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmUsuario.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
    
    public void modificarUsuario(Usuario u, Boolean clave_modificada){
        Connection con;
        PreparedStatement stmUsuario=null;
        String clave_mod;
        if (clave_modificada) clave_mod = "hash(?) ";
        else clave_mod = "?";

        con=super.getConexion();

        try {
            switch (u.getTipoUsuario().toString()){
                case "Normal":
                    stmUsuario=con.prepareStatement("update usuario set nombre=?, "+
                                        "email=?, contraseña = "+clave_mod+", direccion=? where id_usuario=?");
                    stmUsuario.setString(1, u.getNombre());
                    stmUsuario.setString(2, u.getEmail());
                    stmUsuario.setString(3, u.getClave());
                    stmUsuario.setString(4, u.getDireccion());
                    stmUsuario.setString(5, u.getIdUsuario());
                    stmUsuario.executeUpdate();
                    break;
                case "Gestor":
                    stmUsuario=con.prepareStatement("update usuario_gestor set nombre=?, "+
                                        "email=?, contraseña = "+clave_mod+", direccion=? where id_gestor=?");
                    stmUsuario.setString(1, u.getNombre());
                    stmUsuario.setString(2, u.getEmail());
                    stmUsuario.setString(3, u.getClave());
                    stmUsuario.setString(4,u.getDireccion());
                    stmUsuario.setString(5, u.getIdUsuario());
                    stmUsuario.executeUpdate();
                    break;
                case "Administrador":
                    stmUsuario=con.prepareStatement("update administrador set nombre=?, "+
                                        "contraseña = "+clave_mod+" where id_administrador=?");
                    stmUsuario.setString(1, u.getNombre());
                    stmUsuario.setString(2, u.getClave());
                    stmUsuario.setString(3, u.getIdUsuario());
                    stmUsuario.executeUpdate();
                    break;
            }

        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmUsuario.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        
    }
    
    public void borrarUsuario(Usuario usuario){
        Connection con = super.getConexion();
        PreparedStatement stmUsuario=null;
        
        try{
            switch (usuario.getTipoUsuario().toString()){
                case "Normal":
                    stmUsuario = con.prepareStatement("delete from usuario where id_usuario = ? ");
                    stmUsuario.setString(1, usuario.getIdUsuario());
                    stmUsuario.executeUpdate();
                    break;
                case "Gestor":
                    stmUsuario = con.prepareStatement("delete from usuario_gestor where id_gestor = ? ");
                    stmUsuario.setString(1, usuario.getIdUsuario());
                    stmUsuario.executeUpdate();
                    break;
                case "Administrador":
                    stmUsuario = con.prepareStatement("delete from administrador where id_administrador = ? ");
                    stmUsuario.setString(1, usuario.getIdUsuario());
                    stmUsuario.executeUpdate();
                    break;
            }
            
        }catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {if (stmUsuario != null) stmUsuario.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }

   
}
