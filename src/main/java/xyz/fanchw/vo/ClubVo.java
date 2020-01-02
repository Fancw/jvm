package xyz.fanchw.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClubVo implements Serializable {
    private Integer id;

    private String name;

    private static final long serialVersionUID = 1L;
}
