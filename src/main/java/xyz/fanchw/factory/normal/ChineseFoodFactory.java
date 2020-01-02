package xyz.fanchw.factory.normal;

public class ChineseFoodFactory implements FoodFactory {
    @Override
    public Food makeFood(Class<? extends Food> clazz) {
        if ("ChineseSpicyFood".equals(clazz.getSimpleName())) {
            return new ChineseSpicyFood();
        }

        if ("ChineseSweetFood".equals(clazz.getSimpleName())) {
            return new ChineseSweetFood();
        }
        return null;
    }
}
