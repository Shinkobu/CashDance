package Proposals;

import java.util.Date;

public class Card {
    private String name;
    private String bankName;
    private CreditStatus creditStatus;
    private PlasticStatus plasticStatus;
    private Date expireDate;

    public Card(String name, String bankName, CreditStatus creditStatus, PlasticStatus plasticStatus) {
        this.name = name;
        this.bankName = bankName;
        this.creditStatus = creditStatus;
        this.plasticStatus = plasticStatus;
    }

    @Override
    public String toString() {
        return "Card{" +
                "name='" + name + '\'' +
                ", bankName='" + bankName + '\'' +
                ", creditStatus=" + creditStatus +
                ", plasticStatus=" + plasticStatus +
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

    public CreditStatus getCreditStatus() {
        return creditStatus;
    }

    public void setCreditStatus(CreditStatus creditStatus) {
        this.creditStatus = creditStatus;
    }

    public PlasticStatus getPlasticStatus() {
        return plasticStatus;
    }

    public void setPlasticStatus(PlasticStatus plasticStatus) {
        this.plasticStatus = plasticStatus;
    }
}
