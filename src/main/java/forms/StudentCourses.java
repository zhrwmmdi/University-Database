package main.java.forms;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import main.java.tools.Tools;

public class StudentCourses extends javax.swing.JFrame {

    private String loginId;
    private String deleted_course_id;

    public StudentCourses() {
        initComponents();
    }

    public StudentCourses(String loginId) {
        initComponents();
        this.loginId = loginId;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Tools.setCenter(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Course_id", "Course Title", "Credits"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Spring", "Summer", "Fall", "Winter" }));

        jLabel1.setText("Year:");

        jLabel2.setText("Semester:");

        jLabel3.setText("Section:");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2" }));

        jButton1.setText("See Courses");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Delete Course");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Current Semester");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1))
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jButton4))))
                .addGap(0, 33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(83, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addComponent(jButton3)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        getCurrentCourses();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow == -1) {
            //no rows are selected
            JOptionPane.showMessageDialog(null, "Choose a course!",
                    "Fail", JOptionPane.WARNING_MESSAGE);
        } else {
            if (canDelete()) {
                try {
                    updateRelations();
                    JOptionPane.showMessageDialog(null, "Course Deleted Successfully!",
                            "Success", JOptionPane.INFORMATION_MESSAGE);
                    getCurrentCourses();
                } catch (SQLException ex) {
                    System.out.println("Error in delete course button of StudentCourses class: " + ex.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(null, "You can't delete any more courses this semester\nbecause you have already deleted course %s".formatted(deleted_course_id),
                        "Fail", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jComboBox1.setSelectedIndex(0);
        jComboBox2.setSelectedIndex(1);
        jTextField1.setText("2024");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void updateRelations() throws SQLException {
        //Tools.connectToDB();
       // Tools.getConnection().setAutoCommit(false);

        PreparedStatement state = Tools.connectToDB()
                .prepareStatement("insert into deletion values(?,?,?,?,?);");

        state.setString(1, loginId);
        state.setString(2, jComboBox1.getSelectedItem().toString());
        state.setInt(3, Integer.parseInt(jTextField1.getText()));
        state.setString(4, String.valueOf(jComboBox2.getSelectedItem()));
        state.setString(5, jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());

        int rowsChanged = state.executeUpdate();
        System.out.println("here+"+ rowsChanged);
        if (rowsChanged != 1) {
            throw new SQLException("Error in insertion of deletion relation.");
        }

        state = Tools.connectToDB().prepareStatement("UPDATE student SET tot_cred = tot_cred - ? WHERE id=?;");
        state.setInt(1, Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString()));
        state.setString(2, loginId);
        rowsChanged = state.executeUpdate();
        if (rowsChanged != 1) {
            //Tools.getConnection().rollback();
            throw new SQLException("Error in updating student relation.");
        }

        state = Tools.connectToDB().prepareStatement("delete from section where course_id=? and sec_id=? and semester=? and year=?;");

        state.setString(1, jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
        state.setString(2, jComboBox2.getSelectedItem().toString());
        state.setString(3, jComboBox1.getSelectedItem().toString());
        state.setString(4, jTextField1.getText());

        rowsChanged = state.executeUpdate();
        if (rowsChanged != 1) {
            //Tools.getConnection().rollback();
            throw new SQLException("Error in updating section relation.");
        }

      //  Tools.getConnection().commit();
        state.close();
        Tools.closeConnection();
    }

    private void getCurrentCourses() {
        Tools.clearTable(jTable1);
        try {
            String query = "select course.course_id, title, credits from course natural join takes where id = ? and semester=? and year=? and sec_id=?";
            try ( PreparedStatement state = Tools.connectToDB().prepareStatement(query)) {
                state.setString(1, loginId);
                state.setString(2, jComboBox1.getSelectedItem().toString());
                state.setString(3, jTextField1.getText());
                state.setString(4, jComboBox2.getSelectedItem().toString());
                ResultSet result = state.executeQuery();
                while (result.next()) {
                    String course_id = result.getString(1);
                    String title = result.getString(2);
                    String credit = result.getString(3);

                    Object[] content = {course_id, title, credit};
                    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                    model.addRow(content);
                }
            }
            Tools.closeConnection();

        } catch (SQLException e) {
            System.out.println("Error in see getCurrentCourses method of StudentCourses class: " + e.getMessage());
        }
    }

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
            java.util.logging.Logger.getLogger(StudentCourses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentCourses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentCourses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentCourses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentCourses().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    private boolean canDelete() {
        try {
            String query = "select deleted_course_id from deletion where id=? and semester=? and year=? and sec_id=?";
            PreparedStatement state = Tools.connectToDB().prepareStatement(query);

            state.setString(1, loginId);
            state.setString(2, jComboBox1.getSelectedItem().toString());
            state.setString(3, jTextField1.getText());
            state.setString(4, jComboBox2.getSelectedItem().toString());

            ResultSet result = state.executeQuery();
            if (result.next()) {
                deleted_course_id = result.getString(1);
                state.close();
                Tools.closeConnection();
                return false;
            } else {
                state.close();
                Tools.closeConnection();
                return true;
            }

        } catch (SQLException ex) {
            System.out.println("Error in canDelete method of StudentCourses class:  " + ex.getMessage());
        }
        return false;
    }

}
