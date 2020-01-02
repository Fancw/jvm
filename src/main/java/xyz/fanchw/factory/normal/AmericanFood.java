package xyz.fanchw.factory.normal;

public abstract class AmericanFood implements Food {
    @Override
    public void makeFood() {
        System.out.println("制作美国食物。。。。。。");
    }
}
