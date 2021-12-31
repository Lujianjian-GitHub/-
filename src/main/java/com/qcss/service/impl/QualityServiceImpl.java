package com.qcss.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qcss.dao.QualityDao;
import com.qcss.pojo.Quality;
import com.qcss.service.QualityService;
import com.qcss.util.InsertByExcel;
import com.qcss.util.InsertExcelInfo;
import com.qcss.util.Remassge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class QualityServiceImpl implements QualityService {
    @Autowired
    QualityDao qualityDao;

    /**
     * 素质学分
     */
    @Override
    public Remassge qualityInsert(Quality quality) {
        Remassge remassge = new Remassge();
        if ("".equals(quality.getThreeClass()))
            quality.setThreeClass("无");
        if (quality.getLevel() == null)
            quality.setLevel(0);
        if (quality.getGrade() == null)
            quality.setGrade(0);
        if (quality.getType() == null)
            quality.setType(0);
        try {
            qualityDao.insertQuality(quality);
            remassge.setMsg(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return remassge;
    }

    @Override
    public Remassge qualityInsertWithExcel(MultipartFile file) {
        Remassge remassge = new Remassge();
        String realPath = "D:" + File.separator + "qcss" +
                File.separator + "insertSpace";
        String newFilename = String.valueOf(System.currentTimeMillis()) + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        List<Quality> qualityList;
        int flag = -1;
        //创建文件夹
        File fileDir = new File(realPath);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
            System.out.println("创建成功！");
        } else {
            System.out.println("已经存在");
        }
        try {
            file.transferTo(new File(realPath, newFilename));
            flag = 1;
            System.out.println("文件保存成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (flag == 1) {
            try {
                qualityList = InsertByExcel.qualityExcel(new File(realPath + File.separator + newFilename));
                System.out.println("获取信息成功");
                InsertExcelInfo insertExcelInfo = new InsertExcelInfo();
                insertExcelInfo.setAll(qualityList.size());
                for (int i = 0; i < qualityList.size(); i++) {
                    try {
                        qualityDao.insertQuality(qualityList.get(i));
                        insertExcelInfo.setOk(insertExcelInfo.getOk() + 1);
                    }catch (Exception e){
                        e.printStackTrace();
                        insertExcelInfo.setDone(insertExcelInfo.getDone() + 1);
                    }
                    System.out.println(qualityList.get(i).toString());
                }
                remassge.setMsg(1);
                remassge.setData(insertExcelInfo);
            } catch (Exception e) {
                e.printStackTrace();
                remassge.setMsg(3);
            }finally {
                File deleteFile = new File(realPath + File.separator + newFilename);
                if(deleteFile.exists()){
                    //执行删除操作
                    deleteFile.delete();
                    System.out.println("已删除！");
                }else{
                    System.out.println("文件不存在");
                }
            }
        }
        return remassge;
    }

    @Override
    public Remassge qualityDelete(List<Quality> qualityList) {
        Remassge remassge = new Remassge();
        try {
            qualityDao.deleteQuality(qualityList);
            remassge.setMsg(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return remassge;
    }

    @Override
    public Remassge qualityUpdate(Quality quality) {
        Remassge remassge = new Remassge();
        try {
            qualityDao.updateQuality(quality);
            remassge.setMsg(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return remassge;
    }

    @Override
    public Remassge qualitySelect(Integer page, Integer limit, Quality quality) {
        Remassge remassge = new Remassge();
        try {
            PageHelper.startPage(page, limit);
            List<Quality> qualityList = qualityDao.selectQuality(quality);
            PageInfo<Quality> pageInfo = new PageInfo<>(qualityList);
            remassge.setMsg(1);
            remassge.setCount(pageInfo.getTotal());
            remassge.setData(pageInfo.getList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return remassge;
    }

    //查询主类别

    @Override
    public Remassge qualitySelectDistinctOneClass(Quality quality) {
        Remassge remassge = new Remassge();
        List<Quality> qualityList;
        try {
            qualityList = qualityDao.selectDistinctOneClassQuality(quality);
            remassge.setMsg(1);
            remassge.setData(qualityList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return remassge;
    }

    @Override
    public Remassge qualitySelectDistinctTwoClass(Quality quality) {
        Remassge remassge = new Remassge();
        List<Quality> qualityList;
        try {
            qualityList = qualityDao.selectDistinctTwoClassQuality(quality);
            remassge.setMsg(1);
            remassge.setData(qualityList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return remassge;
    }

    @Override
    public Remassge qualitySelectDistinctThreeClass(Quality quality) {
        Remassge remassge = new Remassge();
        List<Quality> qualityList;
        try {
            qualityList = qualityDao.selectDistinctThreeClassQuality(quality);
            remassge.setMsg(1);
            remassge.setData(qualityList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return remassge;
    }

    @Override
    public Remassge qualitySelectDistinctLevel(Quality quality) {
        Remassge remassge = new Remassge();
        List<Quality> qualityList;
        try {
            qualityList = qualityDao.selectDistinctLevelQuality(quality);
            remassge.setMsg(1);
            remassge.setData(qualityList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return remassge;
    }

    @Override
    public Remassge qualitySelectDistinctGrade(Quality quality) {
        Remassge remassge = new Remassge();
        List<Quality> qualityList;
        try {
            qualityList = qualityDao.selectDistinctGradeQuality(quality);
            remassge.setMsg(1);
            remassge.setData(qualityList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return remassge;
    }

    @Override
    public Remassge qualitySelectDistinctType(Quality quality) {
        Remassge remassge = new Remassge();
        List<Quality> qualityList;
        try {
            qualityList = qualityDao.selectDistinctTypeQuality(quality);
            remassge.setMsg(1);
            remassge.setData(qualityList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return remassge;
    }
}
