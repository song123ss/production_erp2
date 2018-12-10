package com.nosuchteam.service.serviceImpl;

import com.nosuchteam.bean.Product;
import com.nosuchteam.bean.RequestList;
import com.nosuchteam.mapper.ProductMapper;
import com.nosuchteam.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * yuexia
 * 2018/12/7
 * 17:44
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;
    public List<Product> findAllProduct() {
        List<Product> allProduct = productMapper.findAllProduct();
        return allProduct;
    }

    public Product selectByPrimaryKey(String productId) {
        return productMapper.selectByPrimaryKey(productId);
    }

    public List<Product> findProductList(RequestList requestList) {
        return productMapper.findProductList(requestList.getRows(), (requestList.getPage() - 1) * requestList.getRows());
    }

    public int findTotalProductNum() {
        return productMapper.findTotalProduct();
    }

    public int updateByPrimaryKeySelective(Product product) {
        return productMapper.updateByPrimaryKeySelective(product);
    }

    public int deleteByPrimaryKey(String ids) {
        return productMapper.deleteByPrimaryKey(ids);
    }
}
