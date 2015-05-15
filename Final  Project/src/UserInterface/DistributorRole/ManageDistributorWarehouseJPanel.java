/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserInterface.DistributorRole;


import Business.EcoSystem;
import Business.Enterprise.DistributorEnterprise;
import Business.Enterprise.DistributorWarehouseEnterprise;
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
public class ManageDistributorWarehouseJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem ecoSystem;
    private DistributorEnterprise distEnterprise;
    public ManageDistributorWarehouseJPanel(JPanel upc, DistributorEnterprise distEnterprise, EcoSystem ecoSystem) {
        initComponents();
        userProcessContainer = upc;
        this.ecoSystem = ecoSystem;
        this.distEnterprise = distEnterprise;
        
        
        enterpriseTypejComboBox.removeAllItems();
                for(Enterprise.EnterpriseType type : Enterprise.EnterpriseType.values())
                    {
                        if(type.getValue().equals(Enterprise.EnterpriseType.DistributorWarehouse.getValue())){
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
    }
    
    private void populateWarehouseTable(){
       DefaultTableModel model = (DefaultTableModel)warehousejTable.getModel();
       
       model.setRowCount(0);
       Enterprise ent = null;
       for(Network network : ecoSystem.getNetworkList()){
           for(Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()){
               if(enterprise instanceof DistributorWarehouseEnterprise){
                   ent = enterprise;
                   Object[] row = new Object[2];
                   row[0] = ent.getName();
                   row[1] = ent.getLocation();
                   model.addRow(row);
               }
           }
           
       }
   }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        warehouseNamejTextField = new javax.swing.JTextField();
        addWarehousejButton = new javax.swing.JButton();
        enterpriseTypejComboBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        warehousejTable = new javax.swing.JTable();
        refreshjButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        locationjComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();

        jLabel1.setText("Warehouse Name:");

        addWarehousejButton.setText("Add Warehouse");
        addWarehousejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addWarehousejButtonActionPerformed(evt);
            }
        });

        enterpriseTypejComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Enterprise Type:");

        jLabel3.setText("Warehouse Location:");

        warehousejTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Warehouse Name", "Location"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(warehousejTable);

        refreshjButton.setText("Refresh");
        refreshjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshjButtonActionPerformed(evt);
            }
        });

        backButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        backButton.setText("<< Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        locationjComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setFont(new java.awt.Font("American Typewriter", 1, 18)); // NOI18N
        jLabel4.setText("DISTRIBUTOR MANAGE DISTRIBUTOR WAREHOUSE ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(47, 47, 47)
                                .addComponent(enterpriseTypejComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(36, 36, 36)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(warehouseNamejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(locationjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(backButton)
                                .addGap(18, 18, 18)
                                .addComponent(refreshjButton)
                                .addGap(18, 18, 18)
                                .addComponent(addWarehousejButton)))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(enterpriseTypejComboBox))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(locationjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(warehouseNamejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(refreshjButton)
                    .addComponent(addWarehousejButton))
                .addGap(0, 20, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addWarehousejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addWarehousejButtonActionPerformed
//       for(Network n : ecoSystem.getNetworkList()){
//           for(Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()){
//               if(e.getEnterpriseType().getValue()=="Clinic"){
                
                    Enterprise.EnterpriseType eType = (Enterprise.EnterpriseType)enterpriseTypejComboBox.getSelectedItem();
                    String name;
                    try
                        {
                        String regex = "[^&%$#@!0-9()~`.,]*";
                        Pattern pattern = Pattern.compile(regex);
                        Matcher matcher = pattern.matcher(warehouseNamejTextField.getText());
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
                        name = warehouseNamejTextField.getText();
                        if ((warehouseNamejTextField.getText().startsWith(" ")) || (warehouseNamejTextField.getText().isEmpty()))
                            throw new Exception(" Please enter valid characters for name ");
                             }        
                            catch (Exception e) {
                                    //System.err.println("Caught IOException: " + e.getMessage());
                                    JOptionPane.showMessageDialog(null,e.getMessage());
                                    return;
                                    }
                    String location = (String)locationjComboBox.getSelectedItem();
                    DistributorWarehouseEnterprise distWarehouseEnterprise = new DistributorWarehouseEnterprise(name, eType);
                    distWarehouseEnterprise.setLocation(location);
                    distEnterprise.createEnterprise(distWarehouseEnterprise);
                    for(Network network : ecoSystem.getNetworkList()){
                        //Enterprise.EnterpriseType eType = (Enterprise.EnterpriseType)enterpriseTypejComboBox.getSelectedItem();
                        Enterprise enterprise = network.getEnterpriseDirectory().createAndAddEnterprise(name, eType);
                        enterprise.setLocation(location);
                    }
                    populateWarehouseTable();
                    warehouseNamejTextField.setText("");
//                   enterpriseTypejComboBox.removeAll();
//                   enterpriseTypejComboBox.add(e.getEnterpriseType());
//                   String name = ClinicNamejTextField.getText();
//                   ClinicEnterprise ce = new ClinicEnterprise(name, Enterprise.EnterpriseType.Clinic);
//               }
//           }
//       }
        
    }//GEN-LAST:event_addWarehousejButtonActionPerformed

    private void refreshjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshjButtonActionPerformed
        populateWarehouseTable();
    }//GEN-LAST:event_refreshjButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addWarehousejButton;
    private javax.swing.JButton backButton;
    private javax.swing.JComboBox enterpriseTypejComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox locationjComboBox;
    private javax.swing.JButton refreshjButton;
    private javax.swing.JTextField warehouseNamejTextField;
    private javax.swing.JTable warehousejTable;
    // End of variables declaration//GEN-END:variables
}
