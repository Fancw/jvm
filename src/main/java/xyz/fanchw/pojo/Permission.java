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
public class Permission implements Serializable {
    /**
     * 权限id
     */
    private Integer permissionId;

    /**
     * 权限名
     */
    private String permissionName;

    /**
     * 权限url
     */
    private String permissionUrl;

    private static final long serialVersionUID = 1L;
}
