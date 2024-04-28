/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baseDatos;

import aplicacion.Categoria;
import java.sql.Connection;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author alumnogreibd
 */
public class DAOCategorias extends AbstractDAO {

    public DAOCategorias(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public List<Categoria> consultarCategorias(String nombre) {
        List<Categoria> resultado = new ArrayList<>();
        Connection con = null;
        PreparedStatement stmCategorias = null;
        ResultSet rsCategorias = null;

        con = this.getConexion();

        String consultaCategorias = "SELECT nombre FROM categoria as c WHERE nombre like ? ";

        try {

            stmCategorias = con.prepareStatement(consultaCategorias);
            stmCategorias.setString(1, "%" + nombre + "%");
            rsCategorias = stmCategorias.executeQuery();

            while (rsCategorias.next()) {
                resultado.add(new Categoria(rsCategorias.getString("nombre")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (stmCategorias != null) {
                    stmCategorias.close();
                }
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }

    public void insertarCategoria(Categoria c) {
        Connection con = null;
        PreparedStatement stmCategoria = null;

        con = this.getConexion();

        try {
            stmCategoria = con.prepareStatement("insert into categoria(nombre) "
                    + "values (?)");
            stmCategoria.setString(1, c.getNombre());
            stmCategoria.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmCategoria.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    public void borrarCategoria(Categoria c) {
        Connection con = null;
        PreparedStatement stmCategoria = null;

        con = this.getConexion();

        try {
            stmCategoria = con.prepareStatement("delete from categoria where nombre = ? ");
            stmCategoria.setString(1, c.getNombre());
            stmCategoria.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmCategoria.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

public void editarCategoria(String nombreAntiguo, String nuevoNombre) {
        Connection con = null;
        PreparedStatement stmCategoria = null;

        try {
            // Establecer la conexión
            con = this.getConexion();// Este método debe obtener la conexión a tu base de datos

            // Consulta para actualizar el nombre de la categoría
            stmCategoria = con.prepareStatement("UPDATE categoria SET nombre = ? WHERE nombre = ?");
            stmCategoria.setString(1, nuevoNombre);
            stmCategoria.setString(2, nombreAntiguo);

            // Ejecutar la consulta de actualización
            stmCategoria.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmCategoria.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }
}
