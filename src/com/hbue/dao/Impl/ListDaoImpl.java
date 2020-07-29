package com.hbue.dao.Impl;

import com.hbue.model.AList;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class ListDaoImpl {

    //1.创建连接（c3p0连接池） 需要c3p0数据源
    QueryRunner queryRunner = new QueryRunner(new ComboPooledDataSource());

    //查找所有清单
    public List<AList> findAllList(){
        String sql = "select * from list";
        List<AList> lists = null;
        try {
            lists = queryRunner.query(sql,new BeanListHandler<>(AList.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("findAllList:"+lists);
        return lists;
    }

    //查找清单
    public AList findListById(Integer id){
        String sql = "select * from list where id="+id;
        AList aList = null;
        try {
            aList = queryRunner.query(sql,new BeanHandler<>(AList.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("findList:"+aList);
        return aList;
    }

    //添加清单
    public void addList(AList alist){
        String sql = "insert into list(name) values(?)";
        int i = 0;
        try {
            i = queryRunner.update(sql,alist.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(i);
    }

    //修改清单
    public void updateList(AList alist){
        String sql = "update list set name=? where id=?";
        int i = 0;
        try {
            i = queryRunner.update(sql,alist.getName(),alist.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(i);
    }

    //删除清单
    public void deleteList(Integer id){
        String sql = "delete from list where id="+id;
        int i = 0;
        try {
            i = queryRunner.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(i);
    }
}
