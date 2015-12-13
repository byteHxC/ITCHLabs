/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inserciones;

import itchlabs.Principal;
import java.sql.*;
import javax.swing.JTextField;

/**
 *
 * @author kevindaniel
 */
public class ID {

    public void gi(String tabla,JTextField txt){
           try {
            ResultSet rs = Principal.con.prepareStatement("select count(*) from "+tabla).executeQuery();
            while (rs.next()) {                
                txt.setText(""+(rs.getInt(1)+1));
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
