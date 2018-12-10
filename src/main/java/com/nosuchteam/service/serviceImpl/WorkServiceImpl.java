package com.nosuchteam.service.serviceImpl;

import com.nosuchteam.bean.RequestList;
import com.nosuchteam.bean.Work;
import com.nosuchteam.mapper.WorkMapper;
import com.nosuchteam.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * yuexia
 * 2018/12/9
 * 22:01
 */
@Service
public class WorkServiceImpl implements WorkService {
    @Autowired
    WorkMapper workMapper;
    public List<Work> findWrokList(RequestList requestList) {
        List<Work> customList = workMapper.findWorkList(requestList.getRows(), (requestList.getPage() - 1) * requestList.getRows());
        return customList;
    }
    public int findTotalWorkNum() {
        return workMapper.findTotalWork();
    }

    public List<Work> findAllWork() {
        return workMapper.findAllWork();
    }

    public Work selectByPrimaryKey(String customId) {
        return workMapper.selectByPrimaryKey(customId);
    }

    public int insertNewWork(Work work) {
        return workMapper.insert(work);
    }

    public int updateByPrimaryKeySelective(Work work) {
        return workMapper.updateByPrimaryKey(work);
    }

    public int deleteByPrimaryKey(String ids) {
        return workMapper.deleteByPrimaryKey(ids);
    }
}
