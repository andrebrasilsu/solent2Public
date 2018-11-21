/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solent.ac.uk.ood.examples.cardvalidator.cardservice;

import java.io.File;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import solent.ac.uk.ood.examples.cardvalidator.accountdao.jaxbimpl.AccountDAOJaxbImpl;
import solent.ac.uk.ood.examples.cardvalidator.model.Account;
import solent.ac.uk.ood.examples.cardvalidator.model.CreditCard;
import solent.ac.uk.ood.examples.cardvalidator.cardservice.BankApiImpl;
import solent.ac.uk.ood.examples.cardvalidator.impl.CardFactoryDAOImpl;
import solent.ac.uk.ood.examples.cardvalidator.impl.SupportedCardIssuerIdentificationNumbers;
import solent.ac.uk.ood.examples.cardvalidator.model.AccountDAO;
import solent.ac.uk.ood.examples.cardvalidator.model.BankApi;
import solent.ac.uk.ood.examples.cardvalidator.model.CardFactoryDAO;

/**
 *
 * @author Andre
 */
public class BankApiImplTest {
    
    public BankApiImplTest() {
    }

    private static final Logger LOG = LoggerFactory.getLogger(AccountDAOJaxbImplTest.class);

    public final String TEST_DATA_FILE_LOCATION = "target/testAccountDaoData.xml";

    @Test
    public void testCreateNewCreditCard() {
        // delete test file at start of test
        File file = new File(TEST_DATA_FILE_LOCATION);
        file.delete();
        assertFalse(file.exists());

        // create dao
        AccountDAO accountDAO = new AccountDAOJaxbImpl(TEST_DATA_FILE_LOCATION);
        CardFactoryDAO cfDao = new CardFactoryDAOImpl();

        assertTrue(file.exists());
        
        
        BankApi bankApi = new BankApiImpl(cfDao,accountDAO);
      
        // create new account1 provider 1
        String providerIIN1 = SupportedCardIssuerIdentificationNumbers.VISA_BANK_OF_IRELAND_UK;
        String name1 = "account1";
        Account account1 = bankApi.createAccount(providerIIN1, name1);   
        System.out.println(providerIIN1);
        assertNotNull(account1);
        LOG.debug("created account 1 : " + account1);

        // create new account2 provider 2
        String providerIIN2 = SupportedCardIssuerIdentificationNumbers.MASTERCARD_LLOYDS_BANK_PLC;
        String name2 = "account2";
        Account account2 = bankApi.createAccount(providerIIN2, name2);
        System.out.println(providerIIN2);                        
        assertNotNull(account2);
        LOG.debug("created account 2 : " + account2);
        
        CreditCard creditCard1 = bankApi.createNewCreditCard(account1);
        assertNotNull(creditCard1);
        System.out.println(creditCard1);
    }
    
}
