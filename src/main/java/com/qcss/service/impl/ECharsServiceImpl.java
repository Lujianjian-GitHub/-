package com.qcss.service.impl;

import com.qcss.dao.*;
import com.qcss.pojo.*;
import com.qcss.service.ECharsService;
import com.qcss.util.QualityClass;
import com.qcss.util.Remassge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ECharsServiceImpl implements ECharsService {
    @Autowired
    SeriesDao seriesDao;
    @Autowired
    StudentDao studentDao;
    @Autowired
    CheckerDao checkerDao;
    @Autowired
    AdminDao adminDao;
    @Autowired
    QualityDataDao qualityDataDao;
    @Autowired
    ClassDao classDao;
    @Override
    public Remassge getSeriesData() {
        Remassge remassge = new Remassge();
        Map data = new HashMap();
        //获取院系数量
        try{
            data.put("seriesCount",seriesDao.countSeries());
        }catch (Exception e){
            e.printStackTrace();
            data.put("seriesCount",0);
        }
        //获取学生数量
        try{
            data.put("studentCount",studentDao.countStudent(null));
        }catch (Exception e){
            e.printStackTrace();
            data.put("studentCount",0);
        }
        //获取审核员数量
        try{
            data.put("checkerCount",checkerDao.countChecker(null));
        }catch (Exception e){
            e.printStackTrace();
            data.put("checkerCount",0);
        }
        //获取管理员员数量
        try{
            data.put("adminCount",adminDao.countAdmin(null));
        }catch (Exception e){
            e.printStackTrace();
            data.put("adminCount",0);
        }
        //获取系中个人员数量
        try {
            List<Series> seriesList = seriesDao.selectSeries(null);
            String[] seriesName = new String[seriesList.size()];
            Long[] seriesStudent = new Long[seriesList.size()];
            Long[] seriesChecker = new Long[seriesList.size()];
            Long[] seriesAdmin = new Long[seriesList.size()];
            Student student = new Student();
            Checker checker = new Checker();
            Admin admin = new Admin();
            for (int i = 0; i < seriesList.size(); i++) {
                seriesName[i] = seriesList.get(i).getName();
                student.setSeriesId(seriesList.get(i).getSeriesId());
                seriesStudent[i] = studentDao.countStudent(student);
                checker.setSeriesId(seriesList.get(i).getSeriesId());
                seriesChecker[i] = checkerDao.countChecker(checker);
                admin.setSeriesId(seriesList.get(i).getSeriesId());
                seriesAdmin[i] = adminDao.countAdmin(admin);
            }
            data.put("seriesName",seriesName);
            //过获取各个院系的学生人数
            data.put("seriesStudent",seriesStudent);
            //获取各个院系审核人员人数
            data.put("seriesChecker",seriesChecker);
            data.put("seriesAdmin",seriesAdmin);
        }catch (Exception e){
            e.printStackTrace();
        }
        remassge.setData(data);
        return remassge;
    }

    @Override
    public Remassge getStudentData(QualityData qualityData) {
        Remassge remassge = new Remassge();
        Map data = new HashMap();
        Map[] qualityDatas = new Map[6];
        try {
            //预计得分：所用的申请项的总分
            QualityData qualityData1 = qualityDataDao.selectGetStudentData(qualityData);
            data.put("proSum",qualityData1.getSumData());
            data.put("upCount",qualityData1.getCountData());
//            System.out.println(qualityData1.toString());
            //实际得分：通过的申请项的总分，求总分
            qualityData.setCheckStatus(1);
            qualityData1 = qualityDataDao.selectGetStudentData(qualityData);
            data.put("trueSum",qualityData1.getSumData());
            data.put("passCount",qualityData1.getCountData());
//            System.out.println(qualityData1.toString());
            //申请总数：求个数
            //通过总数：求个数
            //各类得分情况Map：各个通过的总分
            for (int i = 0; i < 6; i++) {
                Map quality = new HashMap();
                qualityData.setOneClass(i+1);
                qualityData1 = qualityDataDao.selectGetStudentData(qualityData);
                quality.put("value",qualityData1.getSumData());
                quality.put("name",QualityClass.qualityClass[i]);
                qualityDatas[i] = quality;
            }
            data.put("qualityData",qualityDatas);
            remassge.setData(data);
            remassge.setMsg(1);
//            System.out.println(remassge.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
        return remassge;
    }

    @Override
    public Remassge getCheckerData(ClassInfo classInfo) {
        Remassge remassge = new Remassge();
        Map data = new HashMap();
        int classCount = 0;
        int studentCount = 0;
        int uncheckCount = 0;
        int upCount = 0;
        String[] classInfos;
        int[] uncheck;
        int[] unPass;
        int[] pass;
        try{
            List<ClassInfo> classInfoList = classDao.selectClassInfo(classInfo);
            //获取管理的班级数量
            classCount = classInfoList.size();
            data.put("classCount",classCount);
            if (classCount > 0 ){
                classInfos = new String[classCount];
                uncheck = new int[classCount];
                unPass = new int[classCount];
                pass = new int[classCount];
                for (int i = 0; i < classInfoList.size(); i++) {
                    int selectUncheck;
                    int selectUnPass;
                    int selectPass;
                    //获取班级信息
                    classInfos[i] = classInfoList.get(i).getYear()+"届"+classInfoList.get(i).getClassId()+"班";
                    Student student = new Student();
                    student.setYear(classInfoList.get(i).getYear());
                    student.setClassId(classInfoList.get(i).getClassId());
                    //获取学生数量
                    studentCount += studentDao.selectStudentCount(student);
                    //获取申请的数量
                    upCount += qualityDataDao.selectGetCheckerData(student);
                    //获取未审核的数量
                    student.setCheckStatus(2);
                    selectUncheck = qualityDataDao.selectGetCheckerData(student);
                    uncheckCount += selectUncheck;//所用班级未审核的数量
                    uncheck[i] = selectUncheck;
                    //未通过审核
                    student.setCheckStatus(-1);
                    selectUnPass = qualityDataDao.selectGetCheckerData(student);
                    unPass[i] = selectUnPass;
                    //通过的数量
                    student.setCheckStatus(1);
                    selectPass = qualityDataDao.selectGetCheckerData(student);
                    pass[i] = selectPass;
                }
                data.put("studentCount",studentCount);
                data.put("uncheckCount",uncheckCount);
                data.put("upCount",upCount);
                data.put("classInfos",classInfos);
                data.put("uncheck",uncheck);
                data.put("unPass",unPass);
                data.put("pass",pass);
            }else{
                data.put("studentCount",0);
                data.put("uncheckCount",0);
                data.put("upCount",0);
                data.put("classInfos",null);
                data.put("uncheck",0);
                data.put("unPass",0);
                data.put("pass",0);
            }
            remassge.setData(data);
        }catch (Exception e){
            e.printStackTrace();
        }
        return remassge;
    }

    @Override
    public Remassge getAdminData(Admin admin) {
        ClassInfo classInfo = new ClassInfo();
        classInfo.setAdminId(admin.getAdminId());
        Checker checker = new Checker();
        checker.setAdminId(admin.getAdminId());
        Remassge remassge = new Remassge();
        Map data = new HashMap();
        int myClassCount = 0;
        int seriesClassCount = 0;
        int studentAllCount = 0;
        int myCheckerCount = 0;
        String[] classInfos;
        int[] oneClassStudentCounts;

        //我的审核人员
        try{
            List<Checker> checkerList = checkerDao.selectChecker(checker);
            myCheckerCount = checkerList.size();
        }catch (Exception e){
            e.printStackTrace();
            myCheckerCount = 0;
        }finally {
            data.put("myCheckerCount",myCheckerCount);
        }
        try {
            //我管理的班级数量
            List<ClassInfo> classInfoList = classDao.selectClassInfo(classInfo);
            myClassCount = classInfoList.size();
            classInfos = new String[classInfoList.size()];
            oneClassStudentCounts = new int[classInfoList.size()];
            for (int i = 0; i < classInfoList.size(); i++) {
                classInfos[i] = classInfoList.get(i).getYear()+"届"+classInfoList.get(i).getClassId()+"班";
                int selectStudentCount;
                //我的学生
                Student student = new Student();
                student.setYear(classInfoList.get(i).getYear());
                student.setClassId(classInfoList.get(i).getClassId());
                selectStudentCount = studentDao.selectStudentCount(student);
                studentAllCount += selectStudentCount;
                oneClassStudentCounts[i] = selectStudentCount;
            }
            data.put("myClassCount",myClassCount);
            data.put("studentAllCount",studentAllCount);
            data.put("classInfos",classInfos);
            data.put("oneClassStudentCounts",oneClassStudentCounts);

            try{
                classInfo.setAdminId(null);
                classInfo.setSeriesId(classInfoList.get(0).getSeriesId());
                List<ClassInfo> classInfoList1 = classDao.selectClassInfo(classInfo);
                seriesClassCount = classInfoList1.size();
            }catch (Exception e){
                e.printStackTrace();
                seriesClassCount = 0;
            }finally {
                data.put("seriesClassCount",seriesClassCount);
            }
            remassge.setData(data);
        }catch (Exception e){
            e.printStackTrace();
        }
        return remassge;
    }
}
