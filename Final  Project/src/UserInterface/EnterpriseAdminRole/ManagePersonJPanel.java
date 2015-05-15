/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserInterface.EnterpriseAdminRole;

import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Person.Person;
import java.awt.CardLayout;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author relaince
 */
public class ManagePersonJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Enterprise enterprise;
    public ManagePersonJPanel(JPanel upc, Enterprise enterprise) {
        initComponents();
        userProcessContainer = upc;
        this.enterprise = enterprise;
//        populateOrganizationComboBox();
        populateOrganizationPersonComboBox();
        populateOrganizationTable();
    }

//    private void populateOrganizationComboBox(){
//        organizationJComboBox.removeAllItems();
//        for(Organization organization : orgDir.getOrganizationList()){
//            organizationJComboBox.addItem(organization);
//            
//        }
//    }
    
    
    
    private void populateOrganizationPersonComboBox(){
        organizationPersonJComboBox.removeAllItems();
//        personTypejComboBox.removeAllItems();
//        
        for(Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
            organizationPersonJComboBox.addItem(organization);
        }
//            if(organization.getName() == "Clinic Organization"){
//                 for(Person.PersonType pt : Person.PersonType.values()){
//                    if(pt.getValue().equals(Person.PersonType.Clinician.getValue())){
//                    personTypejComboBox.addItem(pt);
//                }
//                    }
//            }
//            if(organization.getName() == "Patient Organization"){
//                 for(Person.PersonType pt : Person.PersonType.values()){
//                    if(pt.getValue().equals(Person.PersonType.Patient.getValue())){
//                    personTypejComboBox.addItem(pt);
//                }
//                    }
//            }
//            if(organization.getName() == "CDC Organization"){
//                 for(Person.PersonType pt : Person.PersonType.values()){
//                    if(pt.getValue().equals(Person.PersonType.CDCAdmin.getValue())){
//                    personTypejComboBox.addItem(pt);
//                }
//                    }
//            }
//            if(organization.getName() == "EnterpriseAdmin Organization"){
//                 for(Person.PersonType pt : Person.PersonType.values()){
//                    if(pt.getValue().equals(Person.PersonType.EnterpriseAdmin.getValue())){
//                    personTypejComboBox.addItem(pt);
//                }
//                    }
//            }
//            if(organization.getName() == "PHD Organization"){
//                 for(Person.PersonType pt : Person.PersonType.values()){
//                    if(pt.getValue().equals(Person.PersonType.PHDAdmin.getValue())){
//                    personTypejComboBox.addItem(pt);
//                }
//                    }
//            }
//            if(organization.getName() == "Distributor Organization"){
//                 for(Person.PersonType pt : Person.PersonType.values()){
//                    if(pt.getValue().equals(Person.PersonType.DistributorAdmin.getValue())){
//                    personTypejComboBox.addItem(pt);
//                }
//                    }
//            }
//            if(organization.getName() == "Provider Organization"){
//                 for(Person.PersonType pt : Person.PersonType.values()){
//                    if(pt.getValue().equals(Person.PersonType.Provider.getValue())){
//                    personTypejComboBox.addItem(pt);
//                }
//                    }
//            }
//            if(organization.getName() == "DistributorWarehouse Organization"){
//                 for(Person.PersonType pt : Person.PersonType.values()){
//                    if(pt.getValue().equals(Person.PersonType.DistributorWarehouseAdmin.getValue())){
//                    personTypejComboBox.addItem(pt);
//                }
//                    }
//            }
//            if(organization.getName() == "Pharmaceutical Organization"){
//                 for(Person.PersonType pt : Person.PersonType.values()){
//                    if(pt.getValue().equals(Person.PersonType.PharmaceuticalAdmin.getValue())){
//                    personTypejComboBox.addItem(pt);
//                }
//                    }
//            }
//            if(organization.getName() == "Manufacturer Organization"){
//                 for(Person.PersonType pt : Person.PersonType.values()){
//                    if(pt.getValue().equals(Person.PersonType.Manufacturer.getValue())){
//                    personTypejComboBox.addItem(pt);
//                }
//                    }
//            }
//            if(organization.getName() == "Hospital Organization"){
//                 for(Person.PersonType pt : Person.PersonType.values()){
//                    if(pt.getValue().equals(Person.PersonType.HospitalAdmin.getValue())){
//                    personTypejComboBox.addItem(pt);
//                }
//                    }
//            }
        
        
//            System.out.println("org name: " +organization.getName());
//            if(enterprise.getEnterpriseType().getValue().equals(Enterprise.EnterpriseType.CDC.getValue())){
//                    for(Person.PersonType pt : Person.PersonType.values()){
//                    if(pt.getValue().equals(Person.PersonType.CDCAdmin.getValue())){
//                    personTypejComboBox.addItem(pt);
//                }
//                    }
//            }
//            if(enterprise.getEnterpriseType().getValue().equals(Enterprise.EnterpriseType.Manufacturer.getValue())){
//                    for(Person.PersonType pt : Person.PersonType.values()){
//                    if(pt.getValue().equals(Person.PersonType.Manufacturer.getValue())){
//                    personTypejComboBox.addItem(pt);
//                }
//                    }
//            }
//            if(enterprise.getEnterpriseType().getValue().equals(Enterprise.EnterpriseType.Distributor.getValue())){
//                    for(Person.PersonType pt : Person.PersonType.values()){
//                    if(pt.getValue().equals(Person.PersonType.DistributorAdmin.getValue())){
//                    personTypejComboBox.addItem(pt);
//                }
//                    }
//            }
//            if(enterprise.getEnterpriseType().getValue().equals(Enterprise.EnterpriseType.DistributorWarehouse.getValue())){
//                    for(Person.PersonType pt : Person.PersonType.values()){
//                    if(pt.getValue().equals(Person.PersonType.DistributorWarehouseAdmin.getValue())){
//                    personTypejComboBox.addItem(pt);
//                }
//                    }
//            }
//            if(enterprise.getEnterpriseType().getValue().equals(Enterprise.EnterpriseType.PHD.getValue())){
//                    for(Person.PersonType pt : Person.PersonType.values()){
//                    if(pt.getValue().equals(Person.PersonType.PHDAdmin.getValue())){
//                    personTypejComboBox.addItem(pt);
//                }
//                    }
//            }
//            if(enterprise.getEnterpriseType().getValue().equals(Enterprise.EnterpriseType.Clinic.getValue())){
//                    for(Person.PersonType pt : Person.PersonType.values()){
//                    if(pt.getValue().equals(Person.PersonType.Clinician.getValue())||pt.getValue().equals(Person.PersonType.Patient.getValue())){
//                    personTypejComboBox.addItem(pt);
//                }
//                    }
//            }
//            
//            if(enterprise.getEnterpriseType().getValue().equals(Enterprise.EnterpriseType.Provider.getValue())){
//                    for(Person.PersonType pt : Person.PersonType.values()){
//                    if(pt.getValue().equals(Person.PersonType.Provider.getValue())){
//                    personTypejComboBox.addItem(pt);
//                }
//                    }
//            }
//            if(enterprise.getEnterpriseType().getValue().equals(Enterprise.EnterpriseType.Hospital.getValue())){
//                    for(Person.PersonType pt : Person.PersonType.values()){
//                    if(pt.getValue().equals(Person.PersonType.HospitalAdmin.getValue())){
//                    personTypejComboBox.addItem(pt);
//                }
//                    }
//            }
//            if(enterprise.getEnterpriseType().getValue().equals(Enterprise.EnterpriseType.Pharmaceutical.getValue())){
//                    for(Person.PersonType pt : Person.PersonType.values()){
//                    if(pt.getValue().equals(Person.PersonType.PharmaceuticalAdmin.getValue())){
//                    personTypejComboBox.addItem(pt);
//                }
//                    }
//            }
//        }
    }
    
    private void populateOrganizationTable(){
        DefaultTableModel dtm = (DefaultTableModel)organizationJTable.getModel();
        dtm.setRowCount(0);
        for(Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
            for(Person p: organization.getPersonDirectory().getPersonList()){
                if(p!=null){
                    Object[] row = new Object[2];
                    row[0] = p.getPersonID();
                    row[1] = p.getName();
                    dtm.addRow(row);
                }
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backJButton = new javax.swing.JButton();
        organizationPersonJComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nameJTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        organizationJTable = new javax.swing.JTable();
        addPersonJButton = new javax.swing.JButton();
        refreshjButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        personTypejComboBox = new javax.swing.JComboBox();

        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        organizationPersonJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        organizationPersonJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationPersonJComboBoxActionPerformed(evt);
            }
        });

        jLabel3.setText("Organization");

        jLabel2.setText("Person Name:");

        organizationJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(organizationJTable);

        addPersonJButton.setText("Add Person");
        addPersonJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPersonJButtonActionPerformed(evt);
            }
        });

        refreshjButton.setText("Refresh");
        refreshjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshjButtonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("American Typewriter", 1, 18)); // NOI18N
        jLabel4.setText("ENTERPRISEADMIN MANAGE PERSON");

        jLabel5.setText("Person Type:");

        personTypejComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(organizationPersonJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel5)
                        .addGap(28, 28, 28)
                        .addComponent(personTypejComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2)
                        .addGap(23, 23, 23)
                        .addComponent(nameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backJButton)
                        .addGap(18, 18, 18)
                        .addComponent(refreshjButton)
                        .addGap(18, 18, 18)
                        .addComponent(addPersonJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel3))
                    .addComponent(organizationPersonJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel5))
                    .addComponent(personTypejComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2))
                    .addComponent(nameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backJButton)
                    .addComponent(refreshjButton)
                    .addComponent(addPersonJButton)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void addPersonJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPersonJButtonActionPerformed

        Organization organization = (Organization)organizationPersonJComboBox.getSelectedItem();
        Person.PersonType type = (Person.PersonType)personTypejComboBox.getSelectedItem();
