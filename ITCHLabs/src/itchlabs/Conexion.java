/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itchlabs;

/**
 *
 * @author kevindaniel
 */
import java.sql.*;
public class Conexion {
   private static Connection conexion;
    public static Connection conexion (String bd,String usuario,String contraseña){
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/"+bd;
            conexion = DriverManager.getConnection(url,usuario,contraseña);
            if(conexion!=null){
                System.out.println("conectado");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
      return conexion;
    }
}
