/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.solent.com504.factoryandfacade.test;

import java.util.List;
import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.solent.com504.factoryandfacade.model.Animal;
import org.solent.com504.factoryandfacade.model.AnimalObjectFactory;
import org.solent.com504.factoryandfacade.model.Cat;
import org.solent.com504.factoryandfacade.model.Cow;
import org.solent.com504.factoryandfacade.model.Dog;
import org.solent.com504.factoryandfacade.model.FarmFacade;

/**
 *
 * @author gallenc
 */
 public class AnimalObjectFactoryTest {

    @Test
    public void testCreateCat() {
        Animal animal = AnimalObjectFactory.createCat();

        String sound = animal.getSound();

        System.out.println(sound);

        assertEquals("Meoww", sound);

    }

    @Test
    public void testCreateDog() {
        Animal animal = AnimalObjectFactory.createDog();

        String sound = animal.getSound();

        System.out.println(sound);

        assertEquals("Woof", sound);

    }

    @Test
    public void testCreateCow() {
        Animal animal = AnimalObjectFactory.createCow();

        String sound = animal.getSound();

        System.out.println(sound);

        assertEquals("Moo", sound);

    }
    
    @Test
    public void testCreateFarmFacade(){
        FarmFacade farmFacade = AnimalObjectFactory.createFarmFacade();
        assertNotNull(farmFacade);
        
        List<Animal> listOfAnimals = farmFacade.getAllAnimals();
       
        Cat c1 = new Cat();
        c1.setName("Meme");
        listOfAnimals.add(c1);
        
        Dog d1 = new Dog();
        d1.setName("Fido");
        listOfAnimals.add(d1);
        
        Cow co1 = new Cow();
        co1.setName("Mimosa"); 
        listOfAnimals.add(co1); 
        
        for (Animal a : listOfAnimals) {

            System.out.println("animal '" + a.getName()
                    + "' makes this sound '" + a.getSound()
                    + "' because it is a '" + a.getClass().getSimpleName()
                    + "' implemented by " + a.getClass().getTypeName());
        }
    
    }
    
    
}
