package com.company.dao.Impl;

import com.company.dao.BusinessDao;
import com.company.domain.Business;
import com.company.utils.JDBCutils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BusinessDaoImpl implements BusinessDao
{
    Connection con = null;
    PreparedStatement psstmt = null;
    ResultSet rs = null;
    @Override
    public List<Business> listBusiness(String businessName, String businessAddress)
    {
        List<Business> list = new ArrayList<>();
        StringBuffer sql = new StringBuffer("select * from business where 1=1 ");
        if (businessName != null && !businessName.equals(""))
            //传入了商家名
            sql.append(" and businessName like '%").append(businessName).append("%'");
//        System.out.println(sql);
        if (businessAddress != null && !businessAddress.equals(""))
            //传入了商家名
            sql.append(" and businessAddress like'%").append(businessAddress).append("%'");
//        System.out.println(sql);

        try
        {
            con = JDBCutils.getConnection();
            psstmt = con.prepareStatement(sql.toString());
            rs = psstmt.executeQuery();
            while (rs.next())
            {
                Business business = new Business();
                business.setBussinessId(rs.getInt("businessId"));
                business.setPassword(rs.getString("password"));
                business.setBusinessName(rs.getString("businessName"));
                business.setBusinessAddress(rs.getString("businessAddress"));
                business.setBusinessExplain(rs.getString("businessExplain"));
                business.setStarPrice(rs.getDouble("starPrice"));
                business.setDeliveryPrice(rs.getDouble("deliveryPrice"));
                list.add(business);
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            JDBCutils.close(psstmt,con,rs);
        }
        return list;
    }

    @Override
    public Integer saveBusiness(String businessName)
    {
        int businessId = 0;
        //附带一个初始密码
        String sql = "insert into business (businessName,password)values(?,'123456')";

        try
        {
            con = JDBCutils.getConnection();
            psstmt = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            //可以在prepareStatement中设置返回自增站列的值
            psstmt.setString(1,businessName);
            psstmt.executeUpdate();
            //获取自增长的列
            rs = psstmt.getGeneratedKeys();
            if (rs.next())
            {
                businessId = rs.getInt(1);
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            JDBCutils.close(psstmt,con,rs);
        }
        return businessId;
    }

    @Override
    public void removeBusiness(Integer businessId)
    {
        String sql = "delete from business where businessId =?";
        try
        {
            con = JDBCutils.getConnection();
            psstmt = con.prepareStatement(sql);
            psstmt.setInt(1,businessId);
            psstmt.executeUpdate();

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            JDBCutils.close(psstmt,con,rs);
        }

    }
}
