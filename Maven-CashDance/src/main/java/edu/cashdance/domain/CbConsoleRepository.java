package edu.cashdance.domain;

import edu.cashdance.CashDanceApp;
import edu.cashdance.old.Database;

import java.util.Iterator;
import java.util.List;

public class CbConsoleRepository implements ConsoleRepository {


    public BankCard findByName(String nameToFind) {
        List<BankCard> tempDB = Database.getCardDatabase();
        boolean isFound = false;
        BankCard tempBankCard = null;
        BankCard foundBankCard = null;

        Iterator<BankCard> cardIterator = tempDB.iterator();
        while (cardIterator.hasNext() && !isFound) {
            tempBankCard = cardIterator.next();
            if (tempBankCard.getName().equals(nameToFind)) {
                isFound = true;
                foundBankCard = tempBankCard;
                foundBankCard.setIndexInDb(tempDB.indexOf(tempBankCard));
            }
        }
        return foundBankCard;
    }

    @Override
    public void showMyCards() {
        Database.showCardDB();
    }

    @Override
    public boolean addNewCard(BankCard bankCard) {
        Database.addCard(bankCard);
        System.out.println("\nКарта успешно добавлена в базу данных\n");
        return true;
    }

    @Override
    public int findCard() {

        System.out.println("Введите название карты: \n");

        String newText = CashDanceApp.myScan.nextLine();
        int isFound = 0;


        for (int i = 0; i < Database.getCardDatabase().size(); i++) {
            if (Database.getCardDatabase().get(i).getName().contains(newText)) {
                System.out.println("Найдена карта");
                System.out.println(Database.getCardDatabase().get(i));
                return i;
            }
        }

        System.out.println("Карта не найдена, попробуйте ещё раз");
        findCard();
        return -1;
    }


    @Override
    public void changeCard(int i, BankCard bankCard) {
        Database.replaceCard(i, bankCard);
        System.out.println("Изменения приняты!");
    }

    @Override
    public void deleteCard(int i) {
        Database.deleteCard(i);
        System.out.println("Карта удалена!");
    }

    @Override
    public void showMyCategories() {
        Database.showCategoryDB();
    }

    @Override
    public void addNewCategory(CbCategory category) {
        Database.addCategory(category);
        System.out.println("\nКатегория успешно добавлена в базу данных\n");
    }

    @Override
    public int findCategory() {

        System.out.println("Введите название категории: \n");

        String newText = CashDanceApp.myScan.nextLine();
        int isFound = 0;

        for (int i = 0; i < Database.getCategoryDatabase().size(); i++) {
            if (Database.getCategoryDatabase().get(i).getName().contains(newText)) {
                System.out.println("Найдена категория");
                System.out.println(Database.getCategoryDatabase().get(i));
                return i;
            }
        }

        System.out.println("Категория не найдена, попробуйте ещё раз");
        findCategory();
        return -1;
    }

    @Override
    public void changeCategory(int i, CbCategory category) {
        Database.replaceCategory(i, category);
        System.out.println("Изменения приняты!");
    }

    @Override
    public void deleteCategory(int i) {
        Database.deleteCategory(i);
        System.out.println("Категория удалена!");
    }
    @Override
    public void showCbChances(){
        Database.showCbChancesDB();
    }


}
