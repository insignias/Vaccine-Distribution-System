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
import Business.Organization.HospitalOrganization;
import Business.Organization.Organization;
import Business.Organization.PharmaceuticalOrganization;
import Business.Organization.ProviderOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.InvoiceRequest;
import Business.WorkQueue.PaymentRequest;
import java.awt.CardLayout;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author insignia
 */
public class PharmaceuticalPaymentJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount ua;
    private PharmaceuticalOrganization pharOrg;
    private EcoSystem ecoSystem;
    private PharmaceuticalEnterprise pharEnt;
    private InvoiceRequest invRequest;
    private Calendar calendar;
    private Date d;
    public PharmaceuticalPaymentJPanel(JPanel userProcessContainer, InvoiceRequest invRequest, PharmaceuticalEnterprise pharEnt, UserAccount ua, PharmaceuticalOrganization pharOrg, EcoSystem ecoSystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.ua = ua;
        this.pharOrg = pharOrg;
        this.ecoSystem = ecoSystem;
        this.pharEnt = pharEnt;
        this.invRequest = invRequest;
        calendar = Calendar.getInstance();
        d = calendar.getTime();
        requestIDjTextField.setText(String.valueOf(invRequest.getRequestID()));
        paymentAmountjTextField.setText(String.valueOf(invRequest.getTotalPrice()));
        
        
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
        paymentAmountjTextField = new javax.swing.JTextField();
        makePaymentjButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        requestIDjTextField = new javax.swing.JTextField();
        backjButton = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("American Typewriter", 1, 18)); // NOI18N
        jLabel1.setText("PHARACEUTICAL PAYMENT WORK AREA");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel3.setText("Payment Amount:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 98, -1, -1));

        paymentAmountjTextField.setEnabled(false);
        add(paymentAmountjTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 92, 101, -1));

        makePaymentjButton.setText("Make Payment");
        makePaymentjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makePaymentjButtonActionPerformed(evt);
            }
        });
        add(makePaymentjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, -1, -1));

        jLabel4.setText("Request ID:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 52, -1, -1));

        requestIDjTextField.setEnabled(false);
        add(requestIDjTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 46, 98, -1));

        backjButton.setText("<< Back");
        backjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButtonActionPerformed(evt);
            }
        });
        add(backjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void makePaymentjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makePaymentjButtonActionPerformed
        if(!invRequest.getPaymentStatus().equals("Pharmaceutical Successful")){
        invRequest.setPaymentStatus("Pharmaceutical Successful");
        PaymentRequest pr = new PaymentRequest();
        pr.setVaccineName(invRequest.getVaccineName());
        pr.setQuantity(invRequest.getQuantity());
        pr.setTotalPrice(invRequest.getTotalPrice());
        pr.setSender(ua);
        String strDate = DateFormat.getDateInstance().format(d);
        pr.setProcessDate(strDate);
        pr.setRequestID(invRequest.getRequestID());
        pr.setPaymentStatus("Pharmaceutical Successful");
        
        Organization org = null;
        for(Network n : ecoSystem.getNetworkList()){
            boolean flag = false;
            for(Enterprise e: n.getEnterpriseDirectory().getEnterpriseList()){
                System.out.println("enterprise: " +e);
                if(pharEnt.getLocation().equals(e.getLocation())){
                    System.out.println("pharEnt.getLocation(): " +pharEnt.getLocation());
                    System.out.println("e.getLocation(): " +e.getLocation());
                    System.out.println("beforeif enterpriseType: " +e.getEnterpriseType().getValue());
                    if(e.getEnterpriseType().getValue().equals("Provider")){
                        System.out.println("enterpriseType: " +e.getEnterpriseType().getValue());
                        for(Organization o : e.getOrganizationDirectory().getOrganizationList()){
                            System.out.println("organization: " +o.getName());
                            if(o instanceof ProviderOrganization){
                            System.out.println("instance of provider org");
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
                org.getWorkQueue().getWorkRequestList().add(pr);
                ua.getWorkQueue().getWorkRequestList().add(pr);
                System.out.println("order request added to Provider org");
        }
            
            JOptionPane.showMessageDialog(null, "Payment Successful");
            return;
          }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Payment already done");
            return;
        }
        
    }//GEN-LAST:event_makePaymentjButtonActionPerformed

    private void backjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButtonActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backjButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton makePaymentjButton;
    private javax.swing.JTextField paymentAmountjTextField;
    private javax.swing.JTextField requestIDjTextField;
    // End of variables declaration//GEN-END:variables
}
