package edu.cashdance.SQL;

import edu.cashdance.App;
import edu.cashdance.domain.Card;
import edu.cashdance.domain.CbCategory;
import edu.cashdance.domain.Repository;

import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

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
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM cards ORDER BY id_card");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + " : " +
                        resultSet.getString(2) + " : " +
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
                    "('" + card.getName() + "', '" + card.getBankName() + "');");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public int findCard() {
        showMyCards();
        System.out.println("Укажите ID карты для изменения");
        int tempID = Integer.parseInt(App.myScan.nextLine());
        return tempID;
    }

    @Override
    public void changeCard(int i, Card card) {

        try (Connection connection = getConnection()) {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("UPDATE cards " +
                    "SET name_card = '" + card.getName() + "', bank_name = '" + card.getBankName() + "'" +
                    "WHERE id_card = " + i + "");

            showMyCards();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteCard(int i) {
        try (Connection connection = getConnection()) {

            Statement stmt = connection.createStatement();
            stmt.executeUpdate("DELETE FROM cards " +
                    "WHERE id_card = " + i + "");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void showMyCategories() {
        try (Connection connection = getConnection()) {
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM categories");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + " : " +
                        resultSet.getString(2));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addNewCategory(CbCategory category) {
        try (Connection connection = getConnection()) {
            // transaction example
            connection.setAutoCommit(false);
            try {
                Statement stmt = connection.createStatement();
                stmt.executeUpdate("INSERT INTO categories (name_category)\n" +
                        "VALUES\n" +
                        "('" + category.getName() + "');");
                connection.commit(); // commit if everything is ok
            } catch (SQLException e) {
                connection.rollback(); // rollback (no commit to DB if any exception occurs)
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int findCategory() {
        showMyCategories();
        System.out.println("Укажите ID категории для изменения");
        int tempID = Integer.parseInt(App.myScan.nextLine());
        return tempID;
    }

    @Override
    public void changeCategory(int i, CbCategory category) {
        try (Connection connection = getConnection()) {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("UPDATE categories " +
                    "SET name_category = '" + category.getName() + "'" +
                    "WHERE id_category = " + i + "");

            showMyCategories();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // TODO: 22.07.2023 add delete with warning
    // TODO: 22.07.2023 add dialog "cancel" during operation
    // TODO: 22.07.2023 DRY this class methods
    // TODO: 22.07.2023 delete card leads to deletion of Chance? ON DELETE , ON UPDATE
    // TODO: 22.07.2023 add warning when update or delete card or category already used in Chances

    @Override
    public void deleteCategory(int i) {
        try (Connection connection = getConnection()) {

            Statement stmt = connection.createStatement();
            stmt.executeUpdate("DELETE FROM categories " +
                    "WHERE id_category = " + i + "");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // TODO: 22.07.2023 add parameters to showCbChances
    @Override
    public void showCbChances() {
        try (Connection connection = getConnection()) {

            ZoneId timezone = ZoneId.of(ZoneId.systemDefault().getId());
            LocalDate ld = LocalDate.now(timezone);
//            LocalDate ld = LocalDate.of(2023, Month.AUGUST, 01);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String ldFormatted = ld.format(formatter);

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
                    "WHERE" +
                    "(from_date <= '" + ldFormatted + "' and to_date >='" + ldFormatted + "')");
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

