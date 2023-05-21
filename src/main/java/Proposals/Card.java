package Proposals;

import java.util.Date;

public class Card {
    private String name;
    private String bankName;
    private Date expireDate;
    private int indexInDb;

    public int getIndexInDb() {
        return indexInDb;
    }

    public void setIndexInDb(int indexInDb) {
        this.indexInDb = indexInDb;
    }

    public Card(String name, String bankName) {
        this.name = name;
        this.bankName = bankName;
    }

    @Override
    public String toString() {
        return "Card{" +
                "name='" + name + '\'' +
                ", bankName='" + bankName + '\'' +
                ", expireDate=" + expireDate +
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
