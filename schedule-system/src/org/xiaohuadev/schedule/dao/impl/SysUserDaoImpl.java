package org.xiaohuadev.schedule.dao.impl;

import org.xiaohuadev.schedule.dao.BaseDao;
import org.xiaohuadev.schedule.dao.SysUserDao;
import org.xiaohuadev.schedule.pojo.SysUser;

import java.util.List;

public class SysUserDaoImpl extends BaseDao implements SysUserDao {
    @Override
    public Integer addSysUser(SysUser sysUser) {
        String sql = "insert into sys_user values(DEFAULT,?,?)";
        return baseUpdate(sql, sysUser.getUsername(), sysUser.getUserPwd());
    }

    @Override
    public SysUser findByUserName(String username) {
        String sql = "select uid,username,user_pwd userPwd from sys_user where username = ?";
        List<SysUser> sysUserList = baseQuery(SysUser.class, sql, username);
        return sysUserList != null && !sysUserList.isEmpty() ? sysUserList.getFirst() : null;
    }
}
