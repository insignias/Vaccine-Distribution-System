/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserInterface.SystemAdminRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Person.Person;
import Business.Role.EnterpriseAdminRole;
import Business.UserAccount.UserAccount;
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
public class ManageEnterpriseAdminJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem ecoSystem;
    public ManageEnterpriseAdminJPanel(JPanel upc, EcoSystem ecoSystem) {
        initComponents();
        userProcessContainer = upc;
        this.ecoSystem = ecoSystem;
        populateNetworkComboBox();
        populateEnterpriseTable();
        
    }

    private void populateNetworkComboBox(){
        networkjComboBox.removeAllItems();
        for(Network network : ecoSystem.getNetworkList()){
            networkjComboBox.addItem(network);
        }
    }
    
    private void populateEnterpriseComboBox(Network network){
        enterprisejComboBox.removeAllItems();
        personTypejComboBox.removeAllItems();
        boolean flag = false;
        for(Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()){
            enterprisejComboBox.addItem(enterprise);
            if(flag == false){
            for(Person.PersonType pt : Person.PersonType.values()){
                if(pt.getValue().equals(Person.PersonType.EnterpriseAdmin.getValue())){
                    personTypejComboBox.addItem(pt);
                    flag = true;
                    break;
                }
                }
            }
            
        }
        
    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        enterprisejComboBox = new javax.swing.JComboBox();
        networkjComboBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        backjButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        enterpriseAdminjTable = new javax.swing.JTable();
        passwordjTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        namejTextField = new javax.swing.JTextField();
        submitjButton = new javax.swing.JButton();
        usernamejTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        personTypejComboBox = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        enterprisejComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(enterprisejComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 196, -1, -1));

        networkjComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        networkjComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                networkjComboBoxActionPerformed(evt);
            }
        });
        add(networkjComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 151, -1, -1));

        jLabel2.setText("Enterprise:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 200, -1, -1));

        jLabel1.setText("Network:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 155, -1, -1));

        jLabel4.setText("Password:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 338, -1, -1));

        backjButton.setText("<< Back");
        backjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButtonActionPerformed(evt);
            }
        });
        add(backjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 424, -1, -1));

        jLabel3.setText("Username:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 292, -1, -1));

        enterpriseAdminjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Enterprise Name", "Location", "Network", "Username"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(enterpriseAdminjTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 41, 375, 92));
        add(passwordjTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 332, 96, -1));

        jLabel5.setText("Person Name :");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 384, -1, -1));
        add(namejTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 378, 96, -1));

        submitjButton.setText("Submit");
        submitjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitjButtonActionPerformed(evt);
            }
        });
        add(submitjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 424, -1, -1));
        add(usernamejTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 286, 96, -1));

        jLabel6.setText("Person Role:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 245, -1, -1));

        personTypejComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(personTypejComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 241, -1, -1));

        jLabel7.setFont(new java.awt.Font("American Typewriter", 1, 18)); // NOI18N
        jLabel7.setText("MANAGE ENTERPRISE ADMIN");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 6, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void networkjComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_networkjComboBoxActionPerformed
        Network network = (Network)networkjComboBox.getSelectedItem();
        if(network != null){
            populateEnterpriseComboBox(network);

        }
    }//GEN-LAST:event_networkjComboBoxActionPerformed

    private void populateEnterpriseTable(){
        DefaultTableModel dtm = (DefaultTableModel)enterpriseAdminjTable.getModel();
        dtm.setRowCount(0);
        
        for(Network network : ecoSystem.getNetworkList()){
            for(Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()){
                for(UserAccount ua : enterprise.getUserAccountDirectory().getUserAccountList()){
                Object[] row = new Object[4];
                row[0] = enterprise.getName();
                row[1] = enterprise.getLocation();
                row[2] = network.getName();
                row[3] = ua.getUsername();
                dtm.addRow(row);
                }
            }
        }
        
    }
    
    private void backjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButtonActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backjButtonActionPerformed

    private void submitjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitjButtonActionPerformed
        Enterprise enterprise = (Enterprise)enterprisejComboBox.getSelectedItem();
        Person.PersonType pt = (Person.PersonType)personTypejComboBox.getSelectedItem();
        String username;
        try
        {
        username = usernamejTextField.getText();
        if ((usernamejTextField.getText().startsWith(" ")) || (usernamejTextField.getText().isEmpty()))
            throw new Exception(" Please enter valid characters for Username ");
        }        
        catch (Exception e) {
        //System.err.println("Caught IOException: " + e.getMessage());
        JOptionPane.showMessageDialog(null,e.getMessage());
        return;
        }
        String password;
        try
        {
        password = passwordjTextField.getText();
        if ((passwordjTextField.getText().startsWith(" ")) || (passwordjTextField.getText().isEmpty()))
            throw new Exception(" Please enter valid characters for Username ");
        }        
        catch (Exception e) {
        //System.err.println("Caught IOException: " + e.getMessage());
        JOptionPane.showMessageDialog(null,e.getMessage());
        return;
        }
        String name;
        
        try
        {
        String regex = "[^&%$#@!0-9()~`.,]*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(namejTextField.getText());
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
        name = namejTextField.getText();
        if ((namejTextField.getText().startsWith(" ")) || (namejTextField.getText().isEmpty()))
            throw new Exception(" Please enter valid characters for Username ");
        }        
        catch (Exception e) {
        //System.err.println("Caught IOException: " + e.getMessage());
        JOptionPane.showMessageDialog(null,e.getMessage());
        return;
        }
        Person person = enterprise.getPersonDirectory().createAndAddPerson(name, pt);
        namejTextField.setText("");
        boolean check = enterprise.getUserAccountDirectory().checkIfUsernameUnique(username);
        boolean f = true;
        for(Organization o : enterprise.getOrganizationDirectory().getOrganizationList()){
            if(o!=null){
            boolean flag = o.getUserAccountDirectory().checkIfUsernameUnique(username);
        
       // if(check==true){
            if(flag == true){
                f = true;
        }
       // }
        else
        {

            f=false;
        }
        }
        }
            
                if(check==true&&f==true){
            
        UserAccount ua = enterprise.getUserAccountDirectory().createAndAddUserAccount(username, password, person, new EnterpriseAdminRole());
        populateEnterpriseTable();
        usernamejTextField.setText("");
        passwordjTextField.setText("");
        JOptionPane.showMessageDialog(null, "Account created successfully");
        
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Username already exists");
            usernamejTextField.setText("");
            passwordjTextField.setText("");
        }
            
                
        
    }//GEN-LAST:event_submitjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backjButton;
    private javax.swing.JTable enterpriseAdminjTable;
    private javax.swing.JComboBox enterprisejComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField namejTextField;
    private javax.swing.JComboBox networkjComboBox;
    private javax.swing.JTextField passwordjTextField;
    private javax.swing.JComboBox personTypejComboBox;
    private javax.swing.JButton submitjButton;
    private javax.swing.JTextField usernamejTextField;
    // End of variables declaration//GEN-END:variables
}
