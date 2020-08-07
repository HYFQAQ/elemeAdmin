package com.company.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

//druid连接池工具类
public class JDBCutils
{
    //  定义成员变量DataSource， 可以切换不同的连接池
    private static DataSource ds;
    //初始化配置
    static
    {
        try
        {
            //1.加载配置文件
            Properties properties = new Properties();
            properties.load(JDBCutils.class.getClassLoader().getResourceAsStream("druid.properties"));
            //2.获取 定义成员变量DataSource
            ds = DruidDataSourceFactory.createDataSource(properties);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    //获取连接
    public static Connection getConnection() throws SQLException
    {
        return ds.getConnection();
    }
    //释放资源
    public static void close(Statement stmt, Connection conn)
    {
//        if (stmt != null)
//            try
//            {
//                stmt.close();
//            }
//            catch (SQLException e)
//            {
//                e.printStackTrace();
//            }
//        if (conn != null)
//            try
//            {
//                conn.close();
//            }
//            catch (SQLException e)
//            {
//                e.printStackTrace();
//            }
        close(stmt,conn,null);
    }
    public static void close(Statement stmt, Connection conn, ResultSet resultSet)
    {
        if (stmt != null)
            try
            {
                stmt.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        if (conn != null)
            try
            {
                conn.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        if (resultSet != null)
        {
            try
            {
                resultSet.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }
    //获取连接池方法
    public static DataSource getDataSource()
    {
        return ds;
    }
}
