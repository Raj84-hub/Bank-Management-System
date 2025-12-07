// we use JDBC connectivity to connect database base
// steps of JDBC connectivity ->
/*    - register the driver
    - create connection
    - create Statement
    - execute query
    - close connection
*/

package bank.management.system;

import java.sql.*;

// create connection
public class Conn {
    Connection c;
    Statement s; // object for creating statement
    
    public Conn(){
    // need exception handling because mysql is a external entity so there may be error in run time not compile time
        try {
           // create connection
           c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "Oriental@87");
           s = c.createStatement(); // to Create statement
        } 
        catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
