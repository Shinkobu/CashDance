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
    private HashMap<CbCategory,Float> categoryMap = new HashMap<>();
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

    public HashMap<CbCategory, Float> getCategoryMap() {
        return categoryMap;
    }

    public void setCategoryMap(HashMap<CbCategory, Float> categoryMap) {
        this.categoryMap = categoryMap;
    }

    public String getUserComment() {
        return userComment;
    }

    public void setUserComment(String userComment) {
        this.userComment = userComment;
    }

//    public String toString() {
//        return "Вид "+ getClassName() + ", кличка " + name + ", дата рождения: " + dateFormat.format(startDate);
//    }




    public void addCategory(CbCategory c, Float f) {
        this.categoryMap.put(c, f);
    }
}
