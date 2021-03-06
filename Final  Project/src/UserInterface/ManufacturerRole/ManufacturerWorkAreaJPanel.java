/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserInterface.ManufacturerRole;

import Business.EcoSystem;
import Business.Enterprise.ManufacturerEnterprise;
import Business.Organization.ManufacturerOrganization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author relaince
 */
public class ManufacturerWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem ecoSystem;
    private ManufacturerOrganization manOrg;
    private UserAccount ua;
    private ManufacturerEnterprise manEnt;
    public ManufacturerWorkAreaJPanel(JPanel upc, ManufacturerEnterprise manEnt, UserAccount ua, ManufacturerOrganization manOrg, EcoSystem ecoSystem) {
        initComponents();
        userProcessContainer = upc;
        this.ecoSystem = ecoSystem;
        this.ua = ua;
        this.manOrg = manOrg;
        this.manEnt = manEnt;
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
        manageVaccineCatalogjButton = new javax.swing.JButton();
        manageVaccineOrderjButton = new javax.swing.JButton();
        manageVaccineAdverseEventjButton = new javax.swing.JButton();
        cdcVaccineRecallRequestjButton = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("American Typewriter", 1, 18)); // NOI18N
        jLabel1.setText("MANUFACTURER WORK AREA");

        manageVaccineCatalogjButton.setText("Manage Vaccine Catalog");
        manageVaccineCatalogjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageVaccineCatalogjButtonActionPerformed(evt);
            }
        });

        manageVaccineOrderjButton.setText("Manage Vaccine Order");
        manageVaccineOrderjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageVaccineOrderjButtonActionPerformed(evt);
            }
        });

        manageVaccineAdverseEventjButton.setText("Manage Vaccine Adverse Event");
        manageVaccineAdverseEventjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageVaccineAdverseEventjButtonActionPerformed(evt);
            }
        });

        cdcVaccineRecallRequestjButton.setText("CDC Vaccine Recall Request");
        cdcVaccineRecallRequestjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cdcVaccineRecallRequestjButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cdcVaccineRecallRequestjButton)
                    .addComponent(manageVaccineAdverseEventjButton)
                    .addComponent(manageVaccineCatalogjButton)
                    .addComponent(jLabel1)
                    .addComponent(manageVaccineOrderjButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(manageVaccineCatalogjButton)
                .addGap(18, 18, 18)
                .addComponent(manageVaccineOrderjButton)
                .addGap(18, 18, 18)
                .addComponent(manageVaccineAdverseEventjButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cdcVaccineRecallRequestjButton)
                .addContainerGap(39, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void manageVaccineCatalogjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageVaccineCatalogjButtonActionPerformed
        ManageVaccineCatalogJPanel mvcjp = new ManageVaccineCatalogJPanel(userProcessContainer, ua, manOrg, ecoSystem);
        userProcessContainer.add("ManageVaccineCatalogJPanel",mvcjp);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageVaccineCatalogjButtonActionPerformed

    private void manageVaccineOrderjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageVaccineOrderjButtonActionPerformed
        ManageManufacturerOrderRequestJPanel mmorjp = new ManageManufacturerOrderRequestJPanel(userProcessContainer, manEnt, ua, manOrg, ecoSystem);
        userProcessContainer.add("ManageManufacturerOrderRequestJPanel",mmorjp);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageVaccineOrderjButtonActionPerformed

    private void manageVaccineAdverseEventjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageVaccineAdverseEventjButtonActionPerformed
        ManageVaccineAdverseEventJPanel mvaejp = new ManageVaccineAdverseEventJPanel(userProcessContainer, manEnt, ua, manOrg, ecoSystem);
        userProcessContainer.add("ManageVaccineAdverseEventJPanel",mvaejp);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageVaccineAdverseEventjButtonActionPerformed

    private void cdcVaccineRecallRequestjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cdcVaccineRecallRequestjButtonActionPerformed
        ManageCDCVaccineRecallRequestJPanel mcdcvrrjp = new ManageCDCVaccineRecallRequestJPanel(userProcessContainer, manEnt, ua, manOrg, ecoSystem);
        userProcessContainer.add("ManageCDCVaccineRecallRequestJPanel",mcdcvrrjp);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_cdcVaccineRecallRequestjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cdcVaccineRecallRequestjButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton manageVaccineAdverseEventjButton;
    private javax.swing.JButton manageVaccineCatalogjButton;
    private javax.swing.JButton manageVaccineOrderjButton;
    // End of variables declaration//GEN-END:variables
}
