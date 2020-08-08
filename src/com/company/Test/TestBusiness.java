package com.company.Test;

import com.company.dao.BusinessDao;
import com.company.dao.Impl.BusinessDaoImpl;

public class TestBusiness
{
    public static void main(String[] args)
    {
        BusinessDaoImpl dao = new BusinessDaoImpl();
        dao.listBusiness(null,null);
    }
}