//        if(organization instanceof ManufacturerOrganization){
//                for(PersonType pt : Person.PersonType.values()){
//                    if(pt.getValue().equals(Person.PersonType.Manufacturer.getValue())){
//                        String name = nameJTextField.getText();
//                        organization.getPersonDirectory().createAndAddPerson(name);
//                    }
//            }
//            
//        }
//        else{
        String name;
        try
        {
        String regex = "[^&%$#@!0-9()~`.,]*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(nameJTextField.getText());
        if (!matcher.matches()) 
        throw new Exception("Enter valid characters for name");
        }
        catch (Exception e) {
        //System.err.println("Caught IOException: " + e.getMessage());
        JOptionPane.showMessageDialog(null,e.getMessage());
        return;
        }

        try
        {
        name = nameJTextField.getText();
        if ((nameJTextField.getText().startsWith(" ")) || (nameJTextField.getText().isEmpty()))
            throw new Exception(" Please enter valid characters for name ");
        }        
        catch (Exception e) {
        //System.err.println("Caught IOException: " + e.getMessage());
        JOptionPane.showMessageDialog(null,e.getMessage());
        return;
        }
        organization.getPersonDirectory().createAndAddPerson(name, type);
        populateOrganizationTable();
        //}
    }//GEN-LAST:event_addPersonJButtonActionPerformed

    private void refreshjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshjButtonActionPerformed
        populateOrganizationTable();
    }//GEN-LAST:event_refreshjButtonActionPerformed

    private void organizationPersonJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationPersonJComboBoxActionPerformed
        Organization organization = (Organization)organizationPersonJComboBox.getSelectedItem();
        personTypejComboBox.removeAllItems();
        if(organization != null){
            if(organization.getName().equals("Clinic Organization")){
                 for(Person.PersonType pt : Person.PersonType.values()){
                    if(pt.getValue().equals(Person.PersonType.Clinician.getValue())){
                    personTypejComboBox.addItem(pt);
                }
                    }
            }
            if(organization.getName().equals("Insurance Organization")){
                 for(Person.PersonType pt : Person.PersonType.values()){
                    if(pt.getValue().equals(Person.PersonType.InsuranceAdmin.getValue())){
                    personTypejComboBox.addItem(pt);
                }
                    }
            }
            if(organization.getName().equals("Patient Organization")){
                 for(Person.PersonType pt : Person.PersonType.values()){
                    if(pt.getValue().equals(Person.PersonType.Patient.getValue())){
                    personTypejComboBox.addItem(pt);
                }
                    }
            }
            if(organization.getName().equals("CDC Organization")){
                 for(Person.PersonType pt : Person.PersonType.values()){
                    if(pt.getValue().equals(Person.PersonType.CDCAdmin.getValue())){
                    personTypejComboBox.addItem(pt);
                }
                    }
            }
            if(organization.getName().equals("EnterpriseAdmin Organization")){
                 for(Person.PersonType pt : Person.PersonType.values()){
                    if(pt.getValue().equals(Person.PersonType.EnterpriseAdmin.getValue())){
                    personTypejComboBox.addItem(pt);
                }
                    }
            }
            if(organization.getName().equals("PHD Organization")){
                 for(Person.PersonType pt : Person.PersonType.values()){
                    if(pt.getValue().equals(Person.PersonType.PHDAdmin.getValue())){
                    personTypejComboBox.addItem(pt);
                }
                    }
            }
            if(organization.getName().equals("Distributor Organization")){
                 for(Person.PersonType pt : Person.PersonType.values()){
                    if(pt.getValue().equals(Person.PersonType.DistributorAdmin.getValue())){
                    personTypejComboBox.addItem(pt);
                }
                    }
            }
            if(organization.getName().equals("Provider Organization")){
                 for(Person.PersonType pt : Person.PersonType.values()){
                    if(pt.getValue().equals(Person.PersonType.Provider.getValue())){
                    personTypejComboBox.addItem(pt);
                }
                    }
            }
            if(organization.getName().equals("DistributorWarehouse Organization")){
                 for(Person.PersonType pt : Person.PersonType.values()){
                    if(pt.getValue().equals(Person.PersonType.DistributorWarehouseAdmin.getValue())){
                    personTypejComboBox.addItem(pt);
                }
                    }
            }
            if(organization.getName().equals("Pharmaceutical Organization")){
                 for(Person.PersonType pt : Person.PersonType.values()){
                    if(pt.getValue().equals(Person.PersonType.PharmaceuticalAdmin.getValue())){
                    personTypejComboBox.addItem(pt);
                }
                    }
            }
            if(organization.getName().equals("Manufacturer Organization")){
                 for(Person.PersonType pt : Person.PersonType.values()){
                    if(pt.getValue().equals(Person.PersonType.Manufacturer.getValue())){
                    personTypejComboBox.addItem(pt);
                }
                    }
            }
            if(organization.getName().equals("Hospital Organization")){
                 for(Person.PersonType pt : Person.PersonType.values()){
                    if(pt.getValue().equals(Person.PersonType.HospitalAdmin.getValue())){
                    personTypejComboBox.addItem(pt);
                }
                    }
            }
        }
