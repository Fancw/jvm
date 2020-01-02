package xyz.fanchw.factory.normal;

public abstract class ChineseFood implements Food {
    @Override
    public void makeFood() {
        System.out.println("制作中国食物。。。。。。");
    }
}
