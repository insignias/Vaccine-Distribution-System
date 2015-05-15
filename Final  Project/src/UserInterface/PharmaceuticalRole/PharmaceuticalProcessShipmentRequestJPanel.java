/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.PharmaceuticalRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.HospitalEnterprise;
import Business.Enterprise.PharmaceuticalEnterprise;
import Business.Network.Network;
import Business.Organization.ClinicOrganization;
import Business.Organization.HospitalOrganization;
import Business.Organization.Organization;
import Business.Organization.PharmaceuticalOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.OrderRequest;
import Business.WorkQueue.ShippingRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author insignia
 */
public class PharmaceuticalProcessShipmentRequestJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount account;
    private PharmaceuticalEnterprise pharmaEnterprise;
    private PharmaceuticalOrganization pharmaOrganization;
    private ShippingRequest request;
    private EcoSystem ecoSystem;
    private Calendar calendar;
    private Date d;
    public PharmaceuticalProcessShipmentRequestJPanel(JPanel upc, UserAccount account, PharmaceuticalEnterprise pharmaEnterprise, PharmaceuticalOrganization pharmaOrganization, ShippingRequest request, EcoSystem ecoSystem) {
        initComponents();
        userProcessContainer = upc;
        this.account = account;
        this.pharmaEnterprise = pharmaEnterprise;
        this.pharmaOrganization = pharmaOrganization;
        this.request = request;
        this.ecoSystem = ecoSystem;
        calendar = Calendar.getInstance();
        d = calendar.getTime();
        
        resultjComboBox.removeAllItems();
        resultjComboBox.addItem("Ship");
        resultjComboBox.addItem("Do Not Ship");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        resultjComboBox = new javax.swing.JComboBox();
        shippingDatejDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        backJButton1 = new javax.swing.JButton();
        submitJButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("American Typewriter", 1, 18)); // NOI18N
        jLabel1.setText("PHARMACEUTICAL PROCESS SHIPMENT REQUEST");

        jLabel3.setText("Ship To:");

        resultjComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        resultjComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultjComboBoxActionPerformed(evt);
            }
        });

        jLabel6.setText("Result:");

        backJButton1.setText("<< Back");
        backJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButton1ActionPerformed(evt);
            }
        });

        submitJButton.setText("Submit");
        submitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButtonActionPerformed(evt);
            }
        });

        jLabel7.setText("Shipping date:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(72, 72, 72))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(backJButton1)
                                .addGap(25, 25, 25)))
                        .addComponent(submitJButton))
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(resultjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(shippingDatejDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(shippingDatejDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(resultjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backJButton1)
                    .addComponent(submitJButton))
                .addGap(0, 16, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void resultjComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resultjComboBoxActionPerformed

    }//GEN-LAST:event_resultjComboBoxActionPerformed

    private void backJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButton1ActionPerformed
            userProcessContainer.remove(this);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButton1ActionPerformed

    private void submitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJButtonActionPerformed
                
        if(!request.getOrderResult().equals("Received")){
        String status = (String)resultjComboBox.getSelectedItem();
        if(status.equals("Ship")){
            request.setStatus("Completed");
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        
//                Date date = shippingDatejDateChooser.getDate();
//                String strDate = DateFormat.getDateInstance().format(date);
//                 System.out.println("calendar: " +d);
//                 System.out.println("date: " +date);
//                 if(date.after(d)){
//                     request.setProcessDate(strDate);
//                     request.setOrderResult("Received");
//                     
//                     }
//                 if(date.equals(d)){
//                     request.setProcessDate(strDate);
//                     request.setOrderResult("Received");
//                     
//                     }
//                 if(date.before(d))
//                 {
//                         JOptionPane.showMessageDialog(null, "Please select a valid date");
//                         return;
//                     }
            
            ShippingRequest shipRequest = new ShippingRequest();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
                Date date = shippingDatejDateChooser.getDate();
                String strDate = DateFormat.getDateInstance().format(date);
                 System.out.println("calendar: " +d);
                 System.out.println("date: " +date);
                 if(!date.before(request.getResolveDate())){
                     request.setProcessDate(strDate);
                     request.setOrderResult("Received");
//                     JOptionPane.showMessageDialog(null, "Result submitted");
//                        return;
                     }
                 else
                     {
                         JOptionPane.showMessageDialog(null, "Shipping date cannot be before receiving date");
                         return;
                     }
                 if(date.equals(d)){
                     request.setProcessDate(strDate);
                     request.setOrderResult("Received");
//                     JOptionPane.showMessageDialog(null, "Result submitted");
//                        return;
                     }
                 if(date.before(d))
                 {
                         JOptionPane.showMessageDialog(null, "Please select a valid date");
                         return;
                     }
            shipRequest.setVaccineName(request.getVaccineName());
            shipRequest.setQuantity(request.getQuantity());
            shipRequest.setSender(account);
            shipRequest.setStatus("sent");
            shipRequest.setOrderResult("Waiting");
            shipRequest.setProcessDate(strDate);
            shipRequest.setRequestID(request.getRequestID());
            shipRequest.setEnterpriseType(request.getEnterpriseType());
            shipRequest.setEnterpriseName(request.getEnterpriseName());
            shipRequest.setLocation(request.getLocation());
            shipRequest.setManufactureDate(request.getManufactureDate());
            shipRequest.setExpiryDate(request.getExpiryDate());
            shipRequest.setManufacturer(request.getManufacturer());
            shipRequest.setLotNumber(request.getLotNumber());
            shipRequest.setPrice(request.getPrice());
            shipRequest.setResolveDate(date);
            OrderRequest or = null;
            for(WorkRequest wr : pharmaOrganization.getWorkQueue().getWorkRequestList()){
                if(wr instanceof OrderRequest){
                    or = (OrderRequest)wr;
                    System.out.println("or.getRequestID: " +or.getRequestID());
                    System.out.println("request.getRequestID: " +request.getRequestID());
                    if(or.getRequestID() == request.getRequestID()){
                    break; 
                        }
                    }
            }
           if(or!=null){
            Organization org = null;
            for(Network n : ecoSystem.getNetworkList()){
                boolean flag = false;
                for(Enterprise e: n.getEnterpriseDirectory().getEnterpriseList()){
                    if(or.getLocation().equals(e.getLocation())){
                        System.out.println("e.getLocation(): " +e.getLocation());
                        System.out.println("beforeif enterpriseType: " +e.getEnterpriseType().getValue());
                        if(e.getEnterpriseType().getValue().equals(or.getEnterpriseType())){
                            System.out.println("enterpriseType: " +e.getEnterpriseType().getValue());
                            System.out.println("e.getName(): " +e.getName());
                            System.out.println("or.getEnterpriseName(): " +or.getEnterpriseName());
                            if(e.getName().equals(or.getEnterpriseName())){
                            for(Organization o : e.getOrganizationDirectory().getOrganizationList()){
                                System.out.println("organization: " +o.getName());
                                //if(e.getEnterpriseType().getValue() == "Hospital"){
                                if(o instanceof ClinicOrganization){
                                    System.out.println("instance of Clinic Organization");
                                    org = o;
                                    flag = true;
                                    break;
                                }
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
                    account.getWorkQueue().getWorkRequestList().add(shipRequest);
                    System.out.println("order request added to org");
                }

                JOptionPane.showMessageDialog(null, "Result submitted");
                return;
            }
            }
           
        }

        if(status.equals("Do Not Ship")){
            request.setStatus("Completed");
            request.setOrderResult("Manufacturer not shipped yet");
//            request.setSender(account);
//                        ShippingRequest shippingRequest = new ShippingRequest();
//                        shippingRequest.setOrderId(request.getOrderId());
//                        shippingRequest.setMessage(request.getMessage());
//                        shippingRequest.setSender(ua);
//                        shippingRequest.setStatus("Completed");
//            shippingRequest.setShippingResult("Cancelled");
//                        Organization org = null;
//                        for(Network n : ecoSystem.getNetworkList()){
//                            for(Enterprise e: n.getEnterpriseDirectory().getEnterpriseList()){
//                                    if(hospitalEnterprise.getLocation().equals(e.getLocation())){
//                                            if(e.getEnterpriseType().getValue().equals("Provider")){
//                                            for(Organization o : e.getOrganizationDirectory().getOrganizationList()){
//                                                    if(o instanceof ProviderOrganization){
//                                                            //System.out.println("instance of provider org");
//                                                            org = o;
//                                                            break;
//                                                        }
//                                                }
//                                        }
//                                    if(org!=null){
//                                            org.getWorkQueue().getWorkRequestList().add(request);
//                                            ua.getWorkQueue().getWorkRequestList().add(request);
//                                            System.out.println("order request added to Provider org");
//                                    }
                        
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JComboBox resultjComboBox;
    private com.toedter.calendar.JDateChooser shippingDatejDateChooser;
    private javax.swing.JButton submitJButton;
    // End of variables declaration//GEN-END:variables
}