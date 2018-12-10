package com.nosuchteam.controller;

import com.nosuchteam.bean.RequestList;
import com.nosuchteam.bean.Task;
import com.nosuchteam.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * yuexia
 * 2018/12/9
 * 21:57
 */
@Controller
@RequestMapping("task")
public class TaskController {
    @Autowired
    TaskService taskService;
    @RequestMapping("list")
    @ResponseBody
    public Map<String,Object> findTaskList(RequestList requestList){
        List<Task> rows = taskService.findTaskList(requestList);
        int total = taskService.findTotalTaskNum();
        HashMap<String, Object> map = new HashMap();
        map.put("total",total);
        map.put("rows",rows);
        return map;
    }
    @RequestMapping("get_data")
    @ResponseBody
    public List findTaskList(){
        List<Task> allTask = taskService.findAllTask();
        return allTask;
    }

    @RequestMapping("find")
    public String taskLocationController(){
        return "plan_scheduling/task_list";
    }
    @RequestMapping("add_judge")
    @ResponseBody
    public String addTask(){

        return null;
    }
    @RequestMapping("add")
    public String showAddList(){
        return "plan_scheduling/task_add";
    }
    @RequestMapping("get/{taskId}")
    @ResponseBody
    public Task findTask(@PathVariable("taskId")String taskId){
        return taskService.selectByPrimaryKey(taskId);
    }
    @RequestMapping("insert")
    @ResponseBody
    public Map insertTask(Task task){
        HashMap<String, Object> map = new HashMap();
        int i = taskService.insertNewTask(task);
        if (i==1){
            map.put("staus",200);
            map.put("msg","ok");
            map.put("data",null);
        } return map;
    }
    @RequestMapping("edit_judge")
    @ResponseBody
    public Map editJudge(){
        HashMap<Object, Object> map = new HashMap();
        return map;
    }
    @RequestMapping("edit")
    public String editpage(){
        return "plan_scheduling/task_edit";
    }

    @RequestMapping("update_all")
    @ResponseBody
    public Map updateTask(Task task){
        HashMap<Object, Object> map = new HashMap();
        int i = taskService.updateByPrimaryKeySelective(task);
        if (i==1){
            map.put("status",200);
            map.put("msg","OK");
            map.put("data",null);
            return map;
        }
        return null;
    }
    @RequestMapping("delete_judge")
    @ResponseBody
    public Map deleteJudge(){
        HashMap<Object, Object> map = new HashMap();
        return map;
    }
    @RequestMapping("delete_batch")
    @ResponseBody
    public Map deleteTask(String  ids){
        HashMap<Object, Object> map = new HashMap();
        int i = taskService.deleteByPrimaryKey(ids);
        if (i==1){
            map.put("status",200);
            map.put("msg","OK");
            map.put("data",null);
            return map;
        }
        return null;
    }

}
