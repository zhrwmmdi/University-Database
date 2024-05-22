package main.java.forms;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import main.java.tools.Tools;

public class TakeCourse extends javax.swing.JFrame {

    private String loginId;
    private boolean canTake;
    
    public TakeCourse() {
        initComponents();
    }
    public TakeCourse(String loginId) {
        this.loginId = loginId;
        initComponents();
        Tools.setCenter(this);
        Tools.fillPanelName(loginId, "student", jLabel2);
        fillCoursesTable();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Student Name:");

        jLabel2.setText("jLabel2");

        jLabel3.setText("Courses:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Course ID", "Title", "Department Name", "Credits"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Take Course");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setText("Instructors:");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Instructor ID", "Instructor Name"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton1)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(44, 44, 44)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //take course
        String selectedCourseId = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
        String selectedInstructorId = jTable2.getValueAt(jTable2.getSelectedRow(), 0).toString(); 
        String addedCredits = jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString();
        try{
                    if(canTake){
                   updateRelations(loginId, selectedCourseId,selectedInstructorId,Integer.parseInt(addedCredits));
                   JOptionPane.showMessageDialog(null, "You took the course successfully!",
                                                                               "Success", JOptionPane.INFORMATION_MESSAGE);
               }else{
                    JOptionPane.showMessageDialog(null, "You can't take this course because you haven't passed its prerequired course.",
                                                                               "Error", JOptionPane.ERROR_MESSAGE);
               }
        }catch(SQLException ex){
            System.out.println("Error in updating relations, "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Taking the course wasn't successful.",
                                                                               "Error", JOptionPane.ERROR_MESSAGE);
        }
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       Tools.clearTable(jTable2);
        String selectedCourseId = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
        canTake = checkPreReq(loginId, selectedCourseId);
        String department = jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString();
        displayValidInstrcutors(department);
    }//GEN-LAST:event_jTable1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TakeCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TakeCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TakeCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TakeCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TakeCourse().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables

    private void fillCoursesTable() {
        try {
            PreparedStatement state = Tools.connectToDB().prepareStatement("select * from course;");
            ResultSet resultSet = state.executeQuery();
            
            while(resultSet.next()){
                String courseId = resultSet.getString(1);
                String courseTitle = resultSet.getString(2);
                String deptName = resultSet.getString(3);
                String credits = resultSet.getString(4);
                
                Object[] content = {courseId,courseTitle, deptName,credits};
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.addRow(content);
            }
            
            state.close();
            Tools.closeConnection();
     
        } catch (SQLException ex) {
            System.out.println("Error in fillCourseTable method of TakeCourse class: "+ex.getMessage());
        }
    }

    private boolean checkPreReq(String loginId, String selectedCourseId) {
        try {
            PreparedStatement state = Tools.connectToDB().prepareStatement("select prereq_id from prereq where course_id=?");
            state.setString(1, selectedCourseId);
            ResultSet result = state.executeQuery();
            if(result.next()){
                //the course needs a prereq
                String prereqId = result.getString(1);
                state = Tools.connectToDB().prepareStatement( "select * from takes where id=? and course_id=? ");
                state.setString(1, loginId);
                state.setString(2, prereqId);
                result = state.executeQuery();
                if(!result.next()){
                    JOptionPane.showMessageDialog(null, "You can't take this course because you haven't passed its prerequired course.",
                                                                        "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Error in checkPreReq method of TakeCourse class: "+ex.getMessage());
        }  
        return true;
    }

    private void displayValidInstrcutors(String department) {
        try {
            PreparedStatement state = Tools.connectToDB().prepareStatement("select id, name from instructor where dept_name=?");
            state.setString(1, department);
            ResultSet result = state.executeQuery();
            while(result.next()){
                String id = result.getString(1);
                String name = result.getString(2);
                
                Object[] content = {id, name};
                DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
                model.addRow(content);
            }
        } catch (SQLException ex) {
            System.out.println("Error in displayValidInstrcutors method in TakeCourse class: "+ex.getMessage());
        }
    }

    private void updateRelations(String studentId, String courseId, String instructorId, int addedCredit) throws SQLException{
        
        PreparedStatement state = Tools.connectToDB().prepareStatement("insert into section values(?,2,'Spring',2024,null, null,null);");
            state.setString(1, courseId);
             int rowsInserted = state.executeUpdate();
             if (rowsInserted != 1){
                 throw new SQLException("Error in updating section relation.");
             }

            state = Tools.connectToDB().prepareStatement("insert into takes values(?,?,2,'Spring',2024,null);");
            state.setString(1, studentId);
             state.setString(2, courseId);
             rowsInserted = state.executeUpdate();
             if (rowsInserted != 1){
                 throw new SQLException("Error in updating takes relation.");
             }
             
             state = Tools.connectToDB().prepareStatement("insert into teaches values(?,?,2,'Spring',2024);");
            state.setString(1, instructorId);
             state.setString(2, courseId);
             rowsInserted = state.executeUpdate();
             if (rowsInserted != 1){
                 throw new SQLException("Error in updating teaches relation.");
             }
             
             state = Tools.connectToDB().prepareStatement("UPDATE student SET tot_cred = tot_cred + ? WHERE id=?;");
            state.setInt(1, addedCredit);
             state.setString(2, studentId);
             rowsInserted = state.executeUpdate();
             if (rowsInserted != 1){
                 throw new SQLException("Error in updating student relation.");
             }
    }

}
