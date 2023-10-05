package com.javaclimb.book.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.javaclimb.book.entity.Druginfo;

import java.util.List;


public interface IDruginfoService extends IService<Druginfo> {

    public IPage<Druginfo> selectDruginfoPage(int pageNum, int pageSize, String param);


    public int addDruginfo(Druginfo druginfo);


    public int editDruginfo(Druginfo druginfo);

    public Druginfo queryDruginfoById(Integer id);

    public int delDruginfoById(Integer id);

    public List<Druginfo> queryDruginfoList();
}
