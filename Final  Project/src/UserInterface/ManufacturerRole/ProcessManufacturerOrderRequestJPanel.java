/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserInterface.ManufacturerRole;


import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.ManufacturerEnterprise;
import Business.Network.Network;
import Business.Organization.DistributorWarehouseOrganization;
import Business.Organization.ManufacturerOrganization;
import Business.Organization.Organization;
import Business.Person.Manufacturer;
import Business.Person.Person;
import Business.Person.Vaccine;

import Business.UserAccount.UserAccount;
import Business.WorkQueue.InvoiceRequest;
import Business.WorkQueue.OrderRequest;
import Business.WorkQueue.ShippingRequest;

import java.awt.CardLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author relaince
 */
public class ProcessManufacturerOrderRequestJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private OrderRequest request;
    private ManufacturerOrganization manOrg;
    private EcoSystem ecoSystem;
    private UserAccount ua;
    private ManufacturerEnterprise manEnt;
    private Date d;
    private Calendar calendar;
    public ProcessManufacturerOrderRequestJPanel(JPanel userProcessContainer, UserAccount ua, ManufacturerEnterprise manEnt, ManufacturerOrganization manOrg, OrderRequest request, EcoSystem ecoSystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.request = request;
        this.manOrg = manOrg;
        this.ecoSystem = ecoSystem;
        this.ua = ua;
        this.manEnt = manEnt;
        calendar = Calendar.getInstance();
        d = calendar.getTime();
        
        resultjComboBox.removeAllItems();
        resultjComboBox.addItem("Ship");
        resultjComboBox.addItem("Do Not Ship");
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        resultjComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        submitJButton = new javax.swing.JButton();
        backJButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        resultjDateChooser = new com.toedter.calendar.JDateChooser();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        resultjComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        resultjComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultjComboBoxActionPerformed(evt);
            }
        });
        add(resultjComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 133, -1));

        jLabel1.setText("Shipping date:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 85, -1, -1));

        jLabel2.setFont(new java.awt.Font("American Typewriter", 1, 18)); // NOI18N
        jLabel2.setText("MANUFACTURER PROCESS ORDER REQUEST");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 6, -1, -1));

        submitJButton.setText("Submit");
        submitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButtonActionPerformed(evt);
            }
        });
        add(submitJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, -1, -1));

        backJButton1.setText("<< Back");
        backJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButton1ActionPerformed(evt);
            }
        });
        add(backJButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 119, -1, -1));

        jLabel3.setText("Result:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 44, -1, -1));
        add(resultjDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void submitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJButtonActionPerformed
        if(!request.getOrderResult().equals("Shipped to Distributor")){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        Date date = resultjDateChooser.getDate();
        String strDate = null;
        if(date!=null){
        strDate = DateFormat.getDateInstance().format(date);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please Enter Date");
        }
         System.out.println("calendar: " +d);
         System.out.println("date: " +date);
//         if(date.after(d)){
//         request.setProcessDate(strDate);
//         //request.setOrderResult("Will be shipped");
////         JOptionPane.showMessageDialog(null, "Result submitted");
////            return;  
//         }
//         if(date.equals(d)){
//         request.setProcessDate(strDate);
//         //request.setOrderResult("Shipped");
////         JOptionPane.showMessageDialog(null, "Result submitted");
////            return;
//         }
         if(date.before(d))
         {
             JOptionPane.showMessageDialog(null, "Please select a valid Shipment Date");
             return;
         }
        
        String status = (String)resultjComboBox.getSelectedItem();
        if(status.equals("Ship")){
            request.setStatus("Completed");
            request.setOrderResult("Shipped to Distributor");
            ShippingRequest shipRequest = new ShippingRequest();
            shipRequest.setVaccineName(request.getVaccineName());
            shipRequest.setQuantity(request.getQuantity());
            shipRequest.setSender(ua);
            shipRequest.setStatus("sent");
            shipRequest.setOrderResult("Waiting");
            shipRequest.setRequestID(request.getRequestID());
            shipRequest.setEnterpriseType(request.getEnterpriseType());
            shipRequest.setEnterpriseName(request.getEnterpriseName());
            shipRequest.setLocation(request.getLocation());
            shipRequest.setProviderLocation(request.getProviderLocation());
            shipRequest.setProviderEnterpriseType(request.getProviderEnterpriseType());
            shipRequest.setProviderEnterpriseName(request.getProviderEnterpriseName());
            shipRequest.setProcessDate(strDate);
            shipRequest.setResolveDate(date);
            
            
            InvoiceRequest invRequest = new InvoiceRequest();
            invRequest.setVaccineName(request.getVaccineName());
            invRequest.setQuantity(request.getQuantity());
            invRequest.setSender(ua);
            invRequest.setStatus("sent");
            invRequest.setPaymentStatus("Waiting");
            invRequest.setRequestID(request.getRequestID());
            invRequest.setEnterpriseType(request.getEnterpriseType());
            invRequest.setEnterpriseName(request.getEnterpriseName());
            invRequest.setLocation(request.getLocation());
            invRequest.setProviderLocation(request.getProviderLocation());
            invRequest.setProviderEnterpriseType(request.getProviderEnterpriseType());
            invRequest.setProviderEnterpriseName(request.getProviderEnterpriseName());
            invRequest.setProcessDate(strDate);
            
            Manufacturer man = null;
            Person p = ua.getPerson();
            if(p instanceof Manufacturer){
                 man = (Manufacturer)p;
            }
            if(man!=null){
            for(Vaccine v : man.getVaccineCatalog().getVaccineCatalog()){
                if(v.getVaccineName().equals(request.getVaccineName())){
                    int newQuant = v.getQuantity() - request.getQuantity();
                    v.setQuantity(newQuant);
                    shipRequest.setExpiryDate(v.getExpiryDate());
                    shipRequest.setManufactureDate(v.getDateManufactured());
                    shipRequest.setManufacturer(v.getManufacturer());
                    shipRequest.setPrice(v.getPrice());
                    shipRequest.setLotNumber(v.getLotNumber());
                    //invRequest.setExpiryDate(v.getExpiryDate());
                    //shipRequest.setManufactureDate(v.getDateManufactured());
                    invRequest.setManufacturer(v.getManufacturer());
                    invRequest.setPrice(v.getPrice());
                    //shipRequest.setLotNumber(v.getLotNumber());
                }
                }
            }
            
            Organization org = null;
        for(Network n : ecoSystem.getNetworkList()){
            boolean flag = false;
            for(Enterprise e: n.getEnterpriseDirectory().getEnterpriseList()){
//                System.out.println("enterprise: " +e);
                if(request.getLocation().equals(e.getLocation())){
                    //System.out.println("hospitalEnterprise.getLocation(): " +hospitalEnterprise.getLocation());
                    System.out.println("e.getLocation(): " +e.getLocation());
                    System.out.println("beforeif enterpriseType: " +e.getEnterpriseType().getValue());
                    if(e.getEnterpriseType().getValue().equals("DistributorWarehouse")){
                        System.out.println("enterpriseType: " +e.getEnterpriseType().getValue());
                        for(Organization o : e.getOrganizationDirectory().getOrganizationList()){
                            System.out.println("organization: " +o.getName());
                            if(o instanceof DistributorWarehouseOrganization){
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
            if(org!=null){
                org.getWorkQueue().getWorkRequestList().add(shipRequest);
                org.getWorkQueue().getWorkRequestList().add(invRequest);
                ua.getWorkQueue().getWorkRequestList().add(shipRequest);
                System.out.println("order request added to DistributorWarehouse org");
        }
            
            JOptionPane.showMessageDialog(null, "Result submitted");
            return;
          }
        }
    
     
            

        if(status.equals("Do Not Ship")){
            request.setStatus("Completed");
            request.setOrderResult("Manufacturer not shipped yet");
//            request.setSender(ua);
//            ShippingRequest shippingRequest = new ShippingRequest(); 
//            shippingRequest.setOrderId(request.getOrderId());
//            shippingRequest.setMessage(request.getMessage());
//            shippingRequest.setSender(ua);
//            shippingRequest.setStatus("Completed");
            //shippingRequest.setShippingResult("Cancelled");
//            Organization org = null;
//            for(Network n : ecoSystem.getNetworkList()){
//            for(Enterprise e: n.getEnterpriseDirectory().getEnterpriseList()){
//                if(hospitalEnterprise.getLocation().equals(e.getLocation())){
//                    if(e.getEnterpriseType().getValue().equals("Provider")){
//                for(Organization o : e.getOrganizationDirectory().getOrganizationList()){
//                    if(o instanceof ProviderOrganization){
//                        //System.out.println("instance of provider org");
//                        org = o;
//                        break;
//                    }
//                }
//            }
//            if(org!=null){
//                org.getWorkQueue().getWorkRequestList().add(request);
//                ua.getWorkQueue().getWorkRequestList().add(request);
//                System.out.println("order request added to Provider org");
//        }
//            
            JOptionPane.showMessageDialog(null, "Result submitted");
            return;
        }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Result already submitted");
            return;
        }
        
    }//GEN-LAST:event_submitJButtonActionPerformed

    private void backJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButton1ActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButton1ActionPerformed

    private void resultjComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resultjComboBoxActionPerformed

    }//GEN-LAST:event_resultjComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JComboBox resultjComboBox;
    private com.toedter.calendar.JDateChooser resultjDateChooser;
    private javax.swing.JButton submitJButton;
    // End of variables declaration//GEN-END:variables
}
