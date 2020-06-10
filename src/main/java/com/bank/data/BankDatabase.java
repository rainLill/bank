package com.bank.data;

import org.springframework.boot.autoconfigure.security.oauth2.resource.IssuerUriCondition;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class BankDatabase {
    private static Map<String, AccountData> ad = new HashMap<>();

    public String addAccount(String iban, AccountData accountData) {
        ad.put(iban, accountData);

        AccountData adRecord = ad.get(iban);

        return "Account created for " + adRecord.getFirstName() + " " + adRecord.getSecondName() +
                ". Iban is " + iban;
    }

    public String deposit(String iban, BigDecimal sum) {
        BigDecimal startSum = ad.get(iban).getBalance();
        BigDecimal endSum = startSum.add(sum);
        ad.get(iban).setBalance(endSum);

        return "" + startSum.toString() + " --> " + ad.get(iban).getBalance().toString();
    }

    public String withdraw(String iban, BigDecimal sum) {
        BigDecimal startSum = ad.get(iban).getBalance();
        int sufficientFunds = startSum.compareTo(sum);

        BigDecimal endSum;
        String output = "insufficient funds";

        if (sufficientFunds > -1) {
            endSum = startSum.subtract(sum);
            ad.get(iban).setBalance(endSum);
            output = endSum.toString();
        }
        return output;
    }


    public String balance(String iban) {
        return ad.get(iban).getBalance().toString();
    }

    public String transfer(String acc1, String acc2, BigDecimal sum) {
        BigDecimal withdrawAccountBalance = ad.get(acc1).getBalance();
        int sufficientFunds = withdrawAccountBalance.compareTo(sum);

        String output = "There is a issue";

        if (sufficientFunds > -1) {
            ad.get(acc1).setBalance(withdrawAccountBalance.subtract(sum));
            BigDecimal depositAccountBalance = ad.get(acc2).getBalance();
            ad.get(acc2).setBalance(depositAccountBalance.add(sum));
            output = "Done";
        }

        return output;
    }
}
