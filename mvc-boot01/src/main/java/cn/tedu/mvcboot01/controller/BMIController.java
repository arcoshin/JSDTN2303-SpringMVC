package cn.tedu.mvcboot01.controller;

import cn.tedu.mvcboot01.pojo.dto.BMIDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BMIController {

    @RequestMapping("/bmi")
    @ResponseBody
    public String bmi(BMIDTO bmidto) {
        double BMI = bmidto.getBMI();

        String result = "";

        if (BMI < 18.5) {
            result = "偏瘦";
        } else if (BMI < 24) {
            result = "正常";
        } else if (BMI < 27) {
            result = "微胖";
        } else {
            result = "過胖";
        }

        result = "你的身體質量指數BMI為" + BMI + ",屬於" + result;

        return result;
    }

}
