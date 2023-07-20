package SQL;

import domain.Card;
import domain.CbCategory;
import domain.Repository;
import domain.Repository;

import java.sql.*;

public class SqlDataGetter implements Repository {

    private Connection getConnection() throws SQLException {

        // подгружаем класс по имени (уже необязательно прописывать)
        // Class.forName("org.postgresql.Driver");
        // устанавливаем соединение с сервером
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/CashDanceDB", "postgres", "postgres");
        System.out.println("Подключение к SQL серверу установлено");
        return con;
    }

    @Override
    public Card findByName(String nameToFind) {
        return null;
    }

    @Override
    public void showMyCards() {
        try (Connection connection = getConnection()) {

            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM cards");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + " : " +
                        resultSet.getString(2)+ " : " +
                        resultSet.getString(3));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addNewCard(Card card) {
        try (Connection connection = getConnection()) {

            Statement stmt = connection.createStatement();
            stmt.executeUpdate("INSERT INTO cards (name_card, bank_name)\n" +
                    "VALUES\n" +
                    "('"+card.getName()+"', '"+card.getBankName()+"');");
                    showMyCards();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public int findCard() {
        return 0;
    }

    @Override
    public void changeCard(int i, Card card) {

    }

    @Override
    public void deleteCard(int i) {

    }

    @Override
    public void showMyCategories() {
        try (Connection connection = getConnection()) {

            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM categories");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addNewCategory(CbCategory category) {

    }

    @Override
    public int findCategory() {
        return 0;
    }

    @Override
    public void changeCategory(int i, CbCategory category) {

    }

    @Override
    public void deleteCategory(int i) {

    }

    @Override
    public void showCbChances() {
        try (Connection connection = getConnection()) {

            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT " +
                    "cbChances.name_chance, " +
                    "cbChances.id_card," +
                    "cbChances.from_date,\n" +
                    "cbChances.to_date," +
                    "cbChances.id_category," +
                    "cbChances.rate, \n" +
                    "cards.name_card, " +
                    "categories.name_category " +
                    "FROM cbChances\n" +
                    "JOIN cards ON cbChances.id_card = cards.id_card\n" +
                    "JOIN categories ON cbChances.id_category = categories.id_category\n" +
                    "WHERE (" +
                    "from_date >= '01-07-2023' and to_date <='31-07-2023') or\n" +
                    "(from_date <= '01-07-2023' and to_date >='31-07-2023')");
            while (resultSet.next()) {
                System.out.println(
                        resultSet.getString(1) + " : " +
                                resultSet.getString(2) + " : " +
                                resultSet.getString(3) + " : " +
                                resultSet.getString(4) + " : " +
                                resultSet.getString(5) + " : " +
                                resultSet.getString(6) + " : " +
                                resultSet.getString(7) + " : " +
                                resultSet.getString(8));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

