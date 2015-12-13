/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inserciones;

import itchlabs.Principal;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author kevindaniel
 */
public class ListaColumnas {
    private ArrayList<Columna>Columnas= new ArrayList();
    
    public ArrayList<Columna> rcol (String tabla){
         try{
           ResultSet rs = Principal.con.prepareStatement("select cname,coltype from col where tname = "+"'"+tabla.toUpperCase()+"'").executeQuery();
           Columnas.removeAll(Columnas);
           while (rs.next()){
           Columnas.add(new Columna(rs.getString(1),rs.getString(2)));
           }
         }catch(SQLException e){
             System.out.println(e.getMessage());   
         }
         return Columnas;
    }
}
