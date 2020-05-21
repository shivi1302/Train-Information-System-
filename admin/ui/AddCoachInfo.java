package admin.ui;

import java.beans.PropertyVetoException;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import model.dao.CoachInfoDAO;
import model.to.CoachInfoTO;
import operation.checks;

public class AddCoachInfo extends javax.swing.JInternalFrame {

    
    public AddCoachInfo() {
        initComponents();
        setSize(650,450);
    }

    public AddCoachInfo(CoachInfoTO data){
        this();
        if(data!=null){
            jtfCoachType.setText(data.getCoachType());
            jtfCoachID.setText(data.getCoachID());
            jtfNumberOfSeats.setText(String.valueOf(data.getNumberOfSeats()));
            jtfCoachID.setEditable(false);
            jbtnAddCoachInfo.setText("Update Coach Info");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfNumberOfSeats = new javax.swing.JTextField();
        jtfCoachType = new javax.swing.JTextField();
        jtfCoachID = new javax.swing.JTextField();
        jbtnAddCoachInfo = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Add CoachInfo");
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Number Of Seats :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 180, 200, 50);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Enter Coach Type :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 24, 200, 50);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Enter Coach ID :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(40, 100, 200, 50);
        getContentPane().add(jtfNumberOfSeats);
        jtfNumberOfSeats.setBounds(280, 180, 290, 40);
        getContentPane().add(jtfCoachType);
        jtfCoachType.setBounds(280, 30, 290, 40);
        getContentPane().add(jtfCoachID);
        jtfCoachID.setBounds(280, 100, 290, 40);

        jbtnAddCoachInfo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jbtnAddCoachInfo.setText("Add Coach Info");
        jbtnAddCoachInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAddCoachInfoActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnAddCoachInfo);
        jbtnAddCoachInfo.setBounds(150, 270, 310, 70);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnAddCoachInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAddCoachInfoActionPerformed
        String message="";
        try{
            String CoachType=jtfCoachType.getText().trim();
            String CoachID=jtfCoachID.getText().trim();
            String NumberOfSeats=jtfNumberOfSeats.getText().trim();
            if(checks.isEmpty(CoachID)|| checks.isEmpty(CoachType) || checks.isEmpty(NumberOfSeats)){
                message="Please Enter Some Value ";
            }else if(checks.isNumeric(NumberOfSeats)){
                CoachInfoTO data=new CoachInfoTO();
                data.setCoachType(CoachType);
                data.setCoachID(CoachID);
                data.setNumberOfSeats(Integer.parseInt(NumberOfSeats));
                CoachInfoDAO action=new CoachInfoDAO();
                if(jbtnAddCoachInfo.getText().contains("Add")){
                if(action.insertRecord(data)){
                    message="Record Inserted";
                    dispose();
                }else{
                    message=action.getErrorMessage();
                }
            }else if(jbtnAddCoachInfo.getText().contains("Update")){
                if(action.updateRecord(data)){
                    message="Record Updated";
                }else{
                    message=action.getErrorMessage();
                }
                JOptionPane.showMessageDialog(this, message);
                ViewCoachInfo obj=new ViewCoachInfo();
                obj.setVisible(true);
                    JDesktopPane jdp=getDesktopPane();
                    jdp.add(obj);
                    try{
                        obj.setSelected(true);
                    }catch(PropertyVetoException ex){
                    }
                    dispose();
            }
          } 
        }catch(Exception ex){
            message=ex.getMessage();
        }
        JOptionPane.showMessageDialog(this, message);
    }//GEN-LAST:event_jbtnAddCoachInfoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jbtnAddCoachInfo;
    private javax.swing.JTextField jtfCoachID;
    private javax.swing.JTextField jtfCoachType;
    private javax.swing.JTextField jtfNumberOfSeats;
    // End of variables declaration//GEN-END:variables
}
