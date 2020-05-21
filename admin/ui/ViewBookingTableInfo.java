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
import model.dao.BookingTableDAO;
import model.to.BookingTableTO;

public class ViewBookingTableInfo extends javax.swing.JInternalFrame {
    ArrayList<BookingTableTO> allBookingData;
    int row;
    JPopupMenu jpopup;
    
    public ViewBookingTableInfo() {
        initComponents();
        setSize(1265, 495);        
        row=-1;
        bindTableData();
        jpopup=new JPopupMenu();
        JMenuItem jmiUpdate=new JMenuItem("Update This Record");
        jpopup.add(jmiUpdate);
        JMenuItem jmiDelete=new JMenuItem("Delete This Record");
        jpopup.add(jmiDelete);
        jmiDelete.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               deleteRecord();
            }
        });
        jmiUpdate.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                updateRecord();
            }
        });
    }
 private void deleteRecord(){
    if(row!=-1){
       BookingTableTO cit=allBookingData.get(row);
       if(cit!=null){
       int result= JOptionPane.showConfirmDialog(this,
      "Are You Sure You Want To Delete This Record","Message From Admin",JOptionPane.OK_CANCEL_OPTION);
       if(result==JOptionPane.OK_OPTION){
           BookingTableDAO action=new BookingTableDAO();
           if(action.deleteRecord(cit.getBookID())){
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
  private void updateRecord(){
        if(row!=-1){
            BookingTableTO cit=allBookingData.get(row);
            if(cit!=null){
                AddBookingTableInfo obj=new AddBookingTableInfo(cit);
                obj.setVisible(true);
                obj.setTitle("Update Coach Info");
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
  private void bindTableData(){
    allBookingData=new BookingTableDAO().getAllRecord();
    if(allBookingData!=null && allBookingData.size()!=0){
        int totalRows=allBookingData.size();
        String[] columnNames={"BookID","TrainID","StartID","EndID","ToatalTickets","UserName","BookDate","JourneyDate"};
        Object allData[][]=new Object[totalRows][columnNames.length];
        for(int i=0;i<totalRows;i++){
            BookingTableTO cit=allBookingData.get(i);
            allData[i]=new Object[columnNames.length];
            allData[i][0]=cit.getBookID();
            allData[i][1]=cit.getTrainID();
            allData[i][2]=cit.getStartID();
            allData[i][3]=cit.getEndID();
            allData[i][4]=cit.getTotalTickets();
            allData[i][5]=cit.getUserName();
            allData[i][6]=cit.getBookDate();
            allData[i][7]=cit.getJourneyDate();            
        }
        DefaultTableModel dtm=new DefaultTableModel(allData,columnNames);
        jtViewBookingInfo.setModel(dtm);
    }
    
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtViewBookingInfo = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("View Booking Info");

        jtViewBookingInfo.setModel(new javax.swing.table.DefaultTableModel(
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
        jtViewBookingInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtViewBookingInfoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtViewBookingInfo);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtViewBookingInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtViewBookingInfoMouseClicked
           if(evt.getButton()== MouseEvent.BUTTON3){
            int idx=jtViewBookingInfo.rowAtPoint(evt.getPoint());
            jtViewBookingInfo.getSelectionModel().setSelectionInterval(idx, idx);
            row=jtViewBookingInfo.getSelectedRow();
            System.out.println(row);
            jpopup.show(jtViewBookingInfo,evt.getX(),evt.getY());
        }
    }//GEN-LAST:event_jtViewBookingInfoMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtViewBookingInfo;
    // End of variables declaration//GEN-END:variables
}
