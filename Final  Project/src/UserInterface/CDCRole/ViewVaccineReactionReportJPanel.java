/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.CDCRole;

import Business.EcoSystem;
import Business.Enterprise.CDCEnterprise;
import Business.Enterprise.Enterprise;
import static Business.Enterprise.Enterprise.EnterpriseType.Manufacturer;
import Business.Network.Network;
import Business.Organization.CDCOrganization;
import Business.Organization.ManufacturerOrganization;
import Business.Organization.Organization;
import Business.Person.Vaccine;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.ReactionRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author insignia
 */
public class ViewVaccineReactionReportJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem ecoSystem;
    private CDCEnterprise cdcEnterprise;
    private UserAccount account;
    private CDCOrganization cdcOrganization;
    public ViewVaccineReactionReportJPanel(JPanel upc,CDCEnterprise cdcEnterprise,UserAccount account,CDCOrganization cdcOrganization,EcoSystem ecoSystem) {
        initComponents();
        userProcessContainer = upc;
        this.ecoSystem = ecoSystem;
        this.cdcEnterprise = cdcEnterprise;
        this.account = account;
        this.cdcOrganization = cdcOrganization;
        populateReactionReportTable();
        populateRecallRequestTable();
    }

    private void populateReactionReportTable(){
        DefaultTableModel dtm = (DefaultTableModel)reactionReportjTable.getModel();
        dtm.setRowCount(0);
        
        for(WorkRequest workRequest : cdcOrganization.getWorkQueue().getWorkRequestList()){
            if(workRequest instanceof ReactionRequest){
                ReactionRequest rr = (ReactionRequest)workRequest;
                Object[] row = new Object[12];
                row[0] = rr;
                row[1] = rr.getPatientAddress();
                row[2] = rr.getPatientContact();
                row[3] = rr.getPatientName();
                row[4] = rr.getDoses();
                row[5] = rr.getLotNumber();
                row[6] = rr.getManufacturer();
                row[7] = rr.getVaccinationDate();
                row[8] = rr.getReactionDate();
                row[9] = rr.getReactionDetails();
                row[10] = rr.getSender();
                row[11] = rr.getStatus();
                dtm.addRow(row);
                
            }
        }
    }
    
    private void populateRecallRequestTable(){
        DefaultTableModel dtm = (DefaultTableModel)recallrequestjTable.getModel();
        dtm.setRowCount(0);
        
        for(WorkRequest workRequest : account.getWorkQueue().getWorkRequestList()){
            if(workRequest instanceof ReactionRequest){
                ReactionRequest rr = (ReactionRequest)workRequest;
                Object[] row = new Object[6];
                row[0] = rr;
                row[1] = rr.getMessage();
                row[2] = rr.getLotNumber();
                row[3] = rr.getManufacturer();
                row[4] = rr.getSender();
                row[5] = rr.getStatus();
                dtm.addRow(row);
                
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        reactionReportjTable = new javax.swing.JTable();
        backjButton = new javax.swing.JButton();
        acknowledgejButton = new javax.swing.JButton();
        sendRecalljButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        recallrequestjTable = new javax.swing.JTable();
        refreshjButton = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("American Typewriter", 1, 18)); // NOI18N
        jLabel1.setText("CDC VACCINE REACTION REPORT");

        reactionReportjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Vaccine Name", "Patient Name", "Patient Address", "Patient Contact", "Doses", "LOT Number", "Manufacturer", "Vaccination Date", "Reaction Date", "Reaction Details", "Sender", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(reactionReportjTable);

        backjButton.setText("<< Back");
        backjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButtonActionPerformed(evt);
            }
        });

        acknowledgejButton.setText("Acknowledge");
        acknowledgejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acknowledgejButtonActionPerformed(evt);
            }
        });

        sendRecalljButton.setText("Send Recall Message");
        sendRecalljButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendRecalljButtonActionPerformed(evt);
            }
        });

        recallrequestjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Vaccine Name", "Message", "LOT Number", "Manufacturer", "Sender", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(recallrequestjTable);

        refreshjButton.setText("Refresh");
        refreshjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshjButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(318, 318, 318)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(refreshjButton)
                        .addGap(179, 179, 179)
                        .addComponent(acknowledgejButton)
                        .addGap(215, 215, 215)
                        .addComponent(sendRecalljButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 954, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 954, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backjButton))
                .addGap(0, 12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(acknowledgejButton)
                    .addComponent(sendRecalljButton)
                    .addComponent(refreshjButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(backjButton)
                .addContainerGap(7, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButtonActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backjButtonActionPerformed

    private void acknowledgejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acknowledgejButtonActionPerformed
        int selectedRow = reactionReportjTable.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a Row from the table");
            return;
        }
        ReactionRequest rr = (ReactionRequest)reactionReportjTable.getValueAt(selectedRow, 0);
        rr.setStatus("Received");
        populateReactionReportTable();
    }//GEN-LAST:event_acknowledgejButtonActionPerformed

    private void sendRecalljButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendRecalljButtonActionPerformed
        int selectedRow = reactionReportjTable.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a Row from the table");
            return;
        }
        Organization org = null;
        ReactionRequest rr = (ReactionRequest)reactionReportjTable.getValueAt(selectedRow, 0);
        
//        if(!rr.getOrderResult().equals("Completed")){
//        rr.setOrderResult("Completed");
        ReactionRequest reactionReq = new ReactionRequest();
        reactionReq.setMessage("Recall");
        reactionReq.setVaccineName(rr.getVaccineName());
        reactionReq.setLotNumber(rr.getLotNumber());
        reactionReq.setManufacturer(rr.getManufacturer());
        reactionReq.setSender(account);
        reactionReq.setStatus("Sent");
        for(Network n : ecoSystem.getNetworkList()){
            boolean flag = false;
            for(Enterprise e: n.getEnterpriseDirectory().getEnterpriseList()){
                    if(e.getEnterpriseType().getValue().equals("Manufacturer")){
                        //if(e.getName().equals(rr.getManufacturer())){
                        for(Organization o : e.getOrganizationDirectory().getOrganizationList()){
                            if(o instanceof ManufacturerOrganization){
                                org = o;
                                flag = true;
                                break;
                            }
                        }
                    //}
                }
                if(flag==true){
                    break;
                }
            }   
                    
            if(org!=null){
                org.getWorkQueue().getWorkRequestList().add(reactionReq);
                account.getWorkQueue().getWorkRequestList().add(reactionReq);
                System.out.println("order request added to ManufacturerOrganization");
        }
            
            JOptionPane.showMessageDialog(null, "Result submitted");
            populateRecallRequestTable();
            return;
          }
//        }
//        else
//        {
//            JOptionPane.showMessageDialog(null, "Result already submitted");
//            return;
//        }
    }//GEN-LAST:event_sendRecalljButtonActionPerformed

    private void refreshjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshjButtonActionPerformed
        populateRecallRequestTable();
        populateReactionReportTable();
    }//GEN-LAST:event_refreshjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acknowledgejButton;
    private javax.swing.JButton backjButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable reactionReportjTable;
    private javax.swing.JTable recallrequestjTable;
    private javax.swing.JButton refreshjButton;
    private javax.swing.JButton sendRecalljButton;
    // End of variables declaration//GEN-END:variables
}
