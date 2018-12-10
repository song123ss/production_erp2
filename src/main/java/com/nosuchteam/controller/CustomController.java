package com.nosuchteam.controller;

import com.nosuchteam.bean.Custom;
import com.nosuchteam.bean.RequestList;
import com.nosuchteam.service.CustomService;
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
 * 2018/12/6
 * 23:15
 */
@Controller
@RequestMapping("custom")
public class CustomController {
    @Autowired
    CustomService customService;
    @RequestMapping("list")
    @ResponseBody
    public Map<String,Object> findCustomList(RequestList requestList){
        List<Custom> rows = customService.findCustomList(requestList);
        int total = customService.findTotalCustomNum();
        HashMap<String, Object> map = new HashMap();
        map.put("total",total);
        map.put("rows",rows);
        return map;
    }
    @RequestMapping("get_data")
    @ResponseBody
    public List findCustomList(){
        List<Custom> allCustom = customService.findAllCustom();
        return allCustom;
    }

    @RequestMapping("find")
    public String customLocationController(){
        return "plan_scheduling/custom_list";
    }
    @RequestMapping("add_judge")
    @ResponseBody
    public String addCustom(){

        return null;
    }
    @RequestMapping("add")
    public String showAddList(){
            return "plan_scheduling/custom_add";
    }
    @RequestMapping("get/{customId}")
    @ResponseBody
    public Custom findCustom(@PathVariable("customId")String customId){
        System.out.println(customId);

        return customService.selectByPrimaryKey(customId);
    }
    @RequestMapping("insert")
    @ResponseBody
    public Map insertCustom(Custom custom){
        HashMap<String, Object> map = new HashMap();
        int i = customService.insertNewCustrom(custom);
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
        return "plan_scheduling/custom_edit";
    }

    @RequestMapping("update_all")
    @ResponseBody
    public Map updateCustom(Custom custom){
        HashMap<Object, Object> map = new HashMap();
        int i = customService.updateByPrimaryKeySelective(custom);
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
    public Map deleteCustom(String  ids){
        HashMap<Object, Object> map = new HashMap();
        int i = customService.deleteByPrimaryKey(ids);
        if (i==1){
            map.put("status",200);
            map.put("msg","OK");
            map.put("data",null);
            return map;
        }
        return null;
    }
}
