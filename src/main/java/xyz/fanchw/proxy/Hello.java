package xyz.fanchw.proxy;

public class Hello implements One {
    @Override
    public void sayHelloWorld() {
        System.out.println("Hello World!");
    }

    public String test(){
        return "test";
    }
}
