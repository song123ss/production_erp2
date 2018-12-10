package com.nosuchteam.controller;

import com.nosuchteam.bean.Order;
import com.nosuchteam.bean.Product;
import com.nosuchteam.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * yuexia
 * 2018/12/6
 * 11:39
 */
@Controller
public class findController {
    @Autowired
    OrderService orderService;
    @RequestMapping("order/{action}")
    public String orderLocationController(@PathVariable ("action") String action){
        if (action.equals("find")){
            return "plan_scheduling/order_list";
        }else if (action.equals("add")){
            return "plan_scheduling/order_add";
        }else if (action.equals("edit")){
            return "plan_scheduling/order_edit";
        }else return "home";
    }
    @ResponseBody
    @RequestMapping("Order/{action}")
    public Map orderActionCheck(@PathVariable("action") String action, Order order, HttpServletRequest request){
        HashMap<String, Object> map = new HashMap();
        if (action.equals("add_judge")){
            return map;
        }else if (action.equals("insert")){
            if (order!=null){
                int i = orderService.inserOrder(order);
                System.out.println(i);
                if (i==1){
                map.put("staus",200);
                map.put("msg","ok");
                map.put("data",null);
                } return map;
            }
        }else if (action.equals("edit_judge")){
            return map;
        }else if (action.equals("update_all")){
            int i = orderService.updateByPrimaryKeySelective(order);
            if (i==1){
                //{"status":200,"msg":"OK","data":null}
                map.put("status",200);
                map.put("msg","OK");
                map.put("data",null);
                return map;
            }
        }else if (action.equals("delete_judge")){
            //可以给返回一个空map
            return map;
        }else if (action.equals("delete_batch")){
            String ids = request.getParameter("ids");
            int i = orderService.deleteByPrimaryKey(ids);
            if (i==1){
                map.put("data","success");
                return map;
            }
        }
        return null;
    }
}

