package com.hbue.service.Impl;

import com.hbue.dao.Impl.ListDaoImpl;
import com.hbue.model.AList;

import java.util.List;

public class ListServiceImpl {

    private ListDaoImpl listDao = new ListDaoImpl();

    public List<AList> findAllList(){
        return listDao.findAllList();
    }

    public AList findListById(Integer id){
        return listDao.findListById(id);
    }

    public void addList(AList alist){
        listDao.addList(alist);
    }

    public void updateList(AList alist){
        listDao.updateList(alist);
    }

    public void deleteList(Integer id){
        listDao.deleteList(id);
    }
}
