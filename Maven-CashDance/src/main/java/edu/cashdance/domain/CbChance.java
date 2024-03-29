package edu.cashdance.domain;

import edu.cashdance.App;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CbChance {
    private int categoryID;

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
    private Card card;
    private Date startDate;
    private Date endDate;
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

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
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
                ", действует с " + App.newDateFormat.format(startDate) +
                ", до " + App.newDateFormat.format(endDate) +
                " по карте " + card.getName();
    }

    public CbChance(String name, Card card, Date startDate, Date endDate, CbCategory category, Double rate) {
        this.name = name;
        this.card = card;
        this.startDate = startDate;
        this.endDate = endDate;
        this.category = category;
        this.rate = rate;
    }

    public CbChance(String name, int cardID, Date startDate, Date endDate, int categoryID, Double rate) {
        this.name = name;
        this.cardID = cardID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.categoryID = categoryID;
        this.rate = rate;
    }
}
