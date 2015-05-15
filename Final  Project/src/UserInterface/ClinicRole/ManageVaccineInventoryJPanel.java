/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserInterface.ClinicRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.ClinicOrganization;
import Business.Person.Clinician;
import Business.Person.Person;
import Business.Person.Vaccine;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author relaince
 */
public class ManageVaccineInventoryJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount account;
    private Enterprise enterprise;
    private ClinicOrganization clinicOrganization;
    private EcoSystem ecoSystem;
    public ManageVaccineInventoryJPanel(JPanel upc, ClinicOrganization clinicOrganization) {
        initComponents();
        userProcessContainer = upc;
        this.account = account;
        this.ecoSystem = ecoSystem;
        this.enterprise = enterprise;
        this.clinicOrganization = clinicOrganization;
        populate();
    }

    private void populate(){
        DefaultTableModel dtm = (DefaultTableModel)vaccineInventoryjTable.getModel();
        dtm.setRowCount(0);
        
        Clinician clinician = null;
        for(Person p : clinicOrganization.getPersonDirectory().getPersonList()){
            if(p instanceof Clinician){
                clinician = (Clinician)p;
                for(Vaccine vaccine : clinician.getVaccineCatalog().getVaccineCatalog()){
                Object[] row = new Object[7];
                row[0] = vaccine;
                row[1] = vaccine.getPrice();
                row[2] = vaccine.getQuantity();
                row[3] = vaccine.getDateManufactured();
                row[4] = vaccine.getExpiryDate();
                row[5] = vaccine.getManufacturer();
                row[6] = vaccine.getLotNumber();
                dtm.addRow(row);
                }
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        backJButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        vaccineInventoryjTable = new javax.swing.JTable();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("American Typewriter", 1, 18)); // NOI18N
        jLabel1.setText("CLINIC MANAGE VACCINE INVENTORY");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, -1));

        backJButton1.setText("<< Back");
        backJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButton1ActionPerformed(evt);
            }
        });
        add(backJButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 164, -1, -1));

        vaccineInventoryjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Vaccine Name", "Price/Dose", "Quantity", "Manufacture Date", "Expiry Date", "Manufacturer", "LOT Number"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(vaccineInventoryjTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 50, 700, 96));
    }// </editor-fold>//GEN-END:initComponents

    private void backJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButton1ActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable vaccineInventoryjTable;
    // End of variables declaration//GEN-END:variables
}
