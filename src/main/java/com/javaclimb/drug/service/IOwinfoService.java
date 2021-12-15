package com.javaclimb.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.javaclimb.drug.entity.Owinfo;


public interface IOwinfoService extends IService<Owinfo> {

    public IPage<Owinfo> selectOwinfoPage(int pageNum, int pageSize, String param);

    public int addOwinfo(Owinfo owinfo);

    public int editOwinfo(Owinfo owinfo);

    public Owinfo queryOwinfoById(Integer id);

    public int delOwinfoById(Integer id);

}
