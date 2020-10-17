/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/**
 *
 * @author user
 */
public class testController {
    @GET
    @Path("/getdata")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<testModel> getDataInJSON() throws ClassNotFoundException, SQLException
    {
        ArrayList <testModel> tm= new ArrayList<>();
        Connection con=null;
        String username="test";
        String password="test123";
        String Query= "select * from test";
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        con=DriverManager.getConnection("jdbc:derby://localhost:1527/firstDatabase",username,password);
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(Query);
        while(rs.next())
        {
            testModel ts = new testModel();
            ts.setId(rs.getInt("id"));
            ts.setName(rs.getString("name"));
            ts.setEmail(rs.getString("email"));
            tm.add(ts);
            
            
            
        }
        return tm;
        
        
        
        
        
    }
    
}
