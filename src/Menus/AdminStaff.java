/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Menus;

import Dashboards.DashboardAdmin;
import DataModels.User;
import DatabaseInstance.Database;
import DatabaseInstance.DatabaseResultResponse;
import java.awt.Dimension;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Irzi Rhmtllh
 */
public class AdminStaff extends javax.swing.JFrame {

    ArrayList<User> listApprovedUser;
    ArrayList<User> listPendingUser;
    DefaultTableModel approvedTableModel;
    DefaultTableModel pendingTableTableModel;
    Database db = new Database();
    
    public AdminStaff() {
        initComponents();
        setTitle("Hotel Management System");
        setVisible(false);
        setLocationRelativeTo(null);
        setBackgroundMenu("/Images/adminBackground.jpg");
        getStaffData();
    }
    
    public void getStaffData() {
        listApprovedUser = db.getStaff("approved").data;
        listPendingUser = db.getStaff("pending").data;
        showDataTable();
    }
    
    public void showDataTable(){
        String[] headerTableColumns = {"Email", "Name", "Username", "Status"};
        Object[][] approvedUserData = new Object[listApprovedUser.size()][headerTableColumns.length];
        Object[][] pendingUserData = new Object[listPendingUser.size()][headerTableColumns.length];
        int i = 0;
        
        for(User user: listApprovedUser) {
            String userData[] = {user.getEmail(), user.getName(), user.getUsername(), user.getStatus()};
            approvedUserData[i] = userData;
            i++;
        };
        i = 0;
        
        for(User user: listPendingUser) {
            String userData[] = {user.getEmail(), user.getName(), user.getUsername(), user.getStatus()};
            pendingUserData[i] = userData;
            i++;
        };
        
        approvedTableModel = new DefaultTableModel(approvedUserData, headerTableColumns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            };        
        };
        pendingTableTableModel = new DefaultTableModel(pendingUserData, headerTableColumns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            };        
        };
        
        approvedTable.setModel(approvedTableModel);
        pendingTable.setModel(pendingTableTableModel);  
    };    
    
    private void setBackgroundMenu(String urlImg) {

        Dimension screenSize = new Dimension(1080, 720);

        // background menu
        ImageIcon originalIcon = new ImageIcon(getClass().getResource(urlImg));
        Image scaledImage = originalIcon.getImage().getScaledInstance((int) screenSize.getWidth(), (int) screenSize.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        bgImage.setIcon(scaledIcon);
        bgImage.setText("");
        bgImage.setSize(screenSize);
        getContentPane().setLayout(null);
        getContentPane().add(bgImage);
        bgImage.setBounds(0, 0, (int) screenSize.getWidth(), (int) screenSize.getHeight());
    };     

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgImage = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        approvedTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        pendingTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(1080, 720));

        bgImage.setText("jLabel1");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        approvedTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Email", "Name", "Username", "Status"
            }
        ));
        jScrollPane2.setViewportView(approvedTable);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Approved Staff");

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 0, 0));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/decline.png"))); // NOI18N
        jButton4.setText("Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        pendingTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Email", "Name", "Username", "Status"
            }
        ));
        jScrollPane3.setViewportView(pendingTable);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Pending Staff");

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/decline.png"))); // NOI18N
        jButton1.setText("Decline");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 255, 51));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/accept.png"))); // NOI18N
        jButton2.setText("Accept");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(89, 89, 89))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Staff List");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/back.png"))); // NOI18N
        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(0, 0, 255));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/refresh.png"))); // NOI18N
        jButton6.setText("Refresh");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bgImage)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(468, 468, 468))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(83, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton6)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(52, 52, 52))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bgImage)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new DashboardAdmin().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        getStaffData();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                 
        int selectedRow = pendingTable.getSelectedRow();
        if(selectedRow <0) return;
        
        String username = pendingTable.getValueAt(selectedRow, 2).toString();
        String name = pendingTable.getValueAt(selectedRow, 1).toString();
        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure want to decline " + name, "Confirm Decline", JOptionPane.YES_NO_OPTION);
        if(confirm == JOptionPane.YES_OPTION) {
            try {
                DatabaseResultResponse response = db.deleteStaff(username);
                if(response.status == 200) {
                    JOptionPane.showMessageDialog(this, "Success Declining " + name);
                    getStaffData();
                } else {
                    JOptionPane.showMessageDialog(this, response.message);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        } else {
            return;
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int selectedRow = approvedTable.getSelectedRow();
        if(selectedRow <0) return;
        String username = approvedTable.getValueAt(selectedRow, 2).toString();
        String name = approvedTable.getValueAt(selectedRow, 1).toString();
        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure want to delete " + name, "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if(confirm == JOptionPane.YES_OPTION) {
            try {
                DatabaseResultResponse response = db.deleteStaff(username);
                if(response.status == 200) {
                    JOptionPane.showMessageDialog(this, "Success Deleting " + name);
                    getStaffData();
                } else {
                    JOptionPane.showMessageDialog(this, response.message);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        } else {
            return;
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int selectedRow = pendingTable.getSelectedRow();
        if(selectedRow <0) return;
        String username = pendingTable.getValueAt(selectedRow, 2).toString();
        String name = pendingTable.getValueAt(selectedRow, 1).toString();
        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure want to approving " + name, "Confirm", JOptionPane.YES_NO_OPTION);
        if(confirm == JOptionPane.YES_OPTION) {
            try {
                DatabaseResultResponse response = db.approveStaff(username);
                if(response.status == 200) {
                    JOptionPane.showMessageDialog(this, "Success Approving " + name);
                    getStaffData();
                } else {
                    JOptionPane.showMessageDialog(this, response.message);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        } else {
            return;
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(AdminStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminStaff().setVisible(false);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable approvedTable;
    private javax.swing.JLabel bgImage;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable pendingTable;
    // End of variables declaration//GEN-END:variables
}
