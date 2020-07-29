package com.ggs.dao;

import com.ggs.entity.City;
import com.ggs.entity.Province;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QueryDao {
    Connection c = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    String className = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/springdb";
    String username = "root";
    String password = "a578173534";


    //查询所有的省份信息
    public List<Province> queryProvinceList() {

        String sql = "select id,name,jiancheng,shenghui from province order by id";

        Province p = null;
        List<Province> provinces = new ArrayList<>();
        try {
            Class.forName(className);
            c = DriverManager.getConnection(url, username, password);
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                p = new Province();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setJiancheng(rs.getString("jiancheng"));
                p.setShenghui(rs.getString("shenghui"));
                provinces.add(p);
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
        return provinces;
    }

    //查询一个省份下面的所有城市
    public List<City> queryCityList(Integer provinceId) {

        String sql = "select id,name from city where provinceId = ?";

        City city = null;
        List<City> cities = new ArrayList<>();
        try {
            Class.forName(className);
            c = DriverManager.getConnection(url, username, password);
            ps = c.prepareStatement(sql);
            //设置省份的参数值
            ps.setInt(1, provinceId);
            rs = ps.executeQuery();
            while (rs.next()) {
                city = new City();
                city.setId(rs.getInt("id"));
                city.setName(rs.getString("name"));
                cities.add(city);
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
        return cities;
    }
}
