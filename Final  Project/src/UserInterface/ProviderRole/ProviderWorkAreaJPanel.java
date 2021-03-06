/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserInterface.ProviderRole;

import Business.EcoSystem;
import Business.Enterprise.ProviderEnterprise;
import Business.Organization.ProviderOrganization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;


public class ProviderWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount account;
    private ProviderEnterprise enterprise;
    private EcoSystem ecoSystem;
    private ProviderOrganization providerOrganization;
    public ProviderWorkAreaJPanel(JPanel upc, UserAccount account, ProviderEnterprise enterprise,ProviderOrganization providerOrganization, EcoSystem ecoSystem) {
        initComponents();
        userProcessContainer = upc;
        this.account = account;
        this.enterprise = enterprise;
        this.ecoSystem = ecoSystem;
        this.providerOrganization = providerOrganization;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        manageEnrollmentRequestjButton = new javax.swing.JButton();
        sendEnrollmentRequestjButton = new javax.swing.JButton();
        manageOrderRequestjButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        shipmentStatusjButton = new javax.swing.JButton();
        PHDVaccineShortageReportjButton = new javax.swing.JButton();
        reportVaccineReactionjButton = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        manageEnrollmentRequestjButton.setText("Manage Enrollment Request");
        manageEnrollmentRequestjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageEnrollmentRequestjButtonActionPerformed(evt);
            }
        });
        add(manageEnrollmentRequestjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 94, -1, -1));

        sendEnrollmentRequestjButton.setText("Send Enrollment Request >>");
        sendEnrollmentRequestjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendEnrollmentRequestjButtonActionPerformed(evt);
            }
        });
        add(sendEnrollmentRequestjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 47, -1, -1));

        manageOrderRequestjButton.setText("Manage Order Request");
        manageOrderRequestjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageOrderRequestjButtonActionPerformed(evt);
            }
        });
        add(manageOrderRequestjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 141, -1, -1));

        jLabel1.setFont(new java.awt.Font("American Typewriter", 1, 18)); // NOI18N
        jLabel1.setText("PROVIDER WORK AREA");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 6, -1, -1));

        shipmentStatusjButton.setText("Shipment Status");
        shipmentStatusjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shipmentStatusjButtonActionPerformed(evt);
            }
        });
        add(shipmentStatusjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 188, -1, -1));

        PHDVaccineShortageReportjButton.setText("Vaccine Shortage Report");
        PHDVaccineShortageReportjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PHDVaccineShortageReportjButtonActionPerformed(evt);
            }
        });
        add(PHDVaccineShortageReportjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 235, -1, -1));

        reportVaccineReactionjButton.setText("Report Vaccine Adverse Event");
        reportVaccineReactionjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportVaccineReactionjButtonActionPerformed(evt);
            }
        });
        add(reportVaccineReactionjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 282, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void sendEnrollmentRequestjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendEnrollmentRequestjButtonActionPerformed
        ProviderEnrollmentRequestWorkAreaJPanel serjp = new ProviderEnrollmentRequestWorkAreaJPanel(userProcessContainer,account,enterprise,ecoSystem);
        userProcessContainer.add("SendEnrollmentRequestJPanel",serjp);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_sendEnrollmentRequestjButtonActionPerformed

    private void manageEnrollmentRequestjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageEnrollmentRequestjButtonActionPerformed
        ManageEnrollmentRequestJPanel merjp = new ManageEnrollmentRequestJPanel(userProcessContainer,account,enterprise,ecoSystem);
        userProcessContainer.add("ManageEnrollmentRequestJPanel",merjp);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageEnrollmentRequestjButtonActionPerformed

    private void manageOrderRequestjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageOrderRequestjButtonActionPerformed
        ProviderManageOrderRequestJPanel pmorjp = new ProviderManageOrderRequestJPanel(userProcessContainer,account,enterprise, providerOrganization,ecoSystem);
        userProcessContainer.add("ManageOrderRequestJPanel",pmorjp);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageOrderRequestjButtonActionPerformed

    private void shipmentStatusjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shipmentStatusjButtonActionPerformed
        ShipmentStatusJPanel ssjp = new ShipmentStatusJPanel(userProcessContainer,account,enterprise,providerOrganization, ecoSystem);
        userProcessContainer.add("ShipmentStatusJPanel",ssjp);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_shipmentStatusjButtonActionPerformed

    private void PHDVaccineShortageReportjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PHDVaccineShortageReportjButtonActionPerformed
        ProviderVaccineShortageJPanel prvsjp = new ProviderVaccineShortageJPanel(userProcessContainer, account, enterprise, providerOrganization, ecoSystem);
        userProcessContainer.add("ProviderVaccineShortageJPanel",prvsjp);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_PHDVaccineShortageReportjButtonActionPerformed

    private void reportVaccineReactionjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportVaccineReactionjButtonActionPerformed
        ProviderReportVaccineAdverseEventJPanel prvaejp = new ProviderReportVaccineAdverseEventJPanel(userProcessContainer, account, enterprise, providerOrganization, ecoSystem);
        userProcessContainer.add("ProviderReportVaccineAdverseEventJPanel",prvaejp);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_reportVaccineReactionjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton PHDVaccineShortageReportjButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton manageEnrollmentRequestjButton;
    private javax.swing.JButton manageOrderRequestjButton;
    private javax.swing.JButton reportVaccineReactionjButton;
    private javax.swing.JButton sendEnrollmentRequestjButton;
    private javax.swing.JButton shipmentStatusjButton;
    // End of variables declaration//GEN-END:variables
}
