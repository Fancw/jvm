package xyz.fanchw.factory.normal;

public class AmericaFoodFactory implements FoodFactory {
    @Override
    public Food makeFood(Class<? extends Food> clazz) {
        if ("AmericanSpicyFood".equals(clazz.getSimpleName())) {
            return new AmericanSpicyFood();
        }
        if ("AmericanSweetFood".equals(clazz.getSimpleName())) {
            return new AmericanSweetFood();
        }
        return null;
    }
}
