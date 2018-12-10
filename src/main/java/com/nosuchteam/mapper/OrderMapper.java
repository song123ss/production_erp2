package com.nosuchteam.mapper;

import com.nosuchteam.bean.Order;
import com.nosuchteam.bean.OrderExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper {
    long countByExample(OrderExample example);

    int deleteByExample(OrderExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExample(OrderExample example);

    Order selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
    Order findOrderById();
    List<Order> findOrderList(@Param("limit") Integer row, @Param("offset") Integer offset);
    @Select("select count(*) from `c_order`;")
    int findTotalOrder();

    Order findOrder(String orderId);
}