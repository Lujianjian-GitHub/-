package com.qcss.service;

import com.qcss.pojo.Admin;
import com.qcss.pojo.Checker;
import com.qcss.util.Remassge;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CheckerService {
    public Remassge checkerInsert(Checker checker, Admin admin);
    public Remassge checkerInsertWithExcel(MultipartFile file, Admin admin);
    public Remassge checkerSelect(Integer page, Integer limit,Checker checker);
    public Remassge checkerDelete(List<Checker> checkerList);
    public Remassge checkerUpdate(Checker checker);
}
