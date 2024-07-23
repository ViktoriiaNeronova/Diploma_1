import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;
    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] params() {
        return new Object[][] {
                { "white bun", 9.99f},
                { "black bun", 19.99f},
        };
    }

    @Test
    public void nameBunTest() {
        Bun bun = new Bun(name, price);
        assertEquals(name, bun.getName());
    }

    @Test
    public void priceBunTest() {
        Bun bun = new Bun(name, price);
        assertEquals(price, bun.getPrice(), 0.001);
    }
}
