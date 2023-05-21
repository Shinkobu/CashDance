import Proposals.CbProposal;

import java.util.ArrayList;
import java.util.List;

public class Database {

    private static final List<CbProposal> CB_PROPOSALS_DATABASE = new ArrayList<>();

    public static void addCbProposal(CbProposal cbProposal) {
        CB_PROPOSALS_DATABASE.add(cbProposal);
    }

    public static void showDB() {

        for (var element : CB_PROPOSALS_DATABASE) {
            System.out.println(element.toString());
        }
    }


    public static List<CbProposal> getDatabase() {
        return CB_PROPOSALS_DATABASE;
    }
}
