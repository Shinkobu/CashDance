import edu.cashdance.App;
import edu.cashdance.SQL.ConnectionBuilder;
import edu.cashdance.SQL.SqlDataGetter;
import edu.cashdance.domain.CbChance;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

public class MyClassTest {
    @Test
    /**
     * Создаёт тестовую базу данных
     */
    public void testDatabaseBuilder() throws URISyntaxException, IOException {
        URL url = MyClassTest.class.getClassLoader().getResource("testDatabaseCreator.sql");
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
    public void testAddNewCard() throws ParseException {
        SqlDataGetter sqlDataGetter = new SqlDataGetter();
        sqlDataGetter.addNewCbChance(new CbChance( "test CbChance", 1,
                App.oldDateFormat.parse("01-07-2023"),
                App.oldDateFormat.parse("31-07-2023"),
                1, 0.15));
    }
}
