/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solent.ac.uk.ood.examples.cardvalidator.cardservice.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Test;

/**
 *
 * @author Andre
 */

public class SimpleDateTest {
    @Test
    public void simpleTEst(){
    
        DateFormat df = new SimpleDateFormat("MMYY");
        Date currentDate = new Date();
        long expiryDateMs = currentDate.getTime()+1000L * 60L * 60L * 24L * 365L;
        System.out.println(expiryDateMs);
        Date expiryDate = new Date(expiryDateMs);
        System.out.println(expiryDate);
        System.out.println(df.format(expiryDate));
        
        System.out.println(currentDate);
        
}
}
