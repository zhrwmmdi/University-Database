/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.tools;



import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class Tools  {
    static String url = "jdbc:mysql://localhost:3306/university";
    static String username = "root";
    static String password = "zAhra-4012023026";
    
    static Connection connect;
    ResultSet result;
    
    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection(url, username, password);
        }catch(Exception e){
            System.out.println("Error in getConnection method"+e.getMessage());  
        }
        return connect;
    }
    
    public void setCenter(JFrame frame){
        Toolkit tool = Toolkit.getDefaultToolkit();
        double screenHeight = tool.getScreenSize().getHeight();
        double screenWidth = tool.getScreenSize().getWidth();
        double frameHeight = frame.getHeight();
        double frameWidth = frame.getWidth();
        double x = (screenWidth - frameWidth)/2;
        double y = (screenHeight-frameHeight)/2;
        frame.setLocation((int)x, (int)y);
    }
    public void setIcon(JFrame frame, String iconResource){
        ImageIcon icon = new ImageIcon(getClass().getResource(iconResource));
        frame.setIconImage(icon.getImage());
    }
    public int[] fillComboBox(JComboBox box, String query, String[] items, int [] itemID){
     try {
            
            connect = DriverManager.getConnection(url,username,password);
            PreparedStatement PreparedState = connect.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            result = PreparedState.executeQuery(query);
            result.last();
            int rowCount = result.getRow();
            result.beforeFirst();
            items = new String[rowCount];
            itemID = new int[rowCount];
            int x = 0;
            while(result.next()){
                items[x] = result.getString(2);
                itemID [x] = result.getInt(1);
                x++;
            }
            box.setModel(new DefaultComboBoxModel(items));
                return itemID;
        } catch (SQLException ex) {
          System.out.println(ex.getMessage());
         return null;
        }
    }
}
