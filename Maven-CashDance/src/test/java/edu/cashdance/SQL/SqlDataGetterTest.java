package edu.cashdance.SQL;

import edu.cashdance.App;
import edu.cashdance.domain.CbChance;
import org.junit.Test;

import java.sql.SQLException;
import java.text.ParseException;

import static org.junit.Assert.*;

public class SqlDataGetterTest {

    /**
     * First test. Throws exception, because rate is null
     * @throws ParseException
     */
    @Test (expected = RuntimeException.class)
    public void addNewCbChance() throws ParseException {
        SqlDataGetter sqlDataGetter = new SqlDataGetter();
        sqlDataGetter.setConnectionBuilder(new DirectConnectionBuilder());

        sqlDataGetter.addNewCbChance(new CbChance( "test CbChance", 1,
                App.oldDateFormat.parse("01-07-2023"),
                App.oldDateFormat.parse("31-07-2023"),
                1, null));
    }
}