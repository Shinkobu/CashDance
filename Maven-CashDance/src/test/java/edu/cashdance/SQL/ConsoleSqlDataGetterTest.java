package edu.cashdance.SQL;

import edu.cashdance.CashDanceApp;
import edu.cashdance.domain.CbChance;
import org.junit.Test;

import java.text.ParseException;
import java.time.LocalDate;

public class ConsoleSqlDataGetterTest {

    /**
     * First test. Throws exception, because rate is null
     * @throws ParseException
     */
    @Test (expected = RuntimeException.class)
    public void addNewCbChance() throws ParseException {
        ConsoleSqlDataGetter consoleSqlDataGetter = new ConsoleSqlDataGetter();
        consoleSqlDataGetter.setConnectionBuilder(new DirectConnectionBuilder());

        consoleSqlDataGetter.addNewCbChance(new CbChance( "test CbChance", 1,
                LocalDate.parse("01-07-2023", CashDanceApp.oldDateFormatter),
                LocalDate.parse("31-07-2023", CashDanceApp.oldDateFormatter),
                1, null));
    }
}