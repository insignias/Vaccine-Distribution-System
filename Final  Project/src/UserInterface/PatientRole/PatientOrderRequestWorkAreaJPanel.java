/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.PatientRole;

import Business.EcoSystem;
import Business.Enterprise.ClinicEnterprise;
import Business.Organization.ClinicOrganization;
import Business.Organization.Organization;
import Business.Organization.PatientOrganization;
import Business.Person.Clinician;
import Business.Person.Person;
import Business.Person.Vaccine;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author insignia
 */
public class PatientOrderRequestWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount account;
    private ClinicEnterprise clinicEnt;
    private PatientOrganization patientOrganization;
    private EcoSystem ecoSystem;
    public PatientOrderRequestWorkAreaJPanel(JPanel upc,UserAccount account,ClinicEnterprise clinicEnt, PatientOrganization patientOrganization, EcoSystem ecoSystem) {
        initComponents();
        userProcessContainer = upc;
        this.account = account;
        this.clinicEnt = clinicEnt;
        this.patientOrganization = patientOrganization;
        this.ecoSystem = ecoSystem;
        populateTable();
    }

    public void populateTable(){
         DefaultTableModel dtm = (DefaultTableModel)orderRequestjTable.getModel();
         dtm.setRowCount(0);
         
         ClinicOrganization clinicOrg = null;
         Clinician clinician = null;
         for(Organization o : clinicEnt.getOrganizationDirectory().getOrganizationList()){
             if(o instanceof ClinicOrganization){
                 clinicOrg = (ClinicOrganization)o;
                 for(Person p : clinicOrg.getPersonDirectory().getPersonList()){
                     if(p instanceof Clinician){
                         clinician = (Clinician)p;
                         for(Vaccine v : clinician.getVaccineCatalog().getVaccineCatalog()){
                             Object[] row = new Object[6];
                                row[0] = v.getVaccineName();
                                row[1] = v.getQuantity();
                                row[2] = v.getPrice();
                                row[3] = v.getManufacturer();
                                row[4] = v.getDateManufactured();
                                row[5] = v.getExpiryDate();
                                dtm.addRow(row);
                             
                         }
                         
                     }
                 }
             }
         }
//         for(WorkRequest workRequest : account.getWorkQueue().getWorkRequestList()){
//             OrderRequest or = (OrderRequest)workRequest;
//             Object[] row = new Object[5];
//             row[0] = or.getVaccineName();
//             row[1] = or.getQuantity();
//             row[2] = workRequest.getSender();
//             row[3] = workRequest.getStatus();
//             row[4] = or.getOrderResult()== null ? "Waiting" : or.getOrderResult();
//             dtm.addRow(row);
//         }
     }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        orderRequestjTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        backjButton = new javax.swing.JButton();
        RequestOrderjButton = new javax.swing.JButton();
        refreshjButton = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        orderRequestjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Vaccine Name", "Quantity", "Price/Dose", "Manufacturer", "Manufacture Date", "Expiry Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(orderRequestjTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 45, 419, 89));

        jLabel1.setText("Order Request Work Area JPanel");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 11, -1, -1));

        backjButton.setText("<<Back");
        backjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButtonActionPerformed(evt);
            }
        });
        add(backjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 152, -1, -1));

        RequestOrderjButton.setText("Request Order");
        RequestOrderjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RequestOrderjButtonActionPerformed(evt);
            }
        });
        add(RequestOrderjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 152, -1, -1));

        refreshjButton.setText("Refresh");
        refreshjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshjButtonActionPerformed(evt);
            }
        });
        add(refreshjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 152, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void RequestOrderjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RequestOrderjButtonActionPerformed
        int selectedRow = orderRequestjTable.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a Row from the table");
            return;
        }
        Vaccine vaccine = (Vaccine)orderRequestjTable.getValueAt(selectedRow, 0);
        PatientRequestOrderJPanel projp = new PatientRequestOrderJPanel(userProcessContainer, account, vaccine, clinicEnt, patientOrganization, ecoSystem);
        userProcessContainer.add("PatientRequestOrderJPanel", projp);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_RequestOrderjButtonActionPerformed

    private void refreshjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshjButtonActionPerformed
        populateTable();
    }//GEN-LAST:event_refreshjButtonActionPerformed

    private void backjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButtonActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backjButtonActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton RequestOrderjButton;
    private javax.swing.JButton backjButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable orderRequestjTable;
    private javax.swing.JButton refreshjButton;
    // End of variables declaration//GEN-END:variables
}
