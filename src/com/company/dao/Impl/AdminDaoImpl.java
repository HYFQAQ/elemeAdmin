package com.company.dao.Impl;

import com.company.dao.AdminDao;
import com.company.utils.JDBCutils;
import com.company.utils.domain.Admin;

import java.sql.*;

public class AdminDaoImpl implements AdminDao
{
    private Connection con = null;
    private ResultSet rs = null;
    PreparedStatement pstmt = null;
    @Override
    public Admin getAdminByNameByPass(String adminName, String password)
    {
        Admin admin = null;
        String sql = "select * from admin where adminName = ? and password = ?";
        try
        {
            con = JDBCutils.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,adminName);
            pstmt.setString(2,password);
            rs = pstmt.executeQuery();
            while (rs.next())
            {
                admin = new Admin();
                admin.setAdminId(rs.getInt("adminId"));
                admin.setAdminName(rs.getString("adminName"));
                admin.setPassword(rs.getString("password"));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            JDBCutils.close(pstmt,con,rs);
        }
        return admin;
    }
}
