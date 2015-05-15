/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserInterface.CDCRole;

import UserInterface.EnterpriseAdminRole.*;
import Business.Enterprise.Enterprise;
import Business.Enterprise.Enterprise.EnterpriseType;
import Business.Organization.Organization;
import Business.Organization.Organization.Type;
import Business.Organization.OrganizationDirectory;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author relaince
 */
public class ManageCDCOrganizationJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Enterprise enterprise;
    public ManageCDCOrganizationJPanel(JPanel upc, Enterprise enterprise) {
        initComponents();
        userProcessContainer = upc;
        this.enterprise = enterprise;
        populateOrganizationsComboBox();
        populateOrganizationsTable();
    }

    private void populateOrganizationsComboBox(){
        organizationsjComboBox.removeAllItems();
//        if(enterprise.getEnterpriseType().getValue().equals(EnterpriseType.CDC.getValue())){
//                    for (Type type : Organization.Type.values()){
//                        if (type.getValue().equals(Type.CDCApprover.getValue())){
//                        organizationsjComboBox.addItem(type);
//                        break;
//                        }
//                    }
//                }
            if(enterprise.getEnterpriseType().getValue().equals(EnterpriseType.PHD.getValue())){
                 for (Type type : Organization.Type.values()){
                    if (type.getValue().equals(Type.PHD.getValue())){
                    organizationsjComboBox.addItem(type);
                    break;
                    }
                }
            }
            if(enterprise.getEnterpriseType().getValue().equals(EnterpriseType.Distributor.getValue())){
                 for (Type type : Organization.Type.values()){
                    if (type.getValue().equals(Type.Distributor.getValue())){
                    organizationsjComboBox.addItem(type);
                    break;
                }
            }   
         }
//            if(et.getValue().equals(EnterpriseType.Hospital.getValue())){
//                 for (Type type : Organization.Type.values()){
//                    if (type.getValue().equals(Type.Hospital.getValue()))
//                    organizationsjComboBox.addItem(type);
//                }
//            }
            if(enterprise.getEnterpriseType().getValue().equals(EnterpriseType.Clinic.getValue())){
                 for (Type type : Organization.Type.values()){
                    if (type.getValue().equals(Type.Clinic.getValue())){
                    organizationsjComboBox.addItem(type);
                    break;
                    }
                }
            }
            if(enterprise.getEnterpriseType().getValue().equals(EnterpriseType.Pharmaceutical.getValue())){
                 for (Type type : Organization.Type.values()){
                    if (type.getValue().equals(Type.Pharmaceutical.getValue())){
                    organizationsjComboBox.addItem(type);
                    break;
                    }
                }
            }
            if(enterprise.getEnterpriseType().getValue().equals(EnterpriseType.Manufacturer.getValue())){
                 for (Type type : Organization.Type.values()){
                    if (type.getValue().equals(Type.Manufacturer.getValue())){
                    organizationsjComboBox.addItem(type);
                    break;
                }
            }
        }
    }
    
    
    private void populateOrganizationsTable(){
        DefaultTableModel dtm = (DefaultTableModel)organizationsjTable.getModel();
        dtm.setRowCount(0);
        for(Organization org : enterprise.getOrganizationDirectory().getOrganizationList()){
        
            Object[] row = new Object[1];
            row[0] = org.getName();
            dtm.addRow(row);
        
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        organizationsjTable = new javax.swing.JTable();
        organizationsjComboBox = new javax.swing.JComboBox();
        addOrganizationjButton = new javax.swing.JButton();
        backjButton = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        organizationsjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Organizations"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(organizationsjTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 375, 95));

        organizationsjComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(organizationsjComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 130, -1));

        addOrganizationjButton.setText("Add Organization");
        addOrganizationjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addOrganizationjButtonActionPerformed(evt);
            }
        });
        add(addOrganizationjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        backjButton.setText("<< Back");
        backjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButtonActionPerformed(evt);
            }
        });
        add(backjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void addOrganizationjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addOrganizationjButtonActionPerformed
        Type type = (Type)organizationsjComboBox.getSelectedItem();
        enterprise.getOrganizationDirectory().createOrganization(type);
        populateOrganizationsTable();
    }//GEN-LAST:event_addOrganizationjButtonActionPerformed

    private void backjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButtonActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addOrganizationjButton;
    private javax.swing.JButton backjButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox organizationsjComboBox;
    private javax.swing.JTable organizationsjTable;
    // End of variables declaration//GEN-END:variables
}
