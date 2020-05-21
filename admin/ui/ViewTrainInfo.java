package admin.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;
import model.dao.TrainInfoDAO;
import model.to.TrainInfoTO;

public class ViewTrainInfo extends javax.swing.JInternalFrame {
    ArrayList<TrainInfoTO> allTrainInfoData;
    JPopupMenu jpopup;
    int row;
    public ViewTrainInfo() {
        initComponents();
        setSize(650,450);
        bindTableData();
        row=-1;
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
            TrainInfoTO data=allTrainInfoData.get(row);
            if(data!=null){
                AddTrainInfo obj=new AddTrainInfo(data);
                obj.setVisible(true);
                obj.setTitle("Update  Train Info");
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
            TrainInfoTO cit=allTrainInfoData.get(row);
            if(cit!=null){
                int result= JOptionPane.showConfirmDialog(this,"Are You Sure You Want To Delete This",
                        "Message From Admin",JOptionPane.OK_CANCEL_OPTION);
                if(result==JOptionPane.OK_OPTION){
                    TrainInfoDAO action=new TrainInfoDAO();
                    if(action.deleteRecord(cit.getTrainID())){
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
    allTrainInfoData=new TrainInfoDAO().getAllRecord();
    if(allTrainInfoData!=null && allTrainInfoData.size()!=0)
    {
        int totalRows=allTrainInfoData.size();
        String[] columnNames={"TrainID","TrainName","SourceID",
            "DestinationID","DepartureTime","ReachTime","NumberOfDays","Distance"};
        Object allData[] []=new Object[totalRows][columnNames.length];
        for(int i=0;i<totalRows;i++){
            TrainInfoTO cit=allTrainInfoData.get(i);
            allData[i]=new Object[columnNames.length];
            allData[i][0]=cit.getTrainID();
            allData[i][1]=cit.getTrainName();
            allData[i][2]=cit.getSourceID();
            allData[i][3]=cit.getDestinationID();
            allData[i][4]=cit.getDepartureTime();
            allData[i][5]=cit.getReachTime();
            allData[i][6]=cit.getNumberOfDays();
            allData[i][7]=cit.getDistance();
        }
        DefaultTableModel dtm=new DefaultTableModel(allData,columnNames);
        jtViewTrainInfo.setModel(dtm);
                
        }
                
   
            
}
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtViewTrainInfo = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("View Train Info");

        jtViewTrainInfo.setModel(new javax.swing.table.DefaultTableModel(
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
        jtViewTrainInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtViewTrainInfoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtViewTrainInfo);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtViewTrainInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtViewTrainInfoMouseClicked
       if(evt.getButton()==MouseEvent.BUTTON3){
           int idx=jtViewTrainInfo.rowAtPoint(evt.getPoint());
           jtViewTrainInfo.getSelectionModel().setSelectionInterval(idx, idx);
           row=jtViewTrainInfo.getSelectedRow();
           System.out.println(row);
           jpopup.show(jtViewTrainInfo, evt.getX(),evt.getY());
       }
    }//GEN-LAST:event_jtViewTrainInfoMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtViewTrainInfo;
    // End of variables declaration//GEN-END:variables
}
