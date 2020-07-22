package com.ggs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ggs.entity.Province;

public class TestJson {
    public static void main(String[] args) {
        // 使用jackson 把java对象转为json格式的字符串
        Province p = new Province(1, "广东", "粤", "广州");
        //使用jackson 把 p 转为 json
        ObjectMapper om = new ObjectMapper();
        try {
            // writeValueAsString：把参数的java对象转为json格式的字符串
            String json = om.writeValueAsString(p);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
