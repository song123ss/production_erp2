package com.nosuchteam;

import com.nosuchteam.bean.Product;
import com.nosuchteam.service.ProductService;
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
 * 2018/12/7
 * 17:48
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@WebAppConfiguration
public class ProductTest {
    @Autowired
    ProductService productService;
    @Test
    public void test1(){
        List<Product> allProduct = productService.findAllProduct();
        Assert.assertNotNull(allProduct);
    }

}
