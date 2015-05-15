/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author insignia
 */
public class ShippingRequest extends WorkRequest{
    
    private String shippingDate;
    private String manufacturer;
    private String expiryDate;
    private String manufactureDate;
    private float price;
    private String LotNumber;
    

    public String getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(String shippingDate) {
        this.shippingDate = shippingDate;
    } 

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(String manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getLotNumber() {
        return LotNumber;
    }

    public void setLotNumber(String LotNumber) {
        this.LotNumber = LotNumber;
    }
    
    
    
    @Override
    
    public String toString(){
        return getVaccineName();
    }
    
    
    
}
