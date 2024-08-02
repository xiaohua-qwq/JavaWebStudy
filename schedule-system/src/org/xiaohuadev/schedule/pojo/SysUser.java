package org.xiaohuadev.schedule.pojo;

import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@AllArgsConstructor //全参构造
@NoArgsConstructor //无参构造
@Data //getter setter equals hashcode toString
public class SysUser implements Serializable {
    private Integer uid;
    private String username;
    private String userPwd;
}
