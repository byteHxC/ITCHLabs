/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inserciones;

import itchlabs.Principal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author kevindaniel
 */
public class Insercion {
    public String CrearConsulta(JTextField[] campos,String nom_tabla,ArrayList<Columna> lista){
        String sql ="INSERT INTO "+nom_tabla+" VALUES(";
        String agregar="";
        for (int i =0;i<campos.length;i++) {
            if(i!=campos.length-1){
               if(campos[i].getText().equalsIgnoreCase("default") || campos[i].getText().equalsIgnoreCase("null") || lista.get(i).getTipo().equalsIgnoreCase("NUMBER")){
                  agregar=campos[i].getText()+",";
               }else{
               agregar="'"+campos[i].getText() +"',";
               }
            }
            if(i==campos.length-1){
               if(campos[i].getText().equalsIgnoreCase("default") || campos[i].getText().equalsIgnoreCase("null") || lista.get(i).getTipo().equalsIgnoreCase("NUMBER")){
                   agregar=campos[i].getText()+")";
               }
               else{
                   agregar="'"+campos[i].getText()+"')";
               }
            }
            sql+=agregar;
        }        
        return sql;
    }
        public void InsertarDatos(String sql){
          try {
            System.out.println(sql);
            Statement st=Principal.con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "DATO AGREGADO");
          } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null, ex.getMessage());
          }
    }
}
