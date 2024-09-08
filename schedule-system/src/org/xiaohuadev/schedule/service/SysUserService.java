package org.xiaohuadev.schedule.service;

import org.xiaohuadev.schedule.pojo.SysUser;

public interface SysUserService {
    Integer regist(SysUser sysUser);

    SysUser findByUsername(String username);
}
