package com.luxoft.bankapp.tests;

import com.luxoft.bankapp.domain.AbstractAccount;
import com.luxoft.bankapp.domain.AccountCache;
import com.luxoft.bankapp.domain.CheckingAccount;
import com.luxoft.bankapp.domain.SavingAccount;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AccountCacheTest {
    private AccountCache cache;

    @Before
    public void setUp() {
        cache = new AccountCache();
        cache.loadCache();
    }

    @Test
    public void testCloneCheckingAccount() {
        AbstractAccount account1 = cache.getClonedAccount("CHECKING");
        AbstractAccount account2 = cache.getClonedAccount("CHECKING");

        assertNotNull(account1);
        assertTrue(account1 instanceof CheckingAccount);
        assertNotSame(account1, account2); // should be different objects
        assertEquals(account1.getId(), account2.getId()); // but same id (0)
    }

    @Test
    public void testCloneSavingAccount() {
        AbstractAccount account1 = cache.getClonedAccount("SAVING");
        AbstractAccount account2 = cache.getClonedAccount("SAVING");

        assertNotNull(account1);
        assertTrue(account1 instanceof SavingAccount);
        assertNotSame(account1, account2);
        assertEquals(account1.getId(), account2.getId());
    }

    @Test
    public void testCloneInvalidAccount() {
        AbstractAccount account = cache.getClonedAccount("UNKNOWN");
        assertNull(account);
    }
}

