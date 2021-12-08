package com.javaclimb.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.javaclimb.drug.entity.Owinfo;

import java.util.List;

/**
 * 药品出入库的service接口
 */
public interface IOwinfoService extends IService<Owinfo> {
    /**
     * 分页查询药品出入库数据
     * @param pageNum 第几页
     * @param pageSize 每页多少条数据
     * @param param 查询参数-药品出入库名称
     * @return
     */
    public IPage<Owinfo> selectOwinfoPage(int pageNum, int pageSize, String param);

    /**
     * 新增一条药品出入库信息
     * @param owinfo
     */
    public int addOwinfo(Owinfo owinfo);

    /**
     * 修改一条药品出入库信息
     * @param owinfo
     */
    public int editOwinfo(Owinfo owinfo);

    /**
     * 根据主键id查询一个药品出入库对象
     * @param id
     * @return
     */
    public Owinfo queryOwinfoById(Integer id);

    /**
     * 根据主键id删除一个药品出入库对象
     * @param id
     * @return
     */
    public int delOwinfoById(Integer id);

}
