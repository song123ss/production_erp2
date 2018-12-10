package com.nosuchteam;

import com.nosuchteam.bean.Order;
import com.nosuchteam.bean.OrderJson;
import com.nosuchteam.bean.RequestList;
import com.nosuchteam.mapper.OrderMapper;
import com.nosuchteam.service.OrderService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Date;
import java.util.List;

/**
 * yuexia
 * 2018/12/6
 * 16:19
 */
//记住这个测试用例，test下面的java文件夹设置成test的绿色文件夹
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@WebAppConfiguration
public class MyTest {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    OrderService orderService;
    @Test
    public void test1(){
        int totalOrder = orderMapper.findTotalOrder();
        Assert.assertNotNull(totalOrder);
    }
    @Test
    public void test2(){
        List<Order> orderList = orderMapper.findOrderList(2,3);
        System.out.println(orderList);
    }
    @Test
    public void test3(){
        RequestList requestList = new RequestList();
        requestList.setPage(1);
        requestList.setRows(5);
        OrderJson orderByJson = orderService.findOrderByJson(requestList);
    }
    @Test
    public void test4(){
        Order orderById = orderMapper.findOrderById();
        Date orderDate = orderById.getOrderDate();
        long time = orderDate.getTime();
    }
    @Test
    public void test5(){
        Order order = new Order();
        order.setOrderId("123456");
        int i = orderService.inserOrder(order);
        Assert.assertEquals(1,i);


    }
}
