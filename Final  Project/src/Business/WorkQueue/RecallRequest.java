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
public class RecallRequest extends WorkRequest{
    
    private String lotNumber;
    private String recallResult;

    public String getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
    }

    public String getRecallResult() {
        return recallResult;
    }

    public void setRecallResult(String recallResult) {
        this.recallResult = recallResult;
    }

    @Override
    
    public String toString(){
        return getVaccineName();
    }
    
    
    
}
