package com.nosuchteam.controller;

import com.nosuchteam.bean.RequestList;
import com.nosuchteam.bean.Work;
import com.nosuchteam.service.WorkService;
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
 * 21:54
 */
@Controller
@RequestMapping("work")
public class WorkController {
    @Autowired
    WorkService workService;
    @RequestMapping("list")
    @ResponseBody
    public Map<String,Object> findWorkList(RequestList requestList){
        List<Work> rows = workService.findWrokList(requestList);
        int total = workService.findTotalWorkNum();
        HashMap<String, Object> map = new HashMap();
        map.put("total",total);
        map.put("rows",rows);
        return map;
    }
    @RequestMapping("get_data")
    @ResponseBody
    public List findWorkList(){
        List<Work> allWork = workService.findAllWork();
        return allWork;
    }

    @RequestMapping("find")
    public String workLocationController(){
        return "plan_scheduling/work_list";
    }
    @RequestMapping("add_judge")
    @ResponseBody
    public String addWork(){

        return null;
    }
    @RequestMapping("add")
    public String showAddList(){
        return "plan_scheduling/work_add";
    }
    @RequestMapping("get/{workId}")
    @ResponseBody
    public Work findwork(@PathVariable("workId")String workId){
        System.out.println(workId);

        return workService.selectByPrimaryKey(workId);
    }
    @RequestMapping("insert")
    @ResponseBody
    public Map insertWork(Work work){
        HashMap<String, Object> map = new HashMap();
        int i = workService.insertNewWork(work);
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
        return "plan_scheduling/work_edit";
    }

    @RequestMapping("update_all")
    @ResponseBody
    public Map updateWork(Work work){
        HashMap<Object, Object> map = new HashMap();
        int i = workService.updateByPrimaryKeySelective(work);
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
    public Map deleteWork(String  ids){
        HashMap<Object, Object> map = new HashMap();
        int i = workService.deleteByPrimaryKey(ids);
        if (i==1){
            map.put("status",200);
            map.put("msg","OK");
            map.put("data",null);
            return map;
        }
        return null;
    }
}
