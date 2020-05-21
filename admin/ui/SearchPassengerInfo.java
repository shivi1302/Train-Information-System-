package admin.ui;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.dao.BookingTableDAO;
import model.dao.PassengerInfoDAO;
import model.to.BookingTableTO;
import model.to.PassengerInfoTO;

public class SearchPassengerInfo extends javax.swing.JInternalFrame {

    public SearchPassengerInfo() {
        initComponents();
        setSize(680, 520);
        jcbSearchBookID.removeAllItems();
        jcbSearchBookID.addItem("Select Any BookID");
        ArrayList<BookingTableTO> allBookingData = new BookingTableDAO().getAllRecord();
        if (allBookingData != null) {
            for (BookingTableTO bit : allBookingData) {
                jcbSearchBookID.addItem(bit);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtSearchPassengerInfo = new javax.swing.JTable();
        jcbSearchBookID = new javax.swing.JComboBox();
        jbtnSearchPassengerInfo = new javax.swing.JButton();

        getContentPane().setLayout(null);

        jtSearchPassengerInfo.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtSearchPassengerInfo);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(-8, 100, 620, 310);

        jcbSearchBookID.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jcbSearchBookID);
        jcbSearchBookID.setBounds(10, 10, 300, 40);

        jbtnSearchPassengerInfo.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jbtnSearchPassengerInfo.setText("Show Passenger Details");
        jbtnSearchPassengerInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSearchPassengerInfoActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnSearchPassengerInfo);
        jbtnSearchPassengerInfo.setBounds(380, 10, 220, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnSearchPassengerInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSearchPassengerInfoActionPerformed
        try {
            if (jcbSearchBookID.getSelectedItem() instanceof BookingTableTO) {
                BookingTableTO bit = (BookingTableTO) jcbSearchBookID.getSelectedItem();
                ArrayList<PassengerInfoTO> allPassengerData = new PassengerInfoDAO().getAllRecord(bit.getBookID());
                if (allPassengerData != null && allPassengerData.size() != 0) {
                    int totalRows = allPassengerData.size();
                    String[] columnNames = {"SrNo", "BookID", "PassengerName", "Gender", "Age"};
                    Object allData[][] = new Object[totalRows][columnNames.length];
                    for (int i = 0; i < totalRows; i++) {
                        PassengerInfoTO pit = allPassengerData.get(i);
                        allData[i] = new Object[columnNames.length];
                        allData[i][0] = pit.getSrNo();
                        allData[i][1] = pit.getBookID();
                        allData[i][2] = pit.getPassengerName();
                        allData[i][3] = pit.getGender();
                        allData[i][4] = pit.getAge();
                    }
                    DefaultTableModel dtm = new DefaultTableModel(allData, columnNames);
                    jtSearchPassengerInfo.setModel(dtm);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please Select A BookID");
            }
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_jbtnSearchPassengerInfoActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnSearchPassengerInfo;
    private javax.swing.JComboBox jcbSearchBookID;
    private javax.swing.JTable jtSearchPassengerInfo;
    // End of variables declaration//GEN-END:variables
}
