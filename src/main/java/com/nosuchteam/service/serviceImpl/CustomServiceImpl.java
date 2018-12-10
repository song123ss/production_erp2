package com.nosuchteam.service.serviceImpl;

import com.nosuchteam.bean.Custom;
import com.nosuchteam.bean.RequestList;
import com.nosuchteam.mapper.CustomMapper;
import com.nosuchteam.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * yuexia
 * 2018/12/6
 * 23:23
 */
@Service
public class CustomServiceImpl implements CustomService {
    @Autowired
    CustomMapper customMapper;
    public List<Custom> findCustomList(RequestList requestList) {
        List<Custom> customList = customMapper.findCustomList(requestList.getRows(), (requestList.getPage() - 1) * requestList.getRows());
        return customList;
    }
    public int findTotalCustomNum() {
        return customMapper.findTotalCustomer();
    }

    public List<Custom> findAllCustom() {
        return customMapper.findALLCustomer();
    }

    public Custom selectByPrimaryKey(String customId) {
        return customMapper.selectByPrimaryKey(customId);
    }

    public int insertNewCustrom(Custom custom) {
        return customMapper.insert(custom);
    }

    public int updateByPrimaryKeySelective(Custom custom) {
        return customMapper.updateByPrimaryKey(custom);
    }

    public int deleteByPrimaryKey(String ids) {
        return customMapper.deleteByPrimaryKey(ids);
    }

}
