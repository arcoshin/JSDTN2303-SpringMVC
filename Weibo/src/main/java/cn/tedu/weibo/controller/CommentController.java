package cn.tedu.weibo.controller;

import cn.tedu.weibo.mapper.CommentMapper;
import cn.tedu.weibo.pojo.dto.CommentDTO;
import cn.tedu.weibo.pojo.entity.Comment;
import cn.tedu.weibo.pojo.vo.CommentVO;
import cn.tedu.weibo.pojo.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/v1/comment/")
public class CommentController {
    @Autowired(required = false)
    private CommentMapper commentMapper;

    /**
     * 添加一條評論
     */
    @RequestMapping("insert")
    public int insert(@RequestBody CommentDTO commentDTO, HttpSession session) {
        System.out.println("commentDTO = " + commentDTO);
        UserVO userVO = (UserVO) session.getAttribute("user");
        if (userVO == null) {
            return 2;
        } else {
            //補齊參數
            Comment comment = new Comment();
            BeanUtils.copyProperties(commentDTO, comment);
            comment.setCreated(new Date());
            comment.setWid(commentDTO.getWeiboId());
            comment.setUid(userVO.getId());
            System.out.println("comment = " + comment);

            if (commentMapper.insert(comment) > 0) {
                return 1;
            } else {
                return 2;
            }
        }
    }

    /**
     * 於文章詳情頁中展示評論詳情
     */
    @RequestMapping("selectByWeiboId")
    public List<CommentVO> selectByWeiboId(Integer id){
        return commentMapper.selectByWeiboId(id);
    }

}
