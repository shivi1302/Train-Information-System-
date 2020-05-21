package admin.ui;

import java.beans.PropertyVetoException;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import model.dao.PassengerInfoDAO;
import model.to.PassengerInfoTO;
import operation.checks;

public class AddPassengerInfo extends javax.swing.JInternalFrame {

    public int BookID;

    public AddPassengerInfo() {
        initComponents();
        setSize(650, 450);
        jcbGender.removeAllItems();
        jcbGender.addItem("Select Any Gender");
        String G1 = "Male";
        String G2 = "Female";
        jcbGender.addItem(G1);
        jcbGender.addItem(G2);
    }
    PassengerInfoTO updateData;

    public AddPassengerInfo(PassengerInfoTO updata) {
        this();
        updateData = updata;
        if (updateData != null) {
            jbtnAddPassengerInfo.setText("Update Passenger Info");
            jtfPassengerName.setText(updateData.getPassengerName());
            jtfAge.setText(String.valueOf(updateData.getAge()));

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfAge = new javax.swing.JTextField();
        jtfPassengerName = new javax.swing.JTextField();
        jbtnAddPassengerInfo = new javax.swing.JButton();
        jcbGender = new javax.swing.JComboBox();

        setClosable(true);
        setIconifiable(true);
        setTitle("Add Passenger Info");
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Age :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(70, 220, 250, 40);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Passenger Name :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(70, 60, 250, 40);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Gender :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(70, 140, 250, 40);
        getContentPane().add(jtfAge);
        jtfAge.setBounds(270, 220, 350, 40);
        getContentPane().add(jtfPassengerName);
        jtfPassengerName.setBounds(270, 60, 350, 40);

        jbtnAddPassengerInfo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jbtnAddPassengerInfo.setText("Add Passenger Info");
        jbtnAddPassengerInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAddPassengerInfoActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnAddPassengerInfo);
        jbtnAddPassengerInfo.setBounds(170, 320, 360, 70);

        jcbGender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jcbGender);
        jcbGender.setBounds(270, 140, 350, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnAddPassengerInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAddPassengerInfoActionPerformed
        String message = "";
        try {
            String PassengerName = jtfPassengerName.getText().trim();
            String Age = jtfAge.getText().trim();
            String Gender=jcbGender.getSelectedItem().toString();
            if (checks.isEmpty(Age) || checks.isEmpty(PassengerName)) {
                message = "Please Enter Some Value";
            } else if (checks.isNumeric(Age)) {
                PassengerInfoTO data = new PassengerInfoTO();
                data.setPassengerName(PassengerName);
                data.setAge(Integer.parseInt(Age));
                data.setGender(Gender);
                data.setBookID(BookID);
                PassengerInfoDAO action = new PassengerInfoDAO();
                if (jbtnAddPassengerInfo.getText().contains("Add")) {
                    if (action.insertRecord(data)) {
                        message = "Record Inserted";
                        dispose();
                    } else {
                        message = action.getErrorMessage();
                    }
                } else if (jbtnAddPassengerInfo.getText().contains("Update")) {
                    if (action.updateRecord(data)) {
                        message = "Record Updated";
                    } else {
                        message = action.getErrorMessage();
                    }
                    JOptionPane.showMessageDialog(this, message);
                    ViewPassengerInfo obj = new ViewPassengerInfo();
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
    }//GEN-LAST:event_jbtnAddPassengerInfoActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jbtnAddPassengerInfo;
    private javax.swing.JComboBox jcbGender;
    private javax.swing.JTextField jtfAge;
    private javax.swing.JTextField jtfPassengerName;
    // End of variables declaration//GEN-END:variables
}
