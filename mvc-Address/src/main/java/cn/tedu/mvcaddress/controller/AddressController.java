package cn.tedu.mvcaddress.controller;

import cn.tedu.mvcaddress.mapper.AddressMapper;
import cn.tedu.mvcaddress.pojo.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/address/")
public class AddressController {
    @Autowired(required = false)
    private AddressMapper addressMapper;

    @RequestMapping("insert")
    public String insert(Address address) {
        addressMapper.insert(address);
        return "新增成功，點我回<a href='/index.html'>首頁</a>";
    }

    @RequestMapping("select")
    public String select() {
        List<Address> addressList = addressMapper.select();

        //1.定義字符串
        String html = "<table border='1'>";
        html += "<caption>員工列表</caption>";
        html += "<tr>" +
                "<th>案件編號</th>" +
                "<th>收件人員</th>" +
                "<th>收件地址</th>" +
                "<th>聯絡信箱</th>" +
                "<th>連絡電話</th>" +
                "<th>收件標籤</th>" +
                "<th>數據操作</th>" +
                "</tr>";

        //2.遍歷集合中的每一筆資料
        for (Address address: addressList) {
            html += "<tr>";
            html += "<td>" + address.getId() + "</td>";
            html += "<td>" + address.getReceiver() + "</td>";
            html += "<td>" + address.getAddress() + "</td>";
            html += "<td>" + address.getEmail() + "</td>";
            html += "<td>" + address.getMobile() + "</td>";
            html += "<td>" + address.getTag() + "</td>";
            // http://localhost:8080/delete?id=xxx
            html += "<td><a href='/address/delete?id=" + address.getId() + "'>删除</a></td>";
            html += "</tr>";
        }
        html += "</table>";


        //3.輸出整篇字符串類型的HTML內文
        return html;
    }

    @RequestMapping("delete")
    public String delete(Integer id) {
        addressMapper.delete(id);
        return "刪除成功，點我回<a href='/address/select'>列表</a>";
    }

    @RequestMapping("update")
    public String update(Address address) {
        addressMapper.update(address);
        return "修改成功，點我到<a href='/address/select'>列表</a>";
    }


}
