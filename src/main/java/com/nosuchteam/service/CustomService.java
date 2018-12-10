package com.nosuchteam.service;

import com.nosuchteam.bean.Custom;
import com.nosuchteam.bean.RequestList;

import java.util.List;

/**
 * yuexia
 * 2018/12/6
 * 23:20
 */
public interface CustomService {
    List<Custom> findCustomList(RequestList requestList);
    int  findTotalCustomNum( );
    List<Custom> findAllCustom();
    Custom selectByPrimaryKey(String customId);

    int insertNewCustrom(Custom custom);

    int updateByPrimaryKeySelective(Custom custom);

    int deleteByPrimaryKey(String ids);
}
