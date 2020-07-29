package com.hbue.dao.Impl;

import com.hbue.model.Work;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class WorkDaoImpl {

    //1.创建连接（c3p0连接池） 需要c3p0数据源
    QueryRunner queryRunner = new QueryRunner(new ComboPooledDataSource());


    public List<Work> getList(String sql){
        List<Work> list = null;
        try {
            list = queryRunner.query(sql, new BeanListHandler<>(Work.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("doneList:"+list);
        return list;
    }

    //查找未完成任务
    public List<Work> findDoingWork(Integer listId){
        String sql = "select * from work where listId="+listId+" and state='未完成'";
        return getList(sql);
    }

    //查找已完成任务
    public List<Work> findDoneWork(Integer listId){
        String sql = "select * from work where listId="+listId+" and state='已完成'";
        return getList(sql);
    }

    //模糊查找未完成任务
    public List<Work> findDoingWorkByDes(String description){
        String sql = "select * from work where description like '%"+description+"%' and state='未完成'";
        return getList(sql);
    }

    //模糊查找已完成任务
    public List<Work> findDoneWorkByDes(String description){
        String sql = "select * from work where description like '%"+description+"%' and state='已完成'";
        return getList(sql);
    }


    //添加任务
    public void addWork(Work work){
        String sql = "insert into work(description,state,listId) values(?,?,?)";
        int i = 0;
        try {
            i = queryRunner.update(sql,work.getDescription(),work.getState(),work.getListId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(i);
    }

    //删除任务
    public void deleteWork(Integer id){
        String sql = "delete from work where id="+id;
        int i = 0;
        try {
            i = queryRunner.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(i);
    }

    //修改任务状态
    public void updateWorkState(Work work){
        String state = work.getState().equals("'未完成'")?"已完成":"未完成";
        System.out.println(work.getState());
        System.out.println(state);
        String sql = "update work set state=? where id=?";
        int i = 0;
        try {
            i = queryRunner.update(sql,state,work.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(i);
    }
}
