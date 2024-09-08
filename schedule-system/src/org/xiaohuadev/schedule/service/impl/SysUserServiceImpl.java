package org.xiaohuadev.schedule.service.impl;

import org.xiaohuadev.schedule.dao.SysUserDao;
import org.xiaohuadev.schedule.dao.impl.SysUserDaoImpl;
import org.xiaohuadev.schedule.pojo.SysUser;
import org.xiaohuadev.schedule.service.SysUserService;
import org.xiaohuadev.schedule.util.MD5Util;

public class SysUserServiceImpl implements SysUserService {

    private SysUserDao userDao = new SysUserDaoImpl();

    /**
     * 用户注册方法
     *
     * @param sysUser sysUser实体类
     * @return 1为成功 0为失败
     */
    @Override
    public Integer regist(SysUser sysUser) {
        sysUser.setUserPwd(MD5Util.encrypt(sysUser.getUserPwd()));
        return userDao.addSysUser(sysUser);
    }

    @Override
    public SysUser findByUsername(String username) {
        return userDao.findByUserName(username);
    }
}
