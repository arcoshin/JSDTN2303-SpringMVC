package cn.tedu.mvccoolshark.controller;

import cn.tedu.mvccoolshark.mapper.ProductMapper;
import cn.tedu.mvccoolshark.pojo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class ProductController {
    @Autowired
    private ProductMapper productMapper;

    @RequestMapping("/v1/product/insert")
    public String insert(Product product){
        productMapper.insert(product);
        return "商品添加完成";
    }
}
