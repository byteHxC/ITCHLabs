/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inserciones;

import java.sql.*;
import javax.swing.JTextField;

/**
 *
 * @author kevindaniel
 */
public class ID {
    private Connection con;

    public ID(Connection con) {
        this.con = con;
    }
    public void gi(String tabla,JTextField txt){
           try {
            ResultSet rs = con.prepareStatement("select count(*) from "+tabla).executeQuery();
            while (rs.next()) {                
                txt.setText(""+(rs.getInt(1)+1));
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
