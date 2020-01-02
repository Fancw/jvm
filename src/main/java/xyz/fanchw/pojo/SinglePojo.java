package xyz.fanchw.pojo;

public class SinglePojo {
    //构造方法私有化 外部无法直接调用构造方法创建对象
    private SinglePojo() {
        System.out.println("私有构造被调用。。。。。。");
    }

    //声明一个静态实例变量但先不实例化，并且加上volatile关键字 使其状态对所有线程可见
    private static volatile SinglePojo SINGLE_POJO = null;


    //提供一个静态方法返回实例
    public static SinglePojo getInstance() {
        //第一次判断SINGLE_POJO 是否为空 这次判断不是必要的 但是能够提高性能
        if (SINGLE_POJO == null) {
            //利用本类的类类型对象加锁
            synchronized (SinglePojo.class) {
                //第二次判断SINGLE_POJO 是否为空 这次判断是必要的 保证多线程下的单例
                if (SINGLE_POJO == null) {
                    //如果为空就通过私有构造创建一个实例
                    SINGLE_POJO = new SinglePojo();
                }
            }
        }
        return SINGLE_POJO;
    }
}
