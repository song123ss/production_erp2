package com.nosuchteam.service;

import com.nosuchteam.bean.Order;
import com.nosuchteam.bean.OrderJson;
import com.nosuchteam.bean.RequestList;

/**
 * yuexia
 * 2018/12/6
 * 9:55
 */
public interface OrderService {
    Order findOrder();
    OrderJson findOrderByJson(RequestList requestList);

    int inserOrder(Order order);

    int updateByPrimaryKeySelective(Order order);

    int deleteByPrimaryKey(String ids);
}
