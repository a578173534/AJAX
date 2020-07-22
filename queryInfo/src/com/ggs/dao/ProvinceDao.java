package com.ggs.dao;

import com.ggs.entity.Province;

import java.sql.*;

//使用jdbc访问数据库
public class ProvinceDao {
    //根据id获取名称
    public String queryProvinceNameById(Integer provinceId) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://localhost:3306/springdb";
        String user = "root";
        String password = "a578173534";

        String sql = "";
        String name = "";
        //加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection(url, user, password);
            //创建PreparedStatement
            sql = "select name from province where id = ?";
            ps = c.prepareStatement(sql);
            //设置参数值
            ps.setInt(1, provinceId);
            //执行sql
            rs = ps.executeQuery();
            //遍历rs
            while (rs.next()) { //当你的rs中有多余一条记录时。
                name = rs.getString("name");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (c != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return name;
    }

    //根据id获取一个完整的Province对象
    public Province queryProvinceById(Integer provinceId) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "";

        String url = "jdbc:mysql://localhost:3306/springdb";
        String user = "root";
        String password = "a578173534";

        Province province = null;
        //加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection(url, user, password);
            //创建PreparedStatement
            sql = "select id,name,jiancheng,shenghui from province where id = ?";
            ps = c.prepareStatement(sql);
            //设置参数值
            ps.setInt(1, provinceId);
            //执行sql
            rs = ps.executeQuery();
            //遍历rs
            while (rs.next()) { //当你的rs中有多余一条记录时。
                province = new Province(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("jiancheng"),
                        rs.getString("shenghui"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (c != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return province;
    }
}
