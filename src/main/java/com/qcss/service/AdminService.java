package com.qcss.service;

import com.qcss.pojo.Admin;
import com.qcss.util.Remassge;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AdminService {


    /**
     * 管理员
     */
    //添加管理员
    public Remassge adminInsert(Admin admin);
    public Remassge adminInsertWithExcel(MultipartFile file);
    public Remassge adminSelect(Integer page, Integer limit,Admin admin);
    public Remassge adminDelete(List<Admin> adminList);
    public Remassge adminUpdate(Admin admin);

}
