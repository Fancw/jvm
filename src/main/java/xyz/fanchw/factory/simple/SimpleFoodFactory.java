package xyz.fanchw.factory.simple;

public class SimpleFoodFactory {
    /**
     * @param clazz 只接受FoodClass的子类的类类型对象
     * @return 根据传入的类类型对象 返回相应实例
     */
    public static FoodClass getFoodClassBean(Class<? extends FoodClass> clazz) {
        //由于限制了传入参数的类型 所以只需要判断简单类名即可 也可以判断全限定名
        if (clazz.getSimpleName().equals("SpicyFoodClass")) {
            return new SpicyFoodClass();
        }

        if (clazz.getSimpleName().equals("SweetFoodClass")) {
            return new SweetFoodClass();
        }
        return null;
    }
}
