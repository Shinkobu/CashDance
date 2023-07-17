import Proposals.Card;

import java.util.Iterator;
import java.util.List;

public class Repository {


    public static void addNewCard(Card card){
        Database.addCard(card);
    }

    public static Card findByName(String nameToFind) {
        List<Card> tempDB = Database.getCardDatabase();
        boolean isFound = false;
        Card tempCard = null;
        Card foundCard = null;

        Iterator<Card> cardIterator = tempDB.iterator();
        while (cardIterator.hasNext() && !isFound) {
            tempCard = cardIterator.next();
            if (tempCard.getName().equals(nameToFind)) {
                isFound = true;
                foundCard = tempCard;
                foundCard.setIndexInDb(tempDB.indexOf(tempCard));
            }
        }
        return foundCard;
    }
}
