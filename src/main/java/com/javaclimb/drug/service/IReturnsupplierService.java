package com.javaclimb.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.javaclimb.drug.entity.Returnsupplier;

/**
 * 退货给供应商的service接口
 */
public interface IReturnsupplierService extends IService<Returnsupplier> {
    /**
     * 分页查询退货给供应商数据
     * @param pageNum 第几页
     * @param pageSize 每页多少条数据
     * @param param 查询参数-退货给供应商名称
     * @return
     */
    public IPage<Returnsupplier> selectReturnsupplierPage(int pageNum, int pageSize, String param);

    /**
     * 新增一条退货给供应商信息
     * @param returnsupplier
     */
    public int addReturnsupplier(Returnsupplier returnsupplier);

    /**
     * 修改一条退货给供应商信息
     * @param returnsupplier
     */
    public int editReturnsupplier(Returnsupplier returnsupplier);

    /**
     * 根据主键id查询一个退货给供应商对象
     * @param id
     * @return
     */
    public Returnsupplier queryReturnsupplierById(Integer id);

    /**
     * 根据主键id删除一个退货给供应商对象
     * @param id
     * @return
     */
    public int delReturnsupplierById(Integer id);

}
