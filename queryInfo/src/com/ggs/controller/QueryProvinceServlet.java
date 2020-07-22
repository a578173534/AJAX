package com.ggs.controller;

import com.ggs.dao.ProvinceDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.Printable;
import java.io.IOException;
import java.io.PrintWriter;

public class QueryProvinceServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理get请求
        String strProid = request.getParameter("proid");

        String name = "";
        //访问dao，查询数据库
        if (strProid != null && !"".equals(strProid.trim())) {
            //创建dao对象，调用它的方法
            ProvinceDao dao = new ProvinceDao();
            name = dao.queryProvinceNameById(Integer.valueOf(strProid));
        }
        //使用HttpServletResponse输出数据
        // servlet返回给浏览器的是 文本数据， 数据的编码是utf-8
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println(name);
        out.flush();
        out.close();
    }
}
