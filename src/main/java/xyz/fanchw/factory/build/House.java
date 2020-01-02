package xyz.fanchw.factory.build;

import lombok.Data;
import lombok.Setter;
import lombok.experimental.Accessors;

@Data
public class House {
    private String houseType;
    private Double housePrice;

    //构造私有化 禁止外部直接调用构造创建对象
    private House(String houseType, Double housePrice) {
        this.houseType = houseType;
        this.housePrice = housePrice;
    }

    //提供一个方法获得静态嵌套类,也可以不提供直接 new House.HouseBuilder
    public static HouseBuilder builder() {
        return new HouseBuilder();
    }

    //利用静态嵌套类创建对象 利用lombok生成可以链式操作的set方法
    @Setter
    @Accessors(chain = true)
    public static class HouseBuilder {
        private String houseType;
        private Double housePrice;

        public House build() {
            //在创建之前可以进行属性的校验
            if (0 > housePrice || housePrice > 5000) {
                throw new RuntimeException("房子价格有误，需在0到5000之间");
            }
            //通过嵌套类可以访问外部类资源的特性，调用私有全参构造进行赋值
            return new House(houseType, housePrice);
        }
    }
}
