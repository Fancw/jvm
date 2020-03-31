package xyz.fanchw.constructor;

import org.junit.Test;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.Unsafe;
import xyz.fanchw.factory.abs.*;
import xyz.fanchw.factory.build.House;
import xyz.fanchw.factory.normal.*;
import xyz.fanchw.factory.simple.FoodClass;
import xyz.fanchw.factory.simple.SimpleFoodFactory;
import xyz.fanchw.factory.simple.SpicyFoodClass;
import xyz.fanchw.factory.simple.SweetFoodClass;
import xyz.fanchw.pojo.Role;
import xyz.fanchw.pojo.SinglePojo;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class NewOne {


    private static final Logger LOGGER = LoggerFactory.getLogger(NewOne.class);

    @Test
    public void newOne() throws Exception {
        Role role = new Role(1, "管理员", "管理员角色描述");
        Role cloneRole = (Role) role.getCloneInstance();
        System.out.println("role = " + role);
        System.out.println("cloneRole = " + cloneRole);
    }

    @Test
    public void serializable() throws Exception {
        Role role = new Role(1, "管理员", "管理员角色描述");
        File tempFile = File.createTempFile("obj", "txt");
        ObjectOutput objectOutput = new ObjectOutputStream(new FileOutputStream(tempFile));
        objectOutput.writeObject(role);
        ObjectInput objectInput = new ObjectInputStream(new FileInputStream(tempFile));
        Role serializableRole = (Role) objectInput.readObject();
        System.out.println("role = " + role);
        System.out.println("serializableRole = " + serializableRole);
    }

    @Test
    public void reflectOne() throws Exception {
        Class<?> clazz = Class.forName("xyz.fanchw.pojo.Role");
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f : declaredFields) {
            System.out.println(f.getName());
        }
        Role role = (Role) clazz.newInstance();
        role.setRoleId(1).setRoleName("管理员").setRoleDescription("管理员角色描述");
        System.out.println("role = " + role);
    }

    @Test
    public void constructor() throws Exception {
        Class<?> clazz = Class.forName("xyz.fanchw.pojo.Role");
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        for (Constructor<?> c : constructors) {
            System.out.println(c);
        }
        //获取默认（空参）构造方法
        Constructor<?> noArgConstructor = clazz.getDeclaredConstructor();
        noArgConstructor.setAccessible(true);
        //获取指定（这里是全参）构造方法 按顺序传入构造参数的Class对象
        Constructor<?> allArgsConstructor = clazz.getConstructor(Integer.class, String.class, String.class);
        //调用默认构造方法生成对象
        Role noArgRole = (Role) noArgConstructor.newInstance();
        System.out.println("noArgRole = " + noArgRole);
        //调用全参构造方法生成对象
        Role allArgsRole = (Role) allArgsConstructor.newInstance(1, "管理员", "管理员的角色描述");
        System.out.println("allArgsRole = " + allArgsRole);
    }

    @Test
    public void unsafe() throws Exception {
        //获得Unsafe对象实例
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe) field.get(null);
        //通过Unsafe中的allocateInstance()方法创建对象
        Role unsafeRole = (Role) unsafe.allocateInstance(Role.class);
        System.out.println("unsafeRole = " + unsafeRole);
    }

    @Test
    public void hungerSingle() {
        SinglePojo firstInstance = SinglePojo.getInstance();
        SinglePojo secondInstance = SinglePojo.getInstance();
        System.out.println(firstInstance == secondInstance);
    }

    @Test
    public void lazySingle() {
        SinglePojo firstInstance = SinglePojo.getInstance();
        SinglePojo secondInstance = SinglePojo.getInstance();
        System.out.println(firstInstance == secondInstance);
    }

    @Test
    public void nestedSingle() {
        SinglePojo firstInstance = SinglePojo.getInstance();
        SinglePojo secondInstance = SinglePojo.getInstance();
        System.out.println(firstInstance == secondInstance);
    }

    @Test
    public void simpleFactory() {
        FoodClass spicyFoodClass = SimpleFoodFactory.getFoodClassBean(SpicyFoodClass.class);
        FoodClass sweetFoodClass = SimpleFoodFactory.getFoodClassBean(SweetFoodClass.class);
        spicyFoodClass.makeFood();
        sweetFoodClass.makeFood();
    }

    @Test
    public void factory() {
        //选择具体工厂
        FoodFactory chineseFoodFactory = new ChineseFoodFactory();
        FoodFactory americaFoodFactory = new AmericaFoodFactory();
        //生产具体对象
        Food chineseSpicyFood = chineseFoodFactory.makeFood(ChineseSpicyFood.class);
        Food chineseSweetFood = chineseFoodFactory.makeFood(ChineseSweetFood.class);
        Food americanSpicyFood = americaFoodFactory.makeFood(AmericanSpicyFood.class);
        Food americanSweetFood = americaFoodFactory.makeFood(AmericanSweetFood.class);
        //调用具体对象的方法
        chineseSpicyFood.makeFood();
        chineseSweetFood.makeFood();
        americanSpicyFood.makeFood();
        americanSweetFood.makeFood();
    }

    @Test
    public void absFactory() {
        //选择一个抽象工厂
        ComputerFactory intelComputerFactory = new IntelComputerFactory();
        ComputerFactory amdComputerFactory = new AmdComputerFactory();
        //制造产品族对象
        CPU intelCPU = intelComputerFactory.createCPU();
        GPU intelGPU = intelComputerFactory.creatGPU();
        Board intelBoard = intelComputerFactory.creatBoard();
        Computer intelComputer = new IntelComputer(intelCPU, intelGPU, intelBoard);
        CPU amdCPU = amdComputerFactory.createCPU();
        GPU amdGPU = amdComputerFactory.creatGPU();
        Board amdBoard = amdComputerFactory.creatBoard();
        Computer amdComputer = new AmdComputer(amdCPU, amdGPU, amdBoard);

        System.out.println(intelComputer);
        System.out.println(amdComputer);
    }

    @Test
    public void builder() {
        House house = House.builder().setHousePrice(2000D).setHouseType("学区房").build();
        System.out.println(house);
    }

    @Test
    public void rLock() {
        Config config = new Config();
//        config.setTransportMode(TransportMode.EPOLL);
        config.useSingleServer()
                .setAddress("redis://115.159.189.44:6379");
        RedissonClient redisson = Redisson.create(config);
        IntStream.rangeClosed(1, 5)
                .parallel()
                .forEach(i -> {
                    executeLock(redisson);
                });

        executeLock(redisson);
    }

    public void executeLock(RedissonClient redisson) {
        RLock lock = redisson.getLock("myLock");
        boolean locked = false;
        try {
            LOGGER.info("try lock");
            locked = lock.tryLock();
//            locked = lock.tryLock(1,2,TimeUnit.MINUTES);
            LOGGER.info("get lock result:{}", locked);
            if (locked) {
                TimeUnit.HOURS.sleep(1);
                LOGGER.info("get lock and finish");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            LOGGER.info("enter unlock");
            if (locked) {
                lock.unlock();
            }
        }
    }
}
