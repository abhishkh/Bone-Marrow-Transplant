/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Enterprise;

import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author abhishekmathukiya
 */
public class HRSA_Enterprise extends Enterprise {
    
     public HRSA_Enterprise(String name){
        super(name,EnterpriseType.HRSA);
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
}
