/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ProviderRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.ProviderEnterprise;
import Business.Network.Network;
import Business.Organization.HospitalOrganization;
import Business.Organization.Organization;
import Business.Organization.PharmaceuticalOrganization;
import Business.Organization.ProviderOrganization;
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
public class ProviderInvoiceJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private InvoiceRequest request;
    private ProviderOrganization providerOrg;
    private EcoSystem ecoSystem;
    private ProviderEnterprise provEnt;
    private UserAccount account;
    public ProviderInvoiceJPanel(JPanel userProcessContainer, UserAccount account, InvoiceRequest request, ProviderOrganization providerOrg, ProviderEnterprise provEnt, EcoSystem ecoSystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.request = request;
        this.providerOrg = providerOrg;
        this.ecoSystem = ecoSystem;
        this.provEnt = provEnt;
        this.account = account;
        
//        vaccineNamejTextField.setText(request.getVaccineName());
//        vaccineQuantityjTextField.setText(String.valueOf(request.getQuantity()));
//        vaccinePricejTextField.setText(String.valueOf(request.getPrice()));
//        Float totalPrice = request.getQuantity() * request.getPrice();
//        totalPricejTextField.setText(String.valueOf(totalPrice));
//        manufacturerjTextField.setText(request.getSender().getPerson().getName());
//        deliveryDatejTextField.setText(request.getProcessDate());
        
        populateInvoiceTable();
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
        sendInvoicejButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        invoicejTable = new javax.swing.JTable();
        paymentStatusjButton = new javax.swing.JButton();

        jLabel2.setFont(new java.awt.Font("American Typewriter", 1, 18)); // NOI18N
        jLabel2.setText("PROVIDER INVOICE WORK AREA");

        backjButton.setText("<< Back");
        backjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButtonActionPerformed(evt);
            }
        });

        sendInvoicejButton.setText("Send Invoice>>");
        sendInvoicejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendInvoicejButtonActionPerformed(evt);
            }
        });

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

        paymentStatusjButton.setText("Payment Status");
        paymentStatusjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentStatusjButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(backjButton)
                                .addGap(63, 63, 63)
                                .addComponent(sendInvoicejButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(paymentStatusjButton))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(backjButton)
                        .addComponent(sendInvoicejButton))
                    .addComponent(paymentStatusjButton))
                .addContainerGap(21, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButtonActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backjButtonActionPerformed

    private void sendInvoicejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendInvoicejButtonActionPerformed
//            for(WorkRequest request : providerOrg.getWorkQueue().getWorkRequestList()){
//                if(request instanceof OrderRequest){
//                OrderRequest or = (OrderRequest)request;
//                if(or.getRequestID() == request.getRequestID()){
        int selectedRow = invoicejTable.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a Row from the table");
            return;
        }
        InvoiceRequest invRequest = (InvoiceRequest)invoicejTable.getValueAt(selectedRow, 0);
        if(!invRequest.getPaymentStatus().equals("Sent")){
         Organization org = null;
        for(Network n : ecoSystem.getNetworkList()){
            boolean flag = false;
            for(Enterprise e: n.getEnterpriseDirectory().getEnterpriseList()){
                System.out.println("request.getLocation() " +invRequest.getLocation());
                System.out.println("e.getLocation() " +e.getLocation());
                if(invRequest.getLocation().equals(e.getLocation())){
                    System.out.println("e.getEnterpriseType() " +e.getEnterpriseType().getValue());
                    System.out.println("request.getEnterpriseType() " +invRequest.getEnterpriseType());
                    if(e.getEnterpriseType().getValue().equals(invRequest.getEnterpriseType())){
                        System.out.println("e.getName() " +e.getName());
                        System.out.println("request.getEnterpriseName() " +invRequest.getEnterpriseName());
                        if(e.getName().equals(invRequest.getEnterpriseName())){
                            for(Organization o : e.getOrganizationDirectory().getOrganizationList()){
                                System.out.println("org: " +o.getName());
                          if(e.getEnterpriseType().getValue().equals("Hospital")){
                              
                                if(o instanceof HospitalOrganization){
                                    invRequest.setPaymentStatus("Sent");
                                org = o;
                                flag = true;
                                break;
                            }
                          }
                            if(e.getEnterpriseType().getValue().equals("Pharmaceutical")){
                                        if(o instanceof PharmaceuticalOrganization){
                                            invRequest.setPaymentStatus("Sent");
                                            System.out.println("instance of Pharmaceutical Organization");
                                            org = o;
                                            flag = true;
                                            break;
                                        }
                            }  
                            }
                    }  
                }
            }
                if(flag==true){
                    break;
                }
        }
                
            }   
                    
            if(org!=null){
                org.getWorkQueue().getWorkRequestList().add(invRequest);
//                ua.getWorkQueue().getWorkRequestList().add(request);
                System.out.println("order request added to PHD org");
        }
            
            JOptionPane.showMessageDialog(null, "Invoice Sent");
            return;
        } 
        else
        {
            JOptionPane.showMessageDialog(null, "Invoice already sent");
        }
                
    }//GEN-LAST:event_sendInvoicejButtonActionPerformed

    private void paymentStatusjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentStatusjButtonActionPerformed
        int selectedRow = invoicejTable.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a Row from the table");
            return;
        }
        InvoiceRequest invRequest = (InvoiceRequest)invoicejTable.getValueAt(selectedRow, 0);
        
        PaymentStatusJPanel psjp = new PaymentStatusJPanel(userProcessContainer,account, invRequest, providerOrg, provEnt, ecoSystem);
        userProcessContainer.add("PaymentStatusJPanel",psjp);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_paymentStatusjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backjButton;
    private javax.swing.JTable invoicejTable;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton paymentStatusjButton;
    private javax.swing.JButton sendInvoicejButton;
    // End of variables declaration//GEN-END:variables
}
