package com.nosuchteam;

import com.nosuchteam.bean.Custom;
import com.nosuchteam.bean.RequestList;
import com.nosuchteam.service.CustomService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * yuexia
 * 2018/12/6
 * 23:46
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@WebAppConfiguration
public class MyCustomTest {
    @Autowired
    CustomService customService;
    @Test
    public void test1(){
        RequestList requestList = new RequestList();
        requestList.setRows(4);
        requestList.setPage(2);
        List<Custom> customList = customService.findCustomList(requestList);
        Assert.assertNotNull(customList);
    }
    @Test
    public void test2(){
        int totalCustomNum = customService.findTotalCustomNum();
        Assert.assertNotNull(totalCustomNum);
    }
    @Test
    public void test3(){
        List<Custom> allCustom = customService.findAllCustom();
        Assert.assertNotNull(allCustom);
    }
    @Test
    public void test4(){
        Custom custom = customService.selectByPrimaryKey("001");
        System.out.println(custom);
    }
}
