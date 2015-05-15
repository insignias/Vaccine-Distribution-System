/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserInterface.ManufacturerRole;

import Business.EcoSystem;
import static Business.Enterprise.Enterprise.EnterpriseType.Manufacturer;
import Business.Organization.ManufacturerOrganization;
import Business.Person.Manufacturer;
import Business.Person.Person;
import static Business.Person.Person.PersonType.Manufacturer;
import Business.Person.Vaccine;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author relaince
 */
public class ManageVaccineCatalogJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem ecoSystem;
    private ManufacturerOrganization manOrg;
    private UserAccount ua;
    private Calendar calendar;
    private Date d;
    public ManageVaccineCatalogJPanel(JPanel upc, UserAccount ua, ManufacturerOrganization manOrg, EcoSystem ecoSystem) {
        initComponents();
        userProcessContainer = upc;
        this.ecoSystem = ecoSystem;
        this.manOrg = manOrg;
        this.ua = ua;
        calendar = Calendar.getInstance();
        d = calendar.getTime();
        populateVaccineTable();
        manufacturerjTextField.setText(ua.getPerson().getName());
    }

    private void populateVaccineTable(){
        DefaultTableModel dtm = (DefaultTableModel)vaccinejTable.getModel();
        dtm.setRowCount(0);
        
        for(Person person : manOrg.getPersonDirectory().getPersonList()){
            if(person instanceof Manufacturer){
                Manufacturer manufacturer = (Manufacturer)person;
            
            for(Vaccine vaccine : manufacturer.getVaccineCatalog().getVaccineCatalog()){
            
                Object[] row = new Object[5];
                row[0] = vaccine;
                row[1] = vaccine.getDateManufactured();
                row[2] = vaccine.getExpiryDate();
                row[3] = vaccine.getQuantity();
                row[4] = vaccine.getLotNumber();
                dtm.addRow(row);
                }
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        vaccineNamejTextField = new javax.swing.JTextField();
        vaccinePricejTextField = new javax.swing.JTextField();
        manufacturerjTextField = new javax.swing.JTextField();
        addjButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        quantityjTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        lotNumberjTextField = new javax.swing.JTextField();
        dateManufacturedjDateChooser = new com.toedter.calendar.JDateChooser();
        expiryDatejDateChooser = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        vaccinejTable = new javax.swing.JTable();
        backJButton1 = new javax.swing.JButton();
        refreshjButton = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("American Typewriter", 1, 18)); // NOI18N
        jLabel1.setText("MANUFACTURER MANAGE VACCINE CATALOG");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 12, -1, -1));

        jLabel2.setText("Vaccine Name:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 169, -1, -1));

        jLabel3.setText("Vaccine Price: ");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 215, -1, -1));

        jLabel4.setText("Date Manufactured:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 255, -1, -1));

        jLabel5.setText("Expiry Date:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 295, -1, -1));

        jLabel6.setText("Manufacturer:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 335, -1, -1));
        add(vaccineNamejTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 163, 88, -1));
        add(vaccinePricejTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 209, 88, -1));

        manufacturerjTextField.setEnabled(false);
        add(manufacturerjTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 329, 88, -1));

        addjButton.setText("Add");
        addjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addjButtonActionPerformed(evt);
            }
        });
        add(addjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 470, -1, -1));

        jLabel7.setText("Quantity:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 381, -1, -1));
        add(quantityjTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 375, 88, -1));

        jLabel8.setText("LOT Number:");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 427, -1, -1));
        add(lotNumberjTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 421, 88, -1));
        add(dateManufacturedjDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 243, -1, -1));
        add(expiryDatejDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 283, -1, -1));

        vaccinejTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Vaccine Name", "Manufacturing Date", "Expiry Date", "Quantity", "LOT Number"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(vaccinejTable);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 46, 560, 99));

        backJButton1.setText("<< Back");
        backJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButton1ActionPerformed(evt);
            }
        });
        add(backJButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 467, -1, -1));

        refreshjButton.setText("Refresh");
        refreshjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshjButtonActionPerformed(evt);
            }
        });
        add(refreshjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 470, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void addjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addjButtonActionPerformed
        String vaccineName;
        try
        {
        String regex = "[^&%$#@!()~`.,]*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(vaccineNamejTextField.getText());
        if (!matcher.matches()) 
        throw new Exception("Enter valid characters for Vaccine name");
        }
        catch (Exception e) {
        //System.err.println("Caught IOException: " + e.getMessage());
        JOptionPane.showMessageDialog(null,e.getMessage());
        return;
        }

        
        try
        {
        vaccineName = vaccineNamejTextField.getText();
        if ((vaccineNamejTextField.getText().startsWith(" ")) || (vaccineNamejTextField.getText().isEmpty()))
            throw new Exception(" Please enter valid characters");
        }        
        catch (Exception e) {
        //System.err.println("Caught IOException: " + e.getMessage());
        JOptionPane.showMessageDialog(null,e.getMessage());
        return;
        }
        Float vaccinePrice;
        try
        {
            vaccinePrice = Float.parseFloat(vaccinePricejTextField.getText());
        }
        catch (NumberFormatException e) {
        
        JOptionPane.showMessageDialog(null,"Please enter numeric value for price ");
        return;
        }
        try
        {
        if (vaccinePrice < 0)
            throw new Exception(" Price cannot be negative ");
        }
        catch (Exception e) {
        
        JOptionPane.showMessageDialog(null,e.getMessage() );
        return;
         }
        Date dateManufactured = dateManufacturedjDateChooser.getDate();
        String manufactureDate = null;
        if(dateManufactured!=null){
        manufactureDate = DateFormat.getDateInstance().format(dateManufactured);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please enter Manufacture date");
            return;
        }
        if(dateManufactured.after(d))
            {
                JOptionPane.showMessageDialog(null, "Date manufacturer cannot be more than current date");
                return;
            }
        
        Date expDate = expiryDatejDateChooser.getDate();
        String expiryDate = null;
        if(expDate!=null){
        expiryDate = DateFormat.getDateInstance().format(expDate);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please enter Expiry date");
            return;
        }
        if(expDate.before(d))
            {
                JOptionPane.showMessageDialog(null, "Please select a valid Expiry date");
                return;
            }
        if(expDate.before(dateManufactured))
            {
                JOptionPane.showMessageDialog(null, "Expiry date cannot be before Manufacture Date");
                return;
            }
        
        //String manufacturer = manufacturerjTextField.setText(ua.getPerson().getName());
        int quant;
        try
        {
            quant = Integer.parseInt(quantityjTextField.getText());
        }
        catch (NumberFormatException e) {
        
        JOptionPane.showMessageDialog(null,"Please enter numeric value for quantity ");
        return;
        }
        try
        {
        if (quant < 0)
            throw new Exception(" Quantity cannot be negative ");
        }
        catch (Exception e) {
        
        JOptionPane.showMessageDialog(null,e.getMessage() );
        return;
         }
        
        String lotNumber;
        try
        {
        String regex = "[^&%$#@!()~`.,]*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(lotNumberjTextField.getText());
        if (!matcher.matches()) 
        throw new Exception("Enter valid characters for LOT Number");
        }
        catch (Exception e) {
        //System.err.println("Caught IOException: " + e.getMessage());
        JOptionPane.showMessageDialog(null,e.getMessage());
        return;
        }

        
        try
        {
        lotNumber = lotNumberjTextField.getText();
        if ((lotNumberjTextField.getText().startsWith(" ")) || (lotNumberjTextField.getText().isEmpty()))
            throw new Exception(" Please enter valid characters");
        }        
        catch (Exception e) {
        //System.err.println("Caught IOException: " + e.getMessage());
        JOptionPane.showMessageDialog(null,e.getMessage());
        return;
        }
//        Person p = null;
            Manufacturer manufacturer = (Manufacturer)ua.getPerson();
                    Vaccine v = manufacturer.getVaccineCatalog().addVaccine();
                    v.setVaccineName(vaccineName);
                    v.setPrice(vaccinePrice);
                    v.setDateManufactured(manufactureDate);
                    v.setExpiryDate(expiryDate);
                    v.setManufacturer(ua.getPerson().getName());
                    v.setQuantity(quant);
                    v.setLotNumber(lotNumber);
                    JOptionPane.showMessageDialog(null,"Vaccine Added");
                    vaccineNamejTextField.setText("");
                    vaccinePricejTextField.setText("");
                    manufacturerjTextField.setText("");
                    quantityjTextField.setText("");
                    lotNumberjTextField.setText("");
//                    expiryDatejDateChooser.removeAll();
//                    dateManufacturedjDateChooser.removeAll();
                    populateVaccineTable();
                
//            }
        //}
        
    }//GEN-LAST:event_addjButtonActionPerformed

    private void backJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButton1ActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButton1ActionPerformed

    private void refreshjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshjButtonActionPerformed
        populateVaccineTable();
    }//GEN-LAST:event_refreshjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addjButton;
    private javax.swing.JButton backJButton1;
    private com.toedter.calendar.JDateChooser dateManufacturedjDateChooser;
    private com.toedter.calendar.JDateChooser expiryDatejDateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField lotNumberjTextField;
    private javax.swing.JTextField manufacturerjTextField;
    private javax.swing.JTextField quantityjTextField;
    private javax.swing.JButton refreshjButton;
    private javax.swing.JTextField vaccineNamejTextField;
    private javax.swing.JTextField vaccinePricejTextField;
    private javax.swing.JTable vaccinejTable;
    // End of variables declaration//GEN-END:variables
}
