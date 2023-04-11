import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MainTests {

    @Test
    public void test_taxEarnings() {
        // given:
        final int argument = 100;
        final int expected = 6;

        // when:
        final int result = Main.taxEarnings(argument);

        // then:
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({
            "100,20"
    })
    public void test_taxEarningsMinusSpendings(int earnings, int spendings) {
        // given:
        final int expected = 12;

        // when:
        final int result = Main.taxEarningsMinusSpendings(earnings, spendings);

        // then:
        Assertions.assertEquals(expected, result);

    }

}