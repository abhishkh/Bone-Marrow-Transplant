/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Network;

import Business.Enterprise.Enterprise_Directory;
/**
 *
 * @author abhishekmathukiya
 */
public class Network {
    private String name;
    private String state;
    private String country;
    
    
    
    private Enterprise_Directory Enterprise_Directory;
    
    public Network(){
        Enterprise_Directory=new Enterprise_Directory();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Enterprise_Directory getEnterprise_Directory() {
        return Enterprise_Directory;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    
    
    
    @Override
    public String toString(){
        return name;
    }    
}
