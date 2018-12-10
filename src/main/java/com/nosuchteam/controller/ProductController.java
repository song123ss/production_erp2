package com.nosuchteam.controller;

import com.nosuchteam.bean.Product;
import com.nosuchteam.bean.RequestList;
import com.nosuchteam.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * yuexia
 * 2018/12/7
 * 17:35
 */
@Controller
@RequestMapping("product")
public class ProductController {
    @Autowired
    ProductService productService;
    @RequestMapping("list")
    @ResponseBody
    public Map<String,Object> findProductList(RequestList requestList){
        List<Product> rows = productService.findProductList(requestList);
        int total = productService.findTotalProductNum();
        HashMap<String, Object> map = new HashMap();
        map.put("total",total);
        map.put("rows",rows);
        return map;
    }
    @RequestMapping("get_data")
    @ResponseBody
    public List findProductList(){
        List<Product> allProduct = productService.findAllProduct();
        return allProduct;
    }

    @RequestMapping("find")
    public String productLocationController(){
        return "plan_scheduling/product_list";
    }
    @RequestMapping("add_judge")
    @ResponseBody
    public String addProduct(){

        return null;
    }
    @RequestMapping("add")
    public String showAddList(){
        return "plan_scheduling/product_add";
    }
    @RequestMapping("get/{productId}")
    @ResponseBody
    public Product findProduct(@PathVariable("productId")String productId){
        System.out.println(productId);

        return productService.selectByPrimaryKey(productId);
    }
    @RequestMapping("insert")
    @ResponseBody
    public Map insertProduct(Product product){
        HashMap<String, Object> map = new HashMap();
        int i = product.inserNewProduct(product);
        if (i==1){
            map.put("staus",200);
            map.put("msg","ok");
            map.put("data",null);
        } return map;
    }
    @RequestMapping("edit_judge")
    @ResponseBody
    public Map editJudge(){
        HashMap<Object, Object> map = new HashMap();
        return map;
    }
    @RequestMapping("edit")
    public String editpage(){
        return "plan_scheduling/product_edit";
    }

    @RequestMapping("update_all")
    @ResponseBody
    public Map updateProduct(Product product){
        HashMap<Object, Object> map = new HashMap();
        int i = productService.updateByPrimaryKeySelective(product);
        if (i==1){
            map.put("status",200);
            map.put("msg","OK");
            map.put("data",null);
            return map;
        }
        return null;
    }
    @RequestMapping("delete_judge")
    @ResponseBody
    public Map deleteJudge(){
        HashMap<Object, Object> map = new HashMap();
        return map;
    }
    @RequestMapping("delete_batch")
    @ResponseBody
    public Map deleteProduct(String  ids){
        HashMap<Object, Object> map = new HashMap();
        int i = productService.deleteByPrimaryKey(ids);
        if (i==1){
            map.put("status",200);
            map.put("msg","OK");
            map.put("data",null);
            return map;
        }
        return null;
    }
}
