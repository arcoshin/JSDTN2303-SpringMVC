package cn.tedu.weibo.controller;

import cn.tedu.weibo.mapper.WeiboMapper;
import cn.tedu.weibo.pojo.dto.WeiboDTO;
import cn.tedu.weibo.pojo.entity.Weibo;
import cn.tedu.weibo.pojo.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;

@RestController
@RequestMapping("/v1/weibo/")
public class WeiboController {
    @Autowired(required = false)
    private WeiboMapper weiboMapper;

    @RequestMapping("insert")
    public int insert(@RequestBody WeiboDTO weiboDTO, HttpSession session) {//前到後->DTO
        //先驗證登入狀態
        UserVO userVO = (UserVO) session.getAttribute("user");
        if (userVO == null) {//沒有登入狀態(或者登入狀態已過期)
            return 2;//尚未登入
        }

        Weibo weibo = new Weibo();
        BeanUtils.copyProperties(weiboDTO,weibo);
        //補齊參數
        weibo.setCreated(new Date());
        weibo.setUid(userVO.getId());
        weiboMapper.insert(weibo);
        return 1;
    }
}
