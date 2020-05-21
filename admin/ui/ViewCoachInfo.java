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
import model.dao.CoachInfoDAO;
import model.to.CoachInfoTO;


public class ViewCoachInfo extends javax.swing.JInternalFrame {
    ArrayList<CoachInfoTO> allCoachInfoData;
    int row;
    JPopupMenu jpopup;
    public ViewCoachInfo() {
        initComponents();
        setSize(650,450);
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
       CoachInfoTO cit=allCoachInfoData.get(row);
       if(cit!=null){
       int result= JOptionPane.showConfirmDialog(this,
      "Are You Sure You Want To Delete This Record","Message From Admin",JOptionPane.OK_CANCEL_OPTION);
       if(result==JOptionPane.OK_OPTION){
           CoachInfoDAO action=new CoachInfoDAO();
           if(action.deleteRecord(cit.getCoachID())){
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
            CoachInfoTO cit=allCoachInfoData.get(row);
            if(cit!=null){
                AddCoachInfo obj=new AddCoachInfo(cit);
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
    allCoachInfoData=new CoachInfoDAO().getAllRecord();
    if(allCoachInfoData!=null && allCoachInfoData.size()!=0){
        int totalRows=allCoachInfoData.size();
        String[] columnNames={"Coach TYpe","Coach ID","Number Of Seats"};
        Object allData[][]=new Object[totalRows][columnNames.length];
        for(int i=0;i<totalRows;i++){
            CoachInfoTO cit=allCoachInfoData.get(i);
            allData[i]=new Object[columnNames.length];
            allData[i][0]=cit.getCoachType();
            allData[i][1]=cit.getCoachID();
            allData[i][2]=cit.getNumberOfSeats();
        }
        DefaultTableModel dtm=new DefaultTableModel(allData,columnNames);
        jtViewCoachInfo.setModel(dtm);
    }
    
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtViewCoachInfo = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("View Coach Info");

        jtViewCoachInfo.setModel(new javax.swing.table.DefaultTableModel(
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
        jtViewCoachInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtViewCoachInfoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtViewCoachInfo);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtViewCoachInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtViewCoachInfoMouseClicked
        if(evt.getButton()== MouseEvent.BUTTON3){
            int idx=jtViewCoachInfo.rowAtPoint(evt.getPoint());
            jtViewCoachInfo.getSelectionModel().setSelectionInterval(idx, idx);
            row=jtViewCoachInfo.getSelectedRow();
            System.out.println(row);
            jpopup.show(jtViewCoachInfo,evt.getX(),evt.getY());
        }
    }//GEN-LAST:event_jtViewCoachInfoMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtViewCoachInfo;
    // End of variables declaration//GEN-END:variables
}
