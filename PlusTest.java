import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class PlusTest {

    @org.junit.jupiter.api.Test

    void calculate_dbszamok_nominalis_ertekekkel() {
        Plus plus = new Plus("Title");

        plus.frescaDb = 2;
        plus.poloDb = 2;
        plus.cokeDb = 2;
        plus.beerDb = 2;

        plus.calculate();

        assertAll(
                () -> Assertions.assertEquals(360,plus.osszesenFreska,"Fresca ár számításban van hiba\n"),
                () -> Assertions.assertEquals(30,plus.osszesenPolo),
                () -> Assertions.assertEquals(6,plus.osszesenCoke),
                () -> Assertions.assertEquals(8,plus.osszesenBeer)
        );
    }
}