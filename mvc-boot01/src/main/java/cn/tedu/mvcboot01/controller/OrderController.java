package cn.tedu.mvcboot01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OrderController {
    //請求註解
    @RequestMapping("/selectOrder")
    //響應註解
    @ResponseBody
    public String order(){
        return "訂單查詢成功";
    }

    @RequestMapping("/deleteOrder")
    @ResponseBody
    public String deleteOrder(){
        return "訂單刪除成功";
    }

    @RequestMapping("/createOrder")
    @ResponseBody
    public String createOrder() {
        return "訂單新增成功";
    }

}
