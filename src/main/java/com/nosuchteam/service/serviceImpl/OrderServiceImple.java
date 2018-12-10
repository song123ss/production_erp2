package com.nosuchteam.service.serviceImpl;

import com.nosuchteam.bean.Order;
import com.nosuchteam.bean.OrderJson;
import com.nosuchteam.bean.RequestList;
import com.nosuchteam.mapper.OrderMapper;
import com.nosuchteam.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * yuexia
 * 2018/12/6
 * 9:57
 */
@Service
public class OrderServiceImple implements OrderService {
    @Autowired
    OrderMapper orderMapper;
    public Order findOrder() {
        return orderMapper.findOrderById();
    }

    public OrderJson findOrderByJson(RequestList requestList) {
        OrderJson orderJson = new OrderJson();
        List<Order> orderList = orderMapper.findOrderList(requestList.getRows(), requestList.getRows()*(requestList.getPage()-1));
        int totalOrder = orderMapper.findTotalOrder();
        orderJson.setTotal(totalOrder);
        orderJson.setRows(orderList);
        return orderJson;
    }

    public int inserOrder(Order order) {
        return orderMapper.insert(order);
    }

    public int updateByPrimaryKeySelective(Order order) {
        return orderMapper.updateByPrimaryKeySelective(order);
    }

    public int deleteByPrimaryKey(String ids) {
        return orderMapper.deleteByPrimaryKey(ids);
    }
}
