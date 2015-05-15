/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ProviderRole;

import UserInterface.ClinicRole.*;
import Business.EcoSystem;
import Business.Enterprise.ClinicEnterprise;
import Business.Enterprise.ProviderEnterprise;
import Business.Organization.ClinicOrganization;
import Business.Organization.ProviderOrganization;
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
public class ProviderReportVaccineAdverseEventJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem ecoSystem;
    private ProviderOrganization providerOrg;
    private UserAccount account; 
    private ProviderEnterprise providerEnterprise;
    public ProviderReportVaccineAdverseEventJPanel(JPanel upc,UserAccount account, ProviderEnterprise providerEnterprise, ProviderOrganization providerOrg,EcoSystem ecoSystem) {
        initComponents();
        userProcessContainer = upc;
        this.account = account;
        this.providerOrg = providerOrg;
        this.ecoSystem = ecoSystem;
        this.providerEnterprise = providerEnterprise;
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

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 47, 1100, 88));

        jLabel1.setFont(new java.awt.Font("American Typewriter", 1, 18)); // NOI18N
        jLabel1.setText("PROVIDER REPORT VACCINE ADVERSE EVENT WORK AREA");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, -1, -1));

        backjButton.setText("<< Back");
        backjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButtonActionPerformed(evt);
            }
        });
        add(backjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 153, -1, -1));

        ReportjButton.setText("Report>>");
        ReportjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReportjButtonActionPerformed(evt);
            }
        });
        add(ReportjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 150, -1, -1));

        refreshjButton.setText("Refresh");
        refreshjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshjButtonActionPerformed(evt);
            }
        });
        add(refreshjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 150, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void backjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButtonActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backjButtonActionPerformed

    private void ReportjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReportjButtonActionPerformed
        ProviderReportVaccineReactionJPanel prvrjp = new ProviderReportVaccineReactionJPanel(userProcessContainer, account, providerEnterprise, providerOrg, ecoSystem);
          userProcessContainer.add("ProviderReportVaccineReactionJPanel",prvrjp);
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
