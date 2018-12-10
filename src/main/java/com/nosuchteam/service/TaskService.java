package com.nosuchteam.service;

import com.nosuchteam.bean.RequestList;
import com.nosuchteam.bean.Task;

import java.util.List;

/**
 * yuexia
 * 2018/12/9
 * 21:59
 */
public interface TaskService {
    List<Task> findTaskList(RequestList requestList);
    int  findTotalTaskNum( );
    List<Task> findAllTask();
    Task selectByPrimaryKey(String taskId);

    int insertNewTask(Task task);

    int updateByPrimaryKeySelective(Task task);

    int deleteByPrimaryKey(String ids);
}
