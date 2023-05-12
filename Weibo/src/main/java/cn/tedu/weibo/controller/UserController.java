package cn.tedu.weibo.controller;

import cn.tedu.weibo.mapper.UserMapper;
import cn.tedu.weibo.pojo.dto.UserLoginDTO;
import cn.tedu.weibo.pojo.dto.UserRegDTO;
import cn.tedu.weibo.pojo.entity.User;
import cn.tedu.weibo.pojo.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/v1/users/")
public class UserController {
    //自動裝配
    @Autowired(required = false)
    private UserMapper userMapper;

    /**
     * 註冊
     */
    //@RequestBody企業常用註解，用以解析請求體類型
    @RequestMapping("reg")
    public int reg(@RequestBody UserRegDTO userRegDTO){
        //用戶端傳送進來的數據--->DTO類
        System.out.println("userRegDTO = " + userRegDTO);
        /**
         * 重複性驗證
         */
        //根據用戶名查詢用戶訊息:向服務端查詢數據--->VO類(來自服務器)
        UserVO userVO = userMapper.selectByUsername(userRegDTO.getUsername());
        if (userVO != null) {
            return 2;//用戶名已被占用
        }

        /**
         * 存入user表:儲存完整數據--->entity類(實體類)
         */
        //建立傳遞參數的容器(完整訊息所以應該使用實體類)
        User user = new User();
        //將DTO類中(來自用戶)的參數傳遞給Entity類
        BeanUtils.copyProperties(userRegDTO,user);
        user.setCreated(new Date());
        //編寫SQL語句將用戶數據存入user表
        userMapper.insert(user);
        return 1;
    }

    /**
     * 登入
     */
    @RequestMapping("login")
    public int login(@RequestBody UserLoginDTO userLoginDTO) {
        System.out.println("userLoginDTO = " + userLoginDTO);
        UserVO userVO = userMapper.selectByUsername(userLoginDTO.getUsername());

        if (userVO != null) {//用戶數據存在(非空)
            //判斷密碼
            if (userVO.getPassword().equals(userLoginDTO.getPassword())){
                return 1;//登入成功
            }
            return 2;//密碼錯誤登入失敗
        }
        return 3;//用戶不存在
    }

}
