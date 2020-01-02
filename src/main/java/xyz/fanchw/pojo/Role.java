package xyz.fanchw.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class Role implements Serializable, Cloneable {
    /**
     * 角色id
     */
    private Integer roleId;

    /**
     * 角色名
     */
    private String roleName;

    /**
     * 角色描述
     */
    private String roleDescription;

    public Role() {
        System.out.println("空参构造被调用。。。。。。");
    }

    public Role(Integer roleId, String roleName, String roleDescription) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleDescription = roleDescription;
        System.out.println("全参构造被调用。。。。。。");
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Role role = null;
        try {
            role = (Role) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return role;
    }

    public Object getCloneInstance() throws CloneNotSupportedException {
        return clone();
    }

    private static final long serialVersionUID = 1L;
}
