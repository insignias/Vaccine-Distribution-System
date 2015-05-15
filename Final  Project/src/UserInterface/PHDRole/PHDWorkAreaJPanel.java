/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserInterface.PHDRole;

import UserInterface.CDCRole.CDCReportVaccineShortageJPanel;
import Business.EcoSystem;
import Business.Enterprise.PHDEnterprise;
import Business.Organization.PHDOrganization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author relaince
 */
public class PHDWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem ecoSystem;
    private UserAccount ua;
    private PHDOrganization phdOrg;
    private PHDEnterprise phdEnterprise;
    public PHDWorkAreaJPanel(JPanel upc,UserAccount ua, PHDEnterprise phdEnterprise, PHDOrganization phdOrg, EcoSystem ecoSystem) {
        initComponents();
        userProcessContainer = upc;
        this.ua = ua;
        this.ecoSystem = ecoSystem;
        this.phdOrg = phdOrg;
        this.phdEnterprise = phdEnterprise;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        manageOrderRequestjButton = new javax.swing.JButton();
        PHDVaccineShortageReportjButton = new javax.swing.JButton();
        reportVaccineReactionjButton = new javax.swing.JButton();
        manageEnrollmentRequestjButton = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("American Typewriter", 1, 18)); // NOI18N
        jLabel1.setText("PHD WORK AREA");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        manageOrderRequestjButton.setText("Manage Order Request");
        manageOrderRequestjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageOrderRequestjButtonActionPerformed(evt);
            }
        });
        add(manageOrderRequestjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        PHDVaccineShortageReportjButton.setText("Vaccine Shortage Report");
        PHDVaccineShortageReportjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PHDVaccineShortageReportjButtonActionPerformed(evt);
            }
        });
        add(PHDVaccineShortageReportjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        reportVaccineReactionjButton.setText("Report Vaccine Adverse Event");
        reportVaccineReactionjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportVaccineReactionjButtonActionPerformed(evt);
            }
        });
        add(reportVaccineReactionjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        manageEnrollmentRequestjButton.setText("Manage Enrollment Request");
        manageEnrollmentRequestjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageEnrollmentRequestjButtonActionPerformed(evt);
            }
        });
        add(manageEnrollmentRequestjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void manageOrderRequestjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageOrderRequestjButtonActionPerformed
        ManagePHDOrderRequestJPanel mphdorjp = new ManagePHDOrderRequestJPanel(userProcessContainer, ua, phdEnterprise, phdOrg, ecoSystem);
        userProcessContainer.add("ManagePHDOrderRequestJPanel",mphdorjp);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageOrderRequestjButtonActionPerformed

    private void PHDVaccineShortageReportjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PHDVaccineShortageReportjButtonActionPerformed
        PHDVaccineShortageJPanel phdvsjp = new PHDVaccineShortageJPanel(userProcessContainer, ua, phdEnterprise, phdOrg, ecoSystem);
        userProcessContainer.add("PHDVaccineShortageJPanel",phdvsjp);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_PHDVaccineShortageReportjButtonActionPerformed

    private void reportVaccineReactionjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportVaccineReactionjButtonActionPerformed
        PHDReportVaccineAdverseEventJPanel phdrvaejp = new PHDReportVaccineAdverseEventJPanel(userProcessContainer, ua, phdEnterprise, phdOrg, ecoSystem);
        userProcessContainer.add("ClinicReportVaccineAdverseEventJPanel",phdrvaejp);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_reportVaccineReactionjButtonActionPerformed

    private void manageEnrollmentRequestjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageEnrollmentRequestjButtonActionPerformed
        ManageEnrollmentRequestJPanel merjp = new ManageEnrollmentRequestJPanel(userProcessContainer, ua, phdOrg, ecoSystem);
        userProcessContainer.add("ManageEnrollmentRequestJPanel",merjp);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageEnrollmentRequestjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton PHDVaccineShortageReportjButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton manageEnrollmentRequestjButton;
    private javax.swing.JButton manageOrderRequestjButton;
    private javax.swing.JButton reportVaccineReactionjButton;
    // End of variables declaration//GEN-END:variables
}
