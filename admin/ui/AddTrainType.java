package admin.ui;

import java.beans.PropertyVetoException;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import model.dao.TrainTypeDAO;
import model.to.TrainTypeTO;
import operation.checks;

public class AddTrainType extends javax.swing.JInternalFrame {

    public AddTrainType() {
        initComponents();
        setSize(650,450);
    }
    public AddTrainType(TrainTypeTO data){
        this();
        if(data!=null){
            jtfTypeName.setText(data.getTypeName());
            jtfTypeID.setText(data.getTypeID());
            jtfExtracharge.setText(String.valueOf(data.getExtraCharge()));
            jtfTypeID.setEditable(false);
            jbtnAddTrainType.setText("Update Train Type");
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfExtracharge = new javax.swing.JTextField();
        jtfTypeName = new javax.swing.JTextField();
        jtfTypeID = new javax.swing.JTextField();
        jbtnAddTrainType = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Add Traintype");
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Extracharge :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(60, 190, 180, 50);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Enter Type Name :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(60, 50, 180, 50);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Enter Type ID :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(60, 120, 180, 50);
        getContentPane().add(jtfExtracharge);
        jtfExtracharge.setBounds(290, 200, 250, 40);
        getContentPane().add(jtfTypeName);
        jtfTypeName.setBounds(290, 60, 250, 40);
        getContentPane().add(jtfTypeID);
        jtfTypeID.setBounds(290, 130, 250, 40);

        jbtnAddTrainType.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jbtnAddTrainType.setText("Add Traintype");
        jbtnAddTrainType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAddTrainTypeActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnAddTrainType);
        jbtnAddTrainType.setBounds(170, 290, 280, 60);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnAddTrainTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAddTrainTypeActionPerformed
       String message=" ";
       try{
           String TypeName=jtfTypeName.getText().trim();
           String TypeID=jtfTypeID.getText().trim();
           String ExtraCharge=jtfExtracharge.getText().trim();
           if(checks.isEmpty(TypeID)|| checks.isEmpty(TypeName)|| checks.isEmpty(ExtraCharge)){
           message="Please Enter Some Value";
           }else if(checks.isNumeric(ExtraCharge)){
               TrainTypeTO data=new TrainTypeTO();
               data.setTypeID(TypeID);
               data.setTypeName(TypeName);
               data.setExtraCharge(Integer.parseInt(ExtraCharge));
               TrainTypeDAO action=new TrainTypeDAO();
               if(jbtnAddTrainType.getText().contains("Add")){
                   if(action.insertRecord(data)){
                       message="One Record Inserted";
                       dispose();
                   }else{
                       message=action.getErrorMessage();
                   }
               }else if(jbtnAddTrainType.getText().contains("Update")){
                       if(action.updateRecord(data)){
                           message="one Record Updated";
                       }else{
                           message=action.getErrorMessage();
                       }
                       JOptionPane.showMessageDialog(this, message);
                      ViewTrainType obj=new ViewTrainType();
                      obj.setVisible(true);
                      JDesktopPane jdp=getDesktopPane();
                      jdp.add(obj);
                      try{
                          obj.setSelected(true);
                      }catch(PropertyVetoException ex){
                      }
           }
          }else{
               message="Please Enter Numeric Value in ExtraCharge";
           }
               dispose();
       }catch(Exception ex){
           message=ex.getMessage();
       }
       JOptionPane.showMessageDialog(this, message);
    }//GEN-LAST:event_jbtnAddTrainTypeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jbtnAddTrainType;
    private javax.swing.JTextField jtfExtracharge;
    private javax.swing.JTextField jtfTypeID;
    private javax.swing.JTextField jtfTypeName;
    // End of variables declaration//GEN-END:variables
}
