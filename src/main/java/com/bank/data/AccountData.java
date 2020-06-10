package com.bank.data;

import java.math.BigDecimal;

public class AccountData {
    private String firstName;
    private String secondName;
    private String sex;
    private BigDecimal balance;
    private BigDecimal withdrawLimit;

    public AccountData(String firstName, String secondName, String sex) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.sex = sex;
        this.balance = new BigDecimal("0");
        this.withdrawLimit = new BigDecimal("1000");
    }

    //<editor-fold desc="Getters and Setters">

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(BigDecimal withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }
    //</editor-fold>
}
