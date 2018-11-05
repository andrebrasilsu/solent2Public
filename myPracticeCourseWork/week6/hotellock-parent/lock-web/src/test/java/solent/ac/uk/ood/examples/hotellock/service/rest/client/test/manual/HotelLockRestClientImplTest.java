/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solent.ac.uk.ood.examples.hotellock.service.rest.client.test.manual;


import javax.ws.rs.core.MediaType;
import org.junit.Test;
import static org.junit.Assert.*;
import solent.ac.uk.ood.examples.hotellock.model.CardKey;
import solent.ac.uk.ood.examples.hotellock.service.rest.client.HotelLockRestClientImpl;

/**
 *
 * @author Andre
 */
public class HotelLockRestClientImplTest {
    String baseUrl = "http://localhost:8680";
    MediaType mediaType = MediaType.APPLICATION_XML_TYPE;
        
@Test
    public void testReadCard(){
        
        HotelLockRestClientImpl client = new HotelLockRestClientImpl(baseUrl, mediaType);

        String cardCode = "312C31363664353765306461302C31363664616134363961302C313A6261666561633634"; 
    
        CardKey readCard = client.readCard(cardCode);
        
        System.out.println("Reading card: " + readCard);
        
        assertEquals(true, readCard); 
        
    }
        
        
        

}


