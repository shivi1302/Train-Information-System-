package admin.ui;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.dao.BookingTableDAO;
import model.dao.TrainInfoDAO;
import model.to.BookingTableTO;
import model.to.TrainInfoTO;


public class SearchBookingInfo extends javax.swing.JInternalFrame {

    public SearchBookingInfo() {
        initComponents();
        setSize(680,520);       
        jcbSearchBookingInfo.removeAllItems();
        jcbSearchBookingInfo.addItem("Select Any Train ID");
        ArrayList<TrainInfoTO> allBookingData = new TrainInfoDAO().getAllRecord();
        if (allBookingData != null) {
            for (TrainInfoTO tit : allBookingData) {
                jcbSearchBookingInfo.addItem(tit);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtSearchBookingInfo = new javax.swing.JTable();
        jcbSearchBookingInfo = new javax.swing.JComboBox();
        jbtnSearchBookingInfo = new javax.swing.JButton();

        getContentPane().setLayout(null);

        jtSearchBookingInfo.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtSearchBookingInfo);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(-8, 70, 660, 340);

        jcbSearchBookingInfo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbSearchBookingInfo.setToolTipText("");
        getContentPane().add(jcbSearchBookingInfo);
        jcbSearchBookingInfo.setBounds(20, 10, 240, 30);

        jbtnSearchBookingInfo.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jbtnSearchBookingInfo.setText("Show Bookings");
        jbtnSearchBookingInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSearchBookingInfoActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnSearchBookingInfo);
        jbtnSearchBookingInfo.setBounds(380, 3, 170, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnSearchBookingInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSearchBookingInfoActionPerformed
       try{
           if(jcbSearchBookingInfo.getSelectedItem() instanceof TrainInfoTO){
               TrainInfoTO tit=(TrainInfoTO) jcbSearchBookingInfo.getSelectedItem();
               ArrayList<BookingTableTO> allBookingData=new BookingTableDAO().getAllRecord(tit.getTrainID());
    if(allBookingData!=null && allBookingData.size()!=0){
        int totalRows=allBookingData.size();
        String[] columnNames={"BookID","TrainID","StartID","EndID","ToatalTickets","UserName","BookDate","JourneyDate"};
        Object allData[][]=new Object[totalRows][columnNames.length];
        for(int i=0;i<totalRows;i++){
            BookingTableTO bit=allBookingData.get(i);
            allData[i]=new Object[columnNames.length];
            allData[i][0]=bit.getBookID();
            allData[i][1]=bit.getTrainID();
            allData[i][2]=bit.getStartID();
            allData[i][3]=bit.getEndID();
            allData[i][4]=bit.getTotalTickets();
            allData[i][5]=bit.getUserName();
            allData[i][6]=bit.getBookDate();
            allData[i][7]=bit.getJourneyDate();            
        }
        DefaultTableModel dtm=new DefaultTableModel(allData,columnNames);
        jtSearchBookingInfo.setModel(dtm);
    }
           }else{
               JOptionPane.showMessageDialog(this,"Please Select A Train");
           }
       }catch(Exception ex){
          
       }
    }//GEN-LAST:event_jbtnSearchBookingInfoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnSearchBookingInfo;
    private javax.swing.JComboBox jcbSearchBookingInfo;
    private javax.swing.JTable jtSearchBookingInfo;
    // End of variables declaration//GEN-END:variables
}
