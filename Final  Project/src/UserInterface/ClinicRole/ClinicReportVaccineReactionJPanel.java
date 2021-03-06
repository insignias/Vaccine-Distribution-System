/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ClinicRole;

import Business.EcoSystem;
import Business.Enterprise.ClinicEnterprise;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.CDCOrganization;
import Business.Organization.ClinicOrganization;
import Business.Organization.Organization;
import Business.Person.Clinician;
import Business.Person.Person;
import Business.Person.Vaccine;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.ReactionRequest;
import java.awt.CardLayout;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author insignia
 */
public class ClinicReportVaccineReactionJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem ecoSystem;
    private ClinicOrganization clinicOrg;
    private UserAccount account; 
    private ClinicEnterprise clinicEnterprise;
    private Calendar calendar;
    private Date d;
    public ClinicReportVaccineReactionJPanel(JPanel upc,UserAccount account, ClinicEnterprise clinicEnterprise, ClinicOrganization clinicOrg,EcoSystem ecoSystem) {
        initComponents();
        userProcessContainer = upc;
        this.account = account;
        this.clinicEnterprise = clinicEnterprise;
        this.clinicOrg = clinicOrg;
        this.ecoSystem = ecoSystem;
        
        calendar = Calendar.getInstance();
        d = calendar.getTime();
        
        vaccineNamejComboBox.removeAllItems();
        lotNumberjComboBox.removeAllItems();
        manufacturerjComboBox.removeAllItems();
//         for(Network n : ecoSystem.getNetworkList()){
//            for(Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()){
//                //if(e.getLocation().equals(phEnterprise.getLocation())){
//                    for(Organization o : e.getOrganizationDirectory().getOrganizationList()){
                        for(Person p : clinicOrg.getPersonDirectory().getPersonList()){
                            if(p instanceof Clinician){
                        Clinician clinician = (Clinician)p;
                        for(Vaccine v : clinician.getVaccineCatalog().getVaccineCatalog()){
                  vaccineNamejComboBox.addItem(v.getVaccineName());
                  lotNumberjComboBox.addItem(v.getLotNumber());
                  manufacturerjComboBox.addItem(v.getManufacturer());
//                        }
//                            }
//                        }
              }
          }  
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        patientNamejTextField = new javax.swing.JTextField();
        patientAddressjTextField = new javax.swing.JTextField();
        patientContactjTextField = new javax.swing.JTextField();
        dosesjTextField = new javax.swing.JTextField();
        submitjButton = new javax.swing.JButton();
        vaccinationDatejDateChooser = new com.toedter.calendar.JDateChooser();
        reactionDatejDateChooser = new com.toedter.calendar.JDateChooser();
        backButton = new javax.swing.JButton();
        vaccineNamejComboBox = new javax.swing.JComboBox();
        lotNumberjComboBox = new javax.swing.JComboBox();
        manufacturerjComboBox = new javax.swing.JComboBox();
        reactionDetailsjTextField = new javax.swing.JTextField();

        jLabel5.setText("jLabel5");

        jLabel1.setFont(new java.awt.Font("American Typewriter", 1, 18)); // NOI18N
        jLabel1.setText("CLINIC REPORT VACCINE REACTION");

        jLabel2.setText("Patient Name:");

        jLabel3.setText("Patient Address:");

        jLabel4.setText("Patient Contact:");

        jLabel6.setText("Vaccine Name:");

        jLabel7.setText("No. Of Doses:");

        jLabel8.setText("LOT Number:");

        jLabel9.setText("Manufacturer:");

        jLabel10.setText("Vaccination Date:");

        jLabel11.setText("Reaction Date:");

        jLabel12.setText("Reaction Details:");

        submitjButton.setText("Submit");
        submitjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitjButtonActionPerformed(evt);
            }
        });

        backButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        backButton.setText("<< Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        vaccineNamejComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        vaccineNamejComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vaccineNamejComboBoxActionPerformed(evt);
            }
        });

        lotNumberjComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        lotNumberjComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lotNumberjComboBoxActionPerformed(evt);
            }
        });

        manufacturerjComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        manufacturerjComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manufacturerjComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(34, 34, 34)
                        .addComponent(dosesjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel11)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(vaccineNamejComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(patientContactjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addGap(12, 12, 12)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(vaccinationDatejDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(reactionDatejDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addGap(33, 33, 33)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lotNumberjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(manufacturerjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(submitjButton)
                            .addComponent(reactionDetailsjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(32, 32, 32)
                            .addComponent(patientNamejTextField))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addComponent(patientAddressjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(77, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backButton)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(patientNamejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(patientAddressjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(patientContactjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(vaccineNamejComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addGap(60, 60, 60))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(dosesjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(lotNumberjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(manufacturerjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(vaccinationDatejDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(reactionDatejDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(reactionDetailsjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(submitjButton))
                .addContainerGap(13, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backButtonActionPerformed

    private void submitjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitjButtonActionPerformed
        String patientName;
        try
        {
        String regex = "[^&%$#@!0-9()~`.,]*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(patientNamejTextField.getText());
        if (!matcher.matches()) 
        throw new Exception("Enter valid characters for Patient name");
        }
        catch (Exception e) {
        //System.err.println("Caught IOException: " + e.getMessage());
        JOptionPane.showMessageDialog(null,e.getMessage());
        return;
        }

        
        try
        {
        patientName = patientNamejTextField.getText();
        if ((patientNamejTextField.getText().startsWith(" ")) || (patientNamejTextField.getText().isEmpty()))
            throw new Exception(" Please enter valid characters for Patient Name ");
        }        
        catch (Exception e) {
        //System.err.println("Caught IOException: " + e.getMessage());
        JOptionPane.showMessageDialog(null,e.getMessage());
        return;
        }
        
        String patientAddress;
        try
        {
        patientAddress = patientAddressjTextField.getText();
        if ((patientAddressjTextField.getText().startsWith(" ")) || (patientAddressjTextField.getText().isEmpty()))
            throw new Exception(" Please enter valid characters for Patient Address ");
        }        
        catch (Exception e) {
        //System.err.println("Caught IOException: " + e.getMessage());
        JOptionPane.showMessageDialog(null,e.getMessage());
        return;
        }
        
        
        
        String patientContact;
        try
        {
        if(!(patientContactjTextField.getText().length() == 10 ))
        throw new Exception(" Please enter 10 digits number for contact ");
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage() );
        return;
        }
        
//        try
//        {
            patientContact = (patientContactjTextField.getText());
            try
        {
        String regex = "[0-9]*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(patientContactjTextField.getText());
        if (!matcher.matches()) 
        throw new Exception("Enter valid phone");
        }
        catch (Exception e) {
        //System.err.println("Caught IOException: " + e.getMessage());
        JOptionPane.showMessageDialog(null,e.getMessage());
        return;
        }
//        }
//        catch (NumberFormatException e) {
//        
//        JOptionPane.showMessageDialog(null,"Please enter numeric value for Contact ");
//        return;
//        }
//        try
//        {
//        if (patientContact < 0)
//            throw new Exception(" Please enter digits only ");
//        }
//        catch (Exception e) {
//        
//        JOptionPane.showMessageDialog(null,e.getMessage() );
//        return;
//         }
        
        try
        {
        if(!(patientContactjTextField.getText().length() == 10 ))
        throw new Exception(" Please enter 10 digits number for contact ");
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage() );
        return;
        }
        
        String vaccineName = (String)vaccineNamejComboBox.getSelectedItem();
        
        String lotNumber = (String)lotNumberjComboBox.getSelectedItem();
        
        String manufacturer = (String)manufacturerjComboBox.getSelectedItem();
        
        int doses;
        try
        {
            doses = Integer.parseInt(dosesjTextField.getText());
        }
        catch (NumberFormatException e) {
        
        JOptionPane.showMessageDialog(null,"Please enter numeric value for doses ");
        return;
        }
        try
        {
        if (doses < 0)
            throw new Exception(" Please enter digits only ");
        }
        catch (Exception e) {
        
        JOptionPane.showMessageDialog(null,e.getMessage() );
        return;
         }
        
        Date vaccinationDate = vaccinationDatejDateChooser.getDate();
        String vDate = DateFormat.getDateInstance().format(vaccinationDate);
//        if(vaccinationDate.before(d))
//            {
//                JOptionPane.showMessageDialog(null, "Please select a valid date");
//                return;
//            }
        
        Date reactionDate = reactionDatejDateChooser.getDate();
        String rDate = DateFormat.getDateInstance().format(reactionDate);
        if(reactionDate.before(vaccinationDate))
            {
                JOptionPane.showMessageDialog(null, "Reaction date cannot be before vaccination Date");
                return;
            }
        
        String reactionDetails;
//        try
//        {
        reactionDetails = reactionDetailsjTextField.getText();
//        if ((reactionDetailsjTextField.getText().startsWith(" ")) || (reactionDetailsjTextField.getText().isEmpty()))
//            throw new Exception(" Please enter valid characters for Patient Address ");
//        }        
//        catch (Exception e) {
//        //System.err.println("Caught IOException: " + e.getMessage());
//        JOptionPane.showMessageDialog(null,e.getMessage());
//        return;
//        }
        
        ReactionRequest rr = new ReactionRequest();
        rr.setPatientName(patientName);
        rr.setPatientAddress(patientAddress);
        rr.setPatientContact(String.valueOf(patientContact));
        rr.setVaccineName(vaccineName);
        rr.setDoses(doses);
        rr.setLotNumber(lotNumber);
        rr.setManufacturer(manufacturer);
        rr.setVaccinationDate(vDate);
        rr.setReactionDate(rDate);
        rr.setReactionDetails(reactionDetails);
        rr.setSender(account);
        rr.setStatus("Sent");
        rr.setLocation(clinicEnterprise.getLocation());
        rr.setEnterpriseType(clinicEnterprise.getEnterpriseType().getValue());
        rr.setEnterpriseName(clinicEnterprise.getName());
        rr.setOrderResult("Sent");
        
        Organization org = null;
        for(Network n : ecoSystem.getNetworkList()){
            boolean flag = false;
            for(Enterprise e: n.getEnterpriseDirectory().getEnterpriseList()){
                if(e.getEnterpriseType().getValue().equals("CDC")){
                        System.out.println("enterpriseType: " +e.getEnterpriseType().getValue());
                        for(Organization o : e.getOrganizationDirectory().getOrganizationList()){
                            System.out.println("organization: " +o.getName());
                            if(o instanceof CDCOrganization){
                            System.out.println("instance of CDC Organization");
                            org = o;
                            flag = true;
                            break;
                            }
                        }
                    }
                
                
                if(flag==true)
                {
                    break;
                }
        }
            if(org!=null){
                org.getWorkQueue().getWorkRequestList().add(rr);
                account.getWorkQueue().getWorkRequestList().add(rr);
                System.out.println("order request added to org");
        }
            
            JOptionPane.showMessageDialog(null, "Submitted");
            patientNamejTextField.setText("");
            patientAddressjTextField.setText("");
            patientContactjTextField.setText("");
            dosesjTextField.setText("");
            reactionDetailsjTextField.setText("");
            return;
        } 
        
    }//GEN-LAST:event_submitjButtonActionPerformed

    private void vaccineNamejComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vaccineNamejComboBoxActionPerformed
//        String vaccineName = (String)vaccineNamejComboBox.getSelectedItem();
//        if(vaccineName!=null){
//            boolean flag = false;
//            for(Person p : clinicOrg.getPersonDirectory().getPersonList()){
//                if(p instanceof Clinician){
//                    Clinician clinician = (Clinician)p;
//                    for(Vaccine v : clinician.getVaccineCatalog().getVaccineCatalog()){
//                        if(v.getVaccineName().equals(vaccineName)){
//                            quantityAvailablejTextField.setText(String.valueOf(v.getQuantity()));
//                            flag = true;
//                        }
//                        if(flag==true){
//                            break;
//                        }
//                    }
//                }
//            }
//        }
    }//GEN-LAST:event_vaccineNamejComboBoxActionPerformed

    private void lotNumberjComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lotNumberjComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lotNumberjComboBoxActionPerformed

    private void manufacturerjComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manufacturerjComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_manufacturerjComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JTextField dosesjTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JComboBox lotNumberjComboBox;
    private javax.swing.JComboBox manufacturerjComboBox;
    private javax.swing.JTextField patientAddressjTextField;
    private javax.swing.JTextField patientContactjTextField;
    private javax.swing.JTextField patientNamejTextField;
    private com.toedter.calendar.JDateChooser reactionDatejDateChooser;
    private javax.swing.JTextField reactionDetailsjTextField;
    private javax.swing.JButton submitjButton;
    private com.toedter.calendar.JDateChooser vaccinationDatejDateChooser;
    private javax.swing.JComboBox vaccineNamejComboBox;
    // End of variables declaration//GEN-END:variables
}
