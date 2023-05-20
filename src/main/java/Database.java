import Animals.Animal;
import Proposals.CbProposal;

import java.util.ArrayList;
import java.util.List;

public class Database {

    private static final List<CbProposal> ANIMALS_DATABASE = new ArrayList<>();

    public static void addAnimal(CbProposal cbProposal) {
        ANIMALS_DATABASE.add(cbProposal);
    }

    public static void addCommandAndAction(CbProposal cbProposal) {
        ANIMALS_DATABASE.set(cbProposal.getIndexInDb(), cbProposal);
    }

    public static void showDB() {

        for (var element : ANIMALS_DATABASE) {
            System.out.println(element.toString());
        }
    }


    public static List<CbProposal> getDatabase() {
        return ANIMALS_DATABASE;
    }
}
