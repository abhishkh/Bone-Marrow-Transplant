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
public class DonorDirectory {
       private ArrayList<Donor> donorList;

    public ArrayList<Donor> getDonorList() {return donorList;}
    public void setDonorList(ArrayList<Donor> donorList) {this.donorList = donorList;}
    
    public DonorDirectory(){
        donorList = new ArrayList<Donor>();
    }
    
    public Donor addDonor(Donor donor)
    {
//        Donor donor = new Donor();
        donorList.add(donor);
        return donor;
    }
    
}
