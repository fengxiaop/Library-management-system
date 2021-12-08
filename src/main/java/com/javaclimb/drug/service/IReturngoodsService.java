package com.javaclimb.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.javaclimb.drug.entity.Returngoods;

/**
 * 收到退货的service接口
 */
public interface IReturngoodsService extends IService<Returngoods> {
    /**
     * 分页查询收到退货数据
     * @param pageNum 第几页
     * @param pageSize 每页多少条数据
     * @param param 查询参数-收到退货名称
     * @return
     */
    public IPage<Returngoods> selectReturngoodsPage(int pageNum, int pageSize, String param);

    /**
     * 新增一条收到退货信息
     * @param returngoods
     */
    public int addReturngoods(Returngoods returngoods);

    /**
     * 修改一条收到退货信息
     * @param returngoods
     */
    public int editReturngoods(Returngoods returngoods);

    /**
     * 根据主键id查询一个收到退货对象
     * @param id
     * @return
     */
    public Returngoods queryReturngoodsById(Integer id);

    /**
     * 根据主键id删除一个收到退货对象
     * @param id
     * @return
     */
    public int delReturngoodsById(Integer id);

}
