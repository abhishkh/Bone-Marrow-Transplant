/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organization;

import Business.HLA.HLACount;
import Business.HLA.PersonHLA;
import Business.Role.DoctorRole;
import Business.Role.Bone_Marrow_Bank_CoordinatorRole;
import Business.Role.Role;
import java.util.ArrayList;
import java.util.HashMap;
/**
 *
 * @author sohamshah
 */
public class Bone_Marrow_Bank_Organization extends Organization {
     HLACount inventory;
    
    public Bone_Marrow_Bank_Organization() {
        super(Organization.BoneMarrowBankType.BoneMarrowBank.getValue());
        inventory = new HLACount();
        PersonHLA h = new PersonHLA();
        h.updateHLAlist("HLA_A,HLA_B");
        inventory.HLACountAdd(h,6);
        h = new PersonHLA();
        h.updateHLAlist("HLA_A");
        inventory.HLACountAdd(h,5);
        h = new PersonHLA();
        h.updateHLAlist("HLA_A,HLA_B,HLA_C");
        inventory.HLACountAdd(h,7);
    }

    public HLACount getInventory() {
        return inventory;
    }
    
    public HashMap<String, Integer> getInventoryData() {
        return this.getInventory().getHlaComboCounts();
    }

    public void setInventory(HLACount inventory) {
        this.inventory = inventory;
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new Bone_Marrow_Bank_CoordinatorRole());
        return roles;
    }
    
}
