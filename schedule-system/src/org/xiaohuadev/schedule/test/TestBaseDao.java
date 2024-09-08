package org.xiaohuadev.schedule.test;


import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.xiaohuadev.schedule.dao.BaseDao;

public class TestBaseDao {

    private static BaseDao baseDao;

    @BeforeClass
    public static void initBaseDao() {
        baseDao = new BaseDao();
    }

    @Test
    public void testBaseQueryObject() throws Exception {
        System.out.println("start");
        //查询用户数量
        String sql = "select COUNT(1) from sys_user";
        Long count = baseDao.baseQueryObject(Long.class, sql);
        System.out.println(count);
    }
}
