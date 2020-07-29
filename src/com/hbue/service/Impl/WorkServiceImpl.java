package com.hbue.service.Impl;

import com.hbue.dao.Impl.WorkDaoImpl;
import com.hbue.model.Work;

import java.util.List;

public class WorkServiceImpl {

    private WorkDaoImpl workDao = new WorkDaoImpl();

    public List<Work> findDoingWork(Integer listId){
        return workDao.findDoingWork(listId);
    }

    public List<Work> findDoneWork(Integer listId){
        return workDao.findDoneWork(listId);
    }

    public List<Work> findDoingWorkByDes(String description){
        return workDao.findDoingWorkByDes(description);
    }

    public List<Work> findDoneWorkByDes(String description){
        return workDao.findDoneWorkByDes(description);
    }

    public void addWork(Work work){
        workDao.addWork(work);
    }

    public void deleteWork(Integer id){
        workDao.deleteWork(id);
    }

    public void updateWorkState(Work work){
        workDao.updateWorkState(work);
    }

}
