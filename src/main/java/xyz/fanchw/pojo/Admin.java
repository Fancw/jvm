package xyz.fanchw.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Admin implements Serializable {
    /**
     * 管理员id
     */
    private Integer adminId;

    /**
     * 管理员账号
     */
    private String adminAccount;

    /**
     * 管理员密码
     */
    private String adminPassword;

    /**
     * 管理员真实姓名
     */
    private String adminRealName;

    /**
     * 管理员手机号
     */
    private String adminPhone;
    /**
     * 管理员状态
     */

    private String adminState;

    private static final long serialVersionUID = 1L;
}
