package xyz.fanchw.factory.normal;

public interface FoodFactory {
    Food makeFood(Class<? extends Food> clazz);
}
