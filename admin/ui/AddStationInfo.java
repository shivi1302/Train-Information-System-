package admin.ui;

import java.beans.PropertyVetoException;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import model.dao.StationInfoDAO;
import model.to.StationInfoTO;
import operation.checks;

public class AddStationInfo extends javax.swing.JInternalFrame {

    public AddStationInfo() {
        initComponents();
        setSize(650,450);
    }

   public AddStationInfo(StationInfoTO data){
       this();
       if(data!=null){
        jtfStationID.setText(data.getStationID());
        jtfStationName.setText(data.getStationName());
        jtfStationID.setEditable(false);
        jbtnAddStationInfo.setText("Update Station Info");
       }
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfStationName = new javax.swing.JTextField();
        jtfStationID = new javax.swing.JTextField();
        jbtnAddStationInfo = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Add StationInfo");
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Enter Station Name :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 130, 170, 50);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Enter Station ID :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 50, 170, 50);
        getContentPane().add(jtfStationName);
        jtfStationName.setBounds(250, 130, 210, 50);
        getContentPane().add(jtfStationID);
        jtfStationID.setBounds(250, 50, 210, 50);

        jbtnAddStationInfo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jbtnAddStationInfo.setText("Add Station Info");
        jbtnAddStationInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAddStationInfoActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnAddStationInfo);
        jbtnAddStationInfo.setBounds(140, 230, 230, 60);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnAddStationInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAddStationInfoActionPerformed
        String message="";
        try{
            String StationID=jtfStationID.getText().trim();
            String StationName=jtfStationName.getText().trim();
        if(checks.isEmpty(StationID)||checks.isEmpty(StationName)){
            message="Please Enter Some Value";
        }else{
            StationInfoTO data=new StationInfoTO();
            data.setStationID(StationID);
            data.setStationName(StationName);
            StationInfoDAO action=new StationInfoDAO();
            if (jbtnAddStationInfo.getText().contains("Add")){
            if(action.insertRecord(data)){
                message="Record Inserted";
                dispose();
            }else{
                message=action.getErrorMessage();
            }
           }
            else if(jbtnAddStationInfo.getText().contains("Update")){
                if(action.updateRecord(data)){
                    message="Record Updated";
                }else{
                    message=action.getErrorMessage();
                }
                JOptionPane.showMessageDialog(this, message);
                ViewStationInfo obj=new ViewStationInfo();
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
    }//GEN-LAST:event_jbtnAddStationInfoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jbtnAddStationInfo;
    private javax.swing.JTextField jtfStationID;
    private javax.swing.JTextField jtfStationName;
    // End of variables declaration//GEN-END:variables
}
