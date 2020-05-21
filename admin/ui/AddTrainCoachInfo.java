package admin.ui;

import java.beans.PropertyVetoException;
import java.util.ArrayList;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import model.dao.CoachInfoDAO;
import model.dao.TrainCoachInfoDAO;
import model.dao.TrainInfoDAO;
import model.to.CoachInfoTO;
import model.to.TrainCoachInfoTO;
import model.to.TrainInfoTO;

public class AddTrainCoachInfo extends javax.swing.JInternalFrame {

    public AddTrainCoachInfo() {
        initComponents();
        setSize(650,450);
        jcbTrainCoachInfoTrainID.removeAllItems();
        jcbTrainCoachInfoTrainID.addItem("Select Any Train ID");
        jcbTrainCoachInfoCoachID.removeAllItems();
        jcbTrainCoachInfoCoachID.addItem("Select Any Coach ID");
        ArrayList<TrainInfoTO> allTrainCoachInfoData= new TrainInfoDAO().getAllRecord();
        ArrayList<CoachInfoTO> allTrainCoachInfoMeta= new CoachInfoDAO().getAllRecord();
        if(allTrainCoachInfoData!=null && allTrainCoachInfoMeta!=null){
            for(TrainInfoTO cit : allTrainCoachInfoData){
                jcbTrainCoachInfoTrainID.addItem(cit);
            }
            for(CoachInfoTO sit : allTrainCoachInfoMeta){
                jcbTrainCoachInfoCoachID.addItem(sit);
            }
        }
    }
    TrainCoachInfoTO updateData;
   public AddTrainCoachInfo(TrainCoachInfoTO updata){
       this();
       updateData=updata;
       if(updateData!=null){
           jbtnAddTrainCoachInfo.setText("Update Train Coach Info");
           for(int i = 1; i< jcbTrainCoachInfoTrainID.getItemCount(); i++){
               TrainInfoTO tt = (TrainInfoTO)jcbTrainCoachInfoTrainID.getItemAt(i);
               if(tt.getTrainID().equals(updateData.getTrainID())){
                   jcbTrainCoachInfoTrainID.setSelectedIndex(i);
                   break;
               }
           }
           for(int i=1;i<jcbTrainCoachInfoCoachID.getItemCount();i++){
               CoachInfoTO ct=(CoachInfoTO)jcbTrainCoachInfoCoachID.getItemAt(i);
               if(ct.getCoachID().equals(updateData.getCoachID())){
                   jcbTrainCoachInfoCoachID.setSelectedIndex(i);
                   break;
               }
           }
       }
   }   
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jbtnAddTrainCoachInfo = new javax.swing.JButton();
        jcbTrainCoachInfoTrainID = new javax.swing.JComboBox();
        jcbTrainCoachInfoCoachID = new javax.swing.JComboBox();

        setClosable(true);
        setIconifiable(true);
        setTitle("Add Train Coach Info");
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Coach ID :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 190, 150, 40);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Train ID :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 60, 150, 40);

        jbtnAddTrainCoachInfo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jbtnAddTrainCoachInfo.setText("Add Train Coach Info");
        jbtnAddTrainCoachInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAddTrainCoachInfoActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnAddTrainCoachInfo);
        jbtnAddTrainCoachInfo.setBounds(170, 310, 290, 70);

        jcbTrainCoachInfoTrainID.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jcbTrainCoachInfoTrainID);
        jcbTrainCoachInfoTrainID.setBounds(220, 60, 280, 40);

        jcbTrainCoachInfoCoachID.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jcbTrainCoachInfoCoachID);
        jcbTrainCoachInfoCoachID.setBounds(220, 190, 280, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnAddTrainCoachInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAddTrainCoachInfoActionPerformed
        String message="";
        try{
          if(jcbTrainCoachInfoTrainID.getSelectedItem() instanceof TrainInfoTO && 
                  jcbTrainCoachInfoCoachID.getSelectedItem() instanceof CoachInfoTO){
              String TrainId=jcbTrainCoachInfoTrainID.getSelectedItem().toString();
              String CoachId=jcbTrainCoachInfoCoachID.getSelectedItem().toString();
              TrainInfoTO cit=(TrainInfoTO) jcbTrainCoachInfoTrainID.getSelectedItem();
              CoachInfoTO sit=(CoachInfoTO)jcbTrainCoachInfoCoachID.getSelectedItem();
              TrainCoachInfoTO data=new TrainCoachInfoTO();
              data.setTrainID(cit.getTrainID());
              data.setCoachID(sit.getCoachID());
              TrainCoachInfoDAO action=new TrainCoachInfoDAO();
              if(jbtnAddTrainCoachInfo.getText().contains("Add")){
                  if(action.insertRecord(data)){
                      message="One Record Inserted";
                      dispose();
                  }else{
                      message=action.getErrorMessage();
                    }                      
                  }
               else if(jbtnAddTrainCoachInfo.getText().contains("Update")){
                   if(action.updateRecord(data)){
                       message="One Record Updated";
                       JOptionPane.showMessageDialog(this, message);
                       ViewTrainCoachInfo obj=new ViewTrainCoachInfo();
                       obj.setVisible(true);
                       JDesktopPane jdp=getDesktopPane();
                       jdp.add(obj);
                       try{
                           obj.setSelected(true);
                       }catch(PropertyVetoException ex){
                       }
                       dispose();
                   }else{
                       message=action.getErrorMessage();
                   }
              }
          }
        }catch(Exception ex){
            message=ex.getMessage();
            ex.printStackTrace();
        }
        JOptionPane.showMessageDialog(this, message);
    }//GEN-LAST:event_jbtnAddTrainCoachInfoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jbtnAddTrainCoachInfo;
    private javax.swing.JComboBox jcbTrainCoachInfoCoachID;
    private javax.swing.JComboBox jcbTrainCoachInfoTrainID;
    // End of variables declaration//GEN-END:variables
}
