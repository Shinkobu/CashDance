package Proposals;

import jdk.jfr.Category;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class CbProposal {
    private String name;
    private Card card;
    private Date startDate;
    private Date endDate;
    private HashMap<CbCategory,Double> categoryMap = new HashMap<>();
    private String userComment;
    private int indexInDb;
    public int getIndexInDb() {
        return indexInDb;
    }
    public void setIndexInDb(int indexInDb) {
        this.indexInDb = indexInDb;
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

    public HashMap<CbCategory, Double> getCategoryMap() {
        return categoryMap;
    }

    public void setCategoryMap(HashMap<CbCategory, Double> categoryMap) {
        this.categoryMap = categoryMap;
    }

    public String getUserComment() {
        return userComment;
    }

    public void setUserComment(String userComment) {
        this.userComment = userComment;
    }


    @Override
    public String toString() {
        return "Кешбек категории - " + card.getName()+": \n"+
                "Категории действуют с " + startDate +"\n"+
                "Категории действуют до " + endDate + "\n" +
                categoryMap.toString();

    }

    public CbProposal(String name, Card card, Date startDate, Date endDate, HashMap<CbCategory, Double> categoryMap, String userComment) {
        this.name = name;
        this.card = card;
        this.startDate = startDate;
        this.endDate = endDate;
        this.categoryMap = categoryMap;
        this.userComment = userComment;
    }

    public void addCategory(CbCategory c, Double f) {
        this.categoryMap.put(c, f);
    }
}
