package com.nosuchteam.service;

import com.nosuchteam.bean.Product;
import com.nosuchteam.bean.RequestList;

import java.util.List;

/**
 * yuexia
 * 2018/12/7
 * 17:41
 */
public interface ProductService {
    List<Product> findAllProduct();

    Product selectByPrimaryKey(String productId);



    List<Product> findProductList(RequestList requestList);

    int findTotalProductNum();


    int updateByPrimaryKeySelective(Product product);

    int deleteByPrimaryKey(String ids);
}
