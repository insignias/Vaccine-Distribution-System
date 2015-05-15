/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Person;

import java.util.Date;

/**
 *
 * @author relaince
 */
public class Vaccine {
    
    private static int count = 0;
    private String vaccineName;
    private String vaccineType;
    private String dateManufactured;
    private String expiryDate;
    private String manufacturer;
    private int quantity;
    private String lotNumber;
    private int avail;
    private int fAvail;
    private int lAvail;
    private String prodName;
    private float price;
    private int modelNumber;
    private int prodQuantSold;
    private int prodAmountGenerated;

    public Vaccine() {
        count++;
        modelNumber = count;
    }
    public int getAvail() {
        return avail;
    }

    public void setAvail(int avail) {
        this.avail = avail;
    }

    public int getfAvail() {
        return fAvail;
    }

    public void setfAvail(int fAvail) {
        this.fAvail = fAvail;
    }

    public int getlAvail() {
        return lAvail;
    }

    public void setlAvail(int lAvail) {
        this.lAvail = lAvail;
    }
    
    
    
    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    

    public int getModelNumber() {
        return modelNumber;
    }

    public int getProdQuantSold() {
        return prodQuantSold;
    }

    public void setProdQuantSold(int prodQuantSold) {
        this.prodQuantSold = prodQuantSold;
    }

    public int getProdAmountGenerated() {
        return prodAmountGenerated;
    }

    public void setProdAmountGenerated(int prodAmountGenerated) {
        this.prodAmountGenerated = prodAmountGenerated;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public String getVaccineType() {
        return vaccineType;
    }

    public void setVaccineType(String vaccineType) {
        this.vaccineType = vaccineType;
    }

    public String getDateManufactured() {
        return dateManufactured;
    }

    public void setDateManufactured(String dateManufactured) {
        this.dateManufactured = dateManufactured;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
    }
    
    
    
     @Override
    public String toString() {
        return vaccineName;
    }
}
