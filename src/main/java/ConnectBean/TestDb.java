/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class TestDb {
    
     public static void main(String[] args){

	
        
        try {
            ConnectionProvider provider=new ConnectionProvider();
            Connection con=provider.getCon();
            System.out.println("Hello World");
            String idcode="ROW001";
            // Tạo một câu SQL có 1 tham số (?)
            String sql = " SELECT * FROM  public.city_list ";
            
            // Tạo một đối tượng PreparedStatement.
            PreparedStatement pstm = con.prepareStatement(sql);
            
            // Sét đặt giá trị tham số thứ nhất (Dấu ? thứ nhất)        
           // pstm.setString(1, idcode);
            
            ResultSet rs = pstm.executeQuery();
            
             while (rs.next()) {
                 
                String kqtam="";
                kqtam=rs.getString("city_name");
                System.out.println(kqtam);
            }
             
            pstm.close();
            con.close();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(TestDb.class.getName()).log(Level.SEVERE, null, ex);
        }
	
}
    
    
    
}
