package org.xiaohuadev.schedule.dao.impl;

import org.xiaohuadev.schedule.dao.BaseDao;
import org.xiaohuadev.schedule.dao.SysScheduleDao;
import org.xiaohuadev.schedule.pojo.SysSchedule;

import java.util.List;

public class SysScheduleDaoImpl extends BaseDao implements SysScheduleDao {
    /**
     * 添加一条记录
     *
     * @param sysSchedule 实体类
     * @return 受影响的行数
     */
    @Override
    public int addSysSchedule(SysSchedule sysSchedule) {
        String sql = "insert into sys_schedule values(DEFAULT,?,?,?)";
        return this.baseUpdate(sql, sysSchedule.getUid(), sysSchedule.getTitle(), sysSchedule.getCompleted());
    }

    @Override
    public List<SysSchedule> findAll() {
        String sql = "select * from sys_schedule";
        return this.baseQuery(SysSchedule.class, sql);
    }
}
