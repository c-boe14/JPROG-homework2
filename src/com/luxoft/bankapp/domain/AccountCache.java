package com.luxoft.bankapp.domain;

import java.util.HashMap;
import java.util.Map;

public class AccountCache {
    private Map<String, AbstractAccount> accountMap = new HashMap<>();

    public void loadCache() {
        accountMap.put("CHECKING", new CheckingAccount(0, 0.0, 0.0));
        accountMap.put("SAVING", new SavingAccount(0, 0.0));
    }

    public AbstractAccount getClonedAccount(String type) {
        AbstractAccount cachedAccount = accountMap.get(type.toUpperCase());
        return cachedAccount != null ? cachedAccount.clone() : null;
    }
}

