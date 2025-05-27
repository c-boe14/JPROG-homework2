package com.luxoft.bankapp.domain;

public class AccountFactory {
    public static AbstractAccount newAccount(int accountId, String accountType){
        if (accountType == null) {
            throw new IllegalArgumentException("Account type and ID cannot be null");
        }

        return switch (accountType.toUpperCase()) {
            case "CHECKING" -> new CheckingAccount(accountId, 0.0, 100.0);
            case "SAVING" -> new SavingAccount(accountId, 0.0);
            default -> throw new IllegalArgumentException("Unknown account type: " + accountType);
        };


    }

}
