package com.luxoft.bankapp.tests;

import com.luxoft.bankapp.domain.AbstractAccount;
import com.luxoft.bankapp.domain.AccountFactory;
import com.luxoft.bankapp.domain.CheckingAccount;
import com.luxoft.bankapp.domain.SavingAccount;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountFactoryTest {

    @Test
    public void testCreateCheckingAccount() {
        int accountId = 1;
        AbstractAccount account = AccountFactory.newAccount(accountId, "CHECKING");
        assertNotNull(account);
        assertTrue(account instanceof CheckingAccount);
        assertEquals(accountId, account.getId());
        CheckingAccount checking = (CheckingAccount) account;
        assertEquals(0.0, checking.getBalance(), 0.001);
    }

    @Test
    public void testCreateSavingAccount() {
        int accountId = 2;
        AbstractAccount account = AccountFactory.newAccount(accountId, "SAVING");
        assertNotNull(account);
        assertTrue(account instanceof SavingAccount);
        assertEquals(accountId, account.getId());
        assertEquals(0.0, account.getBalance(), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateUnknownAccount() {
        AccountFactory.newAccount(3, "UNKNOWN");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateNullAccount() {
        AccountFactory.newAccount(4, null);
    }
}
