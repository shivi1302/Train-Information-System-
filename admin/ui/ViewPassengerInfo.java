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
import model.dao.PassengerInfoDAO;
import model.to.PassengerInfoTO;

public class ViewPassengerInfo extends javax.swing.JInternalFrame {
    ArrayList<PassengerInfoTO>allPassengerData;
    int row;
    JPopupMenu jpopup;
    public ViewPassengerInfo() {
        initComponents();
        setSize(650,450);
          row=-1;
        bindTableData();
        jpopup=new JPopupMenu();
        JMenuItem jmiUpdate=new JMenuItem("Update this Record");
        jpopup.add(jmiUpdate);
        JMenuItem jmiDelete=new JMenuItem("Delete this Record");
        jpopup.add(jmiDelete);
        jmiDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 deleteRecord();  
            }
        });
        jmiUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              updateRecord();
            }
        });
    }
      private void updateRecord(){
        if(row!=-1){
            PassengerInfoTO cit=allPassengerData.get(row);
            if(cit!=null){
                AddPassengerInfo obj=new AddPassengerInfo(cit);
                obj.setVisible(true);
                obj.setTitle("Update Passenger Info");
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
            PassengerInfoTO cit=allPassengerData.get(row);
            if(cit!=null){
                int result= JOptionPane.showConfirmDialog(this,"Are You Sure You Want To Delete This Record" ,
                        "Message From Admin",JOptionPane.OK_CANCEL_OPTION);
                if(result==JOptionPane.OK_OPTION){
                    PassengerInfoDAO action=new PassengerInfoDAO();
                  if(action.deleteRecord(cit.getSrNo())){
                      JOptionPane.showMessageDialog(this,"Record is Deleted");
                      bindTableData();
                      row=-1;
                  }else{
                      JOptionPane.showMessageDialog(this,action.getErrorMessage() );
                  }
                }
            }
        }
    
    }
   private void bindTableData(){
    allPassengerData=new PassengerInfoDAO().getAllRecord();
    if(allPassengerData!=null && allPassengerData.size()!=0){
        int totalRows=allPassengerData.size();
        String[] columnNames={"SrNo" ,"BookID","PassengerName","Gender","Age"};
        Object allData[][]=new Object[totalRows][columnNames.length];
        for(int i=0;i<totalRows;i++){
           PassengerInfoTO cit=allPassengerData.get(i);
           allData[i]=new Object[columnNames.length];
           allData[i][0]=cit.getSrNo();
           allData[i][1]=cit.getBookID();
           allData[i][2]=cit.getPassengerName();
           allData[i][3]=cit.getGender();
           allData[i][4]=cit.getAge();
        }
        DefaultTableModel dtm=new DefaultTableModel(allData,columnNames);
        jtPassengerInfo.setModel(dtm);
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtPassengerInfo = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("View Passenger Info");

        jtPassengerInfo.setModel(new javax.swing.table.DefaultTableModel(
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
        jtPassengerInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtPassengerInfoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtPassengerInfo);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtPassengerInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtPassengerInfoMouseClicked
        if(evt.getButton()== MouseEvent.BUTTON3){
           int idx=jtPassengerInfo.rowAtPoint(evt.getPoint());
           jtPassengerInfo.getSelectionModel().setSelectionInterval(idx,idx);
           row=jtPassengerInfo.getSelectedRow();
           System.out.println(row);
           jpopup.show(jtPassengerInfo,evt.getX(),evt.getY());
       }
    }//GEN-LAST:event_jtPassengerInfoMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtPassengerInfo;
    // End of variables declaration//GEN-END:variables
}
