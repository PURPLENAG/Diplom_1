package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {

    @Test
    public void shouldReturnBunNameAndPrice() {
        Bun bun = new Bun("Hasly", 54.09f);
        var expectedName = "Hasly";
        var expectedPrice = 54.09f;

        assertEquals(expectedName, bun.getName());
        assertEquals(expectedPrice, bun.getPrice(), 0.00001);
    }
}