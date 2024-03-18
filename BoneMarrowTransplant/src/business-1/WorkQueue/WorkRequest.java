/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.WorkQueue;

import Business.DB4OUtil.DB4OUtil;
import Business.Enterprise.Enterprise;
import Business.People.Donor;
import Business.People.Patient;
import Business.UserAccount.UserAccount;
import java.util.Date;
/**
 *
 * @author sohamshah
 */
public class WorkRequest {
     private String message;
    private UserAccount sender;
    private UserAccount receiver;
    private String status;
    private Date requestDate;
    private Date resolveDate;
    private Date actionDate;
    private String summary;
    private String notes;
    private String requestNumber;
    private String assigned;
    private UserAccount medTech;
    private UserAccount userAccount;
    private String overallStatus;
    private Donor donor;
    private Enterprise enterprise;
    private String type;
    private Patient patient;
    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();
    private int requestNumberInt;

    private static int count = 1;
    private static int ct;
    
    
    
    
    public Donor getDonor() {
        return donor;
    }

    public void setDonor(Donor donor) {
        this.donor = donor;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }
    
    public UserAccount getMedTech() {
        return medTech;
    }

    public void setMedTech(UserAccount medTech) {
        this.medTech = medTech;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public String getOverallStatus() {
        return overallStatus;
    }

    public void setOverallStatus(String overallStatus) {
        this.overallStatus = overallStatus;
    }
    
    public WorkRequest(){
        
//        System.out.println(dB4OUtil.retrieveSystem().getWorkQueue().getWorkRequestList().size()+"count");
//        requestNumber = "REQ00000"+ String.valueOf(count);
        count++;
        this.requestNumberInt = count;
        
        requestDate = new Date();
    }
    
//    public WorkRequest(UserAccount sender, UserAccount receiver) {
//        count++;
//        this.sender = sender;
//        this.receiver = receiver;
//        this.requestDate = new Date();
//    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    public void setReceiver(UserAccount receiver) {
        this.receiver = receiver;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }

    public Date getActionDate() {
        return actionDate;
    }

    public void setActionDate(Date actionDate) {
        this.actionDate = actionDate;
    }

    public String getRequestNumber() {
        if(requestNumber == null) 
            this.setRequestNumber(Integer.toString(requestNumberInt));
        else if(requestNumber.equals("Req number Not set yet"))
            this.setRequestNumber(Integer.toString(requestNumberInt));
        return requestNumber;
    }

    public void setRequestNumber(String requestNumber) {
        this.requestNumber = requestNumber;
    }

    public String getAssigned() {
        return assigned;
    }

    public void setAssigned(String assigned) {
        this.assigned = assigned;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        WorkRequest.count = count;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    
    
     @Override
    public String toString() {
        return getRequestNumber().toString() ;
    }
}
