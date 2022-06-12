package praktikum;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class IngredientTest {
    @Test
    @Parameters({
            "FILLING, Tomato, 32.09",
            "SAUCE, Tabasco, 14.232"
    })
    public void shouldReturnIngredientCharacteristics(IngredientType type, String name, float price) {
        Ingredient ingredient = new Ingredient(type, name, price);

        assertEquals(type, ingredient.getType());
        assertEquals(name, ingredient.getName());
        assertEquals(price, ingredient.getPrice(), 0.0001);
    }
}