package org.xiaohuadev.schedule.dao;

import org.xiaohuadev.schedule.pojo.SysSchedule;

import java.util.List;

public interface SysScheduleDao {
    /**
     * 添加一条记录
     *
     * @param sysSchedule 实体类
     * @return 受影响的行数
     */
    int addSysSchedule(SysSchedule sysSchedule);

    List<SysSchedule> findAll();
}
