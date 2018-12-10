package com.nosuchteam.service;

import com.nosuchteam.bean.RequestList;
import com.nosuchteam.bean.Work;

import java.util.List;

/**
 * yuexia
 * 2018/12/9
 * 21:59
 */
public interface WorkService {
    List<Work> findWrokList(RequestList requestList);
    int  findTotalWorkNum( );
    List<Work> findAllWork();
    Work selectByPrimaryKey(String workId);

    int insertNewWork(Work custom);

    int updateByPrimaryKeySelective(Work custom);

    int deleteByPrimaryKey(String ids);
}
