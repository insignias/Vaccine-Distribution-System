/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.PHDRole;

import UserInterface.ClinicRole.*;
import Business.EcoSystem;
import Business.Enterprise.ClinicEnterprise;
import Business.Enterprise.PHDEnterprise;
import Business.Organization.ClinicOrganization;
import Business.Organization.PHDOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.ReactionRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author insignia
 */
public class PHDReportVaccineAdverseEventJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem ecoSystem;
    private PHDOrganization phdOrg;
    private UserAccount account; 
    private PHDEnterprise phdEnterprise;
    public PHDReportVaccineAdverseEventJPanel(JPanel upc,UserAccount account, PHDEnterprise phdEnterprise, PHDOrganization phdOrg,EcoSystem ecoSystem) {
        initComponents();
        userProcessContainer = upc;
        this.account = account;
        this.phdOrg = phdOrg;
        this.ecoSystem = ecoSystem;
        this.phdEnterprise = phdEnterprise;
        populateReactionReportTable();
    }

    private void populateReactionReportTable(){
        DefaultTableModel dtm = (DefaultTableModel)reationReportjTable.getModel();
        dtm.setRowCount(0);
        
        for(WorkRequest workRequest : account.getWorkQueue().getWorkRequestList()){
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        reationReportjTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        backjButton = new javax.swing.JButton();
        ReportjButton = new javax.swing.JButton();
        refreshjButton = new javax.swing.JButton();

        reationReportjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Vaccine Name", "Patient Address", "Patient Contact", "Patient Name", "Doses", "LOT Number", "Manufacturer", "Vaccination Date", "Reaction Date", "Reaction Details", "Sender", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(reationReportjTable);

        jLabel1.setFont(new java.awt.Font("American Typewriter", 1, 18)); // NOI18N
        jLabel1.setText("PHD REPORT VACCINE ADVERSE EVENT");

        backjButton.setText("<< Back");
        backjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButtonActionPerformed(evt);
            }
        });

        ReportjButton.setText("Report");
        ReportjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReportjButtonActionPerformed(evt);
            }
        });

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 925, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(backjButton)
                                .addGap(298, 298, 298)
                                .addComponent(refreshjButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ReportjButton))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(226, 226, 226)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backjButton)
                    .addComponent(ReportjButton)
                    .addComponent(refreshjButton))
                .addContainerGap(118, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButtonActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backjButtonActionPerformed

    private void ReportjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReportjButtonActionPerformed
          PHDReportVaccineReactionJPanel phdrvrjp = new PHDReportVaccineReactionJPanel(userProcessContainer, account, phdEnterprise, phdOrg, ecoSystem);
          userProcessContainer.add("PHDReportVaccineReactionJPanel",phdrvrjp);
          CardLayout layout = (CardLayout)userProcessContainer.getLayout();
          layout.next(userProcessContainer);
    }//GEN-LAST:event_ReportjButtonActionPerformed

    private void refreshjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshjButtonActionPerformed
        populateReactionReportTable();
    }//GEN-LAST:event_refreshjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ReportjButton;
    private javax.swing.JButton backjButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable reationReportjTable;
    private javax.swing.JButton refreshjButton;
    // End of variables declaration//GEN-END:variables
}
