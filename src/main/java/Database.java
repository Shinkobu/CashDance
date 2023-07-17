import Proposals.Card;
import Proposals.CbProposal;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private static final List<Card> CARD_DATABASE = new ArrayList<>();
    private static final List<User> USERS_DATABASE = new ArrayList<>();
    private static final List<CbProposal> CB_PROPOSALS_DATABASE = new ArrayList<>();

    public static void addCbProposal(CbProposal cbProposal) {
        CB_PROPOSALS_DATABASE.add(cbProposal);
    }
    public static void addCard(Card card) {CARD_DATABASE.add(card);}
    public static void addUser(User user) {USERS_DATABASE.add(user);}

    public static void showCbProposalDB() {

        for (var element : CB_PROPOSALS_DATABASE) {
            System.out.println(element.toString());
        }
    }
    public static void showCardDB() {

        for (var element : CARD_DATABASE) {
            System.out.println(element.toString());
        }
    }


    public static List<CbProposal> getCbProposalsDatabase() {
        return CB_PROPOSALS_DATABASE;
    }
    public static List<Card> getCardDatabase() {
        return CARD_DATABASE;
    }
}
