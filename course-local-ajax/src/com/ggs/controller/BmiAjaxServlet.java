package com.ggs.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// servlet
public class BmiAjaxServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收参数
        String strName = request.getParameter("name");
        String weight = request.getParameter("w");
        String height = request.getParameter("h");
        //计算bmi
        Float h = Float.valueOf(height);
        Float w = Float.valueOf(weight);
        Float bmi = w / (h * h);
        //判断bmi的范围
        String msg = null;
        if (bmi <= 18.5) {
            msg = "您比较瘦";
        } else if (bmi > 18.5 && bmi <= 23.9) {
            msg = "你的bmi是正常的";
        } else if (bmi > 24 && bmi <= 27) {
            msg = "你的身体比较胖";
        } else {
            msg = "你的身体肥胖";
        }
        msg = "您好：" + strName + "先生/女士, 您的bmi值是：" + bmi + "," + msg;
        //响应ajax需要的数据，使用HttpServletResponse输出数据
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.println(msg);
        pw.flush();
        pw.close();
    }
}
