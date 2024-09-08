package org.xiaohuadev.schedule.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.xiaohuadev.schedule.dao.SysScheduleDao;
import org.xiaohuadev.schedule.dao.impl.SysScheduleDaoImpl;
import org.xiaohuadev.schedule.pojo.SysSchedule;

public class TestSysScheduleDao {
    private static SysScheduleDao sysScheduleDao;

    @BeforeClass
    public static void init(){
        sysScheduleDao = new SysScheduleDaoImpl();
    }

    @Test
    public void testInsert() {
        int row = sysScheduleDao.addSysSchedule(new SysSchedule(null, 2, "学习数据库", 1));
        System.out.println(row);
    }
}
