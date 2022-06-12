package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient1;
    @Mock
    Ingredient ingredient2;

    @Before
    public void setUp() {
        when(bun.getPrice()).thenReturn(20.5f);
        when(bun.getName()).thenReturn("RedDevil");
        when(ingredient1.getPrice()).thenReturn(0.5f);
        when(ingredient1.getName()).thenReturn("Salad");
        when(ingredient1.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient2.getPrice()).thenReturn(28.0f);
        when(ingredient2.getName()).thenReturn("Cheese");
        when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
    }

    @Test
    public void shouldReturnCorrectBurgerBun() {
        Burger burger = new Burger();
        burger.setBun(bun);
        assertEquals(bun, burger.getBun());
    }

    @Test
    public void shouldAddBurgerIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        assertEquals(List.of(ingredient1, ingredient2), burger.getIngredients());
    }

    @Test
    public void shouldRemoveBurgerIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        burger.removeIngredient(0);
        assertEquals(List.of(ingredient2), burger.getIngredients());
    }

    @Test
    public void shouldMoveBurgerIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        burger.moveIngredient(0, 1);
        assertEquals(List.of(ingredient2, ingredient1), burger.getIngredients());
    }

    @Test
    public void shouldReturnFullBurgerPrice() {
        Burger burger = new Burger();
        burger.setBun(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        assertEquals(69.5f, burger.getPrice(), 0.0001);
    }

    @Test
    public void shouldThrowForEmptyBurgerPrice() {
        Burger burger = new Burger();
        assertThrows(IllegalStateException.class, burger::getPrice);
    }

    @Test
    public void shouldThrowForBurgerPriceWithoutIngredient() {
        Burger burger = new Burger();
        burger.setBun(bun);
        assertThrows(IllegalStateException.class, burger::getPrice);
    }

    @Test
    public void shouldThrowForBurgerPriceWithoutBun() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        assertThrows(IllegalStateException.class, burger::getPrice);
    }

    @Test
    public void shouldReturnBurgerReceipt() {
        Burger burger = new Burger();
        burger.setBun(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        var expected = String.format("" +
                "(==== RedDevil ====)%n" +
                "= filling Salad =%n" +
                "= filling Cheese =%n" +
                "(==== RedDevil ====)%n" +
                "%n" +
                "Price: 69,500000%n");
        assertEquals(expected, burger.getReceipt());
    }

    @Test
    public void shouldThrowForBurgerReceiptWithoutBun() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        assertThrows(IllegalStateException.class, burger::getReceipt);
    }

    @Test
    public void shouldThrowForBurgerReceiptWithoutIngredient() {
        Burger burger = new Burger();
        burger.setBun(bun);
        assertThrows(IllegalStateException.class, burger::getReceipt);
    }

    @Test
    public void shouldThrowForEmptyBurgerReceipt() {
        Burger burger = new Burger();
        assertThrows(IllegalStateException.class, burger::getReceipt);
    }
}