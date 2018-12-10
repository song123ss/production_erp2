package com.nosuchteam.controller;

import com.nosuchteam.bean.Order;
import com.nosuchteam.bean.OrderJson;
import com.nosuchteam.bean.RequestList;
import com.nosuchteam.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * yuexia
 * 2018/12/6
 * 14:27
 */
@Controller
@RequestMapping("order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @RequestMapping("list")
    @ResponseBody
    public OrderJson findOrder(RequestList requestList){
        OrderJson orderByJson = orderService.findOrderByJson(requestList);
        return orderByJson;
    }
    @RequestMapping("insert")
    public boolean inserOrder(Order order, MultipartFile[] file, HttpServletRequest request){

        System.out.println(order.toString());
        for (MultipartFile mf: file
             ) {
            if (!mf.isEmpty()){
                System.out.println(mf.getName());
            }
        }


        return true;
    }


}
