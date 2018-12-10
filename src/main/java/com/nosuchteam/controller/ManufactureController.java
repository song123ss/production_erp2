package com.nosuchteam.controller;

import com.nosuchteam.bean.Manufacture;
import com.nosuchteam.bean.RequestList;
import com.nosuchteam.service.ManufactureService;
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
@RequestMapping("manufacture")
public class ManufactureController {
    @Autowired
    ManufactureService manufactureService;
    @RequestMapping("list")
    @ResponseBody
    public Map<String,Object> findManufactureList(RequestList requestList){
        List<Manufacture> rows = manufactureService.findManufactureList(requestList);
        int total = manufactureService.findTotalManufactureNum();
        HashMap<String, Object> map = new HashMap();
        map.put("total",total);
        map.put("rows",rows);
        return map;
    }
    @RequestMapping("get_data")
    @ResponseBody
    public List findManufactureList(){
        List<Manufacture> allManufacture = manufactureService.findAllManufacture();
        return allManufacture;
    }

    @RequestMapping("find")
    public String manufactureLocationController(){
        return "plan_scheduling/manufacture_list";
    }
    @RequestMapping("add_judge")
    @ResponseBody
    public String addManufacture(){

        return null;
    }
    @RequestMapping("add")
    public String showAddList(){
        return "plan_scheduling/manufacture_add";
    }
    @RequestMapping("get/{manufactureId}")
    @ResponseBody
    public Manufacture findManufacture(@PathVariable("manufactureId")String manufactureId){
        return manufactureService.selectByPrimaryKey(manufactureId);
    }
    @RequestMapping("insert")
    @ResponseBody
    public Map insertManufacture(Manufacture manufacture){
        HashMap<String, Object> map = new HashMap();
        int i = manufactureService.insertNewManufacture(manufacture);
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
        return "plan_scheduling/manufacture_edit";
    }

    @RequestMapping("update_all")
    @ResponseBody
    public Map updateManufacture(Manufacture manufacture){
        HashMap<Object, Object> map = new HashMap();
        int i = manufactureService.updateByPrimaryKeySelective(manufacture);
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
    public Map deleteManufacture(String  ids){
        HashMap<Object, Object> map = new HashMap();
        int i = manufactureService.deleteByPrimaryKey(ids);
        if (i==1){
            map.put("status",200);
            map.put("msg","OK");
            map.put("data",null);
            return map;
        }
        return null;
    }

}
