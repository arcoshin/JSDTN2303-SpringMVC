package cn.tedu.mvccoolshark.controller;

import cn.tedu.mvccoolshark.mapper.ProductMapper;
import cn.tedu.mvccoolshark.pojo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//自動將所有方法的返回值作為HTTP響應的內容，取代所有@ResponseBody註解
/*@Controller--->*/@RestController
//泛化抽取共同的路徑代碼，以下註解會自動與類註解當中的路徑拼接
@RequestMapping("/v1/product/")
public class ProductController {
    //消除誤報紅底線--->"required = false"--->裝配時就算false也沒關係
    @Autowired(required = false)
    private ProductMapper productMapper;

    /**
     * 添加一個商品
     */
    @RequestMapping("insert")
    public String insertProduct(Product product){
        productMapper.insert(product);
        return "商品添加完成";
    }

    /**
     * 展示商品列表
     */
    @RequestMapping("select")
    public String productList(){
        List<Product> productList = productMapper.productList();

//        return productList.toString();//能展示，但可讀性差

        /**
         * 拼接一整頁HTML的字符串
         */

        //1.定義html字符串
        String html = "<table border='1'>";
        html += "<caption>商品列表</caption>";
        html += "<tr>" +
                "<th>商品編號</th>" +
                "<th>商品名稱</th>" +
                "<th>商品價格</th>" +
                "<th>商品庫存</th>" +
                "<th>操作</th>" +
                "</tr>";

        // 2.遍歷每個商品對象，並將其添加到html標籤中
        for (Product p: productList) {
            html += "<tr>";
            html += "<td>" + p.getId() + "</td>";
            html += "<td>" + p.getTitle() + "</td>";
            html += "<td>" + p.getPrice() + "</td>";
            html += "<td>" + p.getNum() + "</td>";
            // http://localhost:8080/delete?id=xxx(刪除的請求路徑)
            html += "<td><a href='/v1/product/delete?id=" + p.getId() + "'>刪除</a></td>";
            html += "</tr>";
        }

        html += "</table>";

        // 3.返回html字符串
        return html;
    }

    /**
     * 刪除一個商品
     */
    @RequestMapping("delete")
    public String deleteProduct(int id) {
        productMapper.deleteProductById(id);
        return "刪除成功";
    }

    /**
     * 修改一個商品
     */
    @RequestMapping("update")
    public String updateProduct(Product product) {
        productMapper.updateProductById(product);
        return "修改成功";
    }


}
