package xyz.fanchw.factory.normal;

public interface Food {
   default void makeFood(){
       System.out.println("制作食物。。。。。。");
   };
}
