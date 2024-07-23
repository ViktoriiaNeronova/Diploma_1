import org.junit.Test;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class BurgerTest {
    public static final String RECEIPT = "(==== Wow burger ====)" + System.lineSeparator() +
            "= filling beef cutlet =" + System.lineSeparator() +
            "(==== Wow burger ====)" + System.lineSeparator() +
            System.lineSeparator() +
            "Price: 300,000000" + System.lineSeparator();

    @Test
    public void receiptTest() {
        Bun bun = Mockito.mock(Bun.class);
        Ingredient ingredient = Mockito.mock(Ingredient.class);
        Mockito.when(bun.getName()).thenReturn("Wow burger");
        Mockito.when(ingredient.getName()).thenReturn("beef cutlet");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Burger burger = Mockito.spy(Burger.class);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.doReturn(300f).when(burger).getPrice();
        assertEquals(RECEIPT, burger.getReceipt());
    }

    @Test
    public void priceTest() {
        Bun bun = Mockito.mock(Bun.class);
        Ingredient ingredient = Mockito.mock(Ingredient.class);
        Mockito.when(bun.getPrice()).thenReturn(19.99f);
        Mockito.when(ingredient.getPrice()).thenReturn(10.02f);
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        assertEquals(50f, burger.getPrice(), 0.001);
    }
}
