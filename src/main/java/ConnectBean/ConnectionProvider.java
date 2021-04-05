 
package ConnectBean;
 
import static ConnectBean.Provider.*;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class ConnectionProvider {
   
private   Connection conn=null;

public   Connection getCon()  {
 
    
    try {
        String url = URL;
        Properties props = new Properties();
        props.setProperty("user",USERNAME);
        props.setProperty("password",PASSWORD);
        props.setProperty("ssl","false");
        Connection conn = DriverManager.getConnection(url, props);
        
        return conn;
    } catch (SQLException ex) {
        //Logger.getLogger(ConnectionProvider.class.getName()).log(Level.SEVERE, null, ex);
        return null;
    }
 
}
}