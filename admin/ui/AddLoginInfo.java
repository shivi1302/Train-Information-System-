/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.ui;

import java.beans.PropertyVetoException;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import model.dao.LoginInfoDAO;
import model.to.LoginInfoTO;
import operation.checks;

public class AddLoginInfo extends javax.swing.JInternalFrame {

    public AddLoginInfo() {
        initComponents();
        setSize(650, 450);
        jcbAddLoginInfoRoleName.removeAllItems();
        jcbAddLoginInfoRoleName.addItem("Select Any Role Name");
        jcbAddLoginInfoRoleName.addItem("User");
        jcbAddLoginInfoRoleName.addItem("Admin");
    }
    LoginInfoTO updateData;
    public AddLoginInfo(LoginInfoTO data) {
        this();
        updateData=data;
        if (updateData != null) {
            jtfUsername.setText(data.getUserName());
            jtfPassword.setText(data.getPassword());
            jtfUsername.setEditable(false);
            jbtnAddLoginInfo.setText("Update LoginInfo");
         
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfUsername = new javax.swing.JTextField();
        jtfPassword = new javax.swing.JTextField();
        jbtnAddLoginInfo = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jcbAddLoginInfoRoleName = new javax.swing.JComboBox();

        setClosable(true);
        setIconifiable(true);
        setTitle("Add LoginInfo");
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Choose Role Name :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(60, 60, 170, 50);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Enter Password :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(60, 240, 180, 40);
        getContentPane().add(jtfUsername);
        jtfUsername.setBounds(280, 150, 210, 50);
        getContentPane().add(jtfPassword);
        jtfPassword.setBounds(280, 240, 210, 50);

        jbtnAddLoginInfo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jbtnAddLoginInfo.setText("Add LoginInfo");
        jbtnAddLoginInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAddLoginInfoActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnAddLoginInfo);
        jbtnAddLoginInfo.setBounds(210, 350, 240, 60);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Enter UserName :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(60, 140, 140, 50);

        jcbAddLoginInfoRoleName.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jcbAddLoginInfoRoleName);
        jcbAddLoginInfoRoleName.setBounds(280, 70, 210, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnAddLoginInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAddLoginInfoActionPerformed
        String message = " ";
        try {
            String UserName = jtfUsername.getText().trim();
            String Password = jtfPassword.getText().trim();
            String RoleName=jcbAddLoginInfoRoleName.getSelectedItem().toString();
            if (checks.isEmpty(UserName) || checks.isEmpty(Password)) {
                message = "Please Enter Some Value";
            } else{                    
                LoginInfoTO data = new LoginInfoTO();
                data.setUserName(UserName);
                data.setPassword(Password);
                data.setRoleName(RoleName);
                LoginInfoDAO action = new LoginInfoDAO();
                if (jbtnAddLoginInfo.getText().contains("Add")) {
                    if (action.insertRecord(data)) {
                        message = "One Record Inserted";
                        dispose();
                    } else {
                        message = action.getErrorMessage();
                    }
                } else if (jbtnAddLoginInfo.getText().contains("Update")) {
                    if (action.updateRecord(data)) {
                        message = "One Record Updated";
                    } else {
                        message = action.getErrorMessage();
                        if (message.contains("PRIMARY")){
                        message="This UserName Is Already In Use";
                        }
                    }
                    JOptionPane.showMessageDialog(this, message);
                    ViewLoginInfo obj = new ViewLoginInfo();
                    obj.setVisible(true);
                    JDesktopPane jdp = getDesktopPane();
                    jdp.add(obj);
                    try {
                        obj.setSelected(true);
                    } catch (PropertyVetoException ex) {
                    }
                    dispose();
                }
            }
        } catch (Exception ex) {
            message = ex.getMessage();
        }
        JOptionPane.showMessageDialog(this, message);
    }//GEN-LAST:event_jbtnAddLoginInfoActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jbtnAddLoginInfo;
    private javax.swing.JComboBox jcbAddLoginInfoRoleName;
    private javax.swing.JTextField jtfPassword;
    private javax.swing.JTextField jtfUsername;
    // End of variables declaration//GEN-END:variables
}
