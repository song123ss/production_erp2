package com.nosuchteam.service.serviceImpl;

import com.nosuchteam.bean.RequestList;
import com.nosuchteam.bean.Task;
import com.nosuchteam.mapper.TaskMapper;
import com.nosuchteam.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * yuexia
 * 2018/12/9
 * 22:01
 */
@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskMapper taskMapper;
    public List<Task> findTaskList(RequestList requestList) {
        List<Task> taskList = taskMapper.findTaskList(requestList.getRows(), (requestList.getPage() - 1) * requestList.getRows());
        return taskList;
    }
    public int findTotalTaskNum() {
        return taskMapper.findTotalTask();
    }

    public List<Task> findAllTask() {
        return taskMapper.findALLTask();
    }

    public Task selectByPrimaryKey(String taskId) {
        return taskMapper.selectByPrimaryKey(taskId);
    }

    public int insertNewTask(Task task) {
        return taskMapper.insert(task);
    }

    public int updateByPrimaryKeySelective(Task task) {
        return taskMapper.updateByPrimaryKey(task);
    }

    public int deleteByPrimaryKey(String ids) {
        return taskMapper.deleteByPrimaryKey(ids);
    }
}
