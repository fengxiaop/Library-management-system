package com.javaclimb.book.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.javaclimb.book.entity.Bookinfo;

import java.util.List;


public interface IbookinfoService extends IService<Bookinfo> {

    public IPage<Bookinfo> selectbookinfoPage(int pageNum, int pageSize, String param);


    public int addbookinfo(Bookinfo bookinfo);


    public int editbookinfo(Bookinfo bookinfo);

    public Bookinfo querybookinfoById(Integer id);

    public int delbookinfoById(Integer id);

    public List<Bookinfo> querybookinfoList();
}
