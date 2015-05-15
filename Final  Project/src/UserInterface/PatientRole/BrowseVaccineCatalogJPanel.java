/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.PatientRole;

import Business.EcoSystem;
import Business.Enterprise.ClinicEnterprise;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.ClinicOrganization;
import Business.Organization.Organization;
import Business.Organization.PatientOrganization;
import Business.Person.Clinician;
import Business.Person.Order;
import Business.Person.OrderItem;
import Business.Person.Patient;
import Business.Person.Person;
import Business.Person.Vaccine;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.OrderRequest;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author insignia
 */
public class BrowseVaccineCatalogJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem ecoSystem;
    private ClinicEnterprise clinicEnt;
    private PatientOrganization patientOrganization;
    private UserAccount account;
    private static int count;
    int totalQuantity;
    int totalQuant;
    private Order order;
    boolean isCheckOut = false;
    String name;
    int prodQuantSold;
    public BrowseVaccineCatalogJPanel(JPanel upc, ClinicEnterprise clinicEnt, UserAccount account, PatientOrganization patientOrganization, EcoSystem ecoSystem) {
        initComponents();
        userProcessContainer = upc;
        this.ecoSystem = ecoSystem;
        this.clinicEnt = clinicEnt;
        this.patientOrganization = patientOrganization;
        this.account = account;
        patientNameJTextField.setText(account.getPerson().getName());
        
         if(isCheckOut == false)
        {   
            order = new Order();
        }
        
        clinicComboBox.removeAllItems();
        
                ClinicOrganization clinicOrg = null;
                Clinician clinician = null;
                for(Organization organization : clinicEnt.getOrganizationDirectory().getOrganizationList()){
                    if(organization instanceof ClinicOrganization){
                        clinicOrg = (ClinicOrganization)organization;
                        for(Person person : clinicOrg.getPersonDirectory().getPersonList()){
                            if(person instanceof Clinician){
                                clinician = (Clinician)person;
                                    clinicComboBox.addItem(clinician);
                                    
                                }
                            }
                                
                        }
                        
                    }
                
 
    }
    
    private void refreshVaccineTable(String keyWord)
    {   boolean flag = false;
        DefaultTableModel dtm = (DefaultTableModel)vaccineJTable.getModel();
        dtm.setRowCount(0);
 
            Clinician clinician = (Clinician)clinicComboBox.getSelectedItem();
                for(Vaccine v : clinician.getVaccineCatalog().getVaccineCatalog())
                {
                    if(v.getVaccineName().equals(keyWord))
                        {  
                        Object row[] = new Object[3];
                        row[0] = v;
                        row[1] = v.getPrice();
                        row[2] = v.getQuantity();
                        dtm.addRow(row);
                        flag=true;
                        break;
                        }
                }
                if (flag == false)
                {
                JOptionPane.showMessageDialog(null,"Vaccine not present");
                return;
                }
                      
    }
    
    
    private void refreshVaccineTable()
    {
        DefaultTableModel dtm = (DefaultTableModel)vaccineJTable.getModel();
        dtm.setRowCount(0);
        
        Clinician clinician = (Clinician)clinicComboBox.getSelectedItem();
        if(clinician == null){
            JOptionPane.showMessageDialog(null, "Please select a supplier");
            return;
        }
        
        for(Vaccine v : clinician.getVaccineCatalog().getVaccineCatalog())
        {
            Object row[] = new Object[3];
            row[0] = v;
            row[1] = v.getPrice();
            row[2] = v.getQuantity();
            dtm.addRow(row);
        }
        
    }
    
    private void refreshOrderTable(){
        DefaultTableModel dtm = (DefaultTableModel)orderJTable.getModel();
        dtm.setRowCount(0);
        
        for(OrderItem oi : order.getOrderItemList())
        {
            Object[] row = new Object[4];
            row[0] = oi;
            row[1] = oi.getVaccine().getPrice();
            row[2] = oi.getQuantity();
            row[3] = oi.getSalesPrice();
            dtm.addRow(row);
        }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        vaccineJTable = new javax.swing.JTable();
        checkOutJButton = new javax.swing.JButton();
        removeJButton = new javax.swing.JButton();
        viewProductDetailsJButton = new javax.swing.JButton();
        refreshJButton = new javax.swing.JButton();
        addToCartJButton = new javax.swing.JButton();
        txtNewFieldJTextField = new javax.swing.JTextField();
        quantityJSpinner = new javax.swing.JSpinner();
        itemsInCartJLabel = new javax.swing.JLabel();
        quantityJLabel = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();
        supplierProductCatalogJLabel = new javax.swing.JLabel();
        customerNameJLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        orderJTable = new javax.swing.JTable();
        patientNameJTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        viewItemJButton = new javax.swing.JButton();
        modifyJButton = new javax.swing.JButton();
        clinicComboBox = new javax.swing.JComboBox();
        txtSearchKeyword = new javax.swing.JTextField();
        searchProductJButton = new javax.swing.JButton();

        vaccineJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Vaccine Name", "Price", "Available"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(vaccineJTable);

        checkOutJButton.setText("Checkout");
        checkOutJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkOutJButtonActionPerformed(evt);
            }
        });

        removeJButton.setText("Remove");
        removeJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeJButtonActionPerformed(evt);
            }
        });

        viewProductDetailsJButton.setText("View Vaccine Detail");
        viewProductDetailsJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewProductDetailsJButtonActionPerformed(evt);
            }
        });

        refreshJButton.setText("Refresh");
        refreshJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButtonActionPerformed(evt);
            }
        });

        addToCartJButton.setText("Add To Cart");
        addToCartJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToCartJButtonActionPerformed(evt);
            }
        });

        itemsInCartJLabel.setText("Items In Cart");

        quantityJLabel.setText("Quantity");

        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        supplierProductCatalogJLabel.setText("Clinic Vaccine Catalog");

        customerNameJLabel.setText("Patient Name:");

        orderJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Vaccine Name", "Price", "Quantity", "Total Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(orderJTable);

        patientNameJTextField.setEnabled(false);

        jLabel1.setText("Enter Vaccine name below:");

        viewItemJButton.setText("View Item");
        viewItemJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewItemJButtonActionPerformed(evt);
            }
        });

        modifyJButton.setText("Modify");
        modifyJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyJButtonActionPerformed(evt);
            }
        });

        clinicComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clinicComboBoxActionPerformed(evt);
            }
        });

        searchProductJButton.setText("Search Vaccine");
        searchProductJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchProductJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(itemsInCartJLabel)
                                    .addComponent(backJButton)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(viewItemJButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNewFieldJTextField)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(modifyJButton)
                                .addGap(18, 18, 18)
                                .addComponent(checkOutJButton)
                                .addGap(18, 18, 18)
                                .addComponent(removeJButton)
                                .addGap(27, 27, 27)
                                .addComponent(refreshJButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(supplierProductCatalogJLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(viewProductDetailsJButton)
                                .addGap(174, 174, 174)
                                .addComponent(quantityJLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(quantityJSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                .addComponent(addToCartJButton))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(clinicComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(customerNameJLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(patientNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtSearchKeyword, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(searchProductJButton))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(101, 101, 101)
                                        .addComponent(jLabel1)
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(customerNameJLabel)
                            .addComponent(patientNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clinicComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearchKeyword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchProductJButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(supplierProductCatalogJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewProductDetailsJButton)
                    .addComponent(addToCartJButton)
                    .addComponent(quantityJSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantityJLabel))
                .addGap(13, 13, 13)
                .addComponent(itemsInCartJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewItemJButton)
                    .addComponent(modifyJButton)
                    .addComponent(checkOutJButton)
                    .addComponent(removeJButton)
                    .addComponent(refreshJButton)
                    .addComponent(txtNewFieldJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(backJButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void checkOutJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkOutJButtonActionPerformed
        count++;
        order.setOrderNumber(count);
//        if(business.getMasterOrderCatalog() == null){
//            System.out.println("moc is null");
//        }
        Patient patient = (Patient)account.getPerson();
        patient.getOrderHistory().addOrder(order);
//        business.getMasterOrderCatalog().addOrder(order);

        OrderRequest request = new OrderRequest();
        request.setOrderId(order.getOrderNumber());
        request.setSender(account);
        request.setStatus("sent");

        Organization org = null;
        for(Network n : ecoSystem.getNetworkList()){
            boolean flag = false;
            for(Enterprise e: n.getEnterpriseDirectory().getEnterpriseList()){
//                System.out.println("enterprise: " +e);
                if(request.getLocation().equals(e.getLocation())){
                    //System.out.println("hospitalEnterprise.getLocation(): " +hospitalEnterprise.getLocation());
                    System.out.println("e.getLocation(): " +e.getLocation());
                    System.out.println("beforeif enterpriseType: " +e.getEnterpriseType().getValue());
                    if(e.getEnterpriseType().getValue().equals("ClinicEnterprise")){
                        System.out.println("enterpriseType: " +e.getEnterpriseType().getValue());
                        for(Organization o : e.getOrganizationDirectory().getOrganizationList()){
                            System.out.println("organization: " +o.getName());
                            if(o instanceof ClinicOrganization){
                            System.out.println("instance of DistributorWarehouse Organization");
                            org = o;
                            flag = true;
                            break;
                        }
                    }
                }
            }
                if(flag==true)
                {
                    break;
                }
        }

        order = new Order();

        refreshOrderTable();
        JOptionPane.showMessageDialog(null,"Checkout successful");
        }
    }//GEN-LAST:event_checkOutJButtonActionPerformed

    private void removeJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeJButtonActionPerformed
        int selectedRow = orderJTable.getSelectedRow();
        if(selectedRow<0)
        {
            JOptionPane.showMessageDialog(null, "Please select a row from the table");
            return;
        }
        OrderItem oi = (OrderItem)orderJTable.getValueAt(selectedRow, 0);
        order.removeOrderItem(oi);
        refreshOrderTable();
        refreshVaccineTable();
        JOptionPane.showMessageDialog(null,"Order Item deleted");
    }//GEN-LAST:event_removeJButtonActionPerformed

    private void viewProductDetailsJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewProductDetailsJButtonActionPerformed
        int selectedRow = vaccineJTable.getSelectedRow();

        if(selectedRow<0)
        {
            JOptionPane.showMessageDialog(null, "Please select a row from the Product Table");
            return;
        }
        Vaccine v = (Vaccine)vaccineJTable.getValueAt(selectedRow, 0);

//        ViewProductDetailJPanel vpdjp = new ViewProductDetailJPanel(userProcessContainer,p);
//        userProcessContainer.add("ViewProductDetailJPanel", vpdjp);
//        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
//        layout.next(userProcessContainer);
    }//GEN-LAST:event_viewProductDetailsJButtonActionPerformed

    private void refreshJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButtonActionPerformed
        refreshOrderTable();
        refreshVaccineTable();
    }//GEN-LAST:event_refreshJButtonActionPerformed

    private void addToCartJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToCartJButtonActionPerformed

        int quantity = (Integer)quantityJSpinner.getValue();
        int selectedRow = vaccineJTable.getSelectedRow();

        if(selectedRow<0)
        {
            JOptionPane.showMessageDialog(null, "Please select a row from the Vaccine Table");
            return;
        }

        Vaccine v = (Vaccine)vaccineJTable.getValueAt(selectedRow, 0);
        System.out.println("Product:" +v);
        if(quantity<=0 || quantity > v.getQuantity())
        {
            JOptionPane.showMessageDialog(null, "Please select a quantity greater than zero and less than or equal to Avail");
            return;
        }

        boolean flag = true;

        ArrayList<OrderItem> oiList =  order.getOrderItemList();
        for(OrderItem orderItem : oiList)
        {
            if(orderItem.getVaccine()== v){
                int oldQuantity = orderItem.getQuantity();
                System.out.println("oldquantity:" +oldQuantity);
                int newQuantity = quantity+oldQuantity;
                orderItem.setQuantity(newQuantity);
                v.setAvail(v.getAvail()-quantity);
                flag = false;

                totalQuantity = newQuantity;
                System.out.println("total quantity : " +totalQuantity);
            }
        }

        if(flag){
            OrderItem oi = order.addOrderItem(v, quantity);
            //           OrderItem oi = customer.getOrder().addOrderItem(p, quantity);
            System.out.println("Vaccine: " +v+ "quantity: "+quantity);
            v.setQuantity(v.getQuantity()-quantity);
            totalQuant = totalQuant + quantity;
            System.out.println("if flag total quantity : " +totalQuant);

        }

        String caption = "You have added the Vaccine : "+v+" with quantity"+quantity+"";
        JOptionPane.showMessageDialog(null, caption);
        refreshOrderTable();
        refreshVaccineTable();
    }//GEN-LAST:event_addToCartJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void viewItemJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewItemJButtonActionPerformed
        int selectedRow = orderJTable.getSelectedRow();

        if(selectedRow<0)
        {
            JOptionPane.showMessageDialog(null, "Please select a row from the Order Table");
            return;
        }
        OrderItem oi = (OrderItem)orderJTable.getValueAt(selectedRow, 0);

//        ViewOrderItemDetailJPanel voidjp = new ViewOrderItemDetailJPanel(userProcessContainer,oi);
//        userProcessContainer.add("ViewOrderItemDetailJPanel",voidjp );
//        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
//        layout.next(userProcessContainer);
    }//GEN-LAST:event_viewItemJButtonActionPerformed

    private void modifyJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyJButtonActionPerformed
        String modifiedQuantityString = txtNewFieldJTextField.getText();
        try{
            int modifiedQuantity = Integer.parseInt(modifiedQuantityString);
            int selectedRow = orderJTable.getSelectedRow();
            if(selectedRow<0)
            {
                JOptionPane.showMessageDialog(null, "Please select a row from the Order Table");
                return;
            }

            OrderItem oi =(OrderItem)orderJTable.getValueAt(selectedRow, 0);

            if(modifiedQuantity > oi.getQuantity()){

                int value = modifiedQuantity - oi.getQuantity();
                if(oi.getVaccine().getQuantity()<value){
                    JOptionPane.showMessageDialog(null, " Please enter a valid quantity ");
                    return;
                }
                oi.setQuantity(modifiedQuantity);
                int avail = oi.getVaccine().getQuantity();
                int newavail = avail-value;
                oi.getVaccine().setQuantity(newavail);
            }
            else
            {
                int value = oi.getQuantity() - modifiedQuantity;
                oi.setQuantity(modifiedQuantity);
                int avail = oi.getVaccine().getQuantity();
                int newavail = avail + value;
                oi.getVaccine().setQuantity(newavail);
            }
            refreshOrderTable();
            refreshVaccineTable();
            JOptionPane.showMessageDialog(null,"Order Item modified");
            txtNewFieldJTextField.setText("");
        }

        catch(NumberFormatException ne)
        {
            JOptionPane.showMessageDialog(null, "Please a enter a valid quantity ");
            return;
        }
    }//GEN-LAST:event_modifyJButtonActionPerformed

    private void clinicComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clinicComboBoxActionPerformed
        refreshVaccineTable();
    }//GEN-LAST:event_clinicComboBoxActionPerformed

    private void searchProductJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchProductJButtonActionPerformed
        String keyWord;
        try
        {
            keyWord = txtSearchKeyword.getText();
            if ((txtSearchKeyword.getText().startsWith(" ")) || (txtSearchKeyword.getText().isEmpty()))
            throw new Exception(" Please enter valid characters for Search Box ");
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
            return;
        }
        System.out.println("keyword : " +keyWord);
        refreshVaccineTable(keyWord);

    }//GEN-LAST:event_searchProductJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addToCartJButton;
    private javax.swing.JButton backJButton;
    private javax.swing.JButton checkOutJButton;
    private javax.swing.JComboBox clinicComboBox;
    private javax.swing.JLabel customerNameJLabel;
    private javax.swing.JLabel itemsInCartJLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton modifyJButton;
    private javax.swing.JTable orderJTable;
    private javax.swing.JTextField patientNameJTextField;
    private javax.swing.JLabel quantityJLabel;
    private javax.swing.JSpinner quantityJSpinner;
    private javax.swing.JButton refreshJButton;
    private javax.swing.JButton removeJButton;
    private javax.swing.JButton searchProductJButton;
    private javax.swing.JLabel supplierProductCatalogJLabel;
    private javax.swing.JTextField txtNewFieldJTextField;
    private javax.swing.JTextField txtSearchKeyword;
    private javax.swing.JTable vaccineJTable;
    private javax.swing.JButton viewItemJButton;
    private javax.swing.JButton viewProductDetailsJButton;
    // End of variables declaration//GEN-END:variables
}
