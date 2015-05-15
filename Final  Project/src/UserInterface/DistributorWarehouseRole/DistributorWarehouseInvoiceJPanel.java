/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.DistributorWarehouseRole;

import Business.EcoSystem;
import Business.Enterprise.DistributorWarehouseEnterprise;
import Business.Organization.DistributorWarehouseOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.InvoiceRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author insignia
 */
public class DistributorWarehouseInvoiceJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private InvoiceRequest request;
    private EcoSystem ecoSystem;
    private UserAccount account;
    private DistributorWarehouseEnterprise dwEnterprise;
    private DistributorWarehouseOrganization dwOrganization;
    public DistributorWarehouseInvoiceJPanel(JPanel userProcessContainer, UserAccount account, InvoiceRequest request, DistributorWarehouseEnterprise dwEnterprise, DistributorWarehouseOrganization dwOrganization, EcoSystem ecoSystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.request = request;
        this.ecoSystem = ecoSystem;
        this.account = account;
        this.dwEnterprise = dwEnterprise;
        this.dwOrganization = dwOrganization;
        populateInvoiceTable();
//        vaccineNamejTextField.setText(request.getVaccineName());
//        vaccineQuantityjTextField.setText(String.valueOf(request.getQuantity()));
//        vaccinePricejTextField.setText(String.valueOf(request.getPrice()));
//        Float totalPrice = request.getQuantity() * request.getPrice();
//        totalPricejTextField.setText(String.valueOf(totalPrice));
//        manufacturerjTextField.setText(request.getSender().getPerson().getName());
//        deliveryDatejTextField.setText(request.getProcessDate());
    }

    private void populateInvoiceTable(){
        DefaultTableModel dtm = (DefaultTableModel)invoicejTable.getModel();
        dtm.setRowCount(0);
        
        Object[] row = new Object[6];
        row[0] = request;
        row[1] = request.getRequestID();
        row[2] = request.getQuantity();
        row[3] = request.getPrice();
        Float totalPrice = request.getQuantity() * request.getPrice();
        request.setTotalPrice(totalPrice);
        row[4] = request.getTotalPrice();
        row[5] = request.getSender().getPerson().getName();
        dtm.addRow(row);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        backjButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        invoicejTable = new javax.swing.JTable();
        paymentStatusjButton = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("American Typewriter", 1, 18)); // NOI18N
        jLabel2.setText("DISTRIBUTOR WAREHOUSE INVOICE");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        backjButton.setText("<< Back");
        backjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButtonActionPerformed(evt);
            }
        });
        add(backjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        invoicejTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Vaccine Name", "Request ID", "Quantity", "Price/Dose", "Total Price", "Manufacturer"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(invoicejTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 490, 120));

        paymentStatusjButton.setText("Payment Status");
        paymentStatusjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentStatusjButtonActionPerformed(evt);
            }
        });
        add(paymentStatusjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void backjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButtonActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backjButtonActionPerformed

    private void paymentStatusjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentStatusjButtonActionPerformed
        int selectedRow = invoicejTable.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a Row from the table");
            return;
        }
        InvoiceRequest invRequest = (InvoiceRequest)invoicejTable.getValueAt(selectedRow, 0);
        
        DistributorWarehousePaymentStatusJPanel dwpsjp = new DistributorWarehousePaymentStatusJPanel(userProcessContainer,account, invRequest, dwOrganization, dwEnterprise, ecoSystem);
        userProcessContainer.add("DistributorWarehousePaymentStatusJPanel",dwpsjp);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_paymentStatusjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backjButton;
    private javax.swing.JTable invoicejTable;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton paymentStatusjButton;
    // End of variables declaration//GEN-END:variables
}
