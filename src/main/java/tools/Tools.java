package main.java.tools;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import main.java.forms.InstructorStudentsList;

public class Tools  {
    static String url = "jdbc:mysql://localhost:3306/university";
    static String username = "root";
    static String password = "zAhra-4012023026";
    
    static Connection connect;
    
    public static Connection connectToDB(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection(url, username, password);
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Error in getConnection method in Tools class: "+e.getMessage());  
        }
        return connect;
    }

    public static void closeConnection() {
        try {
            connect.close();
        } catch (SQLException ex) {
            System.out.println("Error in closeConnection method of Tools class: "+ex.getMessage());
        }
    }
    
    
    public static void setCenter(JFrame frame){
        Toolkit tool = Toolkit.getDefaultToolkit();
        double screenHeight = tool.getScreenSize().getHeight();
        double screenWidth = tool.getScreenSize().getWidth();
        double frameHeight = frame.getHeight();
        double frameWidth = frame.getWidth();
        double x = (screenWidth - frameWidth)/2;
        double y = (screenHeight-frameHeight)/2;
        frame.setLocation((int)x, (int)y);
    }

    
    public static void fillPanelName(String loginId, String relation, JLabel jLabel) {
        try {
             PreparedStatement state = Tools.connectToDB().prepareStatement("select name from %s where id=?".formatted(relation));
             state.setString(1, loginId);
             ResultSet result = state.executeQuery();
             result.next();
             jLabel.setText(result.getString(1));
         } catch (SQLException ex) {
             Logger.getLogger(InstructorStudentsList.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
}

