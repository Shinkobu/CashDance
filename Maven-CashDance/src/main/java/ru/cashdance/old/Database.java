package ru.cashdance.old;

import ru.cashdance.domain.BankCard;
import ru.cashdance.domain.CbCategory;
import ru.cashdance.domain.CbChance;
import ru.cashdance.domain.CbUser;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private static final List<BankCard> BANK_CARD_DATABASE = new ArrayList<>();
    private static final List<CbCategory> CATEGORY_DATABASE = new ArrayList<>();
    private static final List<CbUser> USERS_DATABASE = new ArrayList<>();
    private static final List<CbChance> CB_CHANCES_DATABASE = new ArrayList<>();

    public static void addCbProposal(CbChance cbChance) {
        CB_CHANCES_DATABASE.add(cbChance);
    }
    public static void addCard(BankCard bankCard) {
        BANK_CARD_DATABASE.add(bankCard);}
    public static void addCategory(CbCategory category) {CATEGORY_DATABASE.add(category);}
    public static void replaceCard(int index, BankCard bankCard) {
        BANK_CARD_DATABASE.set(index, bankCard);
    }

    public static void replaceCategory(int index, CbCategory category) {
        CATEGORY_DATABASE.set(index,category);
    }

    public static void deleteCard(int index) {
        BANK_CARD_DATABASE.remove(index);
    }

    public static void deleteCategory(int index) {
        CATEGORY_DATABASE.remove(index);
    }
    public static void addUser(CbUser cbUser) {USERS_DATABASE.add(cbUser);}

    public static void showCbChancesDB() {

        for (CbChance element : CB_CHANCES_DATABASE) {
            System.out.println(element.toString());
        }
    }
    public static void showCardDB() {

        for (BankCard element : BANK_CARD_DATABASE) {
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
    public static List<BankCard> getCardDatabase() {
        return BANK_CARD_DATABASE;
    }
    public static List<CbCategory> getCategoryDatabase() {
        return CATEGORY_DATABASE;
    }
}
