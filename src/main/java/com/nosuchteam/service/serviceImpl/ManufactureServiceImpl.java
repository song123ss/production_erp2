package com.nosuchteam.service.serviceImpl;

import com.nosuchteam.bean.Manufacture;
import com.nosuchteam.bean.RequestList;
import com.nosuchteam.mapper.ManufactureMapper;
import com.nosuchteam.service.ManufactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * yuexia
 * 2018/12/9
 * 22:01
 */
@Service
public class ManufactureServiceImpl implements ManufactureService {
    @Autowired
    ManufactureMapper manufactureMapper;
    public List<Manufacture> findManufactureList(RequestList requestList) {
        List<Manufacture> manufactureList = manufactureMapper.findManufactureList(requestList.getRows(), (requestList.getPage() - 1) * requestList.getRows());
        return manufactureList;
    }
    public int findTotalManufactureNum() {
        return manufactureMapper.findTotalManufacture();
    }

    public List<Manufacture> findAllManufacture() {
        return manufactureMapper.findALLManufacture();
    }

    public Manufacture selectByPrimaryKey(String manufactureId) {
        return manufactureMapper.selectByPrimaryKey(manufactureId);
    }

    public int insertNewManufacture(Manufacture manufacture) {
        return manufactureMapper.insert(manufacture);
    }

    public int updateByPrimaryKeySelective(Manufacture manufacture) {
        return manufactureMapper.updateByPrimaryKey(manufacture);
    }

    public int deleteByPrimaryKey(String ids) {
        return manufactureMapper.deleteByPrimaryKey(ids);
    }
}