//        if(organization..equals("Patient Organization")){
//                for(Person.PersonType pt : Person.PersonType.values()){
//                    if(pt.getValue().equals(Person.PersonType.Patient.getValue())){
//                    personTypejComboBox.addItem(pt);
//                    }
//                }
//            }
//        if(organization.getName().equals("Clinic Organization")){
//                for(Person.PersonType pt : Person.PersonType.values()){
//                    if(pt.getValue().equals(Person.PersonType.Clinician.getValue())){
//                    personTypejComboBox.addItem(pt);
//                    }
//                }
//            }
//        if(organization.va.equals("CDCAdmin Organization")){
//                    for(Person.PersonType pt : Person.PersonType.values()){
//                    if(pt.getValue().equals(Person.PersonType.Admin.getValue())){
//                    personTypejComboBox.addItem(pt);
//                }
//                    }
//            }
//        if(organization.getName() == "HospitalAdmin"){
//                    for(Person.PersonType pt : Person.PersonType.values()){
//                    if(pt.getValue().equals(Person.PersonType.Admin.getValue())){
//                    personTypejComboBox.addItem(pt);
//                }
//                    }
//            }
//        if(organization.getName() == "PharmaceuticalAdmin"){
//                    for(Person.PersonType pt : Person.PersonType.values()){
//                    if(pt.getValue().equals(Person.PersonType.Admin.getValue())){
//                    personTypejComboBox.addItem(pt);
//                }
//                    }
//            }
        
    }//GEN-LAST:event_organizationPersonJComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addPersonJButton;
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JTable organizationJTable;
    private javax.swing.JComboBox organizationPersonJComboBox;
    private javax.swing.JComboBox personTypejComboBox;
    private javax.swing.JButton refreshjButton;
    // End of variables declaration//GEN-END:variables
}
