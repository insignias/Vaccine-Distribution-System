/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserInterface.DistributorWarehouseRole;

import Business.EcoSystem;
import Business.Enterprise.DistributorWarehouseEnterprise;
import Business.Enterprise.Enterprise;
import Business.Organization.DistributorWarehouseOrganization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author relaince
 */
public class DistributorWarehouseWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount ua;
    private DistributorWarehouseEnterprise dwEnterprise;
    private DistributorWarehouseOrganization dwOrganization;
    private EcoSystem ecoSystem;
    public DistributorWarehouseWorkAreaJPanel(JPanel upc, UserAccount ua, DistributorWarehouseEnterprise dwEnterprise, DistributorWarehouseOrganization dwOrganization, EcoSystem ecoSystem) {
        initComponents();
        userProcessContainer = upc;
        this.ua = ua;
        this.dwEnterprise = dwEnterprise;
        this.dwOrganization = dwOrganization;
        this.ecoSystem = ecoSystem;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        manageOrderRequestjButton = new javax.swing.JButton();
        manageShipmentOrderjButton = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("American Typewriter", 1, 18)); // NOI18N
        jLabel1.setText("DISTRIBUTOR WAREHOUSE WORK AREA");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        manageOrderRequestjButton.setText("Manage Order Request");
        manageOrderRequestjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageOrderRequestjButtonActionPerformed(evt);
            }
        });
        add(manageOrderRequestjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, -1, -1));

        manageShipmentOrderjButton.setText("Manage Shipment Order ");
        manageShipmentOrderjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageShipmentOrderjButtonActionPerformed(evt);
            }
        });
        add(manageShipmentOrderjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void manageOrderRequestjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageOrderRequestjButtonActionPerformed
        DistributorWarehouseManageOrderRequestJPanel dwmorjp = new DistributorWarehouseManageOrderRequestJPanel(userProcessContainer, ua, dwEnterprise, dwOrganization, ecoSystem);
        userProcessContainer.add("DistributorWarehouseManageOrderRequestJPanel",dwmorjp);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageOrderRequestjButtonActionPerformed

    private void manageShipmentOrderjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageShipmentOrderjButtonActionPerformed
        DistributorWarehouseManageShipmentOrderJPanel dwmsojp = new DistributorWarehouseManageShipmentOrderJPanel(userProcessContainer, ua, dwEnterprise, dwOrganization, ecoSystem);
        userProcessContainer.add("DistributorWarehouseManageShipmentOrderJPanel",dwmsojp);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageShipmentOrderjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton manageOrderRequestjButton;
    private javax.swing.JButton manageShipmentOrderjButton;
    // End of variables declaration//GEN-END:variables
}
