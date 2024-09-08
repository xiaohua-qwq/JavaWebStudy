package org.xiaohuadev.schedule.dao;

import org.xiaohuadev.schedule.pojo.SysUser;

public interface SysUserDao {
    Integer addSysUser(SysUser sysUser);

    SysUser findByUserName(String username);
}
