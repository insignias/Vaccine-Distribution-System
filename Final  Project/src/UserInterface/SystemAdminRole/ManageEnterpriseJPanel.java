/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserInterface.SystemAdminRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
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
public class ManageEnterpriseJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem ecoSystem;
    public ManageEnterpriseJPanel(JPanel upc, EcoSystem ecoSystem) {
        initComponents();
        userProcessContainer = upc;
        this.ecoSystem = ecoSystem;
        populateNetworkComboBox();
        populateEnterpriseTable();
        locationjComboBox.removeAllItems();
        
        locationjComboBox.addItem("AL");
        locationjComboBox.addItem("AK");
        locationjComboBox.addItem("AR");
        locationjComboBox.addItem("AZ");
        locationjComboBox.addItem("CA");
        locationjComboBox.addItem("CO");
        locationjComboBox.addItem("CT");
        locationjComboBox.addItem("DE");
        locationjComboBox.addItem("FL");
        locationjComboBox.addItem("GA");
        locationjComboBox.addItem("HI");
        locationjComboBox.addItem("ID");
        locationjComboBox.addItem("IL");
        locationjComboBox.addItem("IN");
        locationjComboBox.addItem("IA");
        locationjComboBox.addItem("KS");
        locationjComboBox.addItem("KY");
        locationjComboBox.addItem("LA");
        locationjComboBox.addItem("ME");
        locationjComboBox.addItem("MD");
        locationjComboBox.addItem("MA");
        locationjComboBox.addItem("MI");
        locationjComboBox.addItem("MN");
        locationjComboBox.addItem("MS");
        locationjComboBox.addItem("MO");
        locationjComboBox.addItem("MT");
        locationjComboBox.addItem("NE");
        locationjComboBox.addItem("NV");
        locationjComboBox.addItem("NH");
        locationjComboBox.addItem("NJ");
        locationjComboBox.addItem("NM");
        locationjComboBox.addItem("NY");
        locationjComboBox.addItem("NC");
        locationjComboBox.addItem("ND");
        locationjComboBox.addItem("OH");
        locationjComboBox.addItem("OK");
        locationjComboBox.addItem("OR");
        locationjComboBox.addItem("PA");
        locationjComboBox.addItem("RI");
        locationjComboBox.addItem("SC");
        locationjComboBox.addItem("SD");
        locationjComboBox.addItem("TN");
        locationjComboBox.addItem("TX");
        locationjComboBox.addItem("UT");
        locationjComboBox.addItem("VT");
        locationjComboBox.addItem("VA");
        locationjComboBox.addItem("WA");
        locationjComboBox.addItem("WV");
        locationjComboBox.addItem("WI");
        locationjComboBox.addItem("WY");
        
    }

    private void populateNetworkComboBox(){
        networkjComboBox.removeAllItems();
        EnterprisejComboBox.removeAllItems();
        for(Network network : ecoSystem.getNetworkList())
        {
            networkjComboBox.addItem(network);
                if(network!=null)
                {
                for(Enterprise.EnterpriseType type : Enterprise.EnterpriseType.values())
                    {   
                        if(!type.getValue().equals("DistributorWarehouse")&&!type.getValue().equals("Clinic")&&!type.getValue().equals("PHD")){
                            EnterprisejComboBox.addItem(type);
                        }
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Please define a network");
                    return;
                }
        }
    }
    
    private void populateEnterpriseTable(){
       DefaultTableModel model = (DefaultTableModel)enterprisejTable.getModel();
       
       model.setRowCount(0);
       for(Network network : ecoSystem.getNetworkList()){
           for(Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()){
           Object[] row = new Object[4];
           row[0] = enterprise.getName();
           row[1] = enterprise.getLocation();
           row[2] = network.getName();
           row[3] = enterprise.getEnterpriseType().getValue();
           model.addRow(row);
           }
       }
   }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        enterpriseNamejTextField = new javax.swing.JTextField();
        networkjComboBox = new javax.swing.JComboBox();
        EnterprisejComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        submitjButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        backjButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        enterprisejTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        locationjComboBox = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(enterpriseNamejTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 301, 96, -1));

        networkjComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(networkjComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 165, -1, -1));

        EnterprisejComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        EnterprisejComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnterprisejComboBoxActionPerformed(evt);
            }
        });
        add(EnterprisejComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 210, -1, -1));

        jLabel1.setText("Network:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 176, -1, -1));

        submitjButton.setText("Submit");
        submitjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitjButtonActionPerformed(evt);
            }
        });
        add(submitjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 347, -1, -1));

        jLabel2.setText("Enterprise Type :");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 221, -1, -1));

        backjButton.setText("<< Back");
        backjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButtonActionPerformed(evt);
            }
        });
        add(backjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 347, -1, -1));

        enterprisejTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Enterprise Name", "Location", "Network", "Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(enterprisejTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 47, 375, 100));

        jLabel3.setText("Location:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 260, -1, -1));

        jLabel4.setText("Name:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 307, -1, -1));

        locationjComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(locationjComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 256, -1, -1));

        jLabel5.setFont(new java.awt.Font("American Typewriter", 1, 18)); // NOI18N
        jLabel5.setText("MANAGE ENTERPRISE");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 6, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void submitjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitjButtonActionPerformed
        Network network = (Network)networkjComboBox.getSelectedItem();
        Enterprise.EnterpriseType type = (Enterprise.EnterpriseType)EnterprisejComboBox.getSelectedItem();
        
        if(network == null || type == null){
            
            JOptionPane.showMessageDialog(null, "invalid input");
            return;

        }
//        if(!type.equals("CDC")||!type.equals("Distributor")){
//                enterpriseNamejTextField.setEditable(true);
//            }
        String name;
        try
        {
        String regex = "[^&%$#@!0-9()~`.,]*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(enterpriseNamejTextField.getText());
        if (!matcher.matches()) 
        throw new Exception("Enter valid characters for Enterprise name");
        }
        catch (Exception e) {
        //System.err.println("Caught IOException: " + e.getMessage());
        JOptionPane.showMessageDialog(null,e.getMessage());
        return;
        }
        
        
        try
        {
        name = enterpriseNamejTextField.getText();
        if ((enterpriseNamejTextField.getText().startsWith(" ")) || (enterpriseNamejTextField.getText().isEmpty()))
            throw new Exception(" Please enter valid characters for name ");
        }        
        catch (Exception e) {
        //System.err.println("Caught IOException: " + e.getMessage());
        JOptionPane.showMessageDialog(null,e.getMessage());
        return;
        }
        String location;
        if(type.equals(Enterprise.EnterpriseType.CDC)||type.equals(Enterprise.EnterpriseType.Distributor)||type.equals(Enterprise.EnterpriseType.Manufacturer)||type.equals(Enterprise.EnterpriseType.Insurance))
        {
        location = "";
        }
        else
        {    
        location = (String)locationjComboBox.getSelectedItem();
        }
        
        boolean flag = network.getEnterpriseDirectory().checkIfCDCAndDistributorUnique(type);
        if(flag==true){
        Enterprise enterprise = network.getEnterpriseDirectory().createAndAddEnterprise(name, type);
        enterprise.setLocation(location);
        populateEnterpriseTable();
        enterpriseNamejTextField.setText("");
        }
        else{
            JOptionPane.showMessageDialog(null, type+ " already exists");
            enterpriseNamejTextField.setText("");
        }
        
        
    }//GEN-LAST:event_submitjButtonActionPerformed

    private void backjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButtonActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backjButtonActionPerformed

    private void EnterprisejComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnterprisejComboBoxActionPerformed
        Network network = (Network)networkjComboBox.getSelectedItem();
        Enterprise.EnterpriseType type = (Enterprise.EnterpriseType)EnterprisejComboBox.getSelectedItem();
        if(network != null && type != null){
        System.out.println("etype: " +type);
        if(type.equals(Enterprise.EnterpriseType.CDC)||type.equals(Enterprise.EnterpriseType.Distributor)||type.equals(Enterprise.EnterpriseType.Manufacturer)||type.equals(Enterprise.EnterpriseType.Insurance)){
           
           locationjComboBox.setEnabled(false);
        }
        else
        {
            locationjComboBox.setEnabled(true);
        }
        }
    }//GEN-LAST:event_EnterprisejComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox EnterprisejComboBox;
    private javax.swing.JButton backjButton;
    private javax.swing.JTextField enterpriseNamejTextField;
    private javax.swing.JTable enterprisejTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox locationjComboBox;
    private javax.swing.JComboBox networkjComboBox;
    private javax.swing.JButton submitjButton;
    // End of variables declaration//GEN-END:variables
}
