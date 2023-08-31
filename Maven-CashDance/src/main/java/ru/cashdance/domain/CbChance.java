package ru.cashdance.domain;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class CbChance {
    private int categoryID;

    public CbChance() {

    }

    public int getCategoryID() {
        return categoryID;
    }

    public int getCardID() {
        return cardID;
    }

    public Double getRate() {
        return rate;
    }

    private int cardID;
    private String name;
    private BankCard bankCard;
    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    private LocalDate startDate;
    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    private LocalDate endDate;
    private String userComment;
    private CbCategory category;
    private Double rate;
    private int indexInDb;

    public int getIndexInDb() {
        return indexInDb;
    }

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BankCard getCard() {
        return bankCard;
    }

    public void setCard(BankCard bankCard) {
        this.bankCard = bankCard;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getUserComment() {
        return userComment;
    }

    public void setUserComment(String userComment) {
        this.userComment = userComment;
    }


    @Override
    public String toString() {
        return name + " - Категория "+ category.getName() +
                ", ставка " + rate*100 + " %" +
                ", действует с " + startDate +
                ", до " + endDate +
                " по карте " + bankCard.getName();
    }

    public void setBankCard(BankCard bankCard) {
        this.bankCard = bankCard;
    }

    public void setCategory(CbCategory category) {
        this.category = category;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public BankCard getBankCard() {
        return bankCard;
    }

    public CbCategory getCategory() {
        return category;
    }

    public CbChance(String name, BankCard bankCard, LocalDate startDate, LocalDate endDate, CbCategory category, Double rate) {
        this.name = name;
        this.bankCard = bankCard;
        this.startDate = startDate;
        this.endDate = endDate;
        this.category = category;
        this.rate = rate;
    }

    public CbChance(String name, int cardID, LocalDate startDate, LocalDate endDate, int categoryID, Double rate) {
        this.name = name;
        this.cardID = cardID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.categoryID = categoryID;
        this.rate = rate;
    }
}
