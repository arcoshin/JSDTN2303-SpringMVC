package cn.tedu.mvcemp.controller;

import cn.tedu.mvcemp.mapper.EmpMapper;
import cn.tedu.mvcemp.pojo.entity.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/emp/")
public class EmpController {
    @Autowired(required = false)
    private EmpMapper empMapper;

    /**
     * 增
     */
    @RequestMapping("insert")
    public String insert(Emp emp){
        empMapper.insert(emp);
        return "新增員工成功!!<a href='/index.html'>點我回到首頁</a>";
    }

    /**
     * 查
     */
    @RequestMapping("select")
    public String select(){
        List<Emp> empList = empMapper.select();

        //1.定義字符串
        String html = "<table border='1'>";
        html += "<caption>員工列表</caption>";
        html += "<tr>" +
                "<th>員工編號</th>" +
                "<th>員工姓名</th>" +
                "<th>員工工資</th>" +
                "<th>員工職位</th>" +
                "<th>系統操作</th>" +
                "</tr>";

        //2.遍歷集合中的每一筆資料
        for (Emp emp: empList) {
            html += "<tr>";
            html += "<td>" + emp.getId() + "</td>";
            html += "<td>" + emp.getTitle() + "</td>";
            html += "<td>" + emp.getSalary() + "</td>";
            html += "<td>" + emp.getJob() + "</td>";
            // http://localhost:8080/delete?id=xxx
            html += "<td><a href='/emp/delete?id=" + emp.getId() + "'>删除</a></td>";
            html += "</tr>";
        }
        html += "</table>";


        //3.輸出整篇字符串類型的HTML內文
        return html;
    }

    /**
     * 刪
     */
    @RequestMapping("delete")
    public String delete(int id){
        empMapper.delete(id);
        return "數據已刪除!!<a href='/emp/select'>點我回到列表</a>";
    }

    /**
     * 改
     */
    @RequestMapping("update")
    public String update(Emp emp){
        empMapper.update(emp);
        return "數據更新成功!!<a href='/emp/select'>點我到列表</a>";
    }

}
