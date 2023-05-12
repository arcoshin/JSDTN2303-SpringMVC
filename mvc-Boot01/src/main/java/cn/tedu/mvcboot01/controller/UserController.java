package cn.tedu.mvcboot01.controller;

import cn.tedu.mvcboot01.pojo.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
    /**
     * 服務端獲取數據的第一種方式
     */
//    @RequestMapping("/v1/users/login")
//    @ResponseBody
//    public String userLogin(HttpServletRequest request){
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        return "用入登入成功:" + username + "," + password;
//    }

    /**
     * 服務端獲取數據的第二種方式:聲明參數獲取
     */
//    @RequestMapping("/v1/users/login")
//    @ResponseBody
//    public String userLogin(String username,String password){//直接對應<input>的name屬性
//        return "用入登入成功 : username=" + username + "&password=" + password;
//    }

    /**
     * 服務端獲取數據的第三種方式:聲明Pojo類---DTO(通常建議參數數量不大於三時使用)
     * 服務器--->客戶端
     */
    @RequestMapping("/v1/users/login")
    @ResponseBody
    public String userLogin(UserDTO userDTO){
        String username = userDTO.getUsername();
        String password = userDTO.getPassword();
        return "(username,password) = (" + username + "," + password + ")" ;
    }

}
