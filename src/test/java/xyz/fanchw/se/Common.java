package xyz.fanchw.se;

import org.junit.Test;
import xyz.fanchw.observe.Food;
import xyz.fanchw.observe.People;

public class Common {

    @Test
    public void test() {
        Food food = new Food();
        food.addObserver(new People());
        food.buy();
    }
}
