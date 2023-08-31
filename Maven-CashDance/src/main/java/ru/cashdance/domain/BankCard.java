package ru.cashdance.domain;

import java.util.Date;

public class BankCard {
    private String name;
    private String bankName;
//    private Date expireDate;
    private int indexInDb;

    public BankCard(String name) {
    }

    public BankCard() {

    }

    public int getIndexInDb() {
        return indexInDb;
    }

    public void setIndexInDb(int indexInDb) {
        this.indexInDb = indexInDb;
    }

    public BankCard(String name, String bankName) {
        this.name = name;
        this.bankName = bankName;
    }


    @Override
    public String toString() {
        return "BankCard{" +
                "name='" + name + '\'' +
                ", bankName='" + bankName + '\'' +
                ", indexInDb=" + indexInDb +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }



}
