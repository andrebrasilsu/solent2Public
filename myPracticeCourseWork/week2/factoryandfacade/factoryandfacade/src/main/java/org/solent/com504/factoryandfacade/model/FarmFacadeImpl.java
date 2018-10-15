/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.solent.com504.factoryandfacade.model;
import java.util.ArrayList;
import java.util.List;
import org.solent.com504.factoryandfacade.model.FarmFacade;

/**
 *
 * @author Andre
 */




public class FarmFacadeImpl implements FarmFacade {  
    
    List<Animal> listOfAnimals = new ArrayList<Animal>(); 
    
    public List<Animal> getAllAnimals(){
        return listOfAnimals; 
    };
    
    public void addDog(String name){
        
    };

    public void addCat(String name){
    
    };

    public void addCow(String name){
    
    };
}