package com.company.dao;

import com.company.utils.domain.Admin;

public interface AdminDao
{
    public Admin getAdminByNameByPass(String adminName,String password);
}
