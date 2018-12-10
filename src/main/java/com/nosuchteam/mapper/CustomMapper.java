package com.nosuchteam.mapper;

import com.nosuchteam.bean.Custom;
import com.nosuchteam.bean.RequestList;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CustomMapper {
    int deleteByPrimaryKey(String customId);

    int insert(Custom record);

    int insertSelective(Custom record);

    Custom selectByPrimaryKey(String customId);

    int updateByPrimaryKeySelective(Custom record);

    int updateByPrimaryKey(Custom record);

    List<Custom> findCustomList(@Param("limit") int limit, @Param("offset") int offset);

    @Select("select count(*) from `custom`;")
    int findTotalCustomer();

    List<Custom> findALLCustomer();
}