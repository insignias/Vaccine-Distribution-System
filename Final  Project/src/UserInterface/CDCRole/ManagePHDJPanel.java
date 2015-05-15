/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserInterface.CDCRole;


import Business.EcoSystem;
import Business.Enterprise.CDCEnterprise;
import Business.Enterprise.Enterprise;
import Business.Enterprise.PHDEnterprise;
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
public class ManagePHDJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem ecoSystem;
    private CDCEnterprise cdcEnterprise;
    public ManagePHDJPanel(JPanel upc, CDCEnterprise cdcEnterprise, EcoSystem ecoSystem) {
        initComponents();
        userProcessContainer = upc;
        this.ecoSystem = ecoSystem;
        this.cdcEnterprise = cdcEnterprise;
        
        
        enterpriseTypejComboBox.removeAllItems();
                for(Enterprise.EnterpriseType type : Enterprise.EnterpriseType.values())
                    {
                        if(type.getValue().equals(Enterprise.EnterpriseType.PHD.getValue())){
                        enterpriseTypejComboBox.addItem(type);
                        break;
                        }
                        
                    }
                
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
        
        populateWarehouseTable();
    }
    
    private void populateWarehouseTable(){
       DefaultTableModel model = (DefaultTableModel)phdjTable.getModel();
       
       model.setRowCount(0);
       //Enterprise ent = null;
       for(Network network : ecoSystem.getNetworkList()){
           for(Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()){
               if(enterprise instanceof PHDEnterprise){
                   //ent = enterprise;
                   Object[] row = new Object[2];
                   row[0] = enterprise.getName();
                   row[1] = enterprise.getLocation();
                   model.addRow(row);
               }
           }
                   
           
       }
   }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        phdNamejTextField = new javax.swing.JTextField();
        addPHDjButton = new javax.swing.JButton();
        enterpriseTypejComboBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        phdjTable = new javax.swing.JTable();
        refreshjButton = new javax.swing.JButton();
        backJButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        locationjComboBox = new javax.swing.JComboBox();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("PHD Name:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 248, -1, -1));
        add(phdNamejTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 242, 103, -1));

        addPHDjButton.setText("Add PHD");
        addPHDjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPHDjButtonActionPerformed(evt);
            }
        });
        add(addPHDjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 288, -1, -1));

        enterpriseTypejComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(enterpriseTypejComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 152, 111, -1));

        jLabel2.setText("Enterprise Type:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 156, -1, -1));

        jLabel3.setText("PHD Location:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 201, -1, -1));

        phdjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "PHD Name", "Location"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(phdjTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 34, 346, 100));

        refreshjButton.setText("Refresh");
        refreshjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshjButtonActionPerformed(evt);
            }
        });
        add(refreshjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 288, -1, -1));

        backJButton1.setText("<< Back");
        backJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButton1ActionPerformed(evt);
            }
        });
        add(backJButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 288, -1, -1));

        jLabel4.setFont(new java.awt.Font("American Typewriter", 1, 18)); // NOI18N
        jLabel4.setText("CDC MANAGE PHD");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, -1, -1));

        locationjComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(locationjComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 197, 111, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void addPHDjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPHDjButtonActionPerformed
                    Enterprise.EnterpriseType eType = (Enterprise.EnterpriseType)enterpriseTypejComboBox.getSelectedItem();
                    String name;
                    try
                    {
                        String regex = "[^&%$#@!0-9()~`.,]*";
                        Pattern pattern = Pattern.compile(regex);
                         Matcher matcher = pattern.matcher(phdNamejTextField.getText());
                        if (!matcher.matches()) 
                        throw new Exception("Enter valid characters for PHD name");
                    }
                    catch (Exception e) {
                    //System.err.println("Caught IOException: " + e.getMessage());
                    JOptionPane.showMessageDialog(null,e.getMessage());
                    return;
                    }

                    
                    try
                        {
                        name = phdNamejTextField.getText();
                        if ((phdNamejTextField.getText().startsWith(" ")) || (phdNamejTextField.getText().isEmpty()))
                            throw new Exception(" Please enter valid characters for name ");
                        }        
                        catch (Exception e) {
                                    //System.err.println("Caught IOException: " + e.getMessage());
                                    JOptionPane.showMessageDialog(null,e.getMessage());
                                    return;
                                }
                    String location = (String)locationjComboBox.getSelectedItem();
                    PHDEnterprise phdEnterprise = new PHDEnterprise(name, eType);
                    phdEnterprise.setLocation(location);
                    cdcEnterprise.createEnterprise(phdEnterprise);
                    for(Network network : ecoSystem.getNetworkList()){
                        //Enterprise.EnterpriseType eType = (Enterprise.EnterpriseType)enterpriseTypejComboBox.getSelectedItem();
                        Enterprise enterprise = network.getEnterpriseDirectory().createAndAddEnterprise(name, eType);
                        enterprise.setLocation(location);
                    }
                    populateWarehouseTable();
        
    }//GEN-LAST:event_addPHDjButtonActionPerformed

    private void refreshjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshjButtonActionPerformed
        populateWarehouseTable();
    }//GEN-LAST:event_refreshjButtonActionPerformed

    private void backJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButton1ActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addPHDjButton;
    private javax.swing.JButton backJButton1;
    private javax.swing.JComboBox enterpriseTypejComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox locationjComboBox;
    private javax.swing.JTextField phdNamejTextField;
    private javax.swing.JTable phdjTable;
    private javax.swing.JButton refreshjButton;
    // End of variables declaration//GEN-END:variables
}
