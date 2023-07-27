package edu.cashdance.domain;

import edu.cashdance.domain.Card;
import edu.cashdance.domain.CbCategory;

public interface Repository {

    Card findByName(String nameToFind);

    void showMyCards();
    void addNewCard(Card card);
    int findCard();
    void changeCard(int i, Card card);
    void deleteCard(int i);

    void showMyCategories();
    void addNewCategory(CbCategory category);
    int findCategory();
    void changeCategory(int i, CbCategory category);
    void deleteCategory(int i);

    void showCbChances();
    // TODO: 20.07.2023 query with period of time 

}
