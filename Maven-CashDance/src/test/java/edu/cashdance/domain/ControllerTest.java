package edu.cashdance.domain;

import edu.cashdance.SQL.ConnectionBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerTest {

    @Test
    @BeforeClass
    /**
     * Создаёт тестовую базу данных
     */
    public static void testDatabaseBuilder() throws URISyntaxException, IOException {
        URL url = ControllerTest.class.getClassLoader().getResource("testDatabaseCreator.sql");
        List<String> str = Files.readAllLines(Paths.get(url.toURI()));
        String sql = str.stream().collect(Collectors.joining());

        try (Connection connection = ConnectionBuilder.getConnection();
             Statement statement = connection.createStatement()
        ) {
            statement.executeUpdate(sql);
            System.out.println("Создана тестовая база данных");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test() {

    }
}