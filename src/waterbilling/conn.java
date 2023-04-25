/*  for database connection*/
package Waterbilling;

import java.sql.*;  

public class conn {
  Connection c;
    Statement s;
    public conn(){  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            c = DriverManager.getConnection("jdbc:mysql:///wbs","root","artrekkers");   
            s =c.createStatement();  
            
           
        }catch(Exception e){       // to handle exception
            System.out.println(e); 
        }  
    }  
}  