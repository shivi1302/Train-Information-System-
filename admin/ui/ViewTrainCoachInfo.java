package admin.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import javax.swing.JDesktopPane;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;
import model.dao.TrainCoachInfoDAO;
import model.to.TrainCoachInfoTO;

public class ViewTrainCoachInfo extends javax.swing.JInternalFrame {
    ArrayList<TrainCoachInfoTO> allTrainCoachInfoData;
    int row;
    JPopupMenu jpopup;
    public ViewTrainCoachInfo() {
        initComponents();
        setSize(650,450);
        bindTableData();
        jpopup=new JPopupMenu();
        JMenuItem jmiUpdate=new JMenuItem("Update This Record");
        jpopup.add(jmiUpdate);
        JMenuItem jmiDelete=new JMenuItem("Delete This Record");
        jpopup.add(jmiDelete);
        jmiUpdate.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               updateRecord();
            }
        });
        jmiDelete.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                deleteRecord();
            }
        });
    }
    private void updateRecord(){
        if(row!=-1){
            TrainCoachInfoTO cit=allTrainCoachInfoData.get(row);
            if(cit!=null){
                AddTrainCoachInfo obj=new AddTrainCoachInfo(cit);
                obj.setVisible(true);
                obj.setTitle("Update TrainCoach Info");
                JDesktopPane jdp=getDesktopPane();
                jdp.add(obj);
                try{
                    obj.setSelected(true);
                }catch(PropertyVetoException ex){
                }
                dispose();
            }
        }
            
    }
    private void deleteRecord(){
    if(row!=-1){
     TrainCoachInfoTO cit=allTrainCoachInfoData.get(row);
     if(cit!=null){
         int result= JOptionPane.showConfirmDialog(this,"Are You Sure You Want To Delete This Record",
                 "Message From Admin",JOptionPane.OK_CANCEL_OPTION);
         if(result==JOptionPane.OK_OPTION){
             TrainCoachInfoDAO action=new TrainCoachInfoDAO();
             if(action.deleteRecord(cit.getSrNo())){
                JOptionPane.showMessageDialog(this,"Record Is Deleted");
                bindTableData();
             row=-1;
             }else{
                 JOptionPane.showMessageDialog(this,action.getErrorMessage());
             }
          }
        }
      }
   }
    private void bindTableData(){
      allTrainCoachInfoData=new TrainCoachInfoDAO().getAllRecord();
      if(allTrainCoachInfoData!=null && allTrainCoachInfoData.size()!=0){
          int totalRows=allTrainCoachInfoData.size();
          String[] columnNames={"SrNo","TrainID","CoachID"};
          Object allData[][]=new Object[totalRows][columnNames.length];
          for(int i=0;i<totalRows;i++){
              TrainCoachInfoTO cit=allTrainCoachInfoData.get(i);
              allData[i]=new Object[columnNames.length];
                            allData[i][0]=cit.getSrNo();
              allData[i][1]=cit.getTrainID();
              allData[i][2]=cit.getCoachID();
          }
          DefaultTableModel dtm=new DefaultTableModel(allData,columnNames);
          jtViewTrainCoachInfo.setModel(dtm);

      }
     
    } 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtViewTrainCoachInfo = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("View Train Coach Info");

        jtViewTrainCoachInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtViewTrainCoachInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtViewTrainCoachInfoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtViewTrainCoachInfo);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtViewTrainCoachInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtViewTrainCoachInfoMouseClicked
       if(evt.getButton()==MouseEvent.BUTTON3){
           int idx=jtViewTrainCoachInfo.rowAtPoint(evt.getPoint());
           jtViewTrainCoachInfo.getSelectionModel().setSelectionInterval(idx, idx);
           row=jtViewTrainCoachInfo.getSelectedRow();
           System.out.println(row);
           jpopup.show(jtViewTrainCoachInfo,evt.getX(),evt.getY());
       }           
    }//GEN-LAST:event_jtViewTrainCoachInfoMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtViewTrainCoachInfo;
    // End of variables declaration//GEN-END:variables
}
