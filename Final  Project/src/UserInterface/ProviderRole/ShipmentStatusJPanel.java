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
import Business.WorkQueue.InvoiceRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author insignia
 */
public class ShipmentStatusJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount account;
    private ProviderEnterprise enterprise;
    private EcoSystem ecoSystem;
    private ProviderOrganization providerOrganization;
    public ShipmentStatusJPanel(JPanel upc, UserAccount account, ProviderEnterprise enterprise,ProviderOrganization providerOrganization, EcoSystem ecoSystem) {
        initComponents();
        userProcessContainer = upc;
        this.account = account;
        this.enterprise = enterprise;
        this.ecoSystem = ecoSystem;
        this.providerOrganization = providerOrganization;
        populateShipmentStatus();
    }

    private void populateShipmentStatus(){
        DefaultTableModel dtm = (DefaultTableModel)shippingStatusjTable.getModel();
        dtm.setRowCount(0);
//        InvoiceRequest ir = null;
        for(WorkRequest workRequest : providerOrganization.getWorkQueue().getWorkRequestList()){
            if(workRequest instanceof InvoiceRequest){
               InvoiceRequest ir = (InvoiceRequest)workRequest;
               Object[] row = new Object[5];
               row[0] = ir;
               row[1] = ir.getRequestID();
               row[2] = ir.getQuantity();
               row[3] = ir.getOrderResult() == null ? "Sent" : ir.getOrderResult() ;
               row[4] = ir.getProcessDate();
               dtm.addRow(row);
               
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        shippingStatusjTable = new javax.swing.JTable();
        generateInvoicejButton = new javax.swing.JButton();
        backjButton = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("American Typewriter", 1, 18)); // NOI18N
        jLabel1.setText("SHIPMENT STATUS");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 12, -1, -1));

        shippingStatusjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Vaccine Name", "Request ID", "Quantity", "Order Result", "Shipping Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(shippingStatusjTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 47, 450, 89));

        generateInvoicejButton.setText("Generate Invoice");
        generateInvoicejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateInvoicejButtonActionPerformed(evt);
            }
        });
        add(generateInvoicejButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 154, -1, -1));

        backjButton.setText("<< Back");
        backjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButtonActionPerformed(evt);
            }
        });
        add(backjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 154, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void generateInvoicejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateInvoicejButtonActionPerformed
        int selectedRow = shippingStatusjTable.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a Row from the table");
            return;
        }
        InvoiceRequest request = (InvoiceRequest)shippingStatusjTable.getValueAt(selectedRow, 0);
//        InvoiceRequest invRequest = null;
//        for(WorkRequest workRequest : providerOrganization.getWorkQueue().getWorkRequestList()){
//           if(workRequest instanceof InvoiceRequest) {
//               invRequest = (InvoiceRequest)workRequest;
//                if(invRequest.getRequestID() == request.getRequestID()){
                    ProviderInvoiceJPanel pijp = new ProviderInvoiceJPanel(userProcessContainer, account, request, providerOrganization, enterprise, ecoSystem);
                    userProcessContainer.add("ProviderInvoiceJPanel",pijp);
                    CardLayout layout = (CardLayout)userProcessContainer.getLayout();
                    layout.next(userProcessContainer);
//                }
//           }
//        }
    }//GEN-LAST:event_generateInvoicejButtonActionPerformed

    private void backjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButtonActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backjButton;
    private javax.swing.JButton generateInvoicejButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable shippingStatusjTable;
    // End of variables declaration//GEN-END:variables
}
