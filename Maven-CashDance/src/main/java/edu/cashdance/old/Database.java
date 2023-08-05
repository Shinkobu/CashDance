package edu.cashdance.old;

import edu.cashdance.domain.User;
import edu.cashdance.domain.Card;
import edu.cashdance.domain.CbCategory;
import edu.cashdance.domain.CbChance;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private static final List<Card> CARD_DATABASE = new ArrayList<>();
    private static final List<CbCategory> CATEGORY_DATABASE = new ArrayList<>();
    private static final List<User> USERS_DATABASE = new ArrayList<>();
    private static final List<CbChance> CB_CHANCES_DATABASE = new ArrayList<>();

    public static void addCbProposal(CbChance cbChance) {
        CB_CHANCES_DATABASE.add(cbChance);
    }
    public static void addCard(Card card) {CARD_DATABASE.add(card);}
    public static void addCategory(CbCategory category) {CATEGORY_DATABASE.add(category);}
    public static void replaceCard(int index, Card card) {
        CARD_DATABASE.set(index,card);
    }

    public static void replaceCategory(int index, CbCategory category) {
        CATEGORY_DATABASE.set(index,category);
    }

    public static void deleteCard(int index) {
        CARD_DATABASE.remove(index);
    }

    public static void deleteCategory(int index) {
        CATEGORY_DATABASE.remove(index);
    }
    public static void addUser(User user) {USERS_DATABASE.add(user);}

    public static void showCbChancesDB() {

        for (CbChance element : CB_CHANCES_DATABASE) {
            System.out.println(element.toString());
        }
    }
    public static void showCardDB() {

        for (Card element : CARD_DATABASE) {
            System.out.println(element.toString());
        }
    }

    public static void showCategoryDB() {

        for (CbCategory element : CATEGORY_DATABASE) {
            System.out.println(element.toString());
        }
    }


    public static List<CbChance> getCbChancesDatabase() {
        return CB_CHANCES_DATABASE;
    }
    public static List<Card> getCardDatabase() {
        return CARD_DATABASE;
    }
    public static List<CbCategory> getCategoryDatabase() {
        return CATEGORY_DATABASE;
    }
}
