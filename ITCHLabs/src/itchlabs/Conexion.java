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
import javax.swing.JOptionPane;
public class Conexion {
   private static Connection conexion;
   public static Connection Conectar(String usuario,String contraseña)
    {
        try{
        Class.forName("oracle.jdbc.OracleDriver");
        conexion= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",usuario,contraseña);
        if(conexion!=null)
            JOptionPane.showMessageDialog(null,"Conexion exitosa a "+usuario);
        }
        catch(Exception e)
        {e.printStackTrace();}
        return conexion;
    }
}
