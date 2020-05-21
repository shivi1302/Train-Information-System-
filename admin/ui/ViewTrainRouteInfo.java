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
import model.dao.TrainRouteInfoDAO;
import model.to.TrainRouteInfoTO;

public class ViewTrainRouteInfo extends javax.swing.JInternalFrame {
    ArrayList<TrainRouteInfoTO>allTrainRouteData;
    int row;
    JPopupMenu jpopup;
   
    public ViewTrainRouteInfo() {
        initComponents();
        setSize(650,450);
        bindTableData();
        jpopup=new JPopupMenu();
        JMenuItem jmiUpdate=new JMenuItem("Update This Record");
        jpopup.add(jmiUpdate);
        JMenuItem jmiDelete=new JMenuItem("Delete This Record");
        jpopup.add(jmiDelete);
        jmiUpdate.addActionListener(new ActionListener(){
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
            TrainRouteInfoTO cit=allTrainRouteData.get(row);
            if(cit!=null){
                AddTrainRouteInfo obj=new AddTrainRouteInfo(cit);
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
     TrainRouteInfoTO cit=allTrainRouteData.get(row);
     if(cit!=null){
         int result= JOptionPane.showConfirmDialog(this,"Are You Sure You Want To Delete This Record",
                 "Message From Admin",JOptionPane.OK_CANCEL_OPTION);
         if(result==JOptionPane.OK_OPTION){
             TrainRouteInfoDAO action=new TrainRouteInfoDAO();
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
 allTrainRouteData=new TrainRouteInfoDAO().getAllRecord();
 if(allTrainRouteData!=null && allTrainRouteData.size()!=0){
     int totalRows=allTrainRouteData.size();
     String[] columnNames={"SrNo","TrainID","StationID","DepartureTime","ReachTime"};
     Object alldata[][]=new Object[totalRows][columnNames.length];
     for(int i=0;i<totalRows;i++){
         TrainRouteInfoTO cit=allTrainRouteData.get(i);
         alldata[i]=new Object[columnNames.length];
         alldata[i][0]=cit.getSrNo();
         alldata[i][1]=cit.getTrainID();
         alldata[i][2]=cit.getStationID();
         alldata[i][3]=cit.getDepartureTime();
         alldata[i][4]=cit.getReachTime();
     }
     DefaultTableModel dtm=new DefaultTableModel(alldata,columnNames);
     jtViewTrainRouteInfo.setModel(dtm);
 }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtViewTrainRouteInfo = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("View Train Route Info");

        jtViewTrainRouteInfo.setModel(new javax.swing.table.DefaultTableModel(
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
        jtViewTrainRouteInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtViewTrainRouteInfoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtViewTrainRouteInfo);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtViewTrainRouteInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtViewTrainRouteInfoMouseClicked
        if(evt.getButton()== MouseEvent.BUTTON3){
           int idx=jtViewTrainRouteInfo.rowAtPoint(evt.getPoint());
           jtViewTrainRouteInfo.getSelectionModel().setSelectionInterval(idx, idx);
           row=jtViewTrainRouteInfo.getSelectedRow();
           System.out.println(row);
           jpopup.show(jtViewTrainRouteInfo,evt.getX(),evt.getY());
       }          
    }//GEN-LAST:event_jtViewTrainRouteInfoMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtViewTrainRouteInfo;
    // End of variables declaration//GEN-END:variables
}
