package ru.cashdance.domain;

public interface ConsoleRepository {

    BankCard findByName(String nameToFind);

    void showMyCards();
    boolean addNewCard(BankCard bankCard);
    int findCard();
    void changeCard(int i, BankCard bankCard);
    void deleteCard(int i);

    void showMyCategories();
    void addNewCategory(CbCategory category);
    int findCategory();
    void changeCategory(int i, CbCategory category);
    void deleteCategory(int i);

    void showCbChances();
    // TODO: 20.07.2023 query with period of time 

}
