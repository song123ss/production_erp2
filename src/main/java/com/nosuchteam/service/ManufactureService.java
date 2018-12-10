package com.nosuchteam.service;

import com.nosuchteam.bean.Manufacture;
import com.nosuchteam.bean.RequestList;

import java.util.List;

/**
 * yuexia
 * 2018/12/9
 * 22:00
 */
public interface ManufactureService {
    List<Manufacture> findManufactureList(RequestList requestList);
    int  findTotalManufactureNum( );
    List<Manufacture> findAllManufacture();
    Manufacture selectByPrimaryKey(String manufactureId);

    int insertNewManufacture(Manufacture manufacture);

    int updateByPrimaryKeySelective(Manufacture manufacture);

    int deleteByPrimaryKey(String ids);
}
