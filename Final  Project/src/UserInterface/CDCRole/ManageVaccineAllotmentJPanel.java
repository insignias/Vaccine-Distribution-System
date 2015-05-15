/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.CDCRole;

import Business.EcoSystem;
import Business.Enterprise.CDCEnterprise;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.CDCOrganization;
import Business.Organization.ManufacturerOrganization;
import Business.Organization.Organization;
import Business.Person.Manufacturer;
import Business.Person.Person;
import Business.Person.Vaccine;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.OrderRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author insignia
 */
public class ManageVaccineAllotmentJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount account;
    private CDCEnterprise cdcEnterprise;
    private CDCOrganization cdcOrganization;
    private EcoSystem ecoSystem;
    public ManageVaccineAllotmentJPanel(JPanel upc, UserAccount account, CDCEnterprise cdcEnterprise, CDCOrganization cdcOrganization, EcoSystem ecoSystem) {
        initComponents();
        userProcessContainer = upc;
        this.account = account;
        this.cdcEnterprise = cdcEnterprise;
        this.cdcOrganization = cdcOrganization;
        this.ecoSystem = ecoSystem;
        populateVaccineAvailableTable();
        populateReceivedRequestTable();
        
        statejComboBox.removeAllItems();
        statejComboBox.addItem("AL");
        statejComboBox.addItem("AK");
        statejComboBox.addItem("AR");
        statejComboBox.addItem("AZ");
        statejComboBox.addItem("CA");
        statejComboBox.addItem("CO");
        statejComboBox.addItem("CT");
        statejComboBox.addItem("DE");
        statejComboBox.addItem("FL");
        statejComboBox.addItem("GA");
        statejComboBox.addItem("HI");
        statejComboBox.addItem("ID");
        statejComboBox.addItem("IL");
        statejComboBox.addItem("IN");
        statejComboBox.addItem("IA");
        statejComboBox.addItem("KS");
        statejComboBox.addItem("KY");
        statejComboBox.addItem("LA");
        statejComboBox.addItem("ME");
        statejComboBox.addItem("MD");
        statejComboBox.addItem("MA");
        statejComboBox.addItem("MI");
        statejComboBox.addItem("MN");
        statejComboBox.addItem("MS");
        statejComboBox.addItem("MO");
        statejComboBox.addItem("MT");
        statejComboBox.addItem("NE");
        statejComboBox.addItem("NV");
        statejComboBox.addItem("NH");
        statejComboBox.addItem("NJ");
        statejComboBox.addItem("NM");
        statejComboBox.addItem("NY");
        statejComboBox.addItem("NC");
        statejComboBox.addItem("ND");
        statejComboBox.addItem("OH");
        statejComboBox.addItem("OK");
        statejComboBox.addItem("OR");
        statejComboBox.addItem("PA");
        statejComboBox.addItem("RI");
        statejComboBox.addItem("SC");
        statejComboBox.addItem("SD");
        statejComboBox.addItem("TN");
        statejComboBox.addItem("TX");
        statejComboBox.addItem("UT");
        statejComboBox.addItem("VT");
        statejComboBox.addItem("VA");
        statejComboBox.addItem("WA");
        statejComboBox.addItem("WV");
        statejComboBox.addItem("WI");
        statejComboBox.addItem("WY");
        
    }
    
    private void populateReceivedRequestTable(){
        DefaultTableModel dtm = (DefaultTableModel)orderRequestjTable.getModel();
        dtm.setRowCount(0);
        OrderRequest or = null;
        if(cdcOrganization !=null){
            for(WorkRequest request : cdcOrganization.getWorkQueue().getWorkRequestList()){
            if(request instanceof OrderRequest){
              or = (OrderRequest)request;
              
              Object[] row = new Object[7];
                row[0] = or;
                row[1] = or.getQuantity();
                row[2] = or.getSender().getPerson().getName();
                row[3] = or.getLocation();
                row[4] = or.getReceiver() == null ? null : or.getReceiver().getPerson().getName();
                row[5] = or.getStatus();
                row[6] = or.getOrderResult() == null ? "Waiting" : or.getOrderResult();
                dtm.addRow(row);
            }
        }
    }
            
    }

    private void populateVaccineAvailableTable(){
        DefaultTableModel dtm = (DefaultTableModel)vaccinesAvailablejTable.getModel();
        dtm.setRowCount(0);
        Organization org = null;
        //Manufacturer man = null;
        for(Network network : ecoSystem.getNetworkList()){
            for(Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()){
                for(Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
                    if(organization instanceof ManufacturerOrganization){
                        org = organization;
                        
                        for(Person p : org.getPersonDirectory().getPersonList()){
                            if(p instanceof Manufacturer){
                                Manufacturer m = (Manufacturer)p;
                                
                                for(Vaccine v : m.getVaccineCatalog().getVaccineCatalog()){
                                    Object[] row = new Object[4];
                                    row[0] = v;
                                    row[1] = v.getQuantity();
                                    row[2] = v.getDateManufactured();
                                    row[3] = v.getExpiryDate();
                                    dtm.addRow(row);
                                
                                
                                }
                            }    
                        }
                    }
                        
                }
            }
        }
    }
    
    private void populateVaccineAllotmentTable(){
        int selectedRow = vaccinesAvailablejTable.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a Row from the table");
            return;
        }
        Vaccine vaccine = (Vaccine)vaccinesAvailablejTable.getValueAt(selectedRow, 0);
        int totalPopulation;
        try
        {
            totalPopulation = Integer.parseInt(totalPopulationjTextField.getText());
        }
        catch (NumberFormatException e) {
        
        JOptionPane.showMessageDialog(null,"Please enter numeric value for price ");
        return;
        }
        try
        {
        if (totalPopulation < 0)
            throw new Exception(" Price cannot be negative ");
        }
        catch (Exception e) {
        
        JOptionPane.showMessageDialog(null,e.getMessage() );
        return;
         }
        
        String selectedItem = (String)statejComboBox.getSelectedItem();
        int statePopulation;
        try
        {
            statePopulation = Integer.parseInt(statePopulationjTextField.getText());
        }
        catch (NumberFormatException e) {
        
        JOptionPane.showMessageDialog(null,"Please enter numeric value for price ");
        return;
        }
        try
        {
        if (statePopulation < 0)
            throw new Exception(" Price cannot be negative ");
        }
        catch (Exception e) {
        
        JOptionPane.showMessageDialog(null,e.getMessage() );
        return;
         }
        
        double percentage = (double)statePopulation/totalPopulation;
        System.out.println("percentage: " +percentage);
        double quantity = percentage*vaccine.getQuantity();
        System.out.println("quantity: " +quantity);
        double allotment = Math.floor(quantity);
        DefaultTableModel dtm = (DefaultTableModel)stateVaccineAllotmentjTable.getModel();
        dtm.setRowCount(0);
        
        Object[] row = new Object[3];
        row[0] = vaccine.getVaccineName();
        row[1] = allotment;
        row[2] = statejComboBox.getSelectedItem();
        dtm.addRow(row);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        vaccinesAvailablejTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        totalPopulationjTextField = new javax.swing.JTextField();
        statePopulationjTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        getStateVaccineAllotmentjButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        stateVaccineAllotmentjTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        orderRequestjTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        statejComboBox = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        assignToMejButton = new javax.swing.JButton();
        processjButton = new javax.swing.JButton();
        refreshjButton = new javax.swing.JButton();
        backjButton = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        vaccinesAvailablejTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Vaccine Name", "Total Quantity", "Manufacture Date", "Expiry Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(vaccinesAvailablejTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 34, 375, 89));

        jLabel1.setFont(new java.awt.Font("American Typewriter", 1, 18)); // NOI18N
        jLabel1.setText("CDC MANAGE VACCINE ALLOTMENT");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        jLabel2.setText("Total Population:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 147, -1, -1));
        add(totalPopulationjTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 141, 127, -1));
        add(statePopulationjTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 232, 127, -1));

        jLabel3.setText("State Population:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 238, -1, -1));

        getStateVaccineAllotmentjButton.setText("Get State Vaccine Allotment");
        getStateVaccineAllotmentjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getStateVaccineAllotmentjButtonActionPerformed(evt);
            }
        });
        add(getStateVaccineAllotmentjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 278, -1, -1));

        stateVaccineAllotmentjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Vaccine Name", "Quantity", "Location"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(stateVaccineAllotmentjTable);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 325, 375, 92));

        orderRequestjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Vaccine Name", "Quantity", "Sender", "Location", "Receiver", "Status", "Result"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(orderRequestjTable);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 469, -1, 97));

        jLabel4.setText("State:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 191, -1, -1));

        statejComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        statejComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statejComboBoxActionPerformed(evt);
            }
        });
        add(statejComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 187, 126, -1));

        jLabel5.setText("Order Request from PHD:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 435, -1, -1));

        assignToMejButton.setText("Assign to me");
        assignToMejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignToMejButtonActionPerformed(evt);
            }
        });
        add(assignToMejButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 584, -1, -1));

        processjButton.setText("Process");
        processjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processjButtonActionPerformed(evt);
            }
        });
        add(processjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 584, -1, -1));

        refreshjButton.setText("Refresh");
        refreshjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshjButtonActionPerformed(evt);
            }
        });
        add(refreshjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 584, -1, -1));

        backjButton.setText("<< Back");
        backjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButtonActionPerformed(evt);
            }
        });
        add(backjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 584, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void getStateVaccineAllotmentjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getStateVaccineAllotmentjButtonActionPerformed
//        int selectedRow = vaccinesAvailablejTable.getSelectedRow();
//        if(selectedRow < 0){
//            JOptionPane.showMessageDialog(null, "Please select a Row from the table");
//            return;
//        }
//        Vaccine vaccine = (Vaccine)vaccinesAvailablejTable.getValueAt(selectedRow, 0);
//        int totalPopulation = Integer.parseInt(totalPopulationjTextField.getText());
//        String selectedItem = (String)statejComboBox.getSelectedItem();
//        int statePopulation = Integer.parseInt(statePopulationjTextField.getText());
//        double percentage = (double)statePopulation/totalPopulation;
//        System.out.println("percentage: " +percentage);
//        double quantity = percentage*vaccine.getQuantity();
//        System.out.println("quantity: " +quantity);
//        double allotment = Math.floor(quantity);
//        
//        
//        DefaultTableModel dtm = (DefaultTableModel)stateVaccineAllotmentjTable.getModel();
//        dtm.setRowCount(0);
//        
//        Object[] row = new Object[2];
//        row[0] = vaccine.getVaccineName();
//        row[1] = allotment;
//        row[2] = statejComboBox.getSelectedItem();
//        dtm.addRow(row);
        populateVaccineAllotmentTable();
    }//GEN-LAST:event_getStateVaccineAllotmentjButtonActionPerformed

    private void statejComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statejComboBoxActionPerformed

    }//GEN-LAST:event_statejComboBoxActionPerformed

    private void assignToMejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignToMejButtonActionPerformed
        int selectedRow = orderRequestjTable.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a Row from the table");
            return;
        }
        WorkRequest request = (WorkRequest)orderRequestjTable.getValueAt(selectedRow, 0);
        if(request.getReceiver() == null)
        {
            request.setReceiver(account);
            request.setStatus("Pending");
            populateReceivedRequestTable();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Request is already assigned");
            return;
        }
    }//GEN-LAST:event_assignToMejButtonActionPerformed

    private void refreshjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshjButtonActionPerformed
        populateVaccineAvailableTable();
        populateReceivedRequestTable();
        
    }//GEN-LAST:event_refreshjButtonActionPerformed

    private void processjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processjButtonActionPerformed
        int selectedRow = orderRequestjTable.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a Row from the table");
            return;
        }
        OrderRequest request = (OrderRequest)orderRequestjTable.getValueAt(selectedRow, 0);

        if(request.getReceiver() != null){
            if(request.getReceiver().getPerson().getName().equals(account.getPerson().getName())){
                if(!request.getOrderResult().equals("CDC Approved")){
                    request.setStatus("Processing");
                    CDCProcessOrderRequestJPanel pporjp = new CDCProcessOrderRequestJPanel(userProcessContainer, account, cdcEnterprise, cdcOrganization, request, ecoSystem);
                    userProcessContainer.add("ProviderProcessOrderRequestJPanel", pporjp);
                    CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                    layout.next(userProcessContainer);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Result has already been submitted");
                    return;
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Request is assigned to : " +request.getReceiver() );
                return;
            }
        }
        if(request.getReceiver() == null){
            JOptionPane.showMessageDialog(null, "Please assign a receiver ");
            return;
        }
    }//GEN-LAST:event_processjButtonActionPerformed

    private void backjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButtonActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignToMejButton;
    private javax.swing.JButton backjButton;
    private javax.swing.JButton getStateVaccineAllotmentjButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable orderRequestjTable;
    private javax.swing.JButton processjButton;
    private javax.swing.JButton refreshjButton;
    private javax.swing.JTextField statePopulationjTextField;
    private javax.swing.JTable stateVaccineAllotmentjTable;
    private javax.swing.JComboBox statejComboBox;
    private javax.swing.JTextField totalPopulationjTextField;
    private javax.swing.JTable vaccinesAvailablejTable;
    // End of variables declaration//GEN-END:variables
}



