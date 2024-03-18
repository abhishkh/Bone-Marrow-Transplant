/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.People;

import java.util.ArrayList;
/**
 *
 * @author sohamshah
 */
public class PatientDirectory {
     private ArrayList<Patient> patientList;

    public ArrayList<Patient> getPatientList() {return patientList;}
    public void setPatientList(ArrayList<Patient> patientList) {this.patientList = patientList;}
    
    public PatientDirectory(){
        patientList = new ArrayList<Patient>();
        
    }

    public Patient addPatient(Patient patient)
    {
//        Patient patient = new Patient();
        patientList.add(patient);
        return patient;
        
    }
}
