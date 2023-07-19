import java.util.Iterator;
import java.util.List;

public class CbRepository implements Repository {


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

    @Override
    public void showMyCards() {
        Database.showCardDB();
    }

    public void addNewCard(Card card) {
        Database.addCard(card);
        System.out.println("\nКарта успешно добавлена в базу данных\n");
    }

    @Override
    public int findCard() {

        System.out.println("Введите название карты: \n");

        String newText = App.myScan.nextLine();
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
    public void changeCard(int i, Card card) {
        Database.replaceCard(i, card);
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

        String newText = App.myScan.nextLine();
        int isFound = 0;

        for (int i = 0; i < Database.getCategoryDatabase().size(); i++) {
            if (Database.getCategoryDatabase().get(i).getName().contains(newText)) {
                System.out.println("Найдена категория");
                System.out.println(Database.getCategoryDatabase().get(i));
                return i;
            }
        }

        System.out.println("Карта не найдена, попробуйте ещё раз");
        findCard();
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

    public void showCbChances(){
        Database.showCbChancesDB();
    }


}
