package com.nosuchteam.controller;


import com.nosuchteam.bean.Order;
import com.nosuchteam.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



/**
 * yuexia
 * 2018/12/5
 * 22:05
 */
@Controller
public class CommonsController {
    @Autowired
    OrderService orderService;
    @RequestMapping("/{name}")
    public String forword(@PathVariable String name){
        return name;
    }
}
