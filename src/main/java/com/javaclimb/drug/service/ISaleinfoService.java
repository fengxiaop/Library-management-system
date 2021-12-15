package com.javaclimb.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.javaclimb.drug.entity.Saleinfo;

public interface ISaleinfoService extends IService<Saleinfo> {

    public IPage<Saleinfo> selectSaleinfoPage(int pageNum, int pageSize, String param);

    public int addSaleinfo(Saleinfo saleinfo);

    public int editSaleinfo(Saleinfo saleinfo);

    public Saleinfo querySaleinfoById(Integer id);

    public int delSaleinfoById(Integer id);

}
