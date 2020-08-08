package com.company.view.impl;

import com.company.dao.BusinessDao;
import com.company.dao.Impl.BusinessDaoImpl;
import com.company.domain.Business;
import com.company.view.BusinessView;

import java.util.List;
import java.util.Scanner;

public class BusinessViewImpl implements BusinessView
{
    private Scanner input = new Scanner(System.in);
    @Override
    public void listBusinessAll()
    {
        BusinessDaoImpl Dao = new BusinessDaoImpl();
        List<Business> list = Dao.listBusiness(null,null);
        System.out.println("商家编号\t商家名称\t商家地址\t商家介绍\t起送费\t配送费");
        for (Business b :list){
            System.out.println(b.getBussinessId()+"\t"+b.getBusinessName()+"\t"+b.getBusinessAddress()+"\t"+b.getBusinessExplain()+"\t"+b.getStarPrice()+"\t"+b.getDeliveryPrice());
        }
    }
    //搜索
    @Override
    public void listBusinessSearch()
    {
        String businessName = " ";
        String businessAdress = " ";
        String inputStr = "";
        System.out.println("是否需要输入商家名称关键字(Y/N):");
        inputStr = input.next();
        if (inputStr.equals("Y"))
        {
            System.out.println("请输入商家名称关键字:");
            businessName = input.next();
        }
        System.out.println("是否需要输入商家地址关键字(Y/N):");
        inputStr = input.next();
        if (inputStr.equals("Y"))
        {
            System.out.println("请输入商家地址关键字:");
            businessAdress = input.next();
        }
        BusinessDao Dao = new BusinessDaoImpl();
        List<Business> list = Dao.listBusiness(businessName,businessAdress);
        System.out.println("商家编号\t商家名称\t商家地址\t商家介绍\t起送费\t配送费");
        for (Business b :list){
            System.out.println(b.getBussinessId()+"\t"+b.getBusinessName()+"\t"+b.getBusinessAddress()+"\t"+b.getBusinessExplain()+"\t"+b.getStarPrice()+"\t"+b.getDeliveryPrice());
        }
    }
    //保存商家
    @Override
    public void saveBusiness()
    {
        System.out.println("请输入商家名");
        String businessName = input.next();

        BusinessDaoImpl dao = new BusinessDaoImpl();
        Integer businessId = dao.saveBusiness(businessName);
        if (businessId > 0)
        {
            System.out.println("新建商家成功，商家编号为："+businessId);
        }
        else
        {
            System.out.println("新建商家失败");
        }

    }

    @Override
    public void removeBusiness()
    {
        String inputStr = "";
        System.out.println("请输入商家编号");
        Integer businessId = Integer.valueOf(input.next());
        BusinessDaoImpl dao = new BusinessDaoImpl();
        System.out.println("确定要删除吗? (Y/N)");
        inputStr = input.next();
        if (inputStr.equals("Y"))
        {
            dao.removeBusiness(businessId);
        }

        if (businessId > 0)
        {
            System.out.println("删除成功");
        }
        else
        {
            System.out.println("删除失败");
        }
    }
}
