package xyz.fanchw.reference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class DeepClone implements Cloneable {
    private int age;
    private String sex;
    private Fa fa;

    @Override
    public Object clone() throws CloneNotSupportedException {
        DeepClone deepClone = null;
        try {
            deepClone = (DeepClone) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return deepClone;
    }
}
