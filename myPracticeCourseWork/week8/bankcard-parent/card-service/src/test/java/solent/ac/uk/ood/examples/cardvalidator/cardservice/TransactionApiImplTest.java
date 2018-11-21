/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solent.ac.uk.ood.examples.cardvalidator.cardservice;

import java.io.File;
import org.junit.Test;
import static org.junit.Assert.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import solent.ac.uk.ood.examples.cardvalidator.accountdao.jaxbimpl.AccountDAOJaxbImpl;
import solent.ac.uk.ood.examples.cardvalidator.impl.CardFactoryDAOImpl;
import solent.ac.uk.ood.examples.cardvalidator.impl.SupportedCardIssuerIdentificationNumbers;
import solent.ac.uk.ood.examples.cardvalidator.model.Account;
import solent.ac.uk.ood.examples.cardvalidator.model.AccountDAO;
import solent.ac.uk.ood.examples.cardvalidator.model.BankApi;
import solent.ac.uk.ood.examples.cardvalidator.model.CardFactoryDAO;
import solent.ac.uk.ood.examples.cardvalidator.model.Transaction;
import solent.ac.uk.ood.examples.cardvalidator.model.TransactionApi;
import solent.ac.uk.ood.examples.cardvalidator.model.TransactionResult;

/**
 *
 * @author Andre
 */
public class TransactionApiImplTest {
    
    public TransactionApiImplTest() {
    }

    /**
     * Test of requestTransaction method, of class TransactionApiImpl.
     */
    
    private static final Logger LOG = LoggerFactory.getLogger(AccountDAOJaxbImplTest.class);

    public final String TEST_DATA_FILE_LOCATION = "target/testAccountDaoData.xml";
    
    
    @Test
    public void testRequestTransaction() {
          // delete test file at start of test
        File file = new File(TEST_DATA_FILE_LOCATION);
        file.delete();
        assertFalse(file.exists());

        // create dao
        AccountDAO accountDAO = new AccountDAOJaxbImpl(TEST_DATA_FILE_LOCATION);
        CardFactoryDAO cfDao = new CardFactoryDAOImpl();

        assertTrue(file.exists());
        
        
        TransactionApi transactionApi = new TransactionApiImpl(cfDao,accountDAO);
        
        BankApi bankApi = new BankApiImpl(cfDao, accountDAO); 
        
        // create new account1 provider 1
        String providerIIN1 = SupportedCardIssuerIdentificationNumbers.VISA_BANK_OF_IRELAND_UK;
        String name1 = "account1";
        Account account1 = bankApi.createAccount(providerIIN1, name1);   
        account1.setBalance(500.00);
        assertNotNull(account1);
        LOG.debug("created account 1 : " + account1);

        // create new account2 provider 2
        String providerIIN2 = SupportedCardIssuerIdentificationNumbers.MASTERCARD_LLOYDS_BANK_PLC;
        String name2 = "account2";
        Account account2 = bankApi.createAccount(providerIIN2, name2);
        account2.setBalance(500.00);
        assertNotNull(account2);
        LOG.debug("created account 2 : " + account2);
        
        
        
    }
    
}